import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;


/**
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and then updating the view.
**/



public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Car> cars = new ArrayList<>();
    protected static Workshop<Volvo240> volvoWorkshop = new Workshop<>(10, "volvoWorkshop", Volvo240.class);

    //private Loading loader;
    //methods:


    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        volvoWorkshop.getPoint().setLocation(0, 300);

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());


        for (int i = 0; i < cars.size(); i++ ){
            cars.get(i).getPoint().setY(i*100);
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

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
            for(int i = 0; i < cars.size(); i++){
                Point p = new Point(volvoWorkshop.getPoint().getX(), volvoWorkshop.getPoint().getY());
                if (cars.get(i) instanceof Volvo240 volvo && calculateDistance(volvo.getPoint(), p) < 10) {
                    volvoWorkshop.typeCarAllowed(volvo);
                    frame.drawPanel.moveVolvoToWorkshop2(i);
                    cars.remove(i);

                }
                cars.get(i).move();
                if (cars.get(i).getPoint().getY() > frame.getHeight() - 300) {
                    cars.get(i).direction = Car.Direction.SOUTH;
                } else if (cars.get(i).getPoint().getY() < 0) {
                    cars.get(i).direction = Car.Direction.NORTH;
                }
                if (cars.get(i).getPoint().getX() > frame.getWidth() - 300) {
                    cars.get(i).direction = Car.Direction.WEST;
                } else if (cars.get(i).getPoint().getX() < 0) {
                    cars.get(i).direction = Car.Direction.EAST;
                }}
            frame.drawPanel.moveit(cars);
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
            // Add additional conditions for other types of cars if needed
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }
    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }
    void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab) { // Check if the car is a Saab95 and cast car to Saab95
                saab.setTurboOn(); // Set turbo on for Saab95
            }
        }
    }

    void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab) { // Check if the car is a Saab95
                saab.setTurboOff(); // Set turbo off for Saab95
            }
        }
    }
    void raiseFlak(int amount) {
        for (Car car : cars) {
            if (car instanceof Scania scania) { // Check if the car is a Saab95
                scania.raiseFlak(amount); // Set turbo off for Saab95
            }
        }
    }
    void lowerFlak(int amount) {
        for (Car car : cars) {
            if (car instanceof Scania scania) { // Check if the car is a Saab95
                scania.lowerFlak(amount); // Set turbo off for Saab95
            }
        }
    }
}
