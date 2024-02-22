import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class CarFactory {
    public void createCar(String carType, CarRelatedData CRD) {
        Car car;
        switch (carType.toLowerCase()) {
            case "volvo240":
                try {
                    car = new Volvo240();
                    BufferedImage volvoImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/Volvo240.jpg"));
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
                    BufferedImage saabImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/Saab95.jpg"));
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

    /*public static Truck createTruck(int nrDoors, double enginePower, Color color, String name, int maxCars, String vehicleType) {
        Truck truck = new Truck(nrDoors, enginePower, color, name, maxCars, vehicleType);
        BufferedImage TruckImage = pics.;
        carData.add(null, null, truck); // Add null for images and points
        return truck;
    }*/

    public void createScania(CarRelatedData CRD) {
        Scania scania = new Scania();
        try {
            BufferedImage truckImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/Scania.jpg"));
            Point truckImagePoint = new Point(0, 0);
            // Add the created car to CarRelatedData
            CRD.add(truckImage, truckImagePoint, scania);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
