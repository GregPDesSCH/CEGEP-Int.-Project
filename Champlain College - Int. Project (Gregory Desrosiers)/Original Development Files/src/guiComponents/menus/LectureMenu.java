/**
 * Desrosiers Mechanics Teaching Tool
 * Lecture Menu
 * 
 * This is where the Lecture Menu, for the Lecture Menu Bar, is built.
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

import guiComponents.menuBarActions.LectureMenuAction;


@SuppressWarnings("serial")
public class LectureMenu extends JMenu 
{	
	// Menu Actions (Buttons with their associated properties)
	public LectureMenuAction goToFirstPageAction;
	public LectureMenuAction goToLastPageAction;
	public LectureMenuAction changeLectureAction;
	public LectureMenuAction quitLectureModeAction;
	
	public LectureMenu()
	{
		// Menu Initialization
		setText("Lecture");
		setMnemonic('L');
		
		// Action Construction
		goToFirstPageAction  = new LectureMenuAction("Go to First Page", 
				"Takes you all the way to the first page of this lecture.", 
				KeyEvent.VK_F, KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
		
		goToLastPageAction = new LectureMenuAction("Go to Last Page", 
				"Takes you to the last page of this lecture.", 
				KeyEvent.VK_G, KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
		
		changeLectureAction = new LectureMenuAction("Change Lecture", 
				"Go to the Select Lecture Screen.", 
				KeyEvent.VK_C, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		
		quitLectureModeAction = new LectureMenuAction("Quit Lecture Mode", 
				"Go back to the Main Menu.", 
				KeyEvent.VK_Q, KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		
		// Menu Assembly
		add(goToFirstPageAction);
		add(goToLastPageAction);
		add(changeLectureAction);
		add(quitLectureModeAction);
		
	}
}
