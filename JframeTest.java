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

public class JframeTest extends JPanel implements KeyListener{
	public Sprite character;
	Set<Character> keys = new HashSet<Character>();
	ArrayList<Image> sprite = new ArrayList<Image>();
	int frames;
	public JframeTest(){
		super();
		frames = 0;
		addKeyListener(this);
		try {
			sprite.add(ImageIO.read(new File("src/Sprite/back.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/back walk 1.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/back walk 2.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/left idle.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/left walk.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/left walk 2.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/Idle.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/front walk 1.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/front walk 2.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/right idle.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/right walk.png")));
			sprite.add(ImageIO.read(new File("src/Sprite/right walk 2.png")));
			character = new Sprite(400,250, 0.25, sprite);
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
		int width = getWidth();
	    int height = getHeight();
	    character.draw(g);
	    character.move(keys, width, height);
	    repaint();
	  }

	public synchronized void keyPressed(KeyEvent event) {
		//System.out.println("Hi");
		//Adds pressed key to seta
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
