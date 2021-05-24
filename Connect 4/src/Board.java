import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements MouseListener {
	private int len = 6;
	private int cols = 7;
	private static Piece[][] board;
	private Image img;
	
	public Board() {
		JFrame f = new JFrame("Example Drawing");
		f.setSize(800,600); //width and height
		f.setLayout(new GridLayout(len,cols));
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		board = new Piece[len][cols];
		
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = new Piece();
			}
		}
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
		
		//checks for four in a row horizontally
		if(checkFourHorizontal().length() > 0) {
			System.out.println(checkFourHorizontal() + " Team Wins!");
			
			
		}
		
		if(checkFourUpDiagonal().length() > 0) {
			System.out.println(checkFourUpDiagonal() + " Team Wins!");
		}
		
		if(checkFourUpDiagonalD().length() > 0) {
			System.out.println(checkFourUpDiagonalD() + " Team Wins!");
		}
		
		
		
		if(checkTie().length() > 0) {
			System.out.println(checkTie());
		}
		
	
	}
	
	
	
	/*
	 * Just prints out the board in the console
	 * 
	 * also prints out what team will be added next
	 */
	public static void printBoard() {//Static method so you can call with Board class itself
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c].getValue() + " ");
			}
			System.out.println("");
		}
		//if(Piece.getTurnCntr()%2 == 0) { System.out.println("Red Team Next (1)"); }else{ System.out.println("Black Team Next (2)"); }
	}
	
	public Piece[][] getBoard() {
		return board;
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
	
	/*/public String checkFourVerticleL() {
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
	}/*/
	
	
	
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
	
	
	public String checkTie() {
		int ctr =0;
		for(int row=0; row < board.length; row ++) {
		for(int col = 0; col < board[row].length; col ++) {
			
			if(board [row] [col].getValue() == 1 || board [row] [col].getValue() == 2 ) {
				ctr ++;
				
			}
			if(ctr == len *cols) {	
				return "tie";
				
			}	
		}
	}
	return " ";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////

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
	

