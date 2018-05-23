package Hub;

import Minigame.MiniGamePortal;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * special room on campus that gives player access to a minigame
 * @author Emily
 *
 */
public class ActivityRoom extends Classroom
{
	private MiniGamePortal portal;
	
	/**
	 * 
	 * @param name title of room
	 * @param x x coordinate of room's location on map
	 * @param y y coordinate of room's location on map
	 * @param icon image that gives player access to play minigame
	 */
	public ActivityRoom(String name, int x, int y,PImage icon)
	{
		super(name, x, y, false);
		portal = new MiniGamePortal(icon);
	}
	
	@Override
	public void display(int dir, PApplet drawer)
	{
		super.display(dir, drawer);
		portal.display(drawer);
	}
	
	/**
	 * 
	 * @return object that represents minigame
	 */
	public MiniGamePortal getPortal()
	{
		return portal;
	}
}
