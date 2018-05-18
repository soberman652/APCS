package Hub;

import processing.core.PApplet;

public class StressBar 
{
	private int percentStressed;
	private int height, width;
	
	public StressBar(int w, int h)
	{
		percentStressed = 0;
		width = w;
		height = h;
	}
	
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.noStroke();
		drawer.fill(255);
		drawer.rect(GameWindow.DRAWING_WIDTH-width-10, GameWindow.DRAWING_HEIGHT-height-10, width, height);
		if(percentStressed >= 75)
			drawer.fill(255,0,0);
		else if(percentStressed >= 50)
			drawer.fill(255,150,0);
		else if(percentStressed >= 25)
			drawer.fill(255,255,0);
		else
			drawer.fill(0,255,255);
		drawer.popStyle();
	}
	
	public void stressUp(int p)
	{
		percentStressed += p;
	}
	
	
}
