package com.saltygeek.geospacial;

import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;

/**
 * <p>
 * Geospacial library. Based on algorithms from
 * <a href='http://www.movable-type.co.uk/scripts/latlong.html'>this website</a>
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
public class LatLngDegrees extends LatLngRadians implements LatLng {

	/** Bearing North in radians */
	public static final double N = 0.0;

	/** Bearing East in radians */
	public static final double E = 90.0;

	/** Bearing South in radians */
	public static final double S = 180.0;

	/** Bearing West in radians */
	public static final double W = 270.0;

	public LatLngDegrees(double lat, double lng) {
		super(toRadians(lat), toRadians(lng));
	}

	public LatLngDegrees(LatLngRadians destinationPoint) {
		super(destinationPoint);
	}

	@Override
	public double getLat() {
		return toDegrees(lat);
	}

	@Override
	public double getLng() {
		return toDegrees(lng);
	}

	@Override
	public LatLngDegrees destinationPoint(double distance, double bearing) {
		return new LatLngDegrees(super.destinationPoint(distance, toRadians(bearing)));
	}
	
	@Override
	public String toString() {
		return getLat() + ", " + getLng();
	}

}
