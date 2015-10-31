/**
 * Desrosiers Mechanics Teaching Tool - Title Screen Task
 * 
 * This task does a transparency animation for the text 
 * "Press Enter" in the Title Screen.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 19, 2014 - May 6, 2014)
 * UPDATE (May 19, 2014) - Name constants declared in the Application class 
 * have been changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be 
 * sure to credit me first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package tasks;

// Resource Class
import java.awt.Color;

// Interaction Class
import programCore.Application;

public class TitleScreenTask implements Runnable 
{
	// Animation Limits
	private boolean textAlphaDecrease = true;
	private float alphaStepUnit = 0.010f;
	
	public void run()
	{
		// The task is finished when the user presses Enter on the title screen.
		while (Application.currentPanelName.equals(Application.TITLE_SCREEN_NAME))
		{
			Color currentColor = Application.titleScreenPanel.pressEnterColor;
			
			if (textAlphaDecrease)
			{
				currentColor = new Color(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(),
						((float)currentColor.getAlpha() / 255.0f) - alphaStepUnit);
				if (((float)currentColor.getAlpha() / 255.0f) - alphaStepUnit < 0)
					textAlphaDecrease = false;
			}
			else
			{
				currentColor = new Color(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(),
						((float)currentColor.getAlpha() / 255.0f) + alphaStepUnit);
				if (((float)currentColor.getAlpha() / 255.0f) + alphaStepUnit > 1.0f)
					textAlphaDecrease = true;
			}
			
			Application.titleScreenPanel.pressEnterColor = currentColor;
			
			
			Application.titleScreenPanel.repaint();
			
			try
			{
				Thread.sleep(1000 / 45);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
