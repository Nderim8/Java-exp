package seminari6;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Ushtrimi11 extends JComponent
{
	
	
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D)g;
		 int x1 = 30; int y1 = 30; int x2 = 50; int y2 = 80;
	      Point2D.Double p = new Point2D.Double(40,50);
          Rectangle drejtkendeshi = new Rectangle( x1 , y1 , x2 , y2 );
          
          g2.draw(drejtkendeshi);
         
      /*   
			boolean xInside = false;

			if (x1 <= p.getX() && p.getX() <= x2) 

			 xInside = true;
			else
				xInside = false;

			boolean yInside = false; 

			if (y1 <= p.getY() && p.getY() <= y2)

			 yInside = true; 
			else
				yInside = false;


			if (xInside && yInside)    */
          
          if ( x1 <= p.getX() && p.getX() <= x2 && y1 <= p.getY() && p.getY() <= y2 ) 
          
		      g2.drawString("p ndodhet brenda drejtëkendeshit.", x1 , y1 - 4);
		    else 
				return;
          
         
          Rectangle r; 
          r = new Rectangle();
          if (r.equals(null))
        	  r = new Rectangle( 100, 100 , 40 ,30);
          else 
        	  r = new Rectangle( 140, 140 , 40 ,30);
          
          g2.draw(r);
          
          
          Line2D.Double l1 = new Line2D.Double( 200, 280, 250, 280 );
          Line2D.Double l2 = new Line2D.Double( 200, 280, 250, 280 );
          
          g2.draw(l1);
    	  g2.draw(l2); 
    	  
          if ( l1.getX1() == l2.getX1() && l1.getX2() == l2.getX2() 
        		  && l1.getY1() == l2.getY1() && l1.getY2() == l2.getY2())
        	  g2.drawString("Keto dy objekte paraqesin të njëjtën vijë.", 200 , 250 - 5 );
          else
        	  return;
		 
		}
		
		public static void main(String[]args)
		{
			JFrame frame = new JFrame();
			
			frame.setSize(600,600);
			frame.setTitle("Pika");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			Ushtrimi11 component;
			component= new Ushtrimi11();
			frame.add(component);
			frame.setVisible(true);
			
			
		}
 }


