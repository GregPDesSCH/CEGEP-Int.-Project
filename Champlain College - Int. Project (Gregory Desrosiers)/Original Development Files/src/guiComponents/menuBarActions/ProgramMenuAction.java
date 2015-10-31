/**
 * Desrosiers Mechanics Teaching Tool
 * Program Menu Action
 * 
 * Represents the abstract MenuBarAction class, only it includes the
 * appropriate listener for a ProgramMenu object.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 21, 2014)
 * 
 * UPDATE (May 5, 2014) - Comment introduced
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.menuBarActions;

// Resource Classes
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class ProgramMenuAction extends MenuBarAction 
{
	public ProgramMenuAction(String name, String toolTipText, Integer mnemonicKey, KeyStroke actionKey)
	{
		super(name, toolTipText, mnemonicKey, actionKey);
	}
	
	// For a more appropriate use of this action and for better organization,
	// if this action receives an action event, it's passed on to the associated
	// action listener object referenced by the Application class.
	public void actionPerformed(ActionEvent e)
	{
		Application.programMenuListener.actionPerformed(e);
	}
}
