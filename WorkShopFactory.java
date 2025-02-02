import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class WorkShopFactory {

    public WorkShopFactory(){

    }
    protected void volvo240WorkShop(int maxCars, String name, WorkShopRelatedData WRD){
        try{
            Workshop<Volvo240> volvoWorkShop = new Workshop<>(maxCars, name, Volvo240.class);
            BufferedImage workShopImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/VolvoBrand.jpg"));
            Point workShopImagePoint = new Point(0, 0);
            // Add the created car to CarRelatedData
            WRD.add(workShopImage, workShopImagePoint, volvoWorkShop);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void saab95WorkShop(int maxCars, String name, WorkShopRelatedData WRD){
        try{
            Workshop<Saab95> volvoWorkShop = new Workshop<>(maxCars, name, Saab95.class);
            BufferedImage workShopImage = ImageIO.read(CarFactory.class.getResourceAsStream("/pics/SaabWorkShop.png"));
            Point workShopImagePoint = new Point(0, 0);
            // Add the created car to CarRelatedData
            WRD.add(workShopImage, workShopImagePoint, volvoWorkShop);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /*
    protected Workshop<Scania> scaniaWorkShop(int maxCars, String name){
        return new Workshop<>(maxCars, name, Scania.class);
    }
    protected Workshop<Truck> volvoWorkShop(int maxCars, String name){
        return new Workshop<>(maxCars, name, Truck.class);
    }*/
}
