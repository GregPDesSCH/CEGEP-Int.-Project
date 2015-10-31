/**
 * Desrosiers Mechanics Teaching Tool - Performance Utility
 * 
 * This utility assists the development process in making sure that when
 * the final program is ready, it runs efficiently, concurrently, and
 * effectively with no exceptions thrown.
 * 
 * It displays info regarding RAM, CPU usage, # of running threads, and
 * the status of this program.
 * 
 * For fun, the utility is left available to the user for them to see
 * the technical information at their convenience.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
 * UPDATE (May 17, 2014) - Title of frame set to "Performance Utility" instead
 * of "Debug Utility".
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programCore;

// Resource Classes and Packages
import java.lang.management.ManagementFactory;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.management.*;



@SuppressWarnings("serial")
public class ApplicationPerformanceUtility extends JDialog 
{

	// Main Components
	private JPanel mainPanel;
	private JPanel mainLabelPanel;
	private JLabel mainLabel1;
	private JLabel mainLabel2;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	
	
	// Left Panel Components
	private JLabel totalMemoryLabel;
	private JLabel physicalMemoryLabel;
	private JLabel freeMemoryLabel;
	private JLabel usedMemoryLabel;
	
	private JLabel cpuUsageLabel;
	private JLabel systemCPUUsageLabel;
	private JLabel threadCountLabel;
	
	
	
	
	// Right Panel Components
	private JLabel totalMemoryQuantityLabel;
	private JLabel physicalMemoryQuantityLabel;
	private JLabel freeMemoryQuantityLabel;
	private JLabel usedMemoryQuantityLabel;
	
	private JLabel cpuUsageInfoLabel;
	private JLabel systemCPUUsageInfoLabel;
	private JLabel threadCountQuantityLabel;
	
	
	
	// Associated Task & Thread
	private Runnable thread;
	private Thread utilityThread;
	
	
	
	
	// Information Managers (JVM Status)
	private Runtime jvmManager1 = Runtime.getRuntime();
	private OperatingSystemMXBean jvmManager2 = 
			(OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
	private ThreadMXBean jvmManager3 = 
			(ThreadMXBean)ManagementFactory.getThreadMXBean();
	
	
	
	public ApplicationPerformanceUtility()
	{
		/*
		 * GUI Construction
		 */
		// Main Panel Construction
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		
		mainLabelPanel = new JPanel(new GridLayout(3, 1));
		
		mainLabel1 = new JLabel("The Desrosiers Mechanics Teaching Tool");
		mainLabel1.setHorizontalAlignment(JLabel.CENTER);
		
		mainLabel2 = new JLabel("Performance Utility");
		mainLabel2.setHorizontalAlignment(JLabel.CENTER);
		
		mainLabelPanel.add(mainLabel1);
		mainLabelPanel.add(mainLabel2);
		
		mainPanel.add(mainLabelPanel, BorderLayout.NORTH);
		
		
		// Left Panel Construction
		leftPanel = new JPanel(new GridLayout(10, 1));
		
		
		totalMemoryLabel = new JLabel("Total Memory Available: ");
		totalMemoryLabel.setHorizontalAlignment(JLabel.LEFT);
		leftPanel.add(totalMemoryLabel);
		
		physicalMemoryLabel = new JLabel("Physical Memory: ");
		physicalMemoryLabel.setHorizontalAlignment(JLabel.LEFT);
		leftPanel.add(physicalMemoryLabel);
		
		freeMemoryLabel = new JLabel("Free Memory: ");
		freeMemoryLabel.setHorizontalAlignment(JLabel.LEFT);
		leftPanel.add(freeMemoryLabel);
		
		usedMemoryLabel = new JLabel("Used Memory: ");
		usedMemoryLabel.setHorizontalAlignment(JLabel.LEFT);
		leftPanel.add(usedMemoryLabel);
		
		
		leftPanel.add(new JPanel());
		
		
		cpuUsageLabel = new JLabel("CPU Usage: ");
		cpuUsageLabel.setHorizontalAlignment(JLabel.LEFT);
		leftPanel.add(cpuUsageLabel);
		
		systemCPUUsageLabel = new JLabel("System CPU Usage: ");
		systemCPUUsageLabel.setHorizontalAlignment(JLabel.LEFT);
		leftPanel.add(systemCPUUsageLabel);
		
		threadCountLabel = new JLabel("Thread Count: ");
		threadCountLabel.setHorizontalAlignment(JLabel.LEFT);
		leftPanel.add(threadCountLabel);
		
		
		leftPanel.add(new JPanel());
		
		
		
		// Right Panel Construction
		rightPanel = new JPanel(new GridLayout(10, 1));
		
		
		totalMemoryQuantityLabel = new JLabel();
		totalMemoryQuantityLabel.setHorizontalAlignment(JLabel.RIGHT);
		rightPanel.add(totalMemoryQuantityLabel);
		
		physicalMemoryQuantityLabel = new JLabel();
		physicalMemoryQuantityLabel.setHorizontalAlignment(JLabel.RIGHT);
		rightPanel.add(physicalMemoryQuantityLabel);
		
		freeMemoryQuantityLabel = new JLabel();
		freeMemoryQuantityLabel.setHorizontalAlignment(JLabel.RIGHT);
		rightPanel.add(freeMemoryQuantityLabel);
		
		usedMemoryQuantityLabel = new JLabel();
		usedMemoryQuantityLabel.setHorizontalAlignment(JLabel.RIGHT);
		rightPanel.add(usedMemoryQuantityLabel);
		
		
		rightPanel.add(new JPanel());
		
		
		cpuUsageInfoLabel = new JLabel();
		cpuUsageInfoLabel.setHorizontalAlignment(JLabel.RIGHT);
		rightPanel.add(cpuUsageInfoLabel);
		
		systemCPUUsageInfoLabel = new JLabel();
		systemCPUUsageInfoLabel.setHorizontalAlignment(JLabel.RIGHT);
		rightPanel.add(systemCPUUsageInfoLabel);
		
		threadCountQuantityLabel = new JLabel();
		threadCountQuantityLabel.setHorizontalAlignment(JLabel.RIGHT);
		rightPanel.add(threadCountQuantityLabel);
		
		
		rightPanel.add(new JPanel());
	
		
		
		
		
		// Panel Assembly
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		
		
		
		
		
		// Thread Setup
		thread = new InfoThread();
		utilityThread = new Thread(thread);
		
		
		
		/*
		 *  Final Initialization
		 */
		add(mainPanel);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Performance Utility");
		setResizable(false);
		pack();
	}
	
	public void showDialog()
	{
		if (!isVisible())
		{
			setVisible(true);
		
			if (!utilityThread.isAlive())
			{
				thread = new InfoThread();
				utilityThread = new Thread(thread);
			}
		
			utilityThread.start();
		}
		else
			// Brings utility above application frame if it is visible,
			// but behind the application frame.
			requestFocus(); 
	}
	
	
	// This class is responsible for a task that runs on top of the
	// performance utility.
	private class InfoThread implements Runnable
	{
		public void run()
		{
			// As long as the performance utility is visible and not hiding,
			// the thread will keep running and update the labels the performance
			// utility has.
			while (Application.performanceUtility.isVisible())
			{
				
				// Total Memory
				long totalMemory = jvmManager1.totalMemory();
				
				totalMemoryQuantityLabel.setText(
						String.valueOf(totalMemory / 1048576) + " MB");
				
				
				// Physical Memory
				physicalMemoryQuantityLabel.setText(
						String.valueOf(jvmManager1.maxMemory() / 1048576) + " MB");
				
				
				// Free Memory
				long freeMemory = jvmManager1.freeMemory();
		
				if (freeMemory < 10485760)
					freeMemoryQuantityLabel.setText(freeMemory / 1024 + " KB");
				else
					freeMemoryQuantityLabel.setText(freeMemory / 1048576 + " MB");
				
				
				// Used Memory
				long usedMemory = totalMemory - freeMemory;
				
				if (usedMemory < 10485760)
				{
					usedMemory /= 1024;
					usedMemoryQuantityLabel.setText(String.valueOf(usedMemory) + " KB");
				}
				else
				{
					usedMemory /= 1048576;
					usedMemoryQuantityLabel.setText(String.valueOf(usedMemory) + " MB");
				}
				
				
				
				// Calculating CPU Usage for this program
				byte cpuUsage = (byte) (jvmManager2.getProcessCpuLoad() * 100);
				
				if (cpuUsage >= 0)
					cpuUsageInfoLabel.setText(String.valueOf(cpuUsage) + " %");
				
				
				
				
				// Calculating System CPU Usage and color coding it for rating
				byte systemCPUUsage = (byte) (jvmManager2.getSystemCpuLoad() * 100);
				
				if (systemCPUUsage < 50)
					systemCPUUsageInfoLabel.setForeground(Color.GREEN.darker());
				else if (systemCPUUsage < 70)
					systemCPUUsageInfoLabel.setForeground(Color.YELLOW);
				else if (systemCPUUsage < 85)
					systemCPUUsageInfoLabel.setForeground(Color.ORANGE);
				else
					systemCPUUsageInfoLabel.setForeground(Color.RED);
					
				
				if (systemCPUUsage >= 0)
					systemCPUUsageInfoLabel.setText(String.valueOf(systemCPUUsage) + " %");
				
				
				/*
				 * We want to get the exact number of threads running in the program itself,
				 * only putting emphasis on the GUI and sometimes simulation algorithms.
				 * 
				 * If there are no simulations running nor any other tasks running, the value
				 * displayed is one because the only thread shown is thus the event dispatcher
				 * thread.
				 * 
				 * This is why we find the number of threads by this equation; we do not count
				 * this thread, as this utility adds one thread to it.
				 */
				threadCountQuantityLabel.setText(String.valueOf(jvmManager3.getThreadCount() - 
						jvmManager3.getDaemonThreadCount() - 3));
				
				try
				{
					Thread.sleep(10);
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
}
