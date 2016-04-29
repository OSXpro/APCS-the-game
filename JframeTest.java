import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class JframeTest extends JPanel implements KeyListener{]{
	Sprite character;
	Set<Character> keys = new HashSet<Character>();
	
	public JframeTest(){
		super();
		try {
			character = new Sprite(400,250, 1, ImageIO.read(new File("H:/APCS/Game/src/Sprite.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	}
	
	public static void main(String[] args){
	    JPanel panel = new JPanel();
	    JFrame frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(new JframeTest());
	    frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.white);
	    frame.setVisible(true);
	}
	
	protected void paintComponent(Graphics g) {
	    setBackground(Color.white);
	    int width = getWidth();
	    int height = getHeight();
	    g.setColor(Color.black);
	    g.drawOval(0, 0, width, height);
	    character.draw(g);
	    character.move(keys);
	    repaint();
	  }
	  
	public synchronized void keyPressed(KeyEvent event) {
		//Adds pressed key to set
		keys.add(event.getKeyChar());
	}
		
	//Runs when a key is released
	public synchronized void keyReleased(KeyEvent event){
		//Method to remove key from Set if released
		if(keys.contains(event.getKeyChar()))
			keys.remove(event.getKeyChar());
	}
		
	//Empty Implemented method that has to be here for use of listener
	public void keyTyped(KeyEvent event) {
			
	}
}
