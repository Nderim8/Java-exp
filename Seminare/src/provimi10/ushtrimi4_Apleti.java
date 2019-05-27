package provimi10;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JApplet;

public class ushtrimi4_Apleti extends JApplet
{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Random rand = new Random();
		
		
		
		int x =  rand.nextInt(getSize().width/2);
		int y =  rand.nextInt(getSize().height/2);
		 
 Rectangle drejtkendeshi = new Rectangle(getSize().width/2 -x/2, getSize().height/2 -y/2 , x, y);
		
		g2.draw(drejtkendeshi);
		
	}
	

}
