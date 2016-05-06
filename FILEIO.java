import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class FILEIO {
	int imgspeed = 0;
	Color color = null;
	String[] arr1;

	public int speed()
	{
		int speed = (int) (Math.random() * 100);
		return speed;
	}
	public FILEIO() throws IOException
	{
		String[] arr = ("src//file1.png","src//file2.png", "src//file3.png", 
				"src//file4.png", "src//file5.png", "src//file6.png");
		arr1 = arr;
		
		Sprite file;
		int path = (int)(Math.random() * 6);
		file = new Sprite(-200 , (int)(Math.random() * 500), speed(), ImageIO.read(new File(arr[path])));
			
		
		
		
		
	}
	public static void main(String[] args) throws IOException
	{
		FILEIO newfile = new FILEIO();
	}
	
}
