/*
 * Test.java
 * A Java application that simulates a test. There are 5 questions each having 4 options.
 * Questions, Options and Answers are static.
 * Question are included from the first 3 chapters.
 * Author : Sanchit Shah (301118472)
 * Version : 1.0
 */
package application; 

import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class Test {

	// Field Variables
	int _totalQuestions = 5;
	int _correctAnswers = 0;
	private String[] _congratulatoryMessages = { "EXCELLENT", "GOOD!", "KEEP UP THE GOOD WORK!", "NICE WORK" };
	String[] _incorrectMessages = { "No. Please try again", "Wrong. Try once more", "Don't give up!",
	"No. Keep trying.." };
	private String[] _answers = {"b","c","b","b","c"};
	// Constants
	public final String INCORRECT_ANS_STRING = "\nCorrect Answer is : ";
	public final String DEFAULT_STRING = "Something went Wrong ! Sorry for the Inconvenience Caused !";

	// inputAnswer() method will interact with the user.
	public void inputAnswer() {

		boolean isCorrect = false;
		// For loop which will run till the questions exhaust i.e 5 in our case
		for (int queLoop = 0; queLoop < _totalQuestions; queLoop++) {
			// Getting question by calling the simulateQuestion() method.
			simulateQuestion(queLoop);
			// get answer from the user
			String userAnswer = String.valueOf(JOptionPane.showInputDialog("Enter the Answer (It should be a, b, c or d: "));
			if (null != userAnswer) {
				// Checking the answer by calling checkAnswer() method.
				isCorrect = checkAnswer(queLoop, userAnswer);
			}
			// Generating Result Messages !
			generateMessage(isCorrect, queLoop);
		}
		// generating result in percentage
		displayResult();
	}

	// simulateQuestion() method will display the question
	public void simulateQuestion(int questionNumber) {
		String[] questionList = {"Q1. Why is Java not Fully Object Oriented ? \nA. Because it uses Wrapper Classes \nB. Because it uses primitive data types \nC. Both A and B \nD. None of the above",
				"Q2. Which casing is followed in Java ? \nA. Pascal Casing \nB. Snake Casing \nC. Camel Casing \nD. Upper Casing" ,
				"Q3. Which Keyword is used to create an Object in Java ? \nA. System \nB. new \nC. createObject \nD. None of the Above",
				"Q4. Which Class is used to take input from the user for Console based Java Apps. ? \nA.System \nB.Scanner \nC.Both A and B \nD. None of the Above",
				"Q5. What are the types of loops in Java ? \nA.Entry Oriented \nB. Exite Oriented \nC. Both \nD. None of the Above"};

		JOptionPane.showMessageDialog(null, questionList[questionNumber]);
	}

	// checkAnswer() method will check the answer and returns true if correct else return false.
	public boolean checkAnswer(int questionNumber, String selectedValue) {
		if (selectedValue.equalsIgnoreCase(_answers[questionNumber])) {
			_correctAnswers++;// variable to keep track of the correct answers
			return true;
		} else {
			return false;
		}
	}

	// generateMessage() method will return one Correct Message
	public void generateMessage(boolean isCorrect, int questionNumber) {
		String displayMessage = "";
		SecureRandom randomNumber = new SecureRandom();
		if(isCorrect){
			switch (randomNumber.nextInt(4)) {
			case 0:
				displayMessage = _congratulatoryMessages[0];
				break;
			case 1:
				displayMessage = _congratulatoryMessages[1];
				break;
			case 2:
				displayMessage = _congratulatoryMessages[2];
				break;
			case 3:
				displayMessage = _congratulatoryMessages[3];
				break;
			default:
				displayMessage = DEFAULT_STRING;
			}
			JOptionPane.showMessageDialog(null, displayMessage);
		}else{
			switch (randomNumber.nextInt(4)) {
			case 0:
				displayMessage = _incorrectMessages[0];
				break;
			case 1:
				displayMessage = _incorrectMessages[1];
				break;
			case 2:
				displayMessage = _incorrectMessages[2];
				break;
			case 3:
				displayMessage = _incorrectMessages[3];
				break;
			default:
				displayMessage = DEFAULT_STRING;
			}
				JOptionPane.showMessageDialog(null, displayMessage + INCORRECT_ANS_STRING + _answers[questionNumber]);
			}
		}

	// displayResult() method will display result to the user.
	public void displayResult() {
		double percentageCorrect = 0.00;
		if (_correctAnswers != 0) {
			percentageCorrect = (_correctAnswers * 100) / 5;
		}
		JOptionPane.showMessageDialog(null, "Total Correct Answers are : " + _correctAnswers
				+ " and Total Incorrect Answers are :" + (_totalQuestions - _correctAnswers));
		JOptionPane.showMessageDialog(null, percentageCorrect + "% of answers are correct !");
	}
}
