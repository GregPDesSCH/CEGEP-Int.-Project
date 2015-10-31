/**
 * Desrosiers Mechanics Teaching Tool
 * Simulation Menu Listener
 * 
 * This is the listener for the Simulation Menu in the menu bar for 
 * Simulation Mode.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 21, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * UPDATE (May 17, 2014) - Dialog Title bug fixed.
 * UPDATE (May 19, 2014) - Name constants declared in the Application class 
 * have been changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.menuBarListeners;

// Resource Package and Class
import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.*;

import programCore.DialogLabelText;


// Interaction Class
import programCore.Application;

public class SimulationMenuListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		/*
		 * The menu is assigned to several menu bars. The listener is kept as
		 * a separate class than the listeners already assigned to the actions
		 * for the menu when created.
		 */
		JMenu menuOfEventTrigger = Application.frame.getJMenuBar().getMenu(1);
		
		// When the user clicks on the Start button. 
		if (e.getSource() == menuOfEventTrigger.getItem(0))
		{
			if (!Application.currentSimulation.animationSupported)
			{
				Application.dialogLabel.setText(DialogLabelText.simulationAnimationUnsupportedMessage);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, 
						"No Animation", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				if (!Application.currentSimulation.threadAvailable)
				{
					Application.dialogLabel.setText(DialogLabelText.simulationUnimplementedMessage2);
				
					JOptionPane.showMessageDialog(null, Application.dialogLabel, 
							"No Animation - Simulation Unimplemented", JOptionPane.WARNING_MESSAGE);
				}
				else if (Application.simulationThread == null)
				{
					Application.currentSimulation.replaceThread();
				}
				
				
				if (!Application.simulationThread.isAlive())
				{
					Application.simulationThread.start();
					Application.currentSimulation.setPropertiesForStartingAnimationThread();
					
					if (Application.currentSimulation.simulationResetted)
						Application.currentSimulation.simulationResetted = false;
				}
			}
		}
		// When the user clicks on the Stop button. 
		else if (e.getSource() == menuOfEventTrigger.getItem(1))
		{
			if (!Application.currentSimulation.animationSupported)
			{
				Application.dialogLabel.setText(DialogLabelText.simulationAnimationUnsupportedMessage2);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, 
						"No Animation", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				if (!Application.currentSimulation.threadAvailable)
				{
					Application.dialogLabel.setText(DialogLabelText.simulationUnimplementedMessage2);
				
					JOptionPane.showMessageDialog(null, Application.dialogLabel, 
							"No Animation - Simulation Unimplemented", JOptionPane.WARNING_MESSAGE);
				}
				else if (Application.simulationThread == null || !Application.simulationThread.isAlive())
				{
					Application.dialogLabel.setText(DialogLabelText.simulationAlreadyStoppedMessage);
					
					JOptionPane.showMessageDialog(null, Application.dialogLabel, 
							"No Animation - Simulation Unimplemented", JOptionPane.WARNING_MESSAGE);
				}
				else if (Application.simulationThread.isAlive())
				{
					if (Application.chapter2Simulation6Task != null)
						Application.chapter2Simulation6Task.releaseThread = true;
					
					Application.currentSimulation.replaceThread();
					Application.currentSimulation.setPropertiesForStoppingAnimationThread();
				}
			}
		}
		// When the user clicks on the Reset button.
		else if (e.getSource() == menuOfEventTrigger.getItem(2))
		{
			if (Application.currentSimulation.threadAvailable && !Application.currentSimulation.simulationResetted)
			{
				Application.currentSimulation.setPropertiesForStoppingAnimationThread();
			
				Application.currentSimulation.disposeThread();
				Application.currentSimulation.resetSimulation();
				Application.currentSimulation.reEnableComponentsAfterReset();
			
				Application.simulationPanel.simulationViewingPanel.repaint();
				Application.currentSimulation.simulationResetted = true;
			}
			else if (Application.currentSimulation.simulationResetted)
			{
				Application.dialogLabel.setText(DialogLabelText.simulationAlreadyResetMessage);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, 
						"Reset Simulation", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				Application.dialogLabel.setText(DialogLabelText.simulationUnimplementedMessage2);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, 
						"No Animation - Simulation Unimplemented", JOptionPane.WARNING_MESSAGE);
			}
		}
		// When the user clicks on the button to change simulation.
		else if (e.getSource() == menuOfEventTrigger.getItem(3))
		{
			Application.dialogLabel.setText(DialogLabelText.changeSimulationMessage);
			
			byte selectedButton = (byte)
					(JOptionPane.showConfirmDialog(null, Application.dialogLabel, "Change Simulation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
			
			if (selectedButton == JOptionPane.YES_OPTION)
			{
				Application.currentSimulation.resetSimulation();
				Application.currentSimulation.disposeThread();
				Application.garbageCollector.gc();
				
				Application.frame.setJMenuBar(Application.centralProgramMenuBar);
				
				CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
				Application.currentPanelName = Application.SIMULATION_SELECT_NAME;
				mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			}
		}
		// When the user clicks on the button to quit Simulation Mode.
		else if (e.getSource() == menuOfEventTrigger.getItem(4))
		{
			Application.dialogLabel.setText(DialogLabelText.quitSimulationModeMessage);
			
			byte selectedButton = (byte)
					(JOptionPane.showConfirmDialog(null, Application.dialogLabel, "Quit Simulation Mode",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
			
			if (selectedButton == JOptionPane.YES_OPTION)
			{
				Application.currentSimulation.resetSimulation();
				Application.currentSimulation.disposeThread();
				Application.garbageCollector.gc();
				
				Application.frame.setJMenuBar(Application.centralProgramMenuBar);
				
				Application.restartMainMenuThread();
				
				CardLayout mainPanelLayout = (CardLayout)(Application.mainPanel.getLayout());
				Application.currentPanelName = Application.MAIN_MENU_NAME;
				mainPanelLayout.show(Application.mainPanel, Application.currentPanelName);
			}
		}
	}
}
