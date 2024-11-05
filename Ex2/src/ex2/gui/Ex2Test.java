package ex2.gui;

import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {
    /**
     *This method tests the initialization process of the Ex2 class.
     *  * It initializes an instance of the Ex2 class and creates a GUI_Shape_Collection object.
     *  * Two shapes, a circle and a segment, are created and added to the collection.
     *  * The Ex2 instance is then initialized with this collection.
     *  * The method verifies that the initialized collection matches the original collection in terms of shape properties such as color and fill status.
     *  * It also checks if the size and individual elements of both collections are equal.
     */
    @Test
    void init() {
        Ex2 ex2 = Ex2.getInstance();

        GUI_Shape_Collection shapeCollection = new ShapeCollection();

        Point_2D p =new Point_2D(2,4);
        Point_2D p2=new Point_2D(3,5);
        Circle_2D c =new Circle_2D(p, 3.4);
        Segment_2D s=new Segment_2D(p,p2);
        GUIShape circle= new GUIShape(c,false, Color.gray,2);
        GUIShape segment= new GUIShape(s,false, Color.blue,1);
        shapeCollection.add(circle);
        shapeCollection.add(segment);

        ex2.init(shapeCollection);

        GUI_Shape_Collection initCollection = ex2.getShape_Collection();


        for (int i = 0; i < shapeCollection.size(); i++) {
            GUI_Shape originalShape = shapeCollection.get(i);
            GUI_Shape initializedShape = initCollection.get(i);

            assertEquals(originalShape.getColor(), initializedShape.getColor());
            assertEquals(originalShape.isFilled(), initializedShape.isFilled());
        }
        assertEquals(shapeCollection.size(), initCollection.size());
        assertEquals(shapeCollection.get(0),initCollection.get(0));
        assertEquals(shapeCollection.get(1),initCollection.get(1));
    }

    /**
     *This method tests the retrieval of the shape collection from the Ex2 instance.
     *  * It creates an instance of the Ex2 class and a GUI_Shape_Collection object.
     *  * Two shapes, a circle and a segment, are created and added to the collection.
     *  * The Ex2 instance is initialized with this collection.
     *  * The method retrieves the shape collection using the getShape_Collection method from the Ex2 instance.
     *  * It then compares each shape in the retrieved collection with the corresponding shape in the original collection.
     *  * The test ensures that each shape is correctly retrieved from the Ex2 instance.
     */
    @Test
    void getShape_Collection() {
        GUI_Shape_Collection shapeCollection = new ShapeCollection();
        Ex2 ex2 = Ex2.getInstance();

        Point_2D p =new Point_2D(2,4);
        Point_2D p2=new Point_2D(3,5);
        Circle_2D c =new Circle_2D(p, 3.4);
        Segment_2D s=new Segment_2D(p,p2);
        GUIShape circle= new GUIShape(c,false, Color.gray,2);
        GUIShape segment= new GUIShape(s,false, Color.blue,1);
        shapeCollection.add(circle);
        shapeCollection.add(segment);

        ex2.init(shapeCollection);
        GUI_Shape_Collection Collection = ex2.getShape_Collection();


        for (int i = 0; i < shapeCollection.size(); i++) {

            GUI_Shape originalShape = shapeCollection.get(i);
            GUI_Shape retrievedShape = Collection.get(i);
            assertEquals(originalShape, retrievedShape);
        }
    }

    /**
     *This method tests the retrieval of information about the shapes in the Ex2 instance.
     *  * It creates an instance of the Ex2 class and a ShapeCollection object.
     *  * Two circles are created and added to the collection with different properties (filled and unfilled).
     *  * The Ex2 instance is initialized with this collection.
     *  * The method retrieves information about the shapes in the Ex2 instance using the getInfo method.
     *  * It then checks if the retrieved information contains expected details about the shapes, such as their type, fill status, tag, and color.
     *  * The test ensures that the getInfo method returns correct information about the shapes.
     */

    @Test
    void getInfo() {
        Ex2 ex2 = Ex2.getInstance();
        ShapeCollection shapeCollection=new ShapeCollection();

        Point_2D p1 = new Point_2D(1, 2);
        Circle_2D c1 = new Circle_2D(p1, 3);
        GUIShape circle1 = new GUIShape(c1, true, Color.red, 1);
        Circle_2D c2 = new Circle_2D(p1, 2);
        GUIShape circle2 = new GUIShape(c2, false, Color.black, 2);
        shapeCollection.add(circle1);
        shapeCollection.add(circle2);

        ex2.init(shapeCollection);
        String info = ex2.getInfo();
        System.out.println(ex2.getInfo());

        assertNotNull(info);

        assertTrue(info.contains("Circle"));
        assertTrue(info.contains("true"));
        assertTrue(info.contains("1"));
        assertTrue(info.contains("2"));
        assertTrue(info.contains("16711680"));

    }
}