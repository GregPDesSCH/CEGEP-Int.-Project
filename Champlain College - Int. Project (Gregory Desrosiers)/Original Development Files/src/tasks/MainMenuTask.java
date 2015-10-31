/**
 * Desrosiers Mechanics Teaching Tool - Main Menu Task
 * 
 * This task allows the user to see what time it is of the day,
 * and what is the date, through a label on the Main Menu.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 4, 2014 - May 6, 2014)
 * UPDATE (May 19, 2014) - Name constants declared in the Application class 
 * have been changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure 
 * to credit me first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package tasks;

// Resource Classes
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Interaction Class
import programCore.Application;

public class MainMenuTask implements Runnable 
{
	public void run()
	{	
		// The task holds itself on only when the user is in the main menu.
		while(Application.currentPanelName.equals(Application.MAIN_MENU_NAME))
		{
			// Calendar Info Update
			SimpleDateFormat calendarFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy, hh:mm:ss aaa");
			Application.mainMenuPanel.currentDateAndTimeLabel.
				setText(calendarFormatter.format(Calendar.getInstance().getTime()));
			
			// Pausing the thread for about 1/15 of a second.
			try
			{
				Thread.sleep(1000/15);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
