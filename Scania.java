import java.awt.*;
import java.lang.Math;

public class Scania extends Car{
    private Platform platform;

    public Scania(){
        super(2, 100, Color.gray, "Scania", "truck");
        this.platform = new Platform();

    }
    public double getFlakAngle() {
        return platform.getFlakAngle();
    }
    public void raiseFlak(double raise) {
        platform.raiseFlak(raise);
    }

    public void lowerFlak(double lower ) {
        platform.lowerFlak(lower);
    }


    protected void startEngine() {
        platform.startEngine();
    }


    protected void stopEngine() {
        platform.stopEngine();
    }
}
