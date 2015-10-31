/**
 * Desrosiers Mechanics Teaching Tool
 * Lecture Selection Panel Listener
 * 
 * This is the listener for the Lecture Selection Panel.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (February 21, 2014 - May 7, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added, comment for one of the methods
 * added.
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

// Resource Classes and Package
import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.JOptionPane;


// Interaction Classes
import programCore.Application;
import programCore.DialogLabelText;
import programTopicComponents.lectures.LectureManager;

public class LectureSelectionPanelListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == Application.lectureSelectionPanel.oneSectionRadioButton)
		{
			if (Application.lectureSelectionPanel.chapterComboBox.getSelectedIndex() == 0)
			{
				Application.dialogLabel.setText(DialogLabelText.oneChapterSectionNotAvailableMessage);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, 
						"Full Chapter Only", JOptionPane.WARNING_MESSAGE);
				
				Application.lectureSelectionPanel.fullChapterRadioButton.setSelected(true);
				Application.lectureSelectionPanel.oneSectionRadioButton.setSelected(false);
			}
			else if (!Application.lectureSelectionPanel.sectionComboBox.isEnabled())
				Application.lectureSelectionPanel.sectionComboBox.setEnabled(true);
			
			setSelectedLectureTextArea();
		}
		
		else if (e.getSource() == Application.lectureSelectionPanel.fullChapterRadioButton)
		{
			if (Application.lectureSelectionPanel.sectionComboBox.isEnabled())
				Application.lectureSelectionPanel.sectionComboBox.setEnabled(false);
			
			setSelectedLectureTextArea();
		}
		
		else if (e.getSource() == Application.lectureSelectionPanel.chapterComboBox)
		{
			int selectedIndex = Application.lectureSelectionPanel.chapterComboBox.getSelectedIndex();
			
			if (selectedIndex == 0)
			{
				if (Application.lectureSelectionPanel.oneSectionRadioButton.isSelected())
				{
					Application.lectureSelectionPanel.oneSectionRadioButton.setSelected(false);
					Application.lectureSelectionPanel.fullChapterRadioButton.setSelected(true);
				}
				
				Application.lectureSelectionPanel.sectionComboBox.setEnabled(false);
			}
			else if (Application.lectureSelectionPanel.oneSectionRadioButton.isSelected())
				Application.lectureSelectionPanel.sectionComboBox.setEnabled(true);
			
			setSelectedLectureTextArea();
		}
		
		else if (e.getSource() == Application.lectureSelectionPanel.sectionComboBox)
			setSelectedLectureTextArea();
		
		else if (e.getSource() == Application.lectureSelectionPanel.okButton)
		{
			int chapterComboBoxIndex = Application.lectureSelectionPanel.chapterComboBox.getSelectedIndex();
			
			if (chapterComboBoxIndex == 0)
			{
				Application.currentLecture = Application.prologueLectureObject;
				Application.lecturePanel.chapterAndSectionLabel.setText("What do I need to know to learn physics?");
			}
			else if (chapterComboBoxIndex == 1)
			{
				if (Application.lectureSelectionPanel.oneSectionRadioButton.isSelected())
				{
					int sectionComboBoxIndex = Application.lectureSelectionPanel.sectionComboBox.getSelectedIndex();
					
					if (sectionComboBoxIndex == 0)
					{
						Application.currentLecture = Application.chapter2Section1LectureObject;
						Application.lecturePanel.chapterAndSectionLabel.setText("<html>Chapter 2: Motion in Two and Three Dimensions "
								+ "<br/><sub>Section 1: Vectors</sub></html>");
					}
					else if (sectionComboBoxIndex == 1)
					{
						Application.currentLecture = Application.chapter2Section2LectureObject;
						Application.lecturePanel.chapterAndSectionLabel.setText("<html>Chapter 2: Motion in Two and Three Dimensions "
								+ "<br/><sub>Section 2: Velocity and Acceleration Vectors</sub></html>");
					}
					else if (sectionComboBoxIndex == 2)
					{
						Application.currentLecture = Application.chapter2Section3LectureObject;
						Application.lecturePanel.chapterAndSectionLabel.setText("<html>Chapter 2: Motion in Two and Three Dimensions "
								+ "<br/><sub>Section 3: Relative Motion</sub></html>");
					}
					else if (sectionComboBoxIndex == 3)
					{
						Application.currentLecture = Application.chapter2Section4LectureObject;
						Application.lecturePanel.chapterAndSectionLabel.setText("<html>Chapter 2: Motion in Two and Three Dimensions "
								+ "<br/><sub>Section 4: Constant Acceleration</sub></html>");
					}
					else if (sectionComboBoxIndex == 4)
					{
						Application.currentLecture = Application.chapter2Section5LectureObject;
						Application.lecturePanel.chapterAndSectionLabel.setText("<html>Chapter 2: Motion in Two and Three Dimensions "
								+ "<br/><sub>Section 5: Projectile Motion</sub></html>");
					}
					else if (sectionComboBoxIndex == 5)
					{
						Application.currentLecture = Application.chapter2Section6LectureObject;
						Application.lecturePanel.chapterAndSectionLabel.setText("<html>Chapter 2: Motion in Two and Three Dimensions "
								+ "<br/><sub>Section 6: Uniform Circular Motion</sub></html>");
					}
				}
				else
				{
					Application.currentLecture = Application.chapter2FullChapterLectureObject;
					Application.lecturePanel.chapterAndSectionLabel.setText("<html>Chapter 2: Motion in Two and Three Dimensions"
							+ "<br/><sub>Full Chapter</sub></html>");
				}
			}
			
			Application.currentLecture.resetLecturePageIndex();
			LectureManager.setLectureModeComponents();
			
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.LECTURE_MODE_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			
			Application.frame.setJMenuBar(Application.lectureMenuBar);
		}
		
		else if (e.getSource() == Application.lectureSelectionPanel.backButton)
		{
			Application.restartMainMenuThread();
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.MAIN_MENU_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
		}
	}
	
	/**
	 * Sets the text area to where the user can see what lecture has been selected
	 * from the selection components except the OK and Back buttons.
	 */
	public void setSelectedLectureTextArea()
	{
		Application.lectureSelectionPanel.selectedLectureTextArea.setText("Selected Chapter:\n");
		
		int selectedChapterComboBoxIndex = 
				Application.lectureSelectionPanel.chapterComboBox.getSelectedIndex();
		
		if (selectedChapterComboBoxIndex == 0)
			Application.lectureSelectionPanel.selectedLectureTextArea.setText(
					Application.lectureSelectionPanel.selectedLectureTextArea.getText()
					+ "What do I need to know to learn physics? (Prologue Chapter)");
		
		else if (selectedChapterComboBoxIndex == 1)
		Application.lectureSelectionPanel.selectedLectureTextArea.setText(
				Application.lectureSelectionPanel.selectedLectureTextArea.getText()
				+ "Ch. 2: Motion in Two and Three Dimensions");
		
		if (Application.lectureSelectionPanel.oneSectionRadioButton.isSelected())
		{
			Application.lectureSelectionPanel.selectedLectureTextArea.setText(
					Application.lectureSelectionPanel.selectedLectureTextArea.getText()
					+ "\n\nSelected Section:\n");
			
			int selectedSectionComboBoxIndex = 
					Application.lectureSelectionPanel.sectionComboBox.getSelectedIndex();
			
			if (selectedSectionComboBoxIndex == 0)
				Application.lectureSelectionPanel.selectedLectureTextArea.setText(
						Application.lectureSelectionPanel.selectedLectureTextArea.getText()
						+ "Sect. 1: Vectors");
			
			else if (selectedSectionComboBoxIndex == 1)
				Application.lectureSelectionPanel.selectedLectureTextArea.setText(
						Application.lectureSelectionPanel.selectedLectureTextArea.getText()
						+ "Sect. 2: Velocity and Acceleration Vectors");
			
			else if (selectedSectionComboBoxIndex == 2)
				Application.lectureSelectionPanel.selectedLectureTextArea.setText(
						Application.lectureSelectionPanel.selectedLectureTextArea.getText()
						+ "Sect. 3: Relative Motion");
			
			else if (selectedSectionComboBoxIndex == 3)
				Application.lectureSelectionPanel.selectedLectureTextArea.setText(
						Application.lectureSelectionPanel.selectedLectureTextArea.getText()
						+ "Sect. 4: Constant Acceleration");
			
			else if (selectedSectionComboBoxIndex == 4)
				Application.lectureSelectionPanel.selectedLectureTextArea.setText(
						Application.lectureSelectionPanel.selectedLectureTextArea.getText()
						+ "Sect. 5: Projectile Motion");
			
			else if (selectedSectionComboBoxIndex == 5)
				Application.lectureSelectionPanel.selectedLectureTextArea.setText(
						Application.lectureSelectionPanel.selectedLectureTextArea.getText()
						+ "Sect. 6: Uniform Circular Motion");
		}		
	}
}
