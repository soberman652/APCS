import java.awt.Rectangle;

import processing.core.PApplet;

public class Door extends Rectangle
{
	private Room adjacent;
	private int direction;
	
	public Door(int direction, Rectangle bounds, Room adjacentRoom)
	{
		this.setBounds(bounds);
		this.direction = direction;
		adjacent = adjacentRoom;
	}
	
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.fill(150);
		drawer.rect(this.x, this.y, this.width, this.height);
		drawer.popStyle();
	}
	
	public Room exitTo()
	{
		return adjacent;
	}
	
	public int getDirection()
	{
		return direction;
	}
}
