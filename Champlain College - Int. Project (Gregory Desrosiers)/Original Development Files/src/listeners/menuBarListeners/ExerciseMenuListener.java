/**
 * Desrosiers Mechanics Teaching Tool
 * Exercise Menu Listener
 * 
 * This is the listener for the Exercise Menu in the menu bar for Exercise Mode.
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

public class ExerciseMenuListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		/*
		 * The menu is assigned to several menu bars. The listener is kept as
		 * a separate class than the listeners already assigned to the actions
		 * for the menu when created.
		 */
		JMenu menuOfEventTrigger = Application.frame.getJMenuBar().getMenu(1);
		
		if (e.getSource() == menuOfEventTrigger.getItem(0) )
		{
			Application.dialogLabel.setText(DialogLabelText.exerciseModeGoToFirstExerciseUnimplementedMessage);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Exercises Unavailable", 
					JOptionPane.WARNING_MESSAGE);
		}
		else if (e.getSource() == menuOfEventTrigger.getItem(1))
		{
			Application.dialogLabel.setText(DialogLabelText.exerciseModeGoToLastExerciseUnimplementedMessage);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Exercises Unavailable", 
					JOptionPane.WARNING_MESSAGE);
		}
		else if (e.getSource() == menuOfEventTrigger.getItem(2))
		{
			Application.dialogLabel.setText(DialogLabelText.changeExerciseChapterMessage);
			
			byte selectedButton = (byte)
					(JOptionPane.showConfirmDialog(null, Application.dialogLabel, "Change Chapter for Exercises",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
			
			if (selectedButton == JOptionPane.YES_OPTION)
			{
				Application.frame.setJMenuBar(Application.centralProgramMenuBar);
				
				CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
				Application.currentPanelName = Application.EXERCISES_SELECT_NAME;
				mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			}
		}
		// When the user clicks on the button to quit Exercise Mode.
		else if (e.getSource() == menuOfEventTrigger.getItem(3))
		{
			Application.dialogLabel.setText(DialogLabelText.quitExerciseModeMessage);
			
			byte selectedButton = (byte)
					(JOptionPane.showConfirmDialog(null, Application.dialogLabel, "Quit Exercise Mode",
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
