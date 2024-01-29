import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math.*;


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
            Point carPos = car.getPoint();
            Point truckPos = Truck.getPoint(); // not working properly
            double posX = Math.pow(carPos.getX()-truckPos.getX(), 2);
            double posY = Math.pow(carPos.getY()-truckPos.getY(), 2);
            double distance = Math.sqrt(posX+posY);
            if (distance < 5){
                loadedCars.add(car);
                car.getPoint().setLocation(getPoint().getX(), getPoint().getY()); // does it set the cordenates of the truck?
            } else{
                throw new IllegalArgumentException("Car is too far away");
            }
        }else {
            throw new IllegalArgumentException("Either the truck is full or the ramp is pp");
        }
    }

    public void unloadCar() {
        if(!rampUp && !loadedCars.isEmpty()){
            int i = loadedCars.size() - 1;
            Car lastCar = loadedCars.get(i);
            loadedCars.remove(i);
            lastCar.point.setLocation(point.getX() + 1,point.getY() + 1); // does it set the cordenates of the car to be next the truck?
        }else{
            throw new IllegalArgumentException("Truck is empty or the ramp is up");
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
