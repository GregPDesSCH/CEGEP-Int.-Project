/**
 * Desrosiers Mechanics Teaching Tool - AstrophysicalData Interface
 * 
 * Holds all information of the planets, from Richard Wolfson's Essential University Physics,
 * Volume II, for use on universal gravitation and other equations on gravity.
 * 
 * Additional astrophysical data retrieved from Wikipedia.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 24, 2014 - Feb 25, 2014)
 * 
 * UPDATE (May 13, 2014) - Comment added
 * UPDATE (May 17, 2014) - Unnecessary fields have been removed. In particular, each planet's
 * mass, mean radius, escape speed, and orbital period.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.commonClasses;

public interface AstrophysicalData
{
	// Sun
	double SUN_SURFACE_GRAVITY = 274.0;
	
	// Mercury
	double MERCURY_SURFACE_GRAVITY = 3.70;
	
	// Venus
	double VENUS_SURFACE_GRAVITY = 8.87;
	
	// Earth
	double EARTH_SURFACE_GRAVITY = 9.81;
	
	// Moon
	double MOON_SURFACE_GRAVITY = 1.62;
	
	// Mars
	double MARS_SURFACE_GRAVITY = 3.74;
	
	// Jupiter
	double JUPITER_SURFACE_GRAVITY = 26.5;
	
	// Io
	double IO_SURFACE_GRAVITY = 1.8;
	
	// Europa
	double EUROPA_SURFACE_GRAVITY = 1.3;
	
	// Saturn
	double SATURN_SURFACE_GRAVITY = 11.8;
	
	// Uranus
	double URANUS_SURFACE_GRAVITY = 9.23;
	
	// Titania
	double TITANIA_SURFACE_GRAVITY = 0.3;
	
	// Neptune
	double NEPTUNE_SURFACE_GRAVITY = 11.9;
	
	// Ceres
	double CERES_SURFACE_GRAVITY = 0.27;
	
	// Pluto
	double PLUTO_SURFACE_GRAVITY = 0.58;
}
