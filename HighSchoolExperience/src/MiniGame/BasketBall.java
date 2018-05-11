package MiniGame;
import java.awt.Rectangle;

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
	private int radius;
	private boolean tossed, isPickedUp;
	private Player holder;
	private Net net;
	
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
		this.net = net;
	}
	
	public void display(PApplet drawer)
	{
		drawer.ellipseMode(drawer.RADIUS);
		drawer.ellipse((float)x, (float)y, radius, radius);
		act(drawer);
	}
	
	public void act(PApplet window)
	{		
		if(tossed)
		{
			if(y + radius > window.height)
			{
				y = window.height - radius;
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
			
			if(net.contains(x, y))
			{
				if(x > net.x && x < net.x + net.width && dy > 0)
				{
					net.incrementScore();
					System.out.println(net.getScore());
				}
			}
			this.x += dx;
			this.y += dy;
		}
		else if(isPickedUp)
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
		}
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}