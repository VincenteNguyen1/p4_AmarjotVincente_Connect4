import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Board {
	
	//Instance Variables
	private int len = 6;
	private int cols = 7;
	private Piece[][] board;
	public Image img;
	private int x = 0, y = 0;
	private int firstTurn;
	
	//Constructor
	public Board() {
		firstTurn = 0;
		img = getImage("Board.png");
		board = new Piece[len][cols];
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = new Piece();
			}
		}
		//Prints out what team starts, because it alternates every round.
		System.out.println(Piece.getTurn() + " Team Starts.");}
	
	//Methods:
	
	/*
	 * Paint method
	 */
	
	public void paint(Graphics g) {	
		if(img == null) img = getImage("Connect4 Board.png");
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, x, y, 885, 690, null);
	}
	
	/*
	 * Adds a piece at a certain column and automatically drops it down.
	 * Whatever team placed it is decided by the turnCntr.
	 * If a piece cannot be placed in a column, it will return without incrementing turnCntr so that the same
	 * player can go again, and print out that you cannot place a piece at this column.
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
	
	/*
	 * Just prints out the board in the console
	 */
	
	public void printBoard() {//Static method so you can call with Board class itself
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c].getValue() + " ");
			}
			System.out.println("");
		}
	}
	
	/*
	 * Checks the board for four in a row in any direction, and returns the winner in terms of a String 
	 */
	
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
	
	/*
	 * Checks the board for a tie game 
	 */
	
	public String checkTie() {
		int ctr = 0;
		for(int r = 0; r< board.length; r ++) {
			for(int c = 0; c < board[r].length; c ++) {// scans each rol and col
					if(board[r][c].getValue() == 1 || board[r][c].getValue() == 2) {
							ctr ++;
					}
					if(ctr == len * cols) return "Tie";
			}
		}
		return "";
	}
	
	/*
	 * Checks the board for four in a row horizontally, and returns the winner in the form of a string.
	 */
	
	public String checkFourHorizontal() {
		for(int r = board.length - 1; r > 0; r--) {
			for(int c = 0; c < board[0].length - 4; c++) {
				//RED TEAM
				if(board[r][c].getValue() == 1) {
					if(board[r][c + 1].getValue() == 1 &&
					   board[r][c + 2].getValue() == 1 && 
					   board[r][c + 3].getValue() == 1) {
						return "Red";
					}
				}
				//BLACK TEAM
				else if(board[r][c].getValue() == 2) {
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
	
	/*
	 * Checks the board for four in a row vertically, and returns the winner in the form of a string.
	 */
	
	public String checkFourVerticle() {
		for(int r = board.length - 1; r > 4; r--) {
			for(int c = 0; c < board[0].length; c++) {
				//RED TEAM
				if(board[r][c].getValue() == 1) {
					if(board[r - 1][c].getValue() == 1 &&
					   board[r - 2][c].getValue() == 1 && 
					   board[r - 3][c].getValue() == 1) {
						return "Red";
					}
				}
				//BLACK TEAM
				else if(board[r][c].getValue() == 2) {
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
	
	/*
	 * Checks the board for four in a row diagonally, from the top left to the bottom right.
	 * Returns the winner in the form of a string.
	 */
	
	public String checkFourUpDiagonal() {
		for(int r =3; r < board.length; r++) {
			for(int c = 0; c < board[r].length -3; c++) {
				//RED TEAM
				if(board[r][c].getValue() == 1) {
					if(board[r-1][c + 1].getValue() == 1 &&
					   board[r-2][c + 2].getValue() == 1 && 
					   board[r-3][c + 3].getValue() == 1) {
						return "Red";
					}
				}
				//BLACK TEAM
				else if(board[r][c].getValue() == 2) {
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
	
	/*
	 * Checks the board for four in a row diagonally, from the top right to the bottom left.
	 * Returns the winner in the form of a string.
	 */
	
	public String checkFourUpDiagonalD() {
		for(int r =0; r < board.length-3; r++) {
			for(int c = 0; c < board[r].length -3; c++) {
				//RED TEAM
				if(board[r][c].getValue() == 1) {
					if(board[r+1][c + 1].getValue() == 1 &&
					   board[r+2][c + 2].getValue() == 1 && 
					   board[r+3][c + 3].getValue() == 1) {
						return "Red";
					}
				}
				//BLACK TEAM
				else if(board[r][c].getValue() == 2) {
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
	
	/*
	 * Method to get Images 
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
	
	//Getters & Setters:
	
	public int getFirstTurn() {//getter for firstTurn
		return firstTurn;
	}
	
	public Piece[][] getBoard() {//getter for board
		return board;
	}
		
}
	

