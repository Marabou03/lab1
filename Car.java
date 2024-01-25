import java.awt.Color;
import java.lang.Math;

public abstract class Car implements Movable{
    protected Point point;
    protected int direction;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected Car (int nrDoors, double enginePower, Color color, String modelName){
        this.direction = 0;
        this.point = new Point(0, 0);
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    @Override
    public void move() {
        if(this.direction == 0){
            this.point.setLocation(point.getX(), point.getY()+this.getCurrentSpeed());
        }
        if(this.direction == 1){
            this.point.setLocation(point.getX()+this.getCurrentSpeed(), point.getY());
        }
        if(this.direction == 2){
            this.point.setLocation(point.getX(), point.getY()-this.getCurrentSpeed());
        }
        if(this.direction == 3){
            this.point.setLocation(point.getX()-this.getCurrentSpeed(), point.getY());
        }
    }
    @Override
    public void turnLeft() {
        if(this.direction == 0){
            this.direction = 3;
        } else {
            this.direction = (this.direction % 4) - 1;
        }
    }
    @Override
    public void turnRight() {
        this.direction = ((this.direction + 1) % 4);
    }

    protected int getNrDoors(){
        return nrDoors;
    }
    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        // ska kalla på gas och break ksk
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
