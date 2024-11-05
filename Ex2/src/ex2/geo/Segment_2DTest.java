package ex2.geo;
import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Segment_2DTest {
    private Segment_2D s1 =new
            Segment_2D(Point_2D.ORIGIN,new Point_2D(0,1));
    private Point_2D p1 =new Point_2D(1,0);
    private Point_2D p2=new Point_2D(5,3);

    private Segment_2D s2 =new Segment_2D(p1,p2);

    /**
     *This method tests the toString method of the Segment_2D class.
     *  * It creates a Segment_2D object 's' representing a line segment between two points 'p1' and 'p2'.
     *  * The method invokes the toString method on the 's' object.
     *  * It constructs the expected string representation 'ans' by concatenating the string representations of the points 'p1' and 'p2'.
     *  * Finally, the method compares the actual string representation 'test' returned by the toString method with the expected string 'ans' using the assertEquals method.
     *  * This ensures that the toString method of the Segment_2D class correctly formats the segment's string representation.
     */
    @Test
    public void testToString(){
        Segment_2D s= new Segment_2D (p1,p2);
        String test =s.toString();
        String ans= p1.toString()+","+p2;
        assertEquals(test,ans);
    }

    /**
     *This method tests the isVertical method of the Segment_2D class.
     *  * It creates two Segment_2D objects 's' and 'a' representing line segments between points 'p1' and 'p2', and 'p3' and 'p2' respectively.
     *  * The method verifies that the isVertical method returns false for segment 's', which is not vertical, and true for segment 'a', which is vertical.
     *  * This ensures that the isVertical method correctly identifies whether a segment is vertical or not.
     */
    @Test
    public void testIsVertical(){
        Segment_2D s= new Segment_2D (p1,p2);
        assertFalse(s.isVertical());
        Point_2D p3=new Point_2D(5,1);
        Segment_2D a= new Segment_2D (p3,p2);
        assertTrue(a.isVertical());
    }

    /**
     *This method tests the perimeter calculation functionality of the Segment_2D class.
     *  * It calculates the perimeter of two segments, 's1' and 's2', and compares the results with expected values.
     *  * For 's1' the expected perimeter is 2.
     *  * For 's2' the expected perimeter is 10.
     *  * The method asserts that the calculated perimeters match the expected values within a certain epsilon threshold defined by Ex2_Const.EPS.
     *  * It also asserts that the perimeter of 's2' is not equal to 8
     */
    @Test
    public void testPerimeter(){
        double p = s1.perimeter();
        assertEquals(p,2,Ex2_Const.EPS);
        p=s2.perimeter();
        assertEquals(p, 10,Ex2_Const.EPS);
        assertNotEquals(p,8,Ex2_Const.EPS);
    }

    /**
     *This method tests the area calculation functionality of the Segment_2D class.
     *  * It calculates the area of two segments, 's1' and 's2', and compares the results with expected values.
     *  * The method asserts that the calculated areas match the expected values within a certain epsilon threshold defined by Ex2_Const.EPS.
     *  * It also asserts that the area of 's2' is not equal to 7, ensuring a differentiation between the expected and actual results.
     *  */

    @Test
    public void testArea(){
        double p = s1.area();
        assertEquals(p,2,Ex2_Const.EPS);
        p=s2.area();
        assertEquals(p, 10,Ex2_Const.EPS);
        assertNotEquals(p,7,Ex2_Const.EPS);
    }

    /**
     *This method tests the contains functionality of the Segment_2D class.
     *  * It checks whether certain points are contained within the segments 's1' and 's2'.
     *  * For 's1', it tests points that lie on the segment and points that are outside the segment.
     *  * For 's2', it tests points that lie on the segment and points that are outside the segment.
     *  * The method asserts that points lying on 's1' are contained within it, while points lying outside 's1' are not contained.
     *  * Similarly, it asserts that points lying on 's2' are contained within it, while points lying outside 's2' are not contained.
     */
    @Test
    public void testContains(){
        Point_2D q0=new Point_2D(0,0.3);
        boolean b1=s1.contains(q0);
        assertTrue(b1);

        q0=new Point_2D(0,1.3);
        b1=s1.contains(q0);
        assertFalse(b1);

        q0=new Point_2D(3,1.5);
        b1=s2.contains(q0);
        assertTrue(b1);

        q0=new Point_2D(2.8,1.5);
        b1=s2.contains(q0);
        assertFalse(b1);
    }

    /**
     *This method tests the translation functionality of the Segment_2D class.
     *  * It creates a segment 'segment' with endpoints 'p1' and 'p2'. Then, it translates the segment
     *  * by the vector represented by the point 'translation'.
     *  * After the translation, it checks whether the endpoints of the segment have been correctly
     *  * translated to their new positions.
     *  * The method asserts that the translated endpoints match the expected new positions.
     */
    @Test
    public void testTranslation(){
        Segment_2D segment = new Segment_2D(p1, p2);
        Point_2D translation = new Point_2D(2, 3);
        segment.translate(translation);
        Point_2D ans1= new Point_2D(3,3);
        Point_2D ans2= new Point_2D(7,6);
        assertEquals(ans1,segment.get_p1());
        assertEquals(ans2,segment.get_p2());
    }

    /**
     *This method tests the copy functionality of the Segment_2D class.
     *  * It creates an original segment 'original' with endpoints 'p1' and 'p2'.
     *  * Then, it creates a copy of the original segment using the copy method.
     *  * The method asserts that the copy is not the same object reference as the original segment.
     *  * It also checks whether the endpoints of the copied segment match the endpoints of the original segment.
     */
    @Test
    public void testCopy(){
        Segment_2D original = new Segment_2D(p1, p2);

        Segment_2D copy = (Segment_2D) original.copy();
        assertNotSame(original, copy);
        assertEquals(original.get_p1(), copy.get_p1());
        assertEquals(original.get_p2(), copy.get_p2());
    }

    /**
     *This method tests the scale functionality of the Segment_2D class.
     *  * It creates a segment 'segment' with endpoints 'p1' and 'p2'.
     *  * Then, it scales the segment using the scale method with a given ratio and center point.
     *  * The method asserts that the endpoints of the scaled segment match the expected endpoints.
     */
    @Test
    public void testScale(){

            Point_2D p1 = new Point_2D(1, 1);
            Point_2D p2= new Point_2D(3, 4);
            Segment_2D segment =new Segment_2D(p1, p2);
            double ratio= 2.0;
            Point_2D center = new Point_2D(2, 2);
            segment.scale(center,ratio);// Scale the segment

            Point_2D expectedP1 =new Point_2D(0, 0); // Expected endpoints after scaling
            Point_2D expectedP2 =new Point_2D(4, 6);

            assertEquals(expectedP1,segment.get_p1());
            assertEquals(expectedP2, segment.get_p2());
    }

    /**
     *This method tests the rotate functionality of the Segment_2D class.
     *  * It creates a segment 's' with endpoints 'p1' and 'p2'.
     *  * Then, it rotates the segment around the given center point by the specified angle in degrees.
     *  * The method asserts that the rotated endpoints of the segment match the expected endpoints within a small epsilon value.
     */
    @Test
    public void testRotate(){
        Point_2D p1=new Point_2D(1,-2);
        Point_2D p2= new Point_2D(3,-2);
        double angleDegrees=90;
        Point_2D center =new Point_2D(2,-2);

        Segment_2D s=new Segment_2D(p1,p2);
        s.rotate(center,angleDegrees);

        Point_2D expected1=new Point_2D(2,-3);
        Point_2D expected2=new Point_2D(2,-1);
        assertTrue(s.get_p1().close2equals(expected1,Ex2_Const.EPS));
        assertTrue(s.get_p2().close2equals(expected2,Ex2_Const.EPS));
    }

    /**
     ** This method tests the equality check functionality of the Segment_2D class.
     *  * It creates two segments 'seg1' and 'seg2' with the same endpoints 'p1' and 'p2'.
     *  * The method asserts that 'seg1' is equal to 'seg2'.
     *  * Then, it creates another segment 'seg3' with different endpoint 'p3'.
     *  * The method asserts that 'seg1' is not equal to 'seg3'.
     */
    @Test
    public void testEquals(){

        Segment_2D seg1 = new Segment_2D(p1, p2);
        Segment_2D seg2 = new Segment_2D(p1, p2);

        assertEquals(seg1,seg2);

        Point_2D p3 = new Point_2D(2, 2);
        Segment_2D seg3 = new Segment_2D(p1, p3);

        assertNotEquals(seg1,seg3);
    }
}
