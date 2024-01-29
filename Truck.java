import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Truck extends Car {
    private final int maxCars; //Max amount of cars possible to carry.
    private final List<Car> loadedCars; // the amount of cars being carried.
    private boolean rampUp; // Initial state is ramp up/closed.
    public Truck(int nrDoors, double enginePower, Color color, String modelName, int maxCars) {
        super(nrDoors, enginePower, color, modelName);
        this.maxCars = maxCars;
        this.loadedCars = new ArrayList<>(maxCars);
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

    public void loadCar(Car car) {// car be in a certain range like radius=10, can't be another truck //(car != Truck)
        if(!rampUp && (loadedCars.size() < maxCars)){
            loadedCars.add(car);
            car.setLocation(getX, getY);
        }
    }

    public void unloadCar() {
        if(!rampUp && (loadedCars.size() > maxCars)){
            int i = loadedCars.size() - 1;

        }
    }

    public List<Car> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }

    @Override
    protected void startEngine() {
        if (rampUp == true) {
            super.startEngine();
        }
    }
}
