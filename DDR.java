
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class DDR extends JPanel implements KeyListener{
	Set<Character> keys = new HashSet<Character>();
	static JFrame frame;
	static DDR panel = new DDR();
	static Music player;
	
	public DDR(){
		super();
		addKeyListener(this);

	}

	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	}

	public static void main(String[] args){
	    
	    frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.addKeyListener(panel);
	    //frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.white);
	    frame.setVisible(true);
	    player = new Music();
		player.play("src/music/Undertale OST - Temmie Village Extended.wav");
	}

	public void paintComponent(Graphics g) {
		
	
	    int width = getWidth();
	    int height = getHeight();
	    g.clearRect(0, 0, width, height);
	    g.setColor(Color.black);
	    

	   
	    repaint();
	  }
	
	public synchronized void keyPressed(KeyEvent event) {
		//System.out.println("Hi");
		//Adds pressed key to set
		keys.add(event.getKeyChar());
		
	}

	//Runs when a key is released
	public synchronized void keyReleased(KeyEvent event){
		//Method to remove key from Set if released
		System.out.println(event.getKeyChar());
		if(keys.contains(event.getKeyChar()))
			keys.remove(event.getKeyChar());
	}

	//Empty Implemented method that has to be here for use of listener
	public void keyTyped(KeyEvent event) {

	}
}
