package Hub;
import java.awt.Point;
import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * special room that are on school campus and are displayed on the map
 * @author Emily
 *
 */
public class Classroom extends Room
{	
	private Point mapCoor;
	private boolean hasQuiz;
	private PImage quiz;
	
	/**
	 * 
	 * @param name title of classroom
	 * @param x x coordinate of room's location on map
	 * @param y y coordinate of room's location on map
	 * @param hasQuiz true if room provides a quiz; false otherwise
	 */
	public Classroom(String name, int x, int y, boolean hasQuiz)
	{
		super(name);
		mapCoor = new Point(x,y);
		this.hasQuiz = hasQuiz;
	}
	
	@Override
	public void display(int direction, PApplet drawer) 
	{
		PImage back = drawer.loadImage("img\\Classroom.png");
		quiz = drawer.loadImage("img\\quizIcon.png");
			
		drawer.image(back, 0, 0);
		if(hasQuiz)	
		{
			drawer.image(quiz, GameWindow.DRAWING_WIDTH/2-quiz.width/2, GameWindow.DRAWING_HEIGHT/2-quiz.height/2);
		}
		drawer.pushStyle();
		drawer.fill(0);
		drawer.textSize(20);
		drawer.textAlign(drawer.CENTER);
		//drawer.text(this.getMarker(), drawer.width/2, drawer.height/2);
		if(direction == GameWindow.NORTH)
		{
			//drawer.text('N', drawer.width/2, drawer.height-30);
			for(Door d: this.getExits())
			{
				if(d.getDirection() == GameWindow.NORTH)
					d.display(drawer);
				else
					d.invisible();
			}
		}
		else if(direction == GameWindow.EAST)
		{
			//drawer.text('E', drawer.width/2, drawer.height-30);
			for(Door d: this.getExits())
			{
				if(d.getDirection() == GameWindow.EAST)
					d.display(drawer);
				else
					d.invisible();
			}
		}
		else if(direction == GameWindow.SOUTH)
		{
			//drawer.text('S', drawer.width/2, drawer.height-30);
			for(Door d: this.getExits())
			{
				if(d.getDirection() == GameWindow.SOUTH)
					d.display(drawer);
				else
					d.invisible();
			}
		}
		else if(direction == GameWindow.WEST)
		{
			//drawer.text('W', drawer.width/2, drawer.height-30);
			for(Door d: this.getExits())
			{
				if(d.getDirection() == GameWindow.WEST)
					d.display(drawer);
				else
					d.invisible();
			}
		}
		drawer.popStyle();
	}
	
	/**
	 * checks if student is allowed to access a quiz based on some conditions
	 * @param student character whose location determines if conditions are met to take a quiz
	 * @return true if meets conditions to take quiz; false otherwise
	 */
	public boolean canTakeQuiz(Sprite student)
	{
		if(hasQuiz && student.intersects(new Rectangle(GameWindow.DRAWING_WIDTH/2-quiz.width/2, GameWindow.DRAWING_HEIGHT/2-quiz.height/2,quiz.width,quiz.height)))
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @return x,y coordinate of classroom location on map overlay
	 */
	public Point getMapCoor()
	{
		return mapCoor;
	}
}
