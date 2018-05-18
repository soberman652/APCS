package Minigame;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Hub.GameWindow;
import Hub.Main;
import processing.core.PApplet;
import processing.core.PImage;

public class BallGame extends PApplet
{
	private BasketBall basketball;
	private Player player;
	private Arrow indicator;
	private Net net;
	private boolean[] keyPressed; //[left,right,up,down]
	private PImage floor, seats;
	private Main m;
	
	public BallGame(Main m)
	{
		this.m = m;
		
		player = new Player(new Rectangle(0, this.height-20, 15, 20));
		indicator = new Arrow(player);
		keyPressed = new boolean[4];
	}
	
	public void runMe()
	{
		super.setSize(500,545);
		super.sketchPath();
		super.initSurface();
		super.surface.startThread();
		
		pause(true);
	}
	
	public void pause(boolean paused) 
	{
		keyPressed = new boolean[4];
		if (paused)
			noLoop();
		else
			loop();
	}
	
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
	
	public void draw()
	{
		background(255);
		image(floor, 0, this.height-floor.height);
		image(seats, 0, this.height-floor.height-seats.height);
		indicator.display(this);
		indicator.adjustAngle(mouseX, mouseY);
		player.display(this, floor);
		basketball.display(this);
		net.display(this);
		net.check(basketball);
	}
	
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
