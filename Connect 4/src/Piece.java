import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Piece {
	
	//Instance Variables
	private int value;//assigns a value to a piece --> How we know wether a piece is red or black
	private static int turnCntr;//counts turns; but this means one side will always go first (only at the start)
	public Image img = null;
	public String path = "";

	//Constructor
	public Piece() {
		value = 0;//all pieces with a value of 0 are "empty"
		img = null;
	}
	
	//Methods:

	/*
	 * Sets a value to a piece based on what turn it is.
	 */
	
	public void setValue() {
		if(turnCntr%2 == 0) value = 1;//RED CHIP
		if(turnCntr%2 != 0) value = 2;//BLACK CHIP
	}
	
	/*
	 * Sets the image for a piece automatically based on who's turn it is.
	 */
	
	public void setImage() {
		if(turnCntr%2 == 0) {//RED CHIP
			path = "red poker chip.png";
			img = getImage("red poker chip.png");
		}
		if(turnCntr%2 != 0) {//BLACK CHIP
			path = "black poker chip.png";
			img = getImage("black poker chip.png");
		}
	}
	
	/*
	 * Sets the value and the image for a piece using the two methods.
	 */
	
	public void setPiece() {
		setValue();
		setImage();
	}
	
	public static String getTurn() {//return who's turn it is based on the turnCntr
		if(turnCntr%2 == 0) return "Red";
		if(turnCntr%2 != 0) return "Black";
		return "";
	}
	
	/*
	 * Method to get an Image from a file name.
	 */
	
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
	
	//Getters & Setters
	
	public int getValue() {//getter for value
		return value;
	}

	public Image getImage2() {//getter for img
		return img;
	}
	
	public String getPath() {//getter for path
		return path;
	}
	
	public static int getTurnCntr() {//getter for turnCntr
		return turnCntr;
	}
	
	public static void setTurnCntr() {//adds one to turnCntr
		turnCntr++;
	}
	

}
