import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class file extends JPanel implements KeyListener{
	public Sprite character;
	Set<Character> keys = new HashSet<Character>();
	int frames = 0;
	private ArrayList<FILEIO> files = new ArrayList<FILEIO>(); ArrayList<Image> sprite = new ArrayList<Image>(); ArrayList<FILEIO> removed = new ArrayList<FILEIO>();
	int good = 0; static int bad = 0;
	static JFrame frame;
	static Music player;
	static file panel;
	public file(){
		super();
		good = 0;
		bad = 0;
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
		
	    panel = new file();
	    panel.setOpaque(false);
	    panel.setBackground(Color.black);
	    frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.addKeyListener(panel);
	    frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.black);
	   
	    frame.setVisible(true);
	    player = new Music();
		player.play("src/music/Battle Against a True Hero.wav");
	}
	
	public void paintComponent(Graphics g) {
		frames++;
		g.clearRect(0, 0, getWidth(), getHeight());
	    //g.setColor(Color.white);
	    FILEIO file;
	    
	    character.draw(g);
	    character.move(keys, getWidth(), getHeight());
	    if(frames == 500){
	    	try {
				file = new FILEIO(Math.random() * 5);
				files.add(file);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	frames = 0;
	    }
	    
	    for(FILEIO a: files){
			a.move(g);
			a.draw(g);
			if(a.collide(character) && a.isRed())
			{
				bad++;
				removed.add(a);
				good = 0;
			}
			else if(a.collide(character) && a.isRed() == false)
			{
				good ++;
				removed.add(a);
			}
		}
	    for(FILEIO a: removed){
	    	files.remove(a);
	    	
	    }
	    removed = new ArrayList<FILEIO>();
		g.drawString("LIVES LEFT: " + (3-bad), 0,10);
		g.drawString("NEED TO GET:" + (10-good), 700, 10);
		
		if(bad != 3 && good!= 10)
			repaint();
		else{
			player.stop();
			g.setFont(new Font("Comics Sans MS", Font.PLAIN, 100)); 
			//frame.remove(panel);
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	  }
	  
	public synchronized void keyPressed(KeyEvent event) {
		//System.out.println("Hi");
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
	public static void play(JFrame frame){
		file panel = new file();
	    panel.setOpaque(false);
	    panel.setBackground(Color.black);
	    //frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.addKeyListener(panel);
	    frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.black);
	   
	    frame.setVisible(true);
	    player = new Music();
		player.play("src/music/Battle Against a True Hero.wav");
		panel.paintComponent(panel.getGraphics());
	}
}