import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public abstract class Truck extends Car {
    private final int maxCars; //Max amount of cars possible to carry.
    private final List<Car> loadedCars; // the amount of cars being carried.
    private boolean rampUp; // Initial state is ramp up/closed.
    public Truck(int nrDoors, double enginePower, Color color, String modelName, int maxCars) {
        super(nrDoors, enginePower, color, modelName);
        this.maxCars = maxCars;
        this.loadedCars = new ArrayList<>();
        this.rampUp = true;
    }

    public void lowerRamp() {
        if (currentSpeed == 0) {
            rampUp = false;
        }
    }

    public void raiseRamp() {
        rampUp = true;
    }

    public void loadCar(Car car) {// car be in a certain range like radius=10, can't be another truck
        if(!rampUp){

        }
    }

    public void unloadCar() {
        if(!rampUp){

        }
    }

    public List<Car> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }
}
