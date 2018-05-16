import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Simulates school campus
 * 
 * @author emily
 *
 */
public class GameWindow extends PApplet
{
	private Main m;
	private Sprite student;
	private boolean[] arrowKeyPressed = new boolean[4];
	private boolean showMap; //[Left,Right,Down,Up]
	private ArrayList<Room> campus;
	private Room currentLocation;
	private int userDir, state;
	private PImage map;
	public static final int NORTH = 1, EAST = 2, SOUTH = 3, WEST = 4; //direction user is facing 
	public static final int MENU = 0, GAME = 1;
	public static final int WALL_HEIGHT= 90;
	
	/*
	public static void main(String args[])
	{
		PApplet.main("GameWindow");
	}
	*/
	public GameWindow(Main m)
	{
		this.m = m;
	}
	/*
	public void runMe() {
		super.initSurface();
		super.surface.startThread();
		
		pause(true);
	}
	*/
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
		map = loadImage("img\\CampusMap.png");
		showMap = false;
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
			
			if(showMap)
				displayMap(this);
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
				student.moveXBy(-5);
				student.switchImg(2);
				arrowKeyPressed[0] = true;
			}
			if(keyCode == KeyEvent.VK_RIGHT)
			{
				student.moveXBy(5);
				student.switchImg(3);
				arrowKeyPressed[1] = true;
			}
			if(keyCode == KeyEvent.VK_DOWN)
			{
				student.moveYBy(5);
				student.switchImg(1);
				arrowKeyPressed[2] = true;
			}
			if(keyCode == KeyEvent.VK_UP)
			{
				student.moveYBy(-5);
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
			
			if(keyCode == KeyEvent.VK_SHIFT)
				showMap = true;
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
				student.moveXBy(-5);
			else if(!arrowKeyPressed[0] && arrowKeyPressed[1])
				student.moveXBy(5);
			else if(!arrowKeyPressed[0] && !arrowKeyPressed[1])
				student.moveXBy(0);
			
			if(arrowKeyPressed[2] && !arrowKeyPressed[3])
				student.moveYBy(5);
			else if(!arrowKeyPressed[2] && arrowKeyPressed[3])
				student.moveYBy(-5);
			else if(!arrowKeyPressed[2] && !arrowKeyPressed[3])
				student.moveYBy(0);
			
			if(keyCode == KeyEvent.VK_SHIFT)
				showMap = false;
		}
	}
	
	private void initCampus()
	{
		campus = new ArrayList<Room>();
		Home bedroom = new Home(loadImage("img\\BedroomFloor.png"), loadImage("img\\bed.png"));
		campus.add(bedroom);

		Classroom center = new Classroom("Student Center",240,310);
		Classroom stage = new Classroom("Stage",140,330);
		Classroom gym =  new Classroom("Gym",340,330);
		Classroom wing = new Classroom("Hall",240,210);
		Classroom roomA = new Classroom("Room A",150,250);
		Classroom roomB = new Classroom("Room B",150,175);
		Classroom roomC = new Classroom("Room C",240,125);
		Classroom roomD = new Classroom("Room D",330,175);
		Classroom roomE = new Classroom("Room E",330,250);
		
		
		Door homeDoor = new Door(NORTH, center, new Rectangle(50, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Go to school");
		bedroom.addDoor(homeDoor);
		
		Door centerS = new Door(SOUTH, bedroom, new Rectangle(width/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Go home");
		Door centerW = new Door(WEST, stage, new Rectangle(width/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Stage");
		Door centerE = new Door(EAST, gym, new Rectangle(width/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Gym");
		Door centerN = new Door(NORTH, wing, new Rectangle(width/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Classrooms");
		center.addDoor(centerS);
		center.addDoor(centerW);
		center.addDoor(centerE);
		center.addDoor(centerN);
		
		Door stageDoor = new Door(EAST, center, new Rectangle(125-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Student Center");
		stage.addDoor(stageDoor);
		
		Door gymDoor = new Door(WEST, center, new Rectangle((width-125)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Student Center");
		gym.addDoor(gymDoor);
		
		Door hallExit = new Door(SOUTH, center, new Rectangle(width/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Student Center");
		Door a1 = new Door(WEST, roomA, new Rectangle(160-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room A");
		Door b1 = new Door(WEST, roomB, new Rectangle((width-160)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room B");
		Door c1 = new Door(NORTH, roomC, new Rectangle(width/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room C");
		Door d1 = new Door(EAST, roomD, new Rectangle(160-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room D");
		Door e1 = new Door(EAST, roomE, new Rectangle((width-160)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room E");
		wing.addDoor(hallExit);
		wing.addDoor(a1);
		wing.addDoor(b1);
		wing.addDoor(c1);
		wing.addDoor(d1);
		wing.addDoor(e1);
		
		Door a2 = new Door(EAST, wing, new Rectangle(125-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomA.addDoor(a2);
		Door b2 = new Door(EAST, wing, new Rectangle((width-125)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomB.addDoor(b2);
		Door c2 = new Door(SOUTH, wing, new Rectangle(width/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomC.addDoor(c2);
		Door d2 = new Door(WEST, wing, new Rectangle(125-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomD.addDoor(d2);
		Door e2 = new Door(WEST, wing, new Rectangle((width-125)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomE.addDoor(e2);

		this.currentLocation = bedroom;
	}
	
	private void displayMap(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.fill(100, 200);
		drawer.rect(0, 0, drawer.width, drawer.height);
		drawer.image(map, 0, 0);
		drawer.popStyle();
	}
}
