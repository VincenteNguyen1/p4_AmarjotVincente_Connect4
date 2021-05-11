import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Piece {
	
	private int value;
	public static int turnCntr;//counts turns; but this means one side will always go first
	private Image img;
	private int x, y;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Piece() {
		value = 0;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue() {
		if(turnCntr%2 == 0) value = 1;
		if(turnCntr%2 == 1) value = 2;
	}
	
	public void setImage() {
		if(turnCntr % 2 == 0) {//RED CHIP
			//value for red
			img = getImage("red poker chip.png");
			init(100, 100);
		}
		if(turnCntr % 2 != 0) {//BLACK CHIP
			//value for black
			img = getImage("black poker chip.png");
			init(100, 100);
		}
	}
	
	public void setPiece() {
		setValue();
		setImage();
	}
	
	public static int getTurnCntr() {//Static method so you don't need to use an object --> "Piece.getTurnCntr()"
		return turnCntr;
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Piece.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	//Things to add to this method:
	/*
	 * A Paint method maybe or a way to display all of the images 
	 * 
	 * Change the method so that when a piece is created it's value is set to zero instead of of 1 or two,
	 * and then make a setter for the value using the turncounter
	 * 
	 * add getter and setter for turncntr
	 */
}
