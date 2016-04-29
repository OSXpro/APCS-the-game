import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class JframeTest extends JPanel {
	public JframeTest(){
		super();
		setBackground(Color.white);
	}
	public Dimension getPreferredSize() {
	    return new Dimension(800, 500);
	}
	public static void main(String[] args){
		JPanel panel = new JPanel();
	    JFrame frame = new JFrame("APCS the game");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(new JframeTest());
	    frame.setSize(800, 500);
	    frame.pack();
	    frame.setBackground(Color.white);
	    frame.setVisible(true);
	}
	protected void paintComponent(Graphics g) {
		setBackground(Color.white);
	    int width = getWidth();
	    int height = getHeight();
	    g.setColor(Color.black);
	    g.drawOval(0, 0, width, height);
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    try {
			g.drawImage(ImageIO.read(new File("H:/APCS/Game/src/Sprite.jpg")), 100, 100, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    repaint();
	  }
}
