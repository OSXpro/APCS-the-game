//Tanveer Mittal, Michael Mardyla, Matteo Sabato

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Inherits Jpanel to easily use many methods
public class InfiniteLoop extends JPanel implements KeyListener{
	//Initialize data for this level
	public Sprite character;
	Set<Character> keys = new HashSet<Character>();
	ArrayList<Image> sprite = new ArrayList<Image>();
	int frames;
	static JTextField txt;
	static JFrame frame;
	boolean added = false;
	static InfiniteLoop panel = new InfiniteLoop();
	String input = "temp";
	static Music player;
	
	//Constructor for our child of Jpanel
	public InfiniteLoop(){
		super();
		frames = 0;
		addKeyListener(this);
		//Adds sprite walking images to arraylist in specific order
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
	
	//Method that returns size when frame.pack() is called
	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	}

	public static void main(String[] args){
	    //Intializes frame and sets up panel as drawing surface
	    frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.addKeyListener(panel);
	    txt = new JTextField("Break the Loop");
	    //frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.white);
	    frame.setVisible(true);
	    //Uses our music player class to play song
	    player = new Music();
	    player.play("src/music/Undertale OST - Temmie Village Extended.wav");
	}
	
	//
	public void paintComponent(Graphics g) {
	    //Logic to automatically return character to middle of screen
   	    frames ++;
     	    if(frames > 500){
		character.move(400, 250);
		frames = 0;
	}
	    
	    //Draws all parts of level(sprite, text)
	    int width = getWidth();
	    int height = getHeight();
	    g.clearRect(0, 0, width, height);
	    g.setColor(Color.black);
	    
	    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 32)); 
	    g.drawString("while(count == 1){", 150, 100);
	    g.drawString("}", 600, 400);
	    //g.drawOval(0, 0, width, height);
	    character.draw(g);
	    
	    character.move(keys, width, height);
	    //Checks for textfield input
	    if(input.equals("break;") || input.equals("count ++;")){
	    	//waits 2 seconds then closes window
	    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    	frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	    }
	    else
	    	repaint();
	  }
	
	public synchronized void keyPressed(KeyEvent event) {
		//Adds pressed key to set
		keys.add(event.getKeyChar());
		//If enter is pressed, it creates the textfield
		if(event.getKeyCode() == event.VK_ENTER && !added){
			txt.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					input = txt.getText();
				}
		});
		//adds field to panel
		panel.add(txt);
		
		//Sets frame for use again
		frame.pack();
		frame.setBackground(Color.white);
		frame.setVisible(true);
		added = true;
		}
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
