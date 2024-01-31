import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


public  class Truck extends Car {
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

    public static double calculateDistance(Point point1, Point point2) {
        double posX = Math.pow(point1.getX() - point2.getX(), 2);
        double posY = Math.pow(point1.getY() - point2.getY(), 2);
        return Math.sqrt(posX + posY);
    }
    public void loadCar(Car car) {// car be in a certain range like radius=10, can't be another truck //(car != Truck)
        if(!rampUp && (loadedCars.size() < maxCars) && (car != this)){
            double distance = calculateDistance(car.getPoint(), this.getPoint());
            if (distance < 5){
                loadedCars.add(car);
                car.point = this.getPoint();
            } else{
                throw new IllegalArgumentException("Car is too far away");
            }
        }else if (car.equals(this)) {
            throw new IllegalArgumentException("can't load a truck in a truck");
        } else {
            throw new IllegalArgumentException("Either the truck is full or the ramp is up");
        }
    }

    public void unloadCar() {
        if(!rampUp && !loadedCars.isEmpty() ){
            Car lastCar = loadedCars.getLast();
            Point carPoint = new Point(lastCar.point.getX(), lastCar.point.getY());// new Point
            carPoint.setLocation(point.getX() + 5,point.getY() + 5);
            lastCar.point = carPoint;
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
}
