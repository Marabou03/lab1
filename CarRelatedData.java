import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CarRelatedData<T1 extends BufferedImage, T2 extends Point, T3 extends Car> {
    private final ArrayList<T1> carImages;
    private final ArrayList<T2> carImagesPoints ;
    private final ArrayList<T3> carsList;

    protected CarRelatedData(ArrayList<T1> carImages, ArrayList<T2> carImagesPoints , ArrayList<T3> carsList) {
        this.carImages = carImages;
        this.carImagesPoints  = carImagesPoints ;
        this.carsList = carsList;
    }

    protected ArrayList<T1> getCarImages() {
        return carImages;
    }

    protected ArrayList<T2> getCarImagesPoints () {
        return carImagesPoints ;
    }

    protected ArrayList<T3> getCarsList() {
        return carsList;
    }


    public void add(T1 element1, T2 element2, T3 element3) {
        carImages.add(element1);
        carImagesPoints.add(element2);
        carsList.add(element3);
    }
}