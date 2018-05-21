package Academic;

import java.util.ArrayList;

/**
 * 
 * @author sashaoberman
 *
 */
public abstract class Course 
{
	private int subject;

	// default course to History
	public Course() {
		subject = 0;
	}
	
	public abstract ArrayList<QuestionAnswers> getQuestions();
	
	/*
	public void setHistory() {
		subject = 0;
	}
	public void setLiterature() {
		subject = 1;
	}
	public void setScience() {
		subject = 2;
	}
	public void setMath() {
		subject = 3;
	}

	public boolean isHistory() {
		return subject == 0;
	}
	public boolean isLiterature() {
		return subject == 1;
	}
	public boolean isScience() {
		return subject == 2;
	}
	public boolean isMath() {
		return subject == 3;
	}
	*/
}
