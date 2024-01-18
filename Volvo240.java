import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    private Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }
    
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
