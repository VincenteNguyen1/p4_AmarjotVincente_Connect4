import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener {
	private int len = 6;
	private int cols = 7;
	private Piece[][] board;
	public Image img = null;
	private int x = 0, y = 0;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	public static void main(String[] args) {		
		//Board board = new Board();
	}
	
	public Board() {
//		JFrame f = new JFrame("Connect Four");
//		f.setSize(800,600); //width and height
//		f.setLayout(new GridLayout(len,cols));
//		f.add(this);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
		img = getImage("Board.png");
		init(x, y);
		
		board = new Piece[len][cols];
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = new Piece();
			}
		}
	}
	
	public void paint(Graphics g) {	
		if(img == null) {
			img = getImage("Board.png");
		}
		Image temp = img;
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(temp, tx, null);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}
	
	/*
	 * adds a piece at a certain column and automatically decides what team was placing.
	 * 
	 * if a piece cannot be placed in a column, it will return without incrementing turnCntr so that the same
	 * player can go again
	 */
	public void addPiece(int col) {
		int r = board.length-1;
		while(board[r][col].getValue() > 0) {//drops piece to the bottom
			if(r - 1 < 0) {//If the piece cannot be placed, then it stops the method
				System.out.println("Cannot Place Piece At Column: " + col);
				return;
			}
			r--;
		}
		board[r][col].setPiece();
		Piece.setTurnCntr();
		
		//checks for four in a row
		if(checkFour()) {
			reset();
			System.out.println("New Game: " + Piece.getTurn() + " Team Starts");
		}
		
	}
	
	public Image getImage(String path) {
		Image tempImage = null; 
		try {
			URL url = ImageTest.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(url);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tempImage;
	}
	
	/*
	 * Just prints out the board in the console
	 * 
	 * also prints out what team will be added next
	 */
	public void printBoard() {//Static method so you can call with Board class itself
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c].getValue() + " ");
			}
			System.out.println("");
		}
	}
	
	public Piece[][] getBoard() {
		return board;
	}
	
	public void reset() {
		board = new Piece[len][cols];
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = new Piece();
			}
		}
	}
	
	public boolean checkFour() {
		if(checkFourHorizontal().length() > 0) {
			System.out.println(checkFourHorizontal() + " Team Wins!");
			return true;
		}
		if(checkFourVerticle().length() > 0) {
			System.out.println(checkFourVerticle() + " Team Wins!");
			return true;
		}
		if(checkFourUpDiagonal().length() > 0) {
			System.out.println(checkFourUpDiagonal() + " Team Wins!");
			return true;
		}
		if(checkFourUpDiagonalD().length() > 0) {
			System.out.println(checkFourUpDiagonalD() + " Team Wins!");
			return true;
		}
		return false;
	}
	
	public String checkFourHorizontal() {
		for(int r = board.length - 1; r > 0; r--) {
			for(int c = 0; c < board[0].length - 4; c++) {
				if(board[r][c].getValue() == 1) {//RED TEAM
					if(board[r][c + 1].getValue() == 1 &&
					   board[r][c + 2].getValue() == 1 && 
					   board[r][c + 3].getValue() == 1) {
						return "Red";
					}
				}
				else if(board[r][c].getValue() == 2) {//BLACK TEAM
					if(board[r][c + 1].getValue() == 2 &&
					   board[r][c + 2].getValue() == 2 &&
					   board[r][c + 3].getValue() == 2) {
						return "Black";
					}
				}
			}
		}
		return "";
	}
	
	public String checkFourVerticle() {
		for(int r = board.length - 1; r > 4; r--) {
			for(int c = 0; c < board[0].length; c++) {
				if(board[r][c].getValue() == 1) {//RED TEAM
					if(board[r - 1][c].getValue() == 1 &&
					   board[r - 2][c].getValue() == 1 && 
					   board[r - 3][c].getValue() == 1) {
						return "Red";
					}
				}
				else if(board[r][c].getValue() == 2) {//BLACK TEAM
					if(board[r - 1][c].getValue() == 2 &&
					   board[r - 2][c].getValue() == 2 && 
					   board[r - 3][c].getValue() == 2) {
						return "Black";
					}
				}
			}
		}
		return "";
	}
	
	public String checkFourUpDiagonal() {
		for(int r =3; r < board.length; r++) {
			for(int c = 0; c < board[r].length -3; c++) {
				if(board[r][c].getValue() == 1) {//RED TEAM
					if(board[r-1][c + 1].getValue() == 1 &&
					   board[r-2][c + 2].getValue() == 1 && 
					   board[r-3][c + 3].getValue() == 1) {
						return "Red";
					}
				}
				else if(board[r][c].getValue() == 2) {//BLACK TEAM
					if(board[r-1][c + 1].getValue() == 2 &&
					   board[r-2][c + 2].getValue() == 2 && 
					   board[r-3][c + 3].getValue() == 2) {
						return "Black";
					}
				}
			}
		}
		return "";
	}
	
	public String checkFourUpDiagonalD() {
		for(int r =0; r < board.length-3; r++) {
			for(int c = 0; c < board[r].length -3; c++) {
				if(board[r][c].getValue() == 1) {//RED TEAM
					if(board[r+1][c + 1].getValue() == 1 &&
					   board[r+2][c + 2].getValue() == 1 && 
					   board[r+3][c + 3].getValue() == 1) {
						return "Red";
					}
				}
				else if(board[r][c].getValue() == 2) {//BLACK TEAM
					if(board[r+1][c + 1].getValue() == 2 &&
					   board[r+2][c + 2].getValue() == 2 && 
					   board[r+3][c + 3].getValue() == 2) {
						return "Black";
					}
				}
			}
		}
		return "";
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			//On a click, figure out what tile was clicked
//			Tile theTile = (Tile) arg0.getComponent();
//			System.out.println(theTile.r);
			
			
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
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
}
	

