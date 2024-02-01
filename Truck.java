import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


public class Truck extends Car {
    private final int maxCars; //Max amount of cars possible to carry.
    private final List<Car> loadedCars; // the amount of cars being carried.
    private boolean rampUp; // Initial state is ramp up/closed.
    private final Loading loader;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int maxCars, String vehicleType) {
        super(nrDoors, enginePower, color, modelName, vehicleType);
        this.vehicleType = vehicleType;
        this.maxCars = maxCars;
        this.loadedCars = new ArrayList<>(maxCars);
        this.rampUp = true;
        this.loader = new Loading();
    }
    protected boolean getRampUp(){
        return rampUp;

    }

    protected void lowerRamp() {
        if (currentSpeed == 0) {
            rampUp = false;
        }
    }

    protected void raiseRamp() {
        rampUp = true;
    }

    protected void loadCar(Car car) {
        loader.loadCar(this, car);

    }

    protected void unloadCar() {
        loader.unloadCar(this);
    }

    protected List<Car> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }

    @Override
    protected void startEngine() {
        if (rampUp) {
            super.startEngine();
        }
    }
    @Override
    public void move() {
        super.move();
        if(!loadedCars.isEmpty()){
            for (Car car : loadedCars){
                car.point = this.getPoint();
            }
        }
    }

    public int getMaxCars() {
        return maxCars;
    }
}
