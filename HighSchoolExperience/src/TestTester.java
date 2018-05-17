import java.awt.Dimension;
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
/**
 * 
 * @author sashaoberman
 *
 */
public class TestTester extends PApplet {

	private History his;
	private Science sci;
	private Literature lit;
	private Math math;
	private JComboBox<String> question1, question2, question3, question4;
	private JButton doneButton;
	private Day day;
	private ArrayList<String> questions;
	private String[] answers1, answers2, answers3, answers4;

	
	
	public static void main(String[] args) {
		TestTester b = new TestTester();
		PApplet.main("TestTester");
	}
	
	
	public TestTester() {
		
		day = new Day(3);
		questions = new ArrayList<String>();
		
		his = new History();
		his.addHQuestions();
		
		sci = new Science();
		sci.addSQuestions();
		
		lit = new Literature();
		lit.addLQuestions();
		
		math = new Math();
		math.addMQuestions();
		
		sci.setInUse();
		
		ArrayList<String> groupedAnswers = new ArrayList<String>();
		
		if (his.isInUse()) {
			
			if (day.getDay() > 0 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(his.getHisQuestions().get(i).getQuestion());
					groupedAnswers = his.getHisQuestions().get(i).getAnswers();
				}
			}
			answers1 = new String[4];
			for (int i = 0; i < 4; i++) {
				answers1[i] = groupedAnswers.get(i);
			}
			answers2 = new String[4];
			for (int i = 4; i < 8; i++) {
				answers2[i] = groupedAnswers.get(i);
			}
			answers3 = new String[4];
			for (int i = 8; i < 12; i++) {
				answers3[i] = groupedAnswers.get(i);
			}
			answers4 = new String[4];
			for (int i = 12; i < 16; i++) {
				answers4[i] = groupedAnswers.get(i);
			}
			
			question1 = new JComboBox<String>(answers1);
			question1.setSelectedIndex(0);
			question1.addActionListener((ActionListener) this);
			question1.setPreferredSize(new Dimension(150, 100));
		}
			
		
		if (sci.isInUse()) {
			
			if (day.getDay() > 0 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(sci.getSciQuestions().get(i).getQuestion());
					groupedAnswers = sci.getSciQuestions().get(i).getAnswers();

				}
				answers1 = new String[4];
				for (int i = 0; i < 4; i++) {
					answers1[i] = groupedAnswers.get(i);
				}
				answers2 = new String[4];
				for (int i = 4; i < 8; i++) {
					answers2[i] = groupedAnswers.get(i);
				}
				answers3 = new String[4];
				for (int i = 8; i < 12; i++) {
					answers3[i] = groupedAnswers.get(i);
				}
				answers4 = new String[4];
				for (int i = 12; i < 16; i++) {
					answers4[i] = groupedAnswers.get(i);
				}
			}
			question2 = new JComboBox<String>(answers2);
			question2.setSelectedIndex(0);
			question2.addActionListener((ActionListener) this);
			question2.setPreferredSize(new Dimension(150, 100));
		}
		
		
		if (lit.isInUse()) {
			
			if (day.getDay() > 0 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(lit.getLitQuestions().get(i).getQuestion());
					groupedAnswers = lit.getLitQuestions().get(i).getAnswers();
				}
				answers1 = new String[4];
				for (int i = 0; i < 4; i++) {
					answers1[i] = groupedAnswers.get(i);
				}
				answers2 = new String[4];
				for (int i = 4; i < 8; i++) {
					answers2[i] = groupedAnswers.get(i);
				}
				answers3 = new String[4];
				for (int i = 8; i < 12; i++) {
					answers3[i] = groupedAnswers.get(i);
				}
				answers4 = new String[4];
				for (int i = 12; i < 16; i++) {
					answers4[i] = groupedAnswers.get(i);
				}
			}
			question3 = new JComboBox<String>(answers3);
			question3.setSelectedIndex(0);
			//question3.addActionListener(this);
			question3.addActionListener((ActionListener) this);
			question3.setPreferredSize(new Dimension(150, 100));
		}
		
		
		if (math.isInUse()) {
			
			if (day.getDay() > 0 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(math.getMathQuestions().get(i).getQuestion());
					groupedAnswers = math.getMathQuestions().get(i).getAnswers();
				}
				answers1 = new String[4];
				for (int i = 0; i < 4; i++) {
					answers1[i] = groupedAnswers.get(i);
				}
				answers2 = new String[4];
				for (int i = 4; i < 8; i++) {
					answers2[i] = groupedAnswers.get(i);
				}
				answers3 = new String[4];
				for (int i = 8; i < 12; i++) {
					answers3[i] = groupedAnswers.get(i);
				}
				answers4 = new String[4];
				for (int i = 12; i < 16; i++) {
					answers4[i] = groupedAnswers.get(i);
				}
			}
			question4 = new JComboBox<String>(answers4);
			question4.setSelectedIndex(0);
			question4.addActionListener((ActionListener) this);
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
	

}
