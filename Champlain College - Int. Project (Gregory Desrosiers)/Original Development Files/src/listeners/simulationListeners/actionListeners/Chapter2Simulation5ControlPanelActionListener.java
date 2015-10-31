/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 5 Control Panel Action Listener
 * 
 * This listener responds to components for the control panel of the
 * fifth simulation of Chapter 2.
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

import programCore.Application;
import programCore.DialogLabelText;
import programTopicComponents.commonClasses.AstrophysicalData;
import guiComponents.panels.simulationControlPanels.chapter2.Chapter2Simulation2ControlPanel;
// Interaction Class
import guiComponents.panels.simulationControlPanels.chapter2.Chapter2Simulation5ControlPanel;

public class Chapter2Simulation5ControlPanelActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Chapter2Simulation5ControlPanel.gravitationalAccelerationComboBox)
			setGravitationalAccelerationTextField();
		else if (e.getSource() == Chapter2Simulation5ControlPanel.startOrStopToggleButton)
		{
			Application.dialogLabel.setText(DialogLabelText.simulationUnimplementedMessage2);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, 
					"No Animation - Simulation Unimplemented", JOptionPane.WARNING_MESSAGE);
			
			Chapter2Simulation2ControlPanel.startOrStopToggleButton.setSelected(false);
		}
	}
	
	public void setGravitationalAccelerationTextField()
	{
		int selectedGravitationalAccelerationComboBoxIndex =
				Chapter2Simulation5ControlPanel.gravitationalAccelerationComboBox.getSelectedIndex();
		
		if (selectedGravitationalAccelerationComboBoxIndex == 0)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.SUN_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 1)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.MERCURY_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 2)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.VENUS_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 3)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.EARTH_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 4)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.MOON_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 5)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.MARS_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 6)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.JUPITER_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 7)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.IO_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 8)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.EUROPA_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 9)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.SATURN_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 10)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.URANUS_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 11)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.TITANIA_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 12)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.NEPTUNE_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 13)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.CERES_SURFACE_GRAVITY));
		
		else if (selectedGravitationalAccelerationComboBoxIndex == 14)
			Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
					String.valueOf(AstrophysicalData.PLUTO_SURFACE_GRAVITY));
		
		Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.setText(
				Chapter2Simulation5ControlPanel.gravitationalAccelerationTextField.getText() 
				+ " m/s²");
	}
}
