/**
 * Desrosiers Mechanics Teaching Tool - Quiz Panel
 * 
 * This is the rough GUI build of the panel from what the user sees
 * when he/she is in Quiz Mode of this program. No quizzes are implemented
 * in this version of the program, but the user can see a preview of what
 * quizzes would be like in this program.
 * 
 * Created using NetBeans IDE 7.3.1.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 6, 2014)
 * 
 * UPDATE (May 13, 2014) - Description added, and comments added
 * to some of the code.
 * UPDATE (May 19, 2014) - Constant variable for the panel resolution
 * has its name changed.
 * UPDATE (May 20, 2014) - All constants declared here have their variable 
 * names changed.
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
public class QuizPanel extends JPanel 
{
	/*
	 * Panel Components        
	 */                     
	public JButton previousQuizQuestionButton;
	public JButton nextQuizQuestionButton;
	public JButton submitAnswersButton;
	
	public JLabel currentQuestionLabel;
	
	public QuizAnsweringComponentsPanel answeringComponentsPanel;
	public QuizViewingPanel quizQuestionViewingPanel;
	public QuizInfoPanel quizInfoPanel;
	
	public JTextField customQuizQuestionNumberTextField;
    
    public QuizPanel() 
    {
        initComponents();
    }
                 
    /**
     * Builds all the components of the quiz panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Size Initialization
    	setPreferredSize(Application.PROGRAM_RESOLUTION);
    	
    	// Component Construction
        answeringComponentsPanel = new QuizAnsweringComponentsPanel();
        quizQuestionViewingPanel = new QuizViewingPanel();
        
        currentQuestionLabel = new JLabel();
        
        previousQuizQuestionButton = new JButton();
        nextQuizQuestionButton = new JButton();
        
        customQuizQuestionNumberTextField = new JTextField();
        
        submitAnswersButton = new JButton();
        
        quizInfoPanel = new QuizInfoPanel();


        
        answeringComponentsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GroupLayout answeringComponentsPanelLayout = new GroupLayout(answeringComponentsPanel);
        answeringComponentsPanel.setLayout(answeringComponentsPanelLayout);
        answeringComponentsPanelLayout.setHorizontalGroup(
            answeringComponentsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        answeringComponentsPanelLayout.setVerticalGroup(
            answeringComponentsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        
        // Component Initialization
        quizQuestionViewingPanel.setBackground(Color.WHITE);
        quizQuestionViewingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GroupLayout quizQuestionViewingPanelLayout = new GroupLayout(quizQuestionViewingPanel);
        quizQuestionViewingPanel.setLayout(quizQuestionViewingPanelLayout);
        quizQuestionViewingPanelLayout.setHorizontalGroup(
            quizQuestionViewingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        quizQuestionViewingPanelLayout.setVerticalGroup(
            quizQuestionViewingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        currentQuestionLabel.setFont(Application.centralFontObject); 
        currentQuestionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        currentQuestionLabel.setText("Question # of #");

        previousQuizQuestionButton.setFont(Application.centralFontObject); 
        previousQuizQuestionButton.setText("<");
        previousQuizQuestionButton.setToolTipText("Goes to the previous question of the quiz.");

        nextQuizQuestionButton.setFont(Application.centralFontObject); 
        nextQuizQuestionButton.setText(">");
        nextQuizQuestionButton.setToolTipText("Goes to the next question of the quiz.");

        customQuizQuestionNumberTextField.setFont(Application.centralFontObject);
        customQuizQuestionNumberTextField.setEditable(false);
        customQuizQuestionNumberTextField.setText("1");
        customQuizQuestionNumberTextField.setHorizontalAlignment(JTextField.CENTER);
        customQuizQuestionNumberTextField.setToolTipText(""
        		+ "<html>Type in the question number you want to look at, then press Enter to go to it.<br/>"
        		+ "<b>NOTE: </b>Unfortunately, no quizzes are implemented in this version of"
        		+ "<br/>the program, so this text field is not editable.</html>");

        submitAnswersButton.setFont(Application.centralFontObject); 
        submitAnswersButton.setText("Submit Answers");
        submitAnswersButton.setToolTipText("Send in all of your quiz answers.");

        quizInfoPanel.setBackground(Color.WHITE);
        quizInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        quizInfoPanel.setToolTipText("Time Limit");

        GroupLayout quizInfoPanelLayout = new GroupLayout(quizInfoPanel);
        quizInfoPanel.setLayout(quizInfoPanelLayout);
        quizInfoPanelLayout.setHorizontalGroup(
            quizInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        quizInfoPanelLayout.setVerticalGroup(
            quizInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        
        // Placing components to desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(quizQuestionViewingPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(answeringComponentsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(previousQuizQuestionButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customQuizQuestionNumberTextField, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextQuizQuestionButton))
                            .addComponent(currentQuestionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitAnswersButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quizInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quizInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quizQuestionViewingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentQuestionLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(previousQuizQuestionButton)
                            .addComponent(nextQuizQuestionButton)
                            .addComponent(customQuizQuestionNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitAnswersButton))
                    .addComponent(answeringComponentsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
    }                        

    /**
	 * Loads the listeners for the panel.
	 */
    public void loadListeners()
    {
    	for (Component component : this.getComponents())
    		if ((component instanceof JButton) || (component instanceof JComboBox))
    			((JButton)component).addActionListener(Application.quizModeListener);
    }
    
    /*
     * This panel was supposed to display the chapter name and the current time
     * limit of this quiz if the user decides to put in a time limit.
     */
    private class QuizInfoPanel extends JPanel
    {
    	private final String PANEL_MESSAGE_1 = "This is where the chapter name and the",
    			PANEL_MESSAGE_2 = "quiz time limit would be displayed.";
    	
    	private QuizInfoPanel()
    	{
    		setBackground(Color.WHITE);
    	}
    	
    	protected void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		
    		g.setFont(g.getFont().deriveFont(10.0f));
    		
    		g.drawString(PANEL_MESSAGE_1, 5, 10);
    		g.drawString(PANEL_MESSAGE_2, 5, 20);
    	}
    }
    
    /*
     * This panel was supposed to display the current question of the quiz. On this
     * version of the quiz, only text is displayed.
     */
    private class QuizViewingPanel extends JPanel
    {
    	private final String PANEL_MESSAGE = "This is where the quiz question would be displayed and where the diagram would be drawn.";
    	
    	private QuizViewingPanel()
    	{
    		setBackground(Color.WHITE);
    	}
    	
    	protected void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		
    		FontMetrics fontMetrics = g.getFontMetrics();
    		g.drawString(PANEL_MESSAGE, getWidth() / 2 - fontMetrics.stringWidth(PANEL_MESSAGE) / 2, 
    				getHeight() / 2 + fontMetrics.getHeight() / 2);
    	}
    }
    
    /*
     * This panel was supposed to hold the answering components for each question
     * of the quiz to be answered. A preview message is displayed.
     */
    private class QuizAnsweringComponentsPanel extends JPanel
    {	
    	private final String PANEL_MESSAGE_1 = "This is where the answering components would be.",
    			PANEL_MESSAGE_2 = "It would consist of one of different assembled panels placed here; a panel with a text field",
    			PANEL_MESSAGE_3 = "for questions involving numbers, and a panel with two radio buttons and a text field",
    			PANEL_MESSAGE_4 = "for a question whether or not a prediction is correct and the theoretical answer",
    			PANEL_MESSAGE_5 = "goes along with the correct prediction.";
    			
    	
    	protected void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		
    		g.setFont(g.getFont().deriveFont(10.0f));
    		
    		g.drawString(PANEL_MESSAGE_1, 5, 10);
    		g.drawString(PANEL_MESSAGE_2, 5, 20);
    		g.drawString(PANEL_MESSAGE_3, 5, 30);
    		g.drawString(PANEL_MESSAGE_4, 5, 40);
    		g.drawString(PANEL_MESSAGE_5, 5, 50);
    		
    	}
    }
}
