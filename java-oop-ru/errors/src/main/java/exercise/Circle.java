package exercise;

// BEGIN
public class Circle {
    private Point point;
    private int radius;
    private double square;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {

        if (radius < 0) {
            throw new NegativeRadiusException("01");
        } else {
            return Math.PI * radius * radius;
        }

    }
}
// END
