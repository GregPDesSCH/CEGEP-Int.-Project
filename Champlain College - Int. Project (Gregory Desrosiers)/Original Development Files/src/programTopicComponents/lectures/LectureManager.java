/**
 * Desrosiers Mechanics Teaching Tool
 * Lecture Manager
 * 
 * This class manages the current lecture chosen in the program. There are
 * multiple if and else clauses to make sure that the program avoids errors
 * in different circumstances.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (May 5, 2014 - May 6, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.lectures;

// Resource Class
import javax.swing.JOptionPane;

// Interaction Classes
import programCore.Application;
import programCore.DialogLabelText;

public class LectureManager 
{
	/**
	 * Goes to the first page of the lecture. Displays a dialog if the user is already
	 * in the first page of the lecture.
	 */
	public static void goToFirstPage()
	{
		// Checking if this is the first page of the lecture
		if (Application.currentLecture.currentLecturePageIndex == 0)
		{
			Application.dialogLabel.setText(DialogLabelText.lectureModeAlreadyOnFirstPageMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "First Page Already", 
					JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			Application.currentLecture.currentLecturePageIndex = 0;
			setLectureModeComponents();
		}
	}
	
	/**
	 * Goes to the last page of the lecture. Displays a dialog if the user is already
	 * in the last page of the lecture.
	 */
	public static void goToLastPage()
	{
		// Checking if this is the last page of the lecture
		if (Application.currentLecture.currentLecturePageIndex ==
					Application.currentLecture.lecturePages.length - 1)
		{
			Application.dialogLabel.setText(DialogLabelText.lectureModeAlreadyOnLastPageMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Last Page Already", 
					JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			Application.currentLecture.currentLecturePageIndex = Application.currentLecture.lecturePages.length - 1;
			setLectureModeComponents();
		}
	}
	
	/**
	 * Goes to the next page of the lecture. Displays a dialog if the user is
	 * at the last page of the lecture.
	 */
	public static void goToNextPage()
	{
		// Checking if this is the last page of the lecture
		if (Application.currentLecture.currentLecturePageIndex ==
				Application.currentLecture.lecturePages.length - 1)
		{
			Application.dialogLabel.setText(DialogLabelText.lectureModeCannotGoToNextPageMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Can't go to Next Page", 
					JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Application.currentLecture.currentLecturePageIndex++;
			setLectureModeComponents();
		}
	}
	
	/**
	 * Goes to the previous page of the lecture. Displays a dialog if the user is
	 * at the first page of the lecture.
	 */
	public static void goToPreviousPage()
	{
		// Checking if this is the first page of the lecture
		if (Application.currentLecture.currentLecturePageIndex == 0)
		{
			Application.dialogLabel.setText(DialogLabelText.lectureModeCannotGoToPreviousPageMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Can't go to Previous Page", 
					JOptionPane.ERROR_MESSAGE);	
		}
		else
		{
			Application.currentLecture.currentLecturePageIndex--;
			setLectureModeComponents();
		}
	}
	
	/**
	 * Goes to the lecture page specified by the user. Displays a dialog if the user
	 * enters a page number that is out of range of the lecture pages.
	 */
	public static void goToPageWithSpecifiedPageNumber(int pageNumber)
	{
		if (pageNumber == 0)
		{
			Application.dialogLabel.setText(DialogLabelText.lectureModeCannotGoToSpecifiedPageMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Can't go to Page 0", 
					JOptionPane.ERROR_MESSAGE);
		}
		else if (pageNumber > Application.currentLecture.lecturePages.length)
		{
			Application.dialogLabel.setText(DialogLabelText.lectureModeCannotGoToSpecifiedPageMessage2);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Can't go to Page " + pageNumber, 
					JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Application.currentLecture.currentLecturePageIndex = (pageNumber - 1);
			setLectureModeComponents();
		}
	}
	
	/**
	 * Any time any of the above methods are called and no dialogs appear, meaning that
	 * there are no errors the user must see, this method is called to set the components
	 * of the lecture panel accordingly.
	 */
	public static void setLectureModeComponents()
	{
		Application.lecturePanel.viewingPanel.repaint();
		
		Application.lecturePanel.descriptionTextArea.setText(
				Application.currentLecture.lecturePages[Application.currentLecture.currentLecturePageIndex].pageDescription);
		Application.lecturePanel.pageNumberLabel.setText("Page " + (Application.currentLecture.currentLecturePageIndex + 1) + 
				" of " + Application.currentLecture.lecturePages.length);
		Application.lecturePanel.customPageNumberTextField.setText(String.valueOf(
				Application.currentLecture.currentLecturePageIndex + 1));
	}
}
