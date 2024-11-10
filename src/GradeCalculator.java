/*
 * GradeCalculator.java
 * Author:  Emmanuel Pierre 
 * Submission Date:  Sept 28, 2022
 *
 * Purpose: The purpose of this code is to allow users
 * to calculate their grade based on inputs. This also
 * calculates the average grade needed to achieve a certain 
 * letter grade.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class GradeCalculator {
	public static void main(String[] args) {
		File file = new File("src/textput");
		Scanner keyboard = new Scanner(System.in);
		try {
			keyboard = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		System.out.println("Grading Scale:\nA\t90 - 100\nB\t80 - 89\nC\t70 - 79\nD\t60 - 69\nF\tbelow 60");
		System.out.print("What letter grade do you want to achieve for the course?");
		String gradeToAchieve = keyboard.next().toUpperCase();
		//The following if statement ends at line 191 and is followed by an else statement
		if (gradeToAchieve.equalsIgnoreCase("a")
				||gradeToAchieve.equalsIgnoreCase("b")
				||gradeToAchieve.equalsIgnoreCase("c")
				||gradeToAchieve.equalsIgnoreCase("d")
				||gradeToAchieve.equalsIgnoreCase("f"))
		{
			
		System.out.println("Enter percentage weights below.");
		
		//Variables for grade weight
		System.out.print("Exam 1:\t\t\t");
		int exam1PW = keyboard.nextInt();
		System.out.print("Exam 2:\t\t\t");
		int exam2PW = keyboard.nextInt();
		System.out.print("Final Exam:\t\t");
		int finalExamPW = keyboard.nextInt();
		System.out.print("Labs:\t\t\t");
		int labsPW = keyboard.nextInt();
		System.out.print("Projects:\t\t");
		int projectsPW = keyboard.nextInt();
		System.out.print("Participation:\t\t");
		int participationPW = keyboard.nextInt();
		System.out.print("Quizzes:\t\t");
		int quizzesPW = keyboard.nextInt();
		
		//Variables for grades
		int exam1Score = 0;
		int exam2Score = 0;
		int finalExamScore = 0;
		int labsAverage = 0;
		int projectsAverage = 0;
		int participationAverage = 0;
		int quizzesAverage = 0;
		
		//Must add up to 100
		if ((exam1PW+exam2PW+finalExamPW+labsPW+projectsPW+participationPW+quizzesPW)!=100) {
			System.out.print("Weights don't add up to 100, program exiting...");
			System.exit(0);		
		}
		//Nested if statement for Exam 1 and 2 and Final Exam score. If there's no score for exam 1 we assume there's no score for the others
		System.out.print("Do you know your exam 1 score?");
		String answer = keyboard.next();
		if  (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("yes")) {
			System.out.print("Score recieved on exam 1:");
			exam1Score = keyboard.nextInt();
				System.out.print("Do you know your exam 2 score?");
				answer = keyboard.next();
				if  (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("yes")) {
				System.out.print("Score recieved on exam 2:");
				exam2Score = keyboard.nextInt();
					System.out.print("Do you know your final exam score?");
					answer = keyboard.next();
					if  (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("yes")) {
					System.out.print("Score recieved on final exam:");
					finalExamScore = keyboard.nextInt();
							}
					else {finalExamPW = 0;}

					}
				else {exam2PW = 0;
				finalExamPW = 0;}
			}
		else {exam1PW = 0;
		exam2PW = 0;
		finalExamPW = 0;}

		//The weights are set to 0 if they're not used
		System.out.print("Do you know your lab average?");
		answer = keyboard.next();
		if  (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("yes")) {
			System.out.print("Average lab grade:");
			labsAverage = keyboard.nextInt();
	}
		else {labsPW = 0;}
		
		System.out.print("Do you know your project average?");
		answer = keyboard.next();
		if  (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("yes")) {
			System.out.print("Average project grade:");
			projectsAverage = keyboard.nextInt();
	}
		else {projectsPW = 0;}
		
		System.out.print("Do you know your participation average?");
		answer = keyboard.next();
		if  (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("yes")) {
			System.out.print("Average participation grade:");
			participationAverage = keyboard.nextInt();
	}
		else {participationPW = 0;}
		
		System.out.print("Do you know your quiz average?");
		answer = keyboard.next();
		if  (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("yes")) {
			System.out.print("Average quiz grade:");
			quizzesAverage = keyboard.nextInt();
	}
		else {quizzesPW = 0;}
	
		//This variable is the sum of all the weights that had a corresponding grade inputed
		double totalKnownGradeWeight = exam1PW+exam2PW+finalExamPW+labsPW+projectsPW+participationPW+quizzesPW;
		//The variable sumOfAverages is honestly pretty useless - it's only used to compute currentScore
		double sumOfAverages = ((exam1PW)*(exam1Score))
				+((exam2PW)*(exam2Score))
				+((finalExamPW)*(finalExamScore))
				+((labsPW)*(labsAverage)+((projectsPW)*(projectsAverage))
				+((participationPW)*(participationAverage))
				+((quizzesPW)*(quizzesAverage)));
		System.out.println(totalKnownGradeWeight);
		double currentScore = (sumOfAverages/totalKnownGradeWeight);
		System.out.printf("Current grade score:\t%.2f%n",currentScore);
		
		String letterGrade = null;
		int finalOverallScore = 0;
		
		//Assigning scores letter grades (was gonna use enum but seemed pointless)
		if (Math.floor(currentScore) >= 90.0 && Math.floor(currentScore) <= 100.0){
			letterGrade = "A";
			}
		if (Math.floor(currentScore) >= 80.0 && Math.floor(currentScore) <= 89.0){
			letterGrade = "B";
			}
		if (Math.floor(currentScore) >= 70.0 && Math.floor(currentScore) <= 79.0){
			letterGrade = "C";
			}
		if (Math.floor(currentScore) >= 60.0 && Math.floor(currentScore) <= 69.0){
			letterGrade = "D";
			}
		if (Math.floor(currentScore) < 60){
			letterGrade = "F";
			}
		
		//finalOverallScore is needed for average score needed to final letter grade computation
		if (gradeToAchieve.equalsIgnoreCase("A")){
			finalOverallScore = 90;
		}
		if (gradeToAchieve.equalsIgnoreCase("B")){
			finalOverallScore = 80;
		}
		if (gradeToAchieve.equalsIgnoreCase("C")){
			finalOverallScore = 70;
		}
		if (gradeToAchieve.equalsIgnoreCase("D")){
			finalOverallScore = 60;
		}
		if (gradeToAchieve.equalsIgnoreCase("F")){
			finalOverallScore = 0;
		}
		
		double avgToFinalLetterGrade = (((100*finalOverallScore)-(currentScore*totalKnownGradeWeight))/(100-totalKnownGradeWeight));
		
		System.out.println("Your current letter grade:"+letterGrade);
		
		//The boolean congrats is true when the user's grade is equal to the grade they want to achieve. Very useful variable
		boolean congrats = false;
		System.out.println(avgToFinalLetterGrade);
		if (gradeToAchieve.equals(letterGrade)){
		congrats = true;}
		
		//When user has completed course and has achieved desired grade
		if ((congrats == true) && totalKnownGradeWeight == 100) {
			System.out.println("Congratulations! You received the "+gradeToAchieve+" that you wanted!");
		}
		if ((finalOverallScore+10 < currentScore) && totalKnownGradeWeight == 100 && finalOverallScore != 0) {
			System.out.println("Congratulations! You received a better grade than what you wanted!");
		}
		//When user cannot get the desired grade
		if ((totalKnownGradeWeight == 100 && congrats == false && currentScore < finalOverallScore) || avgToFinalLetterGrade > 100) {
		System.out.print("Unfortunately, a grade of "+gradeToAchieve+" is not possible");
		}
		//When the current grade is the desired grade but there's still more work to be done
		if (totalKnownGradeWeight < 100 && congrats == true && avgToFinalLetterGrade < 100) {
		System.out.print("You will receive at least a grade of D");
		}
		//When there's still more work to be done and it's possible to get the desired grade
		if ((totalKnownGradeWeight < 100 && congrats == false && avgToFinalLetterGrade <= 100)) {
			System.out.printf("In order to receive a grade of "+gradeToAchieve+",\nyou need to score an average greater "
					+ "than\nor equal to %.2f in the rest of the grade items.", avgToFinalLetterGrade);
		}
		}
		
	
	else {System.out.print("The input is invalid.");
	System.exit(0);}
		
	}}
