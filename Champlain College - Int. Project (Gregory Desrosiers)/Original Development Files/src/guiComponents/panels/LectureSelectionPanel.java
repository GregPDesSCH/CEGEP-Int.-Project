/**
 * Desrosiers Mechanics Teaching Tool - Lecture Selection Panel
 * 
 * This is where the user selects the lecture from where he/she wants
 * to learn the material on motion and forces.
 * 
 * Created using NetBeans IDE 7.3.1.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added to this file.
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
import java.awt.*;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class LectureSelectionPanel extends JPanel 
{
	/*
	 * Panel Components        
	 */                   
    public JButton okButton;
    public JButton backButton;
    
    public JComboBox<String> sectionComboBox;
    public JComboBox<String> chapterComboBox;
    
    public JLabel selectLectureLabel;
    public JLabel lectureTypeLabel;
    public JLabel chapterLabel;
    public JLabel sectionLabel;
    
    public ButtonGroup lectureTypeRadioButtonGroup;
    public JRadioButton oneSectionRadioButton;
    public JRadioButton fullChapterRadioButton;
    
    public JScrollPane selectedLectureTextAreaScrollPane;
    
    public JTextArea selectedLectureTextArea;
    
    public LectureSelectionPanel() 
    {
        initComponents();
    }
       
    /**
     * Builds all the components of the lecture selection panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Size Initialization
    	setPreferredSize(Application.PROGRAM_RESOLUTION);
    	
    	
    	
    	
    	
    	// Component Construction
        selectLectureLabel = new JLabel();
        lectureTypeLabel = new JLabel();
        
        lectureTypeRadioButtonGroup = new ButtonGroup();
        
        oneSectionRadioButton = new JRadioButton();
        fullChapterRadioButton = new JRadioButton();
        
        sectionComboBox = new JComboBox<String>();
        
        chapterLabel = new JLabel();
        sectionLabel = new JLabel();
        
        chapterComboBox = new JComboBox<String>();
        
        selectedLectureTextAreaScrollPane = new JScrollPane();
        
        selectedLectureTextArea = new JTextArea();
        
        okButton = new JButton();
        backButton = new JButton();

        
        
        
        
        // Component Initialization
        selectLectureLabel.setFont(Application.modeLabelFontObject); 
        selectLectureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectLectureLabel.setText("Select Lecture");
        selectLectureLabel.setPreferredSize(new Dimension(138, 22));

        lectureTypeLabel.setFont(new Font("Arial", 0, 17)); 
        lectureTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lectureTypeLabel.setText("Lecture Type");

        oneSectionRadioButton.setFont(Application.centralFontObject); 
        oneSectionRadioButton.setText("One Section");
        oneSectionRadioButton.setToolTipText("Learn from one section of one chapter only.");

        fullChapterRadioButton.setFont(Application.centralFontObject); 
        fullChapterRadioButton.setText("Full Chapter");
        fullChapterRadioButton.setToolTipText("Learn from a full chapter.");

        fullChapterRadioButton.setSelected(true);

        lectureTypeRadioButtonGroup.add(oneSectionRadioButton);
        lectureTypeRadioButtonGroup.add(fullChapterRadioButton);
        
        sectionComboBox.setFont(Application.centralFontObject); 
        sectionComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "1: Vectors", "2: Velocity and Acceleration Vectors", 
        		"3: Relative Motion", "4: Constant Acceleration", "5: Projectile Motion", "6: Uniform Circular Motion"}));
        sectionComboBox.setToolTipText("<html>Select a section associated with the chapter by this combo box.<br/>NOTE: This is disabled when the lecture type is \"Full Chapter.\"<br/></html>");
        sectionComboBox.setEnabled(false);
        sectionComboBox.setRenderer(new SectionComboBoxRenderer());

        chapterLabel.setFont(Application.centralFontObject); 
        chapterLabel.setText("Chapter:");

        sectionLabel.setFont(Application.centralFontObject); 
        sectionLabel.setText("Section:");

        chapterComboBox.setFont(Application.centralFontObject); 
        chapterComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { 
        		"What do I need to know to learn physics?", 
        		"Chapter 2: Motion in Two and Three Dimensions"}));
        chapterComboBox.setToolTipText("Select one chapter from this combo box.");
        chapterComboBox.setRenderer(new ChapterComboBoxRenderer());
       

        selectedLectureTextArea.setEditable(false);
        selectedLectureTextArea.setColumns(20);
        selectedLectureTextArea.setFont(Application.centralFontObject); 
        selectedLectureTextArea.setLineWrap(true);
        selectedLectureTextArea.setRows(5);
        selectedLectureTextArea.setWrapStyleWord(true);
        selectedLectureTextArea.setBorder(null);
        selectedLectureTextAreaScrollPane.setViewportView(selectedLectureTextArea);

        okButton.setFont(Application.centralFontObject); 
        okButton.setText("OK");
        okButton.setToolTipText("Start your lecture.");

        backButton.setFont(Application.centralFontObject); 
        backButton.setText("Back");
        backButton.setToolTipText("Go back to the Main Menu.");

        
        
        
        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        	.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        		.addGap(135, 135, 135)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        			.addComponent(chapterComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(layout.createSequentialGroup()
        				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        					.addComponent(chapterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(lectureTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        						.addGap(18, 18, 18)
        						.addComponent(oneSectionRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
        				.addGap(0, 28, Short.MAX_VALUE)))
        		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        			.addComponent(sectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        			.addComponent(sectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        		.addGap(135, 135, 135))
        	.addGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        			.addGroup(layout.createSequentialGroup()
        				.addGap(219, 219, 219)
        				.addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addGap(74, 74, 74)
        				.addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        			.addComponent(selectLectureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        		.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        	.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        		.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        				.addComponent(selectedLectureTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addGap(73, 73, 73))
        			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        				.addComponent(fullChapterRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addGap(135, 135, 135))))
            );
        layout.setVerticalGroup(
        	layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        	.addGroup(layout.createSequentialGroup()
        		.addComponent(selectLectureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        		.addGap(31, 31, 31)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        			.addComponent(lectureTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
        			.addComponent(oneSectionRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(fullChapterRadioButton))
        		.addGap(18, 18, 18)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        			.addComponent(sectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        			.addComponent(chapterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        			.addComponent(sectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        			.addComponent(chapterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        		.addGap(40, 40, 40)
        		.addComponent(selectedLectureTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
        		.addGap(52, 52, 52)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        			.addComponent(okButton)
        			.addComponent(backButton))
        		.addContainerGap())
        	);
    }                      

    /**
	 * Loads the listeners for the panel.
	 */
    public void loadListeners()
	{
		okButton.addActionListener(Application.lectureSelectionPanelListener);
		backButton.addActionListener(Application.lectureSelectionPanelListener);
		
		sectionComboBox.addActionListener(Application.lectureSelectionPanelListener);
		chapterComboBox.addActionListener(Application.lectureSelectionPanelListener);
		
		oneSectionRadioButton.addActionListener(Application.lectureSelectionPanelListener);
		fullChapterRadioButton.addActionListener(Application.lectureSelectionPanelListener);
		
	}
    
    // Based on the renderer code from the following site:
    // http://www.coderanch.com/t/334032/GUI/java/Tool-tip-JComboBox
    private class ChapterComboBoxRenderer extends DefaultListCellRenderer 
    {  
    	public Component getListCellRendererComponent(JList<?> list,   
    			Object value, int index, boolean isSelected, boolean cellHasFocus)
    	{  
    		JComponent c = (JComponent)super.getListCellRendererComponent( list,  
    				value, index, isSelected, cellHasFocus);  
    	            
    		if (value instanceof String && isSelected) 
    			list.setToolTipText(chapterComboBox.getModel().getElementAt(index));  
    	    else if (!(value instanceof String) && isSelected) 
    	    	list.setToolTipText("");  
    		
    		return c;  
    	}  
    }  

    // This cell renderer allows the user to see the full name of the chapter
  	// section through a tool tip text when the name of the chapter section 
    // does not fit within the boundaries of the combo box.
    private class SectionComboBoxRenderer extends DefaultListCellRenderer 
    {  
    	public Component getListCellRendererComponent(JList<?> list,   
    			Object value, int index, boolean isSelected, boolean cellHasFocus)
    	{  
    		JComponent c = (JComponent)super.getListCellRendererComponent( list,  
    				value, index, isSelected, cellHasFocus);  
    	            
    		if (value instanceof String && isSelected) 
    			list.setToolTipText(sectionComboBox.getModel().getElementAt(index));   
    	    else if (!(value instanceof String) && isSelected) 
    	    	list.setToolTipText("");    
    		
    		return c;  
    	}  
    }
}
