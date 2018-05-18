package Minigame;
import java.awt.Rectangle;

import Hub.GameWindow;
import processing.core.PApplet;
import processing.core.PImage;

public class MiniGamePortal extends Rectangle
{
	private PImage icon;
	
	public MiniGamePortal(PImage icon)
	{
		this.setBounds(0, 0, 50, 50);
		this.icon = icon;
		icon.resize(50, 50);
	}
	
	public void display(PApplet drawer)
	{
		this.setLocation(GameWindow.DRAWING_WIDTH/2-icon.width/2, GameWindow.DRAWING_HEIGHT/2-icon.height/2);
		drawer.image(icon, GameWindow.DRAWING_WIDTH/2-icon.width/2, GameWindow.DRAWING_HEIGHT/2-icon.height/2);
		int x = GameWindow.DRAWING_WIDTH/2-icon.width/2;
		int y = GameWindow.DRAWING_HEIGHT/2-icon.height/2;
	}
}
