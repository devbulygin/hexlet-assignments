package exercise;

// BEGIN
public class Cottage implements Home{
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        return Home.super.compareTo(another);
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() +" метров";
    }
}
// END
