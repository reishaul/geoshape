package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Rect_2DTest {
    private Point_2D _p1;
    private Point_2D _p2;
    private Point_2D _p3;
    private Point_2D _p4;

    /**
     * This method tests the construction of a rectangle in 2D space.
     *  * It creates four 2D points to define the rectangle's corners.
     *  * This method prints the coordinates of _p3 and _p4 for verification.
     */
    @Test
    public void Rect2DTest() {

        this._p1 =new Point_2D(1,3);
        this._p2 =new Point_2D(0,0);
        this._p3 =new Point_2D(_p1.x(),_p2.y());
        this._p4 =new Point_2D(_p2.x(),_p1.y());
        System.out.println(_p3);
        System.out.println(_p4);
    }
    /**
     *  * This method tests the string representation of a rectangle in 2D space.
     *  * It creates four 2D points to define the corners of the rectangle.
     *  * The method invokes the toString() method of the Rect_2D object and
     *  * compares the result with the expected string representation.
     *  * The test passes if the obtained string matches the expected string.
     */

    @Test
    public void testToString(){
        this._p1 =new Point_2D(2,3);
        this._p2 =new Point_2D(0,4);
        this._p3 =new Point_2D(_p1.x(),_p2.y());
        this._p4 =new Point_2D(_p2.x(),_p1.y());
        Rect_2D r=new Rect_2D(_p1,_p2);
        String test=r.toString();
        String ans= _p1 + "," + _p2 + "," + _p3 + "," + _p4;;

        assertEquals(test,ans);
    }

    /**
     * This method tests the containment functionality of the Rect_2D class.
     *  * It creates a rectangle defined by two 2D points, p1 and p2.
     *  * Then, it creates two other points, ot and ot2, to check containment.
     *  * The point ot lies within the rectangle, while ot2 lies outside.
     *  * The method verifies whether the rectangle contains ot and does not contain ot2.
     */
    @Test
    public void testContains(){
        Point_2D p1=new Point_2D(1,2);
        Point_2D p2=new Point_2D(2,7);
        Rect_2D r=new Rect_2D(p1,p2);
        Point_2D ot=new Point_2D(1,3);
        Point_2D ot2=new Point_2D(0,0);

        assertTrue(r.contains(ot));
        assertFalse(r.contains(ot2));
    }
    /**
     * This method tests the calculation of the area of a rectangle by the Rect_2D class.
     *  * It creates a rectangle defined by two 2D points, p1 and p2.
     *  * Then, it calculates the area of the rectangle using the area() method.
     *  * The method compares the calculated area with an expected area value.
     */
    @Test
    public void testArea(){
        Point_2D p1=new Point_2D(0,0);
        Point_2D p2=new Point_2D(2,2);


        Rect_2D r=new Rect_2D(p1,p2);
        double test=r.area();
        double ans= 4.0;
        assertEquals(test,ans, Ex2_Const.EPS);
    }
    /**
     * This method tests the calculation of the perimeter of a rectangle by the Rect_2D class.
     *  * It creates a rectangle defined by two 2D points, p1 and p2.
     *  * Then, it calculates the perimeter of the rectangle using the perimeter() method.
     *  * The method compares the calculated perimeter with an expected perimeter value.
     *  */

    @Test
    public void testPerimeter(){
        Point_2D p1=new Point_2D(0,0);
        Point_2D p2=new Point_2D(2,2);
        Rect_2D r=new Rect_2D(p1,p2);
        double test=r.perimeter();
        double ans= 8.0;
        assertEquals(test,ans,Ex2_Const.EPS);
    }

    /**
     *   This method tests the translation functionality of the Rect_2D class.
     *  It creates two 2D points, constructs a rectangle using these points,
     *  and then translates the rectangle by a specified translation vector.
     *  Finally, it checks whether the translation was performed correctly by
     *  comparing the coordinates of the translated rectangle's points with
     *  the expected coordinates.
     */
    @Test
    public void testTranslate(){
        Point_2D p1=new Point_2D(0,0);
        Point_2D p2=new Point_2D(2,2);
        Point_2D trans=new Point_2D(2,7);

        Rect_2D r=new Rect_2D(p1,p2);
        r.translate(trans);
        Point_2D ans1=new Point_2D(2,7);
        Point_2D ans2=new Point_2D(4,9);
        assertEquals(ans1,r.get_p1());
        assertEquals(ans2,r.get_p2());
    }

    /**
     * This method tests the copy functionality of the copy() method in the Rect_2D class.
     *  * It creates a rectangle defined by two 2D points, _p1 and _p2.
     *  * Then, it instantiates a Rect_2D object 'r' using these points.
     *  * The method calls the copy() method to create a copy of the rectangle.
     *  * It then verifies that the copied rectangle has the same coordinates as the original rectangle.
     */
    @Test
    public void copyRectTest(){
        _p1= new Point_2D(1,2);
        _p2=new Point_2D(2,3);
        Rect_2D r=new Rect_2D(_p1,_p2);
        r.copy();
        Point_2D ans1=new Point_2D(1,2);
        Point_2D ans2=new Point_2D(2,3);
        assertEquals(ans1,r.get_p1());
        assertEquals(ans2,r.get_p2());
    }

    /**
     * This method tests the scaling functionality of the Rect_2D class.
     *  * It creates a rectangle defined by two 2D points, _p1 and _p2.
     *  * Then, it instantiates a Rect_2D object 'r' using these points.
     *  * It specifies a scaling ratio of 2.0 and a center point for scaling.
     *  * The method calls the scale() method to scale the rectangle around the specified center point.
     *  * It then verifies that the rectangle has been scaled correctly by comparing the coordinates of its points.
     *  * The expected coordinates after scaling are calculated based on the scaling ratio and the center point.
     *  * It asserts that the coordinates of the scaled rectangle's points (_p1 and _p2) match the expected coordinates.
     *  * Additionally, it verifies that a point not affected by scaling does not match the coordinates of the scaled _p2.
     */
    @Test
    public void testScale(){
        _p1= new Point_2D(1,1);
        _p2=new Point_2D(3,4);
        Rect_2D r=new Rect_2D(_p1,_p2);
        double ratio= 2.0;
        Point_2D center = new Point_2D(2, 2);
        r.scale(center,ratio);
        Point_2D ans1=new Point_2D(0,0);
        Point_2D ans2=new Point_2D(4,6);
        Point_2D notans=new Point_2D(7,9);
        assertEquals(ans1,r.get_p1());
        assertEquals(ans2,r.get_p2());
        assertNotEquals(notans,r.get_p2());
    }

    /**
     * This method tests the rotation functionality of the Rect_2D class.
     *  * It creates a rectangle defined by two 2D points, _p1 and _p2.
     *  * Then, it instantiates a Rect_2D object 'r' using these points.
     *  * The method rotates the rectangle by a specified angle around a given center point.
     *  * It rotates the rectangle by 90 degrees counterclockwise around the center point (2, -2).
     *  * After rotation, it verifies whether the new coordinates of the rectangle's corners match the expected coordinates.
     */
    @Test
    public void testRotate(){
        _p1= new Point_2D(1,-2);
        _p2=new Point_2D(3,-2);
        Rect_2D r=new Rect_2D(_p1,_p2);
        double angleDegrees=90;
        Point_2D center =new Point_2D(2,-2);
        r.rotate(center,angleDegrees);
        Point_2D ans1=new Point_2D(2,-3);
        Point_2D ans2=new Point_2D(2,-1);
        assertTrue(r.get_p1().close2equals(ans1,Ex2_Const.EPS));
        assertTrue(r.get_p2().close2equals(ans2,Ex2_Const.EPS));
    }
}


