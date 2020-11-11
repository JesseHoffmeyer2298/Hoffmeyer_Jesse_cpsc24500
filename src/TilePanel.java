import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

class TilePanel extends JPanel  {
	private ArrayList<Tile> tiles;
	private int tileLeft; 
	private int tileTop; 
	
	public ArrayList<Tile> getTiles() {
		return tiles; 
	}
	public void setTiles(ArrayList<Tile> tiles ) {
		this.tiles = tiles; 
	}
	public int getTileLeft() {
		return tileLeft;
	}
	public void setTileLeft() { 
		tileLeft = 50; 
	}
	public int getTileTop() {
		return tileTop; 
	}
	public void setTileTop() {
		tileTop = 50; 
	}
	public TilePanel() {
		tiles = new ArrayList<Tile>(); 
		tiles.add(new Tile(1,1));
		tiles.add(new Tile(2,1));
		tiles.add(new Tile(1,1));
		tiles.add(new Tile(2,1));
		tileLeft = 50; 
		tileTop = 50; 
	}
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Tile tile : tiles) {
			if ( tile.getTileColor() == 1) {
				g.setColor(Color.BLUE); 
			}
			if (tile.getTileColor() == 2) {
				g.setColor(Color.RED);
			}
			g.fillRect(tileLeft,tileTop,50,50);
			
			tileLeft = tileLeft + 100;
		}
		
		
	}
}
