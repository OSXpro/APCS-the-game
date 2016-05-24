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

public class FileLevel extends JPanel implements KeyListener{
	public Sprite character;
	Set<Character> keys = new HashSet<Character>();
	int frames = 0;
	private ArrayList<FILEIO> files = new ArrayList<FILEIO>(); ArrayList<Image> sprite = new ArrayList<Image>(); ArrayList<FILEIO> removed = new ArrayList<FILEIO>();
	int good = 0; int bad = 0;
	
	public FileLevel(){
		super();
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
			sprite.add(ImageIO.read(new File("src/Sprite/right walk 2.png")));//images for walking animations
			character = new Sprite(400,250, 0.25, sprite);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	}
	
	public static void main(String[] args){
	    FileLevel panel = new FileLevel();//creates the jframe
	    JFrame frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.addKeyListener(panel);
	    frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.black);
	   
	    frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		frames++;
		g.clearRect(0, 0, getWidth(), getHeight());//creates the size
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
	    g.setColor(Color.black);
	    FILEIO file;
	    
	    character.draw(g);
	    character.move(keys, getWidth(), getHeight());
	    if(frames == 500){
	    	try {
				file = new FILEIO(Math.random()*2);
				files.add(file);//every 500 frames, a new fileIO is created
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	frames = 0;
	    }
	    
	    for(FILEIO a: files){
			a.move(g);//goes through the list of IOs and moves each one
			a.draw(g);
			if(a.collide(character) && a.isRed())
			{//if you touch a red one, it is removed from the screen, you lose a life, and your score is reset
				bad++;
				removed.add(a);
				good = 0;
			}
			else if(a.collide(character) && a.isRed() == false)
			{
				good ++;//if you touch a green one, it is removed from the screen and your score is added one
				removed.add(a);
			}
		}
	    for(FILEIO a: removed){
	    	files.remove(a);
	    	if(bad == 3)
	    	{//if you lose all three lives, you lose
	    		g.setFont(new Font("TimesRoman", Font.PLAIN, 100)); 
	    		g.drawString("YOU LOSE", 100, 200);
	    		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
	    	}
	    	else if(good == 10)
	    	{//if you get 10 in a row, you win.
	    		g.setFont(new Font("TimesRoman", Font.PLAIN, 100)); 
	    		g.drawString("YOU WIN", 200, 200);
	    		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
	    	}
	    }
	    removed = new ArrayList<FILEIO>();
		g.drawString("LIVES LEFT: " + (3-bad), 0,10);//displays how many lives you have
		g.drawString("NEED TO GET:" + (10-good), 700, 10);//displays your score
		
		if(bad != 3 && good!= 10)
			repaint();//as long as you haven't won or lost, then it repaints.
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