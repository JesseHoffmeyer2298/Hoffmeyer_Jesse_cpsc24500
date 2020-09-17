// Jesse Hoffmeyer  
import java.util.Random; 
import java.lang.Math;
public class CircleCalc {
	public static double calcCircumference(double radius) {
		double circ = 2 * Math.PI * radius; 
		return circ; 
	}
	public static double calcArea(double radius) {
		double area = Math.PI * (radius * radius); 
		return area; 
	}
	
	public static void main(String[] args) {
		Random rng = new Random();
		double radius = rng.nextInt(50); 
		double circ = calcCircumference(radius);
		double area = calcArea(radius); 
		System.out.printf("The Area of a circle with radius %.0f. is %.2f.\n",radius, area); 
		System.out.printf("The Circumference of a circle with radius %.0f. is %.2f.",radius, circ); 
		
				
}
}
