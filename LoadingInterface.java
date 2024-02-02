import java.util.List;

public interface LoadingInterface {

    default void loadCar(Truck truck, Car car) {

    }

    //<T extends Car> void loadCar2(Workshop<T> workshop, T car);

    void unloadCar(Truck truck);
}
