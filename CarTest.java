import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {
    // HELLO!
    private static Car volvo;
    private static Car saab;
    @BeforeAll
    public static void init() {
        volvo  = new Volvo240();
        saab = new Saab95();
    }

    @Test @Order(1)
    void move() {
        volvo.startEngine();
        volvo.move();
        assertEquals(0, volvo.point.getX());
        assertEquals(0.1, volvo.point.getY());
    }


    @Test
    void turnLeft() {
        saab.turnLeft();
        assertEquals(3, saab.direction);
    }

    @Test @Order(2)
    void turnRight() {
        volvo.turnRight();
        assertEquals(1, volvo.direction);
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

    @Test @Order(3)
    void incrementSpeed() {
        volvo.startEngine();
        volvo.incrementSpeed(10);
        saab.startEngine();
        saab.incrementSpeed(10);
        int initialSpeed = 0;
        int amount = 10;
        assertTrue(volvo.getCurrentSpeed() > 10);
        assertTrue(saab.getCurrentSpeed() > 10);
    }

    @Test @Order(4)
    void decrementSpeed() {
        volvo.decrementSpeed(10);
        saab.decrementSpeed(10);
        int initialSpeed = 20;
        int amount = 10;
        assertTrue(volvo.getCurrentSpeed() < 10);
        assertTrue(saab.getCurrentSpeed() < 10);
    }

    @Test @Order(5)
    void gas() {
        double initialSpeed = 0.1;
        volvo.gas(1);
        saab.gas(1);
        assertTrue( volvo.getCurrentSpeed() > initialSpeed);
        assertTrue(saab.getCurrentSpeed() > initialSpeed);

    }

    @Test @Order(6)
    void brake() {
        double initialSpeed = 1;
        volvo.brake(1);
        saab.brake(1);
        assertTrue(volvo.getCurrentSpeed() < initialSpeed);
        assertTrue(saab.getCurrentSpeed() < initialSpeed);

    }
}