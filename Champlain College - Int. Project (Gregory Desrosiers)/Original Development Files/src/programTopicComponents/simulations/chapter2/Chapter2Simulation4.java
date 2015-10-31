/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 4
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



// Resource Class
import java.awt.Graphics2D;

public class Chapter2Simulation4 extends Simulation
{
	// Simulation Description
	public static String simulationDescription;
	
	public Chapter2Simulation4()
	{
		// General Data Setup
		threadAvailable = false;
		animationSupported = true;
		simulationDescription = "Take a look at constant acceleration as the basic step"
				+ " in describing acceleration; see on how it changes the velocity vector, "
				+ "and most importantly, change the displacement of an object at any given"
				+ " time interval.";
	}
	
	public void paintIconGraphics(Graphics2D graphicsObject)
	{
		drawArrow(graphicsObject, 105.0f, 110.0f, 40.0f, 25.0f);
		graphicsObject.drawString("v", 69.0f, 85.0f);
		
		drawArrow(graphicsObject, 30.0f, 15.0f, 85.0f, 8.0f);
		graphicsObject.drawString("a", 59.0f, 22.0f);
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
