package Hub;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * The class represents a window that allows the user to customize his or her character.
 * @author Amy Ha
 *
 */
public class CustomizationWindow extends JPanel implements ActionListener {
	private JLabel genderLabel, classLabel, activityLabel, ageLabel, nameLabel;
	private JTextField name;
	private JButton doneButton;
	private JComboBox<String> genderOptionList, classOptionList, activityOptionList;
	private JComboBox<Integer> ageOptionList;
	private Image customization, background;
	private final int CUSTOMIZATION_X = 2*Main.WIDTH/7;
	private final int CUSTOMIZATION_Y = Main.HEIGHT - Main.HEIGHT/4; 
	private final String[] genderList = {"Boy", "Girl"};
	private final String[] classList = {"Mathematics", "History", "Literature", "Science"};
	private final String[] activityList = {"Basketball", "Music"};
	private final Integer[] ageList = {13, 14, 15, 16, 17, 18, 19, 20};
	private Main m;

	//gender
	//age
	//name
	//class
	//activity
	/**
	 * 
	 * Creates swing graphical components of the customization window: the boxes or dropdown lists, and the labels that indicate
	 * what the boxes or dropdown lists contain. Locates each graphical component at a specific place on the window.
	 * @param m An instance of the main class, which runs the entire program
	 */
	public CustomizationWindow(Main m) { 
		background = (new ImageIcon("background.png")).getImage();
		customization = (new ImageIcon("customization.png")).getImage();
		
		genderLabel = new JLabel("Select your gender.");
		genderLabel.setFont(new Font("Serif", Font.BOLD, 25));
		classLabel = new JLabel("Select your class.");
		classLabel.setFont(new Font("Serif", Font.BOLD, 25));
		activityLabel = new JLabel("Select your extracurricular activity.");
		activityLabel.setFont(new Font("Serif", Font.BOLD, 25));
		ageLabel = new JLabel("Select your age.");
		ageLabel.setFont(new Font("Serif", Font.BOLD, 25));
		nameLabel = new JLabel("Enter your name.");
		nameLabel.setFont(new Font("Serif", Font.BOLD, 25));

		genderOptionList = new JComboBox<String>(genderList);
		genderOptionList.setSelectedIndex(0);
		genderOptionList.addActionListener(this);
		genderOptionList.setPreferredSize(new Dimension(150, 100));
		classOptionList = new JComboBox<String>(classList);
		classOptionList.setSelectedIndex(0);
		classOptionList.addActionListener(this);
		classOptionList.setPreferredSize(new Dimension(200, 150));
		activityOptionList = new JComboBox<String>(activityList);
		activityOptionList.setSelectedIndex(0);
		activityOptionList.addActionListener(this);
		activityOptionList.setPreferredSize(new Dimension(200, 150));
		ageOptionList = new JComboBox<Integer>(ageList);
		ageOptionList.setSelectedIndex(0);
		ageOptionList.addActionListener(this);
		ageOptionList.setPreferredSize(new Dimension(100, 50));
		name = new JTextField();
		name.addActionListener(this);
		name.setPreferredSize(new Dimension(300, 30));
		doneButton = new JButton();
		doneButton.addActionListener(this);
		doneButton.setPreferredSize(new Dimension(70, 40));
		doneButton.setText("DONE");
		
		//gender
		add(genderLabel);
		Dimension size = genderLabel.getPreferredSize();
		System.out.println(size);
		genderLabel.setBounds(Main.WIDTH/5, Main.HEIGHT/5, size.width, size.height);
		add(genderOptionList);
		size = genderOptionList.getPreferredSize();
		genderOptionList.setBounds(4*Main.WIDTH/7, Main.HEIGHT/7, size.width, size.height);
		//age
		add(ageLabel);
		size = ageLabel.getPreferredSize();
		ageLabel.setBounds(Main.WIDTH/4, Main.HEIGHT/3, size.width, size.height);
		add(ageOptionList);
		size = ageOptionList.getPreferredSize();
		ageOptionList.setBounds(4*Main.WIDTH/7, 8*Main.HEIGHT/25, size.width, size.height);
		//name
		add(nameLabel);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(Main.WIDTH/4, 7*Main.HEIGHT/15, size.width, size.height);
		add(name);
		size = name.getPreferredSize();
		name.setBounds(4*Main.WIDTH/7, 82*Main.HEIGHT/175, size.width, size.height);
		//class
		add(classLabel);
		size = classLabel.getPreferredSize();
		classLabel.setBounds(Main.WIDTH/4, 9*Main.HEIGHT/15, size.width, size.height);
		add(classOptionList);
		size = classOptionList.getPreferredSize();
		classOptionList.setBounds(4*Main.WIDTH/7, 87*Main.HEIGHT/175, size.width, size.height);
		//activity
		add(activityLabel);
		size = activityLabel.getPreferredSize();
		activityLabel.setBounds(Main.WIDTH/17, 11* Main.HEIGHT/15, size.width, size.height);
		add(activityOptionList);
		size = activityOptionList.getPreferredSize();
		activityOptionList.setBounds(4*Main.WIDTH/7, 111*Main.HEIGHT/175, size.width, size.height);
		//done button
		add(doneButton);
		size = doneButton.getPreferredSize();
		doneButton.setBounds(7*Main.WIDTH/8, 7*Main.HEIGHT/8, size.width, size.height);
		
		this.m = m;
	}

	/**
	 * Inserts the background image of school and customization title into the window.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
		g.drawImage(customization, CUSTOMIZATION_X, CUSTOMIZATION_Y,null);
	}
	
	
	/**
	 * Allows switching panels when the DONE button is pressed, so the game will start.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==doneButton) 
		{
			m.changePanel("3");
	/*		JFrame newJFrame = new JFrame("High School Experience");
			GamePanel panel = new GamePanel();
			newJFrame.setBounds(100, 100, Main.WIDTH, Main.HEIGHT);
	/		newJFrame.setContentPane(panel);
			newJFrame.setResizable(false);
			newJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newJFrame.setVisible(true);*/
			
			 // 1=history, 2=science, 3=literature, 4=mathematics
			String className = (String) classOptionList.getSelectedItem();
			int classType = 1;
			if (className.equals("History"))
				classType = 1;
			else if (className.equals("Science"))
				classType = 2;
			else if (className.equals("Literature"))
				classType = 3;
			else if (className.equals("Mathematics"))
				classType = 4;
			m.setPlayerState(name.getText(), classType);
		}

	}
}
