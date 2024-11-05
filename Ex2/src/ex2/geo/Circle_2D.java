package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle_2D implements GeoShape{
	private Point_2D _center;
	private double _radius;
	
	public Circle_2D(Point_2D cen, double rad) {
		this._center = new Point_2D(cen);
		this._radius = rad;
	}
	public Circle_2D(Circle_2D c)
	{
		this(c.getCenter(), c.getRadius());
	}
	public double getRadius() {return this._radius;}
	public Point_2D getCenter(){ return _center;}

	/**
	 * this method returns a string that represents a circle by center point and radius
	 *
	 * @return string
	 */
	 @Override
	    public String toString()
	    {
			return  _center.toString()+", "+_radius;
			////////////////////////////////
		}

	/**
	 * this methode check if a given point 2D found in the circle
	 * @param ot - a query 2D point
	 * @return true or false
	 */
	@Override
	public boolean contains(Point_2D ot) {
		 Point_2D c=new Point_2D(ot);
		double dist = c.distance(_center);//מחשב אם הנק נמצאת במעגל
		boolean ans=dist<=_radius+ Ex2_Const.EPS;
		return ans;
	}

	/**
	 * this methode check if another circle is same as the original one
	 * @param p
	 * @return true or false
	 */
	public boolean equals(Object p){
		 if (p==null||!(p instanceof Circle_2D))
			 return false;
		 Circle_2D c2 =(Circle_2D) p;
		 boolean c =_center.equals(c2._center);
		 boolean r=_radius==c2._radius;
		 return r && c;
	}
	public boolean close2equals(Circle_2D other, double eps){

		 boolean c =_center.equals(other._center);
		 boolean r=_radius==other._radius;
		 if (c && r)
			 return true;

		return false;
	}

	/**
	 * this methode calculate the area of the circle based of his radius
	 * @return area
	 */
	
	@Override
	public double area() {
		double erea = Math.PI * Math.pow(this._radius,2);//calculate of area
		return erea;
	}

	/**
	 * this methode calculate the perimeter of the circle based of his radius
	 * @return perimeter
	 */
	@Override
	public double perimeter() {
		double perimeter = 2*Math.PI*this._radius;//calculate of perimeter
		return perimeter;
	}

	/**
	 * this methode translate the circle by moving the center to a given vector using additional methode call move
	 * @param vec - a vector from the 0,0
	 */
	@Override
	public void translate(Point_2D vec) {
		this._center.move(vec);
	}

	/**
	 * this methode create a copy of the circle with the same size
	 * @return
	 */
	@Override
	public GeoShape copy() {
		return new Circle_2D(this);
	}

	/**
	 * this methode scale up and down the circle by 110% or 90% accordingly
	 *
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */

	@Override
	public void scale(Point_2D center, double ratio) {
		 if (!contains(center)){
			 this._center.scale(center,ratio);
			 this._radius = _radius*ratio;
		 }

		 else{
			 this._center.scale(center,ratio);
			 this._radius = _radius*ratio;
		 }

		////////////////////////////////
	}

	/**
	 * this methode rotate the circle on his axis according to the given angle using additional methode call rotate
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		 this._center.rotate(center,angleDegrees);

		////////////////////////////////
	}

}
