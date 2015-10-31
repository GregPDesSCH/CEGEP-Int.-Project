/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 1 Control Panel
 * 
 * This is the control panel for the first simulation in Chapter 2 of
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

import listeners.simulationListeners.documentListeners.*;
import listeners.simulationListeners.actionListeners.Chapter2Simulation1ControlPanelActionListener;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class Chapter2Simulation1ControlPanel extends RawSimulationControlPanel 
{                    
	/*
	 * Panel Components        
	 */
    public static ButtonGroup vectorRadioButtonGroup;
    public static ButtonGroup scalarForVectorsRadioButtonGroup;
    public static ButtonGroup vector1And2RadioButtonGroup;
    
    public static JButton addVectorsButton;
    public static JButton subtractVectorsButton;
    
    public static JLabel scalarOrFactorLabel;
    public static JLabel yWithScalarValueLabel;
    public static JLabel calculatedMagnitudeLabel;
    public static JLabel xPosLabel;
    public static JLabel yPosLabel;
    public static JLabel directionLabel;
    public static JLabel vectorXComponentLabel;
    public static JLabel vectorYComponentLabel;
    public static JLabel magnitudeLabel;
    public static JLabel xWithScalarLabel;
    public static JLabel xWithScalarValueLabel;
    public static JLabel yWithScalarLabel;
    
    public static JRadioButton oneVectorRadioButton;
    public static JRadioButton twoVectorsRadioButton;
    public static JRadioButton multiplyVectorWithScalarRadioButton;
    public static JRadioButton divideVectorWithScalarRadioButton;
    public static JRadioButton vector1RadioButton;
    public static JRadioButton vector2RadioButton;
    
    public static JSeparator jSeparator1;
    
    public static JTextField scalarOrFactorTextField;
    public static JTextField directionTextField;
    public static JTextField vectorXComponentTextField;
    public static JTextField vectorYComponentTextField;
    public static JTextField vectorXCoordinateTextField;
    public static JTextField vectorYCoordinateTextField;
    
    public static JToggleButton unitVectorToggleButton;
    
    // Text Field Listeners
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener1;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener2;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener3;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener4;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener5;
    public static Chapter2SimulationControlPanelDocumentListener1 jTextFieldDocumentListener6;  

    // Action Listeners
    public static Chapter2Simulation1ControlPanelActionListener controlPanelActionListener;
    
    public Chapter2Simulation1ControlPanel()
    {
        initComponents();
    }

                       
    public void initComponents() 
    {
    	// Component Construction
        vectorRadioButtonGroup = new ButtonGroup();
        scalarForVectorsRadioButtonGroup = new ButtonGroup();
        vector1And2RadioButtonGroup = new ButtonGroup();
        
        oneVectorRadioButton = new JRadioButton();
        twoVectorsRadioButton = new JRadioButton();
        multiplyVectorWithScalarRadioButton = new JRadioButton();
        divideVectorWithScalarRadioButton = new JRadioButton();
        
        scalarOrFactorTextField = new JTextField();
        
        scalarOrFactorLabel = new JLabel();
        directionLabel = new JLabel();
        
        directionTextField = new JTextField();
        
        vectorXComponentLabel = new JLabel();
        vectorYComponentLabel = new JLabel();
        
        vectorXComponentTextField = new JTextField();
        vectorYComponentTextField = new JTextField();
        
        magnitudeLabel = new JLabel();
        xWithScalarLabel = new JLabel();
        xWithScalarValueLabel = new JLabel();
        yWithScalarLabel = new JLabel();
        yWithScalarValueLabel = new JLabel();
        xPosLabel = new JLabel();
        yPosLabel = new JLabel();
        
        vectorXCoordinateTextField = new JTextField();
        vectorYCoordinateTextField = new JTextField();
        
        unitVectorToggleButton = new JToggleButton();
        
        addVectorsButton = new JButton();
        subtractVectorsButton = new JButton();
        
        vector1RadioButton = new JRadioButton();
        vector2RadioButton = new JRadioButton();
        
        jSeparator1 = new JSeparator();
        
        calculatedMagnitudeLabel = new JLabel();

        jTextFieldDocumentListener1 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener2 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener3 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener4 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener5 = new Chapter2SimulationControlPanelDocumentListener1();
        jTextFieldDocumentListener6 = new Chapter2SimulationControlPanelDocumentListener1();
        
        
        controlPanelActionListener = new Chapter2Simulation1ControlPanelActionListener();
        
        
        
        
        
        // Button Group Assembly
        vectorRadioButtonGroup.add(oneVectorRadioButton);
        vectorRadioButtonGroup.add(twoVectorsRadioButton);
        
        scalarForVectorsRadioButtonGroup.add(multiplyVectorWithScalarRadioButton);
        scalarForVectorsRadioButtonGroup.add(divideVectorWithScalarRadioButton);
        
        vector1And2RadioButtonGroup.add(vector1RadioButton);
        vector1And2RadioButtonGroup.add(vector2RadioButton);
        
        
        
        
        // Component Initialization
        oneVectorRadioButton.setSelected(true);
        oneVectorRadioButton.setText("One Vector");
        oneVectorRadioButton.setToolTipText("Control one vector.");
       
        twoVectorsRadioButton.setText("Two Vectors");
        twoVectorsRadioButton.setToolTipText("<html>Control two vectors.<br/>Use the two buttons below to select which vector to modify.</html>");
        
        multiplyVectorWithScalarRadioButton.setSelected(true);
        multiplyVectorWithScalarRadioButton.setText("Multiply");
        multiplyVectorWithScalarRadioButton.setToolTipText("<html>Multiply the vector with a scalar.<br/>(must be greater than 1.0 or less than -1.0)</html>");

        divideVectorWithScalarRadioButton.setText("Divide");
        divideVectorWithScalarRadioButton.setToolTipText("<html>Divide a vector by multiplying it with an inverse factor.<br/>(must be greater than 1.0 or less than -1.0)</html>");

        scalarOrFactorTextField.setDocument(jTextFieldDocumentListener1);
        scalarOrFactorTextField.setHorizontalAlignment(JTextField.RIGHT);
        scalarOrFactorTextField.setText("0");
        scalarOrFactorTextField.setToolTipText("Set the scalar, or factor (which is the inverse of the scalar) using this text field.");

        scalarOrFactorLabel.setText("Scalar / Factor");

        directionLabel.setText("Direction");

        directionTextField.setDocument(jTextFieldDocumentListener2);
        directionTextField.setHorizontalAlignment(JTextField.RIGHT);
        directionTextField.setText("0");
        directionTextField.setToolTipText("Use this text field to set the direction (relative to the positive X axis), in degrees.");

        vectorXComponentLabel.setText("X");

        vectorYComponentLabel.setText("Y");

        vectorXComponentTextField.setDocument(jTextFieldDocumentListener3);
        vectorXComponentTextField.setHorizontalAlignment(JTextField.RIGHT);
        vectorXComponentTextField.setText("0");
        vectorXComponentTextField.setToolTipText("Set the X component of the vector using this text field.");

        vectorYComponentTextField.setDocument(jTextFieldDocumentListener4);
        vectorYComponentTextField.setHorizontalAlignment(JTextField.RIGHT);
        vectorYComponentTextField.setText("0");
        vectorYComponentTextField.setToolTipText("Set the Y component of the vector using this text field.");

        magnitudeLabel.setText("Magnitude");

        xWithScalarLabel.setText("X (w/ scalar)");

        xWithScalarValueLabel.setText("N/A");
        xWithScalarValueLabel.setHorizontalAlignment(JLabel.RIGHT);

        yWithScalarLabel.setText("Y (w/ scalar)");

        yWithScalarValueLabel.setText("N/A");
        yWithScalarValueLabel.setHorizontalAlignment(JLabel.RIGHT);

        xPosLabel.setText("X Pos");

        yPosLabel.setText("Y Pos");

        vectorXCoordinateTextField.setDocument(jTextFieldDocumentListener5);
        vectorXCoordinateTextField.setHorizontalAlignment(JTextField.RIGHT);
        vectorXCoordinateTextField.setText("0");
        vectorXCoordinateTextField.setToolTipText("Set the vector's initial X-coordinate using this text label.");

        vectorYCoordinateTextField.setDocument(jTextFieldDocumentListener6);
        vectorYCoordinateTextField.setHorizontalAlignment(JTextField.RIGHT);
        vectorYCoordinateTextField.setText("0");
        vectorYCoordinateTextField.setToolTipText("Set the initial Y-coordinate of the vector using this text field.");

        unitVectorToggleButton.setText("Unit Vector");
        unitVectorToggleButton.setToolTipText("<html>Calculuate and display the unit vector<br/>Opens up a dialog displaying info on the unit vector.</html>");
        unitVectorToggleButton.setMargin(new java.awt.Insets(0, 10, 0, 10));

        addVectorsButton.setText("Add Vectors");
        addVectorsButton.setEnabled(false);

        subtractVectorsButton.setText("Subtract Vectors");
        subtractVectorsButton.setEnabled(false);
        
        vector1RadioButton.setSelected(true);
        vector1RadioButton.setText("Vector 1");
        vector1RadioButton.setEnabled(false);

        vector2RadioButton.setText("Vector 2");
        vector2RadioButton.setEnabled(false);

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        calculatedMagnitudeLabel.setText("N/A");
        calculatedMagnitudeLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        
        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(oneVectorRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(directionLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(directionTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(magnitudeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calculatedMagnitudeLabel, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(xWithScalarLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xWithScalarValueLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yWithScalarLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yWithScalarValueLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unitVectorToggleButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vectorXComponentLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vectorXComponentTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xPosLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vectorYComponentLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vectorYComponentTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yPosLabel)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(vectorXCoordinateTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vectorYCoordinateTextField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(divideVectorWithScalarRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scalarOrFactorTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(multiplyVectorWithScalarRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scalarOrFactorLabel)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(twoVectorsRadioButton)
                        .addGap(144, 144, 144))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(vector1RadioButton)
                            .addComponent(vector2RadioButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(subtractVectorsButton)
                            .addComponent(addVectorsButton))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(oneVectorRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(twoVectorsRadioButton)
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(vectorXComponentLabel)
                                    .addComponent(vectorXComponentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(xPosLabel)
                                    .addComponent(vectorXCoordinateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(vectorYComponentLabel)
                                    .addComponent(vectorYComponentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yPosLabel)
                                    .addComponent(vectorYCoordinateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(directionLabel)
                                    .addComponent(directionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(magnitudeLabel)
                                    .addComponent(unitVectorToggleButton)
                                    .addComponent(calculatedMagnitudeLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(multiplyVectorWithScalarRadioButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scalarOrFactorLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(divideVectorWithScalarRadioButton, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scalarOrFactorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(addVectorsButton)
                            .addComponent(vector1RadioButton))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(subtractVectorsButton))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vector2RadioButton)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(xWithScalarLabel)
                    .addComponent(xWithScalarValueLabel)
                    .addComponent(yWithScalarLabel)
                    .addComponent(yWithScalarValueLabel))
                .addGap(6, 6, 6))
            .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
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
