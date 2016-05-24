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


	public boolean isRed()//returns the color of the filepath
	{
		boolean c = false;
		if(this.index <3)//color based on index in the array
			c = true;
		return c;
	}
	public FILEIO(double speed) throws IOException
	{
		x = 0;
		y = (int)(Math.random() * 500);//randomly generates a location
		velocity = speed;
		String[] arr ={"src//file1.png","src//file2.png", "src//file3.png", 
				"src//file4.png", "src//file5.png", "src//file6.png"};//array of files
		index = (int) (Math.random() * 5);
		file = ImageIO.read(new File(arr[index]));//randomly makes the object
	
	}
	
	public void draw(Graphics page)
	{
		page.drawImage(file,(int)x, (int)y, null);//draws the image
		
	}
	public void move(Graphics g)
	{
		x += velocity;//moves the path across the screen
		
	}
	public boolean collide(Sprite character){
		return ((Math.abs(character.x - x) < 60) && ((Math.abs(character.y - y) < 30)));//tests to see if the player and the object are colliding
	}
	
	

	
}
