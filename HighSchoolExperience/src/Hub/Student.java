package Hub;

import Academic.Course;

/**
 * 
 * @author sashaoberman
 *
 */
public class Student {

	private int classType; // 1=history, 2=science, 3=literature, 4=mathematics
	private String name;
	private int score; // cumulative 
	private int numGames;
	private double runAvg;

	/**
	 * Creates a Student object
	 * @param name - name of the student
	 * @param classType - class the student chooses
	 */
	public Student(String name, int classType) {
		this.classType = classType;
		this.name = name;
		score = 0;
		numGames = 0;
		runAvg = 0;
	}
	
	/**
	 * creates a default Student object
	 */
	public Student() {
		this.classType = 1;
		this.name = "John";
		score = 0;
		numGames = 0;
		runAvg = 0;
	}
	
	/**
	 * sets the classType
	 * @param classType - the class the student chose
	 */
	public void setClassType (int classType) {
		this.classType = classType;
	}
	
	/**
	 * sets the name of the Student
	 * @param name - the name the student chose
	 */
	public void setName (String name) {
		this.name = name;
	}
	
	/**
	 * updates the score and keeps an average
	 * @param score - score that was just attained
	 */
	public void updateScore (int score) {
		this.score += score;
		numGames++;
		runAvg = (double) this.score / (double) numGames;
	}
	
	/**
	 * gets the score of the student
	 * @return the score
	 */
	public int getScore () {
		return score;
	}
	
	/**
	 * the average of the scores
	 * @return the running average of the scores
	 */
	public double getRunAvg () {
		return runAvg;
	}
	
	/**
	 * gets the class type the student chose
	 * @return the class type
	 */
	public int getClassType () {
		return classType;
	}
	
	/**
	 * gets the name of the student
	 * @return the name of the student
	 */
	public String getName() {
		return name;
	}
	
	
	
}
