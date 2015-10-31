/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 5
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 25, 2014 - May 6, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.simulations.chapter2;

// Inheritance Class (for polymorphism)
import programTopicComponents.simulations.Simulation;

// Resource Classes and Interface
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import programTopicComponents.commonClasses.AstrophysicalData;

public class Chapter2Simulation5 extends Simulation
{
	// Simulation Description
	public static String simulationDescription;
	
	private Line2D.Float iconLine1 = new Line2D.Float(20.0f, 80.0f, 40.0f, 52.0f), 
			iconLine2 = new Line2D.Float(40.0f, 52.0f, 60.0f, 40.0f),
			iconLine3 = new Line2D.Float(60.0f, 40.0f, 80.0f, 40.0f),
			iconLine4 = new Line2D.Float(80.0f, 40.0f, 100.0f, 52.0f),
			iconLine5 = new Line2D.Float(100.0f, 52.0f, 120.0f, 80.0f);
	
	public static double currentGravitationalAcceleration;
	
	public static final double sizeOfProjectile = 2.5;
	public static float projectileX;
	public static float projectileY;

	public static float timeInterval;
	
	public Chapter2Simulation5()
	{
		// General Data Setup
		threadAvailable = false;
		animationSupported = true;
		simulationDescription = "Have you played Rovio\'s Angry Birds?"
				+ " Take a look at how the game's mechanics are applied not only to"
				+ " computer implementation, but also in other realistic situations too"
				+ " using this projectile simulator.";
		
		currentGravitationalAcceleration = AstrophysicalData.EARTH_SURFACE_GRAVITY;
	}
	
	public void paintIconGraphics(Graphics2D graphicsObject)
	{
		graphicsObject.draw(iconLine1);
		graphicsObject.draw(iconLine2);
		graphicsObject.draw(iconLine3);
		graphicsObject.draw(iconLine4);
		drawArrow(graphicsObject, iconLine5.getX1(), iconLine5.getY1(), 
				iconLine5.getX2(), iconLine5.getY2());
	}
	
	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void paintGraphics(Graphics2D graphicsObject) 
	{
		
	}
	
	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void resetSimulation()
	{
		
	}
	
	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void replaceThread()
	{
		
	}
	
	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void disposeThread()
	{
		
	}
	
	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void reinitializeControlPanel()
	{
		
	}

	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void setPropertiesForStartingAnimationThread() 
	{

	}

	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void setPropertiesForStoppingAnimationThread() 
	{
		
	}

	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void reEnableComponentsAfterReset() 
	{
		
	}

}
