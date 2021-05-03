import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Piece {
	
	private int value;
	private static int turnCntr;//counts turns; but this means one side will always go first
	private Image img;
	private int x, y;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Piece() {
		if(turnCntr % 2 == 0) {//RED CHIP
			value = 1;//value for red
			img = getImage("red poker chip.png");
			init(100, 100);
		}
		if(turnCntr % 2 != 0) {//BLACK CHIP
			value = 2;//value for black
			img = getImage("black poker chip.png");
		}
		turnCntr++;
	}
	
	public int getValue() {
		return value;
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
	 * 
	 */
}
