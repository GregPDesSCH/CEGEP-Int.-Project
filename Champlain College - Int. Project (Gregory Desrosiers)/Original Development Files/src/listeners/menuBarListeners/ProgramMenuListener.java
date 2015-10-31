/**
 * Desrosiers Mechanics Teaching Tool
 * Program Menu Listener
 * 
 * This is the listener for the Program Menu in all menu bars of this program.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 21, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.menuBarListeners;

// Resource Packages
import java.awt.event.*;
import javax.swing.*;

// Interaction Class
import programCore.Application;

public class ProgramMenuListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		/*
		 * The menu is assigned to several menu bars. The listener is kept as
		 * a separate class than the listeners already assigned to the actions
		 * for the menu when created.
		 */
		JMenu menuOfEventTrigger = Application.frame.getJMenuBar().getMenu(0);
		
		// When the user clicks on the button to display the performance utility.
		if (e.getSource() == menuOfEventTrigger.getItem(0))
			Application.performanceUtility.showDialog();
		
		// When the user clicks on the button to quit the program.
		else if (e.getSource() == menuOfEventTrigger.getItem(2))
			Application.callingToQuitApplication();
	}
}
