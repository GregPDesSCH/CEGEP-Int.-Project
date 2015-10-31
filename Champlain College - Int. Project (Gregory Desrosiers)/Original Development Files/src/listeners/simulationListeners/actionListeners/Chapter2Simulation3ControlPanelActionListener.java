/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 3 Control Panel Action Listener
 * 
 * This listener responds to components for the control panel of the
 * third simulation of Chapter 2.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 26, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.simulationListeners.actionListeners;

// Resource Package
import java.awt.event.*;
import javax.swing.JOptionPane;

// Interaction Class
import programCore.Application;
import programCore.DialogLabelText;
import guiComponents.panels.simulationControlPanels.chapter2.Chapter2Simulation3ControlPanel;

public class Chapter2Simulation3ControlPanelActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Chapter2Simulation3ControlPanel.startOrStopToggleButton)
		{
			Application.dialogLabel.setText(DialogLabelText.simulationUnimplementedMessage2);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, 
					"No Animation - Simulation Unimplemented", JOptionPane.WARNING_MESSAGE);
			
			Chapter2Simulation3ControlPanel.startOrStopToggleButton.setSelected(false);
		}
	}
}
