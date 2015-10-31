/**
 * Desrosiers Mechanics Teaching Tool
 * Options Menu Listener
 * 
 * This is the listener of the Options Menu for all menu bars in this program.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 21, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * UPDATE (May 17, 2014) - About Dialog updated.
 * UPDATE (May 19, 2014) - Name constants declared in the Application class 
 * have been changed.
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

// Interaction Classes
import guiComponents.panels.AnimatedCreditsPanel;
import programCore.Application;
import programCore.DialogLabelText;

public class OptionsMenuListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		/*
		 * The menu is assigned to several menu bars. The listener is kept as
		 * a separate class than the listeners already assigned to the actions
		 * for the menu when created.
		 */
		JMenuBar menuBarOfEventTrigger = Application.frame.getJMenuBar();
		JMenu menuOfEventTrigger = menuBarOfEventTrigger.getMenu(menuBarOfEventTrigger.getMenuCount() - 1);
		
		if (Application.currentPanelName.equals(Application.CREDITS_PANEL_NAME))
			AnimatedCreditsPanel.yPosAtBottomOfCredits = -50.0f;
		
		// When the user clicks on the button to display the about dialog.
		if (e.getSource() == menuOfEventTrigger.getItem(0))
		{
			Application.dialogLabel.setText(DialogLabelText.aboutDialogMessage);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "About", 
					JOptionPane.INFORMATION_MESSAGE);
		}
		// When the user clicks on the button to display the credits utility.
		else if (e.getSource() == menuOfEventTrigger.getItem(1))
		{
			Application.simpleCreditsUtility.textArea.setCaretPosition(0);
			Application.simpleCreditsUtility.setVisible(true);
		}
	}
}
