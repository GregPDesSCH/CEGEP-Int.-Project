/**
 * Desrosiers Mechanics Teaching Tool
 * Lecture Menu Listener
 * 
 * This is the listener for the Lecture Menu in the menu bar for Lecture Mode.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 21, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * UPDATE (May 17, 2014) - Dialog Title bug fixed.
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

// Resource Package and Class
import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.*;

// Interaction Classes (in the package)
import programCore.*;
import programTopicComponents.lectures.LectureManager;

public class LectureMenuListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		/*
		 * The menu is assigned to several menu bars. The listener is kept as
		 * a separate class than the listeners already assigned to the actions
		 * for the menu when created.
		 */
		JMenu menuOfEventTrigger = Application.frame.getJMenuBar().getMenu(1);
		
		if (e.getSource() == menuOfEventTrigger.getItem(0))
			LectureManager.goToFirstPage();
		else if (e.getSource() == menuOfEventTrigger.getItem(1))
			LectureManager.goToLastPage();
		else if (e.getSource() == menuOfEventTrigger.getItem(2))
		{
			Application.dialogLabel.setText(DialogLabelText.changeLectureMessage);
			
			byte selectedButton = (byte)
					(JOptionPane.showConfirmDialog(null, Application.dialogLabel, "Change Lecture",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
			
			if (selectedButton == JOptionPane.YES_OPTION)
			{
				Application.frame.setJMenuBar(Application.centralProgramMenuBar);
				
				CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
				Application.currentPanelName = Application.LECTURE_SELECT_NAME;
				mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			}
		}
		// When the user clicks on the button to quit Lecture Mode.
		else if (e.getSource() == menuOfEventTrigger.getItem(3))
		{
			Application.dialogLabel.setText(DialogLabelText.quitLectureModeMessage);
			
			byte selectedButton = (byte)
					(JOptionPane.showConfirmDialog(null, Application.dialogLabel, "Quit Lecture Mode",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
			
			if (selectedButton == JOptionPane.YES_OPTION)
			{
				Application.frame.setJMenuBar(Application.centralProgramMenuBar);
				
				Application.restartMainMenuThread();
				
				CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
				Application.currentPanelName = Application.MAIN_MENU_NAME;
				mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			}
		}
	}
}
