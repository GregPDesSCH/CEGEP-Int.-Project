/**
 * Desrosiers Mechanics Teaching Tool
 * Simulation Menu Bar
 * 
 * This menu bar is shown when the user is in Simulation Mode.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Mar 21, 2014 - May 7, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.menuBars;

// Resource Class and Package
import javax.swing.JMenuBar;
import guiComponents.menus.*;

@SuppressWarnings("serial")
public class SimulationMenuBar extends JMenuBar
{	
	// Menus
	public ProgramMenu programMenu;
	public SimulationMenu simulationMenu;
	public OptionsMenu optionsMenu;
	
	public SimulationMenuBar()
	{
		programMenu = new ProgramMenu();
		simulationMenu = new SimulationMenu();
		optionsMenu = new OptionsMenu();
		
		add(programMenu);
		add(simulationMenu);
		add(optionsMenu);
	}
}
