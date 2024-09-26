package edu.iastate.cs228.hw2;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class CompareSorters {
	/**
	 * Repeatedly take integer sequences either randomly generated or read from
	 * files. Use them as coordinates to construct points. Scan these points with
	 * respect to their median coordinate point four times, each time using a
	 * different sorting algorithm.
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Performances of Four Sorting Algorithms in Point Scanning");
		System.out.println("");
		System.out.println("keys: 1 (random integers) 2 (file input) 3 (exit)");
		Scanner scnr = new Scanner(System.in);
		int key = 0;
		int i = 1;
		while (key != 3) {
			System.out.print("Trial " + i + ": ");
			i++;
			key = scnr.nextInt();
			if (key == 3) {
				scnr.close();
				break;
			} else if (key == 1) {
				// generate random points and do comparison on that
				System.out.print("Enter number of random points: ");
				int numPts = scnr.nextInt();
				Random rand = new Random();
				Point[] points = new Point[numPts];
				points = generateRandomPoints(numPts, rand);

				// now have points, go crazy with each sorter

				System.out.println("");
				System.out.println("algorithm       size   time (ns)");
				System.out.println("---------------------------------- ");

				// selection sort
				PointScanner ptScnr = new PointScanner(points, Algorithm.SelectionSort);
				ptScnr.scan();
				System.out.println(ptScnr.stats());

				// insertion sort
				ptScnr = new PointScanner(points, Algorithm.InsertionSort);
				ptScnr.scan();
				System.out.println(ptScnr.stats());

				// merge sort
				ptScnr = new PointScanner(points, Algorithm.MergeSort);
				ptScnr.scan();
				System.out.println(ptScnr.stats());

				// quicksort
				ptScnr = new PointScanner(points, Algorithm.QuickSort);
				ptScnr.scan();
				System.out.println(ptScnr.stats());

				// spacing
				System.out.println("---------------------------------- ");
				System.out.println("");

			} else if (key == 2) {

				/*
				 * example input tests\\points1.txt
				 */
				System.out.println("Points from a file");
				System.out.print("File name: ");
				String fileName = scnr.next();
				System.out.println("algorithm      size  time (ns)");
				System.out.println("---------------------------------- ");

				// selection sort
				PointScanner ptScnr = new PointScanner(fileName, Algorithm.SelectionSort);
				ptScnr.scan();
				System.out.println(ptScnr.stats());

				// insertion sort
				ptScnr = new PointScanner(fileName, Algorithm.InsertionSort);
				ptScnr.scan();
				System.out.println(ptScnr.stats());

				// merge sort
				ptScnr = new PointScanner(fileName, Algorithm.MergeSort);
				ptScnr.scan();
				System.out.println(ptScnr.stats());

				// quicksort
				ptScnr = new PointScanner(fileName, Algorithm.QuickSort);
				ptScnr.scan();
				System.out.println(ptScnr.stats());

				// spacing
				System.out.println("---------------------------------- ");
				System.out.println("");
			}
		}
	}

	/**
	 * This method generates a given number of random points. The coordinates of
	 * these points are pseudo-random numbers within the range [-50,50] � [-50,50].
	 * Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing.
	 * 
	 * @param numPts number of points
	 * @param rand   Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException {
		Point[] points = new Point[numPts];
		for (int i = 0; i < numPts; i++) {
			int randx = rand.nextInt(101) - 50;
			int randy = rand.nextInt(101) - 50;
			Point p = new Point(randx, randy);
			points[i] = p;
		}
		return points;
	}

}
