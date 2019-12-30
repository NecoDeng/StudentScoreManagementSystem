package ssms.ui;

import java.awt.Point;

public class Point2D {
	public double x;
	public double y;

	public Point2D() {
		this(0, 0);
	}

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point toPoint() {
		Point point = new Point((int) x, (int) y);
		return point;
	}
}
