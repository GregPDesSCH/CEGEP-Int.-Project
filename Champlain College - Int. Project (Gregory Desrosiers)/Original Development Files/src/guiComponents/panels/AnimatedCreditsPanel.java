/**
 * Desrosiers Mechanics Teaching Tool
 * Animated Credits Panel
 * 
 * This is what the user sees when he/she decides to watch an animated
 * credits sequence from the main program. There is a task associated
 * with the credits (from the Application class) that performs the movement
 * and repainting of the viewing panel created and added to this panel.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package guiComponents.panels;

// Resource Packages and Classes
import javax.swing.*;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.*;
import java.util.Scanner;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class AnimatedCreditsPanel extends JPanel 
{
	/*
	 * Panel Components        
	 */ 
    public JButton exitButton;
    public JButton playCreditsAgainButton;
    
    public CreditsPanel creditsPanel;
	
	// Position Properties (the thread has an if statement using those properties)
	public static float yPosAtBottomOfCredits = 0;
	public static float yPosAfterLastNameToDisplay = 0;
    
    public AnimatedCreditsPanel() 
    {
        initComponents();
    }

    // Most of the code is generated from NetBeans IDE 7.3.1.
    /**
     * Builds all the components of the animated credits panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Component Construction
        creditsPanel = new CreditsPanel();
        exitButton = new JButton();
        playCreditsAgainButton = new JButton();

        
        
        // Border Initialization
        creditsPanel.setBackground(Color.WHITE);
        creditsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        
        
        // Placing the credits panel
        GroupLayout creditsPanelLayout = new GroupLayout(creditsPanel);
        creditsPanel.setLayout(creditsPanelLayout);
        creditsPanelLayout.setHorizontalGroup(
            creditsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE));
        creditsPanelLayout.setVerticalGroup(
            creditsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE));

        
        
        // Component Initialization
        exitButton.setFont(Application.centralFontObject); 
        exitButton.setText("Exit");
        exitButton.setToolTipText("Exit to Main Menu.");

        playCreditsAgainButton.setFont(Application.centralFontObject); 
        playCreditsAgainButton.setText("Play Credits Again");
        playCreditsAgainButton.setToolTipText("Restart the credits.");

        
        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(playCreditsAgainButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(creditsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(creditsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(playCreditsAgainButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }

    // This inherited JPanel is served as a panel from where the text and
    // associated imagery are drawn.
	public class CreditsPanel extends JPanel
    {
		// Text Arrays
    	String[] creditsArray = null, creditsArray2 = null;
		
    	// Play Again Message
		String playAgainString = "Click on \"Play Again\" to repeat the credits sequence.";
		
		// Images
		Image developerLogo = 
				new ImageIcon(new File("Resource Files/Logos/Developer Logo.png").getAbsolutePath()).getImage();
		Image productionHouse = 
				new ImageIcon(new File("Resource Files/Logos/campus_logo.jpg").getAbsolutePath()).getImage();
		Image presenterLogo = 
				new ImageIcon(new File("Resource Files/Logos/champlain_logo.png").getAbsolutePath()).getImage();
		
		// Objects regarding position of credits text
		Dimension screenResolution = null;
		FontMetrics fontMetricsObject = null;
		
		private CreditsPanel()
		{
			setBackground(Color.WHITE);
			
			try 
			{
				// First File
				// Line Counting Phase
				Scanner inputter = new Scanner(
						new File("Resource Files/Credits Files/Project Credits.txt"));
				int lineCount = 0;
				while(inputter.hasNext())
				{
					inputter.nextLine();
					lineCount++;
				}
				
				inputter.close();
				
				creditsArray = new String[lineCount];
				
				
				
				// Input Phase
				inputter = new Scanner(
						new File("Resource Files/Credits Files/Project Credits.txt"));
				for (int a = 0; a < creditsArray.length && inputter.hasNext(); a++)
				{
					creditsArray[a] = inputter.nextLine();
				}
				
				inputter.close();
				
			
				
				
				
				
				
				
				
				
				// Second File
				// Line Counting Phase
				inputter = new Scanner(
						new File("Resource Files/Credits Files/Copyright Notice.txt"));
				lineCount = 0;
				while(inputter.hasNext())
				{
					inputter.nextLine();
					lineCount++;
				}
				
				inputter.close();
				
				creditsArray2 = new String[lineCount];
				
				
				
				// Input Phase
				inputter = new Scanner(
						new File("Resource Files/Credits Files/Copyright Notice.txt"));
				for (int a = 0; a < creditsArray2.length && inputter.hasNext(); a++)
				{
					creditsArray2[a] = inputter.nextLine();
				}
				
				inputter.close();
				
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		
		/**
		 * Paints the credits on the panel. (This method is thread-dependent on a task,
		 * an instance of CreditsAnimationTask)
		 */
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			// Graphics Plugin Initialization
			Graphics2D graphicsDevice = (Graphics2D)g;
			
			graphicsDevice.setFont(Application.dialogLabelFontObject);
			
			graphicsDevice.setColor(Color.BLACK);
			graphicsDevice.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
			graphicsDevice.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

			
			if (yPosAtBottomOfCredits > -50)
			{
				float currentY = Application.creditsTask.topCreditsYPos;
				
				if (screenResolution == null)
				{
					screenResolution = getPreferredSize();
					fontMetricsObject = graphicsDevice.getFontMetrics();
				}
			
				// Printing the strings on the screen (a.k.a. the credits text)
				for (int a = 0; a < creditsArray.length; a++)
				{
					// The if statement is for the tribute message at the end of most of
					// the credits text.
					if (a >= (creditsArray.length - 4))
						graphicsDevice.setColor(Color.BLUE);
					
					graphicsDevice.drawString(creditsArray[a], (float)(screenResolution.getWidth() / 2 - 
							fontMetricsObject.stringWidth(creditsArray[a]) / 2), currentY);
				
					currentY += graphicsDevice.getFontMetrics().getHeight();
				}
				
				// Resetting color for headers of logos to be displayed
				graphicsDevice.setColor(Color.BLACK);
				yPosAfterLastNameToDisplay = currentY;
				
				
				
				
				
				
				
				// Setting position for the first logo
				currentY += 500;
			
				// Developer Logo initialize and print
				AffineTransform t1 = new AffineTransform();
				t1.translate(screenResolution.getWidth() / 2.0 - developerLogo.getWidth(this) / 2.0 * (8 / 15.0), currentY);
				t1.scale(8 / 15.0, 8 / 15.0);
				
				
				graphicsDevice.drawImage(developerLogo, t1, null);
		
				
				
				
				
				
				
				
				// Setting position for the second logo
				currentY += 100 + developerLogo.getHeight(this) 
						+ graphicsDevice.getFontMetrics().getHeight();
				
				
				// Production House Logo initialize and print
				AffineTransform t2 = new AffineTransform();
				t2.translate(screenResolution.getWidth() / 2.0 - productionHouse.getWidth(this) / 2.0 *
						(8 / 15.0 * ((float)developerLogo.getWidth(this) / (float)productionHouse.getWidth(this))),
						currentY + 50);
				t2.scale(8 / 15.0 * ((float)developerLogo.getWidth(this) / (float)productionHouse.getWidth(this)),
						8 / 15.0 * ((float)developerLogo.getWidth(this) / (float)productionHouse.getWidth(this)));
				
				
				graphicsDevice.drawString("In Association With: ", 
						(float)screenResolution.getWidth() / 2 - fontMetricsObject.stringWidth("In Association With: ") / 2, 
						currentY);
				
				currentY += 50;
				
				graphicsDevice.drawImage(productionHouse, t2, null);
				
			
				
				
				
				
				
				
				// Setting position for the third logo
				currentY += 450 + productionHouse.getHeight(this) * t2.getScaleY();
				
				// Presenter Logo initialize and print
				AffineTransform t3 = new AffineTransform();
				t3.translate(screenResolution.getWidth() / 2.0 - presenterLogo.getWidth(this) / 2.0 * 
						(8 / 15.0 * ((float)developerLogo.getWidth(this) / (float)presenterLogo.getWidth(this))), 
						currentY + 50);
				t3.scale(8 / 15.0 * ((float)developerLogo.getWidth(this) / (float)presenterLogo.getWidth(this)),
						8 / 15.0 * ((float)developerLogo.getWidth(this) / (float)presenterLogo.getWidth(this)));
				
				
				graphicsDevice.drawString("Presented By: ", 
						(float)screenResolution.getWidth() / 2 - fontMetricsObject.stringWidth("Presented By: ") / 2, 
						currentY);
				
				currentY += 50;
				
				graphicsDevice.drawImage(presenterLogo, t3, null);
			
			
				
				
				
				
				// Setting position for the copyright information
				currentY += 450 + presenterLogo.getHeight(this) * t3.getScaleY();
			
				// Printing copyright info
				for (int a = 0; a < creditsArray2.length; a++)
				{
					graphicsDevice.drawString(creditsArray2[a], (float)(screenResolution.getWidth() / 2 - 
							fontMetricsObject.stringWidth(creditsArray2[a]) / 2), currentY);
				
					currentY += graphicsDevice.getFontMetrics().getHeight();
				}
			
				yPosAtBottomOfCredits = currentY;
			}
			else
			{
				// Printing Play Again message
				graphicsDevice.drawString(playAgainString,
						getSize().width / 2 - graphicsDevice.getFontMetrics().stringWidth(playAgainString) / 2,
						getSize().height / 2 - graphicsDevice.getFontMetrics().getHeight() / 2);
			}
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(620, 402);
		}
    }
	
	/**
	 * Loads the listeners for two buttons created for the panel.
	 */
	public void loadListeners()
	{
		playCreditsAgainButton.addActionListener(Application.animatedCreditsPanelListener);
		exitButton.addActionListener(Application.animatedCreditsPanelListener);
	}
}
