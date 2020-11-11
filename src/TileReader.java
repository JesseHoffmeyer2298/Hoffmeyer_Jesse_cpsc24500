import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TileReader {
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> result = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int xpos, ypos;
			Tile tile;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();  
				if (line.length() > 0) {  
					parts = line.split(" ");
					xpos = Integer.parseInt(parts[0]);
					ypos = Integer.parseInt(parts[1]);
					tile = new Tile(xpos, ypos);
					result.add(tile);
				}
			}
			fsc.close();
			return result; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;  
		}
	}
	public ArrayList<Tile> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	public ArrayList<Tile> readFromBinary(File f) {
		try {
			ArrayList<Tile> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tilesRead = (ArrayList<Tile>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
}