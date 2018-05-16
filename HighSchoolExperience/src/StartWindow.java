

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Amy Ha
 *
 */
public class StartWindow extends JPanel implements MouseListener{
	private Image title;
	private Image background;
	private Image button;
	private final int START_BUTTON_X = 3*WindowTester.WIDTH/7;
	private final int START_BUTTON_Y = 2*WindowTester.HEIGHT/3;
	private final int TITLE_X = WindowTester.WIDTH/7;
	private final int TITLE_Y= WindowTester.HEIGHT/6;
	private double startButtonWidth, startButtonHeight;
	private double titleWidth, titleHeight;
	
	public StartWindow() {
		title = (new ImageIcon("gametitle.png")).getImage();
		background = (new ImageIcon("building.jpg")).getImage();
		button = (new ImageIcon("startbutton.png")).getImage();
		startButtonWidth = button.getWidth(null);
		startButtonHeight = button.getHeight(null);
		titleWidth = title.getWidth(null);
		titleHeight = title.getHeight(null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		g.drawImage(title, TITLE_X, TITLE_Y, null);
		g.drawImage(button, START_BUTTON_X, START_BUTTON_Y, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(START_BUTTON_X <= e.getX() && e.getX() <= START_BUTTON_X + startButtonWidth 
				&& START_BUTTON_Y <=e.getY() && e.getY() <= startButtonHeight + START_BUTTON_Y) {
			JComponent drawing = new CustomizationWindow();
			JFrame window = new JFrame("CustomizationWindow");
			window.setBounds(100, 100, WindowTester.WIDTH, WindowTester.HEIGHT);
			window.setContentPane(drawing);
			JPanel panel = (JPanel) window.getContentPane();
			panel.setLayout(null);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);

		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}

