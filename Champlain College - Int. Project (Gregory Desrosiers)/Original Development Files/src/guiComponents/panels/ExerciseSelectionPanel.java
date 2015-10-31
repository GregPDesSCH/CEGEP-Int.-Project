/**
 * Desrosiers Mechanics Teaching Tool - Exercise Selecton Panel
 * 
 * This is where the user selects the exercises; a graphical panel
 * with a few labels, two combo boxes, two radio buttons, and a
 * text area displaying the user selections.
 * 
 * Created using NetBeans IDE 7.3.1.
 * 
 * The combo box item renderers to display a tool tip text of the
 * object is based on the algorithm from this site:
 * http://www.coderanch.com/t/334032/GUI/java/Tool-tip-JComboBox
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
import javax.swing.*;

import java.awt.*;

// Interaction Class
import programCore.Application;

@SuppressWarnings("serial")
public class ExerciseSelectionPanel extends JPanel 
{
	/*
	 * Panel Components        
	 */                  
	public JButton okButton;
	public JButton backButton;
	
	public JComboBox<String> chapterComboBox;
	public JComboBox<String> chapterSectionComboBox;
	
	public JLabel selectExercisesLabel;
	public JLabel sectionLabel;
	public JLabel chapterLabel;
	public JLabel includeAnswersLabel;
	
	public ButtonGroup includeAnswersRadioButtonGroup;
	
	public JRadioButton yesToIncludeAnswersRadioButton;
	public JRadioButton noToIncludeAnswersRadioButton;
	
	public JScrollPane selectedExercisesTextAreaScrollPane;
	
	public JTextArea selectedExercisesTextArea;


    public ExerciseSelectionPanel() 
    {
        initComponents();
    }
        
    /**
     * Builds all the components of the exercises selection panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Size Initialization
    	setPreferredSize(Application.PROGRAM_RESOLUTION);
    	
    	
    	
    	// Component Construction
        selectExercisesLabel = new JLabel();
        
        okButton = new JButton();
        backButton = new JButton();
        
        selectedExercisesTextAreaScrollPane = new JScrollPane();
        
        selectedExercisesTextArea = new JTextArea();
        
        chapterComboBox = new JComboBox<String>();
        
        sectionLabel = new JLabel();
        
        chapterSectionComboBox = new JComboBox<String>();
        
        chapterLabel = new JLabel();
        
        includeAnswersLabel = new JLabel();
        
        includeAnswersRadioButtonGroup = new ButtonGroup();
        
        yesToIncludeAnswersRadioButton = new JRadioButton();
        noToIncludeAnswersRadioButton = new JRadioButton();

        
        
        
        
        // Component Initialization
        selectExercisesLabel.setFont(Application.modeLabelFontObject); 
        selectExercisesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectExercisesLabel.setText("Select Exercises");

        okButton.setFont(Application.centralFontObject); 
        okButton.setText("OK");
        okButton.setToolTipText("Start your exercises.");

        backButton.setFont(Application.centralFontObject); 
        backButton.setText("Back");
        backButton.setToolTipText("Go back to the Main Menu.");

        selectedExercisesTextArea.setColumns(20);
        selectedExercisesTextArea.setFont(Application.centralFontObject); 
        selectedExercisesTextArea.setRows(5);
        selectedExercisesTextArea.setEditable(false);
        selectedExercisesTextAreaScrollPane.setViewportView(selectedExercisesTextArea);

        chapterComboBox.setFont(Application.centralFontObject); 
        chapterComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Chapter 2: Motion in Two and Three Dimensions" }));
        chapterComboBox.setToolTipText("Select chapter from this combo box.");
        chapterComboBox.setRenderer(new ChapterComboBoxRenderer());

        sectionLabel.setFont(Application.centralFontObject); 
        sectionLabel.setText("Section:");

        chapterSectionComboBox.setFont(Application.centralFontObject); 
        chapterSectionComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "1: Vectors", "2: Velocity and Acceleration Vectors", 
        		"3: Relative Motion", "4: Constant Acceleration", "5: Projectile Motion", 
        		"6: Uniform Circular Motion", "Full Chapter", "Substitution Exercises" }));
        chapterSectionComboBox.setToolTipText("Select chapter section from this combo box.");
        chapterSectionComboBox.setRenderer(new SectionComboBoxRenderer());

        chapterLabel.setFont(Application.centralFontObject); 
        chapterLabel.setText("Chapter:");

        includeAnswersLabel.setFont(Application.centralFontObject); 
        includeAnswersLabel.setText("Include answers?");
        
        yesToIncludeAnswersRadioButton.setFont(Application.centralFontObject); 
        yesToIncludeAnswersRadioButton.setText("Yes");
        yesToIncludeAnswersRadioButton.setToolTipText("Displays answers in each exercise.");
        yesToIncludeAnswersRadioButton.setSelected(true);
        includeAnswersRadioButtonGroup.add(yesToIncludeAnswersRadioButton);

        noToIncludeAnswersRadioButton.setFont(Application.centralFontObject); 
        noToIncludeAnswersRadioButton.setText("No");
        noToIncludeAnswersRadioButton.setToolTipText("Does not display answers in each exercise.");
        includeAnswersRadioButtonGroup.add(noToIncludeAnswersRadioButton);

        
        
        
        
        
        // Placing components in desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(selectExercisesLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(selectedExercisesTextAreaScrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(chapterComboBox, 0, 201, Short.MAX_VALUE)
                            .addComponent(chapterLabel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(chapterSectionComboBox,  0, 130, Short.MAX_VALUE)
                            .addComponent(sectionLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yesToIncludeAnswersRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noToIncludeAnswersRadioButton))
                            .addComponent(includeAnswersLabel))
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(selectExercisesLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addComponent(chapterLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addComponent(includeAnswersLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(chapterComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(chapterSectionComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(yesToIncludeAnswersRadioButton)
                    .addComponent(noToIncludeAnswersRadioButton))
                .addGap(64, 64, 64)
                .addComponent(selectedExercisesTextAreaScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(backButton))
                .addContainerGap(68, Short.MAX_VALUE))
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
    			((JButton)component).addActionListener(Application.exerciseSelectionPanelListener);
    		else if (component instanceof JRadioButton)
    			((JRadioButton)component).addActionListener(Application.exerciseSelectionPanelListener);
    		else if (component instanceof JComboBox)
    			((JComboBox<String>)component).addActionListener(Application.exerciseSelectionPanelListener); 	
    }
	
	// This cell renderer allows the user to see the full name of the chapter
	// through a tool tip text when the name of the chapter does not fit within
	// the boundaries of the combo box.
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
    			list.setToolTipText(chapterSectionComboBox.getModel().getElementAt(index));  
    	    else if (!(value instanceof String) && isSelected) 
    	    	list.setToolTipText("");  
    		
    		return c;  
    	}  
    }
}
