import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 * @author Jesse Hoffmeyer
 * This program creates an arrayList of tiles of random color and shape and displays
 * 4 of these tiles on a frame, clicking on a tile will create a new random tile in that tile's place. 
 */

public class SlotMachineApp {
	public static void main(String[] args) {
		SlotMachineFrame frm = new SlotMachineFrame(); 
		frm.setVisible(true); 
	}

}
