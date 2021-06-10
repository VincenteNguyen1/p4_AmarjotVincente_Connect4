import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;

@SuppressWarnings("serial")
public class GUI extends JPanel implements ActionListener, MouseListener { 
	
	JFrame window; 
	Container con;
	JPanel titlePanel, startPanel;
	JLabel title; 
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	Font ButtonFont = new Font("Times New Roman", Font.PLAIN, 40);
	JButton startButton;
	Timer t;
	
	Board board = new Board();
	StartScreen screen = new StartScreen();
	
	Image redWin = getImage("RedTeamWinsFinal.png");
	Image blackWin = getImage("BlackTeamWinsFinal.png");
	Image tieGame = getImage("TieGame.png");
	
	public boolean gameOver;
	
	public static void main(String[] args) {
		new GUI();
		Music backgroundMusic = new Music("Local_Forecast_-_Elevator.wav", true);
		backgroundMusic.run();
	}
	
	public void paint(Graphics g) {	
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(StartScreen.getIsActive()) {
			screen.paint(g);
		}	
		if(!StartScreen.getIsActive()) {
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
		if(gameOver) {
			if(board.checkFour().equals("Red")) {
				g2.drawImage(redWin, 0, 0, 880, 690, null);
			}
			if(board.checkFour().equals("Black")) {
				g2.drawImage(blackWin, 0, 0, 880, 690, null);
			}
			if(board.checkTie().length() > 0) {
				g2.drawImage(tieGame, 0, 0, 880, 690, null);
			}
			g2.setColor(Color.blue);
			g2.fillRect(830, 0, 50, 50);
			g2.setColor(Color.white);
			g2.drawLine(840, 10, 870, 40);
			g2.drawLine(840, 40, 870, 10);
		}
	}
	
	public GUI() {
		gameOver = false;
		window = new JFrame ();
		window.setSize(895,729);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		t = new Timer(16, this);
		t.start();
		window.setVisible(true);
		window.addMouseListener(this);
	}
	
	public void setGameOver(boolean b) {
		gameOver = b;
	}
	
	public Image getImage(String path) {
		Image tempImage = null; 
		try {
			URL url = ImageTest.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(url);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			//System.out.println("Can't Find the File");
		}
		return tempImage;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Music singleChip = new Music("single chip drop.wav", false);
		Music emptyBoard = new Music("emptying the board.wav", false);
		int x = e.getX();//sets variable x equal to mouse x position
		int y = e.getY();//sets variable y equal to mouse y position
		
		if(!StartScreen.getIsActive() && !gameOver) {
			if(x >= 30 && x <= 130) {
				board.addPiece(0);
				singleChip.run();
			}
			if(x >= 155 && x <= 250) {
				board.addPiece(1);
				singleChip.run();
			}
			if(x >= 275 && x <= 375) {
				board.addPiece(2);
				singleChip.run();
			}
			if(x >= 400 && x <= 500) {
				board.addPiece(3);
				singleChip.run();
			}
			if(x >= 525 && x <= 625) {
				board.addPiece(4);
				singleChip.run();
			}
			if(x >= 650 && x <= 750) {
				board.addPiece(5);
				singleChip.run();
			}
			if(x >= 775 && x <= 875) {
				board.addPiece(6);
				singleChip.run();
			}
			if(board.checkFour().length() > 0 || board.checkTie().length() > 0) {
				gameOver = true;
				emptyBoard.play();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();//sets variable x equal to mouse x position
		int y = e.getY();//sets variable y equal to mouse y position
		if(StartScreen.getIsActive()) {
			if(x >= 70 && x <= 370) {
				if(y >= 380 && y <= 530) {
					StartScreen.setIsActive(false);
				}
			}
		}
		if(gameOver) {
			if(x >= 830 && x <= 880) {
				if(y >= 0 && y <= 80) {
					board = new Board();
					StartScreen.setIsActive(true);
					gameOver = false;
				}
			}
		}
	}

}