package com.saltygeek.geospacial;

/**
 * <p>
 * Geospacial library. Based on algorithms from
 * <a href='http://www.movable-type.co.uk/scripts/latlong.html'>this website</a>
 * </p>
 * 
 * <p>
 * This interface does not specify the angle units. For degrees, use
 * {@link com.saltygeek.geospacial.LatLngDegrees}. For radians, use
 * {@link com.saltygeek.geospacial.LatLngRadians}. <s>Note:</s> radians are more
 * efficient. Degrees will be converted to radians for storing.
 * </p>
 * 
 * <p>
 * Copyright (c) 2026 Glen Dinsmore
 * </p>
 * 
 * <p>
 * This code is licensed under the MIT License.
 * </p>
 * 
 * @author Glen Dinsmore
 *
 */
public interface LatLng {

	/** The latitude */
	public double getLat();

	/** The longitude */
	public double getLng();

	/** The latitude */
	public double getLatRadians();

	/** The longitude */
	public double getLngRadians();

	/**
	 * Destination point given distance and bearing from start point.
	 * 
	 * @param distance distance in meters
	 * @param bearing  the heading that the vesile is going when the journey begins
	 * @return the destination point
	 */
	public LatLng destinationPoint(double distance, double bearing);

	/**
	 * Distance in meters between two points.
	 * 
	 * @param latLng the other point.
	 * @return the distance in meters
	 */
	public double distance(LatLng latLng);

}
