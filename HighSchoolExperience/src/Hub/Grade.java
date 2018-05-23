package Hub;
/**
 * 
 * @author sashaoberman
 *
 */
public class Grade {

	private char letterGrade;
	private double percentage;
	
	public Grade() {
		letterGrade = 'E';
		percentage = 0;
	}
	
	/**
	 * 
	 * @param grade letter grade (A, B, C, D, F)
	 */
	public Grade(char grade) {
		letterGrade = grade;
	}
	
	/**
	 * 
	 * @param grade percentage grade
	 */
	public Grade(double grade) {
		letterGrade = calcGrade(grade);
		percentage = grade;
	}
	
	/**
	 * 
	 * @param grade percentage grade
	 * @return letter equivalent of percentage
	 */
	public char calcGrade(double grade) {
		if (grade < 60) 
			return 'F';
		else if (grade < 70)
			return 'D';
		else if (grade < 80)
			return 'C';
		else if (grade < 90)
			return 'B';
		else 
			return 'A';
	}
	
	/**
	 * 
	 * @return percentage grade
	 */
	public double getPercentage() {
		return percentage;
	}
	 /**
	  * 
	  * @return
	  */
	public char getLetterGrade() {
		return letterGrade;
	}
	
	
}
