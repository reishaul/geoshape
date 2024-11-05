package ex2.gui;

import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import org.junit.jupiter.api.Test;

import javax.swing.text.Segment;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GUIShapeTest {
    private Point_2D p1=new Point_2D(7,3);
    private Point_2D p2=new Point_2D(5,1);
    private Circle_2D c=new Circle_2D(p1,9);
    private Segment_2D seg=new Segment_2D(p1,p2);
    private boolean f= false;
    private boolean t= true;
    private Color color1=Color.blue;
    private Color color2=Color.black;
    private GUI_Shape circle= new GUIShape(c,f,color1,4);
    private GUI_Shape segment= new GUIShape(seg,t,color2,1);
    ShapeCollection shapeCollection=new ShapeCollection();

    /**
     *Test case to verify the string representation of the shape returned by the `getShape()` method.
     *  * This test ensures that the `getShape()` method returns the correct string representation of the shape.
     *  * The expected string representation is compared against the actual string representation obtained from `getShape().toString()`.
     */
    @Test
    void testgetShape(){
        String ans= "7.0,3.0, 9.0";
        assertEquals(ans,circle.getShape().toString());
    }

    /**
     *This test verifies that the `setShape()` method correctly sets a new shape for the GUIShape object.
     * The test sets a new Circle_2D shape for the GUIShape object, and then checks if the shape has been updated correctly.
     */
    @Test
    void testSetShape(){
        Point_2D p1=new Point_2D(7,3);
        Circle_2D newc=new Circle_2D(p1,2);
        circle.setShape(newc);
        String ans="7.0,3.0, 2.0";
        assertEquals(ans,circle.getShape().toString());
    }

    /**
     *This test verifies that the `isFilled()` method correctly returns the fill status of the GUIShape object.
     * The test checks the fill status of two different shapes: `circle` and `segment`.
     */
    @Test
    void testIsFilled(){
        assertFalse(circle.isFilled());
        assertTrue(segment.isFilled());
    }

    /**
     *This test verifies that the `setFilled()` method correctly updates the fill status of the GUIShape object.
     *   The test sets the fill status of `circle` to true using `setFilled(true)` and checks if the fill status has been updated correctly.
     *  */
    @Test
    void tsetSetFilled(){
        circle.setFilled(true);
        assertTrue(circle.isFilled());
    }

    /**
     *This test verifies that the `getColor()` method correctly returns the color of the GUIShape object.
     * The test checks if the color of `circle` matches the expected color (Color.BLUE).
     */
    @Test
    void testGetColor(){
        Color color=Color.BLUE;
        assertEquals(color,circle.getColor());
    }
    /**
     *This test verifies that the `setColor()` method correctly updates the color of the GUIShape object.
     *  * The test sets the color of `segment` to Color.CYAN using `setColor()` and checks if the color has been updated correctly.
     */
    @Test
    void testSetColor(){
        segment.setColor(Color.CYAN);
        Color color=Color.CYAN;
        assertEquals(color, segment.getColor());
    }

    /**
     *This test verifies that the `getTag()` method correctly returns the tag of the GUIShape object.
     *The test checks if the tag of `circle` matches the expected value (4).
     */
    @Test
    void testGetTag(){
        int tag= 4;
        assertEquals(tag,circle.getTag());
    }

    /**
     *This test verifies that the `setTag()` method correctly updates the tag of the GUIShape object.
     *The test sets the tag of `segment` to 7 using `setTag()` and checks if the tag has been updated correctly.
     */
    @Test
    void testSetTag(){
        segment.setTag(7);
        int tag=7;
        assertEquals(tag, segment.getTag());
    }

    /**
     *This test verifies that the `copy()` method correctly creates a copy of the shape collection.
     * The test adds `circle` and `segment` to a shape collection, creates a copy of the collection using `copy()`,
     * and checks if the copied collection is equal to the original one.
     */
    @Test
    void testCopy(){
        shapeCollection.add(circle);
        shapeCollection.add(segment);
        assertEquals(shapeCollection.toString(),shapeCollection.copy().toString());
    }

    /**
     *This test verifies that the`toString()` method correctly returns the string representation of the shape collection.
     *The test adds `circle` to a shape collection, and checks if the string representation of the collection matches the expected string.
     */
    @Test
    void testToString(){
        shapeCollection.add(circle);
        String ans="GUIShape,255,false,4,Circle_2D,7.0,3.0, 9.0";
        assertEquals(ans,shapeCollection.toString());
    }

    /**
     *This test verifies that the `isSelected()` method correctly returns the selection status of the GUIShape object.
     *The test checks if the selection status of `circle` is initially false.
     */
    @Test
    void testIsSelected(){
        assertFalse(circle.isSelected());
    }

    /**
     *This test verifies that the `setSelected()` method correctly updates the selection status of the GUIShape object.
     *The test sets the selection status of `circle` to true using `setSelected(true)` and checks if the selection status has been updated correctly.
     */
    @Test
    void testSetSelected(){
        circle.setSelected(true);
        assertTrue(circle.isSelected());
    }
}