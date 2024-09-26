package edu.iastate.cs228.hw2;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * 
 * This class implements the mergesort algorithm.
 *
 */

public class MergeSorter extends AbstractSorter {

	/**
	 * Constructor takes an array of points. It invokes the superclass constructor,
	 * and also set the instance variables algorithm in the superclass.
	 * 
	 * @param pts input array of integers
	 */
	public MergeSorter(Point[] pts) {
		super(pts);
		algorithm = "mergesort";
	}

	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter.
	 * 
	 */
	@Override
	public void sort() {
		this.points = mergeSortRec(points);
	}

	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of
	 * points. One way is to make copies of the two halves of pts[], recursively
	 * call mergeSort on them, and merge the two sorted subarrays into pts[].
	 * 
	 * @param pts point array
	 */
	private Point[] mergeSortRec(Point[] pts) {
		if (pts.length == 1) { // base case
			return pts;
		}
		int middle = pts.length / 2;
		// first
		Point[] array1 = new Point[pts.length / 2];
		Point[] array2 = new Point[pts.length - (pts.length / 2)];

		for (int i = 0; i < pts.length; i++) {
			if (i < middle) {
				array1[i] = pts[i];
			} else {
				array2[i - middle] = pts[i];
			}
		}
		array1 = mergeSortRec(array1);
		array2 = mergeSortRec(array2);

		return combineArrays(array1, array2);

	}

	private Point[] combineArrays(Point[] array1, Point[] array2) {
		int i = 0;
		int j = 0;
		int k = 0;
		int finalLength = array1.length + array2.length;
		Point[] returnArray = new Point[finalLength];

		// magic
		while (i < array1.length && j < array2.length) {
			if (array1[i].compareTo(array2[j]) < 0) {
				returnArray[k] = array1[i];
				k++;
				i++;
			} else {
				returnArray[k] = array2[j];
				k++;
				j++;
			}
		} // now one array is empty need to clear out the other
			// testing first array
		while (i < array1.length) {
			returnArray[k] = array1[i];
			k++;
			i++;
		}
		// now the other array
		while (j < array2.length) {
			returnArray[k] = array2[j];
			k++;
			j++;
		}
		return returnArray;

	}
}
