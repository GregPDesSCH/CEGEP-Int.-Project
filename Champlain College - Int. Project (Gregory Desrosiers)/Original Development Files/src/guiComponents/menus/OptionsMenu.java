/**
 * Desrosiers Mechanics Teaching Tool
 * Options Menu
 * 
 * This menu holds the action buttons necessary for the program to
 * display an options utility, an About dialog, a credits utility. There
 * are several ways to get onto the same options utility, except that when
 * that utility is opened, the tab displayed is determined by which action
 * is clicked.
 * 
 * For this lite version, the only thing this menu holds are two actions:
 * the about dialog and the credits utility.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Mar 28, 2014 - May 5, 2014)
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

import guiComponents.menuBarActions.OptionsMenuAction;


@SuppressWarnings("serial")
public class OptionsMenu extends JMenu 
{
	// Menu Actions (Buttons with their associated properties)
	public OptionsMenuAction aboutAction;
	public OptionsMenuAction creditsAction;
	
	public OptionsMenu()
	{
		// Menu Initialization
		setText("Options");
		setMnemonic('O');
		
		// Action Construction
		aboutAction = new OptionsMenuAction("About", 
				"Displays the program's About dialog.", 
				KeyEvent.VK_A, KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
		
		creditsAction = new OptionsMenuAction("Credits", 
				"Displays a utility that shows who did what in developing this program.", 
				KeyEvent.VK_R, KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));
		
		// Menu Assembly
		add(aboutAction);
		add(creditsAction);
	}
}
