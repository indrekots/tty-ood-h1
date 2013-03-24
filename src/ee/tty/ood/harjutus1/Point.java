package ee.tty.ood.harjutus1;

/**
 * @author Indrek Ots
 *
 * Class for a 2 dimensional point
 */
public class Point {
	
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//TODO: implement toString
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double rho() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public double theta() {
		return Math.atan2(y, x);
	}
	
	public double distance(Point other) {
		return vectorTo(other).rho();
	}
	
	public Point vectorTo(Point other) {
		return new Point(other.getX() - x, other.getY() - y);
	}
	
	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}
	
	public void scale(double factor) {
		x *= factor;
		y *= factor;
	}
	
	public void centreRotate(double angle) {
		double tempX = rho() * Math.cos(theta() + angle);
		double tempY = rho() * Math.sin(theta() + angle);
		x = tempX;
		y = tempY;
	}
	
	public void rotate(Point p, double angle) {
		translate(-p.getX(), -p.getY());
		centreRotate(angle);
		translate(p.getX(), p.getY());
	}
}
