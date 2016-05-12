import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JframeTest extends JPanel implements KeyListener{
	public Sprite character;
	Set<Character> keys = new HashSet<Character>();
	int frames = 0;
	private ArrayList<FILEIO> files = new ArrayList();
	
	public JframeTest(){
		super();
		addKeyListener(this);
		try {
			character = new Sprite(100,250, 1, ImageIO.read(new File("H:/Backup/Workspace APCS/Final Project/src/hellmo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	}
	
	public static void main(String[] args){
	    JframeTest panel = new JframeTest();
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
		frames++;
		g.clearRect(0, 0, getWidth(), getHeight());
	    setBackground(Color.white);
	    int width = getWidth();
	    int height = getHeight();
	    g.setColor(Color.black);
	    g.drawOval(0, 0, width, height);
	    FILEIO file;
	    int good = 0;
	    int bad = 0;
	    
	    
	    character.draw(g);
	    character.move(keys, getWidth(), getHeight());
	    if(frames == 500){
	    	try {
				file = new FILEIO(Math.random());
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
				bad++;
			else if(a.collide(character) && a.isRed() == false)
				good ++;
		}
	    
		g.drawString("LIVES LEFT: " + (3-bad), 500,100);
		g.drawString("NEED TO GET:" + (10-good), 800, 100);
    	if(bad == 3)
    		g.drawString("YOU LOSE", 100, 100);
    	else if(good == 10)
    		g.drawString("YOU WIN", 100, 100);
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
		if(keys.contains(event.getKeyChar()))
			keys.remove(event.getKeyChar());
	}
		
	//Empty Implemented method that has to be here for use of listener
	public void keyTyped(KeyEvent event) {
			
	}
}