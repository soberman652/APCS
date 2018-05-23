package Hub;
import java.awt.Rectangle;

import processing.core.PApplet;

/**
 * small opening for player to travel between rooms
 * @author Emily
 *
 */
public class Door extends Rectangle
{
	private Room adjacentRoom;
	private int direction;
	private String tag;
	private boolean showTag, visible;
	
	/**
	 * 
	 * @param direction which face of a room the door is on (N, S, E, W)
	 * @param adj adjacent room that door connects to
	 * @param bounds rectangle boundaries of door
	 * @param tag text that appears once player gets near door
	 */
	public Door(int direction,  Room adj, Rectangle bounds, String tag)
	{
		this.setBounds(bounds);
		this.direction = direction;
		adjacentRoom = adj;
		this.tag = tag;
		showTag = false;
		visible = false;
	}
	
	/**
	 * draws a black rectangle that represents door
	 * @param drawer interface that draws door
	 */
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
	
	/**
	 * 
	 * @return return access to the adjacent room this door leads to
	 */
	public Room exitTo()
	{
		return adjacentRoom;	
	}
	
	/**
	 * detects if player is within boundaries of door
	 * @param player player that enters door
	 * @return true if player intersects with door bounds; false otherwise
	 */
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
	
	/**
	 * 
	 * @return which face of the room door is on (N,S,E,W)
	 */
	public int getDirection()
	{
		return direction;
	}
	
	/**
	 * stops door from displaying on window
	 */
	public void invisible()
	{
		visible = false;
	}
}
