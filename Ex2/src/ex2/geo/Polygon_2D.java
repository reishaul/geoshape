package ex2.geo;

import java.util.ArrayList;
import java.util.Objects;

public class Polygon_2D implements GeoShape {

	private ArrayList<Point_2D> poly;

	////////////////////////////////
	public Polygon_2D() {

		poly = new ArrayList<>();
		////////////////////////////////
	}
	public Polygon_2D(ArrayList<Point_2D> arrayList){
		this.poly=arrayList;

	}

	public Polygon_2D(Polygon_2D po) {
		this.poly = new ArrayList<>();

		for (Point_2D point : po.getAllPoints()) {//po.poly
			poly.add(point);
		}
		////////////////////////////////
	}

	public Point_2D[] getAllPoints() {
		Point_2D[] ans = new Point_2D[poly.size()];
		for (int i = 0; i < poly.size(); i++) {
			ans[i] = poly.get(i);
		}
		return ans;

		//return poly.toArray(Point_2D[]::new);
		////////////////////////////////
	}

	public void add(Point_2D p) {
		if (p != null) {
			poly.add(p);
		}
		////////////////////////////////
	}

	/**
	 * this methode convert the points of the polygon to a string
	 * @return string of the points
	 */

	@Override
	public String toString() {
//		String ans = "";
//		for (int i = 0; i < poly.size() ; i++) {
//			ans = ans + poly.get(i).toString() + ",";
//		}
//		ans = ans + poly.get(i).toString();
//		return ans;
		String s = poly.get(0).toString();
		for (int i = 1; i < poly.size(); i++)
		{
			s+=","+poly.get(i).toString();
		}
		return s;

		////////////////////////////////
	}

	/**
	 * this methode check if another polygon is equals to the original one
	 * @param o
	 * @return true or false
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Polygon_2D polygon2D = (Polygon_2D) o;
		return Objects.equals(poly, polygon2D.poly);
	}

	/**
	 * methode that check if some given point is found in the polygon
	 *
	 * @param
	 * @return true if the number of the crosses is odd
	 */

	@Override
	public boolean contains(Point_2D ot) {
		int crosses = 0;
		for (int i = 0; i < poly.size(); i++) {
			Point_2D p1 = poly.get(i);
			Point_2D p2 = poly.get((i+1) % poly.size());
			if (((p1.y() <= ot.y()&& ot.y() <p2.y()) || (p2.y() <= ot.y() &&ot.y() < p1.y())) &&
					(ot.x()< (p2.x() -p1.x()) * (ot.y() - p1.y()) /(p2.y()- p1.y()) +p1.x())) {
				crosses++;
			}
		}
		return crosses % 2 == 1;
	}

	/**
	 * this methode calculate the area of the polygon based on the lace formula
	 * @return area
	 */

	@Override
	public double area() {

			double area = 0;

			int n = poly.size();
			for (int i = 0; i < n; i++) {
				Point_2D current = poly.get(i);
				Point_2D next = poly.get((i + 1) % n);
				area += (current.x() * next.y() - next.x() * current.y());
			}
			return Math.abs(area) / 2.0;
	}

	/**
	 * this methode calculate the perimeter of the polygon by calculate the distance between each two neighboring points
	 * @return perimeter
	 */

	@Override
	public double perimeter() {
		double perimeter = 0;

		for (int i = 0; i < poly.size(); i++) {
			Point_2D p1 = poly.get(i);
			Point_2D p2 = poly.get((i + 1) % poly.size());
			perimeter += p1.distance(p2);
		}
		return perimeter;
	}

	/**
	 * this methode translate each point of the polygon by using additional methode call move
	 * @param vec - a vector from the 0,0
	 */

	////////////////////////////////
	@Override
	public void translate(Point_2D vec) {
		for (int i = 0; i < poly.size(); i++) {
			poly.get(i).move(vec);
		}

		////////////////////////////////
	}

	/**
	 * this methode create a copy of the polygon with the same size
	 * @return new polygon
	 */

	@Override
	public GeoShape copy() {
		ArrayList<Point_2D> arr=new ArrayList<>();
		for (int i = 0; i < poly.size(); i++) {
			Point_2D d=new Point_2D(poly.get(i));
			arr.add(d);
		}
		Polygon_2D pol=new Polygon_2D(arr);
		return pol;
	}

	/**
	 * this methode scale up and down the polygon by 110% or 90% accordingly
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */

	@Override
	public void scale(Point_2D center, double ratio) {
		for (int i = 0; i < poly.size(); i++) {
			poly.get(i).scale(center, ratio);
		}
		////////////////////////////////
	}

	/**
	 * this methode rotate the polygon on his axis according to the given angle using additional methode call rotate
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i < poly.size(); i++) {
			poly.get(i).rotate(center,angleDegrees);
		}
	}
}


