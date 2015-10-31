/**
 * Desrosiers Mechanics Teaching Tool
 * Quiz Menu
 * 
 * This is where the Quiz Menu, for the Quiz Menu Bar, is built.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Mar 27, 2014 - May 5, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.menus;

// Resource Packages and Class
import java.awt.event.*;
import javax.swing.*;

import guiComponents.menuBarActions.QuizMenuAction;


@SuppressWarnings("serial")
public class QuizMenu extends JMenu 
{
	// Menu Actions (Buttons with their associated properties)
	public QuizMenuAction goToFirstQuestionAction;
	public QuizMenuAction goToLastQuestionAction;
	public QuizMenuAction changeQuizAction;
	public QuizMenuAction quitQuizModeAction;
	
	public QuizMenu()
	{
		// Menu Initialization
		setText("Quiz");
		setMnemonic('Q');
		
		// Action Construction
		goToFirstQuestionAction = new QuizMenuAction("Go to First Question", 
				"Takes you to the first question of the quiz.", 
				KeyEvent.VK_F, KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
		
		goToLastQuestionAction = new QuizMenuAction("Go to Last Question", 
				"Takes you to the last question of the quiz.", 
				KeyEvent.VK_L, KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
		
		changeQuizAction = new QuizMenuAction("Change Quiz", 
				"Go to the Select Quiz Screen.", 
				KeyEvent.VK_C, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		
		quitQuizModeAction = new QuizMenuAction("Quit Quiz Mode", 
				"Go back to the Main Menu.", 
				KeyEvent.VK_Q, KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		
		// Menu Assembly
		add(goToFirstQuestionAction);
		add(goToLastQuestionAction);
		add(changeQuizAction);
		add(quitQuizModeAction);
		
		
	}
}
