package Hub;
/**
 * 
 * @author sashaoberman
 *
 */
public class Grade {

	private char letterGrade;
	private double percentage;
	
	/**
	 * Creates a default Grade object
	 */
	public Grade() {
		letterGrade = 'E';
		percentage = 0;
	}
	/**
	 * creates a Grade object with a given letter grade
	 * @param grade
	 */
	public Grade(char grade) {
		letterGrade = grade;
	}
	
	/**
	 * Creates a Grade object with a given percentage
	 * @param grade
	 */
	public Grade(double grade) {
		letterGrade = calcGrade(grade);
		percentage = grade;
	}
	
	/**
	 * calculates the average letter grade depending on the percentage
	 * @param grade
	 * @return calculated letter grade
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
	 * returns the percentage
	 * @return percentage
	 */
	public double getPercentage() {
		return percentage;
	}
	/**
	 * returns the letter grade
	 * @return letter grade
	 */
	public char getLetterGrade() {
		return letterGrade;
	}
	
	
}
