import java.awt.Image;

public class Pieces {
	
	private int value;
	private Image img;

	public Pieces(boolean isRed) {
		if(isRed) { 
			value = 1;
			img = getImage("red poker chip.png");
		}
		if(!isRed) {
			value = 2;
			img = getImage("black poker chip.png");
		}

	}

	private Image getImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
