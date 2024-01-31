import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Workshop <T extends Car> {
    private final Truck truck;
    protected int maxCars;
    protected List<T> currentCars;
    protected String workShopName;
    protected Class<T> carType;
    private int x,y;
    private Point point;

    public Point getPoint() {
        return point;
    }


    protected Workshop (int maxCars, String workShopName, Class<T> carType) {
        this.truck = new Truck(2, 20, Color.cyan, "scandic", 2);
        this.maxCars = maxCars;
        this.currentCars = new ArrayList<>(maxCars);
        this.workShopName = workShopName;
        this.carType = carType;
        this.point = new Point(5, 5);
    }


    public void typeCarAllowed(T car){
        if (carType.isInstance(car)){
            double distance = Truck.calculateDistance(car.point, this.point);
            if (distance < 5){
                currentCars.add(car);
                car.point = this.point;
            } else{
                throw new IllegalArgumentException("Car is too far away");
            }
        }
    }



    public void theCarYouGet(){
        if (!currentCars.isEmpty()) {
            T fstcar = currentCars.getFirst();
            Point carPoint = new Point(fstcar.point.getX(), fstcar.point.getY());// new Point
            carPoint.setLocation(point.getX() + 5,point.getY() + 5);
            fstcar.point = carPoint;
            currentCars.removeFirst();
        }
    }

}
