public class Loading implements LoadingInterface{
    public Loading() {
    }


    @Override
    public void loadCar(Truck truck, Car car) {
        if (!(car instanceof Truck) && !(truck.vehicleType.equals(car.vehicleType))) {
            if (!truck.getRampUp() && (truck.getLoadedCars().size() < truck.getMaxCars())) {
                double distance = calculateDistance(car.getPoint(), truck.getPoint());
                if (distance < 5) {
                    truck.getLoadedCars().add(car);
                    car.point = truck.getPoint();
                } else {
                    throw new IllegalArgumentException("Car is too far away");
                }
            } else {
                throw new IllegalArgumentException("Either the truck is full or the ramp is up");
            }
        } else if (car instanceof Truck && car != truck) {
            throw new IllegalArgumentException("Can't load a truck into another truck");
        } else if (truck.vehicleType.equals(car.vehicleType)) {
            throw new IllegalArgumentException("Can't load a truck with the same type into this truck");
        }
    }

    @Override
    public void unloadCar(Truck truck) {
        if (!truck.getRampUp() && !truck.getLoadedCars().isEmpty()) {
            Car lastCar = truck.getLoadedCars().getLast();
            Point carPoint = new Point(lastCar.point.getX(), lastCar.point.getY());
            carPoint.setLocation(truck.getPoint().getX() + 5, truck.getPoint().getY() + 5);
            lastCar.point = carPoint;
            truck.getLoadedCars().removeLast();
        } else {
            throw new IllegalArgumentException("Truck is empty or the ramp is up");
        }
    }


    protected double calculateDistance(Point point1, Point point2) {
        double posX = Math.pow(point1.getX() - point2.getX(), 2);
        double posY = Math.pow(point1.getY() - point2.getY(), 2);
        return Math.sqrt(posX + posY);
    }
}
