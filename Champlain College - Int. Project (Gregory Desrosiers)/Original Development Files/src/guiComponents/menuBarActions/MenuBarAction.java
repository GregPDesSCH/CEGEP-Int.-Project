/**
 * Desrosiers Mechanics Teaching Tool
 * Menu Bar Action
 * 
 * A raw class that allows actions to be added to the menu bars in this
 * program without having to write code for the common components. This saves
 * time when attempting to create buttons for menus.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Mar 25, 2014)
 * 
 * Update (April 29, 2014) - Source Code more organized.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.menuBarActions;

// Resource Package
import javax.swing.*;

@SuppressWarnings("serial")
public abstract class MenuBarAction extends AbstractAction 
{

	public MenuBarAction(String name, String toolTipText, Integer mnemonicKey, KeyStroke actionKey)
	{
		super(name);
		putValue(Action.SHORT_DESCRIPTION, toolTipText);
		putValue(Action.MNEMONIC_KEY, mnemonicKey);
		putValue(Action.ACCELERATOR_KEY, actionKey);
	}
}
