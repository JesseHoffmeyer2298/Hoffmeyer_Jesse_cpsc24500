import java.io.Serializable;

public class Tile implements Serializable {
	private int color; 
	private int shape;  
	public int getTileColor() {
		return color;
	}
	public int getTileShape() {
		return shape;
	}
	public void setTileColor(int color) {
		this.color = color;  
	}
	public void setTileShape(int shape) {
		this.shape = shape;
	}
	public Tile() {
		color = 1; 
		shape = 1; 
	}
	public Tile(int color, int shape) {
		setTileColor(color);
		setTileShape(shape); 
	}
	@Override
	public String toString() {
		return String.format("%d %d",color,shape);
	}
}