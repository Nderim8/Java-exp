package seminari10;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Rrethat extends JComponent
{
	
	private ArrayList<Ellipse2D.Double> rrethat;
	
	public Rrethat(ArrayList<Ellipse2D.Double> rrethat1)
	{
		rrethat = rrethat1;
		
	}

	
	 public void paintComponent(Graphics g)
	 {
		 Graphics2D g2 = (Graphics2D) g;
		 
		 
		 for(int i = 0; i < rrethat.size(); i++)
		 {
			//   g2.setColor(Color.BLUE);
			 
		       g2.draw(rrethat.get(i));
		   //  g2.fill(rrethat.get(i));
		 
		 }
		 
		 
	 } 
	 
	 
	 public void vizato( double r1, double x, double y )
	 {
		 Ellipse2D.Double rrethi = new Ellipse2D.Double(x - r1, y - r1, 2 * r1, 2 * r1);  // ktu behen rregullimet e koordinatave
		 
		 rrethat.add(rrethi);
		 
		  repaint();
		 
	 }
	 
	 public static void main(String[] args)
	 {
		 ArrayList<Ellipse2D.Double> a = new ArrayList<Ellipse2D.Double>();
		 
		 Rrethat r = new Rrethat(a);
		 
		
		 class MouseHandler implements MouseListener
		 {
			 @Override
				public void mouseClicked(MouseEvent e) {
				 
					String rr1 = JOptionPane.showInputDialog( "Jep rrezen" );
					
				//	if(rr1.equals(null) ) return;
					
					double r1 = Double.parseDouble( rr1 );
					
					double x = e.getX();
					
					double y = e.getY();
					
					
				   r.vizato( r1, x, y);	
				
			    }
				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					
					
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					
					
				}
		 }
		  
		 MouseHandler handler = new MouseHandler();
		  JFrame frame = new JFrame();
			
			r.addMouseListener( handler );
			 
			frame.add(r);
			frame.setSize(640, 480);
			frame.setTitle("Rrethi");
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		 
	 }
	 
	 
	
	
}


