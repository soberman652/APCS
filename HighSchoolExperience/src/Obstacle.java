import java.awt.Rectangle;

import processing.core.PApplet;

/**
 * 
 * represents an displayed object that sprite cannot walk through
 * 
 * @author emily
 *
 */
public class Obstacle extends Rectangle
{
	// image
	private String tag; //describes what the obstacle is (table, chair,...) or its function
	
	public Obstacle(Rectangle r)
	{
		this.setBounds(r);
	}
	
	public void display(PApplet drawer)
	{
		
	}
	
	
	
	public String getTag()
	{
		return tag;
	}
	
}
