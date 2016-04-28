
import java.awt.*;
import java.util.Set;
import java.applet.*;

public class Sprite {
	int x,y,velocity, frames;
	Image image, walk1, walk2;
	
	
	public Sprite(int x, int y, int velocity, Image image){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.image = image;
		walk1 = image;
		walk2 = image;

	}
	public Sprite(int x, int y, int velocity, Image walk1, Image walk2){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		image = walk1;
		this.walk1 = walk1;
		this.walk2 = walk2;

	}
	
	public void draw(Graphics page){
		page.clearRect(x,y, image.getWidth(null), image.getHeight(null));
		page.drawImage(image, x, y, null);
	}

	public void move(Set keys){
		frames ++;
		if(frames % 10 == 0){
			if(image.equals(walk1))
				image = walk2;
			else
				image = walk1;
			frames = 0;
		}
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
}
