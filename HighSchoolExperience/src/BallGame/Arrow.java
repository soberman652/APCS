package BallGame;

import processing.core.PApplet;

public class Arrow 
{
	private Player endpoint;
	private double angle;
	private int length = 50;
	public Arrow(Player player)
	{
		endpoint = player;
		angle = Math.PI/2;
	}
	
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
	
	public double getAngle()
	{
		return angle;
	}
}
