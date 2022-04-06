import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MenuKeyListener;

public class Driver extends JPanel implements KeyListener, ActionListener{

	private int shiftValsX;
	private int shiftValsY;
	private Player p1;
	private Map m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Driver d  = new Driver();
	}
	public void paint(Graphics g) {
		m.paint(g);
		
		p1.setY(p1.getY()+shiftValsY);
		p1.setX(p1.getX()+shiftValsX);
		p1.paint(g);
		
		
	
		//g.fillRect(rectX, rectY, 50, 50);
		System.out.println("refresh");
	}
	
	
	
	public Driver() {
		shiftValsX = 0;
		shiftValsY = 0;
		p1 = new Player(200,200);
		m = new Map();
		JFrame frame = new JFrame("Boxhead");
        frame.setSize(1500,1000);
        frame.add(this);
       
        //this part makes sure the x button closes the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
       
        t.start();
        //make the frame show up
        frame.setVisible(true);
	}
	
	Timer t = new Timer(8, this);
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.getKeyCode());
		if (arg0.getKeyCode() == 37 && inWall(p1.getX()-5,p1.getY()) == false) {
			System.out.println("left");
			
			p1.setImage("Player-01Left-01.png");
			shiftValsX = -5;
		}
		if (arg0.getKeyCode() == 38 && inWall(p1.getX(),p1.getY()-5) == false) {
			System.out.println("up");
			p1.setImage("Player-01Back-01.png");
			shiftValsY = -5;
		}
		if (arg0.getKeyCode() == 39 && inWall(p1.getX()+5,p1.getY()) == false) {
			System.out.println("right");
			p1.setImage("Player-01Right-01.png");
			shiftValsX = 5;
		}
		if (arg0.getKeyCode() == 40 && inWall(p1.getX(),p1.getY()+5) == false) {
			System.out.println("down");
			p1.setImage("Player-01.png");
			shiftValsY = 5;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == 37) {
			System.out.println("left");
			shiftValsX = 0;
		}
		if (arg0.getKeyCode() == 38) {
			System.out.println("up");
			shiftValsY = 0;
		}
		if (arg0.getKeyCode() == 39) {
			System.out.println("right");
			shiftValsX = 0;
		}
		if (arg0.getKeyCode() == 40) {
			System.out.println("down");
			shiftValsY = 0;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
	}
	
	public boolean inWall(int x, int y) { // needs work
		if (x <= 75 || x >= 1425 || y < 128 || y > 890) {
			return true;
		}
		
		return false;
	}

}



