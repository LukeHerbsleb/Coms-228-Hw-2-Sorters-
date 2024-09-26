package edu.iastate.cs228.hw2;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * 
 * This class implements selection sort.
 *
 */

public class SelectionSorter extends AbstractSorter {

	/**
	 * Constructor takes an array of points. It invokes the superclass constructor,
	 * and also set the instance variables algorithm in the superclass.
	 * 
	 * @param pts
	 */
	public SelectionSorter(Point[] pts) {
		super(pts);
		algorithm = "selection sort";
	}

	/**
	 * Apply selection sort on the array points[] of the parent class
	 * AbstractSorter.
	 * 
	 */
	@Override
	public void sort() {
		int smallest = 0;
		for (int i = 0; i < points.length; i++) {
			// find the smallest element
			smallest = i;
			for (int j = i; j < points.length; j++) {
				if (pointComparator.compare(points[smallest], points[j]) > 0) {
					smallest = j;
				}
			}
			if (smallest != i) {
				swap(smallest, i);
			}
		}
	}
}
