import java.io.Serializable;
import java.util.Random;
/*
 * This class creates a Tile, which holds a color and shape value that is randomly generated
 * @param shape determines shape of tile (Circle or Square) 
 * @param color determines color of tile 
 */
public class Tile implements Serializable {
	private int color; 
	private int shape;  
	
	public void setRandom(Random rng) { // creates random values between 0-4 for Tile color
		color = rng.nextInt(5);
		shape = rng.nextInt(2); 
	}
	public int getTileColor() { // getter for TileColor
		return color;
	}
	public int getTileShape() { // getter for TileShape
		return shape;
	}
	public void setTileColor(int color) { // setter for TileColor
		this.color = color;  
	}
	public void setTileShape(int shape) { // setter for TileShape
		this.shape = shape;
	}
	public Tile() { //default constructor for Tile 
		color = 0; 
		shape = 0; 
	}
	public Tile(int color, int shape) { // Tile constructor that sets random values
		setTileColor(color);
		setTileShape(shape);
	}
	@Override
	public String toString() { // Converts Tile to String for saving to files 
		return String.format("%d %d",color,shape);
	}
}