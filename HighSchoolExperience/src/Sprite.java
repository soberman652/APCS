import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * This represents a moving character that can only move inside bounds of window.
 * 
 * @author eyao600
 *
 */
public class Sprite extends Rectangle
{
	private int dx, dy, imgID;
	private PImage img;

	public Sprite(int x, int y, PImage img)
	{
		this.setBounds(x, y, img.width, img.height);
		this.img = img;
		imgID = 1;
		dx = 0;
		dy = 0;
	}
	
	public void display(PApplet drawer)
	{
		act(drawer);
		drawer.pushStyle();
		drawer.stroke(0);
		drawer.fill(255);
		if(imgID == 1)
			img = drawer.loadImage("img\\StudentFrontWalk.gif");
		else if(imgID == 2)
			img = drawer.loadImage("img\\StudentLeftWalk.gif");
		else if(imgID == 3)
			img = drawer.loadImage("img\\StudentRightWalk.gif");
		drawer.image(img, x, y);
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
	
	public void switchImg(int id)
	{
		imgID = id;
	}
}
