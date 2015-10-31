/**
 * Desrosiers Mechanics Teaching Tool
 * Exercise Mode Listener
 * 
 * This is the listener for the Exercises Mode; all it does is displays
 * a dialog depending on which of the buttons in the Exercises Panel
 * is clicked.
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

// Resource Package and Class
import java.awt.event.*;
import javax.swing.JOptionPane;

// Interaction Classes
import programCore.Application;
import programCore.DialogLabelText;

public class ExerciseModeListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == Application.exercisesPanel.nextExerciseButton)
		{
			Application.dialogLabel.setText(DialogLabelText.exerciseModeGoToNextExerciseUnimplementedMessage);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Exercises Unavailable", 
					JOptionPane.WARNING_MESSAGE);
		}
		else if (e.getSource() == Application.exercisesPanel.previousExerciseButton)
		{
			Application.dialogLabel.setText(DialogLabelText.exerciseModeGoToPreviousExerciseUnimplementedMessage);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Exercises Unavailable", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
