import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MiddleGround {
    protected static CarFactory carFactory;
    protected static WorkShopFactory workShopFactory;
    protected static WorkShopRelatedData<BufferedImage, Point, Workshop<?>> workShopData;
    protected static CarRelatedData<BufferedImage, Point, Car> carData;
    public MiddleGround(){
        this.carFactory = new CarFactory();
        this.workShopFactory = new WorkShopFactory();
        this.workShopData = new WorkShopRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        this.carData = new CarRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

}
