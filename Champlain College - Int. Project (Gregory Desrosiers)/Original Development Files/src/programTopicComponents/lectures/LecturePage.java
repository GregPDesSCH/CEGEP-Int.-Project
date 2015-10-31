/**
 * Desrosiers Mechanics Teaching Tool - Lecture Page
 * 
 * This is the raw class of a lecture page, consisting of a page description
 * displayed on the lecture panel description text area, and an abstracted
 * drawing graphics method from where a diagram, as part of a lecture page,
 * should be drawn.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.lectures;

// Resource Package
import java.awt.*;

public abstract class LecturePage
{	
	public String pageDescription;
	
	public abstract void paintGraphics(Graphics2D graphicsObject);
}
