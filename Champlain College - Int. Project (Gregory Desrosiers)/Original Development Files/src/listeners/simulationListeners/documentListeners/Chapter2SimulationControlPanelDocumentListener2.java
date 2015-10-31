/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 2 Control Panel
 * 
 * This is the control panel for the second simulation in Chapter 2 of
 * the program. All the components are layered out using NetBeans IDE
 * 7.3.1.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 26, 2014 - May 6, 2014)
 * 
 * UPDATE (May 20, 2014) - The only constant in this class has its variable 
 * name changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.simulationListeners.documentListeners;

// Resource Package
import javax.swing.text.*;

@SuppressWarnings("serial")
public class Chapter2SimulationControlPanelDocumentListener2 extends
		PlainDocument 
{
	private final int STRING_MAX_SIZE = 15;

	public void insertString(int offset, String str, AttributeSet attr) 
			  throws BadLocationException 
	{
		if (str == null)
			return;
		
		int numberOfDecimalPoints = 0;
		
		for (int b = 0; b < getLength(); b++)
			if (getText(0, getLength()).charAt(b) == '.')
				numberOfDecimalPoints++;
		
		for(int x = 0; x < str.length(); x++)
		{	
			if (str.charAt(x) == '.')
				numberOfDecimalPoints++;
			
			else if ((str.charAt(x) < 48 || str.charAt(x) > 57) &&
					str.charAt(x) != '.')
				return;
		}
			
		
		if ((getLength() + str.length()) <= STRING_MAX_SIZE && numberOfDecimalPoints <= 1) 
			super.insertString(offset, str, attr);
	}
}
