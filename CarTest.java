import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static Car volvo;
    private static Car saab;
    @BeforeAll
    public static void init() {
        volvo  = new Volvo240();
        saab = new Saab95();
    }

    @Test
    void move() {
        volvo.startEngine();
        volvo.move();
        assertEquals(0.1, volvo.point.getX());
    }

    @Test
    void turnLeft() {
        saab.turnLeft();
        assertEquals(3, saab.direction);
    }

    @Test
    void turnRight() {
        volvo.turnRight();
        assertEquals(1, volvo.direction);
    }

    @Test
    void getNrDoors() {

    }

    @Test
    void getEnginePower() {
    }

    @Test
    void getCurrentSpeed() {
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
    }

    @Test
    void stopEngine() {
    }

    @Test
    void speedFactor() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }
}