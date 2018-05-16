package Minigame;
import processing.core.PApplet;

public class Sign 
{
	private int type, opacity, x;
	
	public Sign(int type)
	{
		this.type = type;
		opacity = 255;
		x = 0;
	}
	
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
	
	public void act()
	{
		opacity = (int)(255*Math.pow(2,-0.8*x));
		x++;
	}
}
