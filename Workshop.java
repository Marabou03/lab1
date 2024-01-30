import java.util.ArrayList;
import java.util.List;

public abstract class Workshop {
    protected int maxCars;
    protected List<Car> currentCars;
    protected String modelIntake;
    protected Workshop (int maxCars, String modelIntake) {
        this.maxCars = maxCars;
        this.currentCars = new ArrayList<>(maxCars);
        this.modelIntake = modelIntake;
    }

}
