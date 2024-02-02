import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {
    private static Volvo240 volvo;
    private static Volvo240 volvo2;
    private static Volvo240 volvo3;
    private static Saab95 saab;
    private static Saab95 saab2;
    private static Scania scania;
    private static Truck truck;
    private static Truck truck2;
    private static Truck truck3;
    private static Truck truck4;
    private static Workshop<Volvo240> vShop;


    @BeforeAll
    public static void init() {
        volvo = new Volvo240();
        volvo2 = new Volvo240();
        volvo3 = new Volvo240();
        saab = new Saab95();
        saab2 = new Saab95();
        scania = new Scania();
        truck = new VolvoTruck();
        truck2 = new VolvoTruck();
        truck3 = new VolvoTruck();
        truck4 = new VolvoTruck();
        vShop = new Workshop<>(10, "Car Workshop", Volvo240.class);
    }

    @Test @Order(1)
    void move() {
        volvo.startEngine();
        volvo.move();
        assertEquals(0, volvo.point.getX());
        assertEquals(0.1, volvo.point.getY());
        volvo.turnLeft();
        volvo.move();
        assertEquals((-0.1), volvo.point.getX());
        volvo.turnLeft();
        volvo.move();
        assertEquals(0, volvo.point.getY());
        volvo.turnLeft();
        volvo.move();
        assertEquals(0, volvo.point.getX());
        volvo.turnLeft();

    }


    @Test @Order(3)
    void turnLeft() {
        volvo.turnLeft();
        assertEquals(Car.Direction.NORTH, volvo.direction);
        volvo.turnLeft();
        assertEquals(Car.Direction.WEST, volvo.direction);
        volvo.turnLeft();
        assertEquals(Car.Direction.SOUTH, volvo.direction);
        volvo.turnLeft();
        assertEquals(Car.Direction.EAST, volvo.direction);
        saab.turnLeft();
        assertEquals(Car.Direction.WEST, saab.direction);
    }

    @Test @Order(2)
    void turnRight() {
        volvo.turnRight();
        assertEquals(Car.Direction.EAST, volvo.direction);
    }

    @Test
    void getNrDoors() {
        assertTrue(volvo.getNrDoors() == 4 && saab.getNrDoors() == 2);
    }

    @Test
    void getEnginePower() {
        assertTrue(volvo.getEnginePower() == 100 && saab.getEnginePower() == 125);
    }

    @Test
    void getCurrentSpeed() {
        assertTrue(volvo.getCurrentSpeed() == volvo.currentSpeed && saab.getCurrentSpeed() == saab.currentSpeed);
        assertTrue(volvo.getCurrentSpeed() >= 0 && volvo.getCurrentSpeed() <= volvo.getEnginePower());
        assertTrue(saab.getCurrentSpeed() >= 0 && saab.getCurrentSpeed() <= saab.getEnginePower());

    }

    @Test
    void getColor() {
        assertTrue(volvo.getColor() == Color.black && saab.getColor() == Color.red);
    }

    @Test
    void setColor() {

    }

    @Test
    void startEngine() {
        volvo.startEngine();
        saab.startEngine();
        assertTrue(volvo.getCurrentSpeed() > 0 && saab.getCurrentSpeed() > 0);
    }

    @Test
    void stopEngine() {
        volvo.startEngine();
        volvo.stopEngine();
        assertEquals(0.0, volvo.getCurrentSpeed());
    }

    @Test
    void speedFactor() {
        assertTrue(volvo.speedFactor() == 1.25 && (saab.speedFactor() == 1.25 || saab.speedFactor() == 1.625));
    }

    @Test @Order(4)
    void incrementSpeed() {
        volvo.startEngine();
        volvo.incrementSpeed(10);
        saab.startEngine();
        saab.incrementSpeed(10);
        assertTrue(volvo.getCurrentSpeed() > 10);
        assertTrue(saab.getCurrentSpeed() > 10);
    }

    @Test @Order(5)
    void decrementSpeed() {
        volvo.decrementSpeed(10);
        saab.decrementSpeed(10);
        assertTrue(volvo.getCurrentSpeed() < 10);
        assertTrue(saab.getCurrentSpeed() < 10);
    }

    /*
    Gas method in the car class uses clamp 1 to 0,
     which makes it impossible to go above 1 or below 0.
    */
    @Test @Order(6)
    void gas() {
        double initialSpeed = 0.1;
        volvo.gas(1);
        saab.gas(1);
        assertTrue(volvo.getCurrentSpeed() > initialSpeed);
        assertTrue(saab.getCurrentSpeed() > initialSpeed);

        volvo.brake(1);
        volvo.gas(100);
        volvo.gas(-100);
        assertEquals(1.35, volvo.getCurrentSpeed(), 0.001);
    }

    /*
    Brake method in the car class uses clamp 1 to 0,
    which makes it impossible to go above 1 or below 0.
   */
    @Test @Order(7)
    void brake() {
        double initialSpeed = 1;
        volvo.brake(1);
        saab.brake(1);
        assertTrue(volvo.getCurrentSpeed() < initialSpeed);
        assertTrue(saab.getCurrentSpeed() < initialSpeed);
        assertTrue(volvo.getCurrentSpeed() < initialSpeed);

        volvo.gas(1);
        volvo.brake(100);
        volvo.brake(-100);
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.001);
    }

    @Test @Order(8)
    void raiseFlak() {
        scania.stopEngine();
        scania.raiseFlak(2);
        assertEquals(2, scania.getFlakAngle());
    }

    @Test @Order(10)
    void lowerFlak() {
        scania.lowerFlak(2);
        assertEquals(0, scania.getFlakAngle());
        scania.lowerFlak(2);
        assertEquals(0, scania.getFlakAngle());
        scania.lowerFlak(71);
        assertEquals(0, scania.getFlakAngle());
    }

    @Test @Order(9)
    void startEngineScania() {
        scania.startEngine();
        assertEquals(0.0, scania.getCurrentSpeed());
    }

    @Test @Order(11)
    void startEngineScania2() {
        scania.startEngine();
        assertEquals(0.1, scania.getCurrentSpeed());

    }

    @Test @Order(12)
    void getFlakAngle() {
        assertEquals(0, scania.getFlakAngle());
        scania.raiseFlak(2);
        assertEquals(0, scania.getFlakAngle());
        scania.lowerFlak(2);
        assertEquals(0, scania.getFlakAngle());
        scania.stopEngine();
        scania.raiseFlak(2);
        assertEquals(2, scania.getFlakAngle());
    }

    @Test @Order(12)
    void rampUpDown() {
        truck.stopEngine();
        assertEquals(0, truck.getCurrentSpeed());
        truck.lowerRamp();
        assertFalse(truck.getRampUp());
        truck.raiseRamp();
        assertTrue(truck.getRampUp());

    }

    @Test @Order(13)
    void loadCar() {
        truck.lowerRamp();
        volvo2.point.setLocation(2, 2);
        truck.loadCar(volvo2);
        assertEquals(truck.point.getX(), volvo2.point.getX());
        assertEquals(truck.point.getY(), volvo2.point.getY());
        assertEquals(truck.getPoint().getY(), volvo2.getPoint().getY());
        assertEquals(1, truck.getLoadedCars().size());
    }


    @Test @Order(14)
    void unload() {
        truck.lowerRamp();
        truck.loadCar(volvo3);
        truck.unloadCar();
        assertEquals(5, volvo3.point.getX());
        assertEquals(5, volvo3.point.getY());
        assertEquals(0, truck.point.getX());
        assertEquals(0, truck.point.getY());
    }

    @Test @Order(15)
    void MoveTruck() {
        truck.raiseRamp();
        truck.startEngine();
        truck.move();
        assertEquals(0.1, truck.point.getY());
        assertEquals(0, truck.point.getX());
        truck.stopEngine();
        truck.lowerRamp();
        truck.loadCar(volvo);
        truck.raiseRamp();
        truck.startEngine();
        truck.move();
        assertEquals(0.2, truck.point.getY());
        assertEquals(0, truck.point.getX());
        assertEquals(0.2, volvo.point.getY());
        assertEquals(0, volvo.point.getX());

    }


    @Test @Order(16)
    void testing() {
        vShop.point.setLocation(6, 6);
        assertEquals(6, vShop.getPoint().getX());
        assertEquals(6, vShop.getPoint().getY());
    }

    @Test @Order(17)
    void typeCarAllowed() {
        volvo2.point.setLocation(7, 7);
        vShop.typeCarAllowed(volvo2);
        assertEquals(vShop.getPoint().getX(), volvo2.getPoint().getX());
        assertEquals(vShop.getPoint().getY(), volvo2.getPoint().getY());
        saab2.point.setLocation(6, 6);
    }

    @Test @Order(20)
    void loadWrongCarInWorkshop(){
        volvo2.point.setLocation(5,5);
        vShop.typeCarAllowed(volvo2);
        assertEquals(2, vShop.currentCars.size());
        //vShop.typeCarAllowed(saab2); // gives a static (compile time) error.

        /*Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vShop.typeCarAllowed(saab2);});
        System.out.println(exception);*/
    }
    @Test @Order(19)
    void loadTruckWithTruck() {
        try {
            truck3.lowerRamp();
            truck3.loadCar(truck4);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}