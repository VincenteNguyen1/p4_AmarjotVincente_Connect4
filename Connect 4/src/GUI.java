import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GUI extends JPanel implements ActionListener, MouseListener {
	
	JFrame window; 
	Container con;
	JPanel titlePanel, startPanel;
	JLabel title; 
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	Font ButtonFont = new Font("Times New Roman", Font.PLAIN, 40);
	JButton startButton;
	Timer t ;
	
	boolean isActive = true;
	Board board = new Board();
	StartScreen screen = new StartScreen();
	
	public static void main(String[] args) {
		new GUI();
		Music backgroundMusic = new Music("Local_Forecast_-_Elevator.wav", true);
		//backgroundMusic.run();
	}
	
	public void paint(Graphics g) {
		//if(isActive) board.paint(g);
		//screen.paint(g);
		board.paint(g);
	}
	
	public GUI() {
		
		window = new JFrame ();
		window.setSize(900,900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	window.getContentPane().setBackground(Color.black);;
	//	window.setLayout(null);
		window.add(this);
		t = new Timer(16, this);
		t.start();
		
		window.setVisible(true);
	//	con =  window.getContentPane();
//		
//		titlePanel = new JPanel ();
//		titlePanel.setBounds(50, 50, 400, 75);
//		titlePanel.setBackground(Color.white);
//		title =  new JLabel("CONNECT 4");
//		title.setForeground(Color.white);
//		title.setFont(titleFont);
//		
//		startPanel = new JPanel ();
//		startPanel.setBounds(600, 300, 100, 100);
//		startPanel.setBackground(Color.black);
//		
//	//	startButton = new JButton("Start");
//		startButton.setBackground(Color.black);
//		startButton.setForeground(Color.white);
//		startButton.setFont(ButtonFont);
//		
//		titlePanel.add(title);
//		con.add(titlePanel);
	//	con.add(startPanel);
	//	startPanel.add(startButton);
		
		//;window.add(this);
		
	}
	
	public void gameScreen() {
			
	}
	
	public void mousePressed(MouseEvent arg0)
	{	
		System.out.println("asdasd");
		
		int x = arg0.getX();//sets variable x equal to mouse x position
		
		if(isActive)
		{
			//Column 1
			if(x >= 0 && x < 25) 
			{
				board.addPiece(0);
			}
			//Column 2
			if(x >= 25 && x < 50) 
			{
				board.addPiece(1);
			}
			//Column 3
			if(x >= 50 && x < 75) 
			{
				board.addPiece(2);
			}
			//Column 4
			if(x >= 75 && x < 100) 
			{
				board.addPiece(3);
			}
			//Column 5
			if(x >= 100 && x < 125) 
			{
				board.addPiece(4);
			}
			//Column 6
			if(x >= 125 && x < 150) 
			{
				board.addPiece(5);
			}
			//Column 6
			if(x >= 150 && x < 175) 
			{
				board.addPiece(6);
			}
		}
		board.addPiece(0);
		board.printBoard();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		int x = arg0.getX();//sets variable x equal to mouse x position
//		if(isActive)
//		{
//			//Column 1
//			if(x >= 0 && x < 25) 
//			{
//				board.addPiece(0);
//			}
//			//Column 2
//			if(x >= 25 && x < 50) 
//			{
//				board.addPiece(1);
//			}
//			//Column 3
//			if(x >= 50 && x < 75) 
//			{
//				board.addPiece(2);
//			}
//			//Column 4
//			if(x >= 75 && x < 100) 
//			{
//				board.addPiece(3);
//			}
//			//Column 5
//			if(x >= 100 && x < 125) 
//			{
//				board.addPiece(4);
//			}
//			//Column 6
//			if(x >= 125 && x < 150) 
//			{
//				board.addPiece(5);
//			}
//			//Column 6
//			if(x >= 150 && x < 175) 
//			{
//				board.addPiece(6);
//			}
//		}
//		board.printBoard();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	

}