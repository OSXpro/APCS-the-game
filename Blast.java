import java.awt.Color;
import java.awt.Graphics;

public class Blast extends Thread{
	int x,y;
	boolean isHorizontal;
	Color color;
	final int Thickness = 100;
	public Blast(int x, int y, boolean isHorizontal, Color color){
		this.x = x;
		this.y = y;
		this.isHorizontal = isHorizontal;
		this.color = color;
	}
	public void draw(Graphics page, int width, int height){
		page.setColor(color);
		for(int i = 0; i < Thickness; i += 5){
			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isHorizontal)
				page.drawRect(x, y, width, Thickness);
			else
				page.drawRect(x, y, Thickness, height);
		}
	}
	public boolean collide(Sprite character){
		if(isHorizontal)
			return (((Math.abs(character.y - y) < Thickness)));
		else
			return (((Math.abs(character.x - x) < Thickness)));
	}
}
