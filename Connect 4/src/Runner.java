
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Runner extends JPanel{
	
	Board board = new Board();
	
	public void paint(Graphics g) {		
		//this.setSize(500, 500);
		super.paintComponent(g);
		board.paint(g);
	}

	
	public static void main(String[] args) {
		Runner runner = new Runner();
	}
	
	
	public Runner() {
		JFrame f = new JFrame("Connect Four");
		f.setSize(new Dimension(900, 600));
		f.add(this);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
}
