package Minigame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Hub.GameWindow;
import Hub.Main;
import processing.core.PApplet;

public class MusicGame extends PApplet
{
	private ArrayList<Note> notes;
	private int count, good, totalNotes;
	private ArrayList<Integer> sheet;
	private boolean[] numPressed;
	private boolean playing;
	private Sign symbol;
	private Main m;
	public static final int SPACE = 30, FPB = 15;
	
	public MusicGame(Main m)
	{
		this.m = m;
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

	public void runMe()
	{
		super.setSize(500,500);
		super.sketchPath();
		super.initSurface();
		super.surface.startThread();
		
		pause(true);
	}
	
	public void pause(boolean paused) 
	{
		numPressed = new boolean[5];
		if (paused)
			noLoop();
		else
			loop();
	}
	
	public void draw()
	{
		if(!playing && notes.size() == 0)
		{
			background(100);
			int result = (int)(100*((double)good/totalNotes));
			textAlign(CENTER, CENTER);
			text(result+"% correct\nPress SPACE to end activity", GameWindow.DRAWING_WIDTH/2, GameWindow.DRAWING_HEIGHT/2);
			String grade = "";
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
				if(notes.get(0).hit(50) == -1 || notes.get(0).getPitch() != 1)
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
				if(notes.get(0).hit(50) == -1 || notes.get(0).getPitch() != 2)
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
				if(notes.get(0).hit(50) == -1 || notes.get(0).getPitch() != 3)
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
				if(notes.get(0).hit(50) == -1 || notes.get(0).getPitch() != 4)
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
				if(notes.get(0).hit(50) == -1 || notes.get(0).getPitch() != 5)
					symbol = new Sign(-1);
				else
				{
					good++;
					symbol = new Sign(1);
				}
				notes.remove(0);
			}
		}
		else
		{
			if(keyCode == KeyEvent.VK_SPACE)
				m.changePanel("3");
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
		drawer.stroke(255,0,0);
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

	public void reset() 
	{	
		notes = new ArrayList<Note>();
		count = 0;
		good = 0;
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

}
