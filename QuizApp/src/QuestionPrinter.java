import java.util.ArrayList;
/* 
 * This function prints out all the questions along with the letter answer for all the questions in the file
 */
public class QuestionPrinter {
	public static void printQuestions(ArrayList<Question> questions) {
		System.out.println("Here are the answers\n");
		for (Question question : questions) {
			System.out.printf("%s %s\n",question.getAnswer(), question.getQuestion());
		}
	}
}
