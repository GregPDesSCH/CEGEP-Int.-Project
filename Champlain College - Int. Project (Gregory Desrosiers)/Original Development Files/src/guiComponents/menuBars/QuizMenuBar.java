/**
 * Desrosiers Mechanics Teaching Tool
 * Quiz Menu Bar
 * 
 * This menu bar is shown when the user is in Quiz Mode.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Mar 21, 2014 - May 5, 2014)
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
public class QuizMenuBar extends JMenuBar 
{
	// Menus
	public ProgramMenu programMenu;
	public QuizMenu quizMenu;
	public OptionsMenu optionsMenu;	
	
	public QuizMenuBar()
	{
		programMenu = new ProgramMenu();
		quizMenu = new QuizMenu();
		optionsMenu = new OptionsMenu();
		
		add(programMenu);
		add(quizMenu);
		add(optionsMenu);
	}
}
