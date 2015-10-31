/**
 * Desrosiers Mechanics Teaching Tool
 * Exercise Menu Bar
 * 
 * This menu bar is shown when the user is in Exercise Mode.
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

// Resource Package and Class
import guiComponents.menus.*;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class ExerciseMenuBar extends JMenuBar 
{	
	// Menus
	public ProgramMenu programMenu;
	public ExerciseMenu exerciseMenu;
	public OptionsMenu optionsMenu;
	
	public ExerciseMenuBar()
	{
		programMenu = new ProgramMenu();
		exerciseMenu = new ExerciseMenu();
		optionsMenu = new OptionsMenu();
		
		add(programMenu);
		add(exerciseMenu);
		add(optionsMenu);
	}
}
