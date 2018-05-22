package Hub;
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

	/**
	 * creates a movable character
	 * @param x x coordinate of sprite's top left point
	 * @param y y coordinate of sprite's top right point
	 * @param img collection of sprite's images
	 */
	public Sprite(int x, int y, ArrayList<PImage> img)
	{
		this.setBounds(x, y, img.get(0).width, img.get(0).height);
		this.img = img;
		imgID = 1;
		dx = 0;
		dy = 0;
	}
	
	/**
	 * 
	 * @param drawer interface that displays this
	 */
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
		drawer.popStyle();
	}
	
	private void act(PApplet w)
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
	
	/**
	 * set how fast sprite moves horizontally
	 * @param x how many pixels sprite moves each frame
	 */
	public void moveXBy(int x)
	{
		dx = x;
	}
	
	/**
	 * set how fast sprite moves vertically
	 * @param y how many pixels sprite moves each frame
	 */
	public void moveYBy(int y)
	{
		dy = y;
	}
	
	/**
	 * set sprite's center location to point
	 * @param x x coordinate of location
	 * @param y y coordinate of location
	 */
	public void moveTo(int x, int y)
	{
		this.x = x - this.width/2;
		this.y = y - this.height;
	}
	
	/**
	 * change the image displaying the sprite
	 * @param id identifies which image to use that is already stored inside (1-2)
	 */
	public void switchImg(int id)
	{
		imgID = id;
	}
	
	/**
	 * 
	 * @return bottom center point of sprite
	 */
	public Point getCoord()
	{
		return new Point(this.x/2, this.y+this.height);
	}
}
