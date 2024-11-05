package ex2.geo;
import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Circle_2DTest {
    /**
     * This method tests the toString method of the Circle_2D class.
     *  * It creates a Point_2D object 'center' representing the center of the circle,
     *  * and a double variable 'radius' representing the radius of the circle.
     *  * A Circle_2D 'c' is created using the 'center' and 'radius'.
     *  * The toString() method is called on the Circle_2D object to obtain its string representation.
     *  * An expected string representation 'ans' is constructed by concatenating the string representations of 'center' and 'radius'.
     *  * Finally, it asserts that the obtained string representation matches the expected string representation.
     */
    @Test
    public void testToString(){
        Point_2D center = new Point_2D (1,9);
        double radius= 5.0;
        Circle_2D c=new Circle_2D(center,radius);
        String test =c.toString();
        String ans= center.toString()+", "+radius;

        assertEquals(test,ans);
    }

    /**
     *This method tests the contains method of the Circle_2D class.
     *  * It creates a Circle_2D object 'circle1' with a specified center and radius.
     *  * Two Point_2D objects, 'insidePoint' and 'outsidePoint', are created.
     *  * 'insidePoint' lies within the circle, and 'outsidePoint' lies outside the circle.
     *  * The contains method is called on 'circle1' with both 'insidePoint' and 'outsidePoint' as arguments.
     *  * It asserts that the contains method returns true when called with 'insidePoint',
     *  * indicating that 'insidePoint' lies within the circle.
     *  * It also asserts that the contains method returns false when called with 'outsidePoint',
     *  * indicating that 'outsidePoint' lies outside the circle.
     */

    @Test
    public void testContains(){
        Point_2D center= new Point_2D(0, 0);
        double radius = 3.0;
        Circle_2D circle1 = new Circle_2D(center, radius);

        Point_2D insidePoint = new Point_2D(1, 1);
        Point_2D outsidePoint = new Point_2D(4, 4);
        assertTrue(circle1.contains(insidePoint));
        assertFalse(circle1.contains(outsidePoint));
    }

    /**
     *This method tests the equals method of the Circle_2D class.
     *  * It creates three Circle_2D objects: 'circle1', 'circle2', and 'circle3', each with a different center point.
     *  * 'circle1' and 'circle2' have the same center point and radius, while 'circle3' has a different center point but the same radius as 'circle1'.
     *  * The equals method is called to check if 'circle1' is equal to 'circle2', which should return true since they have the same center and radius.
     *  * It asserts that the result is true.
     *  * Then, the equals method is called to check if 'circle1' is equal to 'circle3', which should return false since they have different center points.
     *  * It asserts that the result is false.
     */
    @Test
    public void testEquals() {
        Point_2D center1 = new Point_2D(0, 0);
        Circle_2D circle1 = new Circle_2D(center1, 5);
        Point_2D center2 = new Point_2D(0, 0);
        Circle_2D circle2 = new Circle_2D(center2, 5);
        Point_2D center3 = new Point_2D(1, 1);
        Circle_2D circle3 = new Circle_2D(center3, 5);

        assertEquals(circle1,circle2);//check if the circles is the same
        assertNotEquals(circle1,circle3);//check if the circles is different
    }

    /**
     *This method tests the area method of the Circle_2D class.
     *  * It creates a Circle_2D object 'c3' with a specified center point and radius.
     *  * The area method is called on 'c3' to calculate its area.
     *  * It asserts that the calculated area matches the expected area of a circle with the given radius,
     *  * which is 4π square units.
     */

    @Test
    public void testArea(){
        Point_2D p=new Point_2D(0,0);
        double _rad=2.0;
        Circle_2D c3=new Circle_2D(p,_rad);

        double erea = c3.area();
        assertEquals(4*Math.PI,erea,Ex2_Const.EPS);
    }

    /**
     ** This method tests the perimeter method of the Circle_2D class.
     *  * It creates a Circle_2D object 'c3' with a specified center point and radius.
     *  * The perimeter method is called on 'c3' to calculate its perimeter (circumference).
     *  * It asserts that the calculated perimeter matches the expected perimeter of a circle with the given radius,
     *  * which is 2π times the radius.
     */

    @Test
    public void testPerimeter(){
        Point_2D p=new Point_2D(0,0);
        double _rad=2.0;
        Circle_2D c3=new Circle_2D(p,_rad);
        double perimeterTest = c3.perimeter();
        assertEquals(4*Math.PI, perimeterTest, Ex2_Const.EPS);

    }

    /**
     * This method tests the translate method of the Circle_2D class.
     * It creates a Circle_2D object 'c3' with a specified center point and radius.
     *  A translation vector 'trans' is defined with coordinates (2, 7).
     * The translate method is called on 'c3' to translate its center point by the translation vector.
     * It asserts that the center point of the circle after translation matches the expected center point,
     * which is the original center point (0, 0) plus the translation vector (2, 7).
     */
    @Test
    public void testTranslate(){

        Point_2D center = new Point_2D(0,0);
        double _rad=1.0;
        Circle_2D c3=new Circle_2D(center,_rad);
        Point_2D trans=new Point_2D(2,7);

        c3.translate(trans);
        Point_2D ans=new Point_2D(2,7);

        assertEquals(ans,c3.getCenter());
    }

    /**
     * This method tests the copy method of the Circle_2D class.
     *  * It creates a Circle_2D object 'c3' with a specified center point and radius.
     *  * The copy method is called on 'c3' to create a copy of the circle.
     *  * A Circle_2D object 'test' is created with the same parameters as the original circle.
     *  * It asserts that the copied circle 'c3' is equal to the original circle 'test',
     *  * indicating that the copy operation was successful.
     */

    @Test
    public void testCopy(){
        Point_2D p = new Point_2D(0,0);
        double _rad=1.0;
        Circle_2D c3=new Circle_2D(p,_rad);
        c3.copy();
        Circle_2D test=  new Circle_2D(p,1.0);
        assertEquals(c3,test);
    }

    /**
     * This method tests the scale method of the Circle_2D class.
     * It creates a Circle_2D object 'c3' with a specified center point and radius.
     * The scale method is called on 'c3' to scale the circle with respect to a given center point and scaling factor.
     * Two Circle_2D objects 'test' and 'test2' are created with the same center point as the original circle 'c3',
     * but with different radii based on the scaling factor.
     * It asserts that the scaled circle 'c3' is equal to the circle with the expected scaled radius ('test'),
     * indicating that the scaling operation was successful.
     * It also asserts that 'c3' is not equal to the circle with a different scaled radius ('test2'),
     * ensuring that the scaling operation is correctly applied.
     */
    @Test
    public void testScale(){
        Point_2D p = new Point_2D(0,0);
        double _rad=1.0;
        Circle_2D c3=new Circle_2D(p,_rad);
        c3.scale(p,0.9);

        Circle_2D test= new Circle_2D(p,0.9);
        Circle_2D test2= new Circle_2D(p,1.1);
        assertEquals(c3,test);
        assertNotEquals(c3,test2);
    }

    /**
     *This method tests the rotate method of the Circle_2D class.
     *  * It creates a Circle_2D object 'c3' with a specified center point and radius.
     *  * The rotate method is called on 'c3' to rotate the circle around a given center point by a specified angle.
     *  * A Circle_2D object 'test' is created with the same parameters as the original circle 'c3'.
     *  * It asserts that the rotated circle 'c3' is equal to the original circle 'test',
     *  * indicating that the rotation operation did not affect the circle's properties.
     */
    @Test
    public void testRotate(){
        Point_2D p = new Point_2D(0,0);
        double _rad=1.0;
        Circle_2D c3=new Circle_2D(p,_rad);
        c3.rotate(p,70);
        Circle_2D test= new Circle_2D(p,1.0);
        assertEquals(c3,test);
    }
}
