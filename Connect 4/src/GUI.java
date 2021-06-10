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
	
	//Variables
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
	
	public static void main(String[] args) {//Main Method
		new GUI();
		Music backgroundMusic = new Music("Local_Forecast_-_Elevator.wav", true);
		backgroundMusic.run();
	}
	
	public void paint(Graphics g) {//Paint Method
		super.paintComponent(g);//refreshes the method properly
		Graphics2D g2 = (Graphics2D) g;
		
		/*
		 * If the Start Screen is 'active,' then it paints it. 
		 */
		
		if(StartScreen.getIsActive()) {
			screen.paint(g);
		}	
		
		/*
		 * If the game is active, it paints the board and then all of the pieces on top of it.
		 */
		
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
		
		/*
		 * If someone won the game, then it displays whoever won (or of its a tie), it shows who won, and creates an
		 * x-button in the top right of the screen
		 */
		
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
	
	//Constructor
	public GUI() {//Creates the JFrame
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
	
	/*
	 * Method to get images
	 */
	
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
		//Sound files:
		Music singleChip = new Music("single chip drop.wav", false);
		Music emptyBoard = new Music("emptying the board.wav", false);
		
		int x = e.getX();//sets variable x equal to mouse x position
		
		/*
		 * If the game is running, will drop the chips into a column depending on your mouse location.
		 * 
		 */
		
		if(!StartScreen.getIsActive() && !gameOver) {
			//Column 1
			if(x >= 30 && x <= 130) {
				board.addPiece(0);
				singleChip.run();
			}
			//Column 2
			if(x >= 155 && x <= 250) {
				board.addPiece(1);
				singleChip.run();
			}
			//Column 3
			if(x >= 275 && x <= 375) {
				board.addPiece(2);
				singleChip.run();
			}
			//Column 4
			if(x >= 400 && x <= 500) {
				board.addPiece(3);
				singleChip.run();
			}
			//Column 5
			if(x >= 525 && x <= 625) {
				board.addPiece(4);
				singleChip.run();
			}
			//Column 6
			if(x >= 650 && x <= 750) {
				board.addPiece(5);
				singleChip.run();
			}
			//Column 7
			if(x >= 775 && x <= 875) {
				board.addPiece(6);
				singleChip.run();
			}
			
			/*
			 * When the game ends, moves to a winner screen and resets the board.
			 * Plays the empty board sound effect also.
			 */
			
			if(board.checkFour().length() > 0 || board.checkTie().length() > 0) {
				gameOver = true;
				emptyBoard.play();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();//sets variable x equal to mouse x position
		int y = e.getY();//sets variable y equal to mouse y position
		
		/*
		 * If the start screen is active, and you click the button you will be put into the game.
		 */
		
		if(StartScreen.getIsActive()) {
			if(x >= 70 && x <= 370) {
				if(y >= 380 && y <= 530) {
					StartScreen.setIsActive(false);
				}
			}
		}
		
		/*
		 * If the game is over, and you click the x in the top right, you will be sent back the the start screen
		 */
		
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
	
	public void setGameOver(boolean b) {
		gameOver = b;
	}

}