import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InfiniteLoop extends JPanel implements KeyListener{
	public Sprite character;
	Set<Character> keys = new HashSet<Character>();
	ArrayList<Image> sprite = new ArrayList<Image>();
	
	public InfiniteLoop(){
		super();
		addKeyListener(this);
		try {
			sprite.add(ImageIO.read(new File("Game/src/Sprite/Idle.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/Idle.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/Idle.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/left idle.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/left walk.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/left walk2.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/back.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/back.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/back.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/right idle.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/right walk.png")));
			sprite.add(ImageIO.read(new File("Game/src/Sprite/right walk2.png")));
			
			
			character = new Sprite(100,250, 5, sprite);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	}
	
	public static void main(String[] args){
	    InfiniteLoop panel = new InfiniteLoop();
	    JFrame frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.addKeyListener(panel);
	    frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.white);
	    frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(),getHeight());
	    setBackground(Color.white);
	    int width = getWidth();
	    int height = getHeight();
	    g.setColor(Color.black);
	    g.drawOval(0, 0, width, height);
	    character.draw(g);
	    character.move(keys, width, height);
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