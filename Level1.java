import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;


public class Level1 extends Applet implements KeyListener, MouseListener {
		Set<Character> keys = new HashSet<Character>();
		boolean paused = true;
		int x,y, velocity;
		public void init(){
			setBackground(Color.white);
			x = 400;
			y = 250;
			velocity = 10;
			//Allows program to use mouse and keyboard events
			addKeyListener(this);
			addMouseListener(this);
		}
		
		public void paint(Graphics page){
			page.setColor(Color.black);
			page.drawRect(x,y,10,10);
			repaint();
		}
		
	  //Will run when any key is pressed
	  //Multiple instances of this method can be run at the same time
		public synchronized void keyPressed(KeyEvent event) {
			
			//Adds pressed key to set
			keys.add(event.getKeyChar());
			
			
			move();
			//Temporary variable for updating buidings y coordinates
			int z;
			
			
		}
		
		public void move(){
			if(keys.contains('w')){
				y -= velocity;
			}
			
			if(keys.contains('a')){
				x -= velocity;
			}
			
			if(keys.contains('s')){
				y += velocity;
			}
			
			if(keys.contains('d')){
				x += velocity;
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
		
		//Runs whenever mouse is clicked
		public void mouseClicked(MouseEvent event){
			int x,y,z;
			//retrieves x,y coordinates of click on screen
			x = event.getX();
			y = event.getY();
			
			
		}
		@Override
		public void mouseEntered(MouseEvent event) {
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent event) {
			
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
