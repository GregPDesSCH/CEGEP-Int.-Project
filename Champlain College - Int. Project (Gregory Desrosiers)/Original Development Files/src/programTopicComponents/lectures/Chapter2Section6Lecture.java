/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Section 6 Lecture
 * 
 * This is where the lecture for the sixth section of Chapter 2, in this program,
 * is created.
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

// Resource Package and Classes
import java.io.*;
import java.util.Scanner;
import programTopicComponents.lectures.chapter2.Chapter2LecturePageWithNoPicture;

public class Chapter2Section6Lecture extends Lecture 
{
	public Chapter2Section6Lecture()
	{
		try 
		{
			int numberOfLines = 0, numberOfPages = 0;
			String[] pageText;
			
			// Line Count Phase (Page Text Only)
			Scanner fileInputter = new Scanner(new File("Resource Files/Lecture Files/Chapter 2/Section 6 Lecture Text.txt"));
		
			while (fileInputter.hasNextLine())
			{
				numberOfLines++;
				fileInputter.nextLine();
			}
			
			fileInputter.close();
			
			
			// Input Phase (Page Text Only)
			pageText = new String[numberOfLines];
			Scanner fileInputter2 = new Scanner(new File("Resource Files/Lecture Files/Chapter 2/Section 6 Lecture Text.txt"));
			
			for (int a = 0; a < pageText.length; a++)
				pageText[a] = fileInputter2.nextLine();
			
			fileInputter2.close();
			
			// Page Count
			for (int c = 0; c < pageText.length; c++)
				if (pageText[c] == null || pageText[c].equals("") || c == pageText.length - 1)
					numberOfPages++;
			
			lecturePages = new LecturePage[numberOfPages];
			
			// Page Construction
			StringBuilder currentString = new StringBuilder();
			
			for (int d = 0, e = 0; d < pageText.length || e < lecturePages.length; d++)
			{
				if (!pageText[d].equals(""))
					currentString.append(pageText[d]);
				
				if (pageText[d].equals("") || d == pageText.length - 1)
				{
					lecturePages[e] = new Chapter2LecturePageWithNoPicture(currentString.toString());
					e++;
					currentString.delete(0, currentString.length());
				}
			}	
			
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
