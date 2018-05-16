package Minigame;
import processing.core.PApplet;

public class Note 
{
	private int pitch, x, tempo; //1-5
	
	public Note(int pitch, int tempo, int start)
	{
		this.pitch = pitch;
		this.tempo = tempo;
		x = start;
		
	}
	
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.fill(0);
		drawer.ellipseMode(drawer.CENTER);
		drawer.ellipse((pitch-3)*MusicGame.SPACE + drawer.width/2, x, 20, 20);
		drawer.popStyle();
		act();
	}
	
	//-1: miss
	//1: success 
	public int hit(int target)
	{
		if(Math.abs(target - this.x) < 5)
		{
			return 1;
		}
		else 
			return -1;
	}
	
	public void act()
	{
		x -= tempo;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getPitch()
	{
		return pitch;
	}
}
