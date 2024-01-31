public class VolvoWorkshop  {

    private static final Car Volvo240 = new Volvo240();
    private final Workshop work;

    public VolvoWorkshop() {
        //super(10, "VolvoWrokers", Volvo240);
        this.work = new Workshop(10, "VolvoWrokers", Volvo240.getClass());

    }

}