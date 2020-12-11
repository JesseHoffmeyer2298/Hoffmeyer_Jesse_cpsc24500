import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quizzer {
	/*
	 * This function creates a custom_length quiz for the user to take 
	 * @param Question takes one question from question ArrayList
	 * @param correct correct user answers on the quiz
	 * @param user_answer takes in user input for answer to question  
	 */
	public static void quiz(ArrayList<Question> questions, int quiznum) {
		Question question; 
		Scanner sc = new Scanner(System.in); 
		Collections.shuffle(questions); // randomizes question order
		String user_answer; 
		int correct = 0; 
		for (int i = 0; i < quiznum; i++) { //asks questions until user specified amount 
			question = questions.get(i); 
			System.out.println(question); // print question 
			System.out.print("Enter the letter of your choice: ");
			user_answer = sc.nextLine().trim(); // takes in int answer without whitespace 
			if (user_answer.equalsIgnoreCase(question.getAnswer())) { // if user answer is correct
				System.out.println("Correct!");
				correct ++; 
			}else { // of incorrect 
				System.out.printf("Incorrect, the correct answer is %s.\n", question.getAnswer());
			}
			
		}
		System.out.printf("You scored %s out of %s\n",correct,quiznum);
	}
	

}
