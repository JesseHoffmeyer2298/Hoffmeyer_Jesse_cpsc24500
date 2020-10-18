import java.util.Scanner;
import java.io.File;
import java.util.LinkedHashMap;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import org.math.*;
import org.math.plot.Plot2DPanel;

/*
 * @author Jesse Hoffmeyer
 * This program graphs either the daily or culumiative death totals by each country for
 * the Covid-19 pandemic 
 */
public class CovidPlotter {
	/*
	 * This function creates a Linked Hash Map that holds the name of the countries and 
	 * the values associated with it 
	 */
	public static LinkedHashMap<String,double[]> readData(Scanner fsc) {
		LinkedHashMap<String,double[]> result = new LinkedHashMap<String, double[]>();
		fsc.nextLine();
		String name;
		String line; 
		String[] parts; 
		double[] values; 
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			name = parts[0];  // takes in name of country 
			values = new double[parts.length-1];
			for(int i = 1; i < parts.length; i++) {
				values[i-1] = Double.parseDouble(parts[i]); // enter a double for each value in the array 
			}
			result.put(name, values); // puts result into the Linked Hash Map 
		}
		return result; 
	}
	/*
	 * This function gets the number of days for the x axis of the graph
	 * @param howMany size of array 
	 */
	public static double[] getDays(int howMany) {
		double[] result = new double[howMany];
		for (int i = 0; i < howMany; i++) {
			result[i] = i;
		}
		return result;
	}
	
	/*
	 * This function presents the user with a nice looking header when entering the program
	 */
	public static void welcome() {
		System.out.println("***************************************");
		System.out.println("* COVID-19 MORTALITY RATES BY COUNTRY *");
		System.out.println("***************************************");
	}
	
	/*
	 * This function creates a plot that shows the data from the linked hash map
	 */
	public static void showPlot(Plot2DPanel plot) {
		JFrame frm = new JFrame();
		frm.setBounds(100,100,500,500);
		frm.setTitle("Covid-19 Deaths");
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // delete graph from memory rather than closing program
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		plot.addLegend("SOUTH");
		plot.setAxisLabels("Day","Deaths");
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		LinkedHashMap<String,double[]> countries; 
		String input;
		String c_d; 
		String[] names; 
		Scanner sc = new Scanner(System.in); 
		double [] deathtoll;
		double [] dailydeaths = new double[300];
		welcome();
		System.out.println("Please enter the name of the file:");
		String fname = sc.nextLine(); 
		try {
			Scanner fsc = new Scanner(new File(fname));
			countries = readData(fsc); // converts data from file to a linked Hash map 
		} catch(Exception ex) {
			countries = null; 
		}
		if (countries == null) { 
			System.out.println("Could not read the file.");
		} else {
			do {
				System.out.print("Enter names of countries seperated by commas(exit to quit): ");
				input = sc.nextLine();
				System.out.println("[D]aily or [C]umulative?");
				c_d = sc.nextLine(); 
				if (!input.equalsIgnoreCase("exit")) {
					Plot2DPanel plot = new Plot2DPanel(); 
					names = input.split(",");
					for (String name : names) {
						name = name.trim(); 
						if (!countries.containsKey(name)) {
							System.out.printf("%s is not in the data.\n", name);
						} 
						if (c_d.equalsIgnoreCase("d")) {
							deathtoll = countries.get(name); 
							double day; 
							double dayunder; 
							double death; 
							for (int i = 1; i < deathtoll.length; i++ ) {
								day = deathtoll[i]; // takes in current day evaluated
								dayunder = deathtoll[i-1]; //takes in day before day evaluated
								death = day - dayunder; // current day - previous day
								dailydeaths[i] = death;  // insert result into new double array 
										
							}
							plot.addLinePlot(name, getDays(deathtoll.length), dailydeaths); // plots daily figures
						}else {
							deathtoll = countries.get(name); 
							plot.addLinePlot(name, getDays(deathtoll.length), deathtoll); // plots total figures 
						}
					}
					showPlot(plot);
				}
			} while (!input.equalsIgnoreCase("exit"));
			System.out.println("Thank you.");
			sc.close();
		}
	}
}