import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



/**
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and then updating the view.
**/



public class CarController {

    private static CarFactory carFactory;

    /*public CarController() {
        this.carFactory = new CarFactory();
        this.workShopFactory = new WorkShopFactory();*/
/*        this.workShopData = new WorkShopRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        this.carData = new CarRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        // Initialize other member fields as needed...
    }*/

    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    //static ArrayList<Car> cars = new ArrayList<>();
    protected static Workshop<Volvo240> volvoWorkshop = new Workshop<>(10, "volvoWorkshop", Volvo240.class);

    //private Loading loader;
    //methods:


    public static void main(String[] args) {
        MiddleGround.carFactory = new CarFactory();

        // Initialize car data
        MiddleGround.carData = new CarRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());


        // Instance of this class
        CarController cc = new CarController();

        carFactory.createCar("Volvo240", MiddleGround.carData);
        carFactory.createCar("Saab95", MiddleGround.carData);
        carFactory.createCar("Volvo240", MiddleGround.carData);


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", MiddleGround.carData);

        // Start the timer
        cc.timer.start();
    }

/* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    **/

    private class TimerListener implements ActionListener {

        protected double calculateDistance(Point point1, Point point2) {
            double posX = Math.pow(point1.getX() - point2.getX(), 2);
            double posY = Math.pow(point1.getY() - point2.getY(), 2);
            return Math.sqrt(posX + posY);
        }
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < MiddleGround.carData.getCarsList().size(); i++){
                Car k = MiddleGround.carData.getCarsList().get(i);
                Point p = new Point((int)volvoWorkshop.getPoint().getX(), (int) volvoWorkshop.getPoint().getY());
                Point o = new Point((int)k.getPoint().getX(), (int) k.getPoint().getY());

                if (k instanceof Volvo240 volvo && calculateDistance(o, p) < 10) {
                    volvoWorkshop.typeCarAllowed(volvo);
                    frame.drawPanel.moveVolvoToWorkshop(i);
                    MiddleGround.carData.getCarsList().remove(i);

                }


                k.move();
                if (k.getPoint().getY() > frame.getHeight() - 300) {
                    k.direction = Car.Direction.SOUTH;
                } else if (k.getPoint().getY() < 0) {
                    k.direction = Car.Direction.NORTH;
                }
                if (k.getPoint().getX() > frame.getWidth() - 300) {
                    k.direction = Car.Direction.WEST;
                } else if (k.getPoint().getX() < 0) {
                    k.direction = Car.Direction.EAST;
                }}
            frame.drawPanel.moveit(MiddleGround.carData.getCarsList());
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : MiddleGround.carData.getCarsList()) {
            car.gas(gas);
            // Add additional conditions for other types of carData.getCarsList() if needed
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : MiddleGround.carData.getCarsList()) {
            car.brake(brake);
        }
    }
    void startEngine() {
        for (Car car : MiddleGround.carData.getCarsList()) {
            car.startEngine();
        }
    }
    void stopEngine() {
        for (Car car : MiddleGround.carData.getCarsList()) {
            car.stopEngine();
        }
    }
    void setTurboOn() {
        for (Car car : MiddleGround.carData.getCarsList()) {
            if (car instanceof Saab95 saab) { // Check if the car is a Saab95 and cast car to Saab95
                saab.setTurboOn(); // Set turbo on for Saab95
            }
        }
    }

    void setTurboOff() {
        for (Car car : MiddleGround.carData.getCarsList()) {
            if (car instanceof Saab95 saab) { // Check if the car is a Saab95
                saab.setTurboOff(); // Set turbo off for Saab95
            }
        }
    }
    void raiseFlak(int amount) {
        double raise = ((double) amount) / 100;
        for (Car car : MiddleGround.carData.getCarsList()) {
            if (car instanceof Scania scania) {
                scania.raiseFlak(raise);
            }
        }
    }
    void lowerFlak(int amount) {
        double lower = ((double) amount) / 100;
        for (Car car : MiddleGround.carData.getCarsList()) {
            if (car instanceof Scania scania) {
                scania.lowerFlak(lower);
            }
        }
    }
}
