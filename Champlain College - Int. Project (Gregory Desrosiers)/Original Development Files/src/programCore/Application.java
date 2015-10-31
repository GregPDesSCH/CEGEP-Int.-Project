/**
 * Desrosiers Mechanics Teaching Tool - Application Build
 * 
 * This is where the entire application is built upon. All the important
 * GUI references are placed right here.
 * 
 * The loading utility that keeps track of the progression of the build
 * and lets the user know of it runs on top of the constructor of this
 * class.
 * 
 * *NOTE*: On this version of the project, all necessary resources are loaded
 * up at once. It's only when the user accesses a certain mode that the program
 * needs to take some time to generate some random numbers.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (Feb 22, 2014 - May 6, 2014)
 * 
 * UPDATE (May 19, 2014) - All constant names have been changed.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programCore;

/*
 *  Resource Packages and Classes
 */

// JAVA SDK Classes and Packages
import java.awt.*;
import java.io.File;

import javax.swing.*;

// Program Packages and Classes
import guiComponents.panels.*;
import guiComponents.menuBars.*;
import guiComponents.panels.simulationControlPanels.chapter2.*;

import listeners.mainListeners.*;
import listeners.menuBarListeners.*;

import programTopicComponents.lectures.*;
import programTopicComponents.simulations.Simulation;
import programTopicComponents.simulations.SimulationControlNames;
import programTopicComponents.simulations.chapter2.*;

import tasks.*;
import tasks.simulations.chapter2.Chapter2Simulation6Task;

import utilities.frames.SimpleCreditsUtility;

// Application Build
public class Application
{	
	/*
	 * GUI Components
	 */
	// Application Frame
	public static JFrame frame;
	
	// Main Panel
	public static JPanel mainPanel;
	
	// Major Panels
	public static TitleScreenPanel titleScreenPanel;
	public static MainMenuPanel mainMenuPanel;
	public static LectureSelectionPanel lectureSelectionPanel;
	public static LecturePanel lecturePanel;
	public static ExerciseSelectionPanel exerciseSelectionPanel;
	public static ExercisesPanel exercisesPanel;
	public static SimulationSelectionPanel simulationSelectionPanel;
	public static SimulationPanel simulationPanel;
	public static QuizSelectionPanel quizSelectionPanel;
	public static QuizPanel quizPanel;
	public static AnimatedCreditsPanel creditsPanel;
	
	// Menu Bars
	public static CentralProgramMenuBar centralProgramMenuBar;
	public static LectureMenuBar lectureMenuBar;
	public static SimulationMenuBar simulationMenuBar;
	public static ExerciseMenuBar exerciseMenuBar;
	public static QuizMenuBar quizMenuBar;
	
	// Associative Components
	public static Chapter2Simulation1ControlPanel chapter2Simulation1ControlPanel;
	public static Chapter2Simulation2ControlPanel chapter2Simulation2ControlPanel;
	public static Chapter2Simulation3ControlPanel chapter2Simulation3ControlPanel;
	public static Chapter2Simulation4ControlPanel chapter2Simulation4ControlPanel;
	public static Chapter2Simulation5ControlPanel chapter2Simulation5ControlPanel;
	public static Chapter2Simulation6ControlPanel chapter2Simulation6ControlPanel;
	
	
	
	
	
	/*
	 * Listeners
	 */
	// Main Listeners
	public static TitleScreenListener titleScreenListener;
	public static MainMenuPanelListener mainMenuPanelListener;
	
	public static LectureSelectionPanelListener lectureSelectionPanelListener;
	public static LectureModeListener lectureModeListener;
	
	public static SimulationSelectionPanelListener simulationSelectionPanelListener;
	
	public static ExerciseSelectionPanelListener exerciseSelectionPanelListener;
	public static ExerciseModeListener exerciseModeListener;
	
	public static QuizSelectionPanelListener quizSelectionPanelListener;
	public static QuizModeListener quizModeListener;
	
	public static AnimatedCreditsPanelListener animatedCreditsPanelListener;
	
	
	// Menu Bar Listeners
	public static ProgramMenuListener programMenuListener;
	public static OptionsMenuListener optionsMenuListener;
	
	public static LectureMenuListener lectureMenuListener;
	public static SimulationMenuListener simulationMenuListener;
	public static ExerciseMenuListener exerciseMenuListener;
	public static QuizMenuListener quizMenuListener;
	
	
	
	
	/*
	 * Tracker Variables
	 */
	
	// Panel Names (these are for the card layout to recognize)
	public final static String TITLE_SCREEN_NAME = "title_screen";
	public final static String MAIN_MENU_NAME = "main_menu";
	public final static String LECTURE_SELECT_NAME = "lecture_select";
	public final static String LECTURE_MODE_NAME = "lecture_mode";
	public final static String SIMULATION_SELECT_NAME = "simulation_select";
	public final static String SIMULATION_MODE_NAME = "simulation_mode";
	public final static String EXERCISES_SELECT_NAME = "exercises_select";
	public final static String EXERCISES_MODE_NAME = "exercises_mode";
	public final static String QUIZ_SELECT_NAME = "quiz_select";
	public final static String QUIZ_MODE_NAME = "quiz_mode";
	public final static String CREDITS_PANEL_NAME = "credits";
	
	// Current Panel Name
	public static String currentPanelName = TITLE_SCREEN_NAME;
	
	// Current Lecture
	public static Lecture currentLecture;
	
	// Current Simulation
	public static Simulation currentSimulation;
	
	
	
	
	/*
	 * Subject Material and Subject Material Components
	 */
	
	// Lecture Objects
	public static PrologueLecture prologueLectureObject;
	public static Chapter2Section1Lecture chapter2Section1LectureObject;
	public static Chapter2Section2Lecture chapter2Section2LectureObject;
	public static Chapter2Section3Lecture chapter2Section3LectureObject;
	public static Chapter2Section4Lecture chapter2Section4LectureObject;
	public static Chapter2Section5Lecture chapter2Section5LectureObject;
	public static Chapter2Section6Lecture chapter2Section6LectureObject;
	public static Chapter2FullChapterLecture chapter2FullChapterLectureObject;
	
	// Simulation Objects
	public static Chapter2Simulation1 chapter2Simulation1Object;
	public static Chapter2Simulation2 chapter2Simulation2Object;
	public static Chapter2Simulation3 chapter2Simulation3Object;
	public static Chapter2Simulation4 chapter2Simulation4Object;
	public static Chapter2Simulation5 chapter2Simulation5Object;
	public static Chapter2Simulation6 chapter2Simulation6Object;
	
	
	
	/*
	 * Tasks & Thread Managers
	 */
	// Tasks
	public static MainMenuTask mainMenuTask;
	public static CreditsAnimationTask creditsTask;
	
	
	// Simulation Task
	public static Chapter2Simulation6Task chapter2Simulation6Task;
	
	// Thread Managers
	public static Thread mainMenuThread;
	public static Thread creditsThread;
	public static Thread simulationThread;
	
	
	
	
	
	/*
	 * Additional Resources and Objects
	 */
	// Font Objects
	public static Font centralFontObject;
	public static Font modeLabelFontObject;
	public static Font exerciseModeFontObject;
	public static Font dialogLabelFontObject;
	public static Font simulationModeControlPanelFontObject;
	
	// Application Size (for all major components)
	public final static Dimension PROGRAM_RESOLUTION = new Dimension(640, 480);
	
	// Dialog Label
	public static JLabel dialogLabel;
	
	// Performance Utility
	public static ApplicationPerformanceUtility performanceUtility;
	
	// Simple Credits Utility
	public static SimpleCreditsUtility simpleCreditsUtility;
	
	
	
	
	/*
	 * Program Loading Phase Properties
	 */
	
	// Load Complete Flag
	public static boolean loadComplete = false;
	
	// Current Loading Stage (to let the loading utility calculuate the progression)
	private Byte currentLoadingStage = 1;
	
	
	
	/*
	 * 	Runtime Manager
	 */
	public static Runtime garbageCollector;
	
	
	
	
	public Application()
	{	
		LoadingUtility.progressMessage = "Building Window... (" + currentLoadingStage + " / 11)";
		frame = new JFrame();
		
		
		
		/**
		 * Additional Resource Creation
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Building subresources... (" + currentLoadingStage + " / 11)";
		
		/*
		 * Performance Utility Creation
		 */
		
		performanceUtility = new ApplicationPerformanceUtility();
		
		/*
		 *  Font Initialization
		 *  (Some fonts are created outside the try-and-catch block because JAVA
		 *  supports font expansion or minimization without having to use a file.)
		 *  
		 *  This is done before the GUI can be built, because the constructors of
		 *  the panels rely on these font objects; the font family used for the
		 *  individual components will only be Arial if this is not loaded.
		 */
		try
		{
			centralFontObject = Font.createFont(Font.PLAIN, new File("Resource Files/Fonts/tahoma.ttf")).deriveFont(13.0f);
			modeLabelFontObject = Font.createFont(Font.PLAIN, new File("Resource Files/Fonts/arial.ttf")).deriveFont(21.0f);
			dialogLabelFontObject = Font.createFont(Font.PLAIN, new File("Resource Files/Fonts/consola.ttf")).deriveFont(12.0f);
			simulationModeControlPanelFontObject = Font.createFont(Font.PLAIN, new File("Resource Files/Fonts/tahoma.ttf")).deriveFont(10.0f);
		}
		catch (Exception ex)
		{
			centralFontObject = new Font("Arial", Font.PLAIN, 13);
			modeLabelFontObject = new Font("Arial", Font.PLAIN, 21);
			dialogLabelFontObject = new Font("Arial", Font.BOLD, 10);
			simulationModeControlPanelFontObject = new Font("Arial", Font.PLAIN, 10);
		}
		
		exerciseModeFontObject = centralFontObject.deriveFont(12.0f);
		
		/*
		 * Credits Utility Creation
		 */
		
		simpleCreditsUtility = new SimpleCreditsUtility();
		
		/*
		 * Dialog Label
		 */
		
		dialogLabel = new JLabel();
		dialogLabel.setFont(dialogLabelFontObject);
		dialogLabel.setHorizontalAlignment(JLabel.CENTER);
		
		/*
		 * Dialog Label Text Initialization
		 */
		
		DialogLabelText.initializeDialogMessages();
		
		
		
		
		
		
		
		/**
		 *  GUI Build - Panels
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Building panels... (" + currentLoadingStage + " / 11)";
		
		mainPanel = new JPanel(new CardLayout());
		
		titleScreenPanel = new TitleScreenPanel();
		mainMenuPanel = new MainMenuPanel();
		
		lectureSelectionPanel = new LectureSelectionPanel();
		lecturePanel = new LecturePanel();
		
		exerciseSelectionPanel = new ExerciseSelectionPanel();
		exercisesPanel = new ExercisesPanel();
		
		simulationSelectionPanel = new SimulationSelectionPanel();
		simulationPanel = new SimulationPanel();
		
		quizSelectionPanel = new QuizSelectionPanel();
		quizPanel = new QuizPanel();
		
		creditsPanel = new AnimatedCreditsPanel();
		
		
		
		
		
		

		
		
		/**
		 *  GUI Build - Menu Bars
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Building menu bars... (" + currentLoadingStage + " / 11)";
		
		centralProgramMenuBar = new CentralProgramMenuBar();
		lectureMenuBar = new LectureMenuBar();
		simulationMenuBar = new SimulationMenuBar();
		exerciseMenuBar = new ExerciseMenuBar();
		quizMenuBar = new QuizMenuBar();
		
		
		
		
		
		
		
		/**
		 * 	GUI Build - Associative Components
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Building associative GUI components... (" + currentLoadingStage + " / 11)";
		
		chapter2Simulation1ControlPanel = new Chapter2Simulation1ControlPanel();
		chapter2Simulation2ControlPanel = new Chapter2Simulation2ControlPanel();
		chapter2Simulation3ControlPanel = new Chapter2Simulation3ControlPanel();
		chapter2Simulation4ControlPanel = new Chapter2Simulation4ControlPanel();
		chapter2Simulation5ControlPanel = new Chapter2Simulation5ControlPanel();
		chapter2Simulation6ControlPanel = new Chapter2Simulation6ControlPanel();
		
		
		
		
		
		
		
		
		/**
		 * 	Listeners - Main Listeners Construction
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Building listeners... (" + currentLoadingStage + " / 11)";
		
		titleScreenListener = new TitleScreenListener();
		mainMenuPanelListener = new MainMenuPanelListener();
		
		lectureSelectionPanelListener = new LectureSelectionPanelListener();
		lectureModeListener = new LectureModeListener();
		
		simulationSelectionPanelListener = new SimulationSelectionPanelListener();
		
		exerciseSelectionPanelListener = new ExerciseSelectionPanelListener();
		exerciseModeListener = new ExerciseModeListener();
		
		quizSelectionPanelListener = new QuizSelectionPanelListener();
		quizModeListener = new QuizModeListener();
		
		animatedCreditsPanelListener = new AnimatedCreditsPanelListener();
		
		
		
		
		
		
		
		
		/**
		 * 	Listeners - Menu Bars Listeners Construction
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Building menu bar listeners... (" + currentLoadingStage + " / 11)";
		
		programMenuListener = new ProgramMenuListener();
		optionsMenuListener = new OptionsMenuListener();
		
		lectureMenuListener = new LectureMenuListener();
		simulationMenuListener = new SimulationMenuListener();
		exerciseMenuListener = new ExerciseMenuListener();
		quizMenuListener = new QuizMenuListener();
		
		
		
		
		
		
		
		
		/**
		 * 	Listeners Assembly - Main Listeners
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Assembling listeners... (" + currentLoadingStage + " / 11)";
		
		frame.addKeyListener(titleScreenListener);
		mainMenuPanel.loadListeners();
		
		lectureSelectionPanel.loadListeners();
		lecturePanel.loadListeners();
		
		simulationSelectionPanel.loadListeners();
		
		exerciseSelectionPanel.loadListeners();
		exercisesPanel.loadListeners();
		
		quizSelectionPanel.loadListeners();
		quizPanel.loadListeners();
		
		creditsPanel.loadListeners();
		
		
		
		
		
		
		
		
		/**
		 *	GUI Assembly
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Assembling GUI... (" + currentLoadingStage + " / 11)";
		
		mainPanel.add(titleScreenPanel, TITLE_SCREEN_NAME);
		mainPanel.add(mainMenuPanel, MAIN_MENU_NAME);
		
		mainPanel.add(lectureSelectionPanel, LECTURE_SELECT_NAME);
		mainPanel.add(lecturePanel, LECTURE_MODE_NAME);
		
		mainPanel.add(simulationSelectionPanel, SIMULATION_SELECT_NAME);
		mainPanel.add(simulationPanel, SIMULATION_MODE_NAME);
		
		mainPanel.add(exerciseSelectionPanel, EXERCISES_SELECT_NAME);
		mainPanel.add(exercisesPanel, EXERCISES_MODE_NAME);
		
		mainPanel.add(quizSelectionPanel, QUIZ_SELECT_NAME);
		mainPanel.add(quizPanel, QUIZ_MODE_NAME);
		
		mainPanel.add(creditsPanel,  CREDITS_PANEL_NAME);
		
		
		frame.add(mainPanel);
		
		
		
		
		
		
		
		
		
		/**
		 * Subject Material Construction
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Loading subject material... (" + currentLoadingStage + " / 11)";
		
		// Lectures
		prologueLectureObject = new PrologueLecture();
		chapter2Section1LectureObject = new Chapter2Section1Lecture();
		chapter2Section2LectureObject = new Chapter2Section2Lecture();
		chapter2Section3LectureObject = new Chapter2Section3Lecture();
		chapter2Section4LectureObject = new Chapter2Section4Lecture();
		chapter2Section5LectureObject = new Chapter2Section5Lecture();
		chapter2Section6LectureObject = new Chapter2Section6Lecture();
		chapter2FullChapterLectureObject = new Chapter2FullChapterLecture();
		
		// Simulations
		chapter2Simulation1Object = new Chapter2Simulation1();
		chapter2Simulation2Object = new Chapter2Simulation2();
		chapter2Simulation3Object = new Chapter2Simulation3();
		chapter2Simulation4Object = new Chapter2Simulation4();
		chapter2Simulation5Object = new Chapter2Simulation5();
		chapter2Simulation6Object = new Chapter2Simulation6();
		
		
		
		
		
		
		
		
		
		/**
		 *  Tasks & Thread Pool Creation
		 */
		currentLoadingStage++;
		LoadingUtility.progressMessage = "Initializing program... (" + currentLoadingStage + " / 11)";
		
		mainMenuTask = new MainMenuTask();
		creditsTask = new CreditsAnimationTask();
		
		
		
		
		
		
		
		
		
		/**
		 *  Component Initialization
		 */
		SimulationControlNames.initializeNames();
		simulationPanel.loadSimulationControlPanels();
		
		frame.setJMenuBar(centralProgramMenuBar);
		
		// Sets the text for the first simulation selected.
		simulationSelectionPanel.selectedSimulationTextArea
			.setText(Chapter2Simulation1.simulationDescription);
		
		currentSimulation = chapter2Simulation1Object;
		
		lectureSelectionPanelListener.setSelectedLectureTextArea();
		exerciseSelectionPanelListener.setSelectedExercisesTextArea();
		
		
		
		
		
		
		
		/**
		 * 	Final Frame Initialization
		 */
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("The Desrosiers Mechanics Teaching Tool - Lite Version");
		frame.setResizable(false);
		
		frame.pack();
		frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - frame.getWidth() / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - frame.getHeight() / 2);
		
		loadComplete = true;
		currentLoadingStage = null;
	}
	
	
	/**
	 * This method is called to display a dialog asking the user to see if they
	 * are sure they want to quit. If so, it forces the program to be shut down
	 * by the System class.
	 */
	public static void callingToQuitApplication()
	{
		dialogLabel.setText(DialogLabelText.quitApplicationMessage);
		
		byte selectedButton = (byte)
				(JOptionPane.showConfirmDialog(null, dialogLabel, "Quit Program",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
		
		if (selectedButton == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	
	/**
	 * This method reinitializes the main menu thread, which is the thread
	 * responsible for showing the user the current time and date in the
	 * Main Menu.
	 */
	public static void restartMainMenuThread()
	{
		Application.mainMenuTask = new MainMenuTask();
		
		Application.garbageCollector.gc();
		
		Application.mainMenuThread = new Thread(Application.mainMenuTask);
		Application.mainMenuThread.start();
	}
	
	
	/**
	 * This method stops the main menu simply by forcing the reference pointer
	 * of the main menu thread to not point an object anymore. Even though this
	 * method does nothing to the task, the task shuts down automatically because
	 * the loop in the text stops as soon as the user is no longer in the Main Menu.
	 */
	public static void stopMainMenuThread()
	{
		Application.mainMenuThread = null;
	}
}
