/**
 * Desrosiers Mechanics Teaching Tool - Simulation Class
 * 
 * This is the general class from where the simulations are created and how
 * it is interacted with the listeners through the associated control panel
 * and the menu bar in Simulation Mode.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 2, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added to this file.
 * UPDATE (May 20, 2014) - The constants declared in this class have their
 * names changed.
 * 
 * *NOTE*: The algorithm to paint arrows is from this link:
 * http://stackoverflow.com/questions/4112701/drawing-a-line-with-arrow-in-java
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.simulations;

// Resource Packages
import java.awt.*;
import java.awt.geom.*;

public abstract class Simulation 
{
	// Arrow Size (for painting arrows)
	private final int ARR_SIZE = 4;
	
	// Boolean Flags
	public boolean animationSupported;
	public boolean threadAvailable;
	public boolean simulationResetted;
	
	// Thread Manager
	public static Thread simulationAnimationThread;
	
	// Paint Limits for Actual Simulation Panel
	public static final int MIN_X = -310;
	public static final int MIN_Y = -150;
	public static final int MAX_X = 310;
	public static final int MAX_Y = 150;
	
	// Paint Limit for Icon Panel in "Select Simulation" screen
	public static final int MAX_X_AND_Y_FOR_PREVIEW_PANEL = 140;
	
	// Difference between JAVA and Cartesian coordinate systems
	public static final int DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X = 310;
	public static final int DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y = 150;
	
	
	/**
	 * This method paints the icon of this simulation in the small 
	 * preview panel on the Simulation Selection Screen.
	 */
	public abstract void paintIconGraphics(Graphics2D graphicsObject);
	
	/**
	 * Paints the graphics of this simulation.
	 */
	public abstract void paintGraphics(Graphics2D graphicsObject);
	
	/**
	 * Resets the components of this simulation.
	 */
	public abstract void resetSimulation();
	
	
	
	
	/**
	 * Sets certain components of the control panel when the animation starts,
	 * such as changing the text of toggle buttons and disengaging some text
	 * fields.
	 * (Not implemented in simulations with no animation)
	 */
	public abstract void setPropertiesForStartingAnimationThread();
	
	/**
	 * Sets certain components of the control panel when the animation stops,
	 * such as changing the text of toggle buttons and enabling some text fields.
	 * (Not implemented in simulations with no animation)
	 */
	public abstract void setPropertiesForStoppingAnimationThread();
	
	/**
	 * Reenable specific components, such as text fields, after the user clicks
	 * on the Reset button of the animated simulation.
	 * (Not implemented in simulations with no animation)
	 */
	public abstract void reEnableComponentsAfterReset();
	
	
	
	/**
	 * Replaces the animation thread responsible for this simulation.
	 * (Not implemented in simulations with no animation)
	 */
	public abstract void replaceThread();
	
	/**
	 * Disposes the animation thread responsible for this simulation and
	 * stops its associated task.
	 * (Not implemented in simulations with no animation)
	 */
	public abstract void disposeThread();
	
	/**
	 * Reinitializes the control panel associated with this simulation.
	 */
	public abstract void reinitializeControlPanel();
	
	
	
	// Method from StackOverflow link
	/**
	 * This researched-based method draws arrows using JAVA's integrated AWT Graphics2D
	 * system.
	 */
	public void drawArrow(Graphics2D graphicsObject, double initialPointX, double initialPointY, 
			double finalPointX, double finalPointY)
	{
		double dx = finalPointX - initialPointX, dy = finalPointY - initialPointY;
		double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        
        
        AffineTransform originalTransform = graphicsObject.getTransform(),
        		at = AffineTransform.getTranslateInstance(initialPointX, initialPointY);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        
        graphicsObject.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        graphicsObject.drawLine(0, 0, len, 0);
        graphicsObject.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                      new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
        
        graphicsObject.setTransform(originalTransform);
	}
}
