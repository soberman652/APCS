package Minigame;

import java.awt.Rectangle;

import Hub.GameWindow;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * represent object that user controls and can move around
 * @author Emily
 *
 */
public class Player extends Rectangle
{
	private int dx, dy;
	/**
	 * creates a player within a rectangle bound
	 * @param r boundary of player
	 */
	public Player(Rectangle r)
	{
		this.setBounds(r);
		dx = 0;
		dy = 0;
	}
	
	/**
	 * draw the player 
	 * @param drawer interace that draws the player
	 * @param floor picture of gym floor
	 */
	public void display(PApplet drawer, PImage floor)
	{
		drawer.pushStyle();
		drawer.fill(100);
		drawer.rect(this.x, this.y, this.width, this.height);
		drawer.popStyle();
		act(drawer, floor);
	}
	
	private void act(PApplet window, PImage floor)
	{
		this.x += dx;
		
		if(this.y+this.height < window.height - floor.height)
			this.y = window.height - floor.height-this.height;
		else if(this.y+this.height > window.height)
			this.y = window.height-this.height;
		else
			this.y += dy;
	}
	
	/**
	 * horizontally shifts player's location
	 * @param x pixels
	 */
	public void moveXBy(int x)
	{
		dx = x;
	}
	
	/**
	 * vertically shifts player's location
	 * @param y pixels
	 */
	public void moveYBy(int y)
	{
		dy = y;
	}
}
