import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class playCutOne {
	static JFrame f;
	public static void main(String[] args){
		
	  
	    Icon icon = new ImageIcon("src/Cutscene1.gif");
	    JLabel label = new JLabel(icon);

	    f = new JFrame("Animation");
	    f.add(new JPanel());
	    f.getContentPane().add(label);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.pack();
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	    Music player = new Music();
		player.play("src/music/Shop1.wav");
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	    //processEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
	public static void play(){
		Icon icon = new ImageIcon("src/Cutscene1.gif");
	    JLabel label = new JLabel(icon);

	    f = new JFrame("Animation");
	    f.add(new JPanel());
	    f.getContentPane().add(label);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.pack();
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	    Music player = new Music();
		player.play("src/music/Shop.wav");
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	    
	}

}
