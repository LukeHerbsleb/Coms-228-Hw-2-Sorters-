package tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import edu.iastate.cs228.hw2.*;

public class QuickSortTests {

	//i have no clue if any of this works, test it all(try testing of points of wierd sizes)
	@Test
	public void testQuickSort1() {
		
		Point[] points = new Point[4];
		points[0] = new Point(1, 2);
		points[1] = new Point(3, 4);
		points[2] = new Point(5, 6);
		points[3] = new Point(7, 8);
		
		
		QuickSorter sorter = new QuickSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	
	@Test
	public void testQuickSort2() {
		Point[] points = new Point[4];
		points[0] = new Point(7, 8);
		points[1] = new Point(6, 5);
		points[2] = new Point(4, 3);
		points[3] = new Point(2, 1);
		
		QuickSorter sorter = new QuickSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
		assertTrue(points[2].compareTo(points[3]) < 0);
	}
	//now this ones not working
	@Test
	public void testQuickSort3WierdNumberPoints() {
		Point[] points = new Point[3];
		points[0] = new Point(7, 8);
		points[1] = new Point(6, 5);
		points[2] = new Point(4, 3);
		
		QuickSorter sorter = new QuickSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		
		
		assertTrue(points[0].compareTo(points[1]) < 0);
		assertTrue(points[1].compareTo(points[2]) < 0);
	}
	
	@Test
	public void testQuickSort4WierdNumberPoints() {
		Point[] points = new Point[10];
		points[0] = new Point(1, 8);
		points[1] = new Point(12, 5);
		points[2] = new Point(49, 3);
		points[3] = new Point(-43, 8);
		points[4] = new Point(-5, 5);
		points[5] = new Point(0, 3);
		points[6] = new Point(-50, 8);
		points[7] = new Point(20, 5);
		points[8] = new Point(4, 3);
		points[9] = new Point(7, 8);
		
		QuickSorter sorter = new QuickSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		//infinite loop at this sort
		
		sorter.setComparator(0);
		assertTrue(points[0].getX() <= points[1].getX());
		assertTrue(points[1].getX() <= points[2].getX());
		assertTrue(points[2].getX() <= points[3].getX());
		assertTrue(points[3].getX() <= points[4].getX());
		assertTrue(points[4].getX() <= points[5].getX());
		assertTrue(points[5].getX() <= points[6].getX());
		assertTrue(points[6].getX() <= points[7].getX());
		assertTrue(points[7].getX() <= points[8].getX());
		assertTrue(points[8].getX() <= points[9].getX());
	}
	
	@Test
	public void testQuickSortRandomPoints() {
		Point[] points = new Point[11];
		
		Random rand = new Random(5);
		points = CompareSorters.generateRandomPoints(10, rand);
		
		QuickSorter sorter = new QuickSorter(points);
		sorter.setComparator(0);
		sorter.sort();
		assertTrue(points[0].getX() <= points[1].getX());
		assertTrue(points[1].getX() <= points[2].getX());
		assertTrue(points[2].getX() <= points[3].getX());
		assertTrue(points[3].getX() <= points[4].getX());
		assertTrue(points[4].getX() <= points[5].getX());
		assertTrue(points[5].getX() <= points[6].getX());
		assertTrue(points[6].getX() <= points[7].getX());
		assertTrue(points[7].getX() <= points[8].getX());
		assertTrue(points[8].getX() <= points[9].getX());
	}
	
	@Test
	public void testQuickSort4WierdNumberPointsNowYs() {
		Point[] points = new Point[10];
		points[0] = new Point(1, 8);
		points[1] = new Point(12, 5);
		points[2] = new Point(49, 3);
		points[3] = new Point(-43, 8);
		points[4] = new Point(-5, 5);
		points[5] = new Point(0, 3);
		points[6] = new Point(-50, 8);
		points[7] = new Point(20, 5);
		points[8] = new Point(4, 3);
		points[9] = new Point(7, 8);
		
		QuickSorter sorter = new QuickSorter(points);
		sorter.setComparator(1);
		sorter.sort();
		//infinite loop at this sort
		
		sorter.setComparator(0);
		assertTrue(points[0].getY() <= points[1].getY());
		assertTrue(points[1].getY() <= points[2].getY());
		assertTrue(points[2].getY() <= points[3].getY());
		assertTrue(points[3].getY() <= points[4].getY());
		assertTrue(points[4].getY() <= points[5].getY());
		assertTrue(points[5].getY() <= points[6].getY());
		assertTrue(points[6].getY() <= points[7].getY());
		assertTrue(points[7].getY() <= points[8].getY());
		assertTrue(points[8].getY() <= points[9].getY());
	}


}
