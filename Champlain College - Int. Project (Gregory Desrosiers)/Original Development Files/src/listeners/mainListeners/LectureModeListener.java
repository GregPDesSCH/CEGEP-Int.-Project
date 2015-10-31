/**
 * Desrosiers Mechanics Teaching Tool
 * Lecture Mode Listener
 * 
 * This is the listener used for the Lecture Panel, when the user is in
 * Lecture Mode.
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
import programTopicComponents.lectures.LectureManager;

public class LectureModeListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == Application.lecturePanel.nextPageButton)
			LectureManager.goToNextPage();
		else if (e.getSource() == Application.lecturePanel.previousPageButton)
			LectureManager.goToPreviousPage();
		else if (e.getSource() == Application.lecturePanel.customPageNumberTextField)
		{
			if (Application.lecturePanel.customPageNumberTextField.getText().equals(""))
			{
				Application.dialogLabel.setText(DialogLabelText.lectureModeCustomPageNumberTextFieldEntryEmpty);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Empty Text Field Entry", 
						JOptionPane.ERROR_MESSAGE);
			}
			else
				LectureManager.goToPageWithSpecifiedPageNumber(
						Integer.parseInt(Application.lecturePanel.customPageNumberTextField.getText()));
		}
	}
}
