import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class GameWindow extends PApplet
{
	private Sprite student;
	
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
			student.moveXBy(-3);
		if(keyCode == KeyEvent.VK_RIGHT)
			student.moveXBy(3);
		if(keyCode == KeyEvent.VK_UP)
			student.moveYBy(-3);
		if(keyCode == KeyEvent.VK_DOWN)
			student.moveYBy(3);
	}
	
	public void keyReleased()
	{
		if(keyCode == KeyEvent.VK_LEFT)
			student.moveXBy(0);
		if(keyCode == KeyEvent.VK_RIGHT)
			student.moveXBy(0);
		if(keyCode == KeyEvent.VK_UP)
			student.moveYBy(0);
		if(keyCode == KeyEvent.VK_DOWN)
			student.moveYBy(0);
	}
}
