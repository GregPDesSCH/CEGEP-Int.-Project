/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 6
 * 
 * This class represents the simulation for circular motion; the painting, the
 * individual components for painting, and what the program does to manage
 * the simulation is written here.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 25, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added to this file. Most of the methods 
 * used in this simulation do not have documentation written here because
 * the documentation written in the Simulation class is displayed.
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

// Resource Classes and Packages
import programCore.Application;
import tasks.simulations.chapter2.Chapter2Simulation6Task;

import java.awt.geom.*;
import java.awt.*;
import java.text.DecimalFormat;



// Interaction Class
import guiComponents.panels.simulationControlPanels.chapter2.Chapter2Simulation6ControlPanel;

public class Chapter2Simulation6 extends Simulation
{
	// Simulation Description
	public static String simulationDescription;
	
	// Icon Objects (for drawing)
	Ellipse2D.Float iconOval;
	Line2D.Float iconLine1;
	
	// Simulation Data
	public static float radiusOfMotion;
	public static float tangentialVelocity;
	public static float tangentialAcceleration;
	
	public static float angularAcceleration;
	public static float timeElapsed;
	
	public static double angularDisplacement;
	
	// Simulation Shapes
	public static Ellipse2D.Float rotationOutline;
	
	public static Line2D.Float tangentialVelocityLine;
	public static Line2D.Float tangentialAccelerationLine;
	
	public static Rectangle2D.Float currentVelocityStringRectangle;
	
	// Output Number Formatters
	public static DecimalFormat currentTangentialVelocityStringFormatter;
	public static DecimalFormat radialAccelerationStringFormatter;
	public static DecimalFormat elapsedTimeStringFormatter;
	
	// Animation Frame Time Length
	public static final byte frameDuration = (byte)(1000.0 / 60.0);
	
	public Chapter2Simulation6()
	{	
		// General Data Setup
		threadAvailable = true;
		animationSupported = true;
		simulationDescription = "Take some time to experiment circular motion "
				+ "and follow the concepts discussed in this topic, whether the radius"
				+ " is small, there is an imposing tangential acceleration, or simply "
				+ "a constant linear tangential velocity.";
		simulationResetted = false;
		
		
		// Icon Shape Construction
		iconOval = new Ellipse2D.Float(35.0f, 35.0f, 70.0f, 70.0f);
		iconLine1 = new Line2D.Float(70.0f, 34.0f, 35.0f, 34.0f);
		
		
		// Simulation Data Initialization
		radiusOfMotion = 125.0f;
		tangentialVelocity = 10.0f;
		tangentialAcceleration = 0.0f;
		
		angularDisplacement = 0.0;
		timeElapsed = 0.0f;
		
		angularAcceleration = tangentialAcceleration / radiusOfMotion;
		
		// Simulation Shape Construction
		rotationOutline = new Ellipse2D.Float(- radiusOfMotion, - radiusOfMotion, 2 * radiusOfMotion, 2 * radiusOfMotion);
		
		tangentialVelocityLine = new Line2D.Float(0, - radiusOfMotion, tangentialVelocity / .25f, - radiusOfMotion);
		
		tangentialAccelerationLine = new Line2D.Float(310, 150 - radiusOfMotion - 15.0f, 
				310 - 5.0f * tangentialAcceleration, 150 - radiusOfMotion - 15.0f);
		
		currentVelocityStringRectangle = new Rectangle2D.Float(0, 260, 180, 40);
		
		
		// Number Formatter Construction
		currentTangentialVelocityStringFormatter = new DecimalFormat("#.##");
		radialAccelerationStringFormatter = new DecimalFormat("#.00000");
		elapsedTimeStringFormatter = new DecimalFormat("#.00");
		
		
		// Final Construction and Initialization
		Application.simulationPanel.simulationViewingPanel.repaint();
		Application.chapter2Simulation6Task = new Chapter2Simulation6Task();
		Application.simulationThread = new Thread(Application.chapter2Simulation6Task);
	}
	
	public void paintIconGraphics(Graphics2D graphicsObject)
	{
		graphicsObject.draw(iconOval);
		drawArrow(graphicsObject, iconLine1.getX1(), iconLine1.getY1(), 
				iconLine1.getX2(), iconLine1.getY2());
		
		graphicsObject.drawString("v", 35.0f, 47.0f);
		
		drawArrow(graphicsObject, iconLine1.getX1(), iconLine1.getY1(),
				70.0f, 70.0f);
		graphicsObject.drawString("a", 59.5f, 56.0f);
	}
	
	public void paintGraphics(Graphics2D graphicsObject) 
	{
		Graphics2D drawingObject = (Graphics2D)(graphicsObject.create());
		
		graphicsObject.setColor(Color.BLACK);
		graphicsObject.fill(currentVelocityStringRectangle);
		graphicsObject.setColor(Color.WHITE);
		graphicsObject.drawString("Elapsed Time: " + elapsedTimeStringFormatter.format(timeElapsed), 0, 275);
		graphicsObject.drawString("Tangential Velocity: " + 
				currentTangentialVelocityStringFormatter.format(tangentialVelocity), 0, 295);
		
		graphicsObject.setColor(Color.BLUE);
		

		if (Chapter2Simulation6.tangentialAcceleration != 0.0f)
		drawArrow(graphicsObject, tangentialAccelerationLine.getX1(), tangentialAccelerationLine.getY1(),
				tangentialAccelerationLine.getX2(), tangentialAccelerationLine.getY2());
		
		// Rotation
		drawingObject.translate(DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_X, DIFFERENCE_BETWEEN_JAVA_AND_CARTESIAN_ORIGIN_Y);
		drawingObject.rotate(angularDisplacement);
		
		drawingObject.draw(rotationOutline);
		
		drawingObject.setStroke(new java.awt.BasicStroke(2.5f));
		drawingObject.setColor(Color.RED);
		
		drawArrow(drawingObject, tangentialVelocityLine.getX1(), tangentialVelocityLine.getY1(),
				-tangentialVelocityLine.getX2(), tangentialVelocityLine.getY2());
	}
	
	public void resetSimulation()
	{
		radiusOfMotion = 125.0f;
		tangentialVelocity = 10.0f;
		tangentialAcceleration = 0.0f;
		
		angularDisplacement = 0.0;
		
		Chapter2Simulation6.timeElapsed = 0.0f;
		
		rotationOutline.x = -radiusOfMotion;
		rotationOutline.y = -radiusOfMotion; 
		rotationOutline.width = 2 * radiusOfMotion; 
		rotationOutline.height = 2 * radiusOfMotion;
		
		// Radius
		rotationOutline.setFrame(-radiusOfMotion, -radiusOfMotion, 2 * radiusOfMotion, 
				2 * radiusOfMotion);
		
		Chapter2Simulation6ControlPanel.radiusTextField.setText(String.valueOf(radiusOfMotion));
				
		
		
		// Tangential Velocity
		float factor = .25f;
				
		if (tangentialVelocity >= 0)
			for (; factor * 64.0f < tangentialVelocity; factor+= .25f){}
		else
		{
			factor = -factor;
			for (; factor * 64.0f > tangentialVelocity; factor-= .25f){}
		}
				
		tangentialVelocityLine.setLine(0, -radiusOfMotion, 
				tangentialVelocity / Math.abs(factor), -radiusOfMotion);
		
		Chapter2Simulation6ControlPanel.tangentialVelocityTextField.setText(String.valueOf(tangentialVelocity));
				
		
		
		// Tangential Acceleration
		Chapter2Simulation6.tangentialAccelerationLine.setLine(310, 150 - radiusOfMotion - 15.0f, 
				310 - 5.0f * tangentialAcceleration, 150 - radiusOfMotion - 15.0f);
		
		Chapter2Simulation6ControlPanel.tangentialAccelerationTextField.setText(String.valueOf(tangentialAcceleration));
		
		
		// Labels
		Chapter2Simulation6ControlPanel.calculatedInstantaneousRadialAccelerationLabel.setText("N/A");
		Chapter2Simulation6ControlPanel.calculatedAverageRadialAccelerationLabel.setText("N/A");
	}
	
	public void replaceThread()
	{
		Application.simulationThread = null;
		
		if (Application.chapter2Simulation6Task != null)
			Application.chapter2Simulation6Task.releaseThread = true;
		
		Application.chapter2Simulation6Task = new Chapter2Simulation6Task();
		Application.simulationThread = new Thread(Application.chapter2Simulation6Task);
	}
	
	public void disposeThread()
	{
		if (Application.simulationThread != null)
		{
			Application.simulationThread = null;
			Application.chapter2Simulation6Task.releaseThread = true;
			Application.chapter2Simulation6Task = null;
		}
	}
	
	public void reinitializeControlPanel()
	{
		Chapter2Simulation6ControlPanel.radiusTextField.setText("125.0");
		Chapter2Simulation6ControlPanel.radiusTextField.setEnabled(true);
		
		Chapter2Simulation6ControlPanel.tangentialVelocityTextField.setText("10.0");
		Chapter2Simulation6ControlPanel.tangentialVelocityTextField.setEnabled(true);

		Chapter2Simulation6ControlPanel.startOrStopToggleButton.setSelected(false);

		Chapter2Simulation6ControlPanel.resetButton.setText("Reset");
		Chapter2Simulation6ControlPanel.resetButton.setEnabled(false);
	        
		Chapter2Simulation6ControlPanel.tangentialAccelerationTextField.setText("0.0");
		Chapter2Simulation6ControlPanel.tangentialAccelerationTextField.setEnabled(true);

		Chapter2Simulation6ControlPanel.calculatedInstantaneousRadialAccelerationLabel.setText("N/A");

		Chapter2Simulation6ControlPanel.calculatedAverageRadialAccelerationLabel.setText("N/A");
	}

	public void setPropertiesForStartingAnimationThread() 
	{
		if (Chapter2Simulation6ControlPanel.radiusTextField.isEnabled())
		{
			Chapter2Simulation6ControlPanel.radiusTextField.setEnabled(false);
			Chapter2Simulation6ControlPanel.tangentialVelocityTextField.setEnabled(false);
			Chapter2Simulation6ControlPanel.tangentialAccelerationTextField.setEnabled(false);
		}
		
		Chapter2Simulation6ControlPanel.startOrStopToggleButton.setSelected(true);
		Chapter2Simulation6ControlPanel.startOrStopToggleButton.setText("Stop");
		
		Chapter2Simulation6ControlPanel.resetButton.setEnabled(true);
	}

	public void setPropertiesForStoppingAnimationThread() 
	{
		Chapter2Simulation6ControlPanel.startOrStopToggleButton.setSelected(false);
		Chapter2Simulation6ControlPanel.startOrStopToggleButton.setText("Start");
		
		Chapter2Simulation6ControlPanel.resetButton.setEnabled(false);
	}

	public void reEnableComponentsAfterReset() 
	{
		Chapter2Simulation6ControlPanel.radiusTextField.setEnabled(true);
		Chapter2Simulation6ControlPanel.tangentialVelocityTextField.setEnabled(true);
		Chapter2Simulation6ControlPanel.tangentialAccelerationTextField.setEnabled(true);
	}

}
