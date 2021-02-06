package lessonsJava.Lesson1;

public class Point {
    public double x, y;

    public Point (double x, double y) {
        this.x=x;
        this.y=y;
    }

    // n.4
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x,2)+ Math.pow(this.y-other.y,2));
    }

    public void Print() {
        System.out.println("x=  " + this.x + " ," + "y= " + this.y);
    }

}
