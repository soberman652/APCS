package MiniGame;
import java.awt.Rectangle;

import processing.core.PApplet;

public class Player extends Rectangle
{
	private int dx;
	public Player(Rectangle r)
	{
		this.setBounds(r);
		dx = 0;
	}
	
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.fill(100);
		drawer.rect(this.x, this.y, this.width, this.height);
		drawer.popStyle();
		act();
	}
	
	public void act()
	{
		this.x += dx;
	}
	
	public void moveBy(int x)
	{
		dx = x;
	}
}
