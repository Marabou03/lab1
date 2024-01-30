import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


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
    public boolean getRampUp(){
        return rampUp;

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
            Point truckPos = this.getPoint(); // needs to be fixed
            double posX = Math.pow(carPos.getX()-truckPos.getX(), 2);
            double posY = Math.pow(carPos.getY()-truckPos.getY(), 2);
            double distance = Math.sqrt(posX+posY);
            if (distance < 5){
                loadedCars.add(car);
                car.point = this.getPoint();
            } else{
                throw new IllegalArgumentException("Car is too far away");
            }
        }else {
            throw new IllegalArgumentException("Either the truck is full or the ramp is up");
        }
    }

    public void unloadCar() {
        if(!rampUp && !loadedCars.isEmpty()){

            Car lastCar = loadedCars.getLast();
            lastCar.point.setLocation(this.getPoint().getX() + 10, this.getPoint().getY() + 10);
            loadedCars.removeLast();

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
    @Override
    public void move() {
        switch (direction) {
            case NORTH:
                point.setLocation(point.getX(), point.getY() + this.getCurrentSpeed());
                break;
            case EAST:
                point.setLocation(point.getX() + this.getCurrentSpeed(), point.getY());
                break;
            case SOUTH:
                point.setLocation(point.getX(), point.getY() - this.getCurrentSpeed());
                break;
            case WEST:
                point.setLocation(point.getX() - this.getCurrentSpeed(), point.getY());
                break;
        }
        if(!loadedCars.isEmpty()){
            for (Car car : loadedCars){
                car.point = this.getPoint();
            }
        }
    }
}
