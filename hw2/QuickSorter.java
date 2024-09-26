package edu.iastate.cs228.hw2;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * 
 * This class implements the version of the quicksort algorithm presented in the
 * lecture.
 *
 */

public class QuickSorter extends AbstractSorter {


	/**
	 * Constructor takes an array of points. It invokes the superclass constructor,
	 * and also set the instance variables algorithm in the superclass.
	 * 
	 * @param pts input array of integers
	 */
	public QuickSorter(Point[] pts) {
		super(pts);
		algorithm = "quicksort";
	}

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.
	 * 
	 */
	@Override
	public void sort() {
		quickSortRec(0, points.length - 1);
	}

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first starting index of the subarray
	 * @param last  ending index of the subarray
	 */
	private void quickSortRec(int first, int last) {
		if (first >= last) { // base case
			return;
		}
		// else go crazy
		int dividingPoint = partition(first, last);

		// now recursivly sort the two sides
		quickSortRec(first, dividingPoint - 1);
		quickSortRec(dividingPoint + 1, last);
	}

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last) {
		Point pivot = points[first];

		int arr1Length = first;
		int currPivotPos = first;
		for (int i = first; i <= last; i++) {
			if ((pivot != points[i]) && pointComparator.compare(pivot, points[i]) >= 0) {

				this.swap(arr1Length, i);
				arr1Length++;

				if (arr1Length - 1 == currPivotPos) {//whenever the pivot moves track it with currPivotPos
					currPivotPos = i;
				}
				
			}
		}

		this.swap(arr1Length, currPivotPos); //swap pivot to the middle of the two arrays
		return arr1Length;
	}

}
