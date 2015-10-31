/**
 * Desrosiers Mechanics Teaching Tool - Title Screen Panel
 * 
 * This is what the user sees on the program when the application
 * is loaded.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.panels;

// Resource Packages and Classes
import javax.swing.*;
import java.awt.*;
import java.io.File;

@SuppressWarnings("serial")
public class TitleScreenPanel extends JPanel 
{
	/*
	 * Panel Resources       
	 */
	Image programLogo =
			new ImageIcon(new File("Resource Files/Logos/Program Logo (Title Logo).png").getAbsolutePath()).getImage();
	
	
	Font pressEnterFontObject = null, copyrightNoticeFontObject = null;
	public Color pressEnterColor = new Color(0, 0, 0);
	
	String pressEnterCommand = "Press Enter",
			copyrightNoticeString = "© 2014 Gregory Desrosiers / Champlain College Saint-Lambert"
					+ " / Champlain Regional College";
	
	public TitleScreenPanel()
	{
		try
		{
			pressEnterFontObject = 
					Font.createFont(Font.PLAIN, new File("Resource Files/Fonts/consola.ttf")).deriveFont(15.0f);
			copyrightNoticeFontObject = 
					Font.createFont(Font.PLAIN, new File("Resource Files/Fonts/arial.ttf")).deriveFont(12.0f);
		}
		catch (Exception ex)
		{
			pressEnterFontObject = new Font("Arial", Font.PLAIN, 14);
			copyrightNoticeFontObject = pressEnterFontObject;
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D drawDevice = (Graphics2D)g;
		drawDevice.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		drawDevice.drawImage(programLogo, getPreferredSize().width / 2 - programLogo.getWidth(this) / 2, 0, this);
		
		
		drawDevice.setColor(pressEnterColor);
		drawDevice.setFont(pressEnterFontObject);
		FontMetrics currentFontMetrics = g.getFontMetrics();
		drawDevice.drawString(pressEnterCommand, getPreferredSize().width / 2 - 
				currentFontMetrics.stringWidth(pressEnterCommand) / 2, 340);
		
		drawDevice.setFont(copyrightNoticeFontObject);
		drawDevice.setColor(Color.BLACK);
		currentFontMetrics = g.getFontMetrics();
		drawDevice.drawString(copyrightNoticeString, getPreferredSize().width / 2 - 
				currentFontMetrics.stringWidth(copyrightNoticeString) / 2, 470);
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(640, 480);
	}
}
