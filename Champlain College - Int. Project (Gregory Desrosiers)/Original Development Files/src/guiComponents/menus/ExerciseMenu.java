/**
 * Desrosiers Mechanics Teaching Tool
 * Exercise Menu
 * 
 * This is where the Exercise Menu, for the Exercise Menu Bar, is built.
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

import guiComponents.menuBarActions.ExerciseMenuAction;


@SuppressWarnings("serial")
public class ExerciseMenu extends JMenu 
{
	// Menu Actions (Buttons with their associated properties)
	public ExerciseMenuAction goToFirstExerciseAction;
	public ExerciseMenuAction goToLastExerciseAction;
	public ExerciseMenuAction changeChapterAction;
	public ExerciseMenuAction quitExerciseModeAction;
	
	public ExerciseMenu()
	{
		// Menu Initialization
		setText("Exercise");
		setMnemonic('E');
		
		// Action Construction
		goToFirstExerciseAction = new ExerciseMenuAction("Go to First Exercise", 
				"Lets you get to the first exercise of this chapter in one go.", 
				KeyEvent.VK_G, KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
		
		goToLastExerciseAction = new ExerciseMenuAction("Go to Last Exercise", 
				"Lets you get to the last exercise of this chapter in one go.", 
				KeyEvent.VK_I, KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
		
		changeChapterAction = new ExerciseMenuAction("Change Chapter", 
				"Go to the Select Chapter Screen.", 
				KeyEvent.VK_C, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		
		quitExerciseModeAction = new ExerciseMenuAction("Quit Exercise Mode", 
				"Go back to the Main Menu.", 
				KeyEvent.VK_Q, KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		
		
		// Menu Assembly
		add(goToFirstExerciseAction);
		add(goToLastExerciseAction);
		add(changeChapterAction);
		add(quitExerciseModeAction);
	}
	
}
