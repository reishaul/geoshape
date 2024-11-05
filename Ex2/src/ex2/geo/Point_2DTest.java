package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point_2DTest {
    private Point_2D p1_2 = new Point_2D(1,2);
    private Point_2D p4_6= new Point_2D(4,6);

    /**
     *  This method tests the addition operation between two Point_2D objects.
     *  * Then, it creates a new Point_2D (5, 8).
     *  * The method calculates the distance between the result of the addition operation and 'pp'.
     *  * It asserts that the distance between the calculated point and 'pp' is less than the defined EPSILON value,
     *  * ensuring that they are approximately equal.
     *  * It also asserts that the result of the addition operation is equal to 'pp',
     *  * confirming that the addition operation was performed correctly.
     */

    @Test
    void add() {
        Point_2D p =p1_2.add(p4_6);
        Point_2D pp = new Point_2D(5,8);
        double d =p.distance(pp);
        assertTrue(d< Ex2_Const.EPS);
        assertEquals(p,pp);
    }

    /**
     * this test check if the methode tostring work correct compare to the ans we expected to get
     */

    @Test
    void testToString() {
        Point_2D p=new Point_2D (1,2);
        String test =p.toString();
        String ans= "1.0,2.0";
        assertEquals(test,ans);
    }
    /**
     *this test check if the distance methode work successfully compare to the ans we expected to get
     */

    @Test
    void testDistance() {
        double d =p1_2.distance(p4_6);
        assertEquals(d,5,Ex2_Const.EPS);
    }

    /**
     *this test check if two different points return false if not equals and two same points return ture if equals
     */
    @Test
    void testEquals(){
        Point_2D p12= new Point_2D(p1_2);
        Point_2D p46=new Point_2D(p4_6);
        Object p=null;
        assertEquals(p12,p12);
        assertNotEquals(p12,p46);
    }

    /**
     *This method tests the close2equals method of the Point_2D class with close points.
     *  * It creates two Point_2D objects, 'p12' and 'p46', initialized with the coordinates of 'p1_2' and 'p4_6' respectively.
     *  * The method checks if 'p12' is close to 'p46' with a tolerance of 0.1.
     *  * It asserts that the result is false since 'p12' and 'p46' are not close within the defined tolerance.
     *  * Then, it checks if 'p12' is close to itself with a tolerance of 0.1.
     *  * It asserts that the result is true, indicating that 'p12' is close to itself within the specified tolerance.
     */
    @Test
    void testCloseToClose(){
        Point_2D p12= new Point_2D(p1_2);
        Point_2D p46=new Point_2D(p4_6);
        double eps=Ex2_Const.EPS;
        assertFalse(p12.close2equals(p46,0.1));
        assertTrue(p12.close2equals(p12,0.1));
    }

    /**
     *This method tests the vector method of the Point_2D class.
     *  * It creates two Point_2D objects, 'p1' and 'p2', initialized with the coordinates of 'p1_2' and 'p4_6' respectively.
     *  * The method calculates the vector from 'p1' to 'p2' using the vector method.
     *  * A Point_2D object 'ans' is created with the expected vector coordinates (3, 4).
     *  * It asserts that the calculated vector 'test' is equal to the expected vector 'ans',
     *  * confirming that the vector calculation is correct.
     */

    @Test
    void vector() {
        Point_2D p1= new Point_2D(p1_2);
        Point_2D p2 = new Point_2D(p4_6);
        Point_2D ans= new Point_2D(3,4);
        Point_2D test= p1.vector(p2);
        assertEquals(ans,test);
    }

    /**
     *This method tests the move method of the Point_2D class.
     *  * It creates a Point_2D object 'p' initialized with the coordinates of 'p1_2'.
     *  * It also creates a vector Point_2D object 'vec' with coordinates (2, 4).
     *  * The method moves the point 'p' by the vector 'vec' using the move method.
     *  * A Point_2D object 'ans' is created with the expected coordinates after moving (3, 6).
     *  * It asserts that the coordinates of 'p' after the move operation are equal to the expected coordinates 'ans',
     *  * confirming that the move operation was performed correctly.
     *  */
    @Test
    void move(){
        Point_2D p=new Point_2D(p1_2);
        Point_2D vec=new Point_2D(2,4);
        p.move(vec);
        Point_2D ans= new Point_2D(3,6);
        assertEquals(ans,p);
    }
    /**
     ** This method tests the scale method of the Point_2D class.
     *  * It creates a Point_2D object 'p' initialized with the coordinates of 'p4_6'.
     *  * The method scales the point 'p' with respect to the point 'p1_2' and a scale factor of 0.5 using the scale method.
     *  * A Point_2D object 't' is created with the expected scaled coordinates (2.5, 4).
     *  * It asserts that the coordinates of 'p' after scaling are equal to the expected coordinates 't',
     *  * confirming that the scaling operation was performed correctly.
     */

    @Test
    void scale() {
        Point_2D p = new Point_2D(p4_6);
        p.scale(p1_2,0.5);
        Point_2D t = new Point_2D(2.5,4);
        assertEquals(p,t);
    }

    /**
     *This method tests the rotate method of the Point_2D class.
     *  * It creates a Point_2D object 'p' initialized with the coordinates of 'p1_2'.
     *  * The method calculates the initial distance of the point 'p' from the origin.
     *  * Then, it rotates the point 'p' around the origin by an angle of 10 degrees using the rotate method.
     *  * After rotation, it calculates the new distance of the point 'p' from the origin.
     *  * It asserts that the initial distance 'd1' of 'p' is equal to the new distance 'd2' within the defined EPSILON value,
     *  * ensuring that the rotation operation did not change the distance from the origin significantly.
     *  * It also asserts that the rotated point 'p' is not equal to the original point 'p1_2',
     *  * confirming that the rotation operation was performed correctly and changed the point's coordinates.
     *  */
    @Test
    void rotate() {
        Point_2D p = new Point_2D(p1_2);
        double d1= p.distance();
        p.rotate(Point_2D.ORIGIN,10);
        double d2= p.distance();
        assertEquals(d1,d2, Ex2_Const.EPS);
        assertNotEquals(p1_2,p);
    }
}