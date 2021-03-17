package LessonsJava.Lesson1;

import lessonsJava.Lesson1.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {
     Point p1 = new Point(0,5);
     Point p2 = new Point(0,0);

        Assert.assertEquals( p1.distance(p2), 5.0);
    }


    @Test
    public void testDistance1() {
        Point p1 = new Point(0,5);
        Point p2 = new Point(0,0);

        Assert.assertEquals( p1.distance(p2), 1.0);
    }
    @Test
    public void testDistance2() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);

        Assert.assertEquals( p1.distance(p2), 1.0);
    }
    @Test
    public void testDistance3() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);

        Assert.assertEquals( p1.distance(p2), -1.0);
    }
}
