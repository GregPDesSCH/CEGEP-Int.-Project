/**
 * Desrosiers Mechanics Teaching Tool
 * Program Menu
 * 
 * This is the common menu for all menu bars in this program. It contains
 * only two buttons: to display a debugging utility built along this program,
 * and to exit the program any time.
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
package guiComponents.menus;

// Resource Packages and Class
import java.awt.event.*;
import javax.swing.*;

import guiComponents.menuBarActions.ProgramMenuAction;


@SuppressWarnings("serial")
public class ProgramMenu extends JMenu 
{
	// Menu Actions (Buttons with their associated properties)
	public ProgramMenuAction displayPerformanceUtilityAction;
	public ProgramMenuAction exitAction;
	
	public ProgramMenu()
	{
		// Menu Initialization
		setText("Program");
		setMnemonic('P');
		
		// Action Construction
		displayPerformanceUtilityAction = new ProgramMenuAction("Display Performance Utility", 
				"Opens up a utility displaying system and program info, such as CPU usage.", 
				KeyEvent.VK_D, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		
		exitAction = new ProgramMenuAction("Exit", "Quits the program.", 
				KeyEvent.VK_X, KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		
		// Menu Assembly
		add(displayPerformanceUtilityAction);
		add(new JSeparator());
		add(exitAction);
	}
}
