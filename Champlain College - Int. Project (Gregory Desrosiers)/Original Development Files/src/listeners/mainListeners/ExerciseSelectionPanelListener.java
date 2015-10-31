/**
 * Desrosiers Mechanics Teaching Tool
 * Exercises Selection Panel Listener
 * 
 * This is the listener for all the components in the Exercises Selection Panel.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (February 21, 2014 - May 7, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added, comments for one of the methods
 * added as well.
 * UPDATE (May 19, 2014) - Name constants declared in the Application class 
 * have been changed.
 * UPDATE (May 20, 2014) - Name constants declared in ExercisesPanel, as well as the one
 * defined in this class, have been changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.mainListeners;

// Resource Classes and Package
import guiComponents.panels.ExercisesPanel;

import java.awt.CardLayout;
import java.awt.event.*;

// Interaction Class
import programCore.Application;

public class ExerciseSelectionPanelListener implements ActionListener 
{
	private final String INCLUDE_ANSWERS_STRING_FOR_CONCATENATION = "\n\nAnswers Included: ";
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Application.exerciseSelectionPanel.chapterComboBox ||
				e.getSource() == Application.exerciseSelectionPanel.chapterSectionComboBox ||
				e.getSource() == Application.exerciseSelectionPanel.yesToIncludeAnswersRadioButton ||
				e.getSource() == Application.exerciseSelectionPanel.noToIncludeAnswersRadioButton)
			setSelectedExercisesTextArea();
		
		else if (e.getSource() == Application.exerciseSelectionPanel.okButton)
		{
			Application.exercisesPanel.chapterLabel.setText("Chapter 2: Motion in Two and Three Dimensions");
			
			int selectedSectionComboBoxIndex = Application.exerciseSelectionPanel.chapterSectionComboBox.
					getSelectedIndex();
			
			if (selectedSectionComboBoxIndex == 0)
				Application.exercisesPanel.sectionLabel.setText("Section 1: Vectors");
			else if (selectedSectionComboBoxIndex == 1)
				Application.exercisesPanel.sectionLabel.setText("Section 2: Velocity and Acceleration Vectors");
			else if (selectedSectionComboBoxIndex == 2)
				Application.exercisesPanel.sectionLabel.setText("Section 3: Relative Motion");
			else if (selectedSectionComboBoxIndex == 3)
				Application.exercisesPanel.sectionLabel.setText("Section 4: Constant Acceleration");
			else if (selectedSectionComboBoxIndex == 4)
				Application.exercisesPanel.sectionLabel.setText("Section 5: Projectile Motion");
			else if (selectedSectionComboBoxIndex == 5)
				Application.exercisesPanel.sectionLabel.setText("Section 6: Uniform Circular Motion");
			else if (selectedSectionComboBoxIndex == 6)
				Application.exercisesPanel.sectionLabel.setText("Full Chapter");
			else if (selectedSectionComboBoxIndex == 7)
				Application.exercisesPanel.sectionLabel.setText("Substitution Exercises");
			
			CardLayout exerciseViewingPanelLayout = ((CardLayout)Application.exercisesPanel.exerciseViewingPanel.getLayout()),
					exerciseAnsweringComponentsPanelLayout = 
						((CardLayout)Application.exercisesPanel.answeringComponentsPanel.getLayout());
			
			if (selectedSectionComboBoxIndex == 0)
			{
				Application.exercisesPanel.currentExerciseLabel.setText("Exercise 1 of 1");
				exerciseViewingPanelLayout.show(Application.exercisesPanel.exerciseViewingPanel, 
						ExercisesPanel.DEMO_VIEWING_PANEL_NAME);
				exerciseAnsweringComponentsPanelLayout.show(Application.exercisesPanel.answeringComponentsPanel, 
						ExercisesPanel.DEMO_COMPONENTS_PANEL_NAME);
			}
			else
			{
				Application.exercisesPanel.currentExerciseLabel.setText("Exercise # of #");
				exerciseViewingPanelLayout.show(Application.exercisesPanel.exerciseViewingPanel,
						ExercisesPanel.NO_QUESTION_VIEWING_PANEL_NAME);
				exerciseAnsweringComponentsPanelLayout.show(Application.exercisesPanel.answeringComponentsPanel, 
						ExercisesPanel.NO_ANSWERING_COMPONENTS_PANEL_NAME);
			}
			
			
			if (Application.exerciseSelectionPanel.yesToIncludeAnswersRadioButton.isSelected())
			{
				Application.exercisesPanel.actualAnswerLabel.setText("Actual Answer:");
				Application.exercisesPanel.actualAnswerTextField.setText("Act. Ans. Here");
				Application.exercisesPanel.actualAnswerTextField.setBorder(
						ExercisesPanel.actualAnswerTextFieldBorder);
			}
			else if (Application.exerciseSelectionPanel.noToIncludeAnswersRadioButton.isSelected())
			{
				Application.exercisesPanel.actualAnswerLabel.setText("");
				Application.exercisesPanel.actualAnswerTextField.setText("");
				Application.exercisesPanel.actualAnswerTextField.setBorder(null);
			}
			
				
				
				
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.EXERCISES_MODE_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			
			Application.frame.setJMenuBar(Application.exerciseMenuBar);
		}
		
		else if (e.getSource() == Application.exerciseSelectionPanel.backButton)
		{
			Application.restartMainMenuThread();
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.MAIN_MENU_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
		}
	}
	
	/**
	 * This method sets the text area to where the user can see what exercises has
	 * been selected whenever any of the selection components except the OK and Back
	 * buttons receive an action event.
	 */
	public void setSelectedExercisesTextArea()
	{
		Application.exerciseSelectionPanel.selectedExercisesTextArea.setText("Selected Chapter:\n"
				+ "Motion in Two and Three Dimensions\n\nSelected Section:\n");
		
		int selectedSectionComboBoxIndex = Application.exerciseSelectionPanel.chapterSectionComboBox.
				getSelectedIndex();
		
		
		
		
		// When Section 1: Vectors is selected.
		if (selectedSectionComboBoxIndex == 0) 
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Section 1: Vectors" + INCLUDE_ANSWERS_STRING_FOR_CONCATENATION);
		
		// When Section 2: Velocity and Acceleration Vectors is selected.
		else if (selectedSectionComboBoxIndex == 1)
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Section 2: Velocity and Acceleration Vectors" + 
							INCLUDE_ANSWERS_STRING_FOR_CONCATENATION);
		
		// When Section 3: Relative Motion is selected.
		else if (selectedSectionComboBoxIndex == 2)
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Section 3: Relative Motion" + INCLUDE_ANSWERS_STRING_FOR_CONCATENATION);
		
		// When Section 4: Constant Acceleration is selected.
		else if (selectedSectionComboBoxIndex == 3)
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Section 4: Constant Acceleration" + INCLUDE_ANSWERS_STRING_FOR_CONCATENATION);
		
		// When Section 5: Projectile Motion is selected.
		else if (selectedSectionComboBoxIndex == 4)
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Section 5: Projectile Motion" + INCLUDE_ANSWERS_STRING_FOR_CONCATENATION);
		
		// When Section 6: Uniform Circular Motion is selected.
		else if (selectedSectionComboBoxIndex == 5)
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Section 6: Uniform Circular Motion" + INCLUDE_ANSWERS_STRING_FOR_CONCATENATION);
		
		// When the full chapter is selected.
		else if (selectedSectionComboBoxIndex == 6)
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Full Chapter" + INCLUDE_ANSWERS_STRING_FOR_CONCATENATION);
		
		// When the section having substitution exercises is selected.
		else if (selectedSectionComboBoxIndex == 7)
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Substitution Exercises" + INCLUDE_ANSWERS_STRING_FOR_CONCATENATION);
		
		
		
		if (Application.exerciseSelectionPanel.yesToIncludeAnswersRadioButton.isSelected())
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "Yes");
		
		else if (Application.exerciseSelectionPanel.noToIncludeAnswersRadioButton.isSelected())
			Application.exerciseSelectionPanel.selectedExercisesTextArea.setText(
					Application.exerciseSelectionPanel.selectedExercisesTextArea.getText() 
					+ "No");

		
		Application.exerciseSelectionPanel.selectedExercisesTextArea.setCaretPosition(0);
	}
}
