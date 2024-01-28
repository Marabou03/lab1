import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public abstract class Truck extends Car {
    private final int maxCars;
    private final List<Car> loadedCars;
    private boolean rampUp;
    public Truck(int nrDoors, double enginePower, Color color, String modelName, int maxCars) {
        super(nrDoors, enginePower, color, modelName);
        this.maxCars = maxCars; //Max amount of cars
        this.loadedCars = new ArrayList<>(); // the amount of cars listed
        this.rampUp = true;  // Initial state is ramp up
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            rampUp = false;
        }
    }

    public void raiseRamp() {
        rampUp = true;
    }

    public void loadCar(Car car) {

    }

    public void unloadCar() {

    }

    public List<Car> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }
}
