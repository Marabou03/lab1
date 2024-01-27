import java.awt.*;
import java.lang.Math;

public class Scania extends Car{
    private double flakAngle;

    public Scania(){
        super(2, 100, Color.gray, "Scania");
        this.flakAngle = 0;
    }
    public double getFlakAngle() {
        return flakAngle;
    }
    public void changeFlakAngle(double changeAngle) {
        if (getCurrentSpeed() == 0) {
            flakAngle = Math.clamp(changeAngle, 0 , 70);
        }else {
            flakAngle = 0;
        }
    }
    public void raiseFlak(double raise) {
        if (getCurrentSpeed() == 0) {
            raise += flakAngle;
            flakAngle = Math.clamp(raise, 0 , 70);
        }else {
            flakAngle = 0;
        }
    }

    public void lowerFlak(double lower ) {
        if (getCurrentSpeed() == 0) {
            lower -= flakAngle;
            flakAngle = Math.clamp(lower, 0 , 70);
        }else {
            flakAngle = 0;
        }
    }

    @Override
    protected void startEngine() {
        if (flakAngle == 0) {
            super.startEngine();
        }
    }

    @Override
    protected void stopEngine() {
        super.stopEngine();
        flakAngle = 0;
    }

}
