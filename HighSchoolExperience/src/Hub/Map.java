package Hub;
import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * represents layout of entire campus that shows player's current location
 * @author Emily
 *
 */
public class Map 
{
	private ArrayList<Rectangle> rooms;
	private ArrayList<Classroom> campus;
	private Classroom current;
	private PImage map;
	private ArrayList<PImage> cursor;
	private int dir;
	
	/**
	 * 
	 * @param map picture of entire map
	 * @param cursor picture symbol for player's location
	 * @param campus list of existing rooms
	 */
	public Map(PImage map, ArrayList<PImage> cursor, ArrayList<Classroom> campus)
	{
		rooms = new ArrayList<Rectangle>();
		rooms.add(new Rectangle(191,264,96,96));
		rooms.add(new Rectangle(191,164,96,96));
		rooms.add(new Rectangle(101,289,86,86));
		rooms.add(new Rectangle(291,289,86,86));
		rooms.add(new Rectangle(116,214,71,71));
		rooms.add(new Rectangle(116,139,71,71));
		rooms.add(new Rectangle(203,89,71,71));
		rooms.add(new Rectangle(291,139,71,71));
		rooms.add(new Rectangle(291,214,71,71));
		this.map = map;
		this.cursor = cursor;
		this.campus = campus;
		dir=0;
	}
	
	/**
	 * draws a map that overlays game window and locates the player
	 * @param drawer interface that draws the map
	 */
	public void display(GameWindow drawer)
	{
		drawer.pushStyle();
		drawer.fill(100, 200);
		drawer.noStroke();
		drawer.rect(0, 0, drawer.DRAWING_WIDTH, drawer.DRAWING_HEIGHT);
		drawer.image(map, 0, 0);
		
		String tag = null;
		for(Rectangle r : rooms)
		{
			if(r.contains(drawer.mouseX, drawer.mouseY))
			{
				for(Classroom c : campus)
				{
					if(r.contains(c.getMapCoor()))
						tag = c.getMarker();
				}
			}
		}
		
		int x = current.getMapCoor().x;
		int y = current.getMapCoor().y;
		PImage thing;
		if(dir == GameWindow.NORTH)
			thing = cursor.get(0);
		else if(dir == GameWindow.EAST)
			thing = cursor.get(1);
		else if(dir == GameWindow.SOUTH)
			thing = cursor.get(2);
		else
			thing = cursor.get(3);
		drawer.image(thing, x-thing.width/2, y-thing.height/2);
		
		if(tag != null)
		{
			drawer.rectMode(drawer.CENTER);
			drawer.stroke(0);
			drawer.fill(255,250,208);
			drawer.rect(drawer.mouseX, drawer.mouseY-5, 79, 10);
			drawer.textAlign(drawer.CENTER);
			drawer.fill(0);
			drawer.text(tag, drawer.mouseX, drawer.mouseY-2);
		}
		drawer.popStyle();
	}
	
	/**
	 * update player location
	 * @param c classroom that player is in
	 */
	public void setCurrentRoom(Classroom c)
	{
		current = c;
	}
	
	/**
	 * indentify which direction player is currently facing
	 * @param userDir NORTH, SOUTH, EAST, WEST
	 */
	public void setDir(int userDir)
	{
		dir = userDir;
	}
}
