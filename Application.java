public class Application {

    public static void main(String[] args) {


        // Instance of this class
        CarController cc = new CarController();

        MiddleGround.carFactory.createCar("Volvo240", MiddleGround.carData);
        MiddleGround.carFactory.createCar("Saab95", MiddleGround.carData);
        MiddleGround.carFactory.createCar("Volvo240", MiddleGround.carData);
        MiddleGround.carFactory.createCar("Saab95", MiddleGround.carData);
        MiddleGround.carFactory.createScania(MiddleGround.carData);

        MiddleGround.workShopFactory.volvo240WorkShop(5, "hi", MiddleGround.workShopData);
        //workShopFactory.saab95WorkShop(5, "hi", MiddleGround.workShopData);

        for(int i = 0;i < MiddleGround.carData.getCarsList().size(); i++){
            MiddleGround.carData.getCarsList().get(i).getPoint().setLocation(i*150, 0);

        }
        for(int i = 0;i < MiddleGround.workShopData.getWorkshopsList().size(); i++){
            MiddleGround.workShopData.getWorkshopsList().get(i).getPoint().setLocation(i*150, 300 + i*10);
            MiddleGround.workShopData.getWorkShopImagesPoints().get(i).setLocation(i*150, 300 + i*10);

        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", MiddleGround.carData);

        // Start the timer
        cc.timer.start();
    }
}
