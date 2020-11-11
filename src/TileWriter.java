import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TileWriter {
	public boolean writeToText(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToText(f,tiles);   
	}
	public boolean writeToText(File f, ArrayList<Tile> tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Tile tile : tiles) {
				pw.println(tile); 
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean writeToBinary(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToBinary(f,tiles);
	}
	
	public boolean writeToBinary(File f, ArrayList<Tile> tiles) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(tiles);
			oos.close();
			return true; // success
		} catch (Exception ex) {
			return false;
		}
	}
}