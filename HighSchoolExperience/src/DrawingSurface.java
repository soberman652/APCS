import java.awt.event.KeyEvent;

import processing.core.PApplet;


/**
 * 
 * This class 
 * 
 * @author soberman652
 *
 */
public class DrawingSurface extends PApplet {

	
	//private Background back;
	
	public DrawingSurface() {
		
	}
	
	public static void main(String[] args) {
	       PApplet.main("DrawingSurface");
	    }

	    public void settings(){
	       size(1000,700);
	    }

	    public void setup(){
	       
	       background(153,204,255);
	       
	    }

	    
	    public void createBackground() {
	    		//back = new Background();
	    }
	    
	    public void draw() {
	        //ellipse(width/2,height/2,second(),second());
	    		//rect(400, 300, 200, 100);
	    		
	    	
	    	
		    textSize(24);
		    textAlign(CENTER);
		    text("Press ENTER to start: High School Experience", 450, 320);
	    	
	    }
	    
	    public void keyPressed() {
	    	  if (key == ENTER) {
	    		  //back.addScreenNum();
	    	}
	
	
	    }
}
