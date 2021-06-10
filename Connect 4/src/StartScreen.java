import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class StartScreen {

	private static boolean isActive = true;
	private String path = "connectFourName.png";
	private Image img = null;
	private int x = 9, y = -25;
	
	public StartScreen() {
		img = getImage(path);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.gray);
		g2.fillRect(0, 0, 900, 900);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, 900, 230);
		g2.drawImage(img, x, y, 850, 300, null);
		g2.setColor(Color.white);
		g2.fillOval(70, 280, 300, 150);
		g2.fillOval(70, 480, 300, 150);
	}
	
	public static void setIsActive(boolean a) {
		isActive = a;
	}
	public static boolean getIsActive() {
		return isActive;
	}
	
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
	
	
}
