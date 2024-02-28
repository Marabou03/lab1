import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/


public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    CarRelatedData<BufferedImage, Point, Car> carC;


    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCar = new JButton("Add Car");
    JButton removeCar = new JButton("Remove Car");

    // Constructor
    public CarView(String framename, CarRelatedData<BufferedImage, Point, Car> carC){
        this.carC = carC;
        initComponents(framename);
    }

    // Sets everything in place and fits everything

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);



        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
            gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        addCar.setBackground(Color.red);
        addCar.setForeground(Color.black);
        addCar.setPreferredSize(new Dimension(X/5-15,100));
        this.add(addCar);

        removeCar.setBackground(Color.red);
        removeCar.setForeground(Color.black);
        removeCar.setPreferredSize(new Dimension(X/5-15,100));
        this.add(removeCar);

        // This actionListener is for the gas button only
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    car.gas(gasAmount);
                }
            }
        });


        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    car.brake(gasAmount);
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    car.startEngine();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    car.stopEngine();
                }
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    if(car instanceof Saab95 saab){
                        saab.setTurboOn();
                    }
                }
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    if(car instanceof Saab95 saab){
                        saab.setTurboOff();
                    }
                }
            }
        });
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    if(car instanceof Scania Scania){
                        Scania.raiseFlak(gasAmount);
                    }
                }
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    if(car instanceof Scania Scania){
                        Scania.lowerFlak(gasAmount);
                    }
                }
            }
        });
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the addCar method with the desired car type
                addCar("Volvo240"); // You can replace "Volvo240" with any desired car type
            }
        });

        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the last car from the list
                if (!carC.getCarsList().isEmpty()) {
                    carC.getCarsList().remove(carC.getCarsList().size() - 1);
                    carC.getCarImages().remove(carC.getCarImages().size() - 1);
                    carC.getCarImagesPoints().remove(carC.getCarImagesPoints().size() - 1);// lägg till i CarController

                }
            }
        });
;



        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
