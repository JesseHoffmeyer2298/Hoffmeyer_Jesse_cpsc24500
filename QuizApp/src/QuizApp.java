import java.util.ArrayList;
import java.util.Scanner;
/*\
 * This program creates a quiz based on object oriented theory questions from a json file
 * , and lets you customize the length of the quiz as well as showing the answers to the questions
 * @author Jesse Hoffmeyer
 */
public class QuizApp {
	/*
	 * This function prints a nice header for the user to be introduced to the program 
	 */
	public static void printHeader() {
		System.out.println("************************************");
		System.out.println("* OOP Theory and Concept Questions *");
		System.out.println("************************************");
	}
	/*
	 * This function creates a menu for the user to choose what they want to do
	 * @param choice Holds user input of menu choice 
	 */
	public static int showMenuAndChoice(Scanner sc) {
		int choice; 
		System.out.println("Here are your choices.");
		System.out.println("1. Take a quiz");
		System.out.println("2. See questions & answers");
		System.out.println("3. Exit");
		System.out.print("Enter your choice here: ");
		choice = sc.nextInt(); 
		return choice; 
	}
	
	public static void main(String[] args) {
		printHeader(); 
		ArrayList<Question> questions = new ArrayList<Question>(); 
		QuestionPrinter qp = new QuestionPrinter(); 
		QuestionReader qr = new QuestionReader();
		Quizzer qu = new Quizzer(); 
		Scanner sc = new Scanner(System.in);
		int choice;
		int quiznum = 0; 
		String file; 
		
		try {
			System.out.print("Enter name of file containing questions:");
			file = sc.nextLine(); 
			questions = qr.readFromJSON(file); // reads quiz json file 
		} catch (Exception ex) { 
			System.out.println("File not found.");
		}
		do {
			choice = showMenuAndChoice(sc); 
			if (choice == 1) { // starts quiz 
				System.out.println("How many questions for the quiz?");
				quiznum = sc.nextInt(); 
				qu.quiz(questions, quiznum); 
			} else if (choice == 2) {  // shows questions and answers 
				qp.printQuestions(questions); 
			}
		} while (choice != 3); 

	}

}
