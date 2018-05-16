import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.awt.PSurfaceAWT;

public class Main 
{
	private JFrame window;
	private JPanel cardPanel;
	
	private GameWindow gamePanel;
	private PSurfaceAWT gameSurf;
	private PSurfaceAWT.SmoothCanvas gameProcessingCanvas;
	
	
	public Main()
	{
		window = new JFrame();
		gamePanel = new GameWindow(this);
		
		gameSurf = (PSurfaceAWT) gamePanel.getSurface();
		gameProcessingCanvas = (PSurfaceAWT.SmoothCanvas) gameSurf.getNative();
		
		window.setMinimumSize(new Dimension(500,500));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    cardPanel.add(gameProcessingCanvas,"1");
	    
	    window.setLayout(new BorderLayout());
	    
	    window.add(cardPanel);
	    
	    window.setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		Main m = new Main();
	}
	
	public void changePanel(String name)
	{
		
	}

}
