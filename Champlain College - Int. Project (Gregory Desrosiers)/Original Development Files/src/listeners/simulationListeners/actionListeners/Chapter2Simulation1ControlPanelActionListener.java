/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 1 Control Panel Action Listener
 * 
 * This listener responds to components for the control panel of the
 * first simulation of Chapter 2.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 26, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * UPDATE (May 19, 2014) - Dialog Message fixed for Vector Subtraction.
 * UPDATE (May 20, 2014) - The constants declared in the Simulation class 
 * have their names changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package listeners.simulationListeners.actionListeners;

// Resource Classes and Packages
import guiComponents.panels.simulationControlPanels.chapter2.Chapter2Simulation1ControlPanel;

import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;

// Interaction Classes
import programCore.*;
import programTopicComponents.simulations.Simulation;
import programTopicComponents.simulations.chapter2.Chapter2Simulation1;

public class Chapter2Simulation1ControlPanelActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		
		if (Chapter2Simulation1.vectorSubtraction)
			Chapter2Simulation1.vectorSubtraction = false;
		
		if (e.getSource() == Chapter2Simulation1ControlPanel.oneVectorRadioButton)
		{
			Chapter2Simulation1ControlPanel.vector1RadioButton.setEnabled(false);
			Chapter2Simulation1ControlPanel.vector2RadioButton.setEnabled(false);
			Chapter2Simulation1ControlPanel.addVectorsButton.setEnabled(false);
			Chapter2Simulation1ControlPanel.subtractVectorsButton.setEnabled(false);
			
			if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
				setControlPanelForVector1();
		}
		
		else if (e.getSource() == Chapter2Simulation1ControlPanel.twoVectorsRadioButton)
		{
			Chapter2Simulation1ControlPanel.vector1RadioButton.setEnabled(true);
			Chapter2Simulation1ControlPanel.vector2RadioButton.setEnabled(true);
			Chapter2Simulation1ControlPanel.addVectorsButton.setEnabled(true);
			Chapter2Simulation1ControlPanel.subtractVectorsButton.setEnabled(true);
			
			if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
				setControlPanelForVector2();
		}
		
		else if (e.getSource() == Chapter2Simulation1ControlPanel.vectorXComponentTextField || 
				e.getSource() == Chapter2Simulation1ControlPanel.vectorXCoordinateTextField ||
				e.getSource() == Chapter2Simulation1ControlPanel.vectorYComponentTextField ||
				e.getSource() == Chapter2Simulation1ControlPanel.vectorYCoordinateTextField ||
				e.getSource() == Chapter2Simulation1ControlPanel.scalarOrFactorTextField)
			setVectorEntries();
		
		else if (e.getSource() == Chapter2Simulation1ControlPanel.directionTextField)
		{
			if (!directionEntryAccept())
				return;
			
			double directionEntry = Double.parseDouble(Chapter2Simulation1ControlPanel.directionTextField.getText());
			
			if (Chapter2Simulation1ControlPanel.vector1RadioButton.isSelected() ||
					Chapter2Simulation1ControlPanel.oneVectorRadioButton.isSelected())
				Chapter2Simulation1.firstVector.setDirection(Math.toRadians(directionEntry));
			
			else if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
				Chapter2Simulation1.secondVector.setDirection(Math.toRadians(directionEntry));
		}
		
		
		else if (e.getSource() == Chapter2Simulation1ControlPanel.unitVectorToggleButton)
		{
			if (Chapter2Simulation1ControlPanel.unitVectorToggleButton.isSelected())
			{
				if (Chapter2Simulation1ControlPanel.oneVectorRadioButton.isSelected() ||
						Chapter2Simulation1ControlPanel.vector1RadioButton.isSelected())
					Chapter2Simulation1.firstVectorUnitVectorOn = true;
				else if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
					Chapter2Simulation1.secondVectorUnitVectorOn = true;
			}
			else
			{
				if (Chapter2Simulation1ControlPanel.oneVectorRadioButton.isSelected() ||
						Chapter2Simulation1ControlPanel.vector1RadioButton.isSelected())
					Chapter2Simulation1.firstVectorUnitVectorOn = false;
				else if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
					Chapter2Simulation1.secondVectorUnitVectorOn = false;
			}
		}
		
		else if (e.getSource() == Chapter2Simulation1ControlPanel.addVectorsButton)
		{
			if (Chapter2Simulation1.vectorSubtraction)
				Chapter2Simulation1.vectorSubtraction = false;
			
			double widthOfVectorSumRectangle = 
					Chapter2Simulation1.firstVector.getXComponent() * Chapter2Simulation1.firstVectorMultiple +
					Chapter2Simulation1.secondVector.getXComponent()* Chapter2Simulation1.secondVectorMultiple;
			
			double heightOfVectorSumRectangle = 
					Chapter2Simulation1.firstVector.getYComponent() * Chapter2Simulation1.firstVectorMultiple +
					Chapter2Simulation1.secondVector.getYComponent() * Chapter2Simulation1.secondVectorMultiple;
			
			if (Chapter2Simulation1.firstVector.getYComponent() * Chapter2Simulation1.firstVectorMultiple >= 
					Chapter2Simulation1.secondVector.getYComponent() * Chapter2Simulation1.secondVectorMultiple)
			{
				Chapter2Simulation1.firstVectorInitialPoint.
						setLocation(Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X - widthOfVectorSumRectangle / 2,
								Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y + heightOfVectorSumRectangle / 2);
				Chapter2Simulation1.secondVectorInitialPoint.
						setLocation(Chapter2Simulation1.firstVectorInitialPoint.x + (Chapter2Simulation1.firstVector.getXComponent()
								* Chapter2Simulation1.firstVectorMultiple), 
								Chapter2Simulation1.firstVectorInitialPoint.y - (Chapter2Simulation1.firstVector.getYComponent() *
										Chapter2Simulation1.firstVectorMultiple));
			}
			else
			{
				Chapter2Simulation1.secondVectorInitialPoint.
						setLocation(Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X - widthOfVectorSumRectangle / 2,
								Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y + heightOfVectorSumRectangle / 2);
				Chapter2Simulation1.firstVectorInitialPoint.
						setLocation(Chapter2Simulation1.secondVectorInitialPoint.x + (Chapter2Simulation1.secondVector.getXComponent()
								* Chapter2Simulation1.secondVectorMultiple), 
								Chapter2Simulation1.secondVectorInitialPoint.y - (Chapter2Simulation1.secondVector.getYComponent() *
										Chapter2Simulation1.secondVectorMultiple));
			}
			
			if (Chapter2Simulation1ControlPanel.vector1RadioButton.isSelected())
				setControlPanelForVector1();
			else if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
				setControlPanelForVector2();
		}
		
		else if (e.getSource() == Chapter2Simulation1ControlPanel.subtractVectorsButton)
		{
			int selectedOption = JOptionPane.showOptionDialog(null, "How would you like to do the operation?", "Vector Subtraction", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					new Object[]{"v1 - v2", "v2 - v1", "Cancel"}, null);
			if (selectedOption == 0)
				Chapter2Simulation1.secondVectorInitialPoint.setLocation(Chapter2Simulation1.firstVectorInitialPoint.x + 
						(Chapter2Simulation1.firstVector.getXComponent() * Chapter2Simulation1.firstVectorMultiple),
						Chapter2Simulation1.firstVectorInitialPoint.y - 
						(Chapter2Simulation1.firstVector.getYComponent() * Chapter2Simulation1.firstVectorMultiple));
			else if (selectedOption == 1)
				Chapter2Simulation1.firstVectorInitialPoint.setLocation(Chapter2Simulation1.secondVectorInitialPoint.x + 
						(Chapter2Simulation1.secondVector.getXComponent() * Chapter2Simulation1.secondVectorMultiple),
						Chapter2Simulation1.secondVectorInitialPoint.y -
						(Chapter2Simulation1.secondVector.getYComponent() * Chapter2Simulation1.secondVectorMultiple));
			else if (selectedOption == 2)
				return;
			
			if (!Chapter2Simulation1.vectorSubtraction)
				Chapter2Simulation1.vectorSubtraction = true;
			
			Chapter2Simulation1.subtractionType = selectedOption;
			
			if (Chapter2Simulation1ControlPanel.vector1RadioButton.isSelected())
				setControlPanelForVector1();
			else if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
				setControlPanelForVector2();
		}
		
		else if (e.getSource() == Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton ||
				e.getSource() == Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton)
		{
			if (Chapter2Simulation1ControlPanel.vector1RadioButton.isSelected() ||
					Chapter2Simulation1ControlPanel.oneVectorRadioButton.isSelected())
			{
				Chapter2Simulation1.firstVectorMultiple = 1.0f / Chapter2Simulation1.firstVectorMultiple;
				
				if (Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.isSelected())
					Chapter2Simulation1.firstVectorInMultiplicationMode = true;
				else if (Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.isSelected())
					Chapter2Simulation1.firstVectorInMultiplicationMode = false;
			}
			else if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
			{
				Chapter2Simulation1.secondVectorMultiple = 1.0f / Chapter2Simulation1.firstVectorMultiple;

				if (Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.isSelected())
					Chapter2Simulation1.secondVectorInMultiplicationMode = true;
				else if (Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.isSelected())
					Chapter2Simulation1.secondVectorInMultiplicationMode = false;
			}
		}
		else if (e.getSource() == Chapter2Simulation1ControlPanel.vector1RadioButton ||
				(e.getSource() == Chapter2Simulation1ControlPanel.oneVectorRadioButton && 
				Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected()))
			setControlPanelForVector1();
		else if (e.getSource() == Chapter2Simulation1ControlPanel.vector2RadioButton)
			setControlPanelForVector2();
	
		if (Chapter2Simulation1ControlPanel.vector1RadioButton.isSelected() ||
				Chapter2Simulation1ControlPanel.oneVectorRadioButton.isSelected())
			setControlPanelForVector1();
		else if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
			setControlPanelForVector2();
		
		Application.simulationPanel.simulationViewingPanel.repaint();
	}
	
	
	
	private boolean checkForEmptyEntries()
	{
		byte numberOfEmptyEntries = 0;
		
		for (Component component : Application.chapter2Simulation1ControlPanel.getComponents())
		{
			if (component instanceof JTextField && component != Chapter2Simulation1ControlPanel.directionTextField)
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
	
	private boolean checkForEntryErrors(float vectorXComponentEntry, float vectorXCoordinateEntry, float vectorYComponentEntry,
		float vectorYCoordinateEntry, float scalarOrFactor)
	{
		if (checkForEmptyEntries())
			return true;
		
		
		
		
		if (vectorXComponentEntry > 10000 || vectorXComponentEntry < -10000)
		{
			Application.dialogLabel.setText(DialogLabelText.vectorXComponentTooBigMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Component Too Big",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		
		
		
		
		
		
		if (vectorXCoordinateEntry < Simulation.MIN_X)
		{
			Application.dialogLabel.setText(DialogLabelText.vectorXCoordinateOutOfRangeLeftSideMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Coordinate Out of Range",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		else if (vectorXCoordinateEntry > Simulation.MAX_X)
		{
			Application.dialogLabel.setText(DialogLabelText.vectorXCoordinateOutOfRangeRightSideMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - X Coordinate Out of Range",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		
		
		
		
		
		
		if (vectorYComponentEntry > 10000 || vectorYComponentEntry < -10000)
		{
			Application.dialogLabel.setText(DialogLabelText.vectorYComponentTooBigMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - Y Component Too Big", 
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		
		
		
		
		
		
		if (vectorYCoordinateEntry < Simulation.MIN_Y)
		{
			Application.dialogLabel.setText(DialogLabelText.vectorYCoordinateOutOfRangeBottomSideMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - Y Coordinate Out of Range",
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		else if (vectorYCoordinateEntry > Simulation.MAX_Y)
		{
			Application.dialogLabel.setText(DialogLabelText.vectorYCoordinateOutOfRangeTopSideMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Current Vector - Y Coordinate Out of Range", 
					JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		
		
		
		
		
		if (scalarOrFactor == 0.0)
		{
			Application.dialogLabel.setText(DialogLabelText.scalarOrFactorIsZeroMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Multiple or Factor is Zero", JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		else if (scalarOrFactor > 10000)
		{
			Application.dialogLabel.setText(DialogLabelText.scalarOrFactorTooLargeMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Scalar or Factor Too Large", JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		
		return false;
	}
	
	public boolean directionEntryAccept()
	{
		if (Chapter2Simulation1ControlPanel.directionTextField.getText().equals(""))
		{
			Application.dialogLabel.setText(DialogLabelText.simulationEmptyEntriesMessage1);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Direction Entry Empty", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		double directionEntry = Double.parseDouble(Chapter2Simulation1ControlPanel.directionTextField.getText());
		
		if (directionEntry < 0.0 || directionEntry > 360.0)
		{
			Application.dialogLabel.setText(DialogLabelText.directionOutOfRangeMessage);
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Direction is Out of Range", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public void setVectorEntries()
	{
		if (checkForEmptyEntries())
			return;
		
		float vectorXComponentEntry = 
				Float.parseFloat(Chapter2Simulation1ControlPanel.vectorXComponentTextField.getText()),
			vectorXCoordinateEntry = 
				Float.parseFloat(Chapter2Simulation1ControlPanel.vectorXCoordinateTextField.getText()),
			vectorYComponentEntry = 
				Float.parseFloat(Chapter2Simulation1ControlPanel.vectorYComponentTextField.getText()),
			vectorYCoordinateEntry = 
				Float.parseFloat(Chapter2Simulation1ControlPanel.vectorYCoordinateTextField.getText()),
			scalarOrFactor = Float.parseFloat(Chapter2Simulation1ControlPanel.scalarOrFactorTextField.getText());
		
		if (checkForEntryErrors(vectorXComponentEntry, vectorXCoordinateEntry, vectorYComponentEntry,
				 vectorYCoordinateEntry, scalarOrFactor))
			return;
		
		
		
		if (Chapter2Simulation1ControlPanel.oneVectorRadioButton.isSelected() ||
				Chapter2Simulation1ControlPanel.vector1RadioButton.isSelected())
		{
			Chapter2Simulation1.firstVector.
				setComponents(vectorXComponentEntry, vectorYComponentEntry);
			
			Chapter2Simulation1.firstVectorInitialPoint.setLocation(vectorXCoordinateEntry + Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X, 
					-vectorYCoordinateEntry + Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y);
			
			if (Chapter2Simulation1.firstVectorInMultiplicationMode)
				Chapter2Simulation1.firstVectorMultiple = scalarOrFactor;
			else
				Chapter2Simulation1.firstVectorMultiple = 1.0f / scalarOrFactor;
		}
		
		else if (Chapter2Simulation1ControlPanel.vector2RadioButton.isSelected())
		{
			Chapter2Simulation1.secondVector.
			setComponents(vectorXComponentEntry, vectorYComponentEntry);
		
			Chapter2Simulation1.secondVectorInitialPoint.setLocation(vectorXCoordinateEntry + Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X, 
					-vectorYCoordinateEntry + Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y);
			
			if (Chapter2Simulation1.secondVectorInMultiplicationMode)
				Chapter2Simulation1.secondVectorMultiple = scalarOrFactor;
			else
				Chapter2Simulation1.secondVectorMultiple = 1.0f / scalarOrFactor;
		}
	}
	
	public void setControlPanelForVector1()
	{
		if (Chapter2Simulation1.firstVectorMultiple >= 1.0 || Chapter2Simulation1.firstVectorMultiple <= -1.0)
		{
			Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(true);
			Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(false);
			
			Chapter2Simulation1ControlPanel.scalarOrFactorTextField.
					setText(String.valueOf(Chapter2Simulation1.firstVectorMultiple));
		}
		else
		{
			Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(false);
			Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(true);
			
			Chapter2Simulation1ControlPanel.scalarOrFactorTextField.
					setText(String.valueOf(1.0f / Chapter2Simulation1.firstVectorMultiple));
		}
		
		Chapter2Simulation1ControlPanel.vectorXComponentTextField.
				setText(String.valueOf((float)(Chapter2Simulation1.firstVector.getXComponent())));
		Chapter2Simulation1ControlPanel.vectorYComponentTextField.
				setText(String.valueOf((float)(Chapter2Simulation1.firstVector.getYComponent())));
		
		Chapter2Simulation1ControlPanel.vectorXCoordinateTextField.
				setText(String.valueOf((float)(Chapter2Simulation1.firstVectorInitialPoint.x - Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X)));
		Chapter2Simulation1ControlPanel.vectorYCoordinateTextField.
				setText(String.valueOf((float)(-Chapter2Simulation1.firstVectorInitialPoint.y + Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y)));
		
		
		Chapter2Simulation1ControlPanel.directionTextField.
				setText(String.valueOf((float)(Math.toDegrees(Chapter2Simulation1.firstVector.calculateCardinalBasedAngle()))));

		Chapter2Simulation1ControlPanel.calculatedMagnitudeLabel.
				setText(String.valueOf((float)(Math.abs(Chapter2Simulation1.firstVector.magnitude() * Chapter2Simulation1.firstVectorMultiple))));
		
		Chapter2Simulation1ControlPanel.xWithScalarValueLabel.setText(
				String.valueOf((float)(Chapter2Simulation1.firstVector.getXComponent() * Chapter2Simulation1.firstVectorMultiple)));
		Chapter2Simulation1ControlPanel.yWithScalarValueLabel.setText(
				String.valueOf((float)(Chapter2Simulation1.firstVector.getYComponent() * Chapter2Simulation1.firstVectorMultiple)));
		
		if (Chapter2Simulation1.firstVectorInMultiplicationMode)
		{
			if (Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.isSelected())
				Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(false);
			
			Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(true);

			if (Chapter2Simulation1.firstVectorUnitVectorOn)
			{
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setSelected(true);
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setEnabled(true);
			}
			else
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setSelected(false);
		}
		else
		{
			if (Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.isSelected())
				Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(false);
			
			Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(true);
			
			if (Chapter2Simulation1.firstVectorUnitVectorOn)
			{
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setSelected(false);
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setEnabled(false);
			}
		}
	}
	
	public void setControlPanelForVector2()
	{
		if (Chapter2Simulation1.secondVectorMultiple >= 1.0 || Chapter2Simulation1.secondVectorMultiple <= -1.0)
		{
			Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(true);
			Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(false);
			
			Chapter2Simulation1ControlPanel.scalarOrFactorTextField.
					setText(String.valueOf(Chapter2Simulation1.secondVectorMultiple));
		}
		else
		{
			Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(false);
			Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(true);
			
			Chapter2Simulation1ControlPanel.scalarOrFactorTextField.
					setText(String.valueOf(1.0f / Chapter2Simulation1.secondVectorMultiple));
		}
		
		Chapter2Simulation1ControlPanel.vectorXComponentTextField.
				setText(String.valueOf((float)(Chapter2Simulation1.secondVector.getXComponent())));
		Chapter2Simulation1ControlPanel.vectorYComponentTextField.
				setText(String.valueOf((float)(Chapter2Simulation1.secondVector.getYComponent())));

		Chapter2Simulation1ControlPanel.vectorXCoordinateTextField.
				setText(String.valueOf((float)(Chapter2Simulation1.secondVectorInitialPoint.x - Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X)));
		Chapter2Simulation1ControlPanel.vectorYCoordinateTextField.
				setText(String.valueOf((float)(-Chapter2Simulation1.secondVectorInitialPoint.y + Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y)));

		Chapter2Simulation1ControlPanel.directionTextField.
				setText(String.valueOf((float)(Math.toDegrees(Chapter2Simulation1.secondVector.calculateCardinalBasedAngle()))));
		
		Chapter2Simulation1ControlPanel.calculatedMagnitudeLabel.
				setText(String.valueOf((float)(Math.abs(Chapter2Simulation1.secondVector.magnitude() * Chapter2Simulation1.secondVectorMultiple))));
		
		Chapter2Simulation1ControlPanel.xWithScalarValueLabel.setText(
				String.valueOf((float)(Chapter2Simulation1.secondVector.getXComponent() * Chapter2Simulation1.secondVectorMultiple)));
		Chapter2Simulation1ControlPanel.yWithScalarValueLabel.setText(
				String.valueOf((float)(Chapter2Simulation1.secondVector.getYComponent() * Chapter2Simulation1.secondVectorMultiple)));
		
		if (Chapter2Simulation1.secondVectorInMultiplicationMode)
		{
			if (Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.isSelected())
				Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(false);
			
			Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(true);
			
			if (Chapter2Simulation1.secondVectorUnitVectorOn)
			{
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setSelected(true);
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setEnabled(true);
			}
			else
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setSelected(false);
		}
		else
		{
			if (Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.isSelected())
				Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(false);
			
			Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(true);
			
			if (Chapter2Simulation1.secondVectorUnitVectorOn)
			{
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setSelected(false);
				Chapter2Simulation1ControlPanel.unitVectorToggleButton.setEnabled(false);
			}
		}
		
	}
}
