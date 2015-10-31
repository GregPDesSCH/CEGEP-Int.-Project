/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 6 Control Panel
 * 
 * This is the control panel for the sixth simulation in Chapter 2 of
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
import listeners.simulationListeners.documentListeners.*;
import listeners.simulationListeners.actionListeners.Chapter2Simulation6ControlPanelActionListener;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class Chapter2Simulation6ControlPanel extends RawSimulationControlPanel
{            
	/*
	 * Panel Components        
	 */
    public static JButton resetButton;
    
    public static JLabel radiusLabel;
    public static JLabel tangentialVelocityLabel;
    public static JLabel instantaneousRadialAccelerationLabel;
    public static JLabel tangentialAccelerationLabel;
    public static JLabel calculatedInstantaneousRadialAccelerationLabel;
    public static JLabel averageRadialAccelerationLabel;
    public static JLabel calculatedAverageRadialAccelerationLabel;
    
    public static JTextField radiusTextField;
    public static JTextField tangentialVelocityTextField;
    public static JTextField tangentialAccelerationTextField;
    
    public static JToggleButton startOrStopToggleButton;
    
    // Text Field Document Listeners
    public static Chapter2SimulationControlPanelDocumentListener2 jTextFieldDocumentListener1;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener2;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener3;

    // Action Listeners
    public static Chapter2Simulation6ControlPanelActionListener controlPanelActionListener;
    
    public Chapter2Simulation6ControlPanel() 
    {
        initComponents();
    }
                         
    public void initComponents() 
    {
    	// Component Construction
        radiusLabel = new JLabel();
        
        radiusTextField = new JTextField();
        
        tangentialVelocityLabel = new JLabel();
        
        tangentialVelocityTextField = new JTextField();
        
        startOrStopToggleButton = new JToggleButton();
        
        resetButton = new JButton();
        
        instantaneousRadialAccelerationLabel = new JLabel();
        tangentialAccelerationLabel = new JLabel();
        
        tangentialAccelerationTextField = new JTextField();
        
        calculatedInstantaneousRadialAccelerationLabel = new JLabel();
        averageRadialAccelerationLabel = new JLabel();
        calculatedAverageRadialAccelerationLabel = new JLabel();
        
        jTextFieldDocumentListener1 = new Chapter2SimulationControlPanelDocumentListener2();
        jTextFieldDocumentListener2 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener3 = new Chapter2SimulationControlPanelDocumentListener1();
        
        controlPanelActionListener = new Chapter2Simulation6ControlPanelActionListener();
        
        
        

        // Component Initialization
        radiusLabel.setText("Radius:");

        radiusTextField.setDocument(jTextFieldDocumentListener1);
        radiusTextField.setHorizontalAlignment(JTextField.RIGHT);
        radiusTextField.setText("125.0");
        radiusTextField.setToolTipText("Set the radius of the centripetal motion using this text field.");

        tangentialVelocityLabel.setText("Tangential Velocity:");

        tangentialVelocityTextField.setDocument(jTextFieldDocumentListener2);
        tangentialVelocityTextField.setHorizontalAlignment(JTextField.RIGHT);
        tangentialVelocityTextField.setText("10.0");
        tangentialVelocityTextField.setToolTipText("Set the tangential velocity of the discus, in centripetal motion, using this text field.");

        startOrStopToggleButton.setText("Start");

        resetButton.setText("Reset");
        resetButton.setEnabled(false);

        instantaneousRadialAccelerationLabel.setText("Inst. Radial Acceleration:");

        tangentialAccelerationLabel.setText("Tangential Acceleration:");

        tangentialAccelerationTextField.setDocument(jTextFieldDocumentListener3);
        tangentialAccelerationTextField.setHorizontalAlignment(JTextField.RIGHT);
        tangentialAccelerationTextField.setText("0.0");
        tangentialAccelerationTextField.setToolTipText("Set the tangential acceleration of the discus, in centripetal motion, using this text field.");

        calculatedInstantaneousRadialAccelerationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        calculatedInstantaneousRadialAccelerationLabel.setText("N/A");

        averageRadialAccelerationLabel.setText("Avg. Radial Acceleration:");

        calculatedAverageRadialAccelerationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        calculatedAverageRadialAccelerationLabel.setText("N/A");

        
        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(radiusLabel)
                    .addComponent(tangentialVelocityLabel)
                    .addComponent(tangentialAccelerationLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(tangentialAccelerationTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tangentialVelocityTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                    .addComponent(radiusTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(instantaneousRadialAccelerationLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(averageRadialAccelerationLabel)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(calculatedAverageRadialAccelerationLabel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(calculatedInstantaneousRadialAccelerationLabel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(startOrStopToggleButton)
                    .addComponent(resetButton))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(radiusLabel)
                            .addComponent(radiusTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(tangentialVelocityLabel)
                            .addComponent(tangentialVelocityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(instantaneousRadialAccelerationLabel)
                            .addComponent(calculatedInstantaneousRadialAccelerationLabel)))
                    .addComponent(startOrStopToggleButton, GroupLayout.Alignment.TRAILING))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tangentialAccelerationLabel)
                        .addComponent(tangentialAccelerationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(averageRadialAccelerationLabel)
                        .addComponent(calculatedAverageRadialAccelerationLabel)
                        .addComponent(resetButton)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        
        
        
        // Setting fonts and action listeners
        for (Component component: getComponents())
        {
        	if (component instanceof AbstractButton || component instanceof JLabel ||
        			component instanceof JTextField)
        		component.setFont(Application.simulationModeControlPanelFontObject);
        	
        	if (component instanceof AbstractButton)
        		((AbstractButton)component).addActionListener(controlPanelActionListener);
        	
        	if (component instanceof JTextField)
        		((JTextField)component).addActionListener(controlPanelActionListener);
        }
    }                      
   
}
