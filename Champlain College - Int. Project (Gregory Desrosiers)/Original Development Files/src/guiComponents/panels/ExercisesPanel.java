/**
 * Desrosiers Mechanics Teaching Tool - Exercises Panel
 * 
 * This rough GUI panel represents a general build to what the
 * user would see when he/she is in Exercise Mode. It's not complete
 * because only one exercise is implemented, but most of the build
 * has been done anyway because it allows the user to see what the
 * full Exercise Mode would look like.
 * 
 * Created using NetBeans IDE 7.3.1.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 27, 2014 - May 7, 2014)
 * 
 * UPDATE (May 13, 2014) - Descriptions added of this class and the
 * inner classes of the exercise demonstration answering components
 * panel and the exercise demonstration viewing panel.
 * UPDATE (May 19, 2014) - Constant variable for the panel resolution
 * has its name changed.
 * UPDATE (May 20, 2014)- All constant variables have their name changed.
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
import java.awt.event.*;

import javax.swing.border.*;

// Interaction Class
import programCore.Application;
import programCore.DialogLabelText;

@SuppressWarnings("serial")
public class ExercisesPanel extends JPanel 
{
	/*
	 * Panel Components        
	 */                     
    public JButton previousExerciseButton;
    public JButton nextExerciseButton;
    
    public JLabel currentExerciseLabel;
    public JLabel chapterLabel;
    public JLabel actualAnswerLabel;
    public JLabel sectionLabel;
    
    public JPanel answeringComponentsPanel;
    public ExerciseAnsweringComponentsPanel noAnsweringComponentsPanel;
    public ExerciseAnsweringComponentsDemonstrationPanel demoComponentsPanel;
    public JPanel exerciseViewingPanel;
    public ExerciseViewingPanel noQuestionViewingPanel;
    public ExerciseDemoViewingPanel demoViewingPanel;
    
    public JTextField exerciseNumberTextField;
    public JTextField actualAnswerTextField;
    
    // Actual Answer Text Field
    public static Border actualAnswerTextFieldBorder;
    
    // Strings for Viewing Panel and Answering Components Panel
    public final static String NO_ANSWERING_COMPONENTS_PANEL_NAME = "no_answering_components_panel";
    public final static String DEMO_COMPONENTS_PANEL_NAME = "demo_components_panel";
    
    public final static String NO_QUESTION_VIEWING_PANEL_NAME = "no_question_viewing_panel";
    public final static String DEMO_VIEWING_PANEL_NAME = "demo_viewing_panel";
    
    public ExercisesPanel() 
    {
        initComponents();
    }
       
    /**
     * Builds all the components of the exercises panel and initializes
     * them accordingly.
     */
    private void initComponents() 
    {
    	// Size Initialization
    	setPreferredSize(Application.PROGRAM_RESOLUTION);
    	
    	
    	
    	
    	
    	// Component Construction
        answeringComponentsPanel = new JPanel();
        
        noAnsweringComponentsPanel = new ExerciseAnsweringComponentsPanel();
        demoComponentsPanel = new ExerciseAnsweringComponentsDemonstrationPanel();
    
        chapterLabel = new JLabel();
        
        exerciseViewingPanel = new JPanel();
        noQuestionViewingPanel = new ExerciseViewingPanel();
        demoViewingPanel = new ExerciseDemoViewingPanel();
        
        currentExerciseLabel = new JLabel();
        
        previousExerciseButton = new JButton();
        nextExerciseButton = new JButton();
        
        exerciseNumberTextField = new JTextField();
        
        actualAnswerLabel = new JLabel();
        
        actualAnswerTextField = new JTextField();
        
        sectionLabel = new JLabel();

        
        
        
        
        
        // Setting border and layout of the answering components panel
        answeringComponentsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GroupLayout answeringComponentsPanelLayout = new GroupLayout(answeringComponentsPanel);
        answeringComponentsPanel.setLayout(answeringComponentsPanelLayout);
        answeringComponentsPanelLayout.setHorizontalGroup(
            answeringComponentsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        answeringComponentsPanelLayout.setVerticalGroup(
            answeringComponentsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        
        answeringComponentsPanel.setLayout(new CardLayout());
        answeringComponentsPanel.add(noAnsweringComponentsPanel, NO_ANSWERING_COMPONENTS_PANEL_NAME);
        answeringComponentsPanel.add(demoComponentsPanel, DEMO_COMPONENTS_PANEL_NAME);
        
        
        

        // Component Initialization  
        chapterLabel.setFont(Application.exerciseModeFontObject); 
        chapterLabel.setText("Chapter #");

        

        GroupLayout exerciseViewingPanelLayout = new GroupLayout(exerciseViewingPanel);
        exerciseViewingPanel.setLayout(exerciseViewingPanelLayout);
        exerciseViewingPanelLayout.setHorizontalGroup(
            exerciseViewingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        exerciseViewingPanelLayout.setVerticalGroup(
            exerciseViewingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        exerciseViewingPanel.setLayout(new CardLayout());
        exerciseViewingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        exerciseViewingPanel.add(demoViewingPanel, DEMO_VIEWING_PANEL_NAME);
        exerciseViewingPanel.add(noQuestionViewingPanel, NO_QUESTION_VIEWING_PANEL_NAME);
        

        currentExerciseLabel.setFont(Application.exerciseModeFontObject); 
        currentExerciseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        currentExerciseLabel.setText("Exercise # of #");

        previousExerciseButton.setFont(Application.exerciseModeFontObject); 
        previousExerciseButton.setText("<");
        previousExerciseButton.setToolTipText("Go to the previous exercise.");

        nextExerciseButton.setFont(Application.exerciseModeFontObject); 
        nextExerciseButton.setText(">");
        nextExerciseButton.setToolTipText("Go to the next exercise.");

        exerciseNumberTextField.setFont(Application.exerciseModeFontObject); 
        exerciseNumberTextField.setEditable(false);
        exerciseNumberTextField.setText("1");
        exerciseNumberTextField.setHorizontalAlignment(JTextField.CENTER);
        exerciseNumberTextField.setToolTipText(""
        		+ "<html>Type in a custom exercise number here, then press Enter to go to it.<br/>"
        		+ "<b>NOTE: </b>Unfortunately, no exercises are implemented in this version of"
        		+ "<br/>the program, so this text field is not editable.</html>");

        actualAnswerLabel.setFont(Application.exerciseModeFontObject); 
        actualAnswerLabel.setText("Actual Answer:");

        actualAnswerTextField.setEditable(false);
        actualAnswerTextField.setFont(Application.exerciseModeFontObject); 
        actualAnswerTextField.setText("actualAnswerTextField");
        actualAnswerTextFieldBorder = actualAnswerTextField.getBorder();

        sectionLabel.setFont(Application.exerciseModeFontObject); 
        sectionLabel.setText("sectionLabel");

        
        
        
        
        
        // Placing components in desired positions
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(exerciseViewingPanel, GroupLayout.Alignment.TRAILING, 620, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(answeringComponentsPanel, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(previousExerciseButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exerciseNumberTextField, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextExerciseButton))
                            .addComponent(currentExerciseLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(actualAnswerLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(actualAnswerTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                            .addComponent(sectionLabel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                            .addComponent(chapterLabel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chapterLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sectionLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(exerciseViewingPanel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(answeringComponentsPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentExerciseLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(previousExerciseButton)
                            .addComponent(nextExerciseButton)
                            .addComponent(exerciseNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(actualAnswerLabel)
                    .addComponent(actualAnswerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
    }     
    
    /**
	 * Loads the listeners for the panel.
	 */
    public void loadListeners()
    {
    	for (Component component : getComponents())
    	{
    		if (component instanceof JButton)
    			((JButton)component).addActionListener(Application.exerciseModeListener);
    		else if (component == exerciseNumberTextField)
    			((JTextField)component).addActionListener(Application.exerciseModeListener);
    	}
    }
    
    // It was supposed to be a panel to hold answering components for exercises,
    // but because of development issues and time constraints, this panel now
    // only displays text.
    public class ExerciseAnsweringComponentsPanel extends JPanel
    {	
    	private final String PANEL_MESSAGE_1 = "This is where the answering components would be.",
    			PANEL_MESSAGE_2 = "It would consist of one of different assembled panels placed here; a panel with two radio buttons",
    			PANEL_MESSAGE_3 = "true and false questions, a panel with a text field for questions with numbers, and a panel",
    			PANEL_MESSAGE_4 = "with between three to five radio buttons for multiple choice questions.";
    			
    	
    	protected void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		
    		g.setFont(g.getFont().deriveFont(10.0f));
    		
    		g.drawString(PANEL_MESSAGE_1, 5, 10);
    		g.drawString(PANEL_MESSAGE_2, 5, 20);
    		g.drawString(PANEL_MESSAGE_3, 5, 30);
    		g.drawString(PANEL_MESSAGE_4, 5, 40);
    		
    	}
    }
    
    /*
     *  This is only a demonstration panel for Exercise Mode, because only
     *  one exercise is implemented in this version of the project, since there
     *  were time constraints and problems occured during development.
     *  
     *  This is complete with a radio button listener; because it is so small
     *  and is only associated with this panel, the listener class is not created
     *  in the 'listeners' package.
     */
    public class ExerciseAnsweringComponentsDemonstrationPanel extends JPanel
    {
    	JRadioButton answerARadioButton;
    	JRadioButton answerBRadioButton;
    	JRadioButton answerCRadioButton;
    	
    	private ExerciseAnsweringComponentsDemonstrationPanel()
    	{
    		answerARadioButton = new JRadioButton("A");
    		answerBRadioButton = new JRadioButton("B");
    		answerCRadioButton = new JRadioButton("C");
    		
    		answerARadioButton.addActionListener(new RadioButtonListener());
    		answerBRadioButton.addActionListener(new RadioButtonListener());
    		answerCRadioButton.addActionListener(new RadioButtonListener());
    		
    		add(answerARadioButton);
    		add(answerBRadioButton);
    		add(answerCRadioButton);
    	}
    	
    	private class RadioButtonListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			if (e.getSource() == answerARadioButton || e.getSource() == answerCRadioButton)	
    				displayWrongAnswerDialog();
    			else if (e.getSource() == answerBRadioButton)
    				displayRightAnswerDialog();
    		}
    		
    		public void displayWrongAnswerDialog()
    		{
    			Application.dialogLabel.setText(DialogLabelText.exerciseAnswerIncorrectMessage);
    			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Incorrect Answer", JOptionPane.INFORMATION_MESSAGE);
    			answerARadioButton.setSelected(false);
    			answerCRadioButton.setSelected(false);
    		}
    		
    		public void displayRightAnswerDialog()
    		{
    			Application.dialogLabel.setText(DialogLabelText.exerciseAnswerCorrectMessage);
    			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Correct Answer", JOptionPane.INFORMATION_MESSAGE);
    			answerBRadioButton.setSelected(false);
    		}
    	}
    }
    
    // It was supposed to be a panel to paint exercise diagrams, but because of development 
    // issues and time constraints, this panel now only displays text.
    public class ExerciseViewingPanel extends JPanel
    {
    	private final String PANEL_MESSAGE = "This is where a diagram of the exercise would be drawn.";
    	
    	private ExerciseViewingPanel()
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
     *  This is only a demonstration viewing panel for Exercise Mode, because only
     *  one exercise is implemented in this version of the project, since there
     *  were time constraints and problems occured during development.
     *  
     *  Technically, this panel should not be there because only one panel is necessary
     *  for Exercise Mode, but it's there as a simple way to display the exercise since
     *  there was a shortage of time.
     */
    public class ExerciseDemoViewingPanel extends JPanel
    {
    	private final String PANEL_MESSAGE = "Which one of the following ratios is responsible for cos \u03b8?";
    	private final String PANEL_MESSAGE_2 = "A. A(y) / A(x)";
    	private final String PANEL_MESSAGE_3 = "B. A(x) / ||A||";
    	private final String PANEL_MESSAGE_4 = "C. A(y) / ||A||";
    	
    	
    	private ExerciseDemoViewingPanel()
    	{
    		setBackground(Color.WHITE);
    	}
    	
    	protected void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		
    		FontMetrics fontMetrics = g.getFontMetrics();
    		g.drawString(PANEL_MESSAGE, getWidth() / 2 - fontMetrics.stringWidth(PANEL_MESSAGE) / 2, 
    				getHeight() / 2 - fontMetrics.getHeight());
    		g.drawString(PANEL_MESSAGE_2, getWidth() / 2 - fontMetrics.stringWidth(PANEL_MESSAGE) / 2,
    				getHeight() / 2);
    		g.drawString(PANEL_MESSAGE_3, getWidth() / 2 - fontMetrics.stringWidth(PANEL_MESSAGE) / 2,
    				getHeight() / 2 + fontMetrics.getHeight());
    		g.drawString(PANEL_MESSAGE_4, getWidth() / 2 - fontMetrics.stringWidth(PANEL_MESSAGE) / 2,
    				getHeight() / 2 + 2 * fontMetrics.getHeight());
    	}
    }
}
