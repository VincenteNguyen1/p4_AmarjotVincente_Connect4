import java.awt.Color;
import java.awt.GridLayout;
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
	private int width = 7;
	private static Piece[][] board;
	
	/* constructor for MainPain class */
	public Board() {
		
//		f.setLayout(new GridLayout(rows,cols));

		JFrame f = new JFrame("Example Drawing");
		f.setSize(800,600); //width and height
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		board = new Piece[len][width];
		
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = new Piece();
			}
		}
	}
	
	public void addPiece(int col) {
		int r = board.length-1;
		while(board[r][col].getValue() > 0) {
			if(r - 1 < 0) {
				System.out.println("Cannot Place Piece Here");
				return;
			}
			r--;
		}
		board[r][col].setPiece();
		Piece.turnCntr++;
	}
	
	public static void printBoard() {
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
	

