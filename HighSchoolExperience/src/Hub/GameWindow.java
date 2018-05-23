package Hub;
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
	private boolean[] arrowKeyPressed;//[Left,Right,Down,Up]
	private StressBar stress;
	private Gradebook grades;
	private boolean showMap, takeQuiz;
	private ArrayList<Classroom> campus;
	private Room currentLocation;
	private PImage mapLayout, deadState;
	private ArrayList<PImage> studentImg, mapCursor;
	private Map map;
	private int userDir, playGame;
	public static final int NORTH = 1, EAST = 2, SOUTH = 3, WEST = 4; //direction user is facing 
	public static final int WALL_HEIGHT= 90;
	
	public static final int DRAWING_WIDTH = 500;
	public static final int DRAWING_HEIGHT = 500;
	
	/**
	 * 
	 * @param m contains main method that will display this panel
	 * @param access to student's stress levels
	 */
	public GameWindow(Main m, StressBar stress, Gradebook grades)
	{
		super();
		this.m = m;
		studentImg = new ArrayList<PImage>();
		mapCursor = new ArrayList<PImage>();
		userDir = NORTH;
		showMap = false;
		arrowKeyPressed = new boolean[4];
		playGame = -1;
		this.stress = stress;
		this.grades = grades;
	}
	
	/**
	 * initiates the surface to begin displaying
	 */
	public void runMe() {
		super.setSize(500,500);
		super.sketchPath();
		super.initSurface();
		super.surface.startThread();
		
		pause(true);
	}
	
	/**
	 * initialize images
	 */
	public void setup()
	{
		mapLayout = loadImage("img\\CampusMap.png");
		PImage north = loadImage("img\\mapNorth.png");
		north.resize((int)(((double)30/north.height)*north.width), 30);
		PImage east = loadImage("img\\mapEast.png");
		east.resize((int)(((double)30/east.height)*east.width), 30);
		PImage south = loadImage("img\\mapSouth.png");
		south.resize((int)(((double)30/south.height)*south.width), 30);
		PImage west = loadImage("img\\mapWest.png");
		west.resize((int)(((double)30/west.height)*west.width), 30);
		mapCursor.add(north);
		mapCursor.add(east);
		mapCursor.add(south);
		mapCursor.add(west);
		
		PImage studentL = loadImage("img\\NewStudentLeft.png");
		studentL.resize((int)(80.0/studentL.height * studentL.width), 80);
		PImage studentR = loadImage("img\\NewStudentRight.png");
		studentR.resize((int)(80.0/studentR.height * studentR.width), 80);
		studentImg.add(studentL);
		studentImg.add(studentR);
		studentImg.add(loadImage("img\\NewStudentLeft.png"));
		studentImg.add(loadImage("img\\NewStudentRight.png"));
		student = new Sprite(width/2, height/2, studentImg);
		deadState = loadImage("img\\DeadStudent.png");
		initCampus();
		
		map = new Map(mapLayout,mapCursor,campus);
	}
	
	/**
	 * puts all components of game window together and displays them
	 */
	public void draw()
	{
		if(stress.isCompletelyStressed())
		{
			background(50);
			image(deadState, this.DRAWING_WIDTH/2 - deadState.width/2, this.DRAWING_HEIGHT/2 - deadState.height/2);
			fill(255,0,0);
			textAlign(CENTER, CENTER);
			textSize(30);
			text("YOU FAINTED FROM EXHAUSTION", this.DRAWING_WIDTH/2, this.DRAWING_HEIGHT/2+50);
			text("Grade: " + grades.avgGrade(), this.DRAWING_WIDTH/2, this.DRAWING_HEIGHT/2+90);
		}
		else
		{
			background(255);
			/*
			float ratio = (float)height/m.HEIGHT;

			this.scale(ratio,ratio);
			*/
			currentLocation.display(userDir, this);
			for(Door d:currentLocation.getExits())
			{
				d.hasEntered(student);
			}
			student.display(this);
			stress.display(this);
			
			textSize(15);
			if(currentLocation.getMarker().equals("Stage"))
			{
				ActivityRoom r = (ActivityRoom)currentLocation;
				if(student.intersects(r.getPortal()))
				{
					
					playGame = 2;
					textAlign(CENTER);
					fill(0);
					text("Press ENTER to play music", r.getPortal().x+r.getPortal().width/2, r.getPortal().y+10);
				}
				else
					playGame = -1;
			}
			
			if(currentLocation.getMarker().equals("Gym"))
			{
				ActivityRoom r = (ActivityRoom)currentLocation;
				if(student.intersects(r.getPortal()))
				{
					
					playGame = 1;
					textAlign(CENTER);
					fill(0);
					text("Press ENTER to play basketball", r.getPortal().x+r.getPortal().width/2, r.getPortal().y+10);
				}
				else
					playGame = -1;
			}
			
			if(currentLocation.getMarker().equals("Room A") || currentLocation.getMarker().equals("Room B") || currentLocation.getMarker().equals("Room D") || currentLocation.getMarker().equals("Room E"))
			{
				Classroom c = (Classroom)currentLocation;
				if(c.canTakeQuiz(student))
				{
					takeQuiz = true;
					textAlign(CENTER);
					fill(0);
					text("Press ENTER to take quiz", this.DRAWING_WIDTH/2, this.DRAWING_HEIGHT/2);
				}
				else
					takeQuiz = false;
			}
			
			if(showMap)
			{
				if(!(currentLocation.getMarker().equals("Home")))
				{
					Classroom c = (Classroom)currentLocation;
					map.setCurrentRoom(c);
					map.setDir(userDir);
					map.display(this);
				}
			}
		}
		
	}
	
	/**
	 * detects certain keys that have a function
	 */
	public void keyPressed()
	{
		if(keyCode == KeyEvent.VK_LEFT)
		{
			student.moveXBy(-5);
			student.switchImg(1);
			arrowKeyPressed[0] = true;
		}
		if(keyCode == KeyEvent.VK_RIGHT)
		{
			student.moveXBy(5);
			student.switchImg(2);
			arrowKeyPressed[1] = true;
		}
		if(keyCode == KeyEvent.VK_DOWN)
		{
			student.moveYBy(5);
			arrowKeyPressed[2] = true;
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			student.moveYBy(-5);
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
			{
				currentLocation = enteredDoor.exitTo();
				student.moveTo(student.x, DRAWING_HEIGHT-student.height);
			}
		}
		
		if(keyCode == KeyEvent.VK_SHIFT)
		{
			if(!(currentLocation.getMarker().equals("Home")))
				showMap = true;
		}
		
		if(keyCode == KeyEvent.VK_ENTER)
		{
			if(playGame == 1)
				m.changePanel("4");
			else if(playGame == 2)
				m.changePanel("5");
			else if(takeQuiz)
				m.changePanel("6");
		}
	}
	
	/**
	 * deactivates functions that were activated by keys
	 */
	public void keyReleased()
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
	
	private void initCampus()
	{
		campus = new ArrayList<Classroom>();
		Home bedroom = new Home(loadImage("img\\BedroomFloor.png"), loadImage("img\\bed.png"));

		Classroom center = new Classroom("Student Center",240,310, false);
		ActivityRoom stage = new ActivityRoom("Stage",140,330, loadImage("img\\musicIcon.png"));
		ActivityRoom gym =  new ActivityRoom("Gym",340,330,loadImage("img\\BasketballIcon.png"));
		Classroom wing = new Classroom("Hall",240,210, false);
		Classroom roomA = new Classroom("Room A",150,250, true);
		Classroom roomB = new Classroom("Room B",150,175, true);
		Classroom roomC = new Classroom("Room C",240,125,false);
		Classroom roomD = new Classroom("Room D",330,175,true);
		Classroom roomE = new Classroom("Room E",330,250,true);
		
		campus.add(center);//0
		campus.add(stage);//1
		campus.add(gym);//2
		campus.add(wing);//3
		campus.add(roomA);//4
		campus.add(roomB);//5
		campus.add(roomC);//6
		campus.add(roomD);//7
		campus.add(roomE);//8
		
		Door homeDoor = new Door(NORTH, center, new Rectangle(50, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Go to school");
		bedroom.addDoor(homeDoor);
		
		Door centerS = new Door(SOUTH, bedroom, new Rectangle(DRAWING_WIDTH/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Go home");
		Door centerW = new Door(WEST, stage, new Rectangle(DRAWING_WIDTH/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Stage");
		Door centerE = new Door(EAST, gym, new Rectangle(DRAWING_WIDTH/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Gym");
		Door centerN = new Door(NORTH, wing, new Rectangle(DRAWING_WIDTH/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Classrooms");
		center.addDoor(centerS);
		center.addDoor(centerW);
		center.addDoor(centerE);
		center.addDoor(centerN);
		
		Door stageDoor = new Door(EAST, center, new Rectangle(125-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Student Center");
		stage.addDoor(stageDoor);
		
		Door gymDoor = new Door(WEST, center, new Rectangle((DRAWING_WIDTH-125)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Student Center");
		gym.addDoor(gymDoor);
		
		Door hallExit = new Door(SOUTH, center, new Rectangle(DRAWING_WIDTH/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Student Center");
		Door a1 = new Door(WEST, roomA, new Rectangle(160-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room A");
		Door b1 = new Door(WEST, roomB, new Rectangle((DRAWING_WIDTH-160)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room B");
		Door c1 = new Door(NORTH, roomC, new Rectangle(DRAWING_WIDTH/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room C");
		Door d1 = new Door(EAST, roomD, new Rectangle(160-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room D");
		Door e1 = new Door(EAST, roomE, new Rectangle((DRAWING_WIDTH-160)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Room E");
		wing.addDoor(hallExit);
		wing.addDoor(a1);
		wing.addDoor(b1);
		wing.addDoor(c1);
		wing.addDoor(d1);
		wing.addDoor(e1);
		
		Door a2 = new Door(EAST, wing, new Rectangle(125-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomA.addDoor(a2);
		Door b2 = new Door(EAST, wing, new Rectangle((DRAWING_WIDTH-125)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomB.addDoor(b2);
		Door c2 = new Door(SOUTH, wing, new Rectangle(DRAWING_WIDTH/2-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomC.addDoor(c2);
		Door d2 = new Door(WEST, wing, new Rectangle(125-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomD.addDoor(d2);
		Door e2 = new Door(WEST, wing, new Rectangle((DRAWING_WIDTH-125)-(student.width+10)/2, WALL_HEIGHT-student.height-5, student.width+10, student.height+5), "Exit class");
		roomE.addDoor(e2);

		this.currentLocation = bedroom;
	}
	
	/**
	 * 
	 * @param paused true if want to pause program from running; false otherwise
	 */
	public void pause(boolean paused) {
		arrowKeyPressed = new boolean[4];
		if (paused)
			noLoop();
		else
			loop();
	}
}