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
	//private  game;

	public Student(String name, int classType) {
		this.classType = classType;
		this.name = name;
	}
	public Student() {
		this.classType = 0;
		this.name = "John";
		//this.activity = activity;
	}
	
	public void setClassType (int classType) {
		this.classType = classType;
	}
	
	public int getClassType () {
		return classType;
	}
	
	
}
