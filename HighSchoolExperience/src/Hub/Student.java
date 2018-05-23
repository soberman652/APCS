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

	public Student(String name, int classType) {
		this.classType = classType;
		this.name = name;
		score = 0;
		numGames = 0;
		runAvg = 0;
	}
	public Student() {
		this.classType = 1;
		this.name = "John";
		score = 0;
		numGames = 0;
		runAvg = 0;
	}
	
	public void setClassType (int classType) {
		this.classType = classType;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void updateScore (int score) {
		this.score += score;
		numGames++;
		runAvg = (double) this.score / (double) numGames;
	}
	
	public int getScore () {
		return score;
	}
	
	public double getRunAvg () {
		return runAvg;
	}
	
	public int getClassType () {
		return classType;
	}
	
	public String getName() {
		return name;
	}
	
	
	
}
