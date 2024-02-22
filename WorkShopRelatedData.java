import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class WorkShopRelatedData<T1 extends BufferedImage, T2 extends Point, T3 extends Workshop<? extends Car>> {
    private final ArrayList<T1> workShopImages;
    private final ArrayList<T2> WorkShopImagesPoints ;
    private final ArrayList<T3> WorkshopsList;

    public WorkShopRelatedData(ArrayList<T1> workShopImages, ArrayList<T2> WorkShopImagesPoints, ArrayList<T3> WorkshopsList) {
        this.workShopImages = workShopImages;
        this.WorkShopImagesPoints  = WorkShopImagesPoints ;
        this.WorkshopsList = WorkshopsList;
    }

    protected ArrayList<T1> getworkShopImages() {
        return workShopImages;
    }

    protected ArrayList<T2> getWorkShopImagesPoints () {
        return WorkShopImagesPoints ;
    }

    protected ArrayList<T3> getWorkshopsList() {
        return WorkshopsList;
    }


    public void add(T1 element1, T2 element2, T3 element3) {
        workShopImages.add(element1);
        WorkShopImagesPoints.add(element2);
        WorkshopsList.add(element3);
    }


}