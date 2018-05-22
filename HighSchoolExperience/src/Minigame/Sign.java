package Minigame;
import processing.core.PApplet;

/**
 * indicator of a correct or incorrect note that fades away
 * @author Emily
 *
 */
public class Sign 
{
	private int type, opacity, x;
	
	/**
	 * @param type -1 = incorrect, 1 = correct
	 */
	public Sign(int type)
	{
		this.type = type;
		opacity = 255;
		x = 0;
	}
	
	/**
	 * draws a check or a cross, depending on type
	 * @param drawer interface that draws the sign
	 */
	public void display(PApplet drawer)
	{
		act();
		drawer.pushStyle();
		drawer.strokeWeight(5);
		if(type == -1)
		{
			drawer.stroke(255,0,0,opacity);
			drawer.line(10, 10, 60, 60);
			drawer.line(10, 60, 60, 10);
		}
		else if(type == 1)
		{
			drawer.stroke(0,255,0,opacity);
			drawer.line(10, 40, 30, 60);
			drawer.line(30, 60, 60, 10);
		}
		drawer.popStyle();
	}
	
	private void act()
	{
		opacity = (int)(255*Math.pow(2,-0.8*x));
		x++;
	}
}
