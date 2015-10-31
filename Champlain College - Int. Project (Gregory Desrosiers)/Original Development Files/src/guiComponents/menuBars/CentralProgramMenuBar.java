/**
 * Desrosiers Mechanics Teaching Tool
 * Central Program Menu Bar
 * 
 * This is the menu bar that's shown in the main menu, selection screens,
 * and animated credits screen.
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
public class CentralProgramMenuBar extends JMenuBar
{
	// Menus
	public ProgramMenu programMenu;
	public OptionsMenu optionsMenu;
	
	public CentralProgramMenuBar()
	{
		programMenu = new ProgramMenu();
		optionsMenu = new OptionsMenu();
		
		add(programMenu);
		add(optionsMenu);
	}
}
