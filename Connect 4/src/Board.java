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
	//change the size of the board if you need to
	private int len = 6;
	private int cols = 7;
	private static Piece[][] board;
	private Image img;
	
	/* constructor for MainPain class */
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
	
	public void addPiece(int col) {//adds a piece at a certain column and automatically decides what team was placing.
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
	}
	
	public static void printBoard() {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c].getValue() + " ");
			}
			System.out.println("");
		}
		if(Piece.getTurnCntr()%2 == 0) { System.out.println("Red Team Next (1)"); }else{ System.out.println("Black Team Next (2)"); }
	}
	
	public Piece[][] getBoard() {
		return board;
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
	

