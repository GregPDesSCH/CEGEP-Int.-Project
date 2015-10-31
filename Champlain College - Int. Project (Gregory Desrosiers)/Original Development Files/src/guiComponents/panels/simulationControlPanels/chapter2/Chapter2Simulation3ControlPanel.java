/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 3 Control Panel
 * 
 * This is the control panel for the third simulation in Chapter 2 of
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

// Resource Classes and Package
import javax.swing.*;
import java.awt.Component;
import listeners.simulationListeners.actionListeners.Chapter2Simulation3ControlPanelActionListener;
import listeners.simulationListeners.documentListeners.Chapter2SimulationControlPanelDocumentListener1;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class Chapter2Simulation3ControlPanel extends RawSimulationControlPanel
{              
	/*
	 * Panel Components        
	 */
    public static ButtonGroup car1StartRadioButtonGroup;
    public static ButtonGroup car2StartRadioButtonGroup;
    
    public static JLabel car1Label;
    public static JLabel car2AccelerationLabel;
    public static JLabel instantaneousRelativeVelocityLabel;
    public static JLabel calculatedInstantaneousRelativeVelocityLabel;
    public static JLabel car1StartPositionLabel;
    public static JLabel car1VelocityLabel;
    public static JLabel car2VelocityLabel;
    public static JLabel car2StartPositionLabel;
    public static JLabel car2Label;
    public static JLabel averageRelativeVelocityLabel;
    public static JLabel calculatedAverageRelativeVelocityLabel;
    public static JLabel car1AccelerationLabel;
    
    public static JRadioButton car1StartLeftRadioButton;
    public static JRadioButton car1StartRightRadioButton;
    public static JRadioButton car2StartLeftRadioButton;
    public static JRadioButton car2StartRightRadioButton;
    
    public static JSeparator separatorBar;
    
    public static JTextField car1InitialVelocityTextField;
    public static JTextField car2InitialVelocityTextField;
    public static JTextField car1AccelerationTextField;
    public static JTextField car2AccelerationTextField;
    
    public static JToggleButton startOrStopToggleButton;
    
    public static JButton resetButton;
    
    // Text Field Document Listeners
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener1;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener2;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener3;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener4;
    
    // Action Listener
    public static Chapter2Simulation3ControlPanelActionListener controlPanelActionListener;
    
    public Chapter2Simulation3ControlPanel() 
    {
        initComponents();
    }
                      
    public void initComponents() 
    {
    	// Component Construction
        car1StartRadioButtonGroup = new ButtonGroup();
        car2StartRadioButtonGroup = new ButtonGroup();
        
        car1Label = new JLabel();
        car1StartPositionLabel = new JLabel();
        
        car1StartLeftRadioButton = new JRadioButton();
        car1StartRightRadioButton = new JRadioButton();
        
        car1VelocityLabel = new JLabel();
        
        car1InitialVelocityTextField = new JTextField();
        
        car2VelocityLabel = new JLabel();
        
        car2InitialVelocityTextField = new JTextField();
        
        car2StartPositionLabel = new JLabel();
        
        car2StartLeftRadioButton = new JRadioButton();
        car2StartRightRadioButton = new JRadioButton();
        
        car2Label = new JLabel();
        
        startOrStopToggleButton = new JToggleButton();
        
        resetButton = new JButton();
        
        averageRelativeVelocityLabel = new JLabel();
        calculatedAverageRelativeVelocityLabel = new JLabel();
        car1AccelerationLabel = new JLabel();
        
        car1AccelerationTextField = new JTextField();
        
        car2AccelerationLabel = new JLabel();
        
        car2AccelerationTextField = new JTextField();
        
        instantaneousRelativeVelocityLabel = new JLabel();
        calculatedInstantaneousRelativeVelocityLabel = new JLabel();
        
        separatorBar = new JSeparator();
        
        jTextFieldDocumentListener1 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener2 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener3 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener4 = new Chapter2SimulationControlPanelDocumentListener1();
        
        controlPanelActionListener = new Chapter2Simulation3ControlPanelActionListener();
        
        
        
        
        
        // Button Group Assembly
        car1StartRadioButtonGroup.add(car1StartLeftRadioButton);
        car1StartRadioButtonGroup.add(car1StartRightRadioButton);
        
        car2StartRadioButtonGroup.add(car2StartLeftRadioButton);
        car2StartRadioButtonGroup.add(car2StartRightRadioButton);

        
        
        
        
        // Component Initialization
        car1Label.setText("Car 1");

        car1StartPositionLabel.setText("Start Pos.");

        car1StartLeftRadioButton.setSelected(true);
        car1StartLeftRadioButton.setText("Left");

        car1StartRightRadioButton.setText("Right");

        car1VelocityLabel.setText("Velocity:");

        car1InitialVelocityTextField.setDocument(jTextFieldDocumentListener1);
        car1InitialVelocityTextField.setHorizontalAlignment(JTextField.RIGHT);
        car1InitialVelocityTextField.setText("0");
        car1InitialVelocityTextField.setToolTipText("Set the initial velocity of the first car using this text field.");

        car2VelocityLabel.setText("Velocity:");

        car2InitialVelocityTextField.setDocument(jTextFieldDocumentListener2);
        car2InitialVelocityTextField.setHorizontalAlignment(JTextField.RIGHT);
        car2InitialVelocityTextField.setText("0");
        car2InitialVelocityTextField.setToolTipText("Set the initial velocity of the second car using this text field.");

        car2StartPositionLabel.setText("Start Pos.");

        car2StartLeftRadioButton.setSelected(true);
        car2StartLeftRadioButton.setText("Left");

        car2StartRightRadioButton.setText("Right");

        car2Label.setText("Car 2");

        startOrStopToggleButton.setText("Start");

        resetButton.setText("Reset");
        resetButton.setEnabled(false);

        averageRelativeVelocityLabel.setText("Avg. Relative Velocity:");

        calculatedAverageRelativeVelocityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        calculatedAverageRelativeVelocityLabel.setText("N/A");

        car1AccelerationLabel.setText("Acceleration:");

        car1AccelerationTextField.setDocument(jTextFieldDocumentListener3);
        car1AccelerationTextField.setHorizontalAlignment(JTextField.RIGHT);
        car1AccelerationTextField.setText("0");
        car1AccelerationTextField.setToolTipText("Set the acceleration of the first car using this text field.");

        car2AccelerationLabel.setText("Acceleration:");

        car2AccelerationTextField.setDocument(jTextFieldDocumentListener4);
        car2AccelerationTextField.setHorizontalAlignment(JTextField.RIGHT);
        car2AccelerationTextField.setText("0");
        car2AccelerationTextField.setToolTipText("Set the acceleration of the second car using this text field.");

        instantaneousRelativeVelocityLabel.setText("Inst. Relative Velocity:");

        calculatedInstantaneousRelativeVelocityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        calculatedInstantaneousRelativeVelocityLabel.setText("N/A");

        separatorBar.setOrientation(SwingConstants.VERTICAL);

        
        
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
                            .addComponent(car1Label)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(car1StartPositionLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(car1StartLeftRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(car1StartRightRadioButton))
                            .addComponent(car1VelocityLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(car2AccelerationLabel)
                                    .addComponent(car2VelocityLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(car2InitialVelocityTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(car2AccelerationTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(car2StartPositionLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(car2StartLeftRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(car2StartRightRadioButton))
                            .addComponent(car2Label)))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(car1InitialVelocityTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(car1AccelerationLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(car1AccelerationTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(startOrStopToggleButton)
                    .addComponent(resetButton))
                .addGap(29, 29, 29)
                .addComponent(separatorBar, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(averageRelativeVelocityLabel)
                            .addComponent(calculatedAverageRelativeVelocityLabel, GroupLayout.Alignment.TRAILING))
                        .addComponent(instantaneousRelativeVelocityLabel))
                    .addComponent(calculatedInstantaneousRelativeVelocityLabel, GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separatorBar, GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(car1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(car1StartPositionLabel)
                                    .addComponent(car1StartLeftRadioButton)
                                    .addComponent(car1StartRightRadioButton)
                                    .addComponent(car2StartPositionLabel)
                                    .addComponent(car2StartLeftRadioButton)
                                    .addComponent(car2StartRightRadioButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(car1VelocityLabel)
                                    .addComponent(car1InitialVelocityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(car2VelocityLabel)
                                    .addComponent(car2InitialVelocityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(car1AccelerationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(car1AccelerationLabel))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(car2AccelerationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(car2AccelerationLabel))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(car2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startOrStopToggleButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resetButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(calculatedInstantaneousRelativeVelocityLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(averageRelativeVelocityLabel)
                                .addGap(3, 3, 3)
                                .addComponent(calculatedAverageRelativeVelocityLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(instantaneousRelativeVelocityLabel)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        
        
        
        
        // Setting fonts and action listeners
        for (Component component: getComponents())
        {
        	if (component instanceof AbstractButton || component instanceof JLabel ||
        			component instanceof JTextField	)
        		component.setFont(Application.simulationModeControlPanelFontObject);
        	
        	if (component instanceof JTextField)
        		((JTextField)component).addActionListener(controlPanelActionListener);
        	else if (component instanceof AbstractButton)
        		((AbstractButton)component).addActionListener(controlPanelActionListener);
        }
    }             
}
