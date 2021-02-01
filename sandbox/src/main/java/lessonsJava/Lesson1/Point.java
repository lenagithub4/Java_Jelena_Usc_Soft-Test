package lessonsJava.Lesson1;

public class Point {

    public static double x1, y1, x2, y2;

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();

        p1.x1 = 2;
        p1.y1 = 7;
        p2.x2 = 7;
        p2.y2 = 2;

        System.out.println("Rasstojanie mezdu tochkami (" + p1.Print1() + ") и (" + p2.Print2() + ") = " + distance(p1, p2));

    }

    /* KOORDINATI TOCKI P1 */
    public String Print1(){
        return (this.x1 + ";" + this.y1);
    }

    /* KOORDINATI TOCKI P2 */
    public String Print2() {
        return (this.x2 + ";" + this.y2);
    }

    public static double distance(Point p1, Point p2) {

        return Math.sqrt((p2.x2 - p1.x1)*(p2.x2 - p1.x1) + (p2.y2 - p1.y1)*(p2.y2 - p1.y1));

    }


}
