package Hub;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

	
	/*
	public static void main(String[] args) {
		QuestionManager b = new QuestionManager();
		PApplet.main("TestTester");
	}
	*/
	
	
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

		QuestionAnswers q = null;
		
		if (questionType.isHistory())
			q = his.getQuestions().get(questionNum);
		else if (questionType.isMath())
			q = mathematics.getQuestions().get(questionNum);
		else if (questionType.isScience())
			q = sci.getQuestions().get(questionNum);	
		else if (questionType.isLiterature())
			q = lit.getQuestions().get(questionNum);
		
		String question = q.getQuestion();
		String correctAnswer = q.getCorrectAnswer();
		ArrayList<String> incorrectAnswers = q.getIncorrectAnswers();
		
		int correctAnsPos = (int) Math.random()*4;
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
		boolean choseCorrect = false;
		
		
		return choseCorrect;
		
	
	}
	
			/*
		ArrayList<String> groupedAnswers = new ArrayList<String>();
		
		if (questionType.isHistory())
		{		
			if (day > 0 && day <= 5) {
				for (int i = day; i < day + 4; i ++) {
					questions.add(his.getHisQuestions().get(i).getQuestion());
					//groupedAnswers = his.getHisQuestions().get(i).getAnswers();
					for (int j = 0; j < 4; j++) {
						groupedAnswers.add(his.getHisQuestions().get(i).getAnswers().get(j));
					}
				}
			}
			answers1 = new String[4];
			answers2 = new String[4];
			answers3 = new String[4];
			answers4 = new String[4];
			for (int i = 0; i < 4; i++) {
				answers1[i] = groupedAnswers.get(i);
				answers2[i] = groupedAnswers.get(i+4);
				answers3[i] = groupedAnswers.get(i+8);
				answers4[i] = groupedAnswers.get(i+12);
			}

			
			question1 = new JComboBox<String>(answers1);
			question1.setSelectedIndex(0);
			question1.addActionListener(this);
			question1.setPreferredSize(new Dimension(150, 100));
		}
			
		
		if (sci.isInUse()) {
			
			if (day.getDay() > 0 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(sci.getSciQuestions().get(i).getQuestion());
					//groupedAnswers = sci.getSciQuestions().get(i).getAnswers();
					for (int j = 0; j < 4; j++) {
						groupedAnswers.add(sci.getSciQuestions().get(i).getAnswers().get(j));
					}

				}
				answers1 = new String[4];
				answers2 = new String[4];
				answers3 = new String[4];
				answers4 = new String[4];
				for (int i = 0; i < 4; i++) {
					answers1[i] = groupedAnswers.get(i);
					answers2[i] = groupedAnswers.get(i+4);
					answers3[i] = groupedAnswers.get(i+8);
					answers4[i] = groupedAnswers.get(i+12);
				}
				
			}
			question2 = new JComboBox<String>(answers2);
			question2.setSelectedIndex(0);
			question2.addActionListener(this);
			question2.setPreferredSize(new Dimension(150, 100));
		}
		
		
		if (lit.isInUse()) {
			
			if (day.getDay() > 0 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(lit.getLitQuestions().get(i).getQuestion());
					//groupedAnswers = lit.getLitQuestions().get(i).getAnswers();
					for (int j = 0; j < 4; j++) {
						groupedAnswers.add(lit.getLitQuestions().get(i).getAnswers().get(j));
					}
				}
				answers1 = new String[4];
				answers2 = new String[4];
				answers3 = new String[4];
				answers4 = new String[4];
				for (int i = 0; i < 4; i++) {
					answers1[i] = groupedAnswers.get(i);
					answers2[i] = groupedAnswers.get(i+4);
					answers3[i] = groupedAnswers.get(i+8);
					answers4[i] = groupedAnswers.get(i+12);
				}
				
			}
			question3 = new JComboBox<String>(answers3);
			question3.setSelectedIndex(0);
			//question3.addActionListener(this);
			question3.addActionListener(this);
			question3.setPreferredSize(new Dimension(150, 100));
		}
		
		
		if (math.isInUse()) {
			
			if (day.getDay() > 0 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(math.getMathQuestions().get(i).getQuestion());
					//groupedAnswers = math.getMathQuestions().get(i).getAnswers();
					for (int j = 0; j < 4; j++) {
						groupedAnswers.add(math.getMathQuestions().get(i).getAnswers().get(j));
					}
				}
				answers1 = new String[4];
				answers2 = new String[4];
				answers3 = new String[4];
				answers4 = new String[4];
				for (int i = 0; i < 4; i++) {
					answers1[i] = groupedAnswers.get(i);
					answers2[i] = groupedAnswers.get(i+4);
					answers3[i] = groupedAnswers.get(i+8);
					answers4[i] = groupedAnswers.get(i+12);
					
				}
				
			}
			question4 = new JComboBox<String>(answers4);
			question4.setSelectedIndex(0);
			question4.addActionListener(this);
			question4.setPreferredSize(new Dimension(150, 100));
		}

	}
	
	public void settings()
	{
		size(600, 600);

	}
	public void draw() {
		background(250);
		fill(250);
		rect(100, 50, 400, 500);	
		int y = 0; 
		for (int i = 0; i < 4; i++){
			textSize(10);
			fill(50);
			text(questions.get(i), 115, y+100);
			y += 115;
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
*/
}
