package ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {
	private Point_2D _p1;
	private Point_2D _p2;
	private Point_2D _p3;
	private Point_2D _p4;
	public Rect_2D(Point_2D p1, Point_2D p2) {
		this._p1 =new Point_2D(p1);
		this._p2 =new Point_2D(p2);
		this._p3 =new Point_2D(p1.x(),p2.y());
		this._p4 =new Point_2D(p2.x(), p1.y());

		////////////////////////////////
	}
	public Rect_2D(Rect_2D t1) {
		this._p1=new Point_2D(t1._p1);
		this._p2=new Point_2D(t1._p2);
		this._p3=new Point_2D(t1._p3);
		this._p4=new Point_2D(t1._p4);
		////////////////////////////////
	}
	public Point_2D get_p1(){ return _p1;}
	public Point_2D get_p2(){ return _p2;}
	public Point_2D get_p3(){ return _p3;}
	public Point_2D get_p4(){ return _p4;}

	/**
	 * this method returns a string that represents a rectangle by 4 points
	 * @return
	 */
	public String toString(){
		return this._p1 + "," + _p2 + "," + _p3 + "," + _p4;
	}

	/**
	 * this methode check if a given point is found in the rectangle
	 * @param ot - a query 2D point
	 * @return true or false
	 */


	@Override
	public boolean contains(Point_2D ot) {
		double minX = Math.min(_p1.x(), _p2.x());
		double maxX = Math.max(_p1.x(), _p2.x());
		double minY = Math.min(_p1.y(), _p2.y());
		double maxY = Math.max(_p1.y(), _p2.y());

		return ot.x()>= minX &&ot.x() <= maxX &&
				ot.y() >= minY&& ot.y() <= maxY;
	}

	/**
	 * this methode calculate the area of the rectangle by using additional  methode call distance
	 * @return area
	 */

	@Override
	public double area() {
		double a= _p1.distance(_p3);
		double b = _p1.distance(_p4);

		double area= a*b;
		return area;

	}

	/**
	 * this methode calculate the perimeter of the rectangle by using additional methode call distance
	 * @return perimeter
	 */

	@Override
	public double perimeter() {
		double a= _p1.distance(_p3);
		double b= _p1.distance(_p4);
		double perimeter= 2*(a+b);//calculate perimeter of rect
		return perimeter;

	}

	/**
	 * this methode translate the rectangle by using additional methode which move each point according to the given vector
	 * @param vec - a vector from the 0,0
	 */

	@Override
	public void translate(Point_2D vec) {
		this._p1.move(vec);

		this._p2.move(vec);

		this._p3.move(vec);

		this._p4.move(vec);


	}

	/**
	 * this methode create a copy of the rectangle with the same size
	 * @return new copied rectangle
	 */

	@Override
	public GeoShape copy() {

		return new Rect_2D(this);
	}

	/**
	 * this methode scale up and down the circle by 110% or 90% accordingly
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */

	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center,ratio);
		_p2.scale(center,ratio);

	}

	/**
	 * this methode check if another rectangle is equals to the original one
	 * @param o
	 * @return true or false
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rect_2D rect2D = (Rect_2D) o;
		return Objects.equals(_p1, rect2D._p1) && Objects.equals(_p2, rect2D._p2) && Objects.equals(_p3, rect2D._p3) && Objects.equals(_p4, rect2D._p4);
	}

	/**
	 * this methode rotate the rectangle on his axis according to the given angle using additional methode call rotate
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */


	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center,angleDegrees);
		_p2.rotate(center,angleDegrees);
		_p3.rotate(center,angleDegrees);
		_p4.rotate(center,angleDegrees);

	}
}
