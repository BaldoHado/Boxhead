import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	private Image img; 	
	private AffineTransform tx;
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		update();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		update();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		
		img = getImage("Player-01.png"); 

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x,y); 	
		
		
	}
	
	public void setImage(String file) {
		Image image = getImage(file);  
		img = image;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(.05,.05);
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.05,.05);
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
}



