package com.saltygeek.geospacial;

import static java.lang.Math.asin;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.PI;

/**
 * <p>
 * Geospacial library. Based on algorithms from
 * <a href='http://www.movable-type.co.uk/scripts/latlong.html'>this website</a>
 * </p>
 * 
 * <p>
 * All angles, including latitude and longitude, are stored in radians.
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
public class LatLngRadians implements LatLng {
	private static final Logger logger = LogManager.getLogger(LatLngRadians.class);

	/** Latitude in radians */
	final double lat;

	/** longitude in radians */
	final double lng;

	/** The mean radius of earth in meters */
	final static double R = 6371e3;

	/** Bearing North in radians */
	public static final double N = 0.0;

	/** Bearing East in radians */
	public static final double E = PI / 2;

	/** Bearing South in radians */
	public static final double S = PI;

	/** Bearing West in radians */
	public static final double W = PI * 3 / 2;

	/**
	 * Constructor. Longitude is automatically normalized to +/- pi
	 * 
	 * @param lat latitude
	 * @param lng longitude
	 */
	public LatLngRadians(double lat, double lng) {
		this.lat = lat;
		if (lng > PI) {
			while (lng > PI)
				lng -= PI * 2.0;
		} else if (lng < -PI) {
			while (lng < -PI)
				lng += PI * 2.0;
		}
		this.lng = lng;
	}

	public LatLngRadians(LatLngRadians o) {
		lat = o.lat;
		lng = o.lng;
	}

	@Override
	public double getLat() {
		return lat;
	}

	@Override
	public double getLng() {
		return lng;
	}

	@Override
	public double getLatRadians() {
		return lat;
	}

	@Override
	public double getLngRadians() {
		return lng;
	}

	/**
	 * Destination point given distance and bearing from start point
	 * 
	 * @param distance distance in meters
	 * @param bearing  in radians
	 * @return the destination point
	 */
	@Override
	public LatLngRadians destinationPoint(double distance, double bearing) {
		double ad = distance / R;
		double destinationLat = asin(sin(lat) * cos(ad) + cos(lat) * sin(ad) * cos(bearing));
		double destinationLng = lng
				+ atan2(sin(bearing) * sin(ad) * cos(lat), cos(ad) - sin(lat) * sin(destinationLat));
		if (logger.isDebugEnabled()) {
			logger.debug("distance = " + distance + ", bearing = " + bearing + ", lat = " + lat + ", lng = " + lng);
		}
		return new LatLngRadians(destinationLat, destinationLng);
	}

	/**
	 * Distance in meters between two points.
	 * 
	 * @param other the other point.
	 * @return the distance in meters
	 */
	@Override
	public double distance(LatLng other) {
		final double dO = (other.getLatRadians() - lat);
		final double dy = (other.getLngRadians() - lng);

		final double a = sin(dO / 2) * sin(dO / 2) + cos(lat) * cos(other.getLatRadians()) * sin(dy / 2) * sin(dy / 2);
		final double c = 2 * atan2(sqrt(a), sqrt(1 - a));
		return R * c;
	}

	@Override
	public String toString() {
		return getLat() + ", " + getLng();
	}
}
