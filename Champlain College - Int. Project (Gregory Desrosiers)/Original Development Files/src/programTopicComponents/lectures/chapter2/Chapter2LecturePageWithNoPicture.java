/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Lecture Page (no picture)
 * 
 * An extended type of lecture page where it does hold a description, but
 * no diagrams are painted.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (May 4, 2014 - May 6, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.lectures.chapter2;

// Resource Class
import java.awt.Graphics2D;

// Inheritance Class (for polymorphism)
import programTopicComponents.lectures.LecturePage;

public class Chapter2LecturePageWithNoPicture extends LecturePage 
{
	public Chapter2LecturePageWithNoPicture(String pageDescription)
	{
		this.pageDescription = pageDescription;
	}
	
	/**
	 * An empty method only to overcome a compilation error because this lecture page
	 * inherits from an abstract class called LecturePage.
	 */
	public void paintGraphics(Graphics2D graphicsObject)
	{
		
	}
}
