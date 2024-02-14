import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2, 125, Color.red, "Saab95", "car");
	    turboOn = false;
    }

    protected void setTurboOn(){
	    turboOn = true;
    }

    protected void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 0.5;
        if(turboOn) turbo = 50;
        return enginePower * 0.01 * turbo;
    }


}
