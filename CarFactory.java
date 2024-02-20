import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class CarFactory {
    private static CarRelatedData<BufferedImage, Point, Car> carData;

    // Initialize CarRelatedData
    public static void initializeCarData() {
        carData = new CarRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public void createCar(String carType) {
        Car car;
        switch (carType.toLowerCase()) {
            case "volvo240":
                try {
                    car = new Volvo240();
                    BufferedImage truckImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/Volvo240.jpg"));
                    Point truckImagePoint = new Point(0, 0);
                    // Add the created car to CarRelatedData
                    carData.add(truckImage, truckImagePoint, car);
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the exception appropriately
                }
                break;
            case "saab95":
                try {
                    car = new Saab95();
                    BufferedImage truckImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/Saab95.jpg"));
                    Point truckImagePoint = new Point(0, 0);
                    // Add the created car to CarRelatedData
                    carData.add(truckImage, truckImagePoint, car);
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

    public void createScania() {
        Scania scania = new Scania();
        try {
            BufferedImage truckImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/Scania.jpg"));
            Point truckImagePoint = new Point(0, 0);
            // Add the created car to CarRelatedData
            carData.add(truckImage, truckImagePoint, scania);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
