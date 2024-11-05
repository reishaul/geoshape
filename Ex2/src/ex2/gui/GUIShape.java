package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 *
 * @author I2CS
 */

import ex2.geo.*;

import java.awt.*;
import java.util.ArrayList;

public class GUIShape implements GUI_Shape {
    private GeoShape _g = null;
    private boolean _fill;
    private Color _color;
    private int _tag;
    private boolean _isSelected;

    public GUIShape(GeoShape g, boolean f, Color c, int t) {
        _g = null;
        if (g != null) {
            _g = g.copy();
        }
        _fill = f;
        _color = c;
        _tag = t;
        _isSelected = false;
    }

    public GUIShape(GUIShape ot) {
        this(ot._g, ot._fill, ot._color, ot._tag);
    }

    public GUIShape(String s) {
        String[] str = s.split(",");
		_color = Color.decode(str[1]);
       _fill = Boolean.parseBoolean(str[2]);
        _tag= Integer.parseInt(str[3]);
		String type = str[4];
		if(type.equals("Circle_2D")){
			Point_2D center= new Point_2D(Double.parseDouble(str[5]),Double.parseDouble(str[6]));
			double radius= Double.parseDouble(str[7]);
			_g=new Circle_2D(center,radius);
		}
		if(type.equals("Triangle_2D")){
			Point_2D p1= new Point_2D(Double.parseDouble(str[5]),Double.parseDouble(str[6]));
			Point_2D p2= new Point_2D(Double.parseDouble(str[7]),Double.parseDouble(str[8]));
			Point_2D p3= new Point_2D(Double.parseDouble(str[9]),Double.parseDouble(str[10]));
			_g=new Triangle_2D(p1,p2,p3);

		}
		if (type.equals("Segment_2D")){
			Point_2D edge1 = new Point_2D(Double.parseDouble(str[5]),Double.parseDouble(str[6]));
			Point_2D edge2= new Point_2D(Double.parseDouble(str[7]),Double.parseDouble(str[8]));
			_g=new Segment_2D(edge1,edge2);
		}
		if (type.equals("Rect_2D")){
			Point_2D p1= new Point_2D(Double.parseDouble(str[5]),Double.parseDouble(str[6]));
			Point_2D p2= new Point_2D(Double.parseDouble(str[7]),Double.parseDouble(str[8]));
			Point_2D p3= new Point_2D(Double.parseDouble(str[9]),Double.parseDouble(str[10]));
			Point_2D p4= new Point_2D(Double.parseDouble(str[11]),Double.parseDouble(str[12]));
			_g=new Rect_2D(p1,p3);
		}
		if (type.equals("Polygon_2D")) {
			int num =(str.length-5)/2;
			Point_2D[] point2DS = new  Point_2D[num];
			int index=5;
			for (int i = 0; i < num; i++) {
				point2DS[i]= new Point_2D(Double.parseDouble(str[index]),Double.parseDouble(str[index+1]));
				index+=2;
			}
			_g=new Polygon_2D();
			for (Point_2D p : point2DS) {
				((Polygon_2D )_g).add(p);
			}

		}

    }

    @Override
    public GeoShape getShape() {
        return _g;
    }

    @Override
    public void setShape(GeoShape g) {
        _g = g;
    }

    @Override
    public boolean isFilled() {
        return _fill;
    }

    @Override
    public void setFilled(boolean filled) {
        _fill = filled;
    }

    @Override
    public Color getColor() {
        return _color;
    }

    @Override
    public void setColor(Color cl) {
        _color = cl;
    }

    @Override
    public int getTag() {
        return _tag;
    }

    @Override
    public void setTag(int tag) {
        _tag = tag;

    }

    @Override
    public GUI_Shape copy() {
        GUI_Shape cp = new GUIShape(this);
        return cp;
    }

    @Override
    public String toString() {
        String ans = "" + this.getClass().getSimpleName() + "," + colorEncoding(_color) + "," + _fill + "," + _tag + "," + this._g.getClass().getSimpleName() + "," + _g.toString();
        return ans;
    }

    public static int colorEncoding(Color c) {
        int r = c.getRed();
        int b = c.getBlue();
        int g = c.getGreen();
        int ce = r * 256 * 256 + g * 256 + b;
        return ce;
    }
    public static Color colorDecoding(int ce) {
        int r = ce / (256 * 256);
		int g = ce/256 - r * 256;
		int b = ce -(r * 256 * 256 + g * 256);
		Color color = new Color(r,g,b);
		return color ;

    }

    @Override
    public boolean isSelected() {
        return this._isSelected;
    }

    @Override
    public void setSelected(boolean s) {
        this._isSelected = s;
    }
}
