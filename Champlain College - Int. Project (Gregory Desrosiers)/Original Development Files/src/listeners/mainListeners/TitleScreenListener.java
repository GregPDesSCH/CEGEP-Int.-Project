/**
 * Desrosiers Mechanics Teaching Tool
 * Title Screen Listener
 * 
 * A simple key listener for the Title Screen where it only responds to
 * the Enter Button on the keyboard.
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

// Resource Package and Class
import java.awt.event.*;
import java.awt.CardLayout;

// Interaction Class
import programCore.Application;

public class TitleScreenListener extends KeyAdapter
{
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.MAIN_MENU_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.MAIN_MENU_NAME);
			
			
			Application.frame.removeKeyListener(Application.titleScreenListener);
			
			//Application.centralProgramMenuBar.musicMenu.setEnabled(true);
			
			Application.garbageCollector.gc();
			Application.mainMenuThread = new Thread(Application.mainMenuTask);
			Application.mainMenuThread.start();
		}
	}
}
