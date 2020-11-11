import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class SlotMachineFrame extends JFrame {
	private TilePanel pan; 
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miSave = new JMenuItem("Save");
		miSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { 
					if (tw.writeToText(jfc.getSelectedFile(), pan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles to file.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles to file.");
					}
				}
			}
		});
		mnuFile.add(miSave);
		JMenuItem miLoad = new JMenuItem("Load");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileReader tr = new TileReader();
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					ArrayList<Tile> tilesRead = tr.readFromBinary(jfc.getSelectedFile());
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
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		setJMenuBar(mbar);
	}
	public void setupLook() {
		setBounds(100,100,500,500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		pan = new TilePanel(); 
		c.add(pan,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JButton btnMax = new JButton("Max");
		JButton btnMid = new JButton("Mid");
		JButton btnMin = new JButton("Min");
		JLabel lblBal = new JLabel("$ 5.00");
		panSouth.add(btnMin);
		panSouth.add(btnMid);
		panSouth.add(btnMax);
		panSouth.add(lblBal);
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu(); 
	}
	public SlotMachineFrame() {
		setupLook(); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}