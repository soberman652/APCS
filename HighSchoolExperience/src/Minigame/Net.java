package Minigame;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * basketball net that basketball passed through to score
 * @author Emily
 *
 */
public class Net
{
	private int height;
	private int score;
	private Line2D boundary, threshold;
	private PImage img;
	/**
	 * 
	 * @param x x coordinate of net's top right corner
	 * @param y y coordinate of net's top right corner
	 * @param img image of net
	 */
	public Net(int x, int y, PImage img)
	{
		score = 0;
		boundary = new Line2D.Double(new Point2D.Double(x-50,y), new Point2D.Double(x-50,y+10));
		threshold = new Line2D.Double(new Point2D.Float(x-50,y), new Point2D.Double(x,y));
		this.img = img;
	}
	
	/**
	 * 
	 * @param drawer interface that draws net and current score
	 */
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		/*
		drawer.stroke(0);
		drawer.line((float)boundary.getX1(), (float)boundary.getY1(), (float)boundary.getX2(), (float)boundary.getY2());
		drawer.stroke(255, 0, 0);
		drawer.line((float)threshold.getX1(), (float)threshold.getY1(), (float)threshold.getX2(), (float)threshold.getY2());
		*/
		drawer.textSize(10);
		drawer.fill(0);
		drawer.text(score + "", (float)threshold.getX1(), (float)threshold.getY1() - 10);
		drawer.popStyle();
		drawer.image(img, (float)boundary.getX1(), (float)boundary.getY1());
	}
	
	/**
	 * detects if basketball passed through net from the top; if so, increments score
	 * @param ball
	 */
	public void check(BasketBall ball)
	{
		int ballX = (int)ball.getCenter().getX();
		int ballY = (int)ball.getCenter().getY();
		int r = ball.getRadius();
		if(ballX > threshold.getX1()+r && ballX < threshold.getX2()-r && ball.getLastPoint().getX() > threshold.getX1()+r && ball.getLastPoint().getX() < threshold.getX2()-r)
		{
			if(ballY > threshold.getY1() && ball.getLastPoint().getY() < threshold.getY1())
				score++;
		}
	}
	
	/**
	 * 
	 * @return number of times ball passed net the correct way
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * 
	 * @return line representing net's left side
	 */
	public Line2D getBoundary()
	{
		return boundary;
	}
}
