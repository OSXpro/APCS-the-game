import java.awt.*;
import java.util.Set;


public class Sprite {
	int x,y,velocity;
	double frames;
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
		//page.clearRect(x,y, image.getWidth(null), image.getHeight(null));
		page.drawImage(image, x, y, null);
	}

	public void move(Set keys, int width, int height){
		
		if(frames > 80)
			image = walk2;
		if(frames > 160){
			image = walk1;
			frames = 0;
		}
		
		if(keys.contains('w')){
			if(y > 0)
				y -= velocity;
			frames ++;
		}
		
		if(keys.contains('a')){
			if(x > 0)
				x -= velocity;
			frames ++;
		}
		
		if(keys.contains('s')){
			if(y + image.getHeight(null) < height)
				y += velocity;
			frames ++;
		}
		
		if(keys.contains('d')){
			if(x + image.getWidth(null) < width)
				x += velocity;
			frames ++;
		}
	}
}

