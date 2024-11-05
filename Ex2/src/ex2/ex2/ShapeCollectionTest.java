package ex2.ex2;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeCollectionTest {

    /**
     *This method tests the retrieval of a specific shape from an ArrayList of shapes.
     *  * It creates two Circle_2D objects, c1 and c2, each representing a circle with a center point and radius.
     *  * Then, it creates GUIShape objects, C1 and C2, using the Circle_2D objects, specifying additional properties like fill status and color.
     *  * The method adds c1 and c2 to an ArrayList of Circle_2D objects, 'shape'.
     *  * It then retrieves the second shape from the ArrayList and converts it to a string representation.
     *  * The expected string 'a' represents the center coordinates and radius of the second circle, c2.
     *  * Finally, it asserts that the obtained string representation of the second shape matches the expected string.
     */
    @Test
    public void testGet(){
        Point_2D p1 = new Point_2D(1, 2);
        Circle_2D c1 = new Circle_2D(p1, 3);
        GUIShape C1 = new GUIShape(c1, true, Color.red, 1);
        Circle_2D c2 = new Circle_2D(p1, 2);
        GUIShape C2 = new GUIShape(c2, false, Color.black, 2);
        ArrayList<Circle_2D> shape = new ArrayList<>();
        shape.add(c1);
        shape.add(c2);
        String a="1.0,2.0, 2.0";
        assertEquals(a, shape.get(1).toString());
    }

    /**
     *This method tests the calculation of the size (number of shapes) in a ShapeCollection.
     *  * It creates two Circle_2D objects, c1 and c2, each representing a circle with a center point and radius.
     *  * Then, it creates GUIShape objects, C1 and C2, using the Circle_2D objects, specifying additional properties like fill status and color.
     *  * The method adds C1 and C2 to the ShapeCollection.
     *  * It retrieves the size of the ShapeCollection using the size() method.
     *  * Finally, it asserts that the obtained size matches the expected size.
     */

    @Test
    public void testSize(){
        Point_2D p1 = new Point_2D(1, 2);
        Circle_2D c1 = new Circle_2D(p1, 3);
        GUIShape C1 = new GUIShape(c1, true, Color.red, 1);
        Circle_2D c2 = new Circle_2D(p1, 3);
        GUIShape C2 = new GUIShape(c2, false, Color.black, 2);
        ShapeCollection shapeCollection=new ShapeCollection();

        shapeCollection.add(C1);
        shapeCollection.add(C2);
        int ans=2;
        int test= shapeCollection.size();
        assertEquals(ans,test);
    }

    /**
     *  This method tests the removal of an element at a specified index from an ArrayList.
     *  * It creates two Circle_2D objects, c1 and c2, each representing a circle with a center point and radius.
     *  * Then, it creates GUIShape objects, C1 and C2, using the Circle_2D objects, specifying additional properties like fill status and color.
     *  * It adds c1 and c2 to the 'shape' ArrayList.
     *  * The method removes the element at index 1 from the 'shape' ArrayList.
     *  * After removal, it asserts that the size of the 'shape' ArrayList is 1.
     */

    @Test
    public void testRemoveElementAt() {
        Point_2D p1 = new Point_2D(1, 2);
        Circle_2D c1 = new Circle_2D(p1, 3);
        GUIShape C1 = new GUIShape(c1, true, Color.red, 1);
        Circle_2D c2 = new Circle_2D(p1, 2);
        GUIShape C2 = new GUIShape(c2, false, Color.black, 2);
        ArrayList<Circle_2D> shape = new ArrayList<>();
        shape.add(c1);
        shape.add(c2);
        shape.remove(1);
        assertEquals(1, shape.size());
    }

    /**
     * This method tests the addition of a shape at a specified index in a ShapeCollection.
     *  * It creates a ShapeCollection object to store graphical shapes.
     *  * Then, it creates three Circle_2D objects, c1, c2, and c3, each representing a circle with a center point and radius.
     *  * GUIShape objects, circle1, circle2, and circle3, are created using the Circle_2D objects,
     *  * specifying additional properties like fill status and color.
     *  * Next, it adds circle1 at index 0 in the ShapeCollection and verifies that it is added at the correct index.
     *  * It then adds circle2 at index 0 in the ShapeCollection and verifies that it replaces the element at index 0,
     *  * while the previous element is shifted to index 1.
     *  * Finally, it adds circle3 at index 1 in the ShapeCollection and verifies that it is added at the correct index,
     *  * shifting the existing element at index 1 to index 2.
     */

    @Test
    public void testAddAt(){
        ShapeCollection shapeCollection=new ShapeCollection();
        Point_2D p1 = new Point_2D(1, 2);
        Circle_2D c1 = new Circle_2D(p1, 3);
        GUIShape circle1 = new GUIShape(c1, true, Color.red, 1);
        Circle_2D c2 = new Circle_2D(p1, 2);
        GUIShape circle2 = new GUIShape(c2, false, Color.black, 2);
        Circle_2D c3 = new Circle_2D(p1, 2);
        GUIShape circle3 = new GUIShape(c2, false, Color.green, 2);

        shapeCollection.addAt(circle1,0);
        assertEquals(circle1,shapeCollection.get(0));
        shapeCollection.addAt(circle2,0);
        assertEquals(circle2,shapeCollection.get(0));
        assertEquals(circle1,shapeCollection.get(1));
        shapeCollection.addAt(circle3,1);
        assertEquals(circle3,shapeCollection.get(1));
    }

    /**
     * This method tests the addition of shapes to a ShapeCollection.
     *  * It creates a ShapeCollection object to store graphical shapes.
     *  * Then, it creates three Circle_2D objects, c1, c2, and c3, each representing a circle with a center point and radius.
     *  * GUIShape objects, circle1, circle2, and circle3, are created using the Circle_2D objects,
     *  * specifying additional properties like fill status and color.
     *  * Next, it adds circle1 to the ShapeCollection and verifies that it is added at the correct index.
     *  * It then adds circle2 to the ShapeCollection and verifies that it is added at the end of the collection.
     *  * Finally, it adds circle3 to the ShapeCollection and verifies that it is also added at the end of the collection.
     *  */
    @Test
    public void testAdd(){
        ShapeCollection shapeCollection=new ShapeCollection();
        Point_2D p1 = new Point_2D(1, 2);
        Circle_2D c1 = new Circle_2D(p1, 3);
        GUIShape circle1 = new GUIShape(c1, true, Color.red, 1);
        Circle_2D c2 = new Circle_2D(p1, 2);
        GUIShape circle2 = new GUIShape(c2, false, Color.black, 2);
        Circle_2D c3 = new Circle_2D(p1, 2);
        GUIShape circle3 = new GUIShape(c2, false, Color.green, 2);

        shapeCollection.add(circle1);
        assertEquals(circle1,shapeCollection.get(0));

        shapeCollection.add(circle2);
        assertEquals(circle2,shapeCollection.get(1));

        shapeCollection.add(circle3);
        assertEquals(circle3,shapeCollection.get(2));
    }

    /**
     *This method tests the copy functionality of the ShapeCollection class.
     *  * It creates three GUIShape objects representing graphical shapes.
     *  * Then, it creates a ShapeCollection object and adds the GUIShape objects to it.
     *  * Next, it calls the copy() method to create a copy of the ShapeCollection.
     *  * After copying, it verifies that the shapes in the original ShapeCollection and the copied ShapeCollection are the same.
     *  * It checks whether each shape in the original collection is equal to the corresponding shape in the copied collection.
     */

    @Test
    public void testCopy(){
        Point_2D p1 = new Point_2D(1, 2);
        Circle_2D c1 = new Circle_2D(p1, 3);
        GUIShape circle1 = new GUIShape(c1, true, Color.red, 1);
        Circle_2D c2 = new Circle_2D(p1, 2);
        GUIShape circle2 = new GUIShape(c2, false, Color.black, 2);
        Circle_2D c3 = new Circle_2D(p1, 2);
        GUIShape circle3 = new GUIShape(c2, false, Color.green, 2);


        ShapeCollection shapeCollection=new ShapeCollection();
        shapeCollection.add(circle1);
        shapeCollection.add(circle2);
        shapeCollection.add(circle3);

        shapeCollection.copy();

        assertEquals(circle1,shapeCollection.get(0));
        assertEquals(circle2,shapeCollection.get(1));
        assertEquals(circle3,shapeCollection.get(2));
    }

    /**
     * This method tests the sorting functionality of the ShapeCollection class.
     *  * It creates a Point_2D object a circle and another point 2D and a segment.
     *  * A ShapeCollection 'shapeCollection' is created to store graphical shapes.
     *  * A Comparator is defined to compare GUI_Shape objects based on their string representations.
     *  * 'circle' and 'seg' are added to 'shapeCollection'.
     *  * The sort() method is called on 'shapeCollection' with the provided comparator to sort the shapes.
     *  * Finally, it asserts that 'seg' is at index 0 and 'circle' is at index 1 after sorting in ascending order based on their string representations.
     *
     */

        @Test
       public void TestSort() {
            Point_2D p1 = new Point_2D(1, 2);
            Circle_2D c1 = new Circle_2D(Point_2D.ORIGIN, 1);
            Point_2D p2 = new Point_2D(2, 7);
            Segment_2D s = new Segment_2D(p1, p2);

            GUIShape circle = new GUIShape(c1, false, Color.green, 1);
            GUIShape seg = new GUIShape(s, false, Color.black, 2);

            ShapeCollection shapeCollection = new ShapeCollection();
            Comparator<GUI_Shape> comparator = Comparator.comparing(GUI_Shape::toString);

            shapeCollection.add(circle);
            shapeCollection.add(seg);
            shapeCollection.sort(comparator);

            assertEquals(seg, shapeCollection.get(0));
            assertEquals(circle, shapeCollection.get(1));

  }

    /**
     * This method tests the removeAll functionality of the ShapeCollection class.
     *  * It creates three GUIShape objects, circle1, circle2, and circle3, representing graphical shapes.
     *  * The GUIShape objects are added to the ShapeCollection.
     *  * The removeAll() method is called on the ShapeCollection to remove all elements.
     *  * Finally, it asserts that the size of the ShapeCollection is 0 after removal and that it is not equal to 1.
     */
  @Test
    public void testRemoveAll(){
      Point_2D p1 = new Point_2D(1, 2);
      Circle_2D c1 = new Circle_2D(p1, 3);
      GUIShape circle1 = new GUIShape(c1, true, Color.red, 1);
      Circle_2D c2 = new Circle_2D(p1, 2);
      GUIShape circle2 = new GUIShape(c2, false, Color.black, 2);
      Circle_2D c3 = new Circle_2D(p1, 2);
      GUIShape circle3 = new GUIShape(c2, false, Color.green, 2);


      ShapeCollection shapeCollection=new ShapeCollection();
      shapeCollection.add(circle1);
      shapeCollection.add(circle2);
      shapeCollection.add(circle3);
      shapeCollection.removeAll();

      assertNotEquals(1,shapeCollection.size());
      assertEquals(0,shapeCollection.size());

  }

    /**
     * * This method tests the save functionality of the ShapeCollection class.
     *  * It creates two GUIShape objects, circle1 and circle2, representing graphical shapes.
     *  * The GUIShape objects are added to the ShapeCollection.
     *  * A test file path is defined where the ShapeCollection will be saved.
     *  * The save() method is called on the ShapeCollection to save the shapes to the specified file.
     *  * Finally, it asserts that the string representation of the ShapeCollection matches the expected string,
     *  * which contains the serialized form of the graphical shapes.
     *  */

  @Test
  public void testSave(){
      Point_2D p1 = new Point_2D(1, 2);
      Circle_2D c1 = new Circle_2D(p1, 3);
      GUIShape circle1 = new GUIShape(c1, true, Color.red, 1);
      Circle_2D c2 = new Circle_2D(p1, 2);
      GUIShape circle2 = new GUIShape(c2, false, Color.black, 2);

      ShapeCollection shapeCollection=new ShapeCollection();

      shapeCollection.add(circle1);
      shapeCollection.add(circle2);

      String testFilePath = "test_shapes.txt";


      String ans= "GUIShape,16711680,true,1,Circle_2D,1.0,2.0, 3.0GUIShape,0,false,2,Circle_2D,1.0,2.0, 2.0";
      shapeCollection.save(testFilePath);
      assertEquals(ans,shapeCollection.toString());
  }

    /**
     *This method tests the load functionality of the ShapeCollection class.
     *  * It creates a ShapeCollection 'shapeCollection' to store graphical shapes.
     *  * Two GUIShape objects, circle1 and circle2, are created representing graphical shapes,
     *  * These GUIShape objects are added to the ShapeCollection.
     *  * A test file path is defined where the ShapeCollection will be saved.
     *  * The save() method is called on the ShapeCollection to save the shapes to the specified file.
     *  * A new ShapeCollection 'loaded' is created.
     *  * The load() method is called on the 'loaded' ShapeCollection to load shapes from the saved file.
     *  * Finally, it asserts that the size of the original and loaded ShapeCollections are equal,
     *  * and that each shape in the original ShapeCollection matches the corresponding shape in the loaded ShapeCollection.
     */
  @Test
  public void testLoad(){

      ShapeCollection shapeCollection = new ShapeCollection();
      Point_2D p1 = new Point_2D(1, 2);
      Circle_2D c1 = new Circle_2D(p1, 3);
      GUIShape circle1 = new GUIShape(c1, true, Color.red, 1);
      Circle_2D c2 = new Circle_2D(p1, 2);
      GUIShape circle2 = new GUIShape(c2, false, Color.black, 2);
      shapeCollection.add(circle1);
      shapeCollection.add(circle2);

      String testFilePath = "test_shapes.txt";

      shapeCollection.save(testFilePath);
      ShapeCollection loaded= new ShapeCollection();
      loaded.load(testFilePath);

      assertEquals(shapeCollection.size(), loaded.size());
      assertEquals(shapeCollection.get(0).toString(), loaded.get(0).toString());
      assertEquals(shapeCollection.get(1).toString(), loaded.get(1).toString());
  }

    /**
     * This method tests the toString method of the ShapeCollection class.
     *  * It creates two GUIShape objects, circle1 and circle2, representing graphical shapes.
     *  * The GUIShape objects are added to the ShapeCollection.
     *  * The toString() method is called on the ShapeCollection to get its string representation,
     *  * which should contain the serialized form of the graphical shapes.
     *  * Finally, it asserts that the obtained string matches the expected string representation of the ShapeCollection.
     *  */
  @Test
    public void testToString(){
      Point_2D p1 = new Point_2D(1, 2);
      Circle_2D c1 = new Circle_2D(p1, 3);
      GUIShape circle1 = new GUIShape(c1, true, Color.red, 1);
      Circle_2D c2 = new Circle_2D(p1, 2);
      GUIShape circle2 = new GUIShape(c2, false, Color.black, 2);


      ShapeCollection shapeCollection=new ShapeCollection();
      shapeCollection.add(circle1);
      shapeCollection.add(circle2);

      String ans= "GUIShape,16711680,true,1,Circle_2D,1.0,2.0, 3.0GUIShape,0,false,2,Circle_2D,1.0,2.0, 2.0";
      assertEquals(ans,shapeCollection.toString());
  }
}
