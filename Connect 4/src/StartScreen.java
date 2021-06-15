import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class StartScreen {
	
	//Instance Variables
	private static boolean isActive = true;
	private String path = "connectFourName.png";
	private Image img = null;
	private Image playText = null;
	private int x = 9, y = -25;
	
	//Constructor
	public StartScreen() {
		img = getImage(path);
		playText = getImage("play.png");
	}
	
	//Methods:
	
	/*
	 * Paints the StartScreen;
	 * Creates the Text and the button.
	 */
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.gray);
		g2.fillRect(0, 0, 900, 900);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, 900, 230);
		g2.drawImage(img, x, y, 850, 300, null);
		g2.setColor(Color.white);
		g2.fillOval(70, 380, 300, 150);
		g2.setColor(Color.black);
		g2.drawImage(playText, 95, 405, 250, 100, null);
	}
	
	/*
	 * Method to get the image. 
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
	
	public static void setIsActive(boolean a) {//setter for isActive
		isActive = a;
	}
	
	public static boolean getIsActive() {//getter for isActive
		return isActive;
	}
	
	
}
