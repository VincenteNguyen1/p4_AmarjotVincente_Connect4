import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Piece {
	
	private int value;
	private static int turnCntr;//counts turns; but this means one side will always go first
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
		if(turnCntr%2 == 0) value = 1;//RED CHIP
		if(turnCntr%2 != 0) value = 2;//BLACK CHIP
	}
	
	public void setImage() {
		if(turnCntr%2 == 0) {//RED CHIP
			//value for red
			this.img = getImage("red poker chip.png");
			//init(100, 100);
		}
		if(turnCntr%2 != 0) {//BLACK CHIP
			//value for black
			this.img = getImage("black poker chip.png");
			//init(100, 100);
		}
	}
	
	public void setPiece() {
		setValue();
		setImage();
	}
	
	public static String getTurn() {
		if(turnCntr%2 == 0) return "Red";
		if(turnCntr%2 != 0) return "Black";
		return "";
	}
	
	public static int getTurnCntr() {
		return turnCntr;
	}
	
	public static void setTurnCntr() {
		turnCntr++;
	}
	
//	public static void resetTurnCntr() {
//		turnCntr = 0;
//	}
	
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
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	//Things to add to this method:
	/*
	 * A Paint method/a way to display all of the images 
	 * 
	 */
}
