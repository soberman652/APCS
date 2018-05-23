package Hub;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * starting environment that player begins in
 * @author Emily
 *
 */
public class Home extends Room
{
	private PImage floor, bed;
	
	/**
	 * 
	 * @param floor background picture
	 * @param bed picture for bed
	 */
	public Home(PImage floor, PImage bed) 
	{
		super("Home");
		this.floor = floor;
		this.bed = bed;
	}
	
	@Override
	public void display(int direction, PApplet drawer) 
	{
		drawer.pushStyle();
		//floor.resize(drawer.width, drawer.height);
		drawer.image(floor, 0, 0);
		bed.resize(200, 120);
		drawer.image(bed, 10, drawer.height-bed.height-10);
		for(Door d: this.getExits())
			d.display(drawer);
		
		drawer.popStyle();
	}
	
}
