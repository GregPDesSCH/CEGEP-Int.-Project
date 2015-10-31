/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Full Chapter Lecture
 * 
 * This full lecture is created not by inputting files as the constructors
 * in the sections of Chapter 2 lectures do, but by getting the number of pages
 * from each of the constructed sections, then copying the subarrays of those pages
 * into the large lecture array created here.
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
package programTopicComponents.lectures;

// Interaction Class
import programCore.Application;

public class Chapter2FullChapterLecture extends Lecture 
{
	public Chapter2FullChapterLecture()
	{
		// Array Construction Phase
		int numberOfPages = Application.chapter2Section1LectureObject.lecturePages.length +
				Application.chapter2Section2LectureObject.lecturePages.length +
				Application.chapter2Section3LectureObject.lecturePages.length +
				Application.chapter2Section4LectureObject.lecturePages.length +
				Application.chapter2Section5LectureObject.lecturePages.length +
				Application.chapter2Section6LectureObject.lecturePages.length;
		
		lecturePages = new LecturePage[numberOfPages];
		
		// Copy Phase
		int destinationStartPosition = 0;
		
		System.arraycopy(Application.chapter2Section1LectureObject.lecturePages, 0, lecturePages, destinationStartPosition, 
				Application.chapter2Section1LectureObject.lecturePages.length);
		
		destinationStartPosition += Application.chapter2Section1LectureObject.lecturePages.length;
		
		
		
		System.arraycopy(Application.chapter2Section2LectureObject.lecturePages, 0, lecturePages, destinationStartPosition, 
				Application.chapter2Section2LectureObject.lecturePages.length);
		destinationStartPosition += Application.chapter2Section2LectureObject.lecturePages.length;
		
		
		
		System.arraycopy(Application.chapter2Section3LectureObject.lecturePages, 0, lecturePages, destinationStartPosition, 
				Application.chapter2Section3LectureObject.lecturePages.length);
		destinationStartPosition += Application.chapter2Section3LectureObject.lecturePages.length;
		
		
		
		System.arraycopy(Application.chapter2Section4LectureObject.lecturePages, 0, lecturePages, destinationStartPosition, 
				Application.chapter2Section4LectureObject.lecturePages.length);
		destinationStartPosition += Application.chapter2Section4LectureObject.lecturePages.length;
		
		
		
		System.arraycopy(Application.chapter2Section5LectureObject.lecturePages, 0, lecturePages, destinationStartPosition, 
				Application.chapter2Section5LectureObject.lecturePages.length);
		destinationStartPosition += Application.chapter2Section5LectureObject.lecturePages.length;
		
		
		
		
		System.arraycopy(Application.chapter2Section6LectureObject.lecturePages, 0, lecturePages, destinationStartPosition, 
				Application.chapter2Section6LectureObject.lecturePages.length);
		
		
	}
}
