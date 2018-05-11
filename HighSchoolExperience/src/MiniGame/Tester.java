package MiniGame;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class Tester extends PApplet
{
	private BasketBall basketball;
	private Player player;
	private Arrow indicator;
	private Net net;
	private boolean[] keyPressed; //[left, right]
	public static void main(String[] args) 
	{
		PApplet.main("MiniGame.Tester");
	}
	
	public void settings()
	{
		size(300, 300);
	}
	
	public void setup()
	{
		int r = 5;
		player = new Player(new Rectangle(0, height - 20, 15, 20));
		indicator = new Arrow(player);
		net = new Net(new Rectangle(width-40,height/2,40,20));
		basketball = new BasketBall(r, height - r, r, player, net);
		keyPressed = new boolean[2];
	}
	
	public void draw()
	{
		background(255);
		indicator.display(this);
		indicator.adjustAngle(mouseX, mouseY);
		player.display(this);
		basketball.display(this);
		net.display(this);
	}
	
	public void keyPressed()
	{
		if(keyCode == KeyEvent.VK_ENTER)
			basketball.toss(indicator.getAngle(), 15);
		if(keyCode == KeyEvent.VK_A)
		{
			keyPressed[0] = true;
			player.moveBy(-5);
		}
		if(keyCode == KeyEvent.VK_D)
		{
			keyPressed[1] = true;
			player.moveBy(5);
		}
	}
	
	public void keyReleased()
	{
		if(keyCode == KeyEvent.VK_A)
			keyPressed[0] = false;
		if(keyCode == KeyEvent.VK_D)
			keyPressed[1] = false;
		
		if(keyPressed[0] && !keyPressed[1])
			player.moveBy(-5);
		else if(!keyPressed[0]&& keyPressed[1])
			player.moveBy(5);
		else if(!keyPressed[0] && !keyPressed[1])
			player.moveBy(0);
	}
	
	

}
