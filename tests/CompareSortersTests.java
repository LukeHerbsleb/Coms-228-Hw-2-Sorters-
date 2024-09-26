package tests;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Test;
import edu.iastate.cs228.hw2.*;


public class CompareSortersTests {

	@Test
	public void testRandomPointGeneration() {
		Random generator = new Random(5);
		Point[] points = new Point[50];
		points = CompareSorters.generateRandomPoints(50, generator);
		
		for (int i = 0; i < 50; i++) {
			System.out.println(points[i].toString());
		}
		assertEquals(points[49].getX(), 41);
		assertEquals(points[49].getY(), 49);
	}

}
