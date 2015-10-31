/**
 * Desrosiers Mechanics Teaching Tool - Lecture Panel
 * 
 * This is the build for what the user sees when he/she is in 
 * Lecture Mode.
 * 
 * Created using NetBeans IDE 7.3.1.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 7, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added for this file
 * and the inner class ViewingPanel.
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
import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class LecturePanel extends JPanel 
{
	/*
	 * Panel Components        
	 */                
	public JButton previousPageButton;
	public JButton nextPageButton;
	
	public JLabel pageNumberLabel;
	public JLabel chapterAndSectionLabel;
	
	public JTextArea descriptionTextArea;
	public JScrollPane descriptionTextScrollPane;
	
	public ViewingPanel viewingPanel;
	
	public JTextField customPageNumberTextField;
    
    
    public LecturePanel() 
    {
        initComponents();
    }
               
    /**
     * Builds all the components of the lecture panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Size Initialization
    	setPreferredSize(Application.PROGRAM_RESOLUTION);
    	
    	
    	
    	
    	
    	// Component Construction
        descriptionTextArea = new JTextArea();
        descriptionTextScrollPane = new JScrollPane();
        
        chapterAndSectionLabel = new JLabel();
        
        viewingPanel = new ViewingPanel();
        
        pageNumberLabel = new JLabel();
        
        previousPageButton = new JButton();
        nextPageButton = new JButton();
        
        customPageNumberTextField = new JTextField();


        
        
        
        
        /*
         *  Component Initialization
         */
        // Setting the border and the layout of the description panel
        descriptionTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GroupLayout descriptionTextAreaLayout = new GroupLayout(descriptionTextArea);
        descriptionTextArea.setLayout(descriptionTextAreaLayout);
        descriptionTextAreaLayout.setHorizontalGroup(
            descriptionTextAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        descriptionTextAreaLayout.setVerticalGroup(
            descriptionTextAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setEditable(false);
        descriptionTextScrollPane.setViewportView(descriptionTextArea);

        chapterAndSectionLabel.setFont(Application.centralFontObject); 
        chapterAndSectionLabel.setText("chapterAndSectionLabel");

        GroupLayout viewingPanelLayout = new GroupLayout(viewingPanel);
        viewingPanel.setLayout(viewingPanelLayout);
        viewingPanelLayout.setHorizontalGroup(
            viewingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        viewingPanelLayout.setVerticalGroup(
            viewingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );

        pageNumberLabel.setFont(Application.centralFontObject); 
        pageNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        pageNumberLabel.setText("Page # of #");

        previousPageButton.setFont(Application.centralFontObject); 
        previousPageButton.setText("<");

        nextPageButton.setFont(Application.centralFontObject); 
        nextPageButton.setText(">");

        customPageNumberTextField.setFont(Application.centralFontObject); 
        customPageNumberTextField.setText("1");
        customPageNumberTextField.setHorizontalAlignment(JTextField.CENTER);
        customPageNumberTextField.setDocument(new LecturePageNumberTextFieldDocumentListener());

        
        
        
        
        
        // Placing components in desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        	.addGroup(layout.createSequentialGroup()
        		.addContainerGap()
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        			.addComponent(viewingPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(layout.createSequentialGroup()
        				.addComponent(chapterAndSectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addGap(0, 0, Short.MAX_VALUE))
        			.addGroup(layout.createSequentialGroup()
        				.addComponent(descriptionTextScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(previousPageButton)
        						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        						.addComponent(customPageNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        						.addComponent(nextPageButton))
        					.addComponent(pageNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        		.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        	.addGroup(layout.createSequentialGroup()
        		.addContainerGap()
        		.addComponent(chapterAndSectionLabel)
        		.addGap(29, 29, 29)
        		.addComponent(viewingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        			.addGroup(layout.createSequentialGroup()
        				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        				.addComponent(pageNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        					.addComponent(previousPageButton)
        					.addComponent(nextPageButton)
        					.addComponent(customPageNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        				.addGap(111, 111, 111))
        			.addGroup(layout.createSequentialGroup()
        				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        				.addComponent(descriptionTextScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }                     

    /**
	 * Loads the listeners for the panel.
	 */
    public void loadListeners()
    {
    	for (Component component : this.getComponents())
    		if ((component instanceof JButton))
    			((JButton)component).addActionListener(Application.lectureModeListener);
    		else if (component == customPageNumberTextField)
    			customPageNumberTextField.addActionListener(Application.lectureModeListener);
    
    }
    
    /*
     * This is where the diagrams and drawings associated with the lecture page
     * is drawn. Because of time constraints and development issues, only one
     * image is implemented in this version of the program.
     */
    public class ViewingPanel extends JPanel
    {
    	private ViewingPanel()
    	{
    		setBackground(Color.WHITE);
    		setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	}
    	
    	protected void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		
    		Graphics2D lectureDrawingDevice = ((Graphics2D)g);
    		
    		if (Application.currentLecture != null)
    			Application.currentLecture.lecturePages[Application.currentLecture.currentLecturePageIndex]
    					.paintGraphics(lectureDrawingDevice);
    	}
    	
    	public Dimension getPreferredSize()
    	{
    		return new Dimension(620, 223);
    	}
    }
    
    // This document listener makes sure that the number entered into the
    // custom page number text field are actual positive numbers.
    private class LecturePageNumberTextFieldDocumentListener extends PlainDocument 
    {
    	private final int stringMaxSize = 2;

    	public void insertString(int offset, String str, AttributeSet attr) 
    			throws BadLocationException 
    	{
    		if (str == null)
    			return;
    		
    		for(int x = 0; x < str.length(); x++)
    			if ((str.charAt(x) < 48 || str.charAt(x) > 57))
    				return;
    	
    		if ((getLength() + str.length()) <= stringMaxSize)
    			super.insertString(offset, str, attr);
	
    	}
    }
}
