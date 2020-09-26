// Jesse Hoffmeyer
import java.util.Scanner; 
import java.util.Random; 
public class GameZone {
/**
 * This allows for the user to navigate through the main menu 
 * @param sc Scanner that holds user input 
 * @return Returns an int of the game they wish to play
 */
	public static int mainMenu(Scanner sc) {
		System.out.println("Please select the game you wish to play");
		System.out.println("1. Twenty-One");
		System.out.println("2. Rock Paper Scissors");
		System.out.println("3. Quit" );
		int select = sc.nextInt(); // stores user input 
		return select; //returns choice to be used in main
		}
	
	/**
	 * This function implementates the classic game of 21. 
	 * @param sc Scanner that holds user input
	 * @param total Tracks the total number of the user after each card is drawn
	 * @param card Randomly generated card for the user to add to his/her total
	 * @param dealer A randomly generated number between 13 and 20 that is compared to the user's total
	 * @param response Holds the users response to if they wish to draw another card
	 */
	public static void twentyOne(Scanner sc) {
		int total = 0; // user total for game 
		int card = 0; // value of random card drawn
		int dealer = 0; // dealer value 
		String response = new String("y"); // creates string to hold user response 
		Random rng = new Random();
		do {
			card = rng.nextInt(11)+1; // creates a random value between 1 and 11
			total = total + card; // adds card to total for game 
			System.out.printf("You drew a %d.\n",card); 
			if (total == 21) { // catches if a player gets exactly 21 
				System.out.println("You got a perfect 21! You Win!\n"); 
				total = 0; // returns total to 0 for next game 
				mainMenu(sc); // return to main menu 
			}
			else if (total > 21) { // catches if player goes over 21
				System.out.println("Sorry, you bust. Better Luck Next Time.\n");
				total = 0; // returns total to 0 for next game
				mainMenu(sc); // return to main menu 
			}
			System.out.printf("Your total is now %d. Draw Again? (y/n)\n",total);
			response = sc.next();	// records if user wants to draw another card 		
			}while (!response.equals("n"));
		
		dealer = rng.nextInt(7+1) + 13; // draws random value between 13 and 20
		if (total > dealer) {
			System.out.printf("The dealer has %d. You win!\n",dealer); // win condition for user
			total = 0; // returns total to 0 for next game
			mainMenu(sc); // return to main menu 
		}
		else {
				System.out.printf("The dealer has %d. You lose...\n",dealer); // win condition for dealer
				total = 0; // returns total to 0 for next game
				mainMenu(sc); // return to main menu  
			 
			}
		
	}
	
	/**
	 * This function recreates the game of Rock, Paper, Scissors 
	 * @param sc Scanner that holds user input
	 * @param player Holds the choice of the user
	 * @param computer Randomly generates a number to choose 1 of the 3 options 
	 */
	public static void rockPaperScissors(Scanner sc) {
		int player = 0; // stores player choice
		int computer = 0; // stores randomly generated choice 
		Random rng = new Random();
		System.out.println("What would you like to choose?");
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");
		System.out.println("4. Quit");
		player = sc.nextInt(); // records player input as int 
		computer = rng.nextInt(3)+1; // chooses random value between 1 and 3 
		if (player == computer) {
			System.out.println("You both picked the same thing: Draw"); // base case if choices are equal
		}
		else if (player == 1 && computer == 2) { // player chooses rock, computer chooses paper
			System.out.println("Paper covers Rock: You Lose"); 
		}
		else if (player == 1 && computer == 3) { // player chooses rock, computer chooses scissors
			System.out.println("Rock smashes Scissors: You Win");
		}
		else if (player == 2 && computer == 1) { // player chooses paper, computer chooses rock
			System.out.println("Paper covers Rock: You Win");
		}
		else if (player == 2 && computer == 3) { // player chooses paper, computer chooses scissors 
			System.out.println("Scissors cuts Paper: You lose");
		}
		else if (player == 3 && computer == 1) { // player chooses scissors, computer chooses rock
			System.out.println("Rock crushes Scissors: You lose");
		}
		else if (player == 3 && computer ==2) { // player chooses scissors, computer chooses paper
			System.out.println("Scissors cuts Paper: You win");
		}
		else if (player == 4) { // Returns to Main Menu 
			mainMenu(sc); 
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("***********************");
		System.out.println("Welcome to the GameZone"); // title banner 
		System.out.println("***********************");
		Scanner sc = new Scanner(System.in); // scanner to hold user input 
		int sel = mainMenu(sc); 
		do {
			if (sel == 1) {
				twentyOne(sc); //selects game of 21
			}
			else if (sel == 2) {
				rockPaperScissors(sc); //selects game of Rock, Paper, Scissors 
			}
			else  {
				System.out.println("Please choose a valid number");
			}
		} while (sel != 3);

	}

}
