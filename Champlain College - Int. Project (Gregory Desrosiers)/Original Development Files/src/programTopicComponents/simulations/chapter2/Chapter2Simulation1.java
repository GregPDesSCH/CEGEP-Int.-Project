/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 1
 * 
 * This is a representation of the first simulation, which is manipulating
 * two different vectors regarding components, initial positions, direction,
 * and scalars.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 25, 2014 - May 6, 2014)
 * UPDATE (May 20, 2014) - The constants declared in the Simulation class 
 * have their names changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programTopicComponents.simulations.chapter2;

// Inheritance Class (for polymorphism)
import programTopicComponents.simulations.Simulation;


// Resource Classes and Package
import java.awt.*;
import java.awt.geom.Point2D;

import programTopicComponents.commonClasses.Vector2D;

// Interaction Class
import guiComponents.panels.simulationControlPanels.chapter2.Chapter2Simulation1ControlPanel;

public class Chapter2Simulation1 extends Simulation 
{
	// Simulation Description
	public static String simulationDescription;
	
	// First Vector Variables
	public static Vector2D firstVector;
	public static Vector2D firstVectorUnitVector;
	
	public static Point2D.Double firstVectorInitialPoint;
	public static Point2D.Double firstVectorUnitVectorInitialPoint;
	public static boolean firstVectorUnitVectorOn = false;
	
	public static float firstVectorMultiple; // Scalar or Factor
	
	public static boolean firstVectorInMultiplicationMode = true;
	
	
	// Second Vector Variables
	public static Vector2D secondVector;
	public static Vector2D secondVectorUnitVector;
	
	public static Point2D.Double secondVectorInitialPoint;
	public static Point2D.Double secondVectorUnitVectorInitialPoint;
	public static boolean secondVectorUnitVectorOn = false;
	
	public static float secondVectorMultiple; // Scalar or Factor
	
	public static boolean secondVectorInMultiplicationMode = true;
	
	// Temporary Flag for Subtraction
	public static boolean vectorSubtraction;
	
	// Subtraction Type
	public static int subtractionType;
	
	
	public Chapter2Simulation1()
	{
		// General Data Setup
		threadAvailable = false;
		animationSupported = false;
		simulationDescription = "Explore some of the arithmetics and use of vectors as one of the"
				+ "major core elements in using physics material. Choose between one or two vectors "
				+ "and investigate what you can do to them and what you see.";
		
		
		// First Vector Construction and Initialization
		firstVector = new Vector2D(0.0, 1.0);
		firstVectorUnitVector = new Vector2D(0.0, 1.0);
		
		firstVectorInitialPoint = new Point2D.Double(310.0, 150.0);
		firstVectorUnitVectorInitialPoint = new Point2D.Double(310.0, 150.0);
		
		firstVectorMultiple = 1.0f;
		
		
		// Second Vector Construction and Initialization
		secondVector = new Vector2D(1.0, 0.0);
		secondVectorUnitVector = new Vector2D(1.0, 0.0);
		
		secondVectorInitialPoint = new Point2D.Double(310.0, 150.0);
		secondVectorUnitVectorInitialPoint = new Point2D.Double(310.0, 150.0);
		
		secondVectorMultiple = 1.0f;
		
		
		// Final Initialization
		vectorSubtraction = false;
		
		setControlPanelForFirstUse();
	}
	
	
	public void paintIconGraphics(Graphics2D graphicsObject)
	{
		drawArrow(graphicsObject, 20, 120, 120, 20);
		drawArrow(graphicsObject, 20, 20, 120, 120);
	}
	
	public void paintGraphics(Graphics2D graphicsObject) 
	{
		if (Chapter2Simulation1ControlPanel.oneVectorRadioButton.isSelected())
			drawArrow(graphicsObject, firstVectorInitialPoint.x, firstVectorInitialPoint.y, 
					firstVectorInitialPoint.x + (firstVector.getXComponent() * firstVectorMultiple), 
					firstVectorInitialPoint.y - (firstVector.getYComponent() * firstVectorMultiple));
		
		if (Chapter2Simulation1ControlPanel.twoVectorsRadioButton.isSelected())
		{
			if (!vectorSubtraction)
			{
				drawArrow(graphicsObject, firstVectorInitialPoint.x, firstVectorInitialPoint.y, 
						firstVectorInitialPoint.x + (firstVector.getXComponent() * firstVectorMultiple), 
						firstVectorInitialPoint.y - (firstVector.getYComponent() * firstVectorMultiple));
				
				drawArrow(graphicsObject, secondVectorInitialPoint.x, secondVectorInitialPoint.y,
						secondVectorInitialPoint.x + (secondVector.getXComponent() * secondVectorMultiple), 
						secondVectorInitialPoint.y - (secondVector.getYComponent() * secondVectorMultiple));
			}
			else
			{
				
				
				if (subtractionType == 0)
				{
					graphicsObject.setColor(Color.RED);
					drawArrow(graphicsObject, firstVectorInitialPoint.x, firstVectorInitialPoint.y, 
							firstVectorInitialPoint.x + (firstVector.getXComponent() * firstVectorMultiple), 
							firstVectorInitialPoint.y - (firstVector.getYComponent() * firstVectorMultiple));
					graphicsObject.setColor(Color.BLUE);
					drawArrow(graphicsObject, secondVectorInitialPoint.x, secondVectorInitialPoint.y,
							secondVectorInitialPoint.x - (secondVector.getXComponent() * secondVectorMultiple), 
							secondVectorInitialPoint.y + (secondVector.getYComponent() * secondVectorMultiple));
					graphicsObject.setColor(Color.BLACK);
				}
				else
				{
					graphicsObject.setColor(Color.RED);
					drawArrow(graphicsObject, firstVectorInitialPoint.x, firstVectorInitialPoint.y, 
							firstVectorInitialPoint.x - (firstVector.getXComponent() * firstVectorMultiple), 
							firstVectorInitialPoint.y + (firstVector.getYComponent() * firstVectorMultiple));
					graphicsObject.setColor(Color.BLUE);
					drawArrow(graphicsObject, secondVectorInitialPoint.x, secondVectorInitialPoint.y,
							secondVectorInitialPoint.x + (secondVector.getXComponent() * secondVectorMultiple), 
							secondVectorInitialPoint.y - (secondVector.getYComponent() * secondVectorMultiple));
					graphicsObject.setColor(Color.BLACK);
				}
			}
		}
		
		if (Chapter2Simulation1ControlPanel.unitVectorToggleButton.isSelected())
		{
			if (Chapter2Simulation1.firstVectorUnitVectorOn)
			{
				firstVectorUnitVector = firstVector.multiply(1.0 / (firstVector.magnitude() * firstVectorMultiple));
				firstVectorUnitVectorInitialPoint.setLocation(firstVectorInitialPoint.x, 
						secondVectorInitialPoint.y);
			
				drawArrow(graphicsObject, firstVectorInitialPoint.x, firstVectorInitialPoint.y, 
						firstVectorInitialPoint.x + firstVectorUnitVector.getXComponent(), 
						firstVectorInitialPoint.y - firstVectorUnitVector.getYComponent());
			}
			else if (Chapter2Simulation1.secondVectorUnitVectorOn)
			{
				secondVectorUnitVector = secondVector.multiply(1.0 / (secondVector.magnitude() * secondVectorMultiple));
				secondVectorUnitVectorInitialPoint.setLocation(secondVectorInitialPoint.x, 
						secondVectorInitialPoint.y);
				
				drawArrow(graphicsObject, secondVectorInitialPoint.x, secondVectorInitialPoint.y, 
						secondVectorInitialPoint.x + secondVectorUnitVector.getXComponent(), 
						secondVectorInitialPoint.y - secondVectorUnitVector.getYComponent());
			}
		}
	}
	
	public void resetSimulation()
	{
		// Resetting first vector
		firstVector.setComponents(0.0, 1.0);
		firstVectorUnitVector.setComponents(0.0, 1.0);
		
		firstVectorInitialPoint.setLocation(310.0, 150.0);
		firstVectorUnitVectorInitialPoint.setLocation(310.0, 150.0);
		
		firstVectorMultiple = 1.0f;
		
		
		// Resetting second vector
		secondVector.setComponents(1.0, 0.0);
		secondVectorUnitVector.setComponents(1.0, 0.0);
		
		secondVectorInitialPoint.setLocation(310.0, 150.0);
		secondVectorUnitVectorInitialPoint.setLocation(310.0, 150.0);
		
		secondVectorMultiple = 1.0f;
	}
	
	/**
	 * Resets the components of this simulation.
	 */
	public void setControlPanelForFirstUse()
	{
		Chapter2Simulation1ControlPanel.scalarOrFactorTextField.
					setText(String.valueOf(Chapter2Simulation1.firstVectorMultiple));
		
		Chapter2Simulation1ControlPanel.vectorXComponentTextField.
				setText(String.valueOf(Chapter2Simulation1.firstVector.getXComponent()));
		Chapter2Simulation1ControlPanel.vectorYComponentTextField.
				setText(String.valueOf(Chapter2Simulation1.firstVector.getYComponent()));
		
		Chapter2Simulation1ControlPanel.vectorXCoordinateTextField.
				setText(String.valueOf(Chapter2Simulation1.firstVectorInitialPoint.x - Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X));
		Chapter2Simulation1ControlPanel.vectorYCoordinateTextField.
				setText(String.valueOf(-Chapter2Simulation1.firstVectorInitialPoint.y + Simulation.DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y));
		
		Chapter2Simulation1ControlPanel.directionTextField.
				setText(String.valueOf((float)(Math.toDegrees(Chapter2Simulation1.firstVector.calculateCardinalBasedAngle()))));
	}
	
	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void replaceThread()
	{
		
	}
	
	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void disposeThread()
	{
		
	}
	
	public void reinitializeControlPanel()
	{
		Chapter2Simulation1ControlPanel.oneVectorRadioButton.setSelected(true);
		Chapter2Simulation1ControlPanel.twoVectorsRadioButton.setSelected(false);
        
		Chapter2Simulation1ControlPanel.multiplyVectorWithScalarRadioButton.setSelected(true);
		Chapter2Simulation1ControlPanel.divideVectorWithScalarRadioButton.setSelected(false);

		Chapter2Simulation1ControlPanel.scalarOrFactorTextField.setText(
				String.valueOf(firstVectorMultiple));
        
		Chapter2Simulation1ControlPanel.directionTextField.setText(
				String.valueOf(firstVector.calculateCardinalBasedAngle()));
       
		Chapter2Simulation1ControlPanel.vectorXComponentTextField.setText(
				String.valueOf(firstVector.getXComponent()));
		Chapter2Simulation1ControlPanel.vectorYComponentTextField.setText(
				String.valueOf(firstVector.getYComponent()));
        
		Chapter2Simulation1ControlPanel.xWithScalarValueLabel.setText(
				String.valueOf(firstVector.getXComponent() * firstVectorMultiple));
		Chapter2Simulation1ControlPanel.yWithScalarValueLabel.setText(
				String.valueOf(firstVector.getYComponent() * firstVectorMultiple));

		Chapter2Simulation1ControlPanel.vectorXCoordinateTextField.setText(
				String.valueOf(firstVectorInitialPoint.x));
		Chapter2Simulation1ControlPanel.vectorYCoordinateTextField.setText(
				String.valueOf(firstVectorInitialPoint.y));

		Chapter2Simulation1ControlPanel.unitVectorToggleButton.setSelected(false);
        
		
		
		Chapter2Simulation1ControlPanel.addVectorsButton.setEnabled(false);
		Chapter2Simulation1ControlPanel.subtractVectorsButton.setEnabled(false);
        
		Chapter2Simulation1ControlPanel.vector1RadioButton.setSelected(true);
        Chapter2Simulation1ControlPanel.vector1RadioButton.setEnabled(false);
        Chapter2Simulation1ControlPanel.vector2RadioButton.setSelected(false);

        Chapter2Simulation1ControlPanel.calculatedMagnitudeLabel.setText(
        		String.valueOf(firstVector.magnitude() * firstVectorMultiple));
	}

	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void setPropertiesForStartingAnimationThread() 
	{
		
	}

	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void setPropertiesForStoppingAnimationThread() 
	{
		
	}

	/**
	 * An empty method only to overcome a compilation error because this simulation
	 * inherits from an abstract class called Simulation.
	 */
	public void reEnableComponentsAfterReset() 
	{
		
	}
}
