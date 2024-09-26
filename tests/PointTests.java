package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.iastate.cs228.hw2.Point;

public class PointTests {

	@Test
	public void testPointPrint() {
		Point p = new Point(5, 3);
		assertEquals(p.getX(), 5);
		assertEquals(p.getY(), 3);
		System.out.println(p.toString());
	}
	
	@Test
	public void testCompareTo1() {
		Point p = new Point(5, 3);
		Point q = new Point(5, 3);
		assertEquals(p.compareTo(q), 0);
	}
	
	@Test
	public void testCompareTo2() {
		Point p = new Point(5, 3);
		Point q = new Point(4, 3);
		assertEquals(p.compareTo(q), 1);
	}
	
	@Test
	public void testCompareTo3() {
		Point p = new Point(5, 3);
		Point q = new Point(6, 3);
		assertEquals(p.compareTo(q), -1);
	}
	
	@Test
	public void testCompareTo4() {
		Point p = new Point(5, 2);
		Point q = new Point(5, 3);
		assertEquals(p.compareTo(q), -1);
	}
	
	@Test
	public void testCompareTo5() {
		Point p = new Point(5, 4);
		Point q = new Point(5, 3);
		assertEquals(p.compareTo(q), 1);
	}
	
	@Test
	public void testInitialxORy() {
		Point.setXorY(false);
		assertEquals(Point.xORy, false);
	}
	
	@Test
	public void testsetxORy() {
		Point.setXorY(true);
		assertTrue(Point.xORy);
	}

}
