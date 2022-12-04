package exercise;

// BEGIN
public interface Home {

    double getArea();
    default int compareTo(Home another){
        if (this.getArea() > another.getArea()){
            return 1;
        } else if (this.getArea() == another.getArea()) {
            return 0;
        } else {
            return -1;
        }
    }

    String toString();
    
}
// END
