package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Polygon_2DTest {
    private ArrayList<Point_2D>poly;

    /**
     *This method tests the toString method of the Polygon_2D class.
     *  * It creates a Polygon_2D object 'polygon' and adds three Point_2D objects to it with coordinates (0,0), (1,1), and (2,2).
     *  * The method calls the toString method on the polygon object to get its string representation.
     *  * A string 'ans' is defined with the expected string representation of the polygon containing the coordinates of its vertices.
     *  * It asserts that the string representation of the polygon obtained from toString is equal to the expected string 'ans',
     *  * ensuring that the toString method returns the correct representation of the polygon's vertices.
     */
    @Test
    public void testToString(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(2, 2));
        String ans = "0.0,0.0,1.0,1.0,2.0,2.0";
        assertEquals(ans,polygon.toString());
    }

    /**
     *This method tests the contains method of the Polygon_2D class.
     *  * It creates a Polygon_2D object 'polygon' representing a triangle with vertices at (0,0), (4,0), and (0,4).
     *  * Two Point_2D objects, 'ot' and 'ot2', are created: one inside the polygon and one outside.
     *  * The method checks if the polygon contains the point 'ot' using the contains method.
     *  * It also checks if the polygon contains the point 'ot2'.
     *  * It asserts that the polygon contains 'ot' but does not contain 'ot2',
     *  * ensuring that the contains method correctly identifies points inside and outside the polygon.
     */

    @Test
    public void testContains(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(4, 0));
        polygon.add(new Point_2D(0, 4));

        Point_2D ot=new Point_2D(1,1.4);
        Point_2D ot2=new Point_2D(0,-2);

        assertTrue(polygon.contains(ot));
        assertFalse(polygon.contains(ot2));
    }

    /**
     *This method tests the area method of the Polygon_2D class.
     *  * It creates a Polygon_2D object 'polygon' representing a square with vertices at (0,0), (0,2), (2,2), and (2,0).
     *  * The method calculates the area of the polygon using the area method.
     *  * A double 'ans' is defined with the expected area value (4.0) of the square.
     *  * It asserts that the area calculated by the polygon object is equal to the expected area 'ans',
     *  * ensuring that the area method returns the correct area of the polygon.
     */
    @Test
    public void testArea(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 2));
        polygon.add(new Point_2D(2, 2));
        polygon.add(new Point_2D(2, 0));

        double ans=4.0;
        double test=polygon.area();
        assertEquals(ans,test);
    }

    /**
     ** This method tests the perimeter method of the Polygon_2D class.
     *  * It creates a Polygon_2D object 'polygon' representing a square with vertices at (0,0), (0,2), (2,2), and (2,0).
     *  * The method calculates the perimeter of the polygon using the perimeter method.
     *  * A double 'ans' is defined with the expected perimeter value (8.0) of the square.
     *  * It asserts that the perimeter calculated by the polygon object is equal to the expected perimeter 'ans',
     *  * ensuring that the perimeter method returns the correct perimeter of the polygon.
     */
    @Test
    public void testPerimeter(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 2));
        polygon.add(new Point_2D(2, 2));
        polygon.add(new Point_2D(2, 0));

        double ans=8.0;
        double test=polygon.perimeter();
        assertEquals(ans,test);
    }

    /**
     *This method tests the translate method of the Polygon_2D class.
     *  * It creates a Polygon_2D object 'polygon' representing a square with vertices at (0,0), (0,2), (2,2), and (2,0).
     *  * A Point_2D object 'trans' is created representing the translation vector (2,7).
     *  * The method translates the polygon by the translation vector.
     *  * Four Point_2D objects 'ans1', 'ans2', 'ans3', and 'ans4' are created representing the expected coordinates of the translated vertices.
     *  * The method retrieves the vertices of the translated polygon using the getAllPoints method.
     *  * It asserts that each vertex of the translated polygon matches its corresponding expected vertex,
     *  * ensuring that the translate method correctly translates the polygon.
     */
    @Test
    public void testTranslate(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 2));
        polygon.add(new Point_2D(2, 2));
        polygon.add(new Point_2D(2, 0));

        Point_2D trans=new Point_2D(2,7);

        polygon.translate(trans);
        Point_2D ans1=new Point_2D(2,7);
        Point_2D ans2=new Point_2D(2,9);
        Point_2D ans3=new Point_2D(4,9);
        Point_2D ans4=new Point_2D(4,7);
        Point_2D[] real = polygon.getAllPoints();

        assertEquals(ans1,real[0]);
        assertEquals(ans2,real[1]);
        assertEquals(ans3,real[2]);
        assertEquals(ans4,real[3]);
    }
    /**
     *This method tests the copy method of the Polygon_2D class.
     *  * It creates a Polygon_2D object 'polygon' representing a square with vertices at (0,0), (0,2), (2,2), and (2,0).
     *  * The method invokes the copy method on the 'polygon' object.
     *  * Four Point_2D objects 'ans1', 'ans2', 'ans3', and 'ans4' are created representing the expected coordinates of the copied vertices.
     *  * The method retrieves the vertices of the copied polygon using the getAllPoints method.
     *  * It asserts that each vertex of the copied polygon matches its corresponding expected vertex,
     *  * ensuring that the copy method correctly creates a deep copy of the polygon.
     */
    @Test
    public void testCopy(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 2));
        polygon.add(new Point_2D(2, 2));
        polygon.add(new Point_2D(2, 0));

        polygon.copy();

        Point_2D ans1=new Point_2D(0,0);
        Point_2D ans2=new Point_2D(0,2);
        Point_2D ans3=new Point_2D(2,2);
        Point_2D ans4=new Point_2D(2,0);

        Point_2D[] real = polygon.getAllPoints();
        assertEquals(ans1,real[0]);
        assertEquals(ans2,real[1]);
        assertEquals(ans3,real[2]);
        assertEquals(ans4,real[3]);
    }

    /**
     *This method tests the scale method of the Polygon_2D class.
     *  * It creates a Polygon_2D object 'polygon' representing a quadrilateral with vertices at (1,1), (3,2), (5,4), and (3,1).
     *  * The method invokes the scale method on the 'polygon' object, scaling it by a factor of 2 with respect to the center point (1,1).
     *  * Four Point_2D objects 'real' are created to store the coordinates of the scaled vertices.
     *  * The method retrieves the scaled vertices of the polygon using the getAllPoints method.
     *  * It asserts that each vertex of the scaled polygon matches its expected coordinates after scaling, ensuring that the scale operation is correctly applied to the polygon.
     *  */
    @Test
    public void testScale(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(3, 2));
        polygon.add(new Point_2D(5, 4));
        polygon.add(new Point_2D(3, 1));

        double ratio= 2.0;
        Point_2D center = new Point_2D(1, 1);
        polygon.scale(center,ratio);

        Point_2D[] real=polygon.getAllPoints();

        assertEquals(1.0, real[0].x(), Ex2_Const.EPS);
        assertEquals(1.0, real[0].y(), Ex2_Const.EPS);
        assertEquals(5.0, real[1].x(), Ex2_Const.EPS);
        assertEquals(3.0, real[1].y(), Ex2_Const.EPS);
        assertEquals(9.0, real[2].x(), Ex2_Const.EPS);
        assertEquals(7.0, real[2].y(), Ex2_Const.EPS);
        assertEquals(7.0, real[2].y(), Ex2_Const.EPS);
    }

    /**
     *This method tests the rotate method of the Polygon_2D class.
     *  * It creates a Polygon_2D object 'polygon' representing a quadrilateral with vertices at (1,1), (3,2), (5,4), and (3,1).
     *  * The method invokes the rotate method on the 'polygon' object, rotating it by 90 degrees counterclockwise around the center point (1,1).
     *  * Four Point_2D objects 'real' are created to store the coordinates of the rotated vertices.
     *  * The method retrieves the rotated vertices of the polygon using the getAllPoints method.
     *  * It asserts that each vertex of the rotated polygon matches its expected coordinates after rotation, ensuring that the rotate operation is correctly applied to the polygon.
     *  */
    @Test
    public void testRotate(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(3, 2));
        polygon.add(new Point_2D(5, 4));
        polygon.add(new Point_2D(3, 1));

        double angleDegrees=90;
        Point_2D center =new Point_2D(1,1);

        polygon.rotate(center,angleDegrees);
        Point_2D[] real=polygon.getAllPoints();

        assertEquals(1.0, real[0].x(), Ex2_Const.EPS);
        assertEquals(1.0, real[0].y(), Ex2_Const.EPS);
        assertEquals(0.0, real[1].x(), Ex2_Const.EPS);
        assertEquals(3.0, real[1].y(), Ex2_Const.EPS);
        assertEquals(-2.0, real[2].x(),Ex2_Const.EPS);
        assertEquals(5.0, real[2].y(), Ex2_Const.EPS);
    }
}
