package ex2.geo;
import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Triangle_2DTest {
    private Point_2D p1 =new Point_2D(0,0);
    private Point_2D p2 =new Point_2D(1,0);
    private Point_2D p3 =new Point_2D(1,1);
    private Triangle_2D t1= new Triangle_2D(p1,p2,p3);

    /**
     *This method tests the string representation functionality of the Triangle_2D class.
     *  * It creates a triangle 't' with points 'p1', 'p2', and 'p3'.
     *  * The method then obtains the string representation of the triangle and compares it with the expected string representation 'ans'.
     *  * The expected string 'ans' is constructed by concatenating the string representations of the 'p1', 'p2', and 'p3' separated by commas.
     *  * The method asserts that the obtained string representation of the triangle 'test' matches the expected string 'ans'.
     */
    @Test
    public void testToString(){
        Point_2D p1=new Point_2D(0,0);
        Point_2D p2=new Point_2D(1,0);
        Point_2D p3=new Point_2D(0,1);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        String test= t.toString();
        String ans= p1 +","+ p2 +","+ p3;
        assertEquals(test,ans);
    }

    /**
     *This method tests the contains functionality of the Triangle_2D class.
     *  * It creates a triangle 't' with vertices at points 'p1', 'p2', and 'p3'.
     *  * The method then creates two points: 'inside' and 'outside', which lie inside and outside the triangle, respectively.
     *  * The method asserts that the triangle 't' contains the point 'inside' and does not contain the point 'outside'.
     */
    @Test
    public void testContains(){
        Point_2D p1=new Point_2D(0,0);
        Point_2D p2=new Point_2D(2,0);
        Point_2D p3=new Point_2D(0,2);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        Point_2D inside= new Point_2D(1,1);
        Point_2D outside=new Point_2D(-1,1);
        assertTrue(t.contains(inside));
        assertFalse(t.contains(outside));
    }

    /**
     *This method tests the area calculation functionality of the Triangle_2D class.
     *  * It creates a triangle 't' with points 'p1', 'p2', and 'p3'.
     *  * The method calculates the area of the triangle using the 'area' method of the Triangle_2D class.
     *  * The method asserts that the calculated area matches the expected value '4.0' with a certain epsilon value.
     *  * It also asserts that the calculated area does not match a different expected value '3.0'.
     */
    @Test
    public void testArea(){
        Point_2D p1=new Point_2D(0,0);
        Point_2D p2=new Point_2D(4,0);
        Point_2D p3=new Point_2D(0,2);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        double test=t.area();
        double ans=4.0;
        double notans=3.0;
        assertEquals(ans,test, Ex2_Const.EPS);
        assertNotEquals(notans,test,Ex2_Const.EPS);
    }

    /**
     *This method tests the perimeter calculation functionality of the Triangle_2D class.
     *  * It creates a triangle 't' with points 'p1', 'p2', and 'p3'.
     *  * The method calculates the perimeter of the triangle using the 'perimeter' method of the Triangle_2D class.
     *  * The method asserts that the calculated perimeter matches the expected value '12.0' with a certain epsilon value.
     */
    @Test
    public void testPerimeter(){
        Point_2D p1=new Point_2D(0,0);
        Point_2D p2=new Point_2D(3,0);
        Point_2D p3=new Point_2D(0,4);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        double test=t.perimeter();
        double ans=12.0;
        assertEquals(test,ans, Ex2_Const.EPS);
    }

    /**
     *This method tests the translation functionality of the Triangle_2D class.
     *  * It translates the triangle 't1' by the vector represented by the point 'trans'.
     *  * The method then retrieves the vertices of the translated triangle using the 'getAllPoints' method of the Triangle_2D class.
     *  * The method asserts that the translated vertices match the expected values after the translation.
     */
    @Test
    public void testTranslate(){

        Point_2D trans=new Point_2D(3,5);
        t1.translate(trans);
        Point_2D[] real = t1.getAllPoints();
        Point_2D ans1=new Point_2D(3,5);
        Point_2D ans2=new Point_2D(4,5);
        Point_2D ans3=new Point_2D(4,6);
        assertEquals(ans1,real[0]);
        assertEquals(ans2,real[1]);
        assertEquals(ans3,real[2]);
    }

    /**
     *This method tests the copy functionality of the Triangle_2D class.
     *  * It invokes the 'copy' method on the triangle 't1'.
     *  * The method then retrieves the vertices of the copied triangle using the 'getAllPoints' method of the Triangle_2D class.
     *  * The method asserts that the vertices of the copied triangle match the vertices of the original triangle.
     */
    @Test
    public void testCopy(){
        t1.copy();
        Point_2D ans1=new Point_2D(0,0);
        Point_2D ans2=new Point_2D(1,0);
        Point_2D ans3=new Point_2D(1,1);
        Point_2D[] real = t1.getAllPoints();
        assertEquals(ans1,real[0]);
        assertEquals(ans2,real[1]);
        assertEquals(ans3,real[2]);
    }

    /**
     *This method tests the scaling functionality of the Triangle_2D class.
     *  * It creates a triangle 't' with points p1, p2, and p3.
     *  * Then, it scales the triangle with respect to the given center and ratio.
     *  * The method asserts that after scaling, the vertices of the triangle match the expected coordinates.
     */
    @Test
    public void testScale(){
        Point_2D p1=new Point_2D(1,1);
        Point_2D p2=new Point_2D(3,2);
        Point_2D p3=new Point_2D(5,4);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);

        double ratio= 2.0;
        Point_2D center = new Point_2D(1, 1);
        t.scale(center,ratio);
        Point_2D[] real=t.getAllPoints();
        assertEquals(1.0, real[0].x(), Ex2_Const.EPS);
        assertEquals(1.0, real[0].y(), Ex2_Const.EPS);
        assertEquals(5.0, real[1].x(), Ex2_Const.EPS);
        assertEquals(3.0, real[1].y(), Ex2_Const.EPS);
        assertEquals(9.0, real[2].x(), Ex2_Const.EPS);
        assertEquals(7.0, real[2].y(), Ex2_Const.EPS);
    }

    /**
     *This method tests the rotation functionality of the Triangle_2D class.
     *  * It creates a triangle 't' with vertices p1, p2, and p3.
     *  * Then, it rotates the triangle around the given center by the specified angle in degrees.
     *  * The method asserts that after rotation, the vertices of the triangle match the expected coordinates.
     *  */
    @Test
    public void testRotate(){
        Point_2D p1=new Point_2D(1,1);
        Point_2D p2=new Point_2D(3,2);
        Point_2D p3=new Point_2D(5,4);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        double angleDegrees=90;
        Point_2D center =new Point_2D(1,1);

        t.rotate(center,angleDegrees);
        Point_2D[] real=t.getAllPoints();

        assertEquals(1.0, real[0].x(), Ex2_Const.EPS);
        assertEquals(1.0, real[0].y(), Ex2_Const.EPS);
        assertEquals(0.0, real[1].x(), Ex2_Const.EPS);
        assertEquals(3.0, real[1].y(), Ex2_Const.EPS);
        assertEquals(-2.0, real[2].x(),Ex2_Const.EPS);
        assertEquals(5.0, real[2].y(), Ex2_Const.EPS);
    }
}
