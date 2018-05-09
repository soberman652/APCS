import processing.core.PApplet;

public class Background extends PApplet {

	private int screenNum;
	
	public Background() {
		screenNum = 0;
	}
	
	public Background(int screenNum) {
		this.screenNum = screenNum;
	}
	
	public void addScreenNum() {
		screenNum++;
	}
	
	
}
