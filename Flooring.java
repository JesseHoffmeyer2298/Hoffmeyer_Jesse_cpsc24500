// Jesse Hoffmeyer 
import java.lang.Math; 

public class Flooring {
	public static double findFlooring(int area, double boards) { 
		double total_boards = area / boards;  // finds total board sets needed to cover the area
			
		return total_boards; 
	}

	public static void main(String[] args) {
		int area1 = 20 * 13; 
		int area2 = 12 * 10; 
		int area3 = (12 * 10) / 2; 
		int tot_area = area1 + area2 + area3; // finds the total area of the floor
		int board = 30 * 6; // finds the area (in sq. inches)  of a single board
		double board_set = board * 6; // finds the area (in sq.inches) of a set of boards (6). 
		double board_conv = board_set / 144; // converts area of board set to sq. ft 
		double total_boards = findFlooring(tot_area,board_conv);
		double extra_boards = total_boards * 0.2; 
		total_boards = total_boards + extra_boards; // adds extra 20% of boards 
		total_boards = Math.ceil(total_boards); // rounds up to whole number 
		double price = total_boards * 24.99; // finds price of total board sets
		System.out.printf("You will need to purchase %.0f sets of boards at a price of $%.2f.",total_boards,price);
		

	}

}
