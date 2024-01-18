import java.awt.*;

public abstract class Car {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public Car (int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return 0;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }

}
