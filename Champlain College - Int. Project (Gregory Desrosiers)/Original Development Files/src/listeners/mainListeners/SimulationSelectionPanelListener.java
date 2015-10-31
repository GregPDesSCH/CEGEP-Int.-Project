/**
 * Desrosiers Mechanics Teaching Tool
 * Simulation Selection Panel Listener
 * 
 * This is the listener for the Simulation Selection Panel.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (February 21, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * UPDATE (May 19, 2014) - Name constants declared in the Application class 
 * have been changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.mainListeners;

// Resource Package and Classes
import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.JOptionPane;


// Interaction Classes
import programCore.Application;
import programCore.DialogLabelText;
import programTopicComponents.simulations.SimulationControlNames;
import programTopicComponents.simulations.chapter2.*;

public class SimulationSelectionPanelListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Application.simulationSelectionPanel.simulationComboBox)
		{
			int selectedIndex = Application.simulationSelectionPanel.
					simulationComboBox.getSelectedIndex();
			
			
			

			if (selectedIndex == 0)
			{
    			Application.simulationSelectionPanel.selectedSimulationTextArea
    				.setText(Chapter2Simulation1.simulationDescription);
    			Application.currentSimulation = Application.chapter2Simulation1Object;
			}
			
    		else if (selectedIndex == 1)
    		{
    			Application.simulationSelectionPanel.selectedSimulationTextArea
					.setText(Chapter2Simulation2.simulationDescription);
    			Application.currentSimulation = Application.chapter2Simulation2Object;
    		}
    		
    		else if (selectedIndex == 2)
    		{
    			Application.simulationSelectionPanel.selectedSimulationTextArea
					.setText(Chapter2Simulation3.simulationDescription);
    			Application.currentSimulation = Application.chapter2Simulation3Object;
    		}
    		
    		else if (selectedIndex == 3)
    		{
    			Application.simulationSelectionPanel.selectedSimulationTextArea
					.setText(Chapter2Simulation4.simulationDescription);
    			Application.currentSimulation = Application.chapter2Simulation4Object;
    		}
    		
    		else if (selectedIndex == 4)
    		{
    			Application.simulationSelectionPanel.selectedSimulationTextArea
					.setText(Chapter2Simulation5.simulationDescription);
    			Application.currentSimulation = Application.chapter2Simulation5Object;
    		}
    		
    		else if (selectedIndex == 5)
    		{
    			Application.simulationSelectionPanel.selectedSimulationTextArea
					.setText(Chapter2Simulation6.simulationDescription);
    			Application.currentSimulation = Application.chapter2Simulation6Object;
    		}
			
			Application.simulationSelectionPanel.simulationPreviewPanel.repaint();
		}
		else if (e.getSource() == Application.simulationSelectionPanel.okButton)
		{
			int selectedIndex = Application.simulationSelectionPanel.
					simulationComboBox.getSelectedIndex();
			
			if (selectedIndex != 0 && selectedIndex != 5)
			{
				Application.dialogLabel.setText(DialogLabelText.simulationUnimplementedMessage);
				byte selectedOption = (byte)(JOptionPane.showConfirmDialog(null, Application.dialogLabel, 
						"Simulation Not Available", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE));
				
				if (selectedOption == JOptionPane.YES_OPTION)
					loadSimulationMode(selectedIndex);
			}
			else
				loadSimulationMode(selectedIndex);
		}
		else if (e.getSource() == Application.simulationSelectionPanel.backButton)
		{
			Application.restartMainMenuThread();
			
			CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
			Application.currentPanelName = Application.MAIN_MENU_NAME;
			mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
		}
	}
	
	/**
	 * Loads the simulation based on what is selected from the simulation combo box.
	 * @param selectedIndex The index of the list from which the item is selected.
	 */
	public void loadSimulationMode(int selectedIndex)
	{
		CardLayout controlPanelLayout = (CardLayout)(Application.simulationPanel.simulationControlPanel.getLayout());
		
		if (selectedIndex == 0)
		{
			Application.currentSimulation = Application.chapter2Simulation1Object;
			controlPanelLayout.show(Application.simulationPanel.simulationControlPanel, 
					SimulationControlNames.chapter2Simulation1ControlPanelName);
			
			Application.simulationPanel.currentSimulationLabel.setText("Chapter 2.1: Vectors");
		}
		else if (selectedIndex == 1)
		{
			Application.currentSimulation = Application.chapter2Simulation2Object;
			controlPanelLayout.show(Application.simulationPanel.simulationControlPanel, 
					SimulationControlNames.chapter2Simulation2ControlPanelName);
			
			Application.simulationPanel.currentSimulationLabel.setText("Chapter 2.2: Velocity & Acceleration Vectors");
		}
		else if (selectedIndex == 2)
		{
			Application.currentSimulation = Application.chapter2Simulation3Object;
			controlPanelLayout.show(Application.simulationPanel.simulationControlPanel, 
					SimulationControlNames.chapter2Simulation3ControlPanelName);
			
			Application.simulationPanel.currentSimulationLabel.setText("Chapter 2.3: Relative Motion");
		}
		else if (selectedIndex == 3)
		{
			Application.currentSimulation = Application.chapter2Simulation4Object;
			controlPanelLayout.show(Application.simulationPanel.simulationControlPanel, 
					SimulationControlNames.chapter2Simulation4ControlPanelName);
			
			Application.simulationPanel.currentSimulationLabel.setText("Chapter 2.4: Constant Acceleration");
		}
		else if (selectedIndex == 4)
		{
			Application.currentSimulation = Application.chapter2Simulation5Object;
			controlPanelLayout.show(Application.simulationPanel.simulationControlPanel, 
					SimulationControlNames.chapter2Simulation5ControlPanelName);
			
			Application.simulationPanel.currentSimulationLabel.setText("Chapter 2.5: Projectile Motion");
		}
		else if (selectedIndex == 5)
		{
			Application.currentSimulation = Application.chapter2Simulation6Object;
			controlPanelLayout.show(Application.simulationPanel.simulationControlPanel, 
					SimulationControlNames.chapter2Simulation6ControlPanelName);
			
			Application.simulationPanel.currentSimulationLabel.setText("Chapter 2.6: Uniform Circular Motion");
		}
		
		CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
		Application.currentPanelName = Application.SIMULATION_MODE_NAME;
		mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
		
		Application.frame.setJMenuBar(Application.simulationMenuBar);
	}
}
