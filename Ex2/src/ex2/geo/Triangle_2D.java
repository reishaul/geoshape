package ex2.geo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape {
	//private Point_2D[] tri= new Point_2D[]{p1, point2, point3};;
	private Point_2D point1;
	private Point_2D point2;
	private Point_2D point3;

	////////////////////////////////
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this.point1 = new Point_2D(p1);
		this.point2 = new Point_2D(p2);
		this.point3 = new Point_2D(p3);

		////////////////////////////////
	}

	public Triangle_2D(Triangle_2D t1) {
		this(t1.point1, t1.point2, t1.point3);
	}


	public Point_2D[] getAllPoints() {
		return new Point_2D[]{point1, point2, point3};
		////////////////////////////////
	}

	/**
	 * this method returns a string that represents a triangle by center point and radius
	 * @return string
	 */
	public String toString(){
		return this.point1 +","+ this.point2 +","+ this.point3;
	}

	/**
	 * this methode check if another triangle is equals to the original one
	 * @param o
	 * @return true or false
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Triangle_2D that = (Triangle_2D) o;
		return Objects.equals(point1, that.point1) && Objects.equals(point2, that.point2) && Objects.equals(point3, that.point3);
	}

	/**
	 * this methode check if a given point is found in the triangle by calculate areas
	 * @param ot - a query 2D point
	 * @return true if the sum of areas equals to the original triangle area
	 */


	@Override
	public boolean contains(Point_2D ot) {
		double totalArea = area();
		double a = point1.distance(point3);//distance from point1 to point3
		double b = ot.distance(point3);
		double c = ot.distance(point1);
		double s1 = (a + b + c) / 2;//half of the perimeter
		double area1 = Math.sqrt(s1 * (s1 - a) * (s1 - b) * (s1 - c));

		double x = ot.distance(point2);
		double y = ot.distance(point1); // Distance between ot and point1
		double s2 = (x + y + c) / 2;//half of the perimeter

		double area2 = Math.sqrt(s2 * (s2 - x) * (s2 - y) * (s2 - c));

		double sumOfArea = area1 + area2;
		if (sumOfArea <= totalArea) {
			return true;
		}

		return false;
	}

	/**
	 * this methode calculate the area of the triangle by his points and additional distance methode
	 * @return area
	 */

	@Override
	public double area() {
		double a= point1.distance(point2);//distance from point1 to point2
		double b= point1.distance(point3);
		double c= point2.distance(point3);
		double s= (a+b+c)/2;//half of the perimeter
		double area= Math.sqrt (s*(s-a)*(s-b)*(s-c));
		return area;
	}

	/**
	 * this methode calculate the perimeter of the triangle by using his points and additional distance methode
	 * @return perimeter
	 */
	@Override
	public double perimeter() {
		double a= point1.distance(point2);//distance from point1 to point2
		double b= point1.distance(point3);
		double c= point2.distance(point3);
		double perimeter = (a+b+c);//calculate of the perimeter
		return perimeter;
	}

	/**
	 * this methode translate the triangle by moving each point by additional methode call move
	 * @param vec - a vector from the 0,0
	 */

	@Override
	public void translate(Point_2D vec) {

		point1.move(vec);
		point2.move(vec);
		point3.move(vec);

	}

	/**
	 * this methode create a copy of the triangle with the same size
	 * @return
	 */

	@Override
	public GeoShape copy() {
		return new Triangle_2D(this);
	}

	/**
	 * this methode scale up and down the triangle by 110% or 90% accordingly
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */

	@Override
	public void scale(Point_2D center, double ratio) {

		point1.scale(center,ratio);
		point2.scale(center,ratio);
		point3.scale(center,ratio);


	}

	/**
	 * this methode rotate the triangle on his axis according to the given angle using additional methode call rotate
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		point1.rotate(center,angleDegrees);
		point2.rotate(center,angleDegrees);
		point3.rotate(center,angleDegrees);

	}
}
