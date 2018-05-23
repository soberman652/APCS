package Minigame;
import processing.core.PApplet;

/**
 * This class represents the air hockey table. It keeps track of the movement of each controller and the puck, and
 * saves the current state of the game.
 * @author Amy
 *
 */
public class AirHockeyTable extends PApplet{

	private int backgroundColor, redSide, blueSide;
	private Controller computerController, playerController;
	private Puck puck;
	private boolean mouseIsInside, isHitForFirst;
	private int opponentScore, playerScore;

	/**
	 * Initializes the computer pusher and the player pusher so that they will be at their correct locations. A puck object is
	 * also created and placed on the center of the table. The table color is set to white and the border line is drawn. Both scores are saved the 
	 */
	public AirHockeyTable() {
		computerController = new Controller(0, 0, 1, 1, AirHockeyMain.WIDTH/2, AirHockeyMain.HEIGHT/20, 25);
		playerController = new Controller(0, 0, 1, 1, AirHockeyMain.WIDTH/2, 10*AirHockeyMain.HEIGHT /11, 25);
		puck = new Puck(0, 0, 1, 1, AirHockeyMain.WIDTH/2, AirHockeyMain.HEIGHT / 2, 15, 0.95f);
		backgroundColor = color(255, 255, 255);
		redSide = color(255, 0, 0);
		blueSide = color(0, 0, 255);
		isHitForFirst = false;
		opponentScore = 0;
		playerScore = 0;
	}

	/**
	 * Draws the table with the scores displayed and the puck and the two controllers
	 */
	public void draw() {
		background(backgroundColor);
		textSize(20);
		fill(0, 0, 0);
		text("Computer Score: " + opponentScore, AirHockeyMain.WIDTH/4, AirHockeyMain.HEIGHT/4);
		text("Player Score: " + playerScore, AirHockeyMain.WIDTH/4, 3*AirHockeyMain.HEIGHT/4);
		fill(255, 255, 255);
		strokeWeight(3);
		stroke(0, 0, 0);
		ellipse(AirHockeyMain.WIDTH/2, AirHockeyMain.HEIGHT/2, 150, 150);
		line(0, AirHockeyMain.HEIGHT/2, AirHockeyMain.WIDTH, AirHockeyMain.HEIGHT/2);
		strokeWeight(2);
		stroke(redSide);
		arc(AirHockeyMain.WIDTH/2, 0, 150, 150, 0, PI);
		line(AirHockeyMain.WIDTH/4, 0, 3*AirHockeyMain.WIDTH/4, 0);
		computerController.draw(this);
		stroke(blueSide);
		arc(AirHockeyMain.WIDTH/2, AirHockeyMain.HEIGHT - 25, 150, 150, PI, TWO_PI);
		line(AirHockeyMain.WIDTH/4, AirHockeyMain.HEIGHT - 25, 3*AirHockeyMain.WIDTH/4, AirHockeyMain.HEIGHT - 25);
		playerController.draw(this);
		stroke(0, 0, 0);
		puck.draw(this);
		puck.accelerate(AirHockeyMain.WIDTH, AirHockeyMain.HEIGHT);
		//	if(isHitForFirst) {
		act();
		//	}
		/*	if(puck.collides(playerController)) {
			puck.setVelocityX(mouseX - pmouseX);
			puck.setVelocityY(mouseY - pmouseY);
		}*/
		if(hitsRedGoal(AirHockeyMain.WIDTH/4, 3*AirHockeyMain.WIDTH/4, 0)) {
			playerScore++;
			reset();
		}
		else if(hitsBlueGoal(AirHockeyMain.WIDTH/4, 3*AirHockeyMain.WIDTH/4, AirHockeyMain.HEIGHT)) {
			opponentScore++;
			reset();
		}
	}

	public void reset() {
		computerController = new Controller(0, 0, 1, 1, AirHockeyMain.WIDTH/2, AirHockeyMain.HEIGHT/20, 25);
		playerController = new Controller(0, 0, 1, 1, AirHockeyMain.WIDTH/2, 10*AirHockeyMain.HEIGHT /11, 25);
		puck = new Puck(0, 0, 1, 1, AirHockeyMain.WIDTH/2, AirHockeyMain.HEIGHT / 2, 15, 0.95f);
		backgroundColor = color(255, 255, 255);
		redSide = color(255, 0, 0);
		blueSide = color(0, 0, 255);
		isHitForFirst = false;
	}
	
	public void act() {
		float angle = 0;
		float valueX = 0;
		if(puckIsInsideComputerArea(AirHockeyMain.HEIGHT/2) && !computerController.xIsAtRightBorder(AirHockeyMain.WIDTH) 
				&& !computerController.yIsAtTopBorder() && !computerController.xIsAtLeftBorder() && 
				!computerControllerIsAtBorderLine(AirHockeyMain.HEIGHT)) {
			angle = atan2(computerController.getCenterY() - puck.getCenterY() + computerController.getRadius() + puck.getRadius(), puck.getCenterX() - computerController.getCenterX());
			computerController.chooseAccelerationX();
			computerController.chooseAccelerationY();
			computerController.changeLocation(cos(angle) * computerController.getAccelerationX(), -sin(angle)*computerController.getAccelerationY());
		}
		else {
			if(!puckIsInsideComputerArea(AirHockeyMain.HEIGHT/2)) {
				angle = atan2(computerController.getCenterY() - computerController.getRadius(), (int)(puck.getCenterX() - computerController.getCenterX()));
				if(Math.abs(computerController.getCenterX() - puck.getCenterX()) < cos(angle)*computerController.getAccelerationX()) {
					valueX = -computerController.getCenterX() + puck.getCenterX();
				}
				else {
					valueX = cos(angle)*computerController.getAccelerationX();

				}

				computerController.changeLocation(valueX, -sin(angle)*computerController.getAccelerationY());

			}
			if(computerControllerIsAtBorderLine(AirHockeyMain.HEIGHT /2)) {
				computerController.setCenterY(AirHockeyMain.HEIGHT / 2 - computerController.getRadius());
			}
			if(computerController.yIsAtTopBorder()) {
				computerController.setCenterY(computerController.getRadius());
			}
			if(computerController.xIsAtLeftBorder()) {
				computerController.setCenterX(computerController.getRadius());
			}
			if(computerController.xIsAtRightBorder(AirHockeyMain.WIDTH)) {
				computerController.setCenterX(AirHockeyMain.WIDTH - computerController.getRadius());
			}
		}
		if(computerController.collides(puck)) {
			puck.setVelocityX(computerController.getAccelerationX() * 3);
			puck.setVelocityY(computerController.getAccelerationY() * 3);
		}

	}

	public void mousePressed() {
		if(playerController.isInside(mouseX, mouseY)) {
			mouseIsInside = true;
		}
		else {
			mouseIsInside = false;
		}
	}

	public void mouseDragged() {
		if(mouseIsInside && !playerControllerIsAtBorderLine(AirHockeyMain.HEIGHT /2) &&
				!playerController.xIsAtLeftBorder() && !playerController.xIsAtRightBorder(AirHockeyMain.WIDTH)
				&& !playerController.yIsAtBottomBorder(AirHockeyMain.HEIGHT)) {
			playerController.changeLocation(mouseX - pmouseX, mouseY - pmouseY);
		}
		else {
			if(playerControllerIsAtBorderLine(AirHockeyMain.HEIGHT /2)) {
				playerController.setCenterY(AirHockeyMain.HEIGHT / 2 + playerController.getRadius());
			}
			if(playerController.yIsAtBottomBorder(AirHockeyMain.HEIGHT)) {
				playerController.setCenterY(AirHockeyMain.HEIGHT - playerController.getRadius());
			}
			if(playerController.xIsAtLeftBorder()) {
				playerController.setCenterX(playerController.getRadius());
			}
			if(playerController.xIsAtRightBorder(AirHockeyMain.WIDTH)) {
				playerController.setCenterX(AirHockeyMain.WIDTH - playerController.getRadius());
			}
		}
		if(playerController.collides(puck)) {
			isHitForFirst = true;
			puck.setVelocityX(mouseX - pmouseX);
			puck.setVelocityY(mouseY - pmouseY);
		}


	}

	public boolean playerControllerIsAtBorderLine(float y) {
		if(playerController.getCenterY() - playerController.getRadius() < y) {
			return true;
		}
		return false;
	}

	public boolean computerControllerIsAtBorderLine(float y) {
		if(computerController.getCenterY() + computerController.getRadius() > y) {
			return true;
		}
		return false;
	}

	public boolean puckIsInsideComputerArea(float height) {
		if(puck.getCenterY() >= puck.getRadius() && puck.getCenterY() + puck.getRadius() <= height) {
			return true;
		}
		return false;
	}
	
	public boolean hitsRedGoal(float x1, float x2, float y1) {
		if(puck.getCenterX() - puck.getRadius() >= x1 && 
				puck.getCenterX() + puck.getRadius() <= x2 &&
				puck.getCenterY() - puck.getRadius() <= y1) {
			return true;
		}
		return false;
	}
	
	
	public boolean hitsBlueGoal(float x1, float x2, float y1) {
		if(puck.getCenterX() - puck.getRadius() >= x1 && 
				puck.getCenterX() + puck.getRadius() <= x2 &&
				puck.getCenterY() + puck.getRadius() >= y1) {
			return true;
		}
		return false;
	}
}
