package Minigame;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

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
	
	public static void main(String[] args) 
	{
		PApplet.main("Minigame.BallGame");
	}
	
	public void settings()
	{
		size(500, 500);
	}
	
	public void setup()
	{
		int r = 5;
		player = new Player(new Rectangle(0, height-20, 15, 20));
		indicator = new Arrow(player);
		net = new Net(width, 200, loadImage("img\\net.gif"));
		basketball = new BasketBall(r, height - r, r, player, net);
		keyPressed = new boolean[4];
		floor = loadImage("img\\floor.jpg");
		floor.resize(500, floor.height);
		seats = loadImage("img\\bleachers.jpg");
		seats.resize(500, seats.height);
	}
	
	public void draw()
	{
		background(255);
		image(floor, 0, height-floor.height);
		image(seats, 0, height-floor.height-seats.height);
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
}
