package ex2.ex2;

import ex2.geo.GeoShape;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;
	
	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}

	/**
	 * this methode get the attribute of each element in the array
	 * @param i - the index of the element
	 * @return shape at index i
	 */
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	/**
	 * this methode return the length of the _shapes array
	 * @return number
	 */
	@Override
	public int size() {
		return _shapes.size();
	}

	/**
	 * this methode remove the element found in the index i
	 * @param i - the index of the element to be removed.
	 * @return new array without the chosen element
	 */

	@Override
	public GUI_Shape removeElementAt(int i) {
		return _shapes.remove(i);
		//////////////////////////////////////////
	}

	/**
	 * this methode add a chosen element to the array in a chosen index
	 * @param s - the gui_shape
	 * @param i - the location (index) in which s should be added
	 */

	@Override
	public void addAt(GUI_Shape s, int i) {
		_shapes.add(i,s);
	}

	/**
	 * this methode add a chosen element to the last cell of the array
	 * @param s - the gui_shape
	 */
	@Override
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}

	/**
	 * this methode copy each element of the array
	 * @return a new copied array
	 */
	@Override
	public GUI_Shape_Collection copy() {
		ShapeCollection shapeCollection = new ShapeCollection();
		for (GUI_Shape shape : _shapes)
		{
			GUI_Shape copy = new GUIShape(shape.toString());
			shapeCollection.add( copy);
		}
		return shapeCollection;

		//////////////////////////////////////////
	}

	/**
	 * this methode doing a sort of the array according to Comparator
	 * @param comp a linear order over gui_sahpes as defined in java.util.Comparator
	 */

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
		//////////////////////////////////////////
	}

	/**
	 * this methode remove all the element of the array
	 */

	@Override
	public void removeAll() {
		_shapes.clear();

		//////////////////////////////////////////
	}

	/**
	 * this methode write the element of the array(to a string) and save this to a file
	 * @param file - the file name in which this collection will be saved.
	 */

	@Override
	public void save(String file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			for (GUI_Shape shape : _shapes) {
				writer.write( shape.toString()+"\n");
			}
			writer.close();

		} catch (IOException ex) {
			throw new RuntimeException(ex);
        }
		//////////////////////////////////////////
	}

	/**
	 * this methode read the file(string) we save earlier and load the information to the operating interface where we do the edits
	 * on our shapes.
	 * @param file - the name of the text file to create a gui shape file from.
	 */

	@Override
	public void load(String file) {
		{
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				_shapes.clear();
				String s;
				while ((s = reader.readLine()) != null) {
					_shapes.add(new GUIShape(s));
				}
				reader.close();
			}catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * this methode run all over the array and convert the shapes to a string
	 * @return string
	 */

	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}
}
