import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Point;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private MiddleGround middleGround;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, MiddleGround middleGround) {
        this.middleGround = middleGround;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < Math.min(middleGround.workShopData.getworkShopImages().size(), middleGround.workShopData.getWorkShopImagesPoints().size()); i++) {
            BufferedImage workShopImage = middleGround.workShopData.getworkShopImages().get(i);
            Point workShopPoint = middleGround.workShopData.getWorkShopImagesPoints().get(i);
            g.drawImage(workShopImage, workShopPoint.x, workShopPoint.y, null);
        }
        for (int i = 0; i < Math.min(middleGround.carData.getCarImages().size(), middleGround.carData.getCarImagesPoints().size()); i++) {
            BufferedImage carImage = middleGround.carData.getCarImages().get(i);
            Point carPoint = middleGround.carData.getCarImagesPoints().get(i);
            g.drawImage(carImage, carPoint.x, carPoint.y, null);
        }
    }
}
