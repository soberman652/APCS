package Minigame;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Hub.GameWindow;
import Hub.Main;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * creates small simulation of shooting a ball into a basketball hoop
 * @author Emily
 *
 */
public class BallGame extends PApplet
{
	private BasketBall basketball;
	private Player player;
	private Arrow indicator;
	private Net net;
	private boolean[] keyPressed; //[left,right,up,down]
	private PImage floor, seats;
	private Main m;
	
	/**
	 * initializes the components of the program
	 * @param m contains main method that will display this
	 */
	public BallGame(Main m)
	{
		this.m = m;
		
		player = new Player(new Rectangle(0, this.height-20, 15, 20));
		indicator = new Arrow(player);
		keyPressed = new boolean[4];
	}
	
	/**
	 * initiates the surface to begin displaying
	 */
	public void runMe()
	{
		super.setSize(500,545);
		super.sketchPath();
		super.initSurface();
		super.surface.startThread();
		
		pause(true);
	}
	
	/**
	 * 
	 * @param paused true if want to pause program from running; false otherwise
	 */
	public void pause(boolean paused) 
	{
		keyPressed = new boolean[4];
		if (paused)
			noLoop();
		else
			loop();
	}
	
	/**
	 * collects images
	 */
	public void setup()
	{
		net = new Net(this.width, 200, loadImage("img\\net.gif"));
		int r = 5;
		basketball = new BasketBall(r, GameWindow.DRAWING_HEIGHT - r, r, player, net);
		floor = loadImage("img\\floor.jpg");
		floor.resize(500, floor.height);
		seats = loadImage("img\\bleachers.jpg");
		seats.resize(500, seats.height);
	}
	
	/**
	 * displays graphics of this game
	 */
	public void draw()
	{
		background(255);
		image(floor, 0, this.height-floor.height);
		image(seats, 0,  this.height-floor.height-seats.height);
		textAlign(LEFT, TOP);
		fill(0);
		text("Press BACKSPACE to stop playing ball", 5, 5);
		indicator.display(this);
		indicator.adjustAngle(mouseX, mouseY);
		player.display(this, floor);
		basketball.display(this);
		net.display(this);
		net.check(basketball);
	}
	
	/**
	 * detects keys that will perform functions to play the game
	 */
	public void keyPressed()
	{
		if(keyCode == KeyEvent.VK_SPACE)
			basketball.toss(indicator.getAngle(), 20);
		if(keyCode == KeyEvent.VK_A)
		{
			keyPressed[0] = true;
			player.moveXBy(-5);
		}
		if(keyCode == KeyEvent.VK_D)
		{
			keyPressed[1] = true;
			player.moveXBy(5);
		}
		if(keyCode == KeyEvent.VK_W)
		{
			keyPressed[2] = true;
			player.moveYBy(-5);
		}
		if(keyCode == KeyEvent.VK_S)
		{
			keyPressed[3] = true;
			player.moveYBy(5);
		}
		if(keyCode == KeyEvent.VK_BACK_SPACE)
			m.changePanel("3");
		
	}
	
	public void keyReleased()
	{
		if(keyCode == KeyEvent.VK_A)
			keyPressed[0] = false;
		if(keyCode == KeyEvent.VK_D)
			keyPressed[1] = false;
		if(keyCode == KeyEvent.VK_W)
			keyPressed[2] = false;			
		if(keyCode == KeyEvent.VK_S)
			keyPressed[3] = false;
		
		if(keyPressed[0] && !keyPressed[1])
			player.moveXBy(-5);
		else if(!keyPressed[0]&& keyPressed[1])
			player.moveXBy(5);
		else if(!keyPressed[0] && !keyPressed[1])
			player.moveXBy(0);
		
		if(keyPressed[2] && !keyPressed[3])
			player.moveYBy(-5);
		else if(!keyPressed[2]&& keyPressed[3])
			player.moveYBy(5);
		else if(!keyPressed[2] && !keyPressed[3])
			player.moveYBy(0);
	}
	/**
	 * resets all components to the beginning
	 */
	public void reset() 
	{
		int r = 5;
		player = new Player(new Rectangle(0, GameWindow.DRAWING_HEIGHT-20, 15, 20));
		indicator = new Arrow(player);
		net = new Net(GameWindow.DRAWING_WIDTH, 200, loadImage("img\\net.gif"));
		basketball = new BasketBall(r, GameWindow.DRAWING_HEIGHT - r, r, player, net);
		keyPressed = new boolean[4];
	}
}
