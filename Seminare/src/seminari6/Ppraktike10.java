package seminari6;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Ppraktike10 extends JComponent
{

	private static final long serialVersionUID = 1L;
	private double X;
	private double Y;
	private double R;
	
	private double xPikes;
	private double yPikes;
	
	public Ppraktike10(double x , double y , double r, double xP, double yP)
	{
		X = x;
		Y = y;
		R = r;
		xPikes = xP;
		yPikes = yP;
	}
	public void  shtoPike()
	{
	
		
		//Math.sqrt( (x-xPikes) * (x-xPikes) + (y-yPikes) * (y-yPikes) ) <= r 
	  if( (Math.pow((X - xPikes) * (X - xPikes) + (Y - yPikes) * (Y - yPikes), 0.5)) < R ) 
		  System.out.println("Pika eshte brenda rrethit.");
	  else if ( (Math.pow((X - xPikes) * (X - xPikes) + (Y - yPikes) * (Y - yPikes), 0.5)) == R ) 
		  System.out.println("Pika eshte ne rreth.");
	   else
		  System.out.println("Pika eshte jashte rrethit");   
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double rrethi = new Ellipse2D.Double(X-R, Y-R, 2*R, 2*R);
		double rrezePikes = 1;
		Ellipse2D.Double pika = new Ellipse2D.Double(xPikes-rrezePikes, 
				yPikes-rrezePikes, 2*rrezePikes, 2*rrezePikes);
		
		g2.draw(rrethi);
		g2.draw(pika);
	}
	
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		
	System.out.println("Fut koordinatat e qendres se rrethit (x dhe y) dhe rrezen e tij:");
	double x = in.nextDouble();
	double y = in.nextDouble();
	double r = in.nextDouble();
	
	System.out.println("Fut koordinatat e pikes (x dhe y) : ");
	double xp = in.nextDouble();
	double yp = in.nextDouble();
	in.close();
	Ppraktike10 rrethi = new Ppraktike10(x, y, r, xp, yp);
	
		rrethi.shtoPike();
	
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.setTitle("Pika");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(rrethi);
		frame.setVisible(true);
		
	}
}
