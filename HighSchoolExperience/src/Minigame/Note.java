package Minigame;
import processing.core.PApplet;

/**
 * node that scrolls up the screen and must be hit at the right location
 * @author Emily
 *
 */
public class Note 
{
	private int pitch, x, tempo; //1-5
	
	/**
	 * @param pitch which column note scrolls along
	 * @param tempo how fast note is moving
	 * @param start note's initial location
	 */
	public Note(int pitch, int tempo, int start)
	{
		this.pitch = pitch;
		this.tempo = tempo;
		x = start;
	}
	
	/**
	 * 
	 * @param drawer interface that draws the note
	 */
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.fill(0);
		drawer.ellipseMode(drawer.CENTER);
		drawer.ellipse((pitch-3)*MusicGame.SPACE + drawer.width/2, x, 20, 20);
		drawer.popStyle();
		act();
	}
	
	/**
	 * detects how far note is from goal and deteremines if it counts as a successful hit
	 * @param target where note ideally should be hit
	 * @return successfulness of hit (1 = success, -1 = miss)
	 */
	public int hit(int target)
	{
		if(Math.abs(target - this.x) < 10)
		{
			return 1;
		}
		else 
			return -1;
	}
	
	private void act()
	{
		x -= tempo;
	}
	
	/**
	 * 
	 * @return gets note's position along the column
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * 
	 * @return which column note resides in (return 1-5)
	 */
	public int getPitch()
	{
		return pitch;
	}
}
