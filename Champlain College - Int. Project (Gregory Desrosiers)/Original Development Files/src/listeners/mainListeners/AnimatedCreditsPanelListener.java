/**
 * Desrosiers Mechanics Teaching Tool
 * Animated Credits Panel Listener
 * 
 * This is the listener for the two buttons in the Animated Credits Panel.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 20, 2014 - May 6, 2014)
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

import tasks.*;
import guiComponents.panels.AnimatedCreditsPanel;

// Interaction Class
import programCore.Application;


public class AnimatedCreditsPanelListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == Application.creditsPanel.playCreditsAgainButton)
		{
			if (Application.creditsThread.isAlive())
			{
				Application.creditsTask.letGoOfThread = true;
				Application.creditsThread = null;
			}
			
			Application.creditsTask = new CreditsAnimationTask();
			
			Application.garbageCollector.gc();
			
			Application.creditsThread = new Thread(Application.creditsTask);
			Application.creditsThread.start();
			
			AnimatedCreditsPanel.yPosAtBottomOfCredits = 0.0f;
		}
		
		else if (e.getSource() == Application.creditsPanel.exitButton)
		{
			if (Application.creditsThread.isAlive())
			{
				Application.creditsTask.letGoOfThread = true;
				Application.creditsThread = null;
			}
			
			Application.creditsTask = new CreditsAnimationTask();
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.MAIN_MENU_NAME;
			
			Application.mainMenuTask = new MainMenuTask();
			
			Application.garbageCollector.gc();
			
			Application.mainMenuThread = new Thread(Application.mainMenuTask);
			Application.mainMenuThread.start();
			
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
		}
	}
}
