/**
 * Desrosiers Mechanics Teaching Tool - Simulation Selection Panel
 * 
 * This is where the user selects the simulation for Simulation Mode.
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

// Resource Packages
import java.awt.*;
import javax.swing.*;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class SimulationSelectionPanel extends JPanel 
{
	/*
	 * Panel Components        
	 */                     
	public JButton okButton;
	public JButton backButton;
	
	public JComboBox<String> simulationComboBox;
	
	public JLabel simulationSelectLabel;
	public JLabel simulationLabel;
	
	public SimulationPreviewPanel simulationPreviewPanel;
	
	public JScrollPane jScrollPane1;
	
	public JTextArea selectedSimulationTextArea;
    
    public SimulationSelectionPanel() 
    {
        initComponents();
    }
           
    // Most of the code is generated from NetBeans IDE 7.3.1.  
    /**
     * Builds all the components of the simulation selection panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Size Initialization
    	setPreferredSize(Application.PROGRAM_RESOLUTION);
    	
    	
    	
    	// Component Construction
        simulationSelectLabel = new JLabel();
        simulationLabel = new JLabel();
        
        simulationComboBox = new JComboBox<String>();
        
        jScrollPane1 = new JScrollPane();
        
        selectedSimulationTextArea = new JTextArea();
        
        okButton = new JButton();
        backButton = new JButton();
        
        simulationPreviewPanel = new SimulationPreviewPanel();
        
        
        // Component Initialization
        simulationSelectLabel.setFont(Application.modeLabelFontObject); 
        simulationSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        simulationSelectLabel.setText("Select Simulation");

        simulationLabel.setFont(Application.centralFontObject); 
        simulationLabel.setText("Simulation:");

        simulationComboBox.setFont(Application.centralFontObject); 
        simulationComboBox.setModel(new DefaultComboBoxModel<String>
        	(new String[] { "Ch. 2.1: Vectors", "Ch. 2.2: Velocity & Acceleration Vectors", 
        			"Ch. 2.3: Relative Motion", "Ch. 2.4: Constant Acceleration", 
        			"Ch. 2.5: Projectile Motion", "Ch. 2.6: Uniform Circular Motion"}));
        simulationComboBox.setToolTipText("Select a chapter simulation with this combo box.");

        selectedSimulationTextArea.setEditable(false);
        selectedSimulationTextArea.setColumns(20);
        selectedSimulationTextArea.setRows(5);
        selectedSimulationTextArea.setLineWrap(true);
        selectedSimulationTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(selectedSimulationTextArea);

        okButton.setFont(Application.centralFontObject); 
        okButton.setText("OK");
        okButton.setToolTipText("Start your simulation.");

        backButton.setFont(Application.centralFontObject); 
        backButton.setText("Back");
        backButton.setToolTipText("Go back to the Main Menu.");

        simulationPreviewPanel.setBackground(Color.WHITE);
        simulationPreviewPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        simulationPreviewPanel.setPreferredSize(new Dimension(140, 140));

        GroupLayout simulationPreviewPanelLayout = new GroupLayout(simulationPreviewPanel);
        simulationPreviewPanel.setLayout(simulationPreviewPanelLayout);
        simulationPreviewPanelLayout.setHorizontalGroup(
            simulationPreviewPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );
        simulationPreviewPanelLayout.setVerticalGroup(
            simulationPreviewPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        
     
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(simulationPreviewPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(simulationSelectLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(simulationComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(simulationLabel, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(simulationSelectLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(simulationLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(simulationComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simulationPreviewPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(backButton))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }                      
    
    @SuppressWarnings("unchecked")
    /**
	 * Loads the listeners for the panel.
	 */
	public void loadListeners()
    {
    	for (Component component : this.getComponents())
    		if (component instanceof JButton)
    			((JButton)component).addActionListener(Application.simulationSelectionPanelListener);
    		else if (component instanceof JComboBox)
    			((JComboBox<Object>)component).addActionListener(Application.simulationSelectionPanelListener);
    }
    
    
    /*
     * This panel displays the icon of the chosen simulation from
     * the simulation combo box.
     */
    public class SimulationPreviewPanel extends JPanel
    {
    	private SimulationPreviewPanel()
    	{
    		setBackground(Color.WHITE);
    		setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	}
    	
    	protected void paintComponent(Graphics g)
    	{
    		Graphics2D graphicsObject = ((Graphics2D)g);
    		
    		Application.currentSimulation.paintIconGraphics(graphicsObject);
    	}
    	
    	public Dimension getPreferredSize()
    	{
    		return new Dimension(140, 140);
    	}
    }
    
}
