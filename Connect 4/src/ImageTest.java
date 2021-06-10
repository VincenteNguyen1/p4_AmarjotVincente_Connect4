import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

@SuppressWarnings("serial")
public class ImageTest extends Applet {
	
	ImageTest test = new ImageTest();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	private Image img = null;
	
	public void paint(Graphics g) {
		
		this.setSize(680, 440);
		
		if (img ==  null) img = getImage("board.png");
	
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, 20, 20, 20, 20, this);   
		
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

}
