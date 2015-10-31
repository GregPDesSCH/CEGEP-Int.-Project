/**
 * Desrosiers Mechanics Teaching Tool
 * Main Menu Panel Listener
 * 
 * This is the listener for the Main Menu Panel.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (February 21, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * UPDATE (May 19, 2014) - Name constants declared in the Application class 
 * have been changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.mainListeners;

// Resource Classes and Packages
import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.JOptionPane;

// Interaction Classes
import programCore.Application;
import programCore.DialogLabelText;

public class MainMenuPanelListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Application.mainMenuPanel.lecturesButton)
		{
			Application.stopMainMenuThread();
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.LECTURE_SELECT_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			
			Application.lectureSelectionPanel.sectionComboBox.setPopupVisible(true);
		}
		
		else if (e.getSource() == Application.mainMenuPanel.simulationsButton)
		{
			Application.stopMainMenuThread();
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.SIMULATION_SELECT_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
		}
		
		else if (e.getSource() == Application.mainMenuPanel.exercisesButton)
		{
			Application.dialogLabel.setText(DialogLabelText.exercisesModeUnimplementedMessage);
			
			byte selectedOption = (byte)(JOptionPane.showConfirmDialog(null, Application.dialogLabel, 
					"Exercise Mode Not Available", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE));
			
			if (selectedOption == JOptionPane.YES_OPTION)
			{
				Application.stopMainMenuThread();
			
				CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
				Application.currentPanelName = Application.EXERCISES_SELECT_NAME;
				mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			}
		}
		
		else if (e.getSource() == Application.mainMenuPanel.quizzesButton)
		{
			Application.dialogLabel.setText(DialogLabelText.quizModeUnimplementedMessage);
			
			byte selectedOption = (byte)(JOptionPane.showConfirmDialog(null, Application.dialogLabel, 
					"Quiz Mode Not Available", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE));
			
			if (selectedOption == JOptionPane.YES_OPTION)
			{
				Application.stopMainMenuThread();
			
				CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
				Application.currentPanelName = Application.QUIZ_SELECT_NAME;
				mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			}
		}
		
		else if (e.getSource() == Application.mainMenuPanel.creditsButton)
		{
			Application.stopMainMenuThread();
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.CREDITS_PANEL_NAME;
			
			Application.creditsThread = new Thread(Application.creditsTask);
			Application.creditsThread.start();
			
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
		}
		
		else if (e.getSource() == Application.mainMenuPanel.quitButton)
			Application.callingToQuitApplication();
	}
	
	
}
