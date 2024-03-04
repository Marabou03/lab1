public class Application {

    public static void main(String[] args) {


        MiddleGround middleGround = new MiddleGround();
        CarController cc = new CarController(middleGround);
        // Access carFactory and workShopFactory through the instance
        middleGround.carFactory.createCar("Volvo240", middleGround.carData);
        middleGround.carFactory.createCar("Saab95", middleGround.carData);
        middleGround.carFactory.createCar("Volvo240", middleGround.carData);
        middleGround.carFactory.createCar("Saab95", middleGround.carData);
        middleGround.carFactory.createScania(middleGround.carData);

        middleGround.workShopFactory.volvo240WorkShop(5, "hi", middleGround.workShopData);


        for(int i = 0;i < middleGround.carData.getCarsList().size(); i++){
            middleGround.carData.getCarsList().get(i).getPoint().setLocation(i*150, 0);
        }

        for(int i = 0;i < middleGround.workShopData.getWorkshopsList().size(); i++){
            middleGround.workShopData.getWorkshopsList().get(i).getPoint().setLocation(i*150, 300 + i*10);
            middleGround.workShopData.getWorkShopImagesPoints().get(i).setLocation(i*150, 300 + i*10);
        }



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", middleGround.carData, middleGround);

        // Start the timer
        cc.timer.start();
    }
}
