import java.util.ArrayList;

import javax.swing.JRadioButton;

import processing.core.PApplet;

public class TestTester extends PApplet {

	private History his;
	private Science sci;
	private Literature lit;
	private Math math;
	
	public static void main(String[] args) {
		
		PApplet.main("TestTester");
		

	}
	
	public void settings()
	{
		size(600, 600);
		
		his = new History();
		his.addHQuestions();
		
		sci = new Science();
		sci.addSQuestions();
		
		lit = new Literature();
		lit.addLQuestions();
		
		math = new Math();
		math.addMQuestions();
	}
	
	public void setup()
	{
		
		
	}
	
	
	public void draw() {
		background(250);
		fill(250);
		rect(100, 50, 400, 500);
		
		int y = 0; 
		for (int i = 0; i < 4; i++){
			textSize(10);
			fill(50);
			text(his.getHisQuestions().get(i).getQuestion(), 115, y+100);
			JRadioButton s = new JRadioButton(his.getHisQuestions().get(i).getCorrectAnswer());
			y += 115;
		}
		
		
		
	}
	

}
