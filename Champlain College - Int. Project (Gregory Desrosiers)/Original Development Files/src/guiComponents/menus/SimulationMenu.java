/**
 * Desrosiers Mechanics Teaching Tool
 * Simulation Menu
 * 
 * This is where the Simulation Menu, for the Simulation Menu Bar, is built.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Mar 27, 2014 - May 5, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.menus;

// Resource Packages and Class
import java.awt.event.*;
import javax.swing.*;

import guiComponents.menuBarActions.SimulationMenuAction;


@SuppressWarnings("serial")
public class SimulationMenu extends JMenu 
{
	// Menu Actions (Buttons with their associated properties)
	public SimulationMenuAction startAction;
	public SimulationMenuAction stopAction;
	public SimulationMenuAction resetAction;
	public SimulationMenuAction changeSimulationAction;
	public SimulationMenuAction quitSimulationModeAction;
	
	public SimulationMenu()
	{
		// Menu Initialization
		setText("Simulation");
		setMnemonic('S');
		
		// Action Construction
		startAction = new SimulationMenuAction("Start", 
				"Execute, or start, the simulation.", 
				KeyEvent.VK_S, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		
		stopAction = new SimulationMenuAction("Stop", 
				"Terminate, or stop, the simulation.", 
				KeyEvent.VK_O, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		
		resetAction = new SimulationMenuAction("Reset", 
				"Sets the simulation to default settings.", 
				KeyEvent.VK_E, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		
		changeSimulationAction = new SimulationMenuAction("Change Simulation", 
				"Go to the Select Simulation Screen.", 
				KeyEvent.VK_C, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		
		quitSimulationModeAction = new SimulationMenuAction("Quit Simulation Mode", 
				"Go back to the Main Menu.", 
				KeyEvent.VK_Q, KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		
		// Menu Assembly
		add(startAction);
		add(stopAction);
		add(resetAction);
		add(changeSimulationAction);
		add(quitSimulationModeAction);
	}
}
