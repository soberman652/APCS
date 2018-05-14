import processing.core.PApplet;

public class Home extends Room
{
	public Home() 
	{
		super("Home");
	}

	@Override
	public void display(int direction, PApplet drawer) 
	{
		drawer.pushStyle();
		//show a bed
		drawer.popStyle();
	}
	
}
