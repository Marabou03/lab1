public interface LoadingInterface {
    void loadCar();
    void unloadCar();

    void loadCar(Truck truck, Car car);

    void unloadCar(Truck truck);
}
