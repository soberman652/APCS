import java.awt.Rectangle;

import processing.core.PApplet;

public class Door extends Rectangle
{
	private Room room1, room2;
	private int dir1, dir2;
	
	public Door(int dir1,  Room room1, int dir2, Room room2, Rectangle bounds)
	{
		this.setBounds(bounds);
		this.dir1 = dir1;
		this.dir2 = dir2;
		room1.addDoor(this);
		room2.addDoor(this);
		this.room1 = room1;
		this.room2 = room2;
	}
	
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.fill(150);
		drawer.rect(this.x, this.y, this.width, this.height);
		drawer.popStyle();
	}
	
	public Room exitTo(Room currentRoom)
	{
		if(currentRoom.equals(room1))
			return room2;
		else if(currentRoom.equals(room2))
			return room1;
		else
			return null;
	}
	
	public boolean hasEntered(Sprite player)
	{
		if(this.intersects(player))
		{
			return true;
		}
		else
			return false;
	}
	
	public int getDirection(Room currentRoom)
	{
		if(currentRoom.equals(room1))
			return dir1;
		else if(currentRoom.equals(room2))
			return dir2;
		else
			return -1;
	}
}
