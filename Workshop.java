import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Workshop <T extends Car> {
    private final Truck truck;
    private final Volvo240 carV;

    protected int maxCars;
    protected List<T> currentCars;
    protected String workShopName;
    protected Class<T> carType;
    protected static Point point;


    protected Workshop (int maxCars, String workShopName, Class<T> carType) {
        this.truck = new Truck(2, 20, Color.cyan, "scandic", 2, "truck");
        this.carV = new Volvo240();
        this.maxCars = maxCars;
        this.currentCars = new ArrayList<>(maxCars);
        this.workShopName = workShopName;
        this.carType = carType;
        this.point = new Point(5, 5);
    }
    public Point getPoint() {
        return point;
    }


    protected void typeCarAllowed(T car){
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



    protected void theCarYouGet(){
        if (!currentCars.isEmpty()) {
            T fstCar = currentCars.getFirst();
            Point carPoint = new Point(fstCar.point.getX(), fstCar.point.getY());// new Point
            carPoint.setLocation(point.getX() + 5,point.getY() + 5);
            fstCar.point = carPoint;
            currentCars.removeFirst();
        }
    }

}
