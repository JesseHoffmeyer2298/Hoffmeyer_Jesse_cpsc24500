// Jesse Hoffmeyer

import java.util.ArrayList; 
import java.util.Scanner;
import java.io.*; 
public class Standings_Analyzer {
	/**
	 * 
	 * @param sc Takes in user input on the terminal
	 * @return choice Holds response made by user
	 */
	public static int mainMenu(Scanner sc) {
		System.out.println("**********************************************");
		System.out.println("            2020 MLB STANDINGS");
		System.out.println("");
		System.out.println(" Choose a number for a more detailed stats on");
		System.out.println("each Division or look at the Overall Standings");
		System.out.println("**********************************************");
		System.out.println("1. Al East");
		System.out.println("2. AL Central");
		System.out.println("3. AL West");
		System.out.println("4. NL East");
		System.out.println("5. NL Central");
		System.out.println("6. NL West");
		System.out.println("7. Overall");
		System.out.println("8. Exit");
		int choice = sc.nextInt(); 
		return choice;
	}
	/**
	 * 
	 * @param line Takes in current stat line held by the String Array
	 * @param parts Holds charcaters in string broken up by tabs
	 * @param total Calculation of Wins + Losses 
	 * @return pct Win % calculation returned to printStats function
	 */
	public static double getWinPct(String line) {
		String[] parts = line.split("\t");
		double total = (Integer.parseInt(parts[1])+ Integer.parseInt(parts[2]) * 1.00);
		double pct = (Integer.parseInt(parts[1])/ total); 
		return pct; 
		
	}
	/**
	 * 
	 * @param all Array list wiith each team's stats
	 * @param line Each individual line for all
	 * @param thispct Current pct for the team analyzed on the string 
	 * @param otherpct Comparing win % of other teams to find where it should be placed
	 */
	public static void insertByAverage(ArrayList<String> all, String line) {
		double thispct = getWinPct(line);
		double otherpct; 
		int pos = -1;
		for (int i = 0; i < all.size(); i++) {
			otherpct = getWinPct(all.get(i));
			if(thispct > otherpct) {
				pos = i; 
				break;
			}
		}
		if (pos < 0) {
			all.add(line);
		}else {
			all.add(pos,line); 
		}
	}
	/**
	 * 
	 * @param stats Full array of strings in the file 
	 * @param line individual string taken from stats
	 * @param top_team String to take in inputs from top team's string 
	 * @param topparts Array to take in individual sections of string by tabs
	 * @param high_win Takes in wins from the highest team's string 
	 * @param high_loss Takes in losses from the highest team's string 
	 * @param next_win Takes in wins by the current string being evaluated 
	 * @param next_loss Takes in losses by the current string being evaluated 
	 * @param gb_win Calculating wins for highest team - current team
	 * @param gb_loss Calculating losses for the highest team - current team 
	 * @return g_b Calculates games back for the current team 
	 */
	public static double getGamesBack(ArrayList<String> stats, String line) {
		String top_team = stats.get(0);
		String[] topparts = top_team.split("\t");
		int high_win = Integer.parseInt(topparts[1]);
		int high_loss = Integer.parseInt(topparts[2]); 
		String[] parts = line.split("\t");
		int next_win = Integer.parseInt(parts[1]);
		int next_loss = Integer.parseInt(parts[2]);
		int gb_win = high_win - next_win;
		int gb_loss = high_loss - next_loss; 
		double g_b = ((gb_win - gb_loss)/ 2.0 );
		return g_b;
		
	}
	/**
	 * 
	 * @param stats Takes in arraylist with all strings in the text file  
	 * @param pct Takes in win percentage for the current team
	 * @param g_b Takes in games_back for the current team 
	 */
	public static void printStats(ArrayList<String> stats) {
		String [] parts; 
		double pct; 
		double g_b; 
		System.out.println("Team      Win      Losses      WinPct.      Games Back\n");
		for (String stat : stats) {
			parts = stat.split("\t");
			pct = getWinPct(stat);
			g_b = getGamesBack(stats,stat);
			System.out.printf("%-10s %-10s %-10s %-10.2f %-10.1f\n",parts[0],parts[1],parts[2],pct,g_b);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of file: ");
		String fname = sc.nextLine(); // takes in location of file 
		ArrayList<String> al_east = new ArrayList<String>();
		ArrayList<String> al_cent = new ArrayList<String>();
		ArrayList<String> al_west = new ArrayList<String>();
		ArrayList<String> nl_east = new ArrayList<String>();
		ArrayList<String> nl_cent = new ArrayList<String>();
		ArrayList<String> nl_west = new ArrayList<String>();
		ArrayList<String> target = null; 
		ArrayList<String> together = new ArrayList<String>();
		String line; 
		String[] parts; 
		String league; 
		boolean GoAhead;
		int choice; 
		try { 
			Scanner fsc = new Scanner(new File(fname)); 
			while(fsc.hasNextLine()) { 
				line = fsc.nextLine(); 
				parts = line.split("\t");
				if(parts[0].equalsIgnoreCase("League")) {
					league = parts[1].toUpperCase();
					if(league.equalsIgnoreCase("AL East")) {
						target = al_east; // stores strings under Al East
					}else if(league.equalsIgnoreCase("AL Central")) {
						target = al_cent; // stores strings under Al Central
					}else if(league.equalsIgnoreCase("AL West")) {
						target = al_west; // stores strings under Al West
					}else if(league.equalsIgnoreCase("NL East")) {
						target = nl_east; // stores strings under NL East
					}else if(league.equalsIgnoreCase("NL Central")) {
						target = nl_cent; // stores strings under NL Central
					}else if(league.equalsIgnoreCase("NL West")) {
						target= nl_west; // stores strings under NL West
					}
				} else {
					target.add(line);
					insertByAverage(together,line); // stores all stat lines together 
				}
			
			}
			fsc.close();
			GoAhead = true; 
		} catch (Exception ex) {
			System.out.println("File could not be read."); // handles errors 
			GoAhead = false; 
		}
		if(GoAhead) {
			do {
				choice = mainMenu(sc);
				if(choice == 1) {
					printStats(al_east);
				}else if(choice == 2) {
					printStats(al_cent);
				}else if(choice == 3) {
					printStats(al_west);
				}else if(choice == 4) {
					printStats(nl_east);
				}else if(choice == 5) {
					printStats(nl_cent);
				}else if(choice == 6) {
					printStats(nl_west);
				}else if(choice == 7) {
					for(String team : together) {
						System.out.println(team);
					}
				}else if(choice == 8) {
					sc.close();
					System.exit(0);
				}else {
					System.out.println("Please enter a number in the correct range.");
				}
			}while (choice != 8);
		}
			
		
		
				
	}

}
