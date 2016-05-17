import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Death extends JPanel {
		static ArrayList <String> message = new ArrayList<String>(); 
		static Random rand = new Random();
		static int mess;
		static Music player;
		static JFrame frame; 
	public static void main(String[] args){
		    Death panel = new Death();
		    frame = new JFrame("APCS the game");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.add(panel);
		    frame.setSize(800, 500);
		    frame.setBackground(Color.black);
		    frame.pack();
		    frame.setVisible(true);
		    
		    
		    
		    message.add("Looks like you left your computer unlocked");
			message.add("You should drop the class");
			message.add("You didn't need that college credit anyway");
			message.add("Should have used eclipse");
			message.add("Stop using iIntelliJ");
			
			mess = rand.nextInt(message.size()-1);
			player = new Music();
			player.play("src/music/Determination.wav");
		}
	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	    
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
	    int width = getWidth();
	    int height = getHeight();
	    g.drawRect(0, 0, width, height);
	    g.setColor(Color.white);
	    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 32)); 
	    g.drawString(message.get(mess) + "...", 80, 250);
	    if(player.playCompleted)
	    	frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	    else
	    	repaint();
	  }
	

}
