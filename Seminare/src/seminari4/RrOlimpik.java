package seminari4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class RrOlimpik extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g; 
		
		Ellipse2D.Double rrethi1 = new Ellipse2D.Double(50,50,100,100);
		Ellipse2D.Double rrethi1p = new Ellipse2D.Double(60,60,80,80);
		
		
		Ellipse2D.Double rrethi2= new Ellipse2D.Double(150,50,100,100);
		Ellipse2D.Double rrethi2p = new Ellipse2D.Double(160,60,80,80);
		
		
		Ellipse2D.Double rrethi3 = new Ellipse2D.Double(250,50,100,100);
		Ellipse2D.Double rrethi3p = new Ellipse2D.Double(260,60,80,80);
		
		
		Ellipse2D.Double rrethi4= new Ellipse2D.Double(100,100,100,100);
		Ellipse2D.Double rrethi4p = new Ellipse2D.Double(110,110,80,80);
		
		
		Ellipse2D.Double rrethi5 = new Ellipse2D.Double(200,100,100,100);
		Ellipse2D.Double rrethi5p = new Ellipse2D.Double(210,110,80,80);
		
		
		
		g2.setColor(Color.blue);
		g2.draw(rrethi1);
		g2.fill(rrethi1);
		g2.draw(rrethi1p);
		g2.setColor(Color.white);
		g2.fill(rrethi1p);
		
		g2.setColor(Color.black);
		g2.draw(rrethi2);
		g2.fill(rrethi2);
		g2.draw(rrethi2p);
		g2.setColor(Color.white);
		g2.fill(rrethi2p);
		
		
		
		g2.setColor(Color.red);
		g2.draw(rrethi3);
		g2.fill(rrethi3);
		g2.draw(rrethi3p);
		g2.setColor(Color.white);
		g2.fill(rrethi3p);
		
		
		g2.setColor(Color.yellow);
		g2.draw(rrethi4);
		g2.fill(rrethi4);
		g2.draw(rrethi4p);
		g2.setColor(Color.white);
		g2.fill(rrethi4p);
		
		
		
		g2.setColor(Color.green);
		g2.draw(rrethi5);
		g2.fill(rrethi5);
		g2.draw(rrethi5p);
		g2.setColor(Color.white);
		g2.fill(rrethi5p);
		
		
	}
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		
		frame.setSize(400, 350);
		frame.setTitle("Rrathet Olimpik");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		RrOlimpik rrathet = new RrOlimpik();
		frame.add(rrathet);
	
		frame.setVisible(true);
		
	}
	

}
