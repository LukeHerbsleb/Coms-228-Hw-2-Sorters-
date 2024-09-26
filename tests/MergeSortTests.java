package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.iastate.cs228.hw2.*;

public class MergeSortTests {

	@Test
	public void testMergeSort1() {
		
		Point[] points = new Point[4];
		points[0] = new Point(1, 2);
		points[1] = new Point(3, 4);
		points[2] = new Point(5, 6);
		points[3] = new Point(7, 8);
		
		MergeSorter sorter = new MergeSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testMergeSort2() {
		Point[] pts = new Point[4];
		pts[0] = new Point(7, 8);
		pts[1] = new Point(6, 5);
		pts[2] = new Point(4, 3);
		pts[3] = new Point(2, 1);
		
		MergeSorter sorter = new MergeSorter(pts);
		sorter.setComparator(0);
		sorter.sort();
		
		sorter.getPoints(pts);
		assertTrue(pts[0].compareTo(pts[1]) < 0);
		assertTrue(pts[1].compareTo(pts[2]) < 0);
		assertTrue(pts[2].compareTo(pts[3]) < 0);
	}
	
	
	
	
	
	
	
	
	@Test
	public void testMergeSort1Ys() {
		
		Point[] points = new Point[4];
		points[0] = new Point(1, 2);
		points[1] = new Point(3, 4);
		points[2] = new Point(5, 6);
		points[3] = new Point(7, 8);
		
		MergeSorter sorter = new MergeSorter(points);
		sorter.setComparator(1);
		sorter.sort();
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testMergeSort2Ys() {
		
		Point[] points = new Point[4];
		points[0] = new Point(7, 8);
		points[1] = new Point(6, 5);
		points[2] = new Point(4, 3);
		points[3] = new Point(2, 1);
		
		MergeSorter sorter = new MergeSorter(points);
		sorter.setComparator(1);
		sorter.sort();
		sorter.getPoints(points);
		
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testMergeSort1YsNOTXs() {
		
		Point[] points = new Point[4];
		points[0] = new Point(1, 7);
		points[1] = new Point(3, 6);
		points[2] = new Point(5, 5);
		points[3] = new Point(7, 4);
		
		MergeSorter sorter = new MergeSorter(points);
		sorter.setComparator(1);
		sorter.sort();
		sorter.getPoints(points);
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}

}
