package MusicGame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;

public class Tester extends PApplet
{
	private ArrayList<Note> notes;
	private int count, good, totalNotes;
	private ArrayList<Integer> sheet;
	private boolean[] numPressed;
	private boolean playing;
	private Sign symbol;
	public static final int SPACE = 30, FPB = 15;
	
	public static void main(String[] args) 
	{
		PApplet.main("MusicGame.Tester");
	}
	
	public void settings()
	{
		size(300, 300);
	}
	
	public void setup()
	{
		notes = new ArrayList<Note>();
		count = 0;
		good = 0;
		sheet = MusicReader.readFile("odeToJoy");
		totalNotes = 0;
		for(Integer i : sheet)
		{
			if(i != 0)
				totalNotes++;
		}
		playing = true;
		numPressed = new boolean[5];
		symbol = null;
	}
	
	public void draw()
	{
		if(!playing && notes.size() == 0)
		{
			background(100);
			int result = (int)(100*((double)good/totalNotes));
			textAlign(CENTER, CENTER);
			text(result+"%", width/2, height/2);
		}
		else
		{
			background(255);
			initStaff(this);
			if(count/FPB < sheet.size())
			{
				if(count % FPB == 0)
				{
					int i = sheet.get(count/FPB);
					if(i != 0)
						notes.add(new Note(i, 3, width));	
				}
				count++;
			}
			else
				playing = false;
			
			if(notes.size() != 0)
			{
				for(Note n : notes)
					n.display(this);
				if(notes.get(0).getX() < 5)
				{
					if(notes.size() != 0)
						notes.remove(0);
					symbol = new Sign(-1);
				}
			}
			
			if(symbol != null)
			{
				symbol.display(this);
			}
		}
	}

	public void keyPressed()
	{
		if(notes.size() != 0)
		{
			if(keyCode == KeyEvent.VK_1)
			{
				numPressed[0] = true;
				if(notes.get(0).hit(50) == -1 && notes.get(0).getPitch() != 1)
					symbol = new Sign(-1);
				else
				{
					good++;
					symbol = new Sign(1);
				}
				notes.remove(0);
			}
			if(keyCode == KeyEvent.VK_2)
			{
				numPressed[1] = true;
				if(notes.get(0).hit(50) == -1 && notes.get(0).getPitch() != 2)
					symbol = new Sign(-1);
				else
				{
					good++;
					symbol = new Sign(1);
				}
				notes.remove(0);
			}
			if(keyCode == KeyEvent.VK_3)
			{
				numPressed[2] = true;
				if(notes.get(0).hit(50) == -1 && notes.get(0).getPitch() != 3)
					symbol = new Sign(-1);
				else
				{
					good++;
					symbol = new Sign(1);
				}
				notes.remove(0);
			}
			if(keyCode == KeyEvent.VK_4)
			{
				numPressed[3] = true;
				if(notes.get(0).hit(50) == -1 && notes.get(0).getPitch() != 4)
					symbol = new Sign(-1);
				else
				{
					good++;
					symbol = new Sign(1);
				}
				notes.remove(0);
			}
			if(keyCode == KeyEvent.VK_5)
			{
				numPressed[4] = true;
				if(notes.get(0).hit(50) == -1 && notes.get(0).getPitch() != 5)
					System.out.println("miss");
				else
				{
					good++;
					symbol = new Sign(1);
				}
				notes.remove(0);
			}
		}
	}
	
	public void keyReleased()
	{
		if(notes.size() != 0)
		{
			if(keyCode == KeyEvent.VK_1)
				numPressed[0] = false;
			if(keyCode == KeyEvent.VK_2)
				numPressed[1] = false;
			if(keyCode == KeyEvent.VK_3)
				numPressed[2] = false;
			if(keyCode == KeyEvent.VK_4)
				numPressed[3] = false;
			if(keyCode == KeyEvent.VK_5)
				numPressed[4] = false;
		}
	}
	
	public void initStaff(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.textSize(20);
		drawer.textAlign(drawer.CENTER, drawer.BOTTOM);
		
		drawer.stroke(0);
		drawer.strokeWeight(2);
		drawer.line(drawer.width/2-2*SPACE, 50, drawer.width/2-2*SPACE, drawer.height);
		drawer.line(drawer.width/2-SPACE, 50, drawer.width/2-SPACE, drawer.height);
		drawer.line(drawer.width/2, 50, drawer.width/2, drawer.height);
		drawer.line(drawer.width/2+SPACE, 50, drawer.width/2+SPACE, drawer.height);
		drawer.line(drawer.width/2+2*SPACE, 50, drawer.width/2+2*SPACE, drawer.height);
		drawer.strokeWeight(5);
		drawer.line(drawer.width/2-2*SPACE, 50, drawer.width/2+2*SPACE, 50);
		
		drawer.fill(0);
		if(numPressed[0])
			drawer.fill(0,0,255);
		drawer.text("1", drawer.width/2-2*SPACE, 40);
		drawer.fill(0);
		if(numPressed[1])
			drawer.fill(0,0,255);
		drawer.text("2", drawer.width/2-SPACE, 40);
		drawer.fill(0);
		if(numPressed[2])
			drawer.fill(0,0,255);
		drawer.text("3", drawer.width/2, 40);
		drawer.fill(0);
		if(numPressed[3])
			drawer.fill(0,0,255);
		drawer.text("4", drawer.width/2+SPACE, 40);
		drawer.fill(0);
		if(numPressed[4])
			drawer.fill(0,0,255);
		drawer.text("5", drawer.width/2+2*SPACE, 40);
		drawer.popStyle();
	}

}
