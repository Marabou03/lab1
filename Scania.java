import java.awt.*;
import java.lang.Math;

public class Scania extends Car{
    private final Platform platform;

    public Scania(){
        super(2, 100, Color.gray, "Scania", "truck");
        this.platform = new Platform();

    }
    public double getFlakAngle() {
        return platform.getFlakAngle();
    }
    public void raiseFlak(double raise) {
        if (getCurrentSpeed() == 0) {
            platform.raiseFlak(raise);
        }else {
            platform.flakAngle = 0;
        }

    }

    public void lowerFlak(double lower ) {
        if (getCurrentSpeed() == 0) {
            platform.lowerFlak(lower);
        }else {
            platform.flakAngle = 0;
        }

    }

    @Override
    protected void startEngine() {
        if (platform.flakAngle == 0) {
            super.startEngine();
        }
    }
}
