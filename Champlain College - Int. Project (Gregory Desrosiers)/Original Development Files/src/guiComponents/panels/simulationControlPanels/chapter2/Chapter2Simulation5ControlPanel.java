/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 5 Control Panel
 * 
 * This is the control panel for the fifth simulation in Chapter 2 of
 * the program. All the components are layered out using NetBeans IDE
 * 7.3.1.
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
package guiComponents.panels.simulationControlPanels.chapter2;

// Inheritance Class (for polymorphism)
import guiComponents.panels.simulationControlPanels.RawSimulationControlPanel;


// Resource Class
import javax.swing.*;

import java.awt.Component;

import listeners.simulationListeners.documentListeners.Chapter2SimulationControlPanelDocumentListener2;
import listeners.simulationListeners.actionListeners.Chapter2Simulation5ControlPanelActionListener;

// Interaction Class
import programCore.Application;
import programTopicComponents.commonClasses.AstrophysicalData;

@SuppressWarnings("serial")
public class Chapter2Simulation5ControlPanel extends RawSimulationControlPanel
{              
	/*
	 * Panel Components        
	 */
    public static JButton resetButton;
    
    public static JComboBox<String> gravitationalAccelerationComboBox;
    
    public static JLabel launchAngleLabel;
    public static JLabel initialVelocityLabel;
    public static JLabel gravityTypeLabel;
    public static JLabel gravitationalAccelerationLabel;
    
    public static JTextField launchAngleTextField;
    public static JTextField initialVelocityTextField;
    public static JTextField gravitationalAccelerationTextField;
    
    public static JToggleButton startOrStopToggleButton;
    
    // Text Field Document Listeners
    public static Chapter2SimulationControlPanelDocumentListener2 jTextFieldDocumentListener1;
    public static Chapter2SimulationControlPanelDocumentListener2 jTextFieldDocumentListener2;
   
    // Action Listener
    public static Chapter2Simulation5ControlPanelActionListener controlPanelActionListener;
    
    public Chapter2Simulation5ControlPanel() 
    {
        initComponents();
    }
                         
    public void initComponents() 
    {
    	// Component Construction
        launchAngleLabel = new JLabel();
        
        launchAngleTextField = new JTextField();
        
        initialVelocityLabel = new JLabel();
        
        initialVelocityTextField = new JTextField();
        
        gravitationalAccelerationComboBox = new JComboBox<String>();
        
        gravityTypeLabel = new JLabel();
        gravitationalAccelerationLabel = new JLabel();
        
        gravitationalAccelerationTextField = new JTextField();
        
        startOrStopToggleButton = new JToggleButton();
        
        resetButton = new JButton();

        jTextFieldDocumentListener1 = new Chapter2SimulationControlPanelDocumentListener2();
        jTextFieldDocumentListener2 = new Chapter2SimulationControlPanelDocumentListener2();
        
        controlPanelActionListener = new Chapter2Simulation5ControlPanelActionListener();
        
        
        
        
        
        // Component Initialization
        launchAngleLabel.setText("Launch Angle:");

        launchAngleTextField.setDocument(jTextFieldDocumentListener1);
        launchAngleTextField.setHorizontalAlignment(JTextField.RIGHT);
        launchAngleTextField.setText("0");
        launchAngleTextField.setToolTipText("Set the launch angle, in degrees, using this text field. (Between 0° and 90°)");

        initialVelocityLabel.setText("Initial Velocity:");

        initialVelocityTextField.setDocument(jTextFieldDocumentListener2);
        initialVelocityTextField.setHorizontalAlignment(JTextField.RIGHT);
        initialVelocityTextField.setToolTipText("Set the initial velocity of the projectile using this text field.");
        initialVelocityTextField.setText("0");

        
        gravitationalAccelerationComboBox.
        	setModel(new DefaultComboBoxModel<String>(new String[] 
        			{ "Sun", "Mercury", "Venus", "Earth", "Moon", "Mars", "Jupiter", "Io",
        			"Europa", "Saturn", "Uranus", "Titania", "Neptune", "Ceres", "Pluto"}));
        gravitationalAccelerationComboBox.setToolTipText("Select a type of gravity using this combo box.");
        gravitationalAccelerationComboBox.addActionListener(controlPanelActionListener);
        gravitationalAccelerationComboBox.setSelectedIndex(3);
        
        gravityTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gravityTypeLabel.setText("Gravity Type:");

        gravitationalAccelerationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gravitationalAccelerationLabel.setText("Gravitational Acceleration:");

        gravitationalAccelerationTextField.setEditable(false);
        gravitationalAccelerationTextField.setHorizontalAlignment(JTextField.RIGHT);
        gravitationalAccelerationTextField.setText(String.valueOf(AstrophysicalData.EARTH_SURFACE_GRAVITY) + " m/s²");
        gravitationalAccelerationTextField.setToolTipText("Current gravitational acceleration in meters per second "
        		+ "squared.");

        startOrStopToggleButton.setText("Start");

        resetButton.setText("Reset");
        resetButton.setEnabled(false);

        
        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(launchAngleLabel)
                    .addComponent(initialVelocityLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(launchAngleTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                    .addComponent(initialVelocityTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(gravitationalAccelerationTextField)
                    .addComponent(gravitationalAccelerationComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gravityTypeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gravitationalAccelerationLabel, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startOrStopToggleButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(launchAngleLabel)
                            .addComponent(launchAngleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(gravityTypeLabel))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(initialVelocityLabel)
                            .addComponent(initialVelocityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(gravitationalAccelerationComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gravitationalAccelerationLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gravitationalAccelerationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(startOrStopToggleButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetButton)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        
        
        // Setting fonts and action listeners
        for (Component component: getComponents())
        {
        	if (component instanceof AbstractButton || component instanceof JLabel ||
        			component instanceof JTextField || component instanceof JComboBox<?>)
        		component.setFont(Application.simulationModeControlPanelFontObject);
        	
        	if (component instanceof AbstractButton)
        		((AbstractButton)component).addActionListener(controlPanelActionListener);
        	else if (component instanceof JTextField)
        		((JTextField)component).addActionListener(controlPanelActionListener);
        }
    }                      
    
}
