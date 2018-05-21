package Hub;

import Minigame.MiniGamePortal;
import processing.core.PApplet;
import processing.core.PImage;

public class ActivityRoom extends Classroom
{
	private MiniGamePortal portal;
	
	public ActivityRoom(String name, int x, int y,PImage icon)
	{
		super(name, x, y, false);
		portal = new MiniGamePortal(icon);
	}
	
	public void display(int dir, PApplet drawer)
	{
		super.display(dir, drawer);
		portal.display(drawer);
	}
	
	public MiniGamePortal getPortal()
	{
		return portal;
	}
}
