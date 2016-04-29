import java.applet.Applet;
import java.awt.*;

public class Animation1 extends Applet
{
	public void init(Graphics page)
	{
		setBackground(Color.white);
		setSize (800, 500);
	}
	public void paint(Graphics page)
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("H://Backup//Workspace APCS//Final Project//src//classroom.png");
		page.clearRect(0,0, img.getWidth(null), img.getHeight(null));
		page.drawImage(img, 0, 0, null);
	}
	
	
}
