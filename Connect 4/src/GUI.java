import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	
	JFrame window; 
	Container con;
	
	
	JPanel titlePanel, startPanel;
	JLabel title; 
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	Font ButtonFont = new Font("Times New Roman", Font.PLAIN, 40);
	
	JButton startButton;
	
	
	
	public static void main(String[] args) {
		
		new GUI();
		
		
	}
	
	public GUI() {
		
		window = new JFrame ();
		window.setSize(900,900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);;
		window.setLayout(null);
		window.setVisible(true);
		con =  window.getContentPane();
		
		titlePanel = new JPanel ();
		titlePanel.setBounds(50, 50, 400, 75);
		titlePanel.setBackground(Color.black);
		title =  new JLabel("CONNECT 4");
		title.setForeground(Color.white);
		title.setFont(titleFont);
		
		
		startPanel = new JPanel ();
		startPanel.setBounds(600, 300, 100, 100);
		startPanel.setBackground(Color.black);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(ButtonFont);
		
		titlePanel.add(title);
		con.add(titlePanel);
		con.add(startPanel);
		startPanel.add(startButton);
		
		
		
	}
	
	public void gameScreen() {
		
		
		
		
	}
	

}
