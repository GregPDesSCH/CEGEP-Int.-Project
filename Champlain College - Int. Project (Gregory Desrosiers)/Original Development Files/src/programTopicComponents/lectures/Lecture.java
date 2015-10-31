/**
 * Desrosiers Mechanics Teaching Tool - Lecture Class
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

public abstract class Lecture 
{
	public int currentLecturePageIndex = 0;
	public LecturePage[] lecturePages;
	
	/**
	 * This method resets current lecture page number whenever a new lecture is
	 * about to be started.
	 */
	public void resetLecturePageIndex()
	{
		currentLecturePageIndex = 0;
	}	
}
