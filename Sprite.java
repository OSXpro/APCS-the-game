import java.awt.*;
import java.util.ArrayList;
import java.util.Set;


public class Sprite {
	int x,y,velocity, index;
	double frames;
	Image image, walk1, walk2, idle;
	ArrayList<Image> sprite;
	
	public Sprite(int x, int y, int velocity, Image image){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.image = image;
		walk1 = image;
		walk2 = image;
		sprite = new ArrayList<Image>();
		for(int i = 0; i < 12; i += 3){
			sprite.add(walk1);
			sprite.add(walk1);
			sprite.add(walk2);
		}
		index = 0;
	}
	public Sprite(int x, int y, int velocity, Image walk1, Image walk2){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		image = walk1;
		this.walk1 = walk1;
		this.walk2 = walk2;
		sprite = new ArrayList<Image>();
		for(int i = 0; i < 12; i += 3){
			sprite.add(walk1);
			sprite.add(walk1);
			sprite.add(walk2);
		}
		index = 0;
	}
	
	public Sprite(int x, int y, int velocity, ArrayList<Image> sprite){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		image = sprite.get(0);
		this.walk1 = sprite.get(1);
		this.walk2 = sprite.get(2);
		this.sprite = sprite;
		index = 0;
	}
	public void draw(Graphics page){
		//page.clearRect(x,y, image.getWidth(null), image.getHeight(null));
		page.drawImage(image, x, y, null);
	}

	public void move(Set<Character> keys, int width, int height){
		boolean still = true;
		idle = sprite.get(index);
		walk1 = sprite.get(index + 1);
		walk2 = sprite.get(index +2);
		if(keys.contains('w')){
			if(y > 0)
				y -= velocity;
			frames ++;
			still = false;
			index = 0;
		}
		
		if(keys.contains('a')){
			if(x > 0)
				x -= velocity;
			frames ++;
			still = false;
			index = 3;
		}
		
		if(keys.contains('s')){
			if(y + image.getHeight(null) < height)
				y += velocity;
			frames ++;
			still = false;
			index = 6;
		}
		
		if(keys.contains('d')){
			if(x + image.getWidth(null) < width)
				x += velocity;
			frames ++;
			still = false;
			index = 9;
		}
		
		if(still)
			image = idle;
		else{
			if(frames > 80)
				image = walk2;
			if(frames > 160){
				image = walk1;
				frames = 0;
			}
		}
	}
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
}
