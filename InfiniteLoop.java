import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

public class InfinateLoop extends JPanel implements KeyListener{
	public Sprite character;
	Set<Character> keys = new HashSet<Character>();
	static JTextField t;
	int frames;
	
	public InfinateLoop(){
		super();
		addKeyListener(this);
		try {
			character = new Sprite(400,250, .25, ImageIO.read(new File("src/Sprites/Idle.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	    
	}
	
	public static void main(String[] args){
	    InfinateLoop panel = new InfinateLoop();
	    JFrame frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.addKeyListener(panel);
	    frame.setSize(800, 500);
	    t = new JTextField("count ++;");
	    frame.pack();
	    frame.setBackground(Color.white);
	    frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		
		frames ++;
		if(frames > 500){
			character.move(400, 250);
			frames = 0;
		}
	    
	    
	    int width = getWidth();
	    int height = getHeight();
	    g.clearRect(0, 0, width, height);
	    g.setColor(Color.black);
	    
	    g.setFont(new Font("ComicSans", Font.PLAIN, 32)); 
	    g.drawString("while(1 == 1){", 150, 100);
		g.drawString("}", 600, 400);
	    //g.drawOval(0, 0, width, height);
	    character.draw(g);
	    character.move(keys, width, height);
	    repaint();
	  }
	  
	public synchronized void keyPressed(KeyEvent event) {
		
		//Adds pressed key to set
		keys.add(event.getKeyChar());
		System.out.println(keys);
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
