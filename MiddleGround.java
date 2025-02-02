import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MiddleGround {
    protected CarFactory carFactory;
    protected WorkShopFactory workShopFactory;
    protected WorkShopRelatedData<BufferedImage, Point, Workshop<Car>, Car> workShopData;
    protected CarRelatedData<BufferedImage, Point, Car> carData;
    public MiddleGround(){
        this.carFactory = new CarFactory();
        this.workShopFactory = new WorkShopFactory();
        this.workShopData = new WorkShopRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        this.carData = new CarRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

}
