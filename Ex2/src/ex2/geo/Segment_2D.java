package ex2.geo;
import ex2.ex2.Ex2_Const;

import java.util.Objects;


/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{
	private Point_2D _p1,_p2;
	public Segment_2D(Point_2D a, Point_2D b) {

		this._p1=new Point_2D(a);
		this._p2= new Point_2D(b);

		////////////////////////////////
	}
	public Segment_2D(Segment_2D t1) {

		_p1=new Point_2D(t1._p1);
		_p2=new Point_2D(t1.get_p2());
		////////////////////////////////
	}

	public Point_2D get_p1() {
		return new Point_2D(_p1);
		////////////////////////////////
	}
	public Point_2D get_p2() {
		return _p2;
		////////////////////////////////
	}

	@Override
	public String toString() {

			return  _p1.toString()+","+_p2;
			////////////////////////////////
	}

	/**
	 * this methode check if the segment is vertical or not
	 * @return true or false
	 */

	public boolean isVertical(){return _p1.x()==_p2.x();}

	/**
	 * this methode check if a given point is found in the segment
	 * @param ot - a query 2D point
	 * @return true or false
	 */


	@Override
	public boolean contains(Point_2D ot) {
		double dist=_p1.distance(_p2);
		double d1=_p1.distance(ot);
		double d2= ot.distance(_p2);
		boolean ans= d1+d2<dist+Ex2_Const.EPS;
		return ans;

	}

	/**
	 * this methode calculate the area of the segment
	 * @return area
	 */

	@Override
	public double area() {
		double d=_p1.distance(_p2);
		return 2*d;
	}

	/**
	 * this methode calculate the perimeter of the segment by using additional methode call distance
	 * @return perimeter
	 */

	@Override
	public double perimeter() {
		double d = _p1.distance(_p2);
		return 2*d;
	}
	/**
	 * this methode translate the segment by moving each point by additional methode call move
	 */

	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec);
		_p2.move(vec);

	}

	/**
	 * this methode return a copy of the segment with the same edge points
	 * @return a copied segment
	 */

	@Override
	public GeoShape copy() {
		Segment_2D a= new Segment_2D(this);
		return a;
	}

	/**
	 * this methode scale up and down the segment by 110% or 90% accordingly
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */

	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center,ratio);
		_p2.scale(center,ratio);
	}

	/**
	 * this methode rotate the segment on his axis according to the given angle using additional methode call rotate
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center,angleDegrees);
		_p2.rotate(center,angleDegrees);

	}

	/**
	 * this methode check if another segment is equals to the original one
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Segment_2D segment2D = (Segment_2D) o;
		return _p1.equals(segment2D._p1)&&_p2.equals(segment2D._p2);

	}
}