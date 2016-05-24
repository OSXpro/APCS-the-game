import java.awt.Graphics;
import java.awt.Image;

public class arrow {
	double x, y, velocity;
	Image arrow;
	public arrow(double x, double velocity, Image image){
		this.x = x;
		this.velocity = velocity;
		y = 0;
		arrow = image;
	}
	
	public void move(){
		y += velocity;
	}
	
	public void draw(Graphics g){
		g.drawImage(arrow,(int) x,(int)y,null);
	}
	
	public boolean isUp(){
		return x == 450;
	}
	
	public boolean isLeft(){
		return x == 50;
	}
	
	public boolean isDown(){
		return x == 250;
	}
	
	public boolean isRight(){
		return x == 650;
	}
}
