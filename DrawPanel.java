import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Point;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    ArrayList<BufferedImage> carImages = new ArrayList<>();
    ArrayList<Point> carPoints = new ArrayList<>();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(0,300);


    // Method to move Volvo cars to the workshop
    public void moveVolvoToWorkshop(int i) {
        carImages.remove(i);
        carPoints.remove(i);
    }



    void moveit(ArrayList<Car> cars) {
        for(int i = 0; i < cars.size(); i++){
            int p = (int) cars.get(i).getPoint().getX();
            int q = (int) cars.get(i).getPoint().getY();
            Point k = new Point(p,q);
            carPoints.set(i,k);
        }


        repaint(); // Refresh the panel to reflect the changes
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        try {// Load car images
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));


            volvoWorkshopImage  = (ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Set initial positions for cars
        carPoints.add(new Point(0, 0)); // Volvo
        carPoints.add(new Point(0, 200)); // Saab
        carPoints.add(new Point(0, 400)); // Scania

        //Point p = new Point(volvoWorkshopPoint.getX(),volvoWorkshopPoint.getX());
        //CarController.volvoWorkshop.getPoint() = p;

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        for (int i = 0; i < Math.min(carImages.size(), carPoints.size()); i++) {
            BufferedImage carImage = carImages.get(i);
            Point carPoint = carPoints.get(i);
            g.drawImage(carImage, carPoint.x, carPoint.y, null);
        }
    }

}