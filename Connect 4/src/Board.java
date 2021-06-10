import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Board {
	private int len = 6;
	private int cols = 7;
	private Piece[][] board;
	public Image img;
	private int x = 0, y = 0;
	private int firstTurn;

	public Board() {
		firstTurn = 0;
		img = getImage("Board.png");
		board = new Piece[len][cols];
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = new Piece();
			}
		}
		System.out.println(Piece.getTurn() + " Team Starts.");
	}
	
	public void paint(Graphics g) {	
		if(img == null) {
			this.img = getImage("Connect4 Board.png");
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, x, y, 885, 690, null);
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
				System.out.println("Cannot Place Piece At Column: " + col + ". Please try a Different Column.");
				return;
			}
			r--;
		}
		board[r][col].setPiece();
		Piece.setTurnCntr();
		firstTurn++;
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
	
	public String checkFour() {
		if(checkFourHorizontal().length() > 0) {
			//System.out.println(checkFourHorizontal() + " Team Wins!");
			return checkFourHorizontal() ;
		}
		if(checkFourVerticle().length() > 0) {
			//System.out.println(checkFourVerticle() + " Team Wins!");
			return checkFourVerticle();
		}
		if(checkFourUpDiagonal().length() > 0) {
			//System.out.println(checkFourUpDiagonal() + " Team Wins!");
			return checkFourUpDiagonal();
		}
		if(checkFourUpDiagonalD().length() > 0) {
			//System.out.println(checkFourUpDiagonalD() + " Team Wins!");
			return checkFourUpDiagonalD();
		}
		return "";
	}
	
	public String checkTie() {
		int ctr = 0;
		for(int r = 0; r< board.length; r ++) {
			for(int c = 0; c < board[r].length; c ++) {// scans each rol and col
					if(board[r][c].getValue() == 1 || board[r][c].getValue() == 2) {
							ctr ++;
					}
					if(ctr == len * cols) return "tie";
			}
		}
		return "";
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
	
	public int getFirstTurn() {
		return firstTurn;
	}
	
	public void setFirstTurn(int num) {
		firstTurn = num;
	}
		
}
	

