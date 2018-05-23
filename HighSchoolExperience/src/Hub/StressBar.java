package Hub;

import processing.core.PApplet;

/**
 * level of stress measured based on how well student's grades are
 * @author Emily
 *
 */
public class StressBar 
{
	private int percentStressed;
	private int height, width;
	
	/**
	 * 
	 * @param w pixel width of bar
	 * @param h pixel height of bar
	 */
	public StressBar(int w, int h)
	{
		percentStressed = 0;
		width = w;
		height = h;
	}
	
	/**
	 * draw a bar with is filled with colored rectangle to show stress percentage
	 * @param drawer interface that draws bar
	 */
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
			drawer.fill(0,255,0);
		drawer.rect(GameWindow.DRAWING_WIDTH-width-5, GameWindow.DRAWING_HEIGHT-height-5, (int)((width-10)/100.0*percentStressed), height-10);
		drawer.textAlign(drawer.LEFT, drawer.CENTER);
		drawer.textSize(10);
		drawer.fill(0);
		drawer.text(percentStressed + "%", GameWindow.DRAWING_WIDTH-width, (int)(GameWindow.DRAWING_HEIGHT-height-10 + height/2.0));
		drawer.textAlign(drawer.RIGHT, drawer.CENTER);
		drawer.textSize(20);
		drawer.text("Stress Level: ", GameWindow.DRAWING_WIDTH-width-5, (int)(GameWindow.DRAWING_HEIGHT-height-12 + height/2.0));
		drawer.popStyle();
	}
	
	/**
	 * increases level of stress
	 * @param p increase by p percentage
	 */
	public void stressIncrease(int p)
	{
		percentStressed += p;
	}
	
	public boolean isCompletelyStressed()
	{
		if(percentStressed >= 100)
			return true;
		else 
			return false;
	}
	
	public int getPercentStressed() {
		return percentStressed;
	}
}
