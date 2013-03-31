package ee.tty.ood.harjutus1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ee.tty.ood.harjutus1.Point;

public class PointTest {
	
	private static double EPSILON = 0.0001;

	@Test
	public void testDistance() {
		Point point1 = new Point(10, 20);
		Point point2 = new Point(17, 0);
		assertEquals(21.18962010041709, point1.distance(point2), EPSILON);
	}
	
	@Test
	public void testRho() {
		Point point = new Point(10, 20);
		assertEquals(22.360679774997898, point.rho(), EPSILON);
	}
	
	@Test
	public void testTheta() {
		Point point = new Point(10, 20);
		assertEquals(1.1071487177940904, point.theta(), EPSILON);
	}
	
	@Test
	public void testCentreRotate() {
		Point point = new Point(15, 17);
		point.centreRotate(Math.PI/3);
		
		assertEquals(-7.222432, point.getX(), EPSILON);
		assertEquals(21.490381, point.getY(), EPSILON);
		assertEquals(22.671568, point.rho(), EPSILON);
		assertEquals(1.895015, point.theta(), EPSILON);
	}
}
