package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.iastate.cs228.hw2.InsertionSorter;
import edu.iastate.cs228.hw2.Point;

public class AbstractSorterTests {

	@Test
	public void testGetPoint() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(5, 6);
		Point p4 = new Point(7, 8);

		Point[] points = new Point[4];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		points[3] = p4;

		InsertionSorter sorter = new InsertionSorter(points);
		Point[] getPoints = new Point[4];
		sorter.getPoints(getPoints);

		assertTrue(p1.compareTo(getPoints[0]) == 0);
		assertTrue(p2.compareTo(getPoints[1]) == 0);
		assertTrue(p3.compareTo(getPoints[2]) == 0);
		assertTrue(p4.compareTo(getPoints[3]) == 0);
	}

	@Test
	public void testSwapPoints() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		Point[] points = new Point[2];
		points[0] = p1;
		points[1] = p2;

		InsertionSorter sorter = new InsertionSorter(points);
		//sorter.swap(0, 1); used to be in the og folder but moved before submission
		Point[] getPoints = new Point[2];
		sorter.getPoints(getPoints);

		assertTrue(p1.compareTo(getPoints[1]) == 0);
		assertTrue(p2.compareTo(getPoints[0]) == 0);
	}

}
