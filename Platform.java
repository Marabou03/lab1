import java.awt.*;

public class Platform extends Car{
    private double flakAngle;
    public Platform(){
        super(2,200, Color.cyan, "name", "truck");
        this.flakAngle = 0;
    }
    public double getFlakAngle() {
        return flakAngle;
    }
    public void raiseFlak(double raise) {
        if (getCurrentSpeed() == 0) {
            double raisetmp = flakAngle + raise;
            flakAngle = Math.clamp(raisetmp, 0 , 70);
        }else {
            flakAngle = 0;
        }
    }

    public void lowerFlak(double lower ) {
        if (getCurrentSpeed() == 0) {
            double lowertmp = flakAngle - lower;
            flakAngle = Math.clamp(lowertmp, 0 , 70);
        }else {
            flakAngle = 0;
        }
    }


}
