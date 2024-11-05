package ex2.geo;

import ex2.ex2.Ex2_Const;
import ex2.ex2.ShapeCollection;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeCompTest {
    /**
     * This method tests the comparison functionality of the ShapeComp class.
     *  * It creates a collection of shapes and defines several GUIShape objects: circle, segment, and triangle.
     *  * Then, it creates ShapeComp objects with different comparison criteria: Sort_By_toString, Sort_By_Tag, and Sort_By_Perimeter.
     *  * The method asserts the comparison results between different pairs of GUIShape objects based on the specified comparison criteria.
     *  */
    @Test
    public void testShapeComp(){
        Point_2D p1=new Point_2D(0,2);
        Point_2D p2=new Point_2D(0,0);
        Point_2D p3=new Point_2D(5,7);
        ShapeCollection shapeCollection=new ShapeCollection();
        Circle_2D c= new Circle_2D(p1,4.0);
        GUIShape circle = new GUIShape(c, false, Color.red, 1);
        Segment_2D seg= new Segment_2D(p1,p2);
        GUIShape segment = new GUIShape(seg, false, Color.green, 2);
        Triangle_2D tri=new Triangle_2D(p1,p2,p3);
        GUIShape triangle= new GUIShape(tri, true, Color.black, 3);


        ShapeComp comp = new ShapeComp(Ex2_Const.Sort_By_toString);
        int test=comp.compare(circle, triangle);

        assertEquals(1, test);
        assertNotEquals(-1,test);

        ShapeComp comp2 = new ShapeComp(Ex2_Const.Sort_By_Tag);
        int test2=comp2.compare(circle, segment);

        assertEquals(-1, test2);
        assertNotEquals(1,test2);


        ShapeComp comp3 = new ShapeComp(Ex2_Const.Sort_By_Perimeter);
        int test3=comp3.compare(circle, segment);

        assertEquals(1, test3);
        assertNotEquals(-1,test3);

    }
}
