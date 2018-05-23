package Hub;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class represents the title screen that appears after the entire game is loaded.
 * @author Amy Ha
 *
 */
public class StartWindow extends JPanel implements MouseListener{
	private Image title;
	private Image background;
	private Image button;
	private final int START_BUTTON_X = 3*Main.WIDTH/7;
	private final int START_BUTTON_Y = 2*Main.HEIGHT/3;
	private final int TITLE_X = Main.WIDTH/7;
	private final int TITLE_Y= Main.HEIGHT/6;
	private double startButtonWidth, startButtonHeight;
	private double titleWidth, titleHeight;
	private Main m;
	
	/**
	 * 
	 * Loads all of the images, including title and background, into variables and implements 
	 * mouseListener to allow clicking the START button.
	 * @param m An instance of the main class, which contains the main method to run the
	 * entire program.
	 */
	public StartWindow(Main m) {
		title = (new ImageIcon("gametitle.png")).getImage();
		background = (new ImageIcon("building.jpg")).getImage();
		button = (new ImageIcon("startbutton.png")).getImage();
		startButtonWidth = button.getWidth(null);
		startButtonHeight = button.getHeight(null);
		titleWidth = title.getWidth(null);
		titleHeight = title.getHeight(null);
		this.m = m;
		this.addMouseListener(this);
	}

	/**
	 * Draws the background image of a school onto the window and inserts the title on the 
	 * top while adding the START button on the bottom, which can be pressed to begin the game.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		g.drawImage(title, TITLE_X, TITLE_Y, null);
		g.drawImage(button, START_BUTTON_X, START_BUTTON_Y, null);
	}

	/**
	 * Overrides the mouseClicked method from the superclass to change panel when the START button is pressed.
	 * Here, changing panel means the customization window appearing after the START button is pressed.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(START_BUTTON_X <= e.getX() && e.getX() <= START_BUTTON_X + startButtonWidth 
				&& START_BUTTON_Y <=e.getY() && e.getY() <= startButtonHeight + START_BUTTON_Y) {
			m.changePanel("2");
			/*
			JComponent drawing = new CustomizationWindow(m);
			JFrame window = new JFrame("CustomizationWindow");
			window.setBounds(100, 100, Main.WIDTH, Main.HEIGHT);
			window.setContentPane(drawing);
			JPanel panel = (JPanel) window.getContentPane();
			panel.setLayout(null);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
			*/
		}	
	}

	/**
	 * Had to add necessary methods to implement MouseListener.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Had to add necessary methods to implement MouseListener.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Had to add necessary methods to implement MouseListener.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Had to add necessary methods to implement MouseListener.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}

