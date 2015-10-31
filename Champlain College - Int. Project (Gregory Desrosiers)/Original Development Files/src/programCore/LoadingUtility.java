/**
 * Desrosiers Mechanics Teaching Tool - Loading Utility
 * 
 * This is the class from which the entire program is launched from. It
 * isolates all the GUI handling from the rest of the code by launching
 * the loading utility, and eventually the entire program itself, by using
 * a new thread.
 * 
 * The user launches the program from this class only and not any of the other
 * developed classes.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 22, 2014 - May 7, 2014)
 * 
 * UPDATE (May 19, 2014) - Name of one variable updated.
 * 
 * *NOTE*: You must have all the classes of the program, meaning all the packages,
 * saved together somewhere in the hard drive so that way the JVM works this
 * program properly. The import statements in the code create connections between
 * this code and the code from the other data entries stored in the imported packages.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programCore;

// Resource Packages and Classes
import java.awt.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LoadingUtility 
{
	// GUI Components
	JFrame frame = new JFrame();
	LoadingScreenPanel panel = null;
	
	// Loading Progress Messages (current and library)
	static String progressMessage = "";
	
	LoadingUtility()
	{
		panel = new LoadingScreenPanel();
		frame.add(panel);
		
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
		frame.pack();
		frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - frame.getWidth() / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - frame.getHeight() / 2);
	}
	
	/**
	 * This method simply calls the panel to appear, and start a thread from where
	 * the program construction and initialization is commenced.
	 */
	void showLoadingUtility()
	{
		frame.setVisible(true);
		new Thread(panel.new ApplicationLoadingTask()).start();
	}
	
	
	private class LoadingScreenPanel extends JPanel
	{
		// GUI Components
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		
		
		// Top Panel Resources
		ImageIcon programLogo =
				new ImageIcon(new File("Resource Files/Logos/Program Logo (Cropped).png").getAbsolutePath());
		JLabel programLogoLabel = new JLabel(programLogo);
		JLabel loadingMessage = new JLabel("<html><br/><br/><br/><br/></html> ");
		
		
		// Bottom Panel Resources
		Image campusLogo;
		Image collegeLogo;
		Image developerLogo;
		JLabel creditsLabel = new JLabel();
		
		public LoadingScreenPanel()
		{
			// Image Load
			try
			{
				campusLogo = 
						ImageIO.read(new File("Resource Files/Logos/Campus Logo (Loading Utility).png"));
				collegeLogo =
						ImageIO.read(new File("Resource Files/Logos/Champlain Logo (Loading Utility).png"));
				developerLogo = 
						ImageIO.read(new File("Resource Files/Logos/Developer Logo (Loading Utility).png"));
				
			}
			catch (Exception ex)
			{
				
			}
			
			// Panel Initialization
			setBackground(Color.WHITE);
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
			setLayout(new BorderLayout());
			
			
			
			// Loading Panel Initialization
			loadingMessage.setHorizontalAlignment(JLabel.CENTER);
			loadingMessage.setBorder(new EmptyBorder(15, 0, 15, 0));
			
			try 
			{
				loadingMessage.setFont(Font.createFont(Font.PLAIN, new java.io.File("Resource Files/Fonts/consola.ttf"))
						.deriveFont(16.0f));
			} 
			catch (FontFormatException | IOException e) 
			{
				loadingMessage.setFont(new Font("Arial", Font.PLAIN, 14));
			}
			
			
			// Program Logo, Loading Message & Top Panel Initialization
			topPanel.setLayout(new BorderLayout());
			
			
			topPanel.setBackground(Color.WHITE);
			topPanel.add(programLogoLabel);
			topPanel.add(loadingMessage, BorderLayout.SOUTH);
			add(topPanel, BorderLayout.NORTH);
			
			
			
			/**
			 * Bottom Panel Initialization
			 */
			bottomPanel.setLayout(new BorderLayout());
			
			// Campus Logo
			bottomPanel.add(new JPanel(){

				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					this.setBackground(Color.WHITE);
					g.drawImage(campusLogo, 0, 0, this);
				}
				
				public Dimension getPreferredSize()
				{
					return new Dimension(campusLogo.getWidth(this), campusLogo.getHeight(this));
				}
			}, BorderLayout.WEST);
			
			
			
			
			
			// College Logo
			bottomPanel.add(new JPanel(){

				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.drawImage(collegeLogo, 0, 0, this);
				}
				
				public Dimension getPreferredSize()
				{
					return new Dimension(collegeLogo.getWidth(this), collegeLogo.getHeight(this));
				}
			}, BorderLayout.CENTER);
			
			
			
			
			
			// Developer Logo
			bottomPanel.add(new JPanel(){

				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					this.setBackground(Color.WHITE);
					g.drawImage(developerLogo, 0, 0, this);
				}
				
				public Dimension getPreferredSize()
				{
					return new Dimension(developerLogo.getWidth(this), developerLogo.getHeight(this));
				}
			}, BorderLayout.EAST);
			
			
			bottomPanel.setPreferredSize(new Dimension(750, 124));
			add(bottomPanel);
			
			
			// Credits Label Initialization
			creditsLabel.setBorder(new EmptyBorder(15, 0, 15, 0));
			creditsLabel.setHorizontalAlignment(JLabel.CENTER);
			creditsLabel.setText("<html>© 2014 Champlain Regional College. Production © 2014 Champlain College Saint-Lambert.<br/>" +  
					"Source Code and Project Design © 2014 Gregory Desrosiers.<br/><br/>The Champlain Regional " +
					"College logo, the Champlain College Saint-Lambert logo, the affilates,<br/>and the names, " +
					"are copyrighted material of their respectful owners. All rights reserved.</html>");
		
			add(creditsLabel, BorderLayout.SOUTH);
		}
		
		// This task is responsible for loading the application and updating the progress message
		// of this utility.
		class ApplicationLoadingTask implements Runnable
		{
			final String FIRST_PART_OF_LOADING_LABEL = "<html><div style=\"text-align: center;\">NOW LOADING<br/><br/>",
					SECOND_PART_OF_LOADING_LABEL = "<br/><br/></div></html>";
			
			public void run()
			{
				loadingMessage.setText(FIRST_PART_OF_LOADING_LABEL + progressMessage + SECOND_PART_OF_LOADING_LABEL); 
				
				// Without this thread, there is no way the progress message will change, as this task will
				// be interrupted by the constructor of the Application class.
				new Thread(new Runnable(){
					public void run()
					{
						DesrosiersMechanicsTeachingTool.application = new Application();
					}
				}).start();
				
				// As the application loads, the loading message is updated, making sure that it is
				// somewhat synced with the constructor process of the Application class.
				while(!Application.loadComplete)
				{
					loadingMessage.setText(FIRST_PART_OF_LOADING_LABEL + progressMessage + SECOND_PART_OF_LOADING_LABEL); 
					
					try
					{
						Thread.sleep(1000 / 60);
					}
					catch(InterruptedException ex)
					{
						ex.printStackTrace();
					}
				}
				
				// As soon as the application is loaded, the loading message should say something
				// like this, although this task finishes off so quickly in modern computers
				// that it can't be seen in actual execution.
				loadingMessage.setText("<html><div style=\"text-align: center;\">LOAD COMPLETE<br/><br/>" 
						+ SECOND_PART_OF_LOADING_LABEL); 
				
				new Thread(new DesrosiersMechanicsTeachingTool(). new OpenApplicationTask()).start();
			}
		}
	}
}
