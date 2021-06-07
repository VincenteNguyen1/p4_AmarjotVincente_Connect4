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
		screen.paint(g);
		//board.paint(g);
	}
	
	public GUI() {
		window = new JFrame ();
		window.setSize(885,729);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		t = new Timer(16, this);
		t.start();
		window.setVisible(true);
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {	
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		
	}

}



//////////////

/*
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
 */

