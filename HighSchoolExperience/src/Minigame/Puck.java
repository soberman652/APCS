package Minigame;

/**
 * 
 * @author Amy
 *
 */
public class Puck extends Circle{
	private float friction;
	
	public Puck() {
		super();
		friction = 0.98f;
	}

	public Puck(float velocityX, float velocityY, int xDirection, int yDirection, float centerX, float centerY, float radius, float friction) {
		super(velocityX, velocityY, xDirection, yDirection, centerX, centerY, radius);
		this.friction = friction;
	}
	
	public void bounce(float widthScreen, float heightScreen) {
		if(xIsAtLeftBorder() || xIsAtRightBorder(widthScreen)) {
			setXDirec(-1);
		}
		if(yIsAtTopBorder() || yIsAtBottomBorder(heightScreen)) {
			setYDirec(-1);
		}
	}

	public boolean isMoving() {
		if(getVelocityX() > 0 || getVelocityY() > 0) {
			return true;
		}
		return false;
	}
	
	public void accelerate(float widthScreen, float heightScreen) {
		bounce(widthScreen, heightScreen);
		setCenterX(getCenterX() + getVelocityX() * getXDirec());
		setCenterY(getCenterY() + getVelocityY() * getYDirec());
		setVelocityX(getVelocityX()*friction);
		setVelocityY(getVelocityY()*friction);
	}

}
