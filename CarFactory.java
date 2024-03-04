import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class CarFactory {
    public void createCar(String carType, CarRelatedData<BufferedImage, Point, Car> CRD) {
        Car car;
        switch (carType.toLowerCase()) {
            case "volvo240":
                try {
                    car = new Volvo240();
                    BufferedImage volvoImage = ImageIO.read(Objects.requireNonNull(CarFactory.class.getResourceAsStream("/pics/Volvo240.jpg")));
                    Point volvoImagePoint = new Point(0, 0);
                    // Add the created car to CarRelatedData
                    CRD.add(volvoImage, volvoImagePoint, car);
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the exception appropriately
                }
                break;
            case "saab95":
                try {
                    car = new Saab95();
                    BufferedImage saabImage = ImageIO.read(Objects.requireNonNull(CarFactory.class.getResourceAsStream("/pics/Saab95.jpg")));
                    Point saabImagePoint = new Point(0, 0);
                    // Add the created car to CarRelatedData
                    CRD.add(saabImage, saabImagePoint, car);
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the exception appropriately
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid car type: " + carType);
        }
    }

    public void createScania(CarRelatedData<BufferedImage, Point, Car> CRD) {
        Scania scania = new Scania();
        try {
            BufferedImage truckImage = ImageIO.read(Objects.requireNonNull(CarFactory.class.getResourceAsStream("/pics/Scania.jpg")));
            Point truckImagePoint = new Point(0, 0);
            // Add the created car to CarRelatedData
            CRD.add(truckImage, truckImagePoint, scania);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
