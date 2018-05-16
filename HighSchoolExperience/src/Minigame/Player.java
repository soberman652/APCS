package Minigame;

import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends Rectangle
{
	private int dx, dy;
	public Player(Rectangle r)
	{
		this.setBounds(r);
		dx = 0;
		dy = 0;
	}
	
	public void display(PApplet drawer, PImage floor)
	{
		drawer.pushStyle();
		drawer.fill(100);
		drawer.rect(this.x, this.y, this.width, this.height);
		drawer.popStyle();
		act(drawer, floor);
	}
	
	public void act(PApplet window, PImage floor)
	{
		this.x += dx;
		
		if(this.y+this.height < window.height - floor.height)
			this.y = window.height - floor.height-this.height;
		else if(this.y+this.height > window.height)
			this.y = window.height-this.height;
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
}
