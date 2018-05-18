package Controller;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Minigame.BallGame;
import Minigame.MusicGame;
import processing.awt.PSurfaceAWT;

public class Main extends JFrame
{
	private JPanel cardPanel;
	private StartWindow start1;
	private CustomizationWindow start2;
	
	private GameWindow gamePanel;
	private PSurfaceAWT gameSurf;
	private PSurfaceAWT.SmoothCanvas gameProcessingCanvas;
	
	private BallGame miniPanelA;
	private PSurfaceAWT miniPanelSurfA;
	private PSurfaceAWT.SmoothCanvas miniPanelProcessingCanvasA;
	
	private MusicGame miniPanelB;
	private PSurfaceAWT miniPanelSurfB;
	private PSurfaceAWT.SmoothCanvas miniPanelProcessingCanvasB;
	
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	
	
	public Main()
	{
		start1 = new StartWindow(this);
		start2 = new CustomizationWindow(this);
		
		gamePanel = new GameWindow(this);
		gamePanel.runMe();
		gameSurf = (PSurfaceAWT)gamePanel.getSurface();
		gameProcessingCanvas = (PSurfaceAWT.SmoothCanvas)gameSurf.getNative();
		
		miniPanelA = new BallGame(this);
		miniPanelA.runMe();
		miniPanelSurfA = (PSurfaceAWT)miniPanelA.getSurface();
		miniPanelProcessingCanvasA = (PSurfaceAWT.SmoothCanvas)miniPanelSurfA.getNative();
		
		miniPanelB = new MusicGame(this);
		miniPanelB.runMe();
		miniPanelSurfB = (PSurfaceAWT)miniPanelB.getSurface();
		miniPanelProcessingCanvasB = (PSurfaceAWT.SmoothCanvas)miniPanelSurfB.getNative();
		
		cardPanel = new JPanel();
		CardLayout layout = new CardLayout();
		cardPanel.setLayout(layout);
		
		 cardPanel.addComponentListener(new ComponentAdapter() {

				@Override
				public void componentResized(ComponentEvent arg0) {
					Component x = (Component)arg0.getSource();
					fixProcessingPanelSizes(x);
				}

		    });
		
		
		cardPanel.add(start1, "1");
		cardPanel.add(start2, "2");
		cardPanel.add(gameProcessingCanvas, "3");
		cardPanel.add(miniPanelProcessingCanvasA, "4");
		cardPanel.add(miniPanelProcessingCanvasB, "5");

		setLayout(new BorderLayout());
		setTitle("High School Experience");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		add(cardPanel, BorderLayout.CENTER);
		setVisible(true);
		setResizable(true);
	}
	
	public void fixProcessingPanelSizes(Component match) {
		gameSurf.setSize(match.getWidth(),match.getHeight());
	}
	
	public static void main(String[] args) 
	{
		Main m = new Main();
		
	}
	
	public void changePanel(String name)
	{
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		if (name.equals("3")) {
			gameProcessingCanvas.requestFocus();
			gamePanel.pause(false);
			this.setSize(500, 500);
		}
		else if (name.equals("4")) {
			miniPanelProcessingCanvasA.requestFocus();
			miniPanelA.pause(false);
			miniPanelA.reset();
			this.setSize(521, 600);
		}
		else if (name.equals("5")) {
			miniPanelProcessingCanvasB.requestFocus();
			miniPanelB.pause(false);
			miniPanelB.reset();
			this.setSize(500, 500);
		}
	}

}