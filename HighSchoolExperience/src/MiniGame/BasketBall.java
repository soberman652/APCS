package MiniGame;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * 
 * In the basketball mini-game, a ball that can travel in a parabolic motion
 * 
 * @author Emily
 *
 */
public class BasketBall 
{
	private double x, y, dx, dy;
	private int radius, wasShotAt;
	private boolean tossed, isPickedUp;
	private Player holder;
	private Line2D netBound;
	
	public BasketBall(int x, int y, int r, Player player, Net net)
	{
		this.x = x;
		this.y = y;
		radius = r;
		dx = 0;
		dy = 0;
		tossed = false;
		isPickedUp = false;
		holder = player;
		netBound = net.getBoundary();
		wasShotAt = (int)(player.getY() + player.getHeight());
	}
	
	public void display(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.fill(245,124,19);
		drawer.noStroke();
		drawer.ellipseMode(drawer.RADIUS);
		drawer.ellipse((float)x, (float)y, radius, radius);
		drawer.popStyle();
		act(drawer);
	}
	
	public void act(PApplet window)
	{		
		if(tossed)
		{
			if(y + radius > wasShotAt)
			{
				y = wasShotAt - radius;
				dy = -dy * 0.85;
				dx *= 0.9;
				if(Math.abs(dy) < 3)
					dy = 0;
				if(Math.abs(dx) < 0.1)
					dx = 0;
				if(dx == 0 && dy == 0)
					tossed = false;
			}
			else
				dy += 0.5;
			
			if(x + radius > window.width)
			{
				x = window.width - radius;
				dx = -dx;
			}
			else if(x < 0)
			{
				x = 0;
				dx = -dx;
			}
			else if(this.y > netBound.getY1() && this.y < netBound.getY2())
			{
				if(Math.abs(this.x - netBound.getX1()) < radius)
				{
					if(this.x - dx < netBound.getX1())
						x = netBound.getX1()-radius-5;
					else if(this.x - dx > netBound.getX1())
						x = netBound.getX1()+radius+5;
					dx = -dx;
				}
			}
			else if(this.y <= netBound.getY1())
			{
				if(Math.sqrt(Math.pow(this.x - netBound.getX1(), 2)+Math.pow(this.y-netBound.getY1(), 2)) < radius)
				{
					dx = -dx;
					dy = -dy;
				}
			}
			else if(this.y >= netBound.getY2())
			{
				if(Math.sqrt(Math.pow(this.x - netBound.getX2(), 2)+Math.pow(this.y-netBound.getY2(), 2)) < radius)
				{
					dx = -dx;
					dy = -dy;
				}
			}
			
			this.x += dx;
			this.y += dy;
		}
		
		if(isPickedUp)
		{
			moveTo(holder.x + holder.width, holder.y + holder.height/2);
		}
		else if(!isPickedUp && holder.contains(this.x, this.y))
		{
			isPickedUp = true;
			tossed = false;
		}
	}
	
	public void toss(double angle, int level)
	{
		if(!tossed && isPickedUp)
		{
			tossed = true;
			isPickedUp = false;
			int initialVel = level;
			dx = initialVel * Math.cos(angle);
			dy = -initialVel * Math.sin(angle);
			wasShotAt = (int)(holder.getY() + holder.getHeight());
		}
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public Point2D getCenter()
	{
		return new Point2D.Double(x,y);
	}
	
	public Point2D getLastPoint()
	{
		return new Point2D.Double(x-dx,y-dy);
	}
}