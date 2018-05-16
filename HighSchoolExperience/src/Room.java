import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Room 
{
	// image
	private ArrayList<Door> exits;
	//private ArrayList<Obstacle> furniture;
	private String marker;

	public Room(String marker)
	{
		this.marker = marker;
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
	
	public boolean equals(Room other)
	{
		if(marker.equals(other.getMarker()))
			return true;
		else
			return false;
	}
	
	public String getMarker()
	{
		return marker;
	}
}
