/**
 * Desrosiers Mechanics Teaching Tool
 * Raw Simulation Control Panel
 * 
 * Since all the simulation control panels will occupy the same size, and that 
 * there has to be a generalized data type for a panel the program will set one 
 * panel to in Simulation Mode, this class not only serves as a data type that
 * the control panels will be referenced by, but also holds the default size
 * of the panel to be fitted in the simulation control box in Simulation Mode.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 25, 2014 - May 6, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.panels.simulationControlPanels;

// Resource Classes
import javax.swing.JPanel;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class RawSimulationControlPanel extends JPanel 
{	
	public Dimension getPreferredSize()
	{
		// Resolution determined by NetBeans IDE 7.3.1.
		// (from the WYSIWYG Editor)
		return new Dimension(620, 126);
	}
}
