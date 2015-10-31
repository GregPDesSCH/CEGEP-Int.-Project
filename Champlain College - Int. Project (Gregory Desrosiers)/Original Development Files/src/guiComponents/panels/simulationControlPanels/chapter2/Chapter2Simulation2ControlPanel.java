/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 2 Control Panel
 * 
 * This is the control panel for the second simulation in Chapter 2 of
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

// Resource Classes
import javax.swing.*;
import listeners.simulationListeners.actionListeners.Chapter2Simulation2ControlPanelActionListener;
import listeners.simulationListeners.documentListeners.*;
import java.awt.Component;

// Interaction Class
import programCore.Application;


@SuppressWarnings("serial")
public class Chapter2Simulation2ControlPanel extends RawSimulationControlPanel
{                    
	/*
	 * Panel Components        
	 */
    public static JLabel vector1Label;
    public static JLabel vector1VelocityLabel;
    public static JLabel vector1AccelerationLabel;
    public static JLabel vector2Label;
    public static JLabel vector2VelocityLabel;
    public static JLabel vector2AccelerationLabel;
    public static JLabel vector1TimeFrameIntervalLabel;
    public static JLabel vector2TimeFrameIntervalLabel;
    
    public static JTextField vector1VelocityTextField;
    public static JTextField vector1AccelerationTextField;
    public static JTextField vector2AccelerationTextField;
    public static JTextField vector2VelocityTextField;
    public static JTextField vector1TimeFrameIntervalTextField;
    public static JTextField vector2TimeFrameIntervalTextField;
    
    public static JToggleButton startOrStopToggleButton;
    
    public static JButton resetButton;
    
	// Text Field Document Listeners
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener1;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener2;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener3;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener4;
    
    public static Chapter2SimulationControlPanelDocumentListener2 jTextFieldDocumentListener5;
    public static Chapter2SimulationControlPanelDocumentListener2 jTextFieldDocumentListener6;

    // Action Listener
    public static Chapter2Simulation2ControlPanelActionListener controlPanelActionListener;
    
    public Chapter2Simulation2ControlPanel() 
    {
        initComponents();
    }
                   
    public void initComponents() 
    {
    	// Component Construction
        vector1Label = new JLabel();
        vector1VelocityLabel = new JLabel();
        
        vector1VelocityTextField = new JTextField();
        
        vector1AccelerationLabel = new JLabel();
        
        vector1AccelerationTextField = new JTextField();
        
        
        vector2Label = new JLabel();
        vector2VelocityLabel = new JLabel();
        vector2AccelerationLabel = new JLabel();
        
        vector2VelocityTextField = new JTextField();
        vector2AccelerationTextField = new JTextField();
        
        
        
        vector1TimeFrameIntervalLabel = new JLabel();
        vector2TimeFrameIntervalLabel = new JLabel();
        
        vector1TimeFrameIntervalTextField = new JTextField();
        vector2TimeFrameIntervalTextField = new JTextField();
        
        startOrStopToggleButton = new JToggleButton();
        
        resetButton = new JButton();

        jTextFieldDocumentListener1 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener2 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener3 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener4 = new Chapter2SimulationControlPanelDocumentListener1();
        
        jTextFieldDocumentListener5 = new Chapter2SimulationControlPanelDocumentListener2();
        jTextFieldDocumentListener6 = new Chapter2SimulationControlPanelDocumentListener2();
        
        controlPanelActionListener = new Chapter2Simulation2ControlPanelActionListener();
        
        
        
        
        
        // Component Initialization
        vector1Label.setText("Vector 1 (V1)");

        vector1VelocityLabel.setText("Velocity");

        vector1VelocityTextField.setDocument(jTextFieldDocumentListener1);
        vector1VelocityTextField.setHorizontalAlignment(JTextField.RIGHT);
        vector1VelocityTextField.setText("0");
        vector1VelocityTextField.setToolTipText("Set the velocity of the first vector using this text field.");

        vector1AccelerationLabel.setText("Acceleration");

        vector1AccelerationTextField.setDocument(jTextFieldDocumentListener2);
        vector1AccelerationTextField.setHorizontalAlignment(JTextField.RIGHT);
        vector1AccelerationTextField.setText("0");
        vector1AccelerationTextField.setToolTipText("Set the acceleration of the first vector using this text field.");

        vector2Label.setText("Vector 2 (V2)");

        vector2VelocityLabel.setText("Velocity");

        vector2VelocityTextField.setDocument(jTextFieldDocumentListener4);
        vector2VelocityTextField.setHorizontalAlignment(JTextField.RIGHT);
        vector2VelocityTextField.setText("0");
        vector2VelocityTextField.setToolTipText("Set the velocity of the second vector using this text field.");
        
        vector2AccelerationLabel.setText("Acceleration");

        vector2AccelerationTextField.setDocument(jTextFieldDocumentListener3);
        vector2AccelerationTextField.setHorizontalAlignment(JTextField.RIGHT);
        vector2AccelerationTextField.setText("0");
        vector2AccelerationTextField.setToolTipText("Set the acceleration of the second vector using this text field.");

        vector1TimeFrameIntervalLabel.setText("Time Frame Interval (V1)");

        vector2TimeFrameIntervalLabel.setText("Time Frame Interval (V2)");

        vector1TimeFrameIntervalTextField.setDocument(jTextFieldDocumentListener5);
        vector1TimeFrameIntervalTextField.setHorizontalAlignment(JTextField.RIGHT);
        vector1TimeFrameIntervalTextField.setText("0");
        vector1TimeFrameIntervalTextField.setToolTipText("<html>Set how often you want the first vector to be repainted using this text field.<br/>The animation sequence of this vector in relation to the actual panel itself is not completely synchronized.</html>");

        vector2TimeFrameIntervalTextField.setDocument(jTextFieldDocumentListener6);
        vector2TimeFrameIntervalTextField.setHorizontalAlignment(JTextField.RIGHT);
        vector2TimeFrameIntervalTextField.setText("0");
        vector2TimeFrameIntervalTextField.setToolTipText("<html>Set how often you want the second vector to be repainted using this text field.<br/>The animation sequence of this vector in relation to the actual panel itself is not completely synchronized.</html>");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(vector1AccelerationLabel)
                            .addComponent(vector1VelocityLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(vector1VelocityTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vector1AccelerationTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(vector1Label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(vector2Label)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(vector2AccelerationLabel)
                            .addComponent(vector2VelocityLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vector2VelocityTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vector1TimeFrameIntervalLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vector1TimeFrameIntervalTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vector2AccelerationTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vector2TimeFrameIntervalLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vector2TimeFrameIntervalTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(startOrStopToggleButton)
                            .addComponent(resetButton))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(vector1Label)
                    .addComponent(vector2Label))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(vector1VelocityLabel)
                            .addComponent(vector1VelocityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(vector1AccelerationLabel)
                            .addComponent(vector1AccelerationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(vector2VelocityLabel)
                            .addComponent(vector2VelocityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vector1TimeFrameIntervalLabel)
                            .addComponent(vector1TimeFrameIntervalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(vector2AccelerationLabel)
                            .addComponent(vector2AccelerationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vector2TimeFrameIntervalLabel)
                            .addComponent(vector2TimeFrameIntervalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startOrStopToggleButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        
        
        // Setting fonts and action listeners
        for (Component component: getComponents())
        {
        	if (component instanceof AbstractButton || component instanceof JLabel ||
        			 component instanceof JTextField)
        		component.setFont(Application.simulationModeControlPanelFontObject);
        	
        	if (component instanceof JTextField)
        		((JTextField)component).addActionListener(controlPanelActionListener);
        	else if (component instanceof AbstractButton)
        		((AbstractButton)component).addActionListener(controlPanelActionListener);
        }
    }                                                                   
    
}
