package Controller;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
	private ArrayList<PImage> img;

	public Sprite(int x, int y, ArrayList<PImage> img)
	{
		this.setBounds(x, y, img.get(0).width, img.get(0).height);
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
			drawer.image(img.get(0), x, y);
		else if(imgID == 2)
			drawer.image(img.get(1), x, y);
		else if(imgID == 3)
			drawer.image(img.get(2), x, y);
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
		
		if(this.y+this.height < GameWindow.WALL_HEIGHT)
			this.y = GameWindow.WALL_HEIGHT-this.height;
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
		this.x = x - this.width/2;
		this.y = y - this.height;
	}
	
	public void switchImg(int id)
	{
		imgID = id;
	}
	
	public Point getCoord()
	{
		return new Point(this.x/2, this.y+this.height);
	}
}
