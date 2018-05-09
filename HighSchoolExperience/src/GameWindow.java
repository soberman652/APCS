import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class GameWindow extends PApplet
{
	private Sprite student;
	private boolean[] arrowKeyPressed = new boolean[4]; //[Left,Right,Down,Up]
	
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
		student = new Sprite(width/2, height/2, 25, 35);
	}
	
	public void draw()
	{
		background(255);
		student.display(this);
	}
	
	public void keyPressed()
	{
		if(keyCode == KeyEvent.VK_LEFT)
		{
			student.moveXBy(-3);
			arrowKeyPressed[0] = true;
		}
		if(keyCode == KeyEvent.VK_RIGHT)
		{
			student.moveXBy(3);
			arrowKeyPressed[1] = true;
		}
		if(keyCode == KeyEvent.VK_DOWN)
		{
			student.moveYBy(3);
			arrowKeyPressed[2] = true;
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			student.moveYBy(-3);
			arrowKeyPressed[3] = true;
		}
	}
	
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
