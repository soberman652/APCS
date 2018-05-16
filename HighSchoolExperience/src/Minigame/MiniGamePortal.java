package Minigame;
import processing.core.PApplet;
import processing.core.PImage;

public class MiniGamePortal 
{
	private Playable mini;
	private PImage icon;
	
	public MiniGamePortal(Playable mini, PImage icon)
	{
		this.mini = mini;
		this.icon = icon;
		icon.resize(50, 50);
	}
	
	public void display(PApplet drawer)
	{
		drawer.image(icon, drawer.width/2-icon.width/2, drawer.height/2-icon.height/2);
	}
	
	public void select()
	{
		mini.play();
	}
}
