package Academic;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import processing.core.PApplet;
import processing.data.StringDict;
/**
 * 
 * @author sashaoberman
 *
 */
public class QuestionManager// extends JFrame 
{
	private int questionNum, correctAnsPos;
	private ArrayList<QuestionAnswers> totalQuiz;
	private QuestionAnswers q;
	private Course classType;
	
	/**
	 * initilizes 20 quiz questions prepared for user's subject
	 * @param integer code for user's subject (1=history, 2=science, 3=literature, 4=mathematics)
	 */
	public QuestionManager(int type) 
	{
		questionNum = 1;
		
		if(type == 1)
			classType = new History();
		else if(type == 2)
			classType = new Science();
		else if(type == 3)
			classType = new Literature();
		else if(type == 4)
			classType = new Mathematics();
		
		totalQuiz = classType.getQuestions();
	}
	
	/**
	 * 
	 * @return the question user is currently on and 4 possible answers in randomized order([question, ans1, ans2, ans3, ans4])
	 * @pre current question number is valid (1 <= x <= 20)
	 */
	public String[] askQuestion()
	{
		q = totalQuiz.get(questionNum-1);
		String[] questionSet = new String[5];
		
		questionSet[0] = q.getQuestion();
		correctAnsPos = (int) (Math.random()*4)+1;
		questionSet[correctAnsPos] = q.getCorrectAnswer();
		
		ArrayList<String> incorrectAnswers = q.getIncorrectAnswers();
		int j = 0;
		for (int i = 1; i <= 4; i++) 
		{
			if (i != correctAnsPos) 
			{
				questionSet[i] = incorrectAnswers.get(j);
				j++;
			}
		}
		
		return questionSet;
	}
	
	/**
	 * 
	 * @param selected index in answer set array chosen by user([question, ans1, ans2, ans3, ans4]), 1 <= selected <= 4 
	 * @return true if selected answer matches correct answer of corresponding question that user is currently on
	 * @pre current question number is valid (1 <= x <= 20)
	 * @pre 1 <= selected <= 4
	 */
	public boolean isCorrect(int selected)
	{
		if(selected == correctAnsPos)
			return true;
		else
			return false;
	}
	
	/**
	 * @return index of correct answer of question set array ([question, ans1, ans2, ans3, ans4]), between 1 and 4 inclusive
	 * @pre current question number is valid (1 <= x <= 20)
	 */
	public int getCorrectAns()
	{
		return correctAnsPos;
	}
	
	/**
	 * increment question number
	 */
	public void nextQuestion()
	{
		questionNum++;
	}
	
	/**
	 * 
	 * @return current question number
	 */
	public int getQuestionNumber()
	{
		return questionNum;
	}
}
