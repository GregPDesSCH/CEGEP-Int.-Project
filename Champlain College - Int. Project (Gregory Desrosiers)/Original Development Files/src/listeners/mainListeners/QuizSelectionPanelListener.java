/**
 * Desrosiers Mechanics Teaching Tool
 * Quiz Selection Panel Listener
 * 
 * This is the listener for the Quiz Selection Panel. Two listener interfaces
 * are used because the panel is to respond to changes from the time limit
 * spinners as well.
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

// Resource Packages and Class
import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.event.*;

// Interaction Class
import programCore.Application;

public class QuizSelectionPanelListener implements ActionListener, ChangeListener
{
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Application.quizSelectionPanel.yesTimerRadioButton)
		{
			Application.quizSelectionPanel.minuteSpinner.setEnabled(true);
			Application.quizSelectionPanel.secondSpinner.setEnabled(true);
		}
		
		else if (e.getSource() == Application.quizSelectionPanel.noTimerRadioButton)
		{
			Application.quizSelectionPanel.minuteSpinner.setEnabled(false);
			Application.quizSelectionPanel.secondSpinner.setEnabled(false);
		}
		
		else if (e.getSource() == Application.quizSelectionPanel.okButton)
		{
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.QUIZ_MODE_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			
			Application.frame.setJMenuBar(Application.quizMenuBar);
		}
		
		else if (e.getSource() == Application.quizSelectionPanel.backButton)
		{
			Application.restartMainMenuThread();
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.MAIN_MENU_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
		}
	}

	public void stateChanged(ChangeEvent e) 
	{
		if (e.getSource() == Application.quizSelectionPanel.minuteSpinner)
		{
			if ((Byte)(Application.quizSelectionPanel.minuteSpinner.getValue()) == 20)
			{
				Application.quizSelectionPanel.secondSpinner.setValue(new Integer(0));
				Application.quizSelectionPanel.secondSpinner.setEnabled(false);
			}
			else if (!Application.quizSelectionPanel.secondSpinner.isEnabled())
				Application.quizSelectionPanel.secondSpinner.setEnabled(true);
		}
	}
}
