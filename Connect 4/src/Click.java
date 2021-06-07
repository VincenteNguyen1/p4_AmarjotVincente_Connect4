import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Click extends MouseAdapter {

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y= e.getY();
		
		System.out.println(x +" " + y);
	}
}
