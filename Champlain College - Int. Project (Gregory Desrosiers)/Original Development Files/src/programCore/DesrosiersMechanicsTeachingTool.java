/**
 * Desrosiers Mechanics Teaching Tool - Program Launcher
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
 * @version 1.0 (Feb 22, 2014 - May 6, 2014)
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

// Resource Package
import javax.swing.*;

// Interaction Class
import tasks.TitleScreenTask;

public class DesrosiersMechanicsTeachingTool 
{
	// Frame Pointers
	public static LoadingUtility loadingUtility;
	public static Application application;
	
	// Program Starter Method
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				/*
				 * On startup, a temporary dialog appears indicating that
				 * the program is starting.
				 */
				loadingUtility = new LoadingUtility();

				/*
				 * Loading utility appears on the screen, and this launcher is kept in place
				 * until the the application is completely built and ready to be rendered
				 * on screen.
				 */
				loadingUtility.showLoadingUtility();
			}
		});
	}
	
	/*
	 * At this point, the application has been loaded onto the RAM, and so this
	 * class makes the window appear on the screen before the launcher thread
	 * closes up by itself.
	 */
	class OpenApplicationTask implements Runnable
	{
		public void run()
		{
			loadingUtility.frame.dispose();
			loadingUtility = null;
			
			Application.garbageCollector = Runtime.getRuntime();
			Application.garbageCollector.gc();
			
			new Thread(new TitleScreenTask()).start();
			
			Application.frame.setVisible(true);
		}
	}
}
