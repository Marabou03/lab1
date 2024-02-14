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
