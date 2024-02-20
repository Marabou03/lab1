import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class WorkShopfactory {
    private static WorkShopRelatedData<BufferedImage, Point, Workshop<?>> workShopData;
    public WorkShopfactory(){
    this.workShopData = new WorkShopRelatedData<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }
    protected void volvo240WorkShop(int maxCars, String name){
        try{
            Workshop<Volvo240> volvoWorkShop = new Workshop<>(maxCars, name, Volvo240.class);
            BufferedImage workShopImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/VolvoBrand.jpg"));
            Point workShopImagePoint = new Point(0, 0);
            // Add the created car to CarRelatedData
            workShopData.add(workShopImage, workShopImagePoint, volvoWorkShop);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /*protected Workshop<Saab95> saab95oWorkShop(int maxCars, String name){
        return new Workshop<>(maxCars, name, Saab95.class);
    }
    protected Workshop<Scania> scaniaWorkShop(int maxCars, String name){
        return new Workshop<>(maxCars, name, Scania.class);
    }
    protected Workshop<Truck> volvoWorkShop(int maxCars, String name){
        return new Workshop<>(maxCars, name, Truck.class);
    }*/
}
