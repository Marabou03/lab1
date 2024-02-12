public class Point {
    private double x, y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY (double y){
        this.y = y;
    }

    public void translate(Point point, int dx, int dy) {
        point.x += dx;
        point.y += dy;
    }

}
