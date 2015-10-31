/**
 * Desrosiers Mechanics Teaching Tool - Quiz Mode Listener
 * 
 * This is the listener for the Quiz Mode; all it does is display
 * dialogs depending on which of the two buttons of the Quiz Panel
 * is clicked because quizzes are not implemented in this version
 * of the program.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (May 4, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.mainListeners;

// Resource Package
import java.awt.event.*;

import javax.swing.JOptionPane;

// Interaction Classes
import programCore.Application;
import programCore.DialogLabelText;

public class QuizModeListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == Application.quizPanel.nextQuizQuestionButton)
		{
			Application.dialogLabel.setText(DialogLabelText.quizModeGoToNextQuestionUnimplementedMessage);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Quiz Unavailable", 
					JOptionPane.WARNING_MESSAGE);
		}
		else if (e.getSource() == Application.quizPanel.previousQuizQuestionButton)
		{
			Application.dialogLabel.setText(DialogLabelText.quizModeGoToPreviousQuestionUnimplementedMessage);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Quiz Unavailable", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
