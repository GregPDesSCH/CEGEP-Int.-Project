/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 4 Control Panel
 * 
 * This is the control panel for the fourth simulation in Chapter 2 of
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

// Resource Packages and Classes
import java.awt.Component;
import javax.swing.*;
import listeners.simulationListeners.actionListeners.Chapter2Simulation4ControlPanelActionListener;
import listeners.simulationListeners.documentListeners.*;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class Chapter2Simulation4ControlPanel extends RawSimulationControlPanel
{         
	/*
	 * Panel Components        
	 */
    public static JButton resetButton;
    
    public static JLabel displacementVectorLabel;
    public static JLabel timeIntervalForPointRecordingLabel;
    public static JLabel secondsLabel;
    public static JLabel displacementVectorXComponentLabel;
    public static JLabel displacementVectorYComponentLabel;
    public static JLabel velocityVectorLabel;
    public static JLabel velocityVectorXComponentLabel;
    public static JLabel velocityVectorYComponentLabel;
    public static JLabel accelerationVectorLabel;
    public static JLabel accelerationVectorXComponentLabel;
    public static JLabel accelerationVectorYComponentLabel;
    
    public static JTextField displacementVectorXComponentTextField;
    public static JTextField displacementVectorYComponentTextField;
    public static JTextField velocityVectorXComponentTextField;
    public static JTextField velocityVectorYComponentTextField;
    public static JTextField accelerationVectorYComponentTextField;
    public static JTextField accelerationVectorXComponentTextField;
    public static JTextField timeIntervalForPointRecordingTextField;
    
    public static JToggleButton startOrStopToggleButton;
    public static JToggleButton drawTrajectoryToggleButton;
    
    // Text Field Document Listeners
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener1;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener2;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener3;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener4;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener5;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener6;
    
    public static Chapter2SimulationControlPanelDocumentListener2 jTextFieldDocumentListener7;
	
    // Action Listener
    public static Chapter2Simulation4ControlPanelActionListener controlPanelActionListener;
    

    public Chapter2Simulation4ControlPanel() 
    {
        initComponents();
    }
                      
    public void initComponents() 
    {
    	// Component Construction
        displacementVectorLabel = new JLabel();
        displacementVectorXComponentLabel = new JLabel();
        displacementVectorYComponentLabel = new JLabel();
        
        displacementVectorXComponentTextField = new JTextField();
        displacementVectorYComponentTextField = new JTextField();
        
        velocityVectorLabel = new JLabel();
        velocityVectorXComponentLabel = new JLabel();
        velocityVectorYComponentLabel = new JLabel();
        
        velocityVectorXComponentTextField = new JTextField();
        velocityVectorYComponentTextField = new JTextField();
        
        accelerationVectorLabel = new JLabel();
        accelerationVectorXComponentLabel = new JLabel();
        accelerationVectorYComponentLabel = new JLabel();
        
        accelerationVectorYComponentTextField = new JTextField();
        accelerationVectorXComponentTextField = new JTextField();
        
        timeIntervalForPointRecordingLabel = new JLabel();
        
        timeIntervalForPointRecordingTextField = new JTextField();
        
        secondsLabel = new JLabel();
        
        startOrStopToggleButton = new JToggleButton();
        
        resetButton = new JButton();
        
        drawTrajectoryToggleButton = new JToggleButton();
        
        jTextFieldDocumentListener1 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener2 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener3 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener4 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener5 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener6 = new Chapter2SimulationControlPanelDocumentListener1();
        
        jTextFieldDocumentListener7 = new Chapter2SimulationControlPanelDocumentListener2();
        
        controlPanelActionListener = new Chapter2Simulation4ControlPanelActionListener();
        
        
        
        
        
        // Component Initialization
        displacementVectorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        displacementVectorLabel.setText("<html><div style=\"text-align:center\">Displacement<br/>Vector</div></html>");

        displacementVectorXComponentLabel.setText("X");

        displacementVectorYComponentLabel.setText("Y");

        displacementVectorXComponentTextField.setDocument(jTextFieldDocumentListener1);
        displacementVectorXComponentTextField.setHorizontalAlignment(JTextField.RIGHT);
        displacementVectorXComponentTextField.setText("0");
        displacementVectorXComponentTextField.setToolTipText("<html>Set the X component of the displacement vector using this text field.<br/><br/>This is the ball's initial X position.</html>");

        displacementVectorYComponentTextField.setDocument(jTextFieldDocumentListener2);
        displacementVectorYComponentTextField.setHorizontalAlignment(JTextField.RIGHT);
        displacementVectorYComponentTextField.setText("0");
        displacementVectorYComponentTextField.setToolTipText("<html>Set the Y component of the displacement vector using this text field.<br/><br/>This is the ball's initial Y position.</html>");

        velocityVectorLabel.setText("Velocity Vector");

        velocityVectorXComponentLabel.setText("<html>v<sub>x</sub></html>");

        velocityVectorYComponentLabel.setText("<html>v<sub>y</sub></html>");

        velocityVectorXComponentTextField.setDocument(jTextFieldDocumentListener3);
        velocityVectorXComponentTextField.setHorizontalAlignment(JTextField.RIGHT);
        velocityVectorXComponentTextField.setText("0");
        velocityVectorXComponentTextField.setToolTipText("<html>Set the initial X velocity of the velocity vector using this text field.<br/><br/>This is the ball's initial X velocity.</html>");

        velocityVectorYComponentTextField.setDocument(jTextFieldDocumentListener4);
        velocityVectorYComponentTextField.setHorizontalAlignment(JTextField.RIGHT);
        velocityVectorYComponentTextField.setText("0");
        velocityVectorYComponentTextField.setToolTipText("<html>Set the initial Y velocity of the velocity vector using this text field.<br/><br/>This is the ball's initial Y velocity.</html>");

        accelerationVectorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        accelerationVectorLabel.setText("<html><div style=\"text-align:center\">Acceleration<br/>Vector</div></html>");

        accelerationVectorXComponentLabel.setText("<html>a<sub>x</sub></html>");

        accelerationVectorYComponentLabel.setText("<html>a<sub>y</sub></html>");

        accelerationVectorYComponentTextField.setDocument(jTextFieldDocumentListener5);
        accelerationVectorYComponentTextField.setHorizontalAlignment(JTextField.RIGHT);
        accelerationVectorYComponentTextField.setText("0");
        accelerationVectorYComponentTextField.setToolTipText("<html>Set the Y acceleration of the acceleration vector using this text field.<br/><br/>This is the ball's Y acceleration.</html>");

        accelerationVectorXComponentTextField.setDocument(jTextFieldDocumentListener6);
        accelerationVectorXComponentTextField.setHorizontalAlignment(JTextField.RIGHT);
        accelerationVectorXComponentTextField.setText("0");
        accelerationVectorXComponentTextField.setToolTipText("<html>Set the X component of the acceleration vector using this text field.<br/><br/>This is the ball's X acceleration.</html>");

        timeIntervalForPointRecordingLabel.setText("Time Interval for Point Recording");

        timeIntervalForPointRecordingTextField.setDocument(jTextFieldDocumentListener7);
        timeIntervalForPointRecordingTextField.setHorizontalAlignment(JTextField.RIGHT);
        timeIntervalForPointRecordingTextField.setText("0");
        timeIntervalForPointRecordingTextField.setToolTipText("<html>Set how often you want the program to record a point<br/> of the ball's movement using this text field.</html>");

        secondsLabel.setText("sec.");

        startOrStopToggleButton.setText("Start");

        resetButton.setText("Reset");
        resetButton.setEnabled(false);

        drawTrajectoryToggleButton.setText("Draw Trajectory");
        drawTrajectoryToggleButton.setToolTipText("Toggle to draw a rough trajectory of the ball using the points recorded.");

        
        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displacementVectorXComponentLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displacementVectorXComponentTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displacementVectorYComponentLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displacementVectorYComponentTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addComponent(displacementVectorLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(velocityVectorLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(velocityVectorXComponentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(velocityVectorYComponentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(velocityVectorYComponentTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(velocityVectorXComponentTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(accelerationVectorLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(accelerationVectorXComponentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(accelerationVectorYComponentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(accelerationVectorYComponentTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(accelerationVectorXComponentTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeIntervalForPointRecordingLabel)
                        .addGap(18, 18, 18)
                        .addComponent(timeIntervalForPointRecordingTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondsLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startOrStopToggleButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawTrajectoryToggleButton)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(velocityVectorXComponentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(velocityVectorXComponentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(velocityVectorYComponentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(velocityVectorYComponentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(displacementVectorLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addComponent(velocityVectorLabel)
                            .addComponent(accelerationVectorLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeIntervalForPointRecordingLabel)
                            .addComponent(timeIntervalForPointRecordingTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondsLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(displacementVectorXComponentLabel)
                                    .addComponent(displacementVectorXComponentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(displacementVectorYComponentLabel)
                                    .addComponent(displacementVectorYComponentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(accelerationVectorXComponentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accelerationVectorXComponentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(startOrStopToggleButton)
                                    .addComponent(resetButton)
                                    .addComponent(drawTrajectoryToggleButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(accelerationVectorYComponentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accelerationVectorYComponentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        
        
        
        
        // Setting fonts and action listeners
        for (Component component: getComponents())
        {
        	if (component instanceof AbstractButton || component instanceof JLabel ||
        			component instanceof JTextField)
        		component.setFont(Application.simulationModeControlPanelFontObject);
        	
        	if (component instanceof AbstractButton)
        		((AbstractButton)component).addActionListener(controlPanelActionListener);
        	else if (component instanceof JTextField)
        		((JTextField)component).addActionListener(controlPanelActionListener);
        }
    }                      
}
