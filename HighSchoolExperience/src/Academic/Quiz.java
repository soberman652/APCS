package Academic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

import Hub.GameWindow;
import Hub.Main;
import processing.core.PApplet;
/**
 * creates small multiple choice quiz 
 * @author Emily
 *
 */
public class Quiz extends PApplet
{
	private Main m;
	private String question, aChoice, bChoice, cChoice, dChoice;
	private boolean aOver, bOver, cOver, dOver;
	private int aX, aY, bX, bY, cX, cY, dX, dY;
	private int rectWidth, rectHeight;
	private Color highlight, correct, wrong;
	private final int WIDTH = GameWindow.DRAWING_WIDTH, HEIGHT = GameWindow.DRAWING_HEIGHT;
	
	private int classType; // 1=history, 2=science, 3=literature, 4=mathematics
	private int selectedIndex, totalQ, totalCorrect;
	private boolean completed;
	private QuestionManager manager;
	private String[] currentSet;
	
	private boolean answered;
	
	/**
	 * 
	 * @param m contains main method that displays this
	 */
	public Quiz(Main m)
	{
		this.m = m;
		aOver = false;
		bOver = false;
		cOver = false;
		dOver = false;
		
		rectWidth = 220;
		rectHeight = 105;
		aX = 20;
		aY = HEIGHT/2; 
		bX = aX+rectWidth+20;
		bY = HEIGHT/2; 
		cX = aX;
		cY = aY+rectHeight+20;
		dX = bX; 
		dY = bY+rectHeight+20;
		highlight = new Color(255,251,137);
		correct = new Color(159, 255, 124);
		wrong = new Color(255, 91, 91);
		
		classType = 4;
		manager = new QuestionManager(classType);
		answered = false;
		totalQ = 20;
		totalCorrect = 0;
		completed = false;
		ask();
	}
	
	public void reset()
	{
		classType = m.getPlayerClassType();
		manager = new QuestionManager(classType);
		aOver = false;
		bOver = false;
		cOver = false;
		dOver = false;
		answered = false;
		totalQ = 20;
		totalCorrect = 0;
		completed = false;
		ask();
	}
	
	/**
	 * displays contents of the surface
	 */
	public void runMe() {
		super.setSize(500,500);
		super.sketchPath();
		super.initSurface();
		super.surface.startThread();
		
		pause();
	}
	
	/**
	 * 
	 * @param paused true if want to pause program from running; false otherwise
	 */
	public void pause(boolean paused) 
	{
		if (paused)
			noLoop();
		else
			loop();
	}
	
	/**
	 * set window size
	 */
	public void settings()
	{
		size(500,500);
	}
	
	/**
	 * displays components of the quiz
	 */
	public void draw()
	{
		if(completed)
		{
			background(200);
			textAlign(CENTER, CENTER);
			fill(255);
			int result = (int)(100*((double)totalCorrect/totalQ));
			String grade;
			if(result >= 90)
				grade = "A";
			else if(result >= 80)
				grade = "B";
			else if(result >= 70)
				grade = "C";
			else if(result >= 60)
				grade = "D";
			else
				grade = "F";
			text(grade + "\n" + result + "%\nPress SPACE to end class", WIDTH/2, HEIGHT/2);
		}
		else
		{
			background(255);
			if(aOver())
			{
				aOver = true;
				bOver = false;
				cOver = false;
				dOver = false;
			}
			else if(bOver())
			{
				aOver = false;
				bOver = true;
				cOver = false;
				dOver = false;
			}
			else if(cOver())
			{
				aOver = false;
				bOver = false;
				cOver = true;
				dOver = false;
			}
			else if(dOver())
			{
				aOver = false;
				bOver = false;
				cOver = false;
				dOver = true;
			}
			else
			{
				aOver = false;
				bOver = false;
				cOver = false;
				dOver = false;
			}
			noStroke();
			if(answered)
			{
				int correctIndex = manager.getCorrectAns();
				if(selectedIndex == 1)
					this.fill(wrong.getRGB());
				else 
					this.fill(200);
				if(correctIndex == 1)
					this.fill(correct.getRGB());
				rect(aX, aY, rectWidth, rectHeight);
				
				if(selectedIndex == 2)
					this.fill(wrong.getRGB());
				else 
					this.fill(200);
				if(correctIndex == 2)
					this.fill(correct.getRGB());
				rect(bX, bY, rectWidth, rectHeight);
				
				if(selectedIndex == 3)
					this.fill(wrong.getRGB());
				else 
					this.fill(200);
				if(correctIndex == 3)
					this.fill(correct.getRGB());
				rect(cX, cY, rectWidth, rectHeight);
				
				if(selectedIndex == 4)
					this.fill(wrong.getRGB());
				else 
					this.fill(200);
				if(correctIndex == 4)
					this.fill(correct.getRGB());
				rect(dX, dY, rectWidth, rectHeight);
				
				textAlign(CENTER, CENTER);
				textSize(14);
				fill(0);
				if(manager.getQuestionNumber() < 20)
					text("Press SPACE to go to the next question", WIDTH/2, aY+rectHeight+10);
				else
					text("Press SPACE to end quiz", WIDTH/2, HEIGHT-10);
			}
			else
			{
				if(aOver)
					this.fill(highlight.getRed(), highlight.getGreen(), highlight.getBlue());
				else 
					this.fill(200);
				rect(aX, aY, rectWidth, rectHeight);
				
				if(bOver)
					this.fill(highlight.getRed(), highlight.getGreen(), highlight.getBlue());
				else 
					this.fill(200);
				rect(bX, bY, rectWidth, rectHeight);
				
				if(cOver)
					this.fill(highlight.getRed(), highlight.getGreen(), highlight.getBlue());
				else 
					this.fill(200);
				rect(cX, cY, rectWidth, rectHeight);
				
				if(dOver)
					this.fill(highlight.getRed(), highlight.getGreen(), highlight.getBlue());
				else
					this.fill(200);
				rect(dX, dY, rectWidth, rectHeight);
			}
			
			
			fill(0);
			textAlign(LEFT, TOP);
			textSize(23);
			text("A", aX+5, aY+5);
			text("B", bX+5, bY+5);
			text("C", cX+5, cY+5);
			text("D", dX+5, dY+5);
			textSize(30);
			text("#" + manager.getQuestionNumber() + "/" + totalQ, 5, 5);
			
			textAlign(CENTER, CENTER);
			textSize(18);
			aChoice = adjustText(aChoice, rectWidth-20);
			bChoice = adjustText(bChoice, rectWidth-20);
			cChoice = adjustText(cChoice, rectWidth-20);
			dChoice = adjustText(dChoice, rectWidth-20);
			text(aChoice, aX+rectWidth/2, aY+rectHeight/2);
			text(bChoice, bX+rectWidth/2, bY+rectHeight/2);
			text(cChoice, cX+rectWidth/2, cY+rectHeight/2);
			text(dChoice, dX+rectWidth/2, dY+rectHeight/2);
			
			textSize(30);
			question = adjustText(question, WIDTH-40);
			text(question, WIDTH/2, HEIGHT/4);
		}
		
	}
	
	/**
	 * detect certain mouse activities to select an answer
	 */
	public void mousePressed()
	{
		if(!answered && manager.getQuestionNumber() <= totalQ)
		{
			if(aOver)
			{
				answered = true;
				selectedIndex = 1;
			}
			else if(bOver)
			{
				answered = true;
				selectedIndex = 2;
			}
			else if(cOver)
			{
				answered = true;
				selectedIndex = 3;
			}
			else if(dOver)
			{
				answered = true;
				selectedIndex = 4;
			}
			
			if(manager.isCorrect(selectedIndex))
				totalCorrect++;
		}
	}
	
	/**
	 * detects certain keys that have functions
	 */
	public void keyPressed()
	{
		if(keyCode == KeyEvent.VK_SPACE)
		{
			if(!completed)
			{
				if(manager.getQuestionNumber() < totalQ && answered)
				{
					manager.nextQuestion();
					answered = false;
					ask();
				}
				else if(manager.getQuestionNumber() >= totalQ)
					completed = true;
			}
			else
				m.changePanel("3");
		}
	}
	
	private boolean aOver()
	{
		if (mouseX >= aX && mouseX <= aX+rectWidth && mouseY >= aY && mouseY <= aY+rectHeight)
			return true;
		else
			return false;
	}
	
	private boolean bOver()
	{
		if (mouseX >= bX && mouseX <= bX+rectWidth && mouseY >= bY && mouseY <= bY+rectHeight)
			return true;
		else
			return false;
	}
	
	private boolean cOver()
	{
		if (mouseX >= cX && mouseX <= cX+rectWidth && mouseY >= cY && mouseY <= cY+rectHeight)
			return true;
		else
			return false;
	}
	
	private boolean dOver()
	{
		if (mouseX >= dX && mouseX <= dX+rectWidth && mouseY >= dY && mouseY <= dY+rectHeight)
			return true;
		else
			return false;
	}
	
	private void ask()
	{
		currentSet = manager.askQuestion();
		question = currentSet[0];
		aChoice = currentSet[1];
		bChoice = currentSet[2];
		cChoice = currentSet[3];
		dChoice = currentSet[4];
	}
	
	private String adjustText(String str, int bound)
	{
		String remainder = str, adjusted = "";
		int remainderWidth = (int)textWidth(remainder);
		while(remainderWidth > bound)
		{
			String[] s = {remainder, ""};
			s = newLines(s, bound);
			adjusted += s[0];
			remainder = s[1];
			remainderWidth = (int)textWidth(remainder);
		}
		adjusted += remainder;
		return adjusted;
	}
	
	private String[] newLines(String[] s, int bound)
	{
		if(textWidth(s[0]) < bound)
		{
			s[0] += '\n';
			return s;
		}
		else
		{
			int lastWord = s[0].lastIndexOf(' ', s[0].length()-2);
			s[1] = s[0].substring(lastWord+1) + s[1];
			s[0] = s[0].substring(0, lastWord+1);
			return newLines(s, bound);
		}
	}
}
