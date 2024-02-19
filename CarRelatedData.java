import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CarRelatedData<T1 extends BufferedImage, T2 extends Point, T3 extends Car> {
    private final ArrayList<T1> CarImages;
    private final ArrayList<T2> CarImagesPoints ;
    private final ArrayList<T3> CarsList;

    protected CarRelatedData(ArrayList<T1> CarImages, ArrayList<T2> CarImagesPoints , ArrayList<T3> CarsList) {
        this.CarImages = CarImages;
        this.CarImagesPoints  = CarImagesPoints ;
        this.CarsList = CarsList;
    }

    protected ArrayList<T1> getCarImages() {
        return CarImages;
    }

    protected ArrayList<T2> getCarImagesPoints () {
        return CarImagesPoints ;
    }

    protected ArrayList<T3> getCarsList() {
        return CarsList;
    }


    public void add(T1 element1, T2 element2, T3 element3) {
        CarImages.add(element1);
        CarImagesPoints.add(element2);
        CarsList.add(element3);
    }


}