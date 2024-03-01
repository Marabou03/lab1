import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CarView extends JFrame implements CarObserver{

    private List<CarObserver> observers = new ArrayList<>();

    // Add observer
    public void addObserver(CarObserver observer) {
        observers.add(observer);
    }

    // Remove observer
    public void removeObserver(CarObserver observer) {
        observers.remove(observer);
    }

    // Notify observers
    private void notifyObservers(Car car) {
        for (CarObserver observer : observers) {
            observer.update(car);
        }
    }

    // Implement update method from CarObserver interface
    @Override
    public void update(Car car) {
        // Update view based on the changes in car
        // For example, repaint the car position or update UI elements
        drawPanel.repaint();
    }
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
    JList<String> carList; // JList for car types
    String[] carTypes = {"Volvo240", "Saab95", "Scania"}; // Available car types

    JButton removeCar = new JButton("Remove Car");

    // Constructor
    CCMethotods ccm;
    public CarView(String framename, CarRelatedData<BufferedImage, Point, Car> carC){
        this.carC = carC;
        this.ccm = new CCMethotods();
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

        // Create the JList with car types
        carList = new JList<>(carTypes);
        carList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carList.setVisibleRowCount(3); // Set the number of visible rows
        JScrollPane carListScrollPane = new JScrollPane(carList);
        add(carListScrollPane);

        removeCar.setBackground(Color.red);
        removeCar.setForeground(Color.black);
        removeCar.setPreferredSize(new Dimension(X/5-15,100));
        this.add(removeCar);

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    ccm.gas(car, gasAmount);
                    carC.notifyObservers(car);
                }
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    ccm.brake(car, gasAmount);
                    carC.notifyObservers(car);
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    ccm.startEngine(car);
                    carC.notifyObservers(car);
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    ccm.stopEngine(car);
                    carC.notifyObservers(car);
                }
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    if(car instanceof Saab95 saab){
                        ccm.setTurboOn(saab);
                        carC.notifyObservers(car);
                    }
                }
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    if(car instanceof Saab95 saab){
                        ccm.setTurboOff(saab);
                        carC.notifyObservers(car);
                    }
                }
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    if(car instanceof Scania scania){
                        ccm.raiseFlak(scania, gasAmount);
                        carC.notifyObservers(car);
                    }
                }
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : carC.getCarsList()) {
                    if(car instanceof Scania scania){
                        ccm.lowerFlak(scania,gasAmount);
                        carC.notifyObservers(car);
                    }
                }
            }
        });

        // Add a ListSelectionListener to the JList
        carList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedCarType = carList.getSelectedValue();
                    if (selectedCarType != null) {
                        ccm.addCar(selectedCarType);

                    }
                }
            }
        });

        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!carC.getCarsList().isEmpty()) {
                    carC.getCarsList().remove(carC.getCarsList().size() - 1);
                    carC.getCarImages().remove(carC.getCarImages().size() - 1);
                    carC.getCarImagesPoints().remove(carC.getCarImagesPoints().size() - 1);
                    drawPanel.repaint();
                }
            }
        });

        // Make the frame pack all its components by respecting the sizes if possible.
        this.pack();

        // Center the frame on the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        // Make the frame visible
        this.setVisible(true);

        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
