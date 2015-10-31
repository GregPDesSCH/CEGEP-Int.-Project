/**
 * Desrosiers Mechanics Teaching Tool - Quiz Selection Panel
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
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
public class QuizSelectionPanel extends JPanel 
{
	/*
	 * Panel Components        
	 */
	public JButton okButton;
	public JButton backButton;
	
	public JComboBox<String> chapterComboBox;
	
	public JLabel quizSelectLabel;
	public JLabel chapterLabel;
	public JLabel difficultyLabel;
	public JLabel minuteLabel;
	public JLabel secondLabel;
	public JLabel timerLabel;
	public JLabel timeLimitLabel;
	
	public ButtonGroup difficultyRadioButtonGroup;
	public JRadioButton easyDifficultyRadioButton;
	public JRadioButton mediumDifficultyRadioButton;
	public JRadioButton hardDifficultyRadioButton;
	
	public ButtonGroup timerRadioButtonGroup;
	public JRadioButton yesTimerRadioButton;
	public JRadioButton noTimerRadioButton;
	
	public JSpinner secondSpinner;
	public JSpinner minuteSpinner;

    public QuizSelectionPanel() 
    {
        initComponents();
    }
    
    // Most of the code is generated from NetBeans IDE 7.3.1. 
    /**
     * Builds all the components of the quiz selection panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Size Initialization
    	setPreferredSize(Application.PROGRAM_RESOLUTION);

    	
    	// Component Construction
        quizSelectLabel = new JLabel();
        
        okButton = new JButton();
        backButton = new JButton();
        
        chapterLabel = new JLabel();
        
        chapterComboBox = new JComboBox<String>();
        
        difficultyRadioButtonGroup = new ButtonGroup();
        easyDifficultyRadioButton = new JRadioButton();
        mediumDifficultyRadioButton = new JRadioButton();
        hardDifficultyRadioButton = new JRadioButton();
        
        difficultyLabel = new JLabel();
        
        secondSpinner = new JSpinner();
        minuteSpinner = new JSpinner();
        
        minuteLabel = new JLabel();
        secondLabel = new JLabel();
        timerLabel = new JLabel();
        
        timerRadioButtonGroup = new ButtonGroup();
        yesTimerRadioButton = new JRadioButton();
        noTimerRadioButton = new JRadioButton();
        
        timeLimitLabel = new JLabel();

        
        // Component Initialization
        quizSelectLabel.setFont(Application.modeLabelFontObject); 
        quizSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quizSelectLabel.setText("Select Quiz");

        okButton.setFont(Application.centralFontObject); 
        okButton.setToolTipText("Start your quiz.");
        okButton.setText("OK");

        backButton.setFont(Application.centralFontObject); 
        backButton.setToolTipText("Go back to the Main Menu.");
        backButton.setText("Back");

        chapterLabel.setFont(Application.centralFontObject); 
        chapterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chapterLabel.setText("Chapter:");

        chapterComboBox.setFont(Application.centralFontObject); 
        chapterComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { 
        		"Chapter 2: Motion in Two and Three Dimensions" }));
        chapterComboBox.setToolTipText("Select a chapter from this combo box.");
        chapterComboBox.setRenderer(new ChapterComboBoxRenderer());

        easyDifficultyRadioButton.setFont(Application.centralFontObject); 
        easyDifficultyRadioButton.setToolTipText("Do an easy quiz.");
        easyDifficultyRadioButton.setText("Easy");
        easyDifficultyRadioButton.setSelected(true);
        difficultyRadioButtonGroup.add(easyDifficultyRadioButton);

        mediumDifficultyRadioButton.setFont(Application.centralFontObject); 
        mediumDifficultyRadioButton.setToolTipText("Do a medium quiz.");
        mediumDifficultyRadioButton.setText("Medium");
        difficultyRadioButtonGroup.add(mediumDifficultyRadioButton);

        hardDifficultyRadioButton.setFont(Application.centralFontObject); 
        hardDifficultyRadioButton.setToolTipText("Do a hard quiz.");
        hardDifficultyRadioButton.setText("Hard");
        difficultyRadioButtonGroup.add(hardDifficultyRadioButton);

        difficultyLabel.setFont(Application.centralFontObject); 
        difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        difficultyLabel.setText("Difficulty:");

        secondSpinner.setFont(Application.centralFontObject); 
        secondSpinner.setModel(new SpinnerNumberModel(Byte.valueOf((byte)0), Byte.valueOf((byte)0), Byte.valueOf((byte)45), Byte.valueOf((byte)15)));
        secondSpinner.setToolTipText("<html>Select how many seconds you want your quiz to be with this spinner.<br/><b>NOTE: </b> This spinner is disabled when you don't want a time limit in your quiz.</html>");

        minuteSpinner.setFont(Application.centralFontObject); 
        minuteSpinner.setModel(new SpinnerNumberModel(Byte.valueOf((byte)5), Byte.valueOf((byte)5), Byte.valueOf((byte)20), Byte.valueOf((byte)1)));
        minuteSpinner.setToolTipText("<html>Select how many minutes you want your quiz to be with this spinner.<br/><b>NOTE: </b> This spinner is disabled when you don't want a time limit in your quiz.</html>");

        minuteLabel.setText("min.");
        minuteLabel.setFont(new Font("Tahoma", Font.PLAIN, 10)); 

        secondLabel.setText("sec.");
        secondLabel.setFont(new Font("Tahoma", Font.PLAIN, 10)); 

        timerLabel.setFont(Application.centralFontObject); 
        timerLabel.setText("Timer?");

        yesTimerRadioButton.setFont(Application.centralFontObject); 
        yesTimerRadioButton.setToolTipText("Enable time limit.");
        yesTimerRadioButton.setText("Yes");
        timerRadioButtonGroup.add(yesTimerRadioButton);

        noTimerRadioButton.setFont(Application.centralFontObject); 
        noTimerRadioButton.setToolTipText("Disable time limit.");
        noTimerRadioButton.setText("No");
        noTimerRadioButton.setSelected(true);
        timerRadioButtonGroup.add(noTimerRadioButton);

        timeLimitLabel.setFont(Application.centralFontObject); 
        timeLimitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLimitLabel.setText("Time Limit:");

        
        
        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(chapterComboBox, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                .addComponent(chapterLabel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yesTimerRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(noTimerRadioButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(timerLabel)))
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(difficultyLabel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(easyDifficultyRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mediumDifficultyRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hardDifficultyRadioButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(timeLimitLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minuteSpinner, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minuteLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondSpinner, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(96, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(quizSelectLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(quizSelectLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(difficultyLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(chapterLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(chapterComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(easyDifficultyRadioButton)
                    .addComponent(mediumDifficultyRadioButton)
                    .addComponent(hardDifficultyRadioButton))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(timerLabel)
                    .addComponent(timeLimitLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(secondSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteLabel)
                    .addComponent(secondLabel)
                    .addComponent(yesTimerRadioButton)
                    .addComponent(noTimerRadioButton))
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(backButton))
                .addContainerGap(50, Short.MAX_VALUE))
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
    			((JButton)component).addActionListener(Application.quizSelectionPanelListener);
    		else if (component instanceof JRadioButton)
    			((JRadioButton)component).addActionListener(Application.quizSelectionPanelListener);
    		else if (component instanceof JComboBox)
    			((JComboBox<String>)component).addActionListener(Application.quizSelectionPanelListener);
    		else if (component instanceof JSpinner)
    			((JSpinner)component).addChangeListener(Application.quizSelectionPanelListener);
    
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
}
