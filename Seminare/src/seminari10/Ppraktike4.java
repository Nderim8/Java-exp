package seminari10;


import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import seminari4.Car;


public class Ppraktike4  extends JComponent    
{
    
 public Car car;
 public int x;
 public int y;
 public int size;
  
  
  public Ppraktike4()
  {
	  x = 0;
	  y = 0;
	  size = 1;
	  
	car = new Car(x, y, size);
	  
  }
  
  
  public void paintComponent(Graphics g)
  { 
     Graphics2D g2 = (Graphics2D) g;
    
     car.draw(g2);
 
  }

  public void vizato(int x, int y, int size)
	{
		car = new Car(x / size, y / size, size);
		
		repaint();                                 
	}
	
  
	public static void main(String[] args)
	{
		  
		Ppraktike4 ppraktike4 = new Ppraktike4();
		 
	
	 
 class MouseHandler implements MouseListener
 {
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	
		 int size1 = Integer.parseInt(JOptionPane.showInputDialog("Fut madhesine (psh: 1, 2 etj): ") );
		 
       	 int x1 = e.getX();
	     int y1 = e.getY();
		 
		 ppraktike4.vizato(x1,  y1, size1);
		
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
 
	
	  JFrame frame = new JFrame();
	 
	  MouseHandler handler = new MouseHandler();	
	  
	    ppraktike4.addMouseListener( handler );
		frame.add(ppraktike4);   
		
		frame.setTitle("Makina");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
	
	
	
	}
	


}




