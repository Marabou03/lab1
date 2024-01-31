import java.awt.Color;
import java.lang.Math;

public abstract class Car implements Movable{
    protected Point point;
    protected Direction direction;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected Car (int nrDoors, double enginePower, Color color, String modelName){
        this.direction = Direction.NORTH;
        this.point = new Point(0, 0);
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    @Override
    public void move() {
        switch (direction) {
            case NORTH:
                point.setLocation(point.getX(), point.getY() + this.getCurrentSpeed());
                break;
            case EAST:
                point.setLocation(point.getX() + this.getCurrentSpeed(), point.getY());
                break;
            case SOUTH:
                point.setLocation(point.getX(), point.getY() - this.getCurrentSpeed());
                break;
            case WEST:
                point.setLocation(point.getX() - this.getCurrentSpeed(), point.getY());
                break;
        }
    }

    @Override
    public void turnLeft() {
        if (this.direction == Direction.NORTH){
            this.direction = Direction.WEST;
        } else{
            int i = (this.direction.ordinal() - 1 + 4) % 4;
            this.direction = Direction.values()[i];
        }
    }
    @Override
    public void turnRight() {
        direction = Direction.values()[(direction.ordinal() + 1) % 4];
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        currentSpeed = Math.clamp(currentSpeed, 0, enginePower);
        return currentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    protected double speedFactor(){
        return 0;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() + speedFactor() * amount,0);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    protected void gas(double amount){
        amount = Math.clamp(amount, 0, 1);
        incrementSpeed(amount);
    }

    protected void brake(double amount){
        amount = Math.clamp(amount, 0, 1);
        decrementSpeed(amount);
    }
}