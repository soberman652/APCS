package Hub;
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
public class QuestionManager extends JFrame {

	private History his;
	private Science sci;
	private Literature lit;
	private Mathematics mathematics;
	private JComboBox<String> question1, question2, question3, question4;
	private JButton doneButton;
	private Day day;
	private ArrayList<String> questions;
	private String[] answers1, answers2, answers3, answers4;
	private JPanel panHis, panSci, panLit, panMath;
	private int correctAnsPos;
	QuestionAnswers q;

	

	
	public QuestionManager() {
		
		questions = new ArrayList<String>();
		
		his = new History();
		his.addHQuestions();
		
		sci = new Science();
		sci.addSQuestions();
		
		lit = new Literature();
		lit.addLQuestions();
		
		mathematics = new Mathematics();
		mathematics.addMQuestions();
	}
	
	public boolean askQuestion(Course questionType, int questionNum) {

		
		
		if (questionType.isHistory())
			q = his.getQuestions().get(questionNum);
		else if (questionType.isMath())
			q = mathematics.getQuestions().get(questionNum);
		else if (questionType.isScience())
			q = sci.getQuestions().get(questionNum);	
		else 
			q = lit.getQuestions().get(questionNum);
		
		
		
		
		String question = q.getQuestion();
		String correctAnswer = q.getCorrectAnswer();
		ArrayList<String> incorrectAnswers = q.getIncorrectAnswers();
		
		int correctAnsPos = (int) (Math.random()*4);
		String[] answers = new String[4];
		answers[correctAnsPos] = correctAnswer;
	
		int j = 0;
		for (int i = 0; i < 4; i++) {
			if (i != correctAnsPos) {
				answers[i] = incorrectAnswers.get(j);
				j++;
			}
		}
		// call method to display and ask question with
		// String question, String[] answers[4], int correctAnsPos;
		// it should check that user chose correctAnsPos;
		// it should return boolean choseCorrect;

			
		boolean choseCorrect;
		
		System.out.println(question+"\n");
		for (int i=0; i<4; i++) {
			System.out.println((i+1)+". "+answers[i]);
		}
		System.out.println("\n");
		

		Scanner kboard = new Scanner (System.in);
		System.out.println("Answer: " );
		int x = kboard.nextInt();
		
		if (x == (correctAnsPos+1)) {
			System.out.println("Correct!\n");
			choseCorrect = true;
		}
		else {
			System.out.println("Incorrect. The correct answer is: "+ answers[correctAnsPos]);
			choseCorrect = false;
		}
	
		return choseCorrect;
	}


}
