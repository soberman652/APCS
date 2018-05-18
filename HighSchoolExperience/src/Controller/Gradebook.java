package Controller;
import java.util.ArrayList;
/**
 * 
 * @author sashaoberman
 *
 */
public class Gradebook {

	private ArrayList<Grade> grades;
	
	public Gradebook() {
		grades = new ArrayList<Grade>();
	}
	
	public Gradebook(ArrayList<Grade> grades) {
		this.grades = grades;
	}
	
	public double calcAverage() {
		
		double sum = 0;
		double count = 0;
		for (Grade x : grades) {
			sum += x.getPercentage();
			count ++;
		}
		
		double average = sum/count;
		
		return average;
		
	}
	
	
}
