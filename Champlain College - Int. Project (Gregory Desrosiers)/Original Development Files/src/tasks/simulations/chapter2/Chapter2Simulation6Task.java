/**
 * Desrosiers Mechanics Teaching Tool
 * Chapter 2 Simulation 6
 * 
 * This is the timestep algorithm for the circular motion simulation,
 * where assuming that the CPU can process this task quickly enough,
 * it runs at about 60 frames per second.
 * 
 * This algorithm is heavily based on the last coding block from this
 * site: http://gafferongames.com/game-physics/fix-your-timestep/
 * (Description available for more detail on how this works)
 * 
 * Unlike the most simple algorithms where it does not take into account
 * the delay time in adjusting properties of an object or a variable, this
 * algorithm does count the time delay in setting the properties of the
 * painted components as part of the timing algorithm and thus the elapsed 
 * time in this simulation is approximately real time. In addition, this
 * algorithm counts possible circumstances with regards to RAM,
 * operating system, CPU, power settings, and other vital hardware.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 25, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added to this file.
 * UPDATE (May 18, 2014) - Two slashes have been removed from the code, and
 * the description has been updated, and the task has been fixed for the
 * simulation to work correctly. (had to do with unpausing the simulation
 * when the radial acceleration label values were incorrect)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package tasks.simulations.chapter2;

// Interaction Classes
import guiComponents.panels.simulationControlPanels.chapter2.Chapter2Simulation6ControlPanel;
import programCore.Application;
import programTopicComponents.simulations.chapter2.Chapter2Simulation6;

public class Chapter2Simulation6Task implements Runnable 
{
	public boolean releaseThread = false;
	
	public void run()
	{
		// Variables for instantaneous and average radial acceleration
		float currentRadialAcceleration = (float)(
						Math.pow(Chapter2Simulation6.tangentialVelocity, 2.0) / Chapter2Simulation6.radiusOfMotion),
				originalRadialAcceleration = (float)
				(Math.pow(Float.parseFloat(Chapter2Simulation6ControlPanel.tangentialVelocityTextField.getText()), 2.0) /
						Float.parseFloat(Chapter2Simulation6ControlPanel.radiusTextField.getText()));
		
		// Timestep Variables
		final double dt = 0.01;
		double  t = 0.0, accumulator = 0.0, currentTime;

		currentTime = (double)(System.nanoTime()) / 1E09;
			
		while(!releaseThread)
		{
			// Timestep Variables (2)
			double newTime = (double)(System.nanoTime()) / 1E09, 
					frameTime = newTime - currentTime;
			currentTime = newTime;
			
			
			accumulator += frameTime;
			
			while(accumulator >= dt)
			{
				Chapter2Simulation6.tangentialVelocity += Chapter2Simulation6.tangentialAcceleration *
						dt;
				
				Chapter2Simulation6.angularDisplacement -= 
						(Chapter2Simulation6.tangentialVelocity / Chapter2Simulation6.radiusOfMotion) * 
						dt;
				
				
				
				
				// Loops for changing the length of the tangential velocity vector
				float factor = .25f;
				
				if (Chapter2Simulation6.tangentialVelocity >= 0)
					for (; factor * 64.0f < Chapter2Simulation6.tangentialVelocity; factor+= .25f){}
				else
				{
					factor = -factor;
					for (; factor * 64.0f > Chapter2Simulation6.tangentialVelocity; factor-= .25f){}
				}
				
				Chapter2Simulation6.tangentialVelocityLine.x2 = Chapter2Simulation6.tangentialVelocity / Math.abs(factor);
				
				
				
				
				
				currentRadialAcceleration = (float)(Math.pow(Chapter2Simulation6.tangentialVelocity, 2.0) 
						/ Chapter2Simulation6.radiusOfMotion);
				
				Chapter2Simulation6ControlPanel.calculatedInstantaneousRadialAccelerationLabel.
					setText(Chapter2Simulation6.radialAccelerationStringFormatter.format( 
						currentRadialAcceleration));
				
				
				
				
				
				accumulator -= dt;
				t += dt;
			}
			
			
			
			
			Chapter2Simulation6.timeElapsed += t;
			
			Chapter2Simulation6ControlPanel.calculatedAverageRadialAccelerationLabel.
				setText(Chapter2Simulation6.radialAccelerationStringFormatter.format(
					(float)( (originalRadialAcceleration + currentRadialAcceleration) / 2.0 )));
			
			Application.simulationPanel.simulationViewingPanel.repaint();
			
			t = 0.0;
			
			
			
			try
			{
				Thread.sleep(Chapter2Simulation6.frameDuration);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
