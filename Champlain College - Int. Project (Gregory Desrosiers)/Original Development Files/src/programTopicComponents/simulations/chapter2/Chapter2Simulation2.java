/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 2
 * 
 * An unimplemented simulation where all it does is allow the icon and
 * description to appear when this simulation is selected from the Simulation
 * Selection Panel.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 25, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added to this file.
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

public class Chapter2Simulation2 extends Simulation
{
	// Simulation Description
	public static String simulationDescription;
	
	public Chapter2Simulation2()
	{
		// General Data Setup
		threadAvailable = false;
		animationSupported = true;
		simulationDescription = "Take a look at how velocity and acceleration can be visualized"
				+ " by animating two vectors, in real time, that are side by side. Adjust the "
				+ "individual details of the vectors for different ways on what they look like,"
				+ " and how they theoretically apply in real-life situations.";
	}
	
	public void paintIconGraphics(Graphics2D graphicsObject)
	{
		drawArrow(graphicsObject, 20.0f, 50.0f, 60.0f, 50.0f);
		graphicsObject.drawString("a", 29, 45);
		
		drawArrow(graphicsObject, 20.0f, 100.0f, 120.0f, 100.0f);
		graphicsObject.drawString("v", 29, 95);
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
