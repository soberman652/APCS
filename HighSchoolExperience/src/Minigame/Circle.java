package Minigame;
import java.awt.Point;

import processing.core.PApplet;

/**
 * 
 * @author Amy
 *
 */
public class Circle {
	private float velocityX, velocityY;
	private int xDirection;
	private int yDirection;
	private float centerX, centerY;
	private float radius;
	
	public Circle() {
		velocityX = 0;
		velocityY = 0;
		xDirection = 1;
		yDirection = 1;
		centerX = AirHockeyMain.WIDTH / 2;
		centerY = AirHockeyMain.HEIGHT/2;
		radius = 25;
	}

	public Circle(float velocityX, float velocityY, int xDirection, int yDirection, float centerX, float centerY, float radius) {
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.xDirection = xDirection;
		this.yDirection = yDirection;
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}

	public void draw(PApplet drawer) {
		drawer.ellipse(centerX, centerY, radius*2, radius*2);
	}

	public boolean isInside(float xC, float yC) {
		//a^2 + b^2 = c^2
		//a = xC - centerX
		//b = yC - centerY
		//if c < radius
		if(Math.sqrt(Math.pow(xC-centerX, 2) + Math.pow(yC - centerY, 2)) < radius){
			return true;
		}
		return false;
	}

	public boolean xIsAtLeftBorder() {
		if(centerX < radius) 
			return true;
		return false;
	}
	
	public boolean xIsAtRightBorder(float width) {
		if(centerX + radius > width)
			return true;
		return false;
	}
	
	public boolean yIsAtTopBorder() {
		if(centerY < radius)
			return true;
		return false;
	}
	
	public boolean yIsAtBottomBorder(float height) {
		if(centerY + radius > height) 
			return true;
		return false;
	}

	
	public boolean collides(Circle other) {
		//1. this.center = (x1, y1)
		//2. other.center = (x2, y2)
		//if the distance between this.center and other.center is
		//less than the sum of their radii
		if(Math.pow(Math.pow(centerX - other.centerX, 2) + Math.pow(centerY - other.centerY, 2), 0.5) < radius + other.radius) {
			return true;
		}
		return false;
	}

	public double calculateDistanceBetweenCenters(Circle other) {
		return Math.pow(Math.pow(centerX - other.centerX, 2) + Math.pow(centerY - other.centerY, 2), 0.5);
	}
	
	public float getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}

	public float getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(float velocityY){
		this.velocityY = velocityY;
	}

	public int getXDirec() {
		return xDirection;
	}

	public void setXDirec(int xDirection) {
		this.xDirection *= xDirection;
	}

	public int getYDirec() {
		return yDirection;
	}

	public void setYDirec(int yDirection) {
		this.yDirection *= yDirection;
	}

	public float getCenterX() {
		return centerX;
	}

	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}

	public float getCenterY() {
		return centerY;
	}

	public void setCenterY(float centerY) {
		this.centerY = centerY;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
}

