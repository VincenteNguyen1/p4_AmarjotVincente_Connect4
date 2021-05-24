
public class Runner {

	public static void main(String[] args) {
		
		Board board = new Board();
		
		board.addPiece(0);//1
		board.addPiece(1);//2
		board.addPiece(1);//1
		board.addPiece(2);//2
		board.addPiece(3);//1
		board.addPiece(2);//2
		board.addPiece(2);//1
		board.addPiece(3);//2
		board.addPiece(3);//1
		board.addPiece(4);//2
		board.addPiece(3);//1

		board.printBoard();

	}
	
	
	
	
}
