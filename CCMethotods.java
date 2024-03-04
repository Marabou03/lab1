import javax.swing.*;

public class CCMethotods {
    CarView frame;
    MiddleGround middleGround;

    // Constructor
    public CCMethotods(MiddleGround middleGround) {
        this.middleGround = middleGround;
    }

    // Calls the gas method for each car once
    void gas(Car car, int amount) {
        double gas = ((double) amount) / 100;
        car.gas(gas);
    }

    void brake(Car car, int amount) {
        double brake = ((double) amount) / 100;
        car.brake(brake);
    }

    void startEngine(Car car) {
        car.startEngine();
    }

    void stopEngine(Car car) {
        car.stopEngine();
    }

    void setTurboOn(Saab95 saab) {
        saab.setTurboOn(); // Set turbo on for Saab95
    }

    void setTurboOff(Saab95 saab) {
        saab.setTurboOff(); // Set turbo off for Saab95
    }

    void raiseFlak(Scania scania, int amount) {
        double raise = ((double) amount) / 100;
        scania.raiseFlak(raise);
    }

    void lowerFlak(Scania scania, int amount) {
        double lower = ((double) amount) / 100;
        scania.lowerFlak(lower);
    }

    public void addCar(String carType) {
        if (middleGround.carData.getCarsList().size() < 10) { // Check if there is space for a new car
            switch (carType.toLowerCase()) {
                case "volvo240":
                    middleGround.carFactory.createCar("Volvo240", middleGround.carData);
                    break;
                case "saab95":
                    middleGround.carFactory.createCar("Saab95", middleGround.carData);
                    break;
                case "scania":
                    middleGround.carFactory.createScania(middleGround.carData);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid car type: " + carType);
            }
        } else {
            // Inform the user that there is no space for more cars
            JOptionPane.showMessageDialog(frame, "Maximum number of cars reached. Cannot add more cars.");
        }
    }
}
