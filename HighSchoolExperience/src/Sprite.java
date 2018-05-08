import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class Sprite extends Rectangle
{
	private int dx, dy;

	public Sprite(int x, int y, int w, int h)
	{
		this.setBounds(x, y, w, h);
		dx = 0;
		dy = 0;
	}
	
	public void display(PApplet drawer)
	{
		act();
		drawer.pushStyle();
		drawer.fill(0);
		drawer.rect(this.x, this.y, this.width, this.height);
		drawer.popStyle();
	}
	
	public void act()
	{
		this.x += dx;
		this.y += dy;
	}
	
	public void moveXBy(int x)
	{
		dx = x;
	}
	
	public void moveYBy(int y)
	{
		dy = y;
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
