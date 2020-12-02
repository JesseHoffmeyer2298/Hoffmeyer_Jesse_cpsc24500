import java.util.ArrayList;
import java.util.Random;
/*
 * This function randomizes the color and shape codes of the tiles
 *  when the bet buttons are pressed
 *   
 */
public class TileRandomizer {
	public void tileRandomizer(ArrayList<Tile> tiles, Random rng) {
		tiles.get(0).setRandom(rng);
		tiles.get(1).setRandom(rng);
		tiles.get(2).setRandom(rng);
		tiles.get(3).setRandom(rng); 
	}
	
}
