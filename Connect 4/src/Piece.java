import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Piece {
	
	private int value;
	private static int turnCntr;//counts turns; but this means one side will always go first
	public Image img = null;
	public String path = "";

	public Piece() {
		value = 0;
		img = null;
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
			this.path = "red poker chip.png";
			this.img = getImage("red poker chip.png");
		}
		if(turnCntr%2 != 0) {//BLACK CHIP
			//value for black
			this.path = "black poker chip.png";
			this.img = getImage("black poker chip.png");
		}
	}
	public String getPath() {
		return path;
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

	public Image getImage2() {
		// TODO Auto-generated method stub
		return img;
	}

	//Things to add to this method:
	/*
	 * A Paint method/a way to display all of the images 
	 * 
	 */
}
