/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 6 Control Panel Action Listener
 * 
 * This listener responds to components for the control panel of the
 * sixth simulation of Chapter 2.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 26, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * UPDATE (May 19, 2014) - Problem with the simulation fixed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.simulationListeners.actionListeners;

// Resource Classes and Packages
import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;

// Interaction Classes
import programCore.*;
import programTopicComponents.simulations.chapter2.Chapter2Simulation6;
import tasks.simulations.chapter2.Chapter2Simulation6Task;
import guiComponents.panels.simulationControlPanels.chapter2.Chapter2Simulation6ControlPanel;

public class Chapter2Simulation6ControlPanelActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Chapter2Simulation6ControlPanel.radiusTextField ||
				e.getSource() == Chapter2Simulation6ControlPanel.tangentialVelocityTextField ||
				e.getSource() == Chapter2Simulation6ControlPanel.tangentialAccelerationTextField)
			processEnteredDataForAnimation();
		else if (e.getSource() == Chapter2Simulation6ControlPanel.startOrStopToggleButton)
		{
			if (Chapter2Simulation6ControlPanel.startOrStopToggleButton.isSelected())
			{
				if (Chapter2Simulation6ControlPanel.radiusTextField.isEnabled()) 
					// Only process new simulation info if the user enters new data.
					processEnteredDataForAnimation();
				
				if (Application.simulationThread == null)
				{
					Application.chapter2Simulation6Task = new Chapter2Simulation6Task();
					Application.simulationThread = new Thread(Application.chapter2Simulation6Task);
				}
				
				Application.simulationThread.start();
				
				if (Application.currentSimulation.simulationResetted)
					Application.currentSimulation.simulationResetted = false;
				
				Chapter2Simulation6ControlPanel.startOrStopToggleButton.setText("Stop");
				
				Chapter2Simulation6ControlPanel.radiusTextField.setEnabled(false);
				Chapter2Simulation6ControlPanel.tangentialVelocityTextField.setEnabled(false);
				Chapter2Simulation6ControlPanel.tangentialAccelerationTextField.setEnabled(false);
				Chapter2Simulation6ControlPanel.resetButton.setEnabled(true);
			}
			else
			{
				disposeThread();
				
				Chapter2Simulation6ControlPanel.startOrStopToggleButton.setText("Start");
			}
		}
		else if (e.getSource() == Chapter2Simulation6ControlPanel.resetButton)
		{
			if (Chapter2Simulation6ControlPanel.startOrStopToggleButton.isSelected())
			{
				disposeThread();
				
				Chapter2Simulation6ControlPanel.startOrStopToggleButton.setSelected(false);
				Chapter2Simulation6ControlPanel.startOrStopToggleButton.setText("Start");
			}
			
			Application.currentSimulation.resetSimulation();
			
			Application.currentSimulation.simulationResetted = true;
			
			Chapter2Simulation6ControlPanel.radiusTextField.setEnabled(true);
			Chapter2Simulation6ControlPanel.tangentialVelocityTextField.setEnabled(true);
			Chapter2Simulation6ControlPanel.tangentialAccelerationTextField.setEnabled(true);
			Chapter2Simulation6ControlPanel.resetButton.setEnabled(false);
		}
		
		Application.simulationPanel.simulationViewingPanel.repaint();
	}
	
	private boolean checkForEmptyEntries()
	{
		byte numberOfEmptyEntries = 0;
		
		for (Component component : Application.chapter2Simulation1ControlPanel.getComponents())
		{
			if (component instanceof JTextField)
				if (((JTextField)component).getText().equals(""))
					numberOfEmptyEntries++;
		}
		
		if (numberOfEmptyEntries == 0)
			return false;
		else if (numberOfEmptyEntries == 1)
		{
			Application.dialogLabel.setText(DialogLabelText.simulationEmptyEntriesMessage1);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Empty Entry", JOptionPane.ERROR_MESSAGE);
		}
		else if (numberOfEmptyEntries > 1)
		{
			Application.dialogLabel.setText(DialogLabelText.simulationEmptyEntriesMessage2);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Empty Entry", JOptionPane.ERROR_MESSAGE);
		}
			
		return true;
	}
	
	public boolean checkForEntryErrors(float radiusEntry, float tangentialVelocityEntry, float tangentialAccelerationEntry)
	{
		
		if (radiusEntry > 125.0f)
		{
			Application.dialogLabel.setText(DialogLabelText.radiusTooBigMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Component Too Big",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		else if (radiusEntry < 45.0f)
		{
			Application.dialogLabel.setText(DialogLabelText.radiusTooSmallMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Component Too Big",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		
		
		if (tangentialVelocityEntry > 500.0f)
		{
			Application.dialogLabel.setText(DialogLabelText.tangentialVelocityTooHighMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Component Too Big",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		else if (tangentialVelocityEntry < -500.0f)
		{
			Application.dialogLabel.setText(DialogLabelText.tangentialVelocityTooLowMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Component Too Big",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		
		
		if (tangentialAccelerationEntry > 100.0f)
		{
			Application.dialogLabel.setText(DialogLabelText.tangentialAccelerationTooHighMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Component Too Big",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		else if (tangentialAccelerationEntry < -100.0f)
		{
			Application.dialogLabel.setText(DialogLabelText.tangentialAccelerationTooLowMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Component Too Big",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		
		
		return false;
	}
	
	public void replaceThread()
	{
		Application.simulationThread = null;
		Application.chapter2Simulation6Task.releaseThread = true;
		
		Application.chapter2Simulation6Task = new Chapter2Simulation6Task();
		Application.simulationThread = new Thread(Application.chapter2Simulation6Task);
	}
	
	public void disposeThread()
	{
		Application.simulationThread = null;
		Application.chapter2Simulation6Task.releaseThread = true;
		
		Application.chapter2Simulation6Task = null;
		Application.garbageCollector.gc();
	}
	
	public void processEnteredDataForAnimation()
	{
		if (checkForEmptyEntries())
		{
			Chapter2Simulation6ControlPanel.startOrStopToggleButton.setSelected(false);
			return;
		}
		
		float radiusEntry = Float.parseFloat(Chapter2Simulation6ControlPanel.radiusTextField.getText()),
				tangentialVelocityEntry = Float.parseFloat(Chapter2Simulation6ControlPanel.tangentialVelocityTextField.getText()),
				tangentialAccelerationEntry = Float.parseFloat(Chapter2Simulation6ControlPanel.tangentialAccelerationTextField.getText());
		
		if (checkForEntryErrors(radiusEntry, tangentialVelocityEntry, tangentialAccelerationEntry))
			return;
		
		
		// Radius
		Chapter2Simulation6.radiusOfMotion = radiusEntry;
		
		Chapter2Simulation6.rotationOutline.setFrame(- Chapter2Simulation6.radiusOfMotion, 
				- Chapter2Simulation6.radiusOfMotion, 2 * Chapter2Simulation6.radiusOfMotion, 
				2 * Chapter2Simulation6.radiusOfMotion);
		
		
		
		// Tangential Velocity
		Chapter2Simulation6.tangentialVelocity = tangentialVelocityEntry;
		
		float tangentialVelocityFactor = .25f;
		
		if (Chapter2Simulation6.tangentialVelocity >= 0)
			for (; tangentialVelocityFactor * 64.0f < Chapter2Simulation6.tangentialVelocity; tangentialVelocityFactor += .25f){}
		else
		{
			tangentialVelocityFactor = -tangentialVelocityFactor;
			for (; tangentialVelocityFactor * 64.0f > Chapter2Simulation6.tangentialVelocity; tangentialVelocityFactor -= .25f){}
		}
		
		Chapter2Simulation6.tangentialVelocityLine.setLine(0, - Chapter2Simulation6.radiusOfMotion, 
				Chapter2Simulation6.tangentialVelocity / Math.abs(tangentialVelocityFactor), - Chapter2Simulation6.radiusOfMotion);
		
		
		
		
		// Tangential Acceleration
		Chapter2Simulation6.tangentialAcceleration = tangentialAccelerationEntry;
		
		float tangentialAccelerationFactor = 0.0f;
		
		if (Chapter2Simulation6.tangentialAcceleration >= 0)
			for (; tangentialAccelerationFactor * 250.0f < Chapter2Simulation6.tangentialAcceleration; tangentialAccelerationFactor += .05f){}
		else
		{
			tangentialVelocityFactor = -tangentialVelocityFactor;
			for (; tangentialAccelerationFactor * 250.0f > Chapter2Simulation6.tangentialAcceleration; tangentialAccelerationFactor -= .05f){}
		}
		
		if (tangentialAccelerationFactor != 0.0f)
			Chapter2Simulation6.tangentialAccelerationLine.setLine(310, 150 - Chapter2Simulation6.radiusOfMotion - 15.0f, 
					310 - Chapter2Simulation6.tangentialAcceleration / Math.abs(tangentialAccelerationFactor), 
					150 - Chapter2Simulation6.radiusOfMotion - 15.0f);
		else
			Chapter2Simulation6.tangentialAccelerationLine.setLine(310, 150 - Chapter2Simulation6.radiusOfMotion - 15.0f, 
					310, 150 - Chapter2Simulation6.radiusOfMotion - 15.0f);
	}
	
}
