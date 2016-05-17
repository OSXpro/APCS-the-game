import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class FILEIO {
	int imgspeed = 0, index;
	Color color = null;
	Image file;
	public String[] arr1;
	double x;
	double y;
	double velocity;


	public boolean isRed()
	{
		boolean c = false;
		if(this.index <3)
			c = true;
		return c;
	}
	public FILEIO(double speed) throws IOException
	{
		x = 0;
		y = (int)(Math.random() * 500);
		velocity = speed;
		String[] arr ={"src//file1.png","src//file2.png", "src//file3.png", 
				"src//file4.png", "src//file5.png", "src//file6.png"};
		index = (int) ((Math.random() * 10) % 6);
		file = ImageIO.read(new File(arr[index]));
	
	}
	
	public void draw(Graphics page)
	{
		page.drawImage(file,(int)x, (int)y, null);
		
	}
	public void move(Graphics g)
	{
		x += velocity;
		
	}
	public boolean collide(Sprite character){
		return ((Math.abs(character.x - x) < 60) && ((Math.abs(character.y - y) < 30)));
	}
	
	

	
}
