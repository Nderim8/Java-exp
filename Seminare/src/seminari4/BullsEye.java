package seminari4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class BullsEye extends JComponent
{
	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double rrethi0 = new Ellipse2D.Double(20, 20,380 ,380);
		g2.setColor(Color.black);
		g2.draw(rrethi0);
		g2.fill(rrethi0);
		
		
		Ellipse2D.Double rrethi = new Ellipse2D.Double(60, 60,300 ,300);
		g2.setColor(Color.white);
		g2.draw(rrethi);
		g2.fill(rrethi);
		
	/* Duhet t ket ndonji metod qe t jep per ndryshimin e 
	 gjatsise dhe gjersise sic esht metoda translate per x dhe y  */
		
		Ellipse2D.Double rrethi2 = new Ellipse2D.Double(100, 100,220 ,220);
		g2.setColor(Color.black);
		g2.draw(rrethi2);
		g2.fill(rrethi2);
		
		Ellipse2D.Double rrethi3 = new Ellipse2D.Double(140, 140,140 ,140);
		g2.setColor(Color.white);
		g2.draw(rrethi3);
		g2.fill(rrethi3);
		
		Ellipse2D.Double rrethi4 = new Ellipse2D.Double(180, 180,60 ,60);
		g2.setColor(Color.black);
		g2.draw(rrethi4);
		g2.fill(rrethi4); 
		
		
	}
	
	
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		
		frame.setSize(430,430);
		frame.setTitle("BullsEye");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    BullsEye component = new BullsEye();	
		frame.add(component);
		frame.setVisible(true);
		
	}
	
}
