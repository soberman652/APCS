import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Simulates school campus
 * 
 * @author emily
 *
 */
public class GameWindow extends PApplet
{
	private Sprite student;
	private boolean[] arrowKeyPressed = new boolean[4]; //[Left,Right,Down,Up]
	private ArrayList<Room> campus;
	private Room currentLocation;
	private int userDir, state;
	public static final int NORTH = 1, EAST = 2, SOUTH = 3, WEST = 4; //direction user is facing 
	public static final int MENU = 0, GAME = 1;
	
	public static void main(String args[])
	{
		PApplet.main("GameWindow");
	}
	
	public void settings()
	{
		size(500, 500);
	}
	
	public void setup()
	{
		background(255);
		userDir = NORTH;
		state = MENU;
		student = new Sprite(width/2, height/2, loadImage("img\\StudentFrontWalk.gif"));
		initCampus();
	}
	
	public void draw()
	{
		if(state == MENU)
		{
			fill(0);
			textSize(24);
		    textAlign(CENTER);
		    text("Press ENTER to start: High School Experience", 450, 320);
		}
		else if(state == GAME)
		{
			background(255);
			currentLocation.display(userDir, this);
			for(Door d:currentLocation.getExits())
			{
				d.hasEntered(student);
			}
			student.display(this);
		}
	}
	
	public void keyPressed()
	{
		if(state == MENU)
		{
			if (keyCode == KeyEvent.VK_ENTER)
			{
				state = GAME;
			}
		}
		else if(state == GAME)
		{
			if(keyCode == KeyEvent.VK_LEFT)
			{
				student.moveXBy(-3);
				student.switchImg(2);
				arrowKeyPressed[0] = true;
			}
			if(keyCode == KeyEvent.VK_RIGHT)
			{
				student.moveXBy(3);
				student.switchImg(3);
				arrowKeyPressed[1] = true;
			}
			if(keyCode == KeyEvent.VK_DOWN)
			{
				student.moveYBy(3);
				student.switchImg(1);
				arrowKeyPressed[2] = true;
			}
			if(keyCode == KeyEvent.VK_UP)
			{
				student.moveYBy(-3);
				student.switchImg(1);
				arrowKeyPressed[3] = true;
			}
			
			if(keyCode == KeyEvent.VK_A)
			{
				if(userDir == NORTH)
					userDir = WEST;
				else
					userDir--;
			}
			if(keyCode == KeyEvent.VK_D)
			{
				if(userDir == WEST)
					userDir = NORTH;
				else
					userDir++;
			}
			
			if(keyCode == KeyEvent.VK_SPACE)
			{
				Door enteredDoor = null;
				for(Door d : currentLocation.getExits())
				{
					if(d.hasEntered(student))
					{
						enteredDoor = d;
					}
				}
				
				if(enteredDoor != null)
					currentLocation = enteredDoor.exitTo();
			}
		}
	}
	
	public void keyReleased()
	{
		if(state == GAME)
		{
			if(keyCode == KeyEvent.VK_LEFT)
				arrowKeyPressed[0] = false;
			if(keyCode == KeyEvent.VK_RIGHT)
				arrowKeyPressed[1] = false;
			if(keyCode == KeyEvent.VK_DOWN)
				arrowKeyPressed[2] = false;
			if(keyCode == KeyEvent.VK_UP)
				arrowKeyPressed[3] = false;
			
			if(arrowKeyPressed[0] && !arrowKeyPressed[1])
				student.moveXBy(-3);
			else if(!arrowKeyPressed[0] && arrowKeyPressed[1])
				student.moveXBy(3);
			else if(!arrowKeyPressed[0] && !arrowKeyPressed[1])
				student.moveXBy(0);
			
			if(arrowKeyPressed[2] && !arrowKeyPressed[3])
				student.moveYBy(3);
			else if(!arrowKeyPressed[2] && arrowKeyPressed[3])
				student.moveYBy(-3);
			else if(!arrowKeyPressed[2] && !arrowKeyPressed[3])
				student.moveYBy(0);
		}
	}
	
	private void initCampus()
	{
		campus = new ArrayList<Room>();
		Home bedroom = new Home();
		//home -> student center
		campus.add(bedroom);
		Classroom a = new Classroom("Room A");
		campus.add(a);
		Classroom b = new Classroom("Room B");
		campus.add(b);
		Classroom c = new Classroom("Room C");
		campus.add(c);
		Classroom d = new Classroom("Room D");
		campus.add(d);
		
		Door ab = new Door(EAST, b, new Rectangle(100,50,25,35), "To Room B");
		Door ad = new Door(SOUTH, d, new Rectangle(100,50,25,35), "To Room D");
		a.addDoor(ab);
		a.addDoor(ad);
		
		Door bc = new Door(SOUTH, c, new Rectangle(100,50,25,35), "To Room C");
		Door ba = new Door(WEST, a, new Rectangle(100,50,25,35), "To Room A");
		b.addDoor(bc);
		b.addDoor(ba);
		
		Door cd = new Door(WEST, d, new Rectangle(100,50,25,35), "To Room D");
		Door cb = new Door(NORTH, b, new Rectangle(100,50,25,35), "To Room B");
		c.addDoor(cd);
		c.addDoor(cb);
		
		Door da = new Door(NORTH, a, new Rectangle(100,50,25,35), "To Room A");
		Door dc = new Door(EAST, c, new Rectangle(100,50,25,35), "To Room C");
		d.addDoor(da);
		d.addDoor(dc);
		
		currentLocation = campus.get(0);
		
		//redo doors so each face of a door is its own object
	}
	
	private void addConnection(Room r1, Rectangle a, Room r2, Rectangle b)
	{
		int dir = 0;
	}
}
