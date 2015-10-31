/**
 * Desrosiers Mechanics Teaching Tool
 * Simple Credits Utility
 *
 * A utility that displays the credits of this project; specifically,
 * who did what, who should be owed special thanks, and the copyright
 * and trademark information.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Mar 28, 2014 - May 6, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package utilities.frames;

// Resource Classes and Packages
import java.awt.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class SimpleCreditsUtility extends JFrame 
{
	/*
	 * GUI Components
	 */
	private JPanel panel;
	public JTextArea textArea;
	private JScrollPane scrollPane;
	
	public SimpleCreditsUtility()
	{
		/*
		 * GUI Construction and Initialization
		 */
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		
		textArea = new JTextArea(20, 35);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setFont(Application.centralFontObject);
		textArea.setBackground(Color.WHITE);
		textArea.setForeground(Color.BLACK);
		
		buildText();
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(scrollPane);
		add(panel);
		
		
		
		// Final Initialization
		setTitle("Program Credits");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2);
		setResizable(false);
		pack();
	}
	
	/**
	 * Puts together the text of this utility's text area by inputting from a text file,
	 * then formatting it for a proper appearence.
	 */
	private void buildText()
	{
		try 
		{
			String[] creditsArray, creditsArray2;
			
			// First File
			// Line Counting Phase
			Scanner inputter = new Scanner(
					new File("Resource Files/Credits Files/Project Credits.txt"));
			int lineCount = 0;
			while(inputter.hasNext())
			{
				inputter.nextLine();
				lineCount++;
			}
			
			inputter.close();
			
			creditsArray = new String[lineCount];
			
			
			// Input Phase
			inputter = new Scanner(
					new File("Resource Files/Credits Files/Project Credits.txt"));
			for (int a = 0; a < creditsArray.length && inputter.hasNext(); a++)
			{
				creditsArray[a] = inputter.nextLine();
			}
			
			inputter.close();
			
		
			
			
			// Second File
			// Line Counting Phase
			inputter = new Scanner(
					new File("Resource Files/Credits Files/Copyright Notice.txt"));
			lineCount = 0;
			while(inputter.hasNext())
			{
				inputter.nextLine();
				lineCount++;
			}
			
			inputter.close();
			
			creditsArray2 = new String[lineCount];
			
			
			// Input Phase
			inputter = new Scanner(
					new File("Resource Files/Credits Files/Copyright Notice.txt"));
			for (int a = 0; a < creditsArray2.length && inputter.hasNext(); a++)
			{
				creditsArray2[a] = inputter.nextLine();
			}
			
			inputter.close();
			
			
			// Initializing text area with two loops for proper text formatting
			for (int a = 0; a < creditsArray.length; a++)
			{
				if (a < 24 && !creditsArray[a].equals(""))
					textArea.setText(textArea.getText() + creditsArray[a] + " ");
				else if (a < 24 && creditsArray[a].equals(""))
					textArea.setText(textArea.getText() + "\n\n");
				else
					textArea.setText(textArea.getText() + creditsArray[a] + "\n");
				
				if (a == creditsArray.length - 1)
					textArea.setText(textArea.getText() + "\n\n\n\n\n");
			}
			
			for (int a = 0; a < creditsArray2.length; a++)
			{
				if (!creditsArray2[a].equals(""))
					textArea.setText(textArea.getText() + creditsArray2[a] + " ");
				else
					textArea.setText(textArea.getText() + "\n\n");
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
