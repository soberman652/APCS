package Minigame;

/**
 * 
 * @author Amy
 *
 */
public class Controller extends Circle{
	private float accelerationX, accelerationY;
	private final float MAX_ACCELERATION = 20;
	
	public Controller() {
		super();
		accelerationX = 0;
		accelerationY = 0;
	}
	
	public Controller(float velocityX, float velocityY, int xDirection, int yDirection, float centerX, float centerY, float radius) {
		super(velocityX, velocityY, xDirection, yDirection, centerX, centerY, radius);
		accelerationX = 0;
		accelerationY = 0;
	}
	
	public void changeLocation(float x, float y) {

		setCenterX(getCenterX() + x);
		setCenterY(getCenterY() + y);
	}
	
	public void chooseAccelerationX() {
		accelerationX = (float)(Math.random() * MAX_ACCELERATION);
	}
	
	public void chooseAccelerationY() {
		accelerationY = (float)(Math.random() * MAX_ACCELERATION);
	}
	
	public float getAccelerationX() {
		return accelerationX;
	}
	
	public float getAccelerationY() {
		return accelerationY;
	}
	
	public void setAccelerationX(float accelerationX) {
		this.accelerationX = accelerationX;
	}
	
	public void setAccelerationY(float accelerationY) {
		this.accelerationY = accelerationY;
	}
}
