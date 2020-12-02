import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * This class creates the framing of the app as well as file options and on screen buttons and visuals 
 */
class SlotMachineFrame extends JFrame {
	private TilePanel pan; // holds tiles in ArrayList 
	private Random rng; 
	private TileRandomizer random; // Randomizes tiles in the tile Panel 
	private TileChecker check; // checks Tile Panel for matches based on shape/color 
	private double winnings = 5.00; 
	private JTextField txtWinnings;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File"); // creates a drop down menu
		JMenuItem miSave = new JMenuItem("Save"); // Saves tiles as text, binary, or XML
		miSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { 
					if (tw.write(jfc.getSelectedFile(), pan.getTiles())) {  // if successful 
						JOptionPane.showMessageDialog(null,"Wrote tiles to file.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles to file.");
					}
				}
			}
		});
		mnuFile.add(miSave);
		JMenuItem miLoad = new JMenuItem("Load"); // Loads tiles as text, binary, or XML 
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileReader tr = new TileReader();
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					ArrayList<Tile> tilesRead = tr.read(jfc.getSelectedFile()); // if successful 
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null,"Could not read tiles from file.");
					} else {
						pan.setTiles(tilesRead);
						repaint();
					}
				}
			}
		});
		mnuFile.add(miLoad);
		JMenuItem miClear = new JMenuItem("Clear"); // clears Tiles from screen 
		miClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan.clearTiles(); 
				repaint(); 
			}
		});
		mnuFile.add(miClear);
		JMenuItem miRestart = new JMenuItem("Restart"); // Restarts program
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				winnings = 5.00; // resets winnings 
				txtWinnings.setText(String.format("%.2f", winnings)); 
				repaint(); 
			}
		});
		mnuFile.add(miRestart); 
		JMenuItem miExit = new JMenuItem("Exit"); // exits the program
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help"); // creates a drop down menu titled Help
		JMenuItem miAbout = new JMenuItem("About"); // Shows author and link to github 
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Jesse Hoffmeyer; https://github.com/JesseHoffmeyer2298/Hoffmeyer_Jesse_cpsc24500");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	public void setupLook() {
		setBounds(100,100,500,500);
		setTitle("Vegas Baby Vegas Slot Machine"); 
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		pan = new TilePanel(); // creating tile panel
		c.add(pan,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JButton btnMax = new JButton("Max");
		JButton btnMid = new JButton("Mid");
		JButton btnMin = new JButton("Min");
		JLabel lblBal = new JLabel("$");
		txtWinnings = new JTextField(6);
		txtWinnings.setText(String.format("%.2f",winnings)); // shows current winnings 
		panSouth.add(btnMin);
		btnMin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				random.tileRandomizer(pan.getTiles(), rng); // randomizes color and shape codes on tiles
				repaint(); // updates to show new tiles 
				Double earnings = check.minTileChecker(pan.getTiles(), winnings); // checks tiles for matches, returns amount won 
				winnings = earnings + winnings; // add amount won or loss to total winnings 
				txtWinnings.setText(String.format("%.2f", winnings)); // update winnings on screen 
				if (winnings <= 0) { // disables game 
					btnMin.setEnabled(false); 
					btnMid.setEnabled(false); 
					btnMax.setEnabled(false); 
				}
			}
		});
		panSouth.add(btnMid);
		btnMid.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				random.tileRandomizer(pan.getTiles(), rng);
				repaint();
				Double earnings = check.midTileChecker(pan.getTiles(), winnings);
				winnings = earnings + winnings;
				txtWinnings.setText(String.format("%.2f", winnings)); 
				if (winnings <= 0) {
					btnMin.setEnabled(false); 
					btnMid.setEnabled(false); 
					btnMax.setEnabled(false); 
				}
			}
		});
		panSouth.add(btnMax);
		btnMax.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				random.tileRandomizer(pan.getTiles(), rng);
				repaint();
				Double earnings = check.maxTileChecker(pan.getTiles(), winnings);
				winnings = earnings + winnings;
				txtWinnings.setText(String.format("%.2f", winnings)); 
				if (winnings <= 0) {
					btnMin.setEnabled(false); 
					btnMid.setEnabled(false); 
					btnMax.setEnabled(false); 
				}
			}
		});
		panSouth.add(lblBal);
		txtWinnings.setEditable(false);
		panSouth.add(txtWinnings);
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu(); 
	}
	public SlotMachineFrame() {
		random = new TileRandomizer();
		check = new TileChecker(); 
		rng = new Random(); 
		setupLook(); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}