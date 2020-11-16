import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
/* 
 * This class uses the Tile class to create 4 random tiles and paint them on the screen 
 */
class TilePanel extends JPanel implements MouseListener, MouseMotionListener  {
	private ArrayList<Tile> tiles;
	private int tileLeft; 
	private int tileTop;
	private int count;
	
	public ArrayList<Tile> getTiles() { // getter for tiles
		return tiles; 
	}
	public void setTiles(ArrayList<Tile> tiles ) { // setter for tiles 
		this.tiles = tiles; 
	}
	public int getTileLeft() { // getter for TileLeft coordinate 
		return tileLeft;
	}
	public void setTileLeft() { // setter for TileLeft coordinate 
		tileLeft = 20; 
	}
	public int getTileTop() { // getter for TileTop coordinate 
		return tileTop; 
	}
	public void setTileTop() { // setter for TileTop coordinate 
		tileTop = 50; 
	}
	public void clearTiles() { // clears Tiles on screen 
		tiles.clear(); 
	}
	
	public TilePanel() { // constructor for TilePanel 
		tiles = new ArrayList<Tile>(); 
		tiles.add(new Tile());
		tiles.add(new Tile());
		tiles.add(new Tile());
		tiles.add(new Tile());
		tileLeft = 20; 
		tileTop = 50; 
		this.addMouseListener(this);
	}
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Tile tile : tiles) {
			if (count == 1) { // spaces out tiles 
				tileLeft = tileLeft + 120; 
			}
			if (count == 2) {
				tileLeft = tileLeft + 120; 
			}
			if (count == 3) {
				tileLeft = tileLeft + 120; 
			}
			if ( tile.getTileColor() == 0) {
				g.setColor(Color.BLUE); 
			}
			else if (tile.getTileColor() ==  1) {
				g.setColor(Color.RED);
			}
			else if (tile.getTileColor() == 2) {
				g.setColor(Color.YELLOW);
			}
			else if (tile.getTileColor() == 3) {
				g.setColor(Color.GREEN);
			}
			else if (tile.getTileColor() == 4) {
				g.setColor(new Color(255,140,0)); // changed orange, looked to similar to yellow 
			}
			if (tile.getTileShape() == 0) {
				g.fillRect(tileLeft,tileTop,100,100);
			}
			else if (tile.getTileShape() == 1) {
				g.fillOval(tileLeft, tileTop, 100, 100); 
			}
			count++; 
		}
	count = 0; 
	tileLeft = 20; 
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {	
	}
	@Override
	public void mouseDragged(MouseEvent e) {		
	}
	@Override
	public void mouseMoved(MouseEvent e) {	
	}
	// creates new tile and replaces on screen tile based on mouse click position  
	@Override
	public void mouseClicked(MouseEvent e) { 
		int cordX = e.getX(); 
		int cordY = e.getY(); 
		Tile tiley = new Tile(e.getX(),e.getY());
		if (cordY >= 50 & cordY <= 150) {
		if (cordX <= 120) {
			tiles.remove(0);
			tiles.add(0,tiley);
			repaint();
		}
		else if (cordX <= 240 & cordX > 121) {
			tiles.remove(1);
			tiles.add(1,tiley);
			repaint();
		}
		else if (cordX <= 360 & cordX > 241) {
			tiles.remove(2);
			tiles.add(2,tiley);
			repaint();
		}
		else if (cordX <= 480 & cordX > 361) {
			tiles.remove(3);
			tiles.add(3,tiley);
			repaint();
		}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {	
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {	
	}
}
