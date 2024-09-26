package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.iastate.cs228.hw2.*;

public class InsertionSorterTests {

	@Test
	public void testinsertSort1() {
		
		Point[] points = new Point[4];
		points[0] = new Point(1, 2);
		points[1] = new Point(3, 4);
		points[2] = new Point(5, 6);
		points[3] = new Point(7, 8);
		
		InsertionSorter sorter = new InsertionSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testinsertSort2() {
		
		Point[] points = new Point[4];
		points[0] = new Point(7, 8);
		points[1] = new Point(6, 5);
		points[2] = new Point(4, 3);
		points[3] = new Point(2, 1);
		
		InsertionSorter sorter = new InsertionSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testSameX() {
		
		Point[] points = new Point[4];
		points[0] = new Point(1, 1);
		points[1] = new Point(2, 6);
		points[2] = new Point(2, 1);
		points[3] = new Point(3, 1);
		
		InsertionSorter sorter = new InsertionSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) > 0);		//this should change if i decide later on that y's matter when sorting x's
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testinsertSort1Ys() {
		
		Point[] points = new Point[4];
		points[0] = new Point(1, 2);
		points[1] = new Point(3, 4);
		points[2] = new Point(5, 6);
		points[3] = new Point(7, 8);
		
		InsertionSorter sorter = new InsertionSorter(points);
		sorter.setComparator(1);
		sorter.sort();
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testinsertSort2Ys() {
		
		Point[] points = new Point[4];
		points[0] = new Point(7, 8);
		points[1] = new Point(6, 5);
		points[2] = new Point(4, 3);
		points[3] = new Point(2, 1);
		
		InsertionSorter sorter = new InsertionSorter(points);
		sorter.setComparator(1);
		sorter.sort();
		
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testinsertSort1YsNOTXs() {
		
		Point[] points = new Point[4];
		points[0] = new Point(1, 7);
		points[1] = new Point(3, 6);
		points[2] = new Point(5, 5);
		points[3] = new Point(7, 4);
		
		InsertionSorter sorter = new InsertionSorter(points);
		sorter.setComparator(1);
		sorter.sort();
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}

}
