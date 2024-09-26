package edu.iastate.cs228.hw2;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * 
 * This class implements insertion sort.
 *
 */

public class InsertionSorter extends AbstractSorter {

	/**
	 * Constructor takes an array of points. It invokes the superclass constructor,
	 * and also set the instance variables algorithm in the superclass.
	 * 
	 * @param pts
	 */
	public InsertionSorter(Point[] pts) {
		super(pts);
		algorithm = "insertion sort";
	}

	/**
	 * Perform insertion sort on the array points[] of the parent class
	 * AbstractSorter.
	 */
	@Override
	public void sort() {
		for (int i = 0; i < points.length; i++) {
			Point nextPoint = points[i];
			for (int j = i - 1; j >= 0; j--) {
				if (pointComparator.compare(nextPoint, points[j]) < 0) { // then nextpoint belongs before point j
					swap(j + 1, j);
				}
			}
		}
	}
}
