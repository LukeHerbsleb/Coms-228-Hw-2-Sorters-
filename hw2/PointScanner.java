package edu.iastate.cs228.hw2;

import java.io.File;

/**
 * 
 * @author Luke Herbsleb
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * This class sorts all the points in an array of 2D points to determine a
 * reference point whose x and y coordinates are respectively the medians of the
 * x and y coordinates of the original points.
 * 
 * It records the employed sorting algorithm as well as the sorting time for
 * comparison.
 *
 */
public class PointScanner {
	private Point[] points;

	private Point medianCoordinatePoint; // point whose x and y coordinates are respectively the medians of
											// the x coordinates and y coordinates of those points in the array
											// points[].
	private Algorithm sortingAlgorithm;

	protected long scanTime; // execution time in nanoseconds.

	/**
	 * This constructor accepts an array of points and one of the four sorting
	 * algorithms as input. Copy the points into the array points[].
	 * 
	 * @param pts input array of points
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException {
		if (pts == null || pts.length == 0) {
			throw new IllegalArgumentException();
		}
		points = pts;
		sortingAlgorithm = algo;
	}

	/**
	 * This constructor reads points from a file.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 * @throws InputMismatchException if the input file contains an odd number of
	 *                                integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException {
		sortingAlgorithm = algo;
		File f = new File(inputFileName);
		Scanner scnr = new Scanner(f);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while (scnr.hasNextInt()) {
			nums.add(scnr.nextInt());
		}
		scnr.close();
		if ((nums.size()) % 2 != 0) {
			throw new InputMismatchException();
		}
		points = new Point[nums.size() / 2];
		for (int i = 0; i < nums.size(); i += 2) { // create every point
			Point p = new Point(nums.get(i), nums.get(i + 1));
			int n = i / 2;
			points[n] = p;
		}
	}

	/**
	 * Carry out two rounds of sorting using the algorithm designated by
	 * sortingAlgorithm as follows:
	 * 
	 * a) Sort points[] by the x-coordinate to get the median x-coordinate. b) Sort
	 * points[] again by the y-coordinate to get the median y-coordinate. c)
	 * Construct medianCoordinatePoint using the obtained median x- and
	 * y-coordinates.
	 * 
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter,
	 * InsertionSorter, MergeSorter, or QuickSorter to carry out sorting.
	 * 
	 * @param algo
	 * @return
	 */
	public void scan() {
		AbstractSorter aSorter;

		// create an object to be referenced by aSorter according to sortingAlgorithm.
		// for each of the two
		// rounds of sorting, have aSorter do the following:
		//
		// a) call setComparator() with an argument 0 or 1.
		//
		// b) call sort().
		//
		// c) use a new Point object to store the coordinates of the
		// medianCoordinatePoint
		//
		// d) set the medianCoordinatePoint reference to the object with the correct
		// coordinates.
		//
		// e) sum up the times spent on the two sorting rounds and set the instance
		// variable scanTime.

		// create correct sorting algorythm
		if (sortingAlgorithm.equals(Algorithm.InsertionSort)) {
			aSorter = new InsertionSorter(points);
		} else if (sortingAlgorithm.equals(Algorithm.SelectionSort)) {
			aSorter = new SelectionSorter(points);
		} else if (sortingAlgorithm.equals(Algorithm.MergeSort)) {
			aSorter = new MergeSorter(points);
		} else if (sortingAlgorithm.equals(Algorithm.QuickSort)) {
			aSorter = new QuickSorter(points);
		} else {
			System.out.println("couldnt find correct algorythm");
			return;
		}

		// sort according to x's
		aSorter.setComparator(0);
		long time0 = System.nanoTime();
		aSorter.sort();
		long time1 = System.nanoTime() - time0;

		aSorter.getPoints(points);
		int medianX = points[points.length / 2].getX();

		// now sort y's
		aSorter.setComparator(1);
		time0 = System.nanoTime();
		aSorter.sort();
		long time2 = System.nanoTime() - time0;

		aSorter.getPoints(points);
		int medianY = points[points.length / 2].getY();

		scanTime = (time1 + time2) / 2;

		// now create the median coordinate point with the median x and median y
		medianCoordinatePoint = new Point(medianX, medianY);

	}

	/**
	 * Outputs performance statistics in the format:
	 * 
	 * <sorting algorithm> <size> <time>
	 * 
	 * For instance,
	 * 
	 * selection sort 1000 9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description.
	 */
	public String stats() {
		String returnString = "";
		// add the sorting algorythm name
		if (sortingAlgorithm.equals(Algorithm.SelectionSort)) {
			returnString += "selectionSort   ";
		} else if (sortingAlgorithm.equals(Algorithm.InsertionSort)) {
			returnString += "insertionSort   ";
		} else if (sortingAlgorithm.equals(Algorithm.MergeSort)) {
			returnString += "MergeSort       ";
		} else if (sortingAlgorithm.equals(Algorithm.QuickSort)) {
			returnString += "QuickSort       ";
		} else {
			returnString += "UnknownSortType ";
		}

		// number of points
		returnString += ("" + points.length);

		// time to sort
		returnString += ("   " + scanTime);

		return returnString;
	}

	/**
	 * Write MCP after a call to scan(), in the format "MCP: (x, y)" The x and y
	 * coordinates of the point are displayed on the same line with exactly one
	 * blank space in between.
	 */
	@Override
	public String toString() {
		String returnString = ("MCP: (" + medianCoordinatePoint.getX() + ", " + medianCoordinatePoint.getY() + ")");
		return returnString;
	}

	/**
	 * 
	 * This method, called after scanning, writes point data into a file by
	 * outputFileName. The format of data in the file is the same as printed out
	 * from toString(). The file can help you verify the full correctness of a
	 * sorting result and debug the underlying algorithm.
	 * 
	 * @throws IOException
	 */
	public void writeMCPToFile() throws FileNotFoundException {
		try {
			// printwriter
			// og outputFileName.txt
			File file = new File("edu\\iastate\\cs228\\hw2\\outputFileName.txt");
			PrintWriter f = new PrintWriter(file);
			String mcp = this.medianCoordinatePoint.toString();
			f.print(mcp);
			f.flush();
			System.out.println("worked?");
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileNotFoundException();
		}
	}

}
