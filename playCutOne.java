import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class playCutOne {
	public static void main(String[] args){

	  
	    Icon icon = new ImageIcon("H:/Final pictures/Cutscene1.gif");
	    JLabel label = new JLabel(icon);

	    JFrame f = new JFrame("Animation");
	    f.getContentPane().add(label);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.pack();
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	    
	    try {
			Thread.sleep(28026);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    f.dispose();
	    //processEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
}
