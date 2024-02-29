import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Point;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);



    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        for (int i = 0; i < Math.min(MiddleGround.workShopData.getworkShopImages().size(), MiddleGround.workShopData.getWorkShopImagesPoints().size()); i++) {
            BufferedImage workShopImage = MiddleGround.workShopData.getworkShopImages().get(i);
            Point workShopPoint = MiddleGround.workShopData.getWorkShopImagesPoints().get(i);
            g.drawImage(workShopImage, workShopPoint.x, workShopPoint.y, null);
        }
        for (int i = 0; i < Math.min(MiddleGround.carData.getCarImages().size(), MiddleGround.carData.getCarImagesPoints().size()); i++) {
            BufferedImage carImage = MiddleGround.carData.getCarImages().get(i);
            Point carPoint = MiddleGround.carData.getCarImagesPoints().get(i);
            g.drawImage(carImage, carPoint.x, carPoint.y, null);
        }
    }
}