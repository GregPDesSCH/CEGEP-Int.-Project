/**
 * Desrosiers Mechanics Teaching Tool
 * Prologue Lecture Page (Demo Picture)
 * 
 * An extended type of lecture page where it does hold a description and one
 * image to demonstrate in this version of the program.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (May 7, 2014)
 * 
 * UPDATE (May 13, 2014) - Code for handling exception now implemented.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.lectures.chapter2;

// Resource Packages
import java.awt.*;
import java.io.*;
import javax.imageio.*;

// Inheritance Class
import programTopicComponents.lectures.LecturePage;

public class Chapter2LectureDemoPicturePage extends LecturePage 
{
	// Demo Picture
	private Image picture;
	private int pictureWidth, pictureHeight;
	
	public Chapter2LectureDemoPicturePage(String pageDescription)
	{
		this.pageDescription = pageDescription;
		
		try
		{
			picture = ImageIO.read(new File("Resource Files/Lecture Demo Picture.png"));
			pictureWidth = picture.getWidth(null);
			pictureHeight = picture.getHeight(null);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * Paints the image onto the viewing panel in the Lecture Panel.
	 */
	public void paintGraphics(Graphics2D graphicsObject)
	{
		graphicsObject.drawImage(picture, 310 - pictureWidth / 2, 122 - pictureHeight / 2, pictureWidth, pictureHeight, null);
	}
}
