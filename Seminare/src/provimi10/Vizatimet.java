package provimi10;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JApplet;


public class Vizatimet extends JApplet
{
	private  int clicks;
	private Point2D.Double[] points;
	private final int maxNumber = 3;
	
	public Vizatimet()
	{
		clicks = 0 ;
		points = new Point2D.Double[maxNumber];
		addMouseListener(new MouseHandler());
	}
	
	
	public Vizatimet(int aClick, Point2D.Double[] aPoint)
	{
		clicks = aClick;
		points = aPoint;
		
		addMouseListener(new MouseHandler());
		
	}	
	
	
	
		
		public void drawing(Graphics2D g2)
		{
			if(clicks == 1)
			{
				double x = points[0].getX();
				double y = points[0].getY();
				final double RREZE = 20;
				
				Ellipse2D.Double rrethi = new Ellipse2D.Double(x - RREZE, y - RREZE , 2 * RREZE , 2 * RREZE);
				g2.draw(rrethi);
				
			}
			else if(clicks == 2)
			{
				g2.draw(new Line2D.Double(points[0], points[1] ) );
				
			}
			else if(clicks == 3)
			{
				g2.draw(new Line2D.Double(points[0], points[1] ) );
				g2.draw(new Line2D.Double(points[1], points[2] ) );
				g2.draw(new Line2D.Double(points[0], points[2] ) );
				
			}
			
			
		}
		
		public void paint(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			Vizatimet t = new Vizatimet(clicks, points);
			t.drawing(g2);
		}	
		
	
	
		 class	MouseHandler implements MouseListener
		  {

			@Override
			public void mousePressed(MouseEvent e) {
				
				if(clicks >= maxNumber) return;

				int x = e.getX();
				int y = e.getY();
				
			    points[clicks] = new Point2D.Double(x,y);
				clicks++;
				
				repaint();
				
			
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }
			
	

}
