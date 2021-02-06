package lessonsJava.Lesson1;

public class StartPoint {
    public static void main (String[] args) {

            Point p1 = new Point(0, 5);
            p1.Print();
            Point p2 = new Point(0,0);
            p2.Print();

        // method distance calls from class Point1
        System.out.println("Method distance result N4: " +  " = " + p1.distance(p2));

        // Static function distance
        System.out.println("Method distance static result N2: "+" = " + distance(p1,p2));
    }

         // N2 function distance static
         public  static double distance(Point p1, Point p2) {
         return Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
    }
}
