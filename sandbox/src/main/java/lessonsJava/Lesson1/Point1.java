package lessonsJava.Lesson1;

public class Point1 {
    public double x, y;

         public Point1 (double x, double y) {
             this.x=x;
             this.y=y;
         }

    // n.4
    public double distance(Point1 other) {
        return Math.sqrt(Math.pow(this.x - other.x,2)+ Math.pow(this.y-other.y,2));
    }

    public void Print() {
        System.out.println("x=  " + this.x + " ," + "y= " + this.y);
    }

}
