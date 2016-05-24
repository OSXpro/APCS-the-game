import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DDR extends JPanel implements KeyListener{
	Set<Integer> keys = new HashSet<Integer>();
	static JFrame frame;
	static DDR panel = new DDR();
	static Music player;
	static Image up, down, right, left;
	static ArrayList<arrow> temp;
	static ArrayList<ArrayList<arrow>> arrows;
	static ArrayList<Long> times;
	static ArrayList<ArrayList<Boolean>> displayed;
	static ArrayList<Boolean> bools;
	static int score, index, frames;
	static long previous, current, draw;
	static Random rand;
	static double velocity = 0.05;
	static boolean added;
	public DDR(){
		super();
		addKeyListener(this);
	}

	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	}

	public static void main(String[] args) throws IOException{
		previous = System.currentTimeMillis();
		draw = previous;
		index = 1;
		frames = 1;
		arrows = new ArrayList<ArrayList<arrow>>();
		bools = new ArrayList<Boolean>();
		displayed = new ArrayList<ArrayList<Boolean>>();
		score = 0;
		rand = new Random();
	    temp = new ArrayList<arrow>();
		up = ImageIO.read(new File("src/Arrows/up.jpg"));
		down = ImageIO.read(new File("src/Arrows/down.jpg"));
		right = ImageIO.read(new File("src/Arrows/right.jpg"));
		left = ImageIO.read(new File("src/Arrows/left.jpg"));
		    
		frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.addKeyListener(panel);
	    //frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.white);
	    frame.setVisible(true);
	    player = new Music();
		player.play("src/music/Mega Man 2 Medley.wav");
	   
	}

	public void paintComponent(Graphics g) {
		current = System.currentTimeMillis();
		frames ++;
		int width = getWidth();
	    int height = getHeight();
	    
		if((current - previous) > 1000){
		    for(int i = 0; i < 100; i ++){
		    	added = false;
		    	if(rand.nextInt(2) == 1){
		    		temp.add(new arrow(50, velocity, left));
		    		added = true;
		    		bools.add(true);
		    	}
		    	if(rand.nextInt(2) == 1){
		    		temp.add(new arrow(250, velocity, down ));
		    		bools.add(true);
		    		added = true;
		    	}
		    	if(rand.nextInt(2) == 1){
		    		temp.add(new arrow(450, velocity, up));
		    		added = true;
		    		bools.add(true);
		    	}
		    	if(rand.nextInt(2) == 1){
		    		temp.add(new arrow(650, velocity, right));
		    		added = true;
		    		bools.add(true);
		    	}
		    	if(!added){
		    		switch(rand.nextInt(4)){
		    		case 0:
		    			temp.add(new arrow(50, velocity, left));
		    			bools.add(true);
		    			break;
		    		case 1:
		    			temp.add(new arrow(250, velocity, down ));
		    			bools.add(true);
		    			break;
		    		case 2:
		    			temp.add(new arrow(450, velocity, up));
		    			bools.add(true);
		    			break;
		    		case 3:
		    			temp.add(new arrow(650, velocity, right));
		    			bools.add(true);
		    		}
		    	}
		    	arrows.add(temp);
		    	displayed.add(bools);
		    	for(int x = 0; x < temp.size(); x ++){
		    		temp.remove(x);
		    		bools.remove(x);
		    }
		    }
			previous = System.currentTimeMillis();
		}
		
		if((System.currentTimeMillis() - draw) > 100){
			g.clearRect(0, 0, width, height);
			for(int i = 0; i < arrows.size(); i++){
				for(int x = 0; x < arrows.get(i).size(); x ++){
					arrows.get(i).get(x).move();
					//arrows.get(i).get(x).draw(g);
				}
			}
			draw = System.currentTimeMillis();
		}
		g.clearRect(0, 0, width, height);
		for(int i = 0; i < arrows.size(); i++){
			for(int x = 0; x < arrows.get(i).size(); x ++){
				if(displayed.get(i).get(x))
					arrows.get(i).get(x).draw(g);
			}
		}
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 32)); 
	    g.drawString("Score: " + score, 0, 100);
	    try {
			g.drawImage(ImageIO.read(new File("src/Arrows/leftEmpty.jpg")), 50, 400, null);
			g.drawImage(ImageIO.read(new File("src/Arrows/downEmpty.jpg")), 250, 400, null);
		    g.drawImage(ImageIO.read(new File("src/Arrows/upEmpty.jpg")), 450, 400, null);
		    g.drawImage(ImageIO.read(new File("src/Arrows/rightEmpty.jpg")), 650, 400, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    repaint();
	  }
	
	public synchronized void keyPressed(KeyEvent event) {
		//System.out.println("Hi");
		//Adds pressed key to set
		keys.add(event.getKeyCode());
		if(keys.contains(event.VK_UP)){
			for(int i = 0; i < arrows.size(); i++){
				for(int x = 0; x < arrows.get(i).size(); x ++){
					if(arrows.get(i).get(x).isUp() && arrows.get(i).get(x).y < 500 && displayed.get(i).get(x)){
						displayed.get(i).remove(x);
						displayed.get(i).add(x, false);
						
						if(arrows.get(i).get(x).y - 400 > 400){
							score += 100;
						}
						else if(arrows.get(i).get(x).y - 300 > 200){
							score += 200;
						}
						else if(arrows.get(i).get(x).y - 200 > 100){
							score += 300;
						}
						else if(arrows.get(i).get(x).y - 100 > 50){
							score += 400;
						}
						else if(arrows.get(i).get(x).y - 100 > 25){
							score += 500;
						}
					}
				}
			}
		}
		if(keys.contains(event.VK_DOWN)){
			for(int i = 0; i < arrows.size(); i++){
				for(int x = 0; x < arrows.get(i).size(); x ++){
					if(arrows.get(i).get(x).isDown() && arrows.get(i).get(x).y < 500 && displayed.get(i).get(x)){
						displayed.get(i).remove(x);
						displayed.get(i).add(x, false);
					}
					if(arrows.get(i).get(x).y - 400 > 400){
						score += 100;
					}
					else if(arrows.get(i).get(x).y - 300 > 200){
						score += 200;
					}
					else if(arrows.get(i).get(x).y - 200 > 100){
						score += 300;
					}
					else if(arrows.get(i).get(x).y - 100 > 50){
						score += 400;
					}
					else if(arrows.get(i).get(x).y - 100 > 25){
						score += 500;
					}
				}
			}
		}
		if(keys.contains(event.VK_LEFT)){
			for(int i = 0; i < arrows.size(); i++){
				for(int x = 0; x < arrows.get(i).size(); x ++){
					if(arrows.get(i).get(x).isLeft() && arrows.get(i).get(x).y < 500 && displayed.get(i).get(x)){
						displayed.get(i).remove(x);
						displayed.get(i).add(x, false);
						if(arrows.get(i).get(x).y - 400 > 400){
							score += 100;
						}
						else if(arrows.get(i).get(x).y - 300 > 200){
							score += 200;
						}
						else if(arrows.get(i).get(x).y - 200 > 100){
							score += 300;
						}
						else if(arrows.get(i).get(x).y - 100 > 50){
							score += 400;
						}
						else if(arrows.get(i).get(x).y - 100 > 25){
							score += 500;
						}
					}
				}
			}
		}
		if(keys.contains(event.VK_RIGHT)){
			for(int i = 0; i < arrows.size(); i++){
				for(int x = 0; x < arrows.get(i).size(); x ++){
					if(arrows.get(i).get(x).isRight() && arrows.get(i).get(x).y < 500 && displayed.get(i).get(x)){
						displayed.get(i).remove(x);
						displayed.get(i).add(x, false);
						if(arrows.get(i).get(x).y - 400 > 400){
							score += 100;
						}
						else if(arrows.get(i).get(x).y - 300 > 200){
							score += 200;
						}
						else if(arrows.get(i).get(x).y - 200 > 100){
							score += 300;
						}
						else if(arrows.get(i).get(x).y - 100 > 50){
							score += 400;
						}
						else if(arrows.get(i).get(x).y - 100 > 25){
							score += 500;
						}
					}
				}
			}
		}
	}

	//Runs when a key is released
	public synchronized void keyReleased(KeyEvent event){
		//Method to remove key from Set if released
		//System.out.println(event.getKeyCode());
		if(keys.contains(event.getKeyCode()))
			keys.remove(event.getKeyCode());
	}

	//Empty Implemented method that has to be here for use of listener
	public void keyTyped(KeyEvent event) {
	}
}
