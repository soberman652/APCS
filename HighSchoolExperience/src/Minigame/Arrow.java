package Minigame;

import processing.core.PApplet;

/**
 * represents angle basketball would be thrown based on mouse coordinates
 * @author Emily
 *
 */
public class Arrow 
{
	private Player endpoint;
	private double angle;
	private int length = 50;
	/**
	 * creates the arrow
	 * @param player where ray will point from
	 */
	public Arrow(Player player)
	{
		endpoint = player;
		angle = Math.PI/2;
	}
	
	/**
	 * draws arrow
	 * @param drawer interface used to display
	 */
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.stroke(255, 0, 0);
		drawer.strokeWeight(5);
		float x = endpoint.x + endpoint.width/2 + (float)(length*Math.cos(angle));
		float y = endpoint.y + endpoint.height/2 - (float)(length*Math.sin(angle));
		drawer.line(endpoint.x + endpoint.width/2, endpoint.y + endpoint.height/2, x, y);
		drawer.popStyle();
	}
	
	/**
	 * changes arrow's direction to point at coordinates
	 * @param xCoor x coordinate
	 * @param yCoor y coordinate
	 */
	public void adjustAngle(int xCoor, int yCoor)
	{
		int xOrigin = endpoint.x + endpoint.width/2;
		int yOrigin = endpoint.y + endpoint.height/2;
		double dy = yOrigin - yCoor;
		double dx = xCoor - xOrigin;
		angle = Math.atan(dy/dx);
		if(angle > Math.PI/2)
			angle = Math.PI/2;
		else if(angle < 0)
			angle = 0;
	}
	
	/**
	 * 
	 * @return angle of arrow from positive x-axis in radians
	 */
	public double getAngle()
	{
		return angle;
	}
}
