import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	Board board = new Board();
	StartScreen screen = new StartScreen();
	
	public static void main(String[] args) {
		new GUI();
		Music backgroundMusic = new Music("Local_Forecast_-_Elevator.wav", true);
		//backgroundMusic.run();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		screen.paint(g);
		board.paint(g);
		
		for(int r = 0, y1 = 9; r < board.getBoard().length; r++, y1 += 115) {
			int x1 = 17;
			for(int c = 0; c < board.getBoard()[0].length; c++, x1 += 125) {
				if(board.getBoard()[r][c].img != null) {
					g2.drawImage(board.getBoard()[r][c].img, x1, y1, 100, 100, null);
				}
			}
		}
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