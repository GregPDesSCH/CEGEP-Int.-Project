/**
 * Desrosiers Mechanics Teaching Tool
 * Dialog Label Text
 * 
 * This class holds all the text the program needs to deliver information
 * regarding a particular event the program will not accept, or is not
 * able to process because the feature is not implemented.
 * 
 * The text is stored here to organize the code and let the program interact
 * by means of object-oriented programming. Essentially, it's an interaction
 * class where the program can access the strings.
 * 
 * @author Gregory Desrosiers
 * @version 1.0 (April 24, 2014 - May 7, 2014)
 * 
 * *NOTE*: Even though the text variables are technically not constants
 * as they should, the program does not change the text of those variables 
 * at all.
 * 
 * DISCLAIMER: You may use this class at anytime, but be sure to credit me 
 * first as a programmer.
 * 
 * © 2014 Gregory Desrosiers. All rights reserved.
 */

// Package Location
package programCore;

public class DialogLabelText 
{
	public static String 
			
			// About Dialog Message
			aboutDialogMessage, 
			
			
	
			// Unimplemented Features Messages
			simulationUnimplementedMessage,
			exercisesModeUnimplementedMessage,
			quizModeUnimplementedMessage,
			simulationUnimplementedMessage2,
			
			musicFeaturesUnimplementedMessage,
			
			exerciseModeGoToPreviousExerciseUnimplementedMessage,
			exerciseModeGoToNextExerciseUnimplementedMessage,
			exerciseModeGoToFirstExerciseUnimplementedMessage,
			exerciseModeGoToLastExerciseUnimplementedMessage,
			
			quizModeGoToPreviousQuestionUnimplementedMessage,
			quizModeGoToNextQuestionUnimplementedMessage,
			quizModeGoToFirstQuestionUnimplementedMessage,
			quizModeGoToLastQuestionUnimplementedMessage,
	
			
			
			// In-Lecture Messages
			lectureModeAlreadyOnFirstPageMessage,
			lectureModeAlreadyOnLastPageMessage,
			lectureModeCannotGoToNextPageMessage,
			lectureModeCannotGoToPreviousPageMessage,
			lectureModeCannotGoToSpecifiedPageMessage,
			lectureModeCannotGoToSpecifiedPageMessage2,
			lectureModeCustomPageNumberTextFieldEntryEmpty,
			
			
			
			// In-Simulation Messages
			simulationAnimationUnsupportedMessage,
			simulationAnimationUnsupportedMessage2,
			simulationEmptyEntriesMessage1,
			simulationEmptyEntriesMessage2,
			simulationAlreadyStoppedMessage,
			simulationAlreadyResetMessage,
			
			
			
			// Demo Exercise Messages
			exerciseAnswerCorrectMessage,
			exerciseAnswerIncorrectMessage,
			
			
			
			// Chapter 2 - Simulation 1 Messages
			vectorXComponentTooBigMessage,
			vectorXCoordinateOutOfRangeLeftSideMessage,
			vectorXCoordinateOutOfRangeRightSideMessage,
			vectorYComponentTooBigMessage,
			vectorYCoordinateOutOfRangeTopSideMessage,
			vectorYCoordinateOutOfRangeBottomSideMessage,
			scalarOrFactorIsZeroMessage,
			scalarOrFactorTooLargeMessage,
			directionOutOfRangeMessage,
			
			
			
			// Chapter 2 - Simulation 4 Message
			drawTrajectoryNotAvailableMessage,
			
			
			
			
			// Chapter 2 - Simulation 6 Messages
			radiusTooSmallMessage,
			radiusTooBigMessage,
			tangentialVelocityTooHighMessage,
			tangentialVelocityTooLowMessage,
			tangentialAccelerationTooHighMessage,
			tangentialAccelerationTooLowMessage,
			
			
			
			// Change Messages
			changeLectureMessage,
			changeSimulationMessage,
			changeExerciseChapterMessage,
			changeQuizMessage,
			
			
			
			// Quit Messages
			quitApplicationMessage,
			quitLectureModeMessage,
			quitSimulationModeMessage,
			quitExerciseModeMessage,
			quitQuizModeMessage,
			
			
			
			// Additional Messages
			oneChapterSectionNotAvailableMessage;
	
	
	/**
	 * This method sets the corresponding dialog messages needed for all possible
	 * events in the application that a dialog must be displayed with an appropriate
	 * message.
	 */
	public static void initializeDialogMessages()
	{
		// About Dialog Message
		aboutDialogMessage = "<html><h3>The Desrosiers Mechanics Teaching Tool - Lite Version</h3>"
				+ "<div>Created and Developed by Gregory Desrosiers<br/><br/>"
				+ "Integrative Project in Computer Science and Mathematics (420-204-RE)<br/><br/>"
				+ "Producer & Director: Amin Ranj Bar<br/>"
				+ "Assistants for Programmer: Marie Pupo & Emily O'Donnell<br/>"
				+ "Assistant Producers: Samia Ramadan, Jennifer Liutec, Robert Bierman<br/>"
				+ "Senior Producer & College Program Director: Pedro Cabrejo<br/><br/>"
				+ "Executive Producer: Don Shewan</div><br/><br/>"
				+ "<div>© 2014 Champlain Regional College. Production © 2014 Champlain College Saint-Lambert. Source Code<br/>"
				+ "and Project Design © 2014 Gregory Desrosiers. The Champlain Regional College logo, the Champlain College<br/>"
				+ "Saint-Lambert logo, the affiliates, and the names, are trademarks and/or copyrighted material of their<br/>"
				+ "respectful owners. All rights reserved.<br/><br/>"
				+ "™ & © 2014 Oracle Corporation. JAVA, the JAVA logo, and its affilates, are trademarks and/or copyrighted<br/>"
				+ "material of Oracle. All rights reserved.<br/><br/>"
				+ "Developed using Eclipse Kepler and NetBeans 7.3.1 IDEs.<br/>"
				+ "Eclipse Kepler © Eclipse contributors and others 2005, 2013.  All rights reserved.<br/>"
				+ "NetBeans 7.3.1 IDE © 2013 Oracle Corporation. All rights reserved.</div></html>";
		
		
		
		
		
		
		
		// Unimplemented Features Message
		simulationUnimplementedMessage = "<html>Because of time constraints in building this project, unfortunately this simulation<br/>"
				+ "is not available. However, there is still something you can see out of this mode. Would you like to view<br/>"
				+ "it anyway?</html>";
		
		exercisesModeUnimplementedMessage = "<html>Because of time constraints in building this project, unfortunately Exercise Mode<br/>"
				+ "is not available. However, there is still something you can see out of this mode. Would you like to view<br/>"
				+ "it anyway?</html>";
		
		quizModeUnimplementedMessage = "<html>Because of time constraints in building this project, unfortunately Quiz Mode<br/>"
				+ "is not available. However, there is still something you can see out of this mode. Would you like to view<br/>"
				+ "it anyway?</html>";
		
		simulationUnimplementedMessage2 = "There is no animation in this simulation because the simulation is not implemented.";
		
		
		
		musicFeaturesUnimplementedMessage = "<html>Because of time constraints, unfortunately there is no music player in<br/>"
				+ "this version of the program.</html>";
		
		
		
		exerciseModeGoToPreviousExerciseUnimplementedMessage = "<html>"
				+ "You can't go to the previous exercise because the exercises are not implemented<br/>"
				+ "in this version of the program.</html>";
		
		exerciseModeGoToNextExerciseUnimplementedMessage = "<html>"
				+ "You can't go to the next exercise because the exercises are not implemented<br/>"
				+ "in this version of the program.</html>";
		
		exerciseModeGoToFirstExerciseUnimplementedMessage = "<html>"
				+ "You can't go to the first exercise because the exercises are not implemented<br/>"
				+ "in this version of the program.</html>";
		
		exerciseModeGoToLastExerciseUnimplementedMessage = "<html>"
				+ "You can't go to the last exercise because the exercises are not implemented<br/>"
				+ "in this version of the program.</html>";
		
		
		
		quizModeGoToPreviousQuestionUnimplementedMessage = "<html>"
				+ "You can't go to the previous question because quizzes are not implemented<br/>"
				+ "in this version of the program.</html>";
		
		quizModeGoToNextQuestionUnimplementedMessage = "<html>"
				+ "You can't go to the next question because quizzes are not implemented<br/>"
				+ "in this version of the program.</html>";
		
		quizModeGoToFirstQuestionUnimplementedMessage = "<html>"
				+ "You can't go to the first question because quizzes are not implemented<br/>"
				+ "in this version of the program.</html>";
		
		quizModeGoToLastQuestionUnimplementedMessage = "<html>"
				+ "You can't go to the last question because quizzes are not implemented<br/>"
				+ "in this version of the program.</html>";
		
		
		
		
		
		
		
		
		// In-Lecture Messages
		lectureModeAlreadyOnFirstPageMessage = "You are already on the first page of the lecture.";
		
		lectureModeAlreadyOnLastPageMessage = "You are already on the last page of the lecture.";
		
		lectureModeCannotGoToNextPageMessage = "<html>You cannot go to the next page of the lecture.<br/>"
				+ lectureModeAlreadyOnLastPageMessage +  "</html>";
		
		lectureModeCannotGoToPreviousPageMessage = "<html>You cannot go to the previous page of the lecture.<br/>"
				+ lectureModeAlreadyOnFirstPageMessage +  "</html>";
		
		lectureModeCannotGoToSpecifiedPageMessage = "<html>Invalid entry; page 0 does not exist. Please enter a number<br/>"
				+ "between 1 and the page number of the last lecture page.</html>";
		
		lectureModeCannotGoToSpecifiedPageMessage2 = "<html>Invalid entry; you can't enter a page number that is bigger than <br/>"
				+ "the page number of the last lecture page. Please enter a number<br/>"
				+ "between 1 and the page number of the last lecture page.</html>";
		
		lectureModeCustomPageNumberTextFieldEntryEmpty = "<html>You have an empty entry for the custom page number text field.<br/>"
				+ "Please enter a number between 1 and the page number of the last lecture page.</html>";
		
		
		
		
		
		
		
		
		
		// In-Simulation Messages
		simulationAnimationUnsupportedMessage = "You cannot run this simulation because the animation is unsupported.";
		
		simulationAnimationUnsupportedMessage2 = "You cannot stop this simulation because the animation is unsupported.";
		
		simulationEmptyEntriesMessage1 = "<html>There is one text field entry that is empty.<br/>Please enter an appropriate number"
				+ " in that text field.</html>";
		
		simulationEmptyEntriesMessage2 = "<html>There is more than one text field entry that is empty.<br/>"
				+ "Please enter appropriate numbers for those text fields.</html>";
		
		simulationAlreadyStoppedMessage = "The simulation has already been stopped.";
		
		simulationAlreadyResetMessage = "The simulation has been already resetted.";
		
		
		
		
		
		
		// Demo Exercise Messages
		exerciseAnswerCorrectMessage = "You got the right answer!";
		
		exerciseAnswerIncorrectMessage = "You got the wrong answer; whoops!";
		
		
		
		
		
		
		
		// Chapter 2 - Simulation 1 Messages
		vectorXComponentTooBigMessage = "<html>The X component of the current vector is too big.<br/>"
				+ "Enter a number between -10000 and 10000, inclusive.</html>";
		
		vectorXCoordinateOutOfRangeLeftSideMessage = "<html>The current vector's initial point has its X-coordinate too far to the left.<br/>"
				+ "Enter a number that is not less than -310 so that way you can see the point.</html>";
		
		vectorXCoordinateOutOfRangeRightSideMessage = "<html>The current vector's initial point has its X-coordinate too far to the right.<br/>"
				+ "Enter a number that is not more than 310 so that way you can see the point.</html>";
		
		vectorYComponentTooBigMessage = "<html>The y component of the current vector is too big.<br/>"
				+ "Enter a number between -10000 and 10000, inclusive.</html>";
		
		vectorYCoordinateOutOfRangeTopSideMessage = "<html>The current vector's initial point has its X-coordinate too far upwards.<br/>"
				+ "Enter a number that is not more than 150 so that way you can see the point.</html>";
		
		vectorYCoordinateOutOfRangeBottomSideMessage = "<html>The current vector's initial point has its X-coordinate too far downwards.<br/>"
				+ "Enter a number that is not less than -150 so that way you can see the point.</html>";
		
		scalarOrFactorIsZeroMessage = "<html>You cannot have a scalar, or factor, equal to zero..<br/>"
				+ "Enter a number not equal to zero.</html>";
		
		scalarOrFactorTooLargeMessage = "<html>The scalar, or factor, is too big.<br/>"
				+ "Enter a number that is not more than 10000.</html>";
		
		directionOutOfRangeMessage = "<html>The simulation only supports actual angles of the vector relative to the positive x-axis.<br/>"
				+ "Enter a number between 0.0 and 360.0.</html>";
		
		
		
		
		
		
		
		// Chapter 2 - Simulation 4 Message
		drawTrajectoryNotAvailableMessage = "<html>The trajectory cannot be drawn, because this simulation is unimplemented.<br/>"
				+ "There's no animation to be shown in this version of the program.</html>";
					
					
		
		
		
		
		
		
		
		// Chapter 2 - Simulation 6 Messages
		radiusTooSmallMessage = "<html>The radius of the motion is too small.<br/>"
				+ "Enter a number between 45.0 and 125.0.</html>";
		
		radiusTooBigMessage = "<html>The radius of the motion is too big.<br/>"
				+ "Enter a number between 45.0 and 125.0.</html>";
		
		tangentialVelocityTooHighMessage = "<html>The tangential velocity is too big (> 500).<br/>"
				+ "Enter a number between -500.0 and 500.0.</html>";
		
		tangentialVelocityTooLowMessage = "<html>The absolute tangential velocity is too high (< -500).<br/>"
				+ "Enter a number between -500.0 and 500.0.</html>";
		
		tangentialAccelerationTooHighMessage = "<html>The tangential acceleration is too high (> 100).<br/>"
				+ "Enter a number between -100.0 and 100.0.</html>";
		
		tangentialAccelerationTooLowMessage = "<html>The absolute tangential acceleration is too big (< -100).<br/>"
				+ "Enter a number between -100.0 and 100.0.</html>";
		
		
		
		
		
		
		
		
		
		// Change Messages
		changeLectureMessage = "Are you sure you want to change the lecture?";
		
		changeSimulationMessage = "Are you sure you want to change the simulation?";
		
		changeExerciseChapterMessage = "Are you sure you want to change the chapter for exercises?";
		
		changeQuizMessage = "<html>Are you sure you want to change the quiz?<br/>"
				+ "You will lose all of your progress up to this point.</html>";
		
		
		
		
		
		
		
		
		
		// Quit Messages
		quitApplicationMessage = "Are you sure you want to quit?";
		
		quitLectureModeMessage = "Are you sure you want to quit Lecture Mode?";
		
		quitSimulationModeMessage = "Are you sure you want to quit Simulation Mode?";
		
		quitExerciseModeMessage = "Are you sure you want to quit Exercise Mode?";
		
		quitQuizModeMessage = "<html>Are you sure you want to quit Quiz Mode?<br/>"
				+ "You will lose all of your progress up to this point.</html>";
		
		
		
		
		
		
		
		
		// Additional Messages
		oneChapterSectionNotAvailableMessage = "<html>The chapter is not split into individual sections.<br/>"
				+ "This is a full chapter only.</html>";
	}
}
