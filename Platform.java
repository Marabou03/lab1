import java.awt.*;

public class Platform{
    protected double flakAngle;
    public Platform(){
        this.flakAngle = 0;
    }
    public double getFlakAngle() {
        return flakAngle;
    }
    public void raiseFlak(double raise) {
            double raisetmp = flakAngle + raise;
            flakAngle = Math.clamp(raisetmp, 0 , 70);
    }

    public void lowerFlak(double lower ) {
            double lowertmp = flakAngle - lower;
            flakAngle = Math.clamp(lowertmp, 0 , 70);
    }
}
