import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Workshop {
    private final Truck t;
    protected int maxCars;
    protected List<Car> currentCars;
    protected String workShopName;
    protected Car carType;
    private int x,y;
    private Point point;


    protected Workshop (int maxCars, String workShopName, Car carType) {
        this.t = new Truck(2, 20, Color.cyan, "scandic", 2);
        this.maxCars = maxCars;
        this.currentCars = new ArrayList<>(maxCars);
        this.workShopName = workShopName;
        this.carType = carType;
        this.point = new Point(x, y);
    }


    public void typeCarAllowed(Car car){
        if (car.equals(carType)){
            double distance = Truck.calculateDistance(car.point, this.point);
            if (distance < 5){
                currentCars.add(car);
                car.point = this.point;
            } else{
                throw new IllegalArgumentException("Car is too far away");
            }
        }else {
            throw new IllegalArgumentException("Either the truck is full or the ramp is up");
        }
    }



    public void theCarYouGet(){



    }
}
