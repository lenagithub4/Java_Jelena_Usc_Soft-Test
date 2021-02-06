package LessonsJava.Lesson1;

import lessonsJava.Lesson1.Point1;
import org.testng.Assert;
import org.junit.Test;

public class Point1Tests {
    @Test
    public void testDistance() {
     Point1 p1 = new Point1(0,5);
     Point1 p2 = new Point1(0,0);

        Assert.assertEquals( p1.distance(p2), 5.0);
    }


    @Test
    public void testDistance1() {
        Point1 p1 = new Point1(0,5);
        Point1 p2 = new Point1(0,0);

        Assert.assertEquals( p1.distance(p2), 1.0);
    }
    @Test
    public void testDistance2() {
        Point1 p1 = new Point1(1,1);
        Point1 p2 = new Point1(1,2);

        Assert.assertEquals( p1.distance(p2), 1.0);
    }
    @Test
    public void testDistance3() {
        Point1 p1 = new Point1(1,1);
        Point1 p2 = new Point1(1,2);

        Assert.assertEquals( p1.distance(p2), -1.0);
    }
}
