

import java.util.Map;
/**
 * 
 * @author sashaoberman/online
 *
 */
public class DrawingWindow extends ProcessingWindow {
	private Map<String, String> parameters;	
	private MenuWindow menu;
	private static final String DEFAULT_TITLE = "Drawing Window";

	/**
	* Base constructor for a DrawingWindow. Takes in the window width and height as parameters
	* and sets the size of the DrawingWindow accordingly, as well as a a String title for the
	* DrawingWindow, a Map of parameters, and the dimensions of the MenuWindow
	* DrawingWindow.
	* @param width
	* @param height
	* @param title
	* @param parameters
	* @param menu
	*/
	public DrawingWindow(int width, int height, String title, Map<String, String> parameters,
						int menuWidth, int menuHeight) {
		super(width, height, title);
		this.parameters = parameters;
		createMenu(menuWidth, menuHeight);
	}
	
	/**
	* Constructor for DrawingWindow where only width, height, title, and menu 
	* dimensions are given
	* @param width
	* @param height
	* @param title
	* @param menu
	*/
	public DrawingWindow(int width, int height, Map<String, String> parameters, int menuWidth, int menuHeight) {
		this(width, height, DEFAULT_TITLE, parameters, menuWidth, menuHeight);
	}
	
	/**
	 * Constructor for DrawingWindow for window dimensions and a map
	 * containing parameters
	 * @param width
	 * @param height
	 * @param parameters
	 */
	public DrawingWindow(int width, int height, Map<String, String> parameters) {
		this(width, height, parameters, width, height);
	}
	
	/**
	 * Creates the DrawingWindow as well as its accompanying MenuWindow. 
	 */
	@Override
	public void createWindow() {
		super.createWindow();
		menu.createWindow();
	}
	
	/*
	 * Helper method creates a MenuWindow object for the parameters stored by
	 * the DrawingWindow. The input parameters represent the dimensions
	 * of the menu to be drawn
	 */
	private void createMenu(int menuWidth, int menuHeight) {
		menu = new MenuWindow(menuWidth, menuHeight, "Menu for " + title, parameters);
	}


	///////////////////////////////////////////////////////////////////////////////////////
	/* Below are methods that customize the DrawingWindow's appearance and functionality.*/
	///////////////////////////////////////////////////////////////////////////////////////

	/*
	 * Initialize the DrawingWindow the same way we would a normal Processing sketch
	 */
	public void setup() {
		background(255);
		fill(0);
		noStroke();
		rectMode(CENTER);
	}
	/*
	 * The draw function should be updated so that the DrawingWindow creates
	 * whatever the user desires.
	 */
	public void draw() {
		
		//Below is an example to demo the MenuWindow based on the 
		// parameters set in the ExampleDriver.
		/*float centerX = parameters.get("Center X").floatValue();
		float centerY = parameters.get("Center Y").floatValue();
		float radius = parameters.get("Radius").floatValue();
		*/
		String activity = parameters.get("Activity");
		String course = parameters.get("Course");

		background(255);
		text("Student Activity: "+activity,250,320);
		text("Student Course: "+course,250,350);

		
	}


}


