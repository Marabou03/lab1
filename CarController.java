import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



/**
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and then updating the view.
**/



public class CarController {

    private CarFactory carFactory;
    private WorkShopFactory workShopFactory;
    private MiddleGround md;

    public CarController() {
        carFactory = new CarFactory();
        workShopFactory = new WorkShopFactory();
        md = new MiddleGround();
        }

    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed

    //protected static Workshop<Volvo240> volvoWorkshop = new Workshop<>(10, "volvoWorkshop", Volvo240.class);

    //private Loading loader;
    //methods:



/* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    **/

    private class TimerListener implements ActionListener {

        private double calculateDistance(Point point1, Point point2) {
            double posX = Math.pow(point1.getX() - point2.getX(), 2);
            double posY = Math.pow(point1.getY() - point2.getY(), 2);
            return Math.sqrt(posX + posY);
        }

        private void moveStuff(int i, int j, Car car){
            md.workShopData.getWorkshopsList().get(j).typeCarAllowed(car);
            moveVolvoToWorkshop(i);
            md.carData.getCarsList().remove(i);
        }

        // Method to move Volvo cars to the workshop
        private void moveVolvoToWorkshop(int i) {
            md.carData.getCarImages().remove(i);
            md.carData.getCarImagesPoints().remove(i);
        }

        private void moveit(ArrayList<Car> cars) {
            for(int i = 0; i < cars.size(); i++){
                int p = (int) cars.get(i).getPoint().getX();
                int q = (int) cars.get(i).getPoint().getY();
                Point k = new Point(p,q);
                md.carData.getCarImagesPoints().set(i,k);
            }
            frame.drawPanel.repaint(); // Refresh the panel to reflect the changes

        }

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < md.carData.getCarsList().size(); i++) {
                Car k = md.carData.getCarsList().get(i);
                Point o = new Point((int) k.getPoint().getX(), (int) k.getPoint().getY());
                for (int j = 0; j < md.workShopData.getWorkshopsList().size(); j++){
                    Workshop<Car> h = md.workShopData.getWorkshopsList().get(j);
                    double x = h.getPoint().getX();
                    double y = h.getPoint().getY();
                    Point p = new Point((int) x, (int) y);
                    if (k instanceof Volvo240 v && h.getCarType().isInstance(v) && calculateDistance(o, p) < 10) {
                        moveStuff(i,j,v);
                        i--;
                        System.out.println(md.carData.getCarImages().toString());
                    } else if (k instanceof Saab95 sa && h.getCarType().isInstance(sa)&& calculateDistance(o, p) < 10) {
                        moveStuff(i,j,sa);
                        i--;
                    } else if (k instanceof Scania sc && h.getCarType().isInstance(sc) && calculateDistance(o, p) < 10) {
                        moveStuff(i, j, sc);
                        i--;
                    }
                }

                k.move();
                if (k.getPoint().getY() > frame.getHeight() - 300) {
                    k.direction = Car.Direction.SOUTH;
                } else if (k.getPoint().getY() < 0) {
                    k.direction = Car.Direction.NORTH;
                }
                if (k.getPoint().getX() > frame.getWidth()) {
                    k.direction = Car.Direction.WEST;
                } else if (k.getPoint().getX() < 0) {
                    k.direction = Car.Direction.EAST;
                }
                moveit(md.carData.getCarsList());
                frame.drawPanel.repaint();
            }
        }
    }

}
