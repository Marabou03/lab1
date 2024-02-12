import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Point;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    private ArrayList<BufferedImage> carImages = new ArrayList<>();
    private ArrayList<Point> carPoints = new ArrayList<>();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(int x, int y) {
        for (int i = 0; i < carPoints.size(); i++) {
            Point point = carPoints.get(i);
            point.x = x + i * 150; // Adjust the x-coordinate based on the index
            point.y = y;
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
        carPoints.add(new Point(200, 0)); // Saab
        carPoints.add(new Point(400, 0)); // Scania

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
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
