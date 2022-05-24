package com.saltygeek.geospacial;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for LatLng
 */
public class LatLngTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public LatLngTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(LatLngTest.class);
	}

	/**
	 * test the constructor
	 */
	public void testConstDegrees() {
		LatLng ll = new LatLngDegrees(48.390081, -123.414670);
		assertEquals(48.390081, ll.getLat());
		assertEquals(-123.414670, ll.getLng());
	}

	/**
	 * test the constructor
	 */
	public void testConstRadians() {
		LatLng ll = new LatLngRadians(0.8445662387567502, -2.15399233676227);
		assertEquals(0.8445662387567502, ll.getLat());
		assertEquals(-2.15399233676227, ll.getLng());
	}

	/**
	 * test the constructor
	 */
	public void testConstNormalizeDegrees() {
		LatLng ll = new LatLngDegrees(48.390081, -185.414670);
		assertEquals(48.390081, ll.getLat());
		assertEquals(174.58533, ll.getLng());

		ll = new LatLngDegrees(48.390081, 185.414670);
		assertEquals(48.390081, ll.getLat());
		assertEquals(-174.58533, ll.getLng());
	}

	/**
	 * test the constructor
	 */
	public void testConstNormalizeRadians() {
		LatLng ll = new LatLngRadians(0.8445662387567502, -3.174334);
		assertEquals(0.8445662387567502, ll.getLat());
		assertEquals(3.1088513071795862, ll.getLng());

		ll = new LatLngRadians(0.8445662387567502, 3.17333);
		assertEquals(0.8445662387567502, ll.getLat());
		assertEquals(-3.1098553071795862, ll.getLng());
	}

	/**
	 * Destination Point
	 */
	public void testDestinationPointDegrees() {
		LatLng src = new LatLngDegrees(48.390081, -123.414670);
		System.out.println("source: " + src);
		LatLng dst = src.destinationPoint(1000, LatLngDegrees.S);
		System.out.println("destination: " + dst);
		LatLng dst2 = dst.destinationPoint(1000, LatLngDegrees.W);
		System.out.println("destination: " + dst2);
		LatLng dst3 = dst2.destinationPoint(1000, LatLngDegrees.N);
		System.out.println("destination: " + dst3);
		LatLng dst4 = dst3.destinationPoint(1000, LatLngDegrees.E);
		System.out.println("destination: " + dst4);
		// great circle means the points will just miss each other...
		assertEquals(src.getLat(), dst4.getLat(), 0.00001);
		assertEquals(src.getLng(), dst4.getLng(), 0.00001);
	}

	/**
	 * Destination Point
	 */
	public void testDestinationPointRadians() {
		LatLng src = new LatLngRadians(0.8445662387567502, -2.15399233676227);
		System.out.println("source: " + src);
		LatLng dst = src.destinationPoint(1000, LatLngRadians.S);
		System.out.println("destination: " + dst);
		LatLng dst2 = dst.destinationPoint(1000, LatLngRadians.W);
		System.out.println("destination: " + dst2);
		LatLng dst3 = dst2.destinationPoint(1000, LatLngRadians.N);
		System.out.println("destination: " + dst3);
		LatLng dst4 = dst3.destinationPoint(1000, LatLngRadians.E);
		System.out.println("destination: " + dst4);
		// great circle means the points will just miss each other...
		assertEquals(src.getLat(), dst4.getLat(), 0.0000001);
		assertEquals(src.getLng(), dst4.getLng(), 0.0000001);
	}

	/**
	 * Distance
	 */
	public void testDistance() {
		LatLng src = new LatLngDegrees(48.390081, -123.414670);
		LatLng dst = new LatLngDegrees(48.38108778394081, -123.41467);
		assertEquals(1000.0, src.distance(dst), 0.0000001);
	}

	/**
	 * Distance
	 */
	public void testDistanceRadians() {
		LatLng src = new LatLngRadians(0.8445662387567502, -2.15399233676227);
		LatLng dst = new LatLngRadians(0.8444092775261741, -2.15399233676227);
		assertEquals(1000, src.distance(dst), 0.0000001);
	}
}
