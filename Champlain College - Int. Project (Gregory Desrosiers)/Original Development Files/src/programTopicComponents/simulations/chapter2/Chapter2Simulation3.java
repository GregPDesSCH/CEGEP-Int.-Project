/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 3
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

public class Chapter2Simulation3 extends Simulation
{
	// Simulation Description
	public static String simulationDescription;
	
	public Chapter2Simulation3()
	{
		// General Data Setup
		threadAvailable = false;
		animationSupported = true;
		simulationDescription = "See on how velocities don't necessarily have to be based"
				+ " on the ground; they can also be applied to objects in motion as well,"
				+ " assuming they are moving in the same dimensional space such as the real "
				+ "world.";
	}
	
	public void paintIconGraphics(Graphics2D graphicsObject)
	{
		drawArrow(graphicsObject, 20.0f, 50.0f, 60.0f, 50.0f);
		graphicsObject.drawString("v", 29, 45);
		
		drawArrow(graphicsObject, 20.0f, 75.0f, 120.0f, 75.0f);
		graphicsObject.drawString("V", 29, 70);
		
		drawArrow(graphicsObject, 60.0f, 50.0f, 120.0f, 50.0f);
		graphicsObject.drawString("v\'", 69, 45);
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
