package MiniGame;
import java.awt.Rectangle;

import processing.core.PApplet;

public class Net extends Rectangle
{
	private int score;
	public Net(Rectangle r)
	{
		this.setBounds(r);
		score = 0;
	}
	
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.stroke(0);
		drawer.fill(0, 150, 0);
		drawer.rect(this.x, this.y, this.width, this.height);
		drawer.popStyle();
	}
	
	public void incrementScore()
	{
		score++;
	}
	
	
	public int getScore()
	{
		return score;
	}
}
