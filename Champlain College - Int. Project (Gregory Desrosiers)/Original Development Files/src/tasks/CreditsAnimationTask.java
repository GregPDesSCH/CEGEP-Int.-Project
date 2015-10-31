/**
 * Desrosiers Mechanics Teaching Tool - Credits Animation Task
 * 
 * This associated task is how the credits in the Credits Panel
 * of this program are animated; every timestep sets a new position
 * for the y position of the top of the credits.
 * 
 * When the last name finally clears out the screen at the top,
 * the animation is slowed down to show the pictures loaded in this
 * animation more carefully.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 5, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added to this file as well
 * as the "if" block for the animation speed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to 
 * credit me first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package tasks;

// Interaction Classes
import guiComponents.panels.AnimatedCreditsPanel;
import programCore.Application;

public class CreditsAnimationTask implements Runnable 
{
	public float topCreditsYPos;
	
	public boolean letGoOfThread = false;
	
	public void run() 
	{
		// The animated credits starts out from above the text so that way
		// the user sees a white screen before he sees the credits in this
		// sequence.
		topCreditsYPos = 500;
		
		while (AnimatedCreditsPanel.yPosAtBottomOfCredits > -50 && !letGoOfThread)
		{	
			/* 
			 * The first part of the credits is moved upwards at 1.2 pixels per frame,
			 * about 30 times per second.
			 * 
			 * Once the last string of the first block is cleared of the screen, the
			 * animation slows down to 1.0 pixels per frame, still at about 30 frames
			 * per second.
			 */
			
			if (AnimatedCreditsPanel.yPosAfterLastNameToDisplay > -50)
				topCreditsYPos -= 1.2;
			else
				topCreditsYPos -= 1.0;
			
			try 
			{
				Thread.sleep(1000 / 30);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			Application.creditsPanel.creditsPanel.repaint();
		}
	}
}
