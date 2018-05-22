package Hub;
import java.awt.Rectangle;

import processing.core.PApplet;

public class Door extends Rectangle
{
	private Room adjacentRoom;
	private int direction;
	private String tag;
	private boolean showTag, visible;
	
	public Door(int direction,  Room adj, Rectangle bounds, String tag)
	{
		this.setBounds(bounds);
		this.direction = direction;
		adjacentRoom = adj;
		this.tag = tag;
		showTag = false;
		visible = false;
	}
	
	public void display(PApplet drawer)
	{
		visible = true;
		drawer.pushStyle();
		drawer.noStroke();
		drawer.fill(0);
		drawer.rect(x, y, width, height);
		
		if(showTag)
		{
			drawer.fill(0);
			drawer.textSize(10);
			drawer.textAlign(drawer.CENTER, drawer.TOP);
			drawer.text(tag, x+width/2, y+height+5);
		}
		drawer.popStyle();
	}
	
	public Room exitTo()
	{
		return adjacentRoom;	
	}
	
	public boolean hasEntered(Sprite player)
	{
		if(visible && this.intersects(player))
		{
			showTag = true;
			return true;
		}
		else
		{
			showTag = false;
			return false;
		}
	}
	
	public int getDirection()
	{
		return direction;
	}
	
	public void invisible()
	{
		visible = false;
	}
}
