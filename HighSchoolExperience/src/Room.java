import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Room 
{
	// image
	private ArrayList<Door> exits;

	public Room()
	{
		exits = new ArrayList<Door>();
	}

	public abstract void display(int direction, PApplet drawer);
	
	public void addDoor(Door d)
	{
		exits.add(d);
	}
	
	public ArrayList<Door> getExits()
	{
		return exits;
	}
}
