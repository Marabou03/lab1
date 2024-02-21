import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Point;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{



    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(0,300);


    // Method to move Volvo cars to the workshop
    public void moveVolvoToWorkshop(int i) {
        MiddleGround.carData.getCarImages().remove(i);
        MiddleGround.carData.getCarImagesPoints().remove(i);
        System.out.println(MiddleGround.carData.getCarImagesPoints().toString());
        System.out.println(CarController.volvoWorkshop.getPoint().toString());

    }

    void moveit(ArrayList<Car> cars) {
        for(int i = 0; i < cars.size(); i++){
            int p = (int) cars.get(i).getPoint().getX();
            int q = (int) cars.get(i).getPoint().getY();
            Point k = new Point(p,q);
            MiddleGround.carData.getCarImagesPoints().set(i,k);
            //System.out.println(MiddleGround.carData.getCarImagesPoints());
            System.out.println(CarController.volvoWorkshop.getPoint().toString());
        }


        repaint(); // Refresh the panel to reflect the changes
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        try {
            volvoWorkshopImage  = (ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        double x1 =volvoWorkshopPoint.getX();
        double y1 =volvoWorkshopPoint.getY();
        CarController.volvoWorkshop.getPoint().setLocation(x1,y1);

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        for (int i = 0; i < Math.min(MiddleGround.carData.getCarImages().size(), MiddleGround.carData.getCarImagesPoints().size()); i++) {
            BufferedImage carImage = MiddleGround.carData.getCarImages().get(i);
            Point carPoint = MiddleGround.carData.getCarImagesPoints().get(i);
            g.drawImage(carImage, carPoint.x, carPoint.y, null);
        }
    }

}