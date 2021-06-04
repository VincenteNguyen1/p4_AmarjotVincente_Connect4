import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame  implements ActionListener{
	
	JFrame window; 
	Container con;
	
	
	JPanel titlePanel, startPanel;
	JLabel title; 
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	Font ButtonFont = new Font("Times New Roman", Font.PLAIN, 40);

	JButton startButton;
	
	
	public GUI (){
		
		
		//makes the window
		window = new JFrame ();
		window.setSize(900,900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con =  window.getContentPane();
		
	
		
		// makes connect 4 title on front page
		titlePanel = new JPanel ();
		titlePanel.setBounds(50, 50, 400, 75);
		titlePanel.setBackground(Color.black);
		title =  new JLabel("CONNECT 4");
		title.setForeground(Color.white);
		title.setFont(titleFont);
		titlePanel.add(title);
		con.add(titlePanel);
	
		// sets the background
		startPanel = new JPanel ();
		startPanel.setBounds(600, 300, 100, 100);
		startPanel.setBackground(Color.black);
		con.add(startPanel);
		
		// makes the start button
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(ButtonFont);
	//startPanel.setBounds(150,50,100,60);
		startPanel.add(startButton);
		startButton.addActionListener(this);
		
	}
	
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			
			startButton.setVisible(false);
			titlePanel.setVisible(false);
			window.getContentPane().setBackground(Color.black);
			startButton.setBackground(Color.black);
			startPanel.setBackground(Color.black);
			
			
		}
}


