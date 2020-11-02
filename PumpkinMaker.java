import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * @author Jesse Hoffmeyer
 * This program allows the user to draw pumpkins by choosing different shapes
 * and sizes to add  
 */
class PumpkinPanel extends JPanel {
	private String eye;
	private String nose; 
	private String mouth; 
	private int left; 
	private int top; 
	private int pumpkin_width; 
	private int pumpkin_height;  
	
	public String getEye() { // getter for eye
		return eye; 
	}
	public void setEye(String t) { //setter for eye
		if (t.equalsIgnoreCase("c")) {
			eye = "c";
		} else if (t.equalsIgnoreCase("s")) {
			eye = "s";
		} else if (t.equalsIgnoreCase("t")) {
			eye = "t"; 
		} else {
			JOptionPane.showMessageDialog(null, "Enter either a C, S, or T");
		}
		
	}
	public String getNose() { //getter for nose
		return nose; 
	}
	public void setNose(String t) { //setter for nose
		if (t.equalsIgnoreCase("c")) {
			nose = "c";
		} else if (t.equalsIgnoreCase("s")) {
			nose = "s";
		} else if (t.equalsIgnoreCase("t")) {
			nose = "t"; 
		} else {
			JOptionPane.showMessageDialog(null, "Enter either a C, S, or T");
		}
	}
	public String getMouth() { // getter for mouth
		return mouth; 
	}
	public void setMouth(String t) { // setter for mouth
		if (t.equalsIgnoreCase("o")) {
			mouth = "o";
		} else if (t.equalsIgnoreCase("r")) {
			mouth = "r";
		}else {
			JOptionPane.showMessageDialog(null, "Enter either a C, S, or T");
		}
	}
	public int getLeft() { //getter for left
		return left; 
	}
	public void setLeft(int i) { //setter for left
		if (i < 0) {
			left = 50; //set to default value if user input too low  
		} else {
			left = i; 
		}
	}
	public int getTop() { // getter for top
		return top; 
	}
	public void setTop(int i) { //setter for top
		if (i < 0) {
			top = 50; //set to default value if user input too low 
		} else { 
			top = i; 
		}
	}
	public int getPumpWidth() { // getter for pumpkin width
		return pumpkin_width; 
	}
	public void setPumpWidth(int i) { // setter for pumpkin width
		if (i < 50) {
			pumpkin_width = 100; //set to default value if user input too low 
		} else {
			pumpkin_width = i; 
		}
	}
	public int getPumpHeight() { // getter for pumpkin height
		return pumpkin_height; 
	}
	public void setPumpHeight(int i) { // setter for pumpkin width
		if (i < 50) {
			pumpkin_height = 100; //set to default value if user input too low 
		} else {
			pumpkin_height = i; 
		}
	}
	public PumpkinPanel() { // set default values on start up 
		setLeft(200);
		setTop(100); 
		setPumpWidth(150);
		setPumpHeight(100); 
		setEye("C");
		setNose("S"); 
		setMouth("O"); 
		
	}
	public PumpkinPanel(String eye, String nose, String mouth, 
			int left, int top, int pumpkin_width, int pumpkin_height) { // non-default for user input
		setEye(eye);
		setNose(nose);
		setMouth(mouth); 
		setLeft(left);
		setTop(top);
		setPumpWidth(pumpkin_width);
		setPumpHeight(pumpkin_height);
		
	}
	
	@Override
	public void paintComponent(Graphics g) { // draws shapes in proportion of base oval size 
		super.paintComponent(g); 
		g.setColor(Color.ORANGE);
		g.fillOval(left,  top, pumpkin_width, pumpkin_height); // fills in base oval based on user values
		g.setColor(Color.WHITE);
		g.fillRect((int)(left+pumpkin_width*0.425), (int)(top - pumpkin_height*0.125),
				(int)(pumpkin_width*0.125), (int)(pumpkin_height*0.125)); // draws in pupkin stem
		if (nose.equals("c")) { // creates circle nose
			g.fillOval((int)(left+pumpkin_width*0.4375), (int)(top+pumpkin_height*0.4375),
					(int)(pumpkin_width*0.125), (int)(pumpkin_height*0.125)); // proportions nose to base oval size
		}else if (nose.equals("s")) { // creates square nose
			g.fillRect((int)(left+pumpkin_width*0.4375), (int)(top+pumpkin_height*0.4375), 
					(int)(pumpkin_width*0.125), (int)(pumpkin_height*0.125)); // proportions nose to base oval size
	    }else if (nose.equals("t")) {	// creates triangle nose
			int noseLeft[] = new int[] {(int)(left+pumpkin_width*0.4375), (int)(left+pumpkin_width*0.5),
					(int)(left+pumpkin_width*0.5625)}; // sets location for "x" points of triangle 
			
			int noseTop[] = new int[] {(int)(top+pumpkin_height*0.5625), (int)(top+pumpkin_height*0.4375), 
				    (int)(top+pumpkin_height*0.5625)}; // sets location for "x" points of triangle 
			g.fillPolygon(noseLeft, noseTop, 3); // creates triangle based on proportioned locations 
	    }
		if (mouth.equals("o")) { // creates oval mouth 
			g.fillOval((int)(left+pumpkin_width*0.25), (int)(top+pumpkin_height*0.6875), (int)(pumpkin_width*0.5),
					(int)(pumpkin_height*0.125)); // proportions mouth to base oval 
		} else if (mouth.equals("r")) {	// creates rectangle mouth 
			g.fillRect((int)(left+pumpkin_width*0.25), (int)(top+pumpkin_height*0.6875), (int)(pumpkin_width*0.5),
					(int)(pumpkin_height*0.125)); // proportions mouth to base oval 
		}
		if (eye.equals("c")) { // creates two circle eyes 
			g.fillOval((int)(left+pumpkin_width*0.25), (int)(top + pumpkin_height*0.25),
					(int)(pumpkin_width*0.1875), (int)(pumpkin_height*0.1875)); // left eye position and proportioned size
			g.fillOval((int)(left+pumpkin_width*0.625), (int)(top + pumpkin_height*0.25),
					(int)(pumpkin_width*0.1875), (int)(pumpkin_height*0.1875)); // right eye position and proportioned size
		} else if (eye.equals("s")) { // creates two square eyes
			g.fillRect((int)(left+pumpkin_width*0.25), (int)(top + pumpkin_height*0.25), // left eye position and proportioned size
					(int)(pumpkin_width*0.1875), (int)(pumpkin_height*0.1875));
			g.fillRect((int)(left+pumpkin_width*0.625), (int)(top + pumpkin_height*0.25), // right eye position and proportioned size
					(int)(pumpkin_width*0.1875), (int)(pumpkin_height*0.1875));
		} else if (eye.equals("t")) { // creates two triangular eyes 
			int rightEyeLeft[] = new int [] {(int)(left+pumpkin_width*0.625), (int) (left + 
					pumpkin_width*0.6875), (int)(left+pumpkin_width*0.75)}; // right eye "x" position and proportioned size
			int rightEyeTop[] = new int [] {(int)(top+pumpkin_width*0.375), (int) (top + 
					pumpkin_width*0.25), (int)(top+pumpkin_width*0.375)}; // right eye "y" position and proportioned size
			g.fillPolygon(rightEyeLeft, rightEyeTop, 3); // creates right eye based on locations
			
			int leftEyeLeft[] = new int [] {(int)(left+pumpkin_width*0.25), (int) (left + 
					pumpkin_width*0.3125), (int)(left+pumpkin_width*0.375)}; // left eye "x" position and proportioned size
			int leftEyeTop[] = new int [] {(int)(top+pumpkin_width*0.375), (int) (top + 
					pumpkin_width*0.25), (int)(top+pumpkin_width*0.375)}; // left eye "y" position and proportioned size
			g.fillPolygon(leftEyeLeft, leftEyeTop, 3); // creates left eye based on locations
			
			
			}

		
}
}
class PumpkinPrinterFrame extends JFrame {
	
	public void centerFrame(int frameWidth, int frameHeight) { // centers frame on screen 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDims = tk.getScreenSize();
		int screenWidth = (int)screenDims.getWidth();
		int screenHeight = (int)screenDims.getHeight(); 
		int screenLeft = (screenWidth - frameWidth) / 2; 
		int screenTop = (screenHeight - frameHeight) / 2; 
		setBounds(screenLeft,screenTop,frameWidth,frameHeight);
	}
	/*
	 * This function creates a frame to handle user input,
	 *  and draw the shapes based on the choice
	 */
	public void setupLook() {
		centerFrame(800,480);
		setTitle("Pumpkin Maker");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		PumpkinPanel panCenter = new PumpkinPanel();
		c.add(panCenter,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JLabel lblLeft = new JLabel("Left:");
		panSouth.add(lblLeft);
		JTextField txtLeft = new JTextField(2); // left position  text field
		panSouth.add(txtLeft);
		JLabel lblTop = new JLabel("Top:");
		panSouth.add(lblTop);
		JTextField txtTop = new JTextField(2); // top position text field
		panSouth.add(txtTop);
		JLabel lblWidth = new JLabel("Width:");
		panSouth.add(lblWidth);
		JTextField txtWidth = new JTextField(2); // width size text field
		panSouth.add(txtWidth);
		JLabel lblHeight = new JLabel("Height:");
		panSouth.add(lblHeight);
		JTextField txtHeight = new JTextField(2); // height size text field 
		panSouth.add(txtHeight);
		JLabel lblEye = new JLabel("Eye(C S T):");
		panSouth.add(lblEye);
		JTextField txtEye = new JTextField(2); // eye type text field
		panSouth.add(txtEye);
		JLabel lblNose = new JLabel("Nose(C S T):");
		panSouth.add(lblNose);
		JTextField txtNose = new JTextField(2); // nose type text field
		panSouth.add(txtNose);
		JLabel lblMouth = new JLabel("Mouth(O R):");
		panSouth.add(lblMouth);
		JTextField txtMouth = new JTextField(2); // mouth type text field
		panSouth.add(txtMouth);
		JButton btnChange = new JButton("Apply");
		btnChange.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panCenter.setEye(txtEye.getText()); // gets eye type from user and passes through setEye
				panCenter.setNose(txtNose.getText()); // gets nose type from user and passes through setNose
				panCenter.setMouth(txtMouth.getText()); // gets mouth type from user and passes through setMouth
				try {
					int left = Integer.parseInt(txtLeft.getText()); // parses int from user and passes through setLeft
					panCenter.setLeft(left); 
					int top = Integer.parseInt(txtTop.getText()); // parses int from user and passes through setTop
					panCenter.setTop(top);
					int pumpkin_width = Integer.parseInt(txtWidth.getText()); // parses int from user and passes through setPumpWidth
					panCenter.setPumpWidth(pumpkin_width);
					int pumpkin_height = Integer.parseInt(txtHeight.getText()); // parses int from user and passes through setPumpHeight
					panCenter.setPumpHeight(pumpkin_height);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Something went wrong");
				}
				repaint();  // forces the whole window to repaint.
			}
		}		
		);
		panSouth.add(btnChange);
		c.add(panSouth,BorderLayout.SOUTH);
	}
	/* 
	 * This function calls the setupLook function and sets
	 *  default close operation to exit on close
	 */
	public PumpkinPrinterFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


public class PumpkinMaker {
	public static void main(String[] args) {
		PumpkinPrinterFrame frm = new PumpkinPrinterFrame();
		frm.setVisible(true);
	}
}
