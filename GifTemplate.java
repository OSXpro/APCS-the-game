import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GifTemplate {
	public static void main(String[] args){

	  
	    Icon icon = new ImageIcon("C:/Users/tmittal/Desktop/Hellmo.gif");
	    JLabel label = new JLabel(icon);

	    JFrame f = new JFrame("Animation");
	    f.getContentPane().add(label);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.pack();
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	}
}
