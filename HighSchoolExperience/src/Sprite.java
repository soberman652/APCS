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
		act(drawer);
		drawer.pushStyle();
		drawer.stroke(0);
		drawer.fill(255);
		drawer.rect(this.x, this.y, this.width, this.height);
		drawer.popStyle();
	}
	
	public void act(PApplet w)
	{
		if(this.x < 0)
			this.x = 0;
		else if(this.x + this.width > w.width)
			this.x = w.width - this.width;
		else
			this.x += dx;
		
		if(this.y < 0)
			this.y = 0;
		else if(this.y + this.height > w.height)
			this.y = w.height - this.height;
		else
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
