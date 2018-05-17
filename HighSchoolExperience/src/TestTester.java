import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


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

	
	
	public static void main(String[] args) {
		TestTester b = new TestTester();
		PApplet.main("TestTester");
	}
	
	
	public TestTester() {
		
		day = new Day();
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
		
		if (his.isInUse()) {
			if (day.getDay() == 1) {
				for (int i = 0; i < 4; i++) {
					questions.add(his.getHisQuestions().get(i).getQuestion());
				}	
			}
			if (day.getDay() > 1 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(his.getHisQuestions().get(i).getQuestion());
				}
			}
		}
			
		
		if (sci.isInUse()) {
			if (day.getDay() == 1) {
				for (int i = 0; i < 4; i++) {
					questions.add(sci.getSciQuestions().get(i).getQuestion());
				}	
			}
			if (day.getDay() > 1 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(sci.getSciQuestions().get(i).getQuestion());
				}
			}
		}
		
		
		if (lit.isInUse()) {
			if (day.getDay() == 1) {
				for (int i = 0; i < 4; i++) {
					questions.add(lit.getLitQuestions().get(i).getQuestion());
				}	
			}
			if (day.getDay() > 1 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(lit.getLitQuestions().get(i).getQuestion());
				}
			}
		}
		
		
		if (math.isInUse()) {
			if (day.getDay() == 1) {
				for (int i = 0; i < 4; i++) {
					questions.add(math.getMathQuestions().get(i).getQuestion());
				}	
			}
			if (day.getDay() > 1 && day.getDay() <= 5) {
				for (int i = day.getDay(); i < day.getDay() + 4; i ++) {
					questions.add(math.getMathQuestions().get(i).getQuestion());
				}
			}
		}
		
	}
	
	public void settings()
	{
		size(600, 600);
		
		
		
		
		/*
		question1 = new JComboBox<String>(genderList);
		genderOptionList.setSelectedIndex(0);
		genderOptionList.addActionListener(this);
		genderOptionList.setPreferredSize(new Dimension(150, 100));
		*/
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
			//text(his.getHisQuestions().get(i).getQuestion(), 115, y+100);
			// = new JRadioButton(his.getHisQuestions().get(i).getCorrectAnswer());
			y += 115;
		}
		
		
		
	}
	

}
