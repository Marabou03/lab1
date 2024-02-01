import java.util.List;

public class VolvoWorkshop extends Workshop{

    private static final Car Volvo240 = new Volvo240();

    public VolvoWorkshop() {
        super(10, "VolvoWrokers", Volvo240.class);

    }

}
