/**
 * Desrosiers Mechanics Teaching Tool - Simulation Panel
 * 
 * This is what the user sees when he/she is in Simulation Mode.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description and comments added.
 * UPDATE (May 19, 2014) - Constant variable for the panel resolution
 * has its name changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.panels;

// Resource Packages
import javax.swing.*;

import java.awt.*;

// Interaction Class
import programCore.Application;
import programTopicComponents.simulations.SimulationControlNames;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel 
{                    
	/*
	 * Panel Components        
	 */
	public JLabel currentSimulationLabel;
	
	public JPanel simulationControlPanel;
	
	public SimulationViewingPanel simulationViewingPanel;
	
	
	
    public SimulationPanel() 
    {
        initComponents();
    }

    // Most of the code is generated from NetBeans IDE 7.3.1. 
    /**
     * Builds all the components of the simulation panel and initializes
     * them accordingly.
     */            
    private void initComponents() 
    {
    	// Size Initialization
    	setPreferredSize(Application.PROGRAM_RESOLUTION);
    	
    	
    	// Component Construction
        simulationControlPanel = new JPanel(new CardLayout());
        currentSimulationLabel = new JLabel();
        simulationViewingPanel = new SimulationViewingPanel();

        
        
        simulationControlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        // Component Initialization
        currentSimulationLabel.setFont(Application.centralFontObject); 
        currentSimulationLabel.setText("currentSimulationLabel");

        simulationViewingPanel.setBackground(Color.WHITE);
        simulationViewingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        simulationViewingPanel.setPreferredSize(new Dimension(622, 300));

        GroupLayout simulationViewingPanelLayout = new GroupLayout(simulationViewingPanel);
        simulationViewingPanel.setLayout(simulationViewingPanelLayout);
        simulationViewingPanelLayout.setHorizontalGroup(
            simulationViewingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        simulationViewingPanelLayout.setVerticalGroup(
            simulationViewingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(simulationViewingPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentSimulationLabel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 370, Short.MAX_VALUE))
                    .addComponent(simulationControlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentSimulationLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulationViewingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simulationControlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }                   
    
    /**
     * Loads the control panels into this generalized panel that displays
     * one control panel at a time.
     */
    public void loadSimulationControlPanels()
    {
    	simulationControlPanel.add(Application.chapter2Simulation1ControlPanel, 
    			SimulationControlNames.chapter2Simulation1ControlPanelName);
    	
    	simulationControlPanel.add(Application.chapter2Simulation2ControlPanel, 
    			SimulationControlNames.chapter2Simulation2ControlPanelName);
    	
    	simulationControlPanel.add(Application.chapter2Simulation3ControlPanel, 
    			SimulationControlNames.chapter2Simulation3ControlPanelName);
    	
    	simulationControlPanel.add(Application.chapter2Simulation4ControlPanel, 
    			SimulationControlNames.chapter2Simulation4ControlPanelName);
    	
    	simulationControlPanel.add(Application.chapter2Simulation5ControlPanel, 
    			SimulationControlNames.chapter2Simulation5ControlPanelName);
    	
    	simulationControlPanel.add(Application.chapter2Simulation6ControlPanel, 
    			SimulationControlNames.chapter2Simulation6ControlPanelName);
    }
    
    /*
     * This panel displays the visual components of the current simulation.
     */
    public class SimulationViewingPanel extends JPanel
    {
    	private SimulationViewingPanel()
    	{
    		setBackground(Color.WHITE);
    		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    	}
    	
    	protected void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		
    		if (Application.currentSimulation != null)
    			Application.currentSimulation.paintGraphics(((Graphics2D)g));
    	}
    	
    	public Dimension getPreferredSize()
    	{
    		return new Dimension(622, 300);
    	}
    }
}
