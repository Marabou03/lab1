import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Loading<T extends Car>{
    private Point point;
    protected Class<T> carType;

    protected List<T> currentCars; // Use List<T> instead of List<? super T>
    private List<Car> listOfCar = new ArrayList<>();

    public Loading() {
        //this.carType =carType;
        //this.currentCars = currentCars;
    }

    public void loadCar(Truck truck, Car car) {
        double distance = calculateDistance(car.getPoint(), truck.getPoint());
        if (distance < 5) {
            truck.getLoadedCars().add(car);
            car.setPoint(truck.getPoint());
        } else {
            throw new IllegalArgumentException("Car is too far away");
        }
    }

    public void loadCar2(Workshop<T> workshop, T car) {
        if (carType.isInstance(car)) {
            double distance = calculateDistance(car.getPoint(), workshop.getPoint());
            if (distance < 5) {
                currentCars.add(car);
                car.setPoint(workshop.point);
            } else {
                throw new IllegalArgumentException("Car is too far away");
            }
        } else {
            throw new IllegalArgumentException("Incompatible car type");
        }
    }

    //@Override
    public void unloadCar(Truck truck) {
        if (!truck.getRampUp() && !truck.getLoadedCars().isEmpty()) {
            Car lastCar = truck.getLoadedCars().getLast();
            Point carPoint = new Point(lastCar.point.getX(), lastCar.point.getY());
            carPoint.setLocation(truck.getPoint().getX() + 5, truck.getPoint().getY() + 5);
            lastCar.point = carPoint;
            truck.getLoadedCars().removeLast();
        } else {
            throw new IllegalArgumentException("Truck is empty or the ramp is up");
        }
    }

    protected List<Car> getLoadedCar() {
        // Return a list of type T instead of Car
        return new ArrayList<>(listOfCar);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    protected double calculateDistance(Point point1, Point point2) {
        double posX = Math.pow(point1.getX() - point2.getX(), 2);
        double posY = Math.pow(point1.getY() - point2.getY(), 2);
        return Math.sqrt(posX + posY);
    }
}
