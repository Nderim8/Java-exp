package seminari10;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


import javax.swing.JComponent;
import javax.swing.JFrame;



public class Trekendesh extends JComponent
{
	private  int clicks;
	private Point2D.Double[] points;
	private final int maxNumber = 3;
	
	
	
	public Trekendesh()
	{
		clicks = 0 ;
		points = new Point2D.Double[maxNumber];
		
	}
	
	
	public Trekendesh(int aClick, Point2D.Double[] aPoint)
	{
		clicks = aClick;
		points = aPoint;
		addMouseListener(new MouseHandler());
		
	}	
	
		
		public void paintComponent(Graphics g)             ///// drawing
		{
			Graphics2D g2 = (Graphics2D) g;
			
		
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
				/*
				double x = points[0].getX();
				double y = points[0].getY();
				final double RREZE = 20;
				
			//	Ellipse2D.Double rrethi = new Ellipse2D.Double(x - RREZE, y - RREZE , 2 * RREZE , 2 * RREZE);
			//	g2.draw(rrethi);  */
				
				g2.draw(new Line2D.Double(points[0], points[1] ) );
				
			}
			else if(clicks == 3)
			{
				/*
				double x = points[0].getX();
				double y = points[0].getY();
				final double RREZE = 20;
				
			//	Ellipse2D.Double rrethi = new Ellipse2D.Double(x - RREZE, y - RREZE , 2 * RREZE , 2 * RREZE);
			//	g2.draw(rrethi);  */
				
				g2.draw(new Line2D.Double(points[0], points[1] ) );
				g2.draw(new Line2D.Double(points[1], points[2] ) );
				g2.draw(new Line2D.Double(points[0], points[2] ) );
				
			}
	
		}	
		  /*
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				Trekendesh t = new Trekendesh(clicks, points);
				t.drawing(g2);
			}	
		*/
		
		public static void main(String[] args)
		{
			
			Point2D.Double[] pika1 = new Point2D.Double[3];   /////// 2
			
			Trekendesh object = new Trekendesh(0, pika1);
				
		    JFrame frame = new JFrame();
		
			frame.add(object);
			frame.setSize(640, 480);
			frame.setTitle("Trekendesh");
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		 
			
		}
	
		 class	MouseHandler implements MouseListener
		  {

			@Override
			public void mouseClicked(MouseEvent e) {
				
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
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }
			
	

}
