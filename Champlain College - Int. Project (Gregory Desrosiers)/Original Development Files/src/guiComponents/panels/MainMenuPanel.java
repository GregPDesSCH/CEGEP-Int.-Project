/**
 * Desrosiers Mechanics Teaching Tool - Main Menu Panel
 * 
 * This is the code for the main menu panel; most of the GUI design
 * was done using NetBeans IDE 7.3.1. As such, all of the generated
 * code for the components is combined here.
 * 
 * Changes have been made to the NetBeans generated code to make
 * the code for this class more professionally presentable and appropriate.
 * 
 * Created using NetBeans IDE 7.3.1.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added.
 * UPDATE (May 19, 2014) - Constant variable for the panel resolution
 * has its name changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.panels;

// Resource Packages and Class
import javax.swing.*;

import java.awt.*;
import java.io.File;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial") 
public class MainMenuPanel extends JPanel 
{
	/*
	 * Panel Components        
	 */
    public JButton lecturesButton;
    public JButton simulationsButton;
    public JButton exercisesButton;
    public JButton quizzesButton;
    public JButton quitButton;
    public JButton creditsButton;
    
    public JLabel programLogoLabel;
    public JLabel currentDateAndTimeLabel;
      
    public MainMenuPanel() 
    {
        initComponents();
    }

    
    /**
     * Builds all the components of the main menu panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Size Initialization
        setPreferredSize(Application.PROGRAM_RESOLUTION);
        
      
        // Component Construction
        lecturesButton = new JButton();
        simulationsButton = new JButton();
        exercisesButton = new JButton();
        quizzesButton = new JButton();
        
        quitButton = new JButton();
        creditsButton = new JButton();
        
        programLogoLabel = new JLabel();
        currentDateAndTimeLabel = new JLabel();

     
        // Component Initialization
        lecturesButton.setFont(Application.centralFontObject); 
        lecturesButton.setText("Lectures");
        lecturesButton.setToolTipText("Take some time to follow a lecture.");

        simulationsButton.setFont(Application.centralFontObject); 
        simulationsButton.setText("Simulations");
        simulationsButton.setToolTipText("Use your time to investigate more of the material using animated simulations.");

        exercisesButton.setFont(Application.centralFontObject); 
        exercisesButton.setText("Exercises");
        exercisesButton.setToolTipText("Practice your knowledge of a chapter or section using preprogrammed exercises.");

        quizzesButton.setFont(Application.centralFontObject); 
        quizzesButton.setText("Quizzes");
        quizzesButton.setToolTipText("Test yourself with a quiz on a chapter or across multiple chapters.");

        creditsButton.setFont(Application.centralFontObject); 
        creditsButton.setText("Credits");
        creditsButton.setToolTipText("Watch an animated credits sequence.");
        
        quitButton.setFont(Application.centralFontObject); 
        quitButton.setText("Quit");
        quitButton.setToolTipText("Quit the program.");

        programLogoLabel.setIcon(new ImageIcon(new File("Resource Files/Logos/Program Logo (Main Menu).png").getAbsolutePath())); 

        currentDateAndTimeLabel.setFont(new Font("Arial", 0, 12)); 
        currentDateAndTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(exercisesButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addComponent(simulationsButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lecturesButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(quizzesButton, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(creditsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(263, 263, 263))
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(programLogoLabel)
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentDateAndTimeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(programLogoLabel)
                .addGap(58, 58, 58)
                .addComponent(lecturesButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulationsButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exercisesButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quizzesButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditsButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(currentDateAndTimeLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }
    
    /**
	 * Loads the listeners for the panel.
	 */
    public void loadListeners()
    {
    	for (Component component : this.getComponents())
    		if (component instanceof JButton)
    			((JButton)component).addActionListener(Application.mainMenuPanelListener);
    }
             
}
