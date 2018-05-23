package Minigame;
import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/**
 * 
 * This game was going to be added to the project, but we ran out of time unfortunately.
 * @author Amy Ha
 *
 */
public class AirHockeyMain {

	/**
	 * WIDTH - width of the JFrame window
	 * HEIGHT - height of the JFrame window
	 */
	public static int WIDTH = 500;
	public static int HEIGHT = 700;

	/**
	 * Main method that runs the air hockey game.
	 * @param args
	 */
	public static void main(String args[]) {
	
		AirHockeyTable drawing = new AirHockeyTable();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(WIDTH, HEIGHT);
		window.setLocation(10, 10);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}
}
