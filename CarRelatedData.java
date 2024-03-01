import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CarRelatedData<T1 extends BufferedImage, T2 extends Point, T3 extends Car> {
    private final ArrayList<T1> carImages;
    private final ArrayList<T2> carImagesPoints;
    private final ArrayList<T3> carsList;
    private final ArrayList<CarObserver> observers; // Moved to class level

    public CarRelatedData(ArrayList<T1> carImages, ArrayList<T2> carImagesPoints, ArrayList<T3> carsList) {
        this.carImages = carImages;
        this.carImagesPoints = carImagesPoints;
        this.carsList = carsList;
        this.observers = new ArrayList<>(); // Initialize here
    }

    protected ArrayList<T1> getCarImages() {
        return carImages;
    }

    protected ArrayList<T2> getCarImagesPoints() {
        return carImagesPoints;
    }

    protected ArrayList<T3> getCarsList() {
        return carsList;
    }

    // Method to add observer
    public void addObserver(CarObserver observer) {
        observers.add(observer);
    }

    // Method to remove observer
    public void removeObserver(CarObserver observer) {
        observers.remove(observer);
    }

    // Method to notify observers
    public void notifyObservers(T3 car) {
        for (CarObserver observer : observers) {
            observer.update(car);
        }
    }

    // Method to add car elements
    public void add(T1 element1, T2 element2, T3 element3) {
        carImages.add(element1);
        carImagesPoints.add(element2);
        carsList.add(element3);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car Image Names:\n");
        for (T1 imageName : carImages) {
            sb.append(imageName).append("\n");
        }
        return sb.toString();
    }
}