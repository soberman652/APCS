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
	
	/**
	 * 
	 * @return list of questions with corresponding answers
	 */
	public abstract ArrayList<QuestionAnswers> getQuestions();
}
