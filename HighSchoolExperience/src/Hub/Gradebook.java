package Hub;
import java.util.ArrayList;
/**
 * 
 * @author sashaoberman
 *
 */
public class Gradebook {

	private ArrayList<Grade> grades;
	/**
	 * Creates a Gradebook object
	 */
	public Gradebook() {
		grades = new ArrayList<Grade>();
	}
	
	/**
	 * Creates a Gradebook object
	 * @param grades
	 */
	public Gradebook(ArrayList<Grade> grades) {
		this.grades = grades;
	}
	
	/**
	 * Calculates the average of the grades in Gradebook
	 * @return average of grades
	 */
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
	
	/**
	 * calculates average letter grade
	 * @return average letter grade
	 */
	public String avgGrade()
	{
		double x = calcAverage();
		String grade = "";
		if(x >= 90)
			grade = "A";
		else if(x >= 80)
			grade = "B";
		else if(x >= 70)
			grade = "C";
		else if(x >= 60)
			grade = "D";
		else
			grade = "F";
		return grade;
	}
	
	/**
	 * adds grade to a Gradebook object
	 * @param g
	 */
	public void addGrade(Grade g)
	{
		grades.add(g);
	}
	
	
}
