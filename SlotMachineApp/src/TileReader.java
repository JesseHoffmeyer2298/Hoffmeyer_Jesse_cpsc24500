import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
/*
 * This class loads Tile data in either text, binary, or XML
 */
public class TileReader {
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	/*
	 * This function loads Tile data as a text file (.txt)
	 * @param line line of characters taken by scanner 
	 * @param parts part of line, string seperated by white spaces 
	 * @param colortxt 1st part, color code for tile 
	 * @param shapetxt 2nd part, shape code for tile 
	 * @return return result if successful, return null if unsuccessful 
	 */
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> result = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int colortxt, shapetxt;
			Tile tile;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();  
				if (line.length() > 0) {  
					parts = line.split(" ");
					colortxt = Integer.parseInt(parts[0]);
					shapetxt = Integer.parseInt(parts[1]);
					tile = new Tile(colortxt, shapetxt);
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
	/*
	 * This function loads tile data as a binary file (.bin) 
	 */
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
	/*
	 * This function loads tile data as a XML file (.xml) 
	 */
	public ArrayList<Tile> readFromXML(String fname) {
		File f = new File(fname);
		return readFromXML(f);
	}
	public ArrayList<Tile> readFromXML(File f) {
		try {
			ArrayList<Tile> tilesRead;
			XMLDecoder dec = new XMLDecoder(
					new BufferedInputStream(new FileInputStream(f)));
			tilesRead = (ArrayList<Tile>)dec.readObject();
			dec.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	/*
	 * This function determines what file type is being loaded in a determines what function
	 * to use to load the file properly 
	 */
	public ArrayList<Tile> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	public ArrayList<Tile> read(File f) {
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return readFromText(f);
		}
		if (fname.endsWith(".BIN")) {
			return readFromBinary(f);
		}
		if (fname.endsWith(".XML")) {
			return readFromXML(f);
		}
		return null;  
	}
}

