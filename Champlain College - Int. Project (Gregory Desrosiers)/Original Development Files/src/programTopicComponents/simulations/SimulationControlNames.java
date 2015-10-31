/**
 * Desrosiers Mechanics Teaching Tool
 * Simulation Control Names
 * 
 * This class contains names the program needs to assign, in Simulation Mode,
 * the right control panel for the selected simulation. The general control panel
 * in the Simulation Panel uses a card layout that involves using names to
 * show a different panel that is added.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 2, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Comments added
 * 
 * *NOTE*: The algorithm to paint arrows is from this link:
 * http://stackoverflow.com/questions/4112701/drawing-a-line-with-arrow-in-java
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.simulations;

public class SimulationControlNames 
{
	// Control Names
	public static String chapter2Simulation1ControlPanelName;
	public static String chapter2Simulation2ControlPanelName;
	public static String chapter2Simulation3ControlPanelName;
	public static String chapter2Simulation4ControlPanelName;
	public static String chapter2Simulation5ControlPanelName;
	public static String chapter2Simulation6ControlPanelName;
	
	/**
	 * Initializes the names of the simulation control panels for use with
	 * the card layout in the Simulation Panel.
	 */
	public static void initializeNames()
	{
		chapter2Simulation1ControlPanelName = "ch2sim1";
		chapter2Simulation2ControlPanelName = "ch2sim2";
		chapter2Simulation3ControlPanelName = "ch2sim3";
		chapter2Simulation4ControlPanelName = "ch2sim4";
		chapter2Simulation5ControlPanelName = "ch2sim5";
		chapter2Simulation6ControlPanelName = "ch2sim6";
	}
}
