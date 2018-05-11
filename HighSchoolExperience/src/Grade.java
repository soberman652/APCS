
public class Grade {

	private char letterGrade;
	private double percentage;
	
	public Grade() {
		letterGrade = 'E';
		percentage = 0;
	}
	
	public Grade(char grade) {
		letterGrade = grade;
	}
	
	public Grade(double grade) {
		letterGrade = calcGrade(grade);
		percentage = grade;
	}
	
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
	
	public double getPercentage() {
		return percentage;
	}
	
	public char getLetterGrade() {
		return letterGrade;
	}
	
	
}
