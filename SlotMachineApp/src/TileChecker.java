import java.util.ArrayList;

public class TileChecker {
	/*
	 * This function calculates the payout for the Min bet button 
	 * @param balance Total worth of bet placed, 10% of total winnings 
	 * @param col (1-4) takes in integer value of tile color
	 * @param sha (1-2) takes in integer value of tile shape 
	 * @return total winnings of the spin 
	 */
	public Double minTileChecker(ArrayList<Tile> tiles, Double winnings) {
		double balance = winnings/ 10.0; // bet tenth of winnings 
		int col_1 = tiles.get(0).getTileColor();
		int col_2 = tiles.get(1).getTileColor();
		int col_3 = tiles.get(2).getTileColor();
		int col_4 = tiles.get(3).getTileColor();
		int sha_1 = tiles.get(0).getTileShape();
		int sha_2 = tiles.get(1).getTileShape();
		int sha_3 = tiles.get(2).getTileShape();
		int sha_4 = tiles.get(3).getTileShape();
		if (col_1 == col_2 && col_1 == col_3 && col_1 == col_4 && col_2 == col_3
				&& col_2 == col_4 && col_3 == col_4) { // compares tile colors 
			if(sha_1 == sha_2 && sha_1 == sha_3 && sha_1 == sha_4 && sha_2 == sha_3
					&& sha_2 == sha_4 && sha_3 == sha_4) { // compares tile shapes 
				winnings = balance * 10.0; // match of color and shape
				return winnings; 
			}
			winnings = balance * 5.0; // match of color 
			return winnings; 
		} else {
			return -balance; // no match  
		}
	}
	/*
	 * This function calculates the payout for the Mid bet button 
	 * @param balance Total worth of bet placed, 50% of total winnings 
	 * @param col (1-4) takes in integer value of tile color
	 * @param sha (1-2) takes in integer value of tile shape 
	 * @return total winnings of the spin 
	 */
	public Double midTileChecker(ArrayList<Tile> tiles, Double winnings) {
		double balance = winnings/ 2.0; // bet half of winnings  
		int col_1 = tiles.get(0).getTileColor();
		int col_2 = tiles.get(1).getTileColor();
		int col_3 = tiles.get(2).getTileColor();
		int col_4 = tiles.get(3).getTileColor();
		int sha_1 = tiles.get(0).getTileShape();
		int sha_2 = tiles.get(1).getTileShape();
		int sha_3 = tiles.get(2).getTileShape();
		int sha_4 = tiles.get(3).getTileShape();
		if (col_1 == col_2 && col_1 == col_3 && col_1 == col_4 && col_2 == col_3
				&& col_2 == col_4 && col_3 == col_4) { // comparing tile color 
			if(sha_1 == sha_2 && sha_1 == sha_3 && sha_1 == sha_4 && sha_2 == sha_3
					&& sha_2 == sha_4 && sha_3 == sha_4) { // commparing tile color and shape 
				winnings = balance * 50.0; // color and shape match 
				return winnings; 
			}
			winnings = balance * 10.0; // color match 
			return winnings; 
		} else {
			return -balance;  // no match 
		}
	}
	/*
	 * This function calculates the payout for the Max bet button 
	 * @param balance Total worth of bet placed, 100% of total winnings 
	 * @param col (1-4) takes in integer value of tile color
	 * @param sha (1-2) takes in integer value of tile shape 
	 * @return total winnings of the spin 
	 */
	public Double maxTileChecker(ArrayList<Tile> tiles, Double winnings) {
		double balance = winnings; // bet all of winnings  
		int col_1 = tiles.get(0).getTileColor();
		int col_2 = tiles.get(1).getTileColor();
		int col_3 = tiles.get(2).getTileColor();
		int col_4 = tiles.get(3).getTileColor();
		int sha_1 = tiles.get(0).getTileShape();
		int sha_2 = tiles.get(1).getTileShape();
		int sha_3 = tiles.get(2).getTileShape();
		int sha_4 = tiles.get(3).getTileShape();
		if (col_1 == col_2 && col_1 == col_3 && col_1 == col_4 && col_2 == col_3
				&& col_2 == col_4 && col_3 == col_4) { // compares tile color 
			if(sha_1 == sha_2 && sha_1 == sha_3 && sha_1 == sha_4 && sha_2 == sha_3
					&& sha_2 == sha_4 && sha_3 == sha_4) { // compares tile shape 
				winnings = balance * 100.0; // color and shape match  
				return winnings; 
			}
			winnings = balance * 25.0; // color match 
			return winnings; 
		} else {
			return 0.0;  // no match 
		}
	}
	
}
