package Hub;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * environment of panel
 * @author Emily
 *
 */
public abstract class Room 
{
	private ArrayList<Door> exits;
	private String marker;
	
	/**
	 * intializes the components in a room
	 * @param marker title linked with current room
	 */
	public Room(String marker)
	{
		this.marker = marker;
		exits = new ArrayList<Door>();
	}
	/**
	 * draw room environment
	 * @param direction which cardinal direction player is facing
	 * @param drawer interface that draws the room
	 */
	public abstract void display(int direction, PApplet drawer);
	
	/**
	 * add an entrance/exit that transport player to another room
	 * @param d door that appears in current room
	 */
	public void addDoor(Door d)
	{
		exits.add(d);
	}
	
	/**
	 * 
	 * @return all doors that are linked with the room
	 */
	public ArrayList<Door> getExits()
	{
		return exits;
	}
	
	/**
	 * 
	 * @param other room that is being compared with
	 * @return true if this is the same room as other; false otherwise
	 */
	public boolean equals(Room other)
	{
		if(marker.equals(other.getMarker()))
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @return title identifier of room
	 */
	public String getMarker()
	{
		return marker;
	}
}
