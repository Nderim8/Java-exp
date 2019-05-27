package seminari10;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import seminari4.Car;

public class Components extends JComponent
{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Car> cars;
	
	public Components(ArrayList<Car> Cars)
	{
		cars = Cars;
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i = 0; i < cars.size(); i++)
		{
			cars.get(i).draw(g2);
			
		}
		
	}
	
	public void vizato(int x, int y, int size)
	{
		Car car = new Car(x / size, y / size , size);   /////// /size because of the build in Car class
		
		cars.add(car);
		
		repaint();
		
	}
	
	public static void main(String[] args)
	{
		ArrayList <Car> a = new ArrayList<Car>();
		
		Components components = new Components(a);
		
		class KeyHandler implements KeyListener
		{

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					System.out.println("Space Button");
					  for(int i = 0; i < cars.size(); i++) {
							
							cars.get(i).setCarX(cars.get(i).getCarX()+5);
							components.repaint();
						}
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					System.out.println("Space Button");
					  for(int i = 0; i < cars.size(); i++) {
							
							cars.get(i).setCarX(cars.get(i).getCarX()+5);
							components.repaint();
						}
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		}
		class MouseHandler implements MouseListener
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				;
				   if(SwingUtilities.isMiddleMouseButton(e))	{
					   System.out.println("Middle Button");
						int size = Integer.parseInt(JOptionPane.showInputDialog("Fut madhesine e vizatimit(psh: 1,2 etj) "));
						
						int x = e.getX();
						int y = e.getY();
						
						components.vizato(x, y, size);
					}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

                if(SwingUtilities.isRightMouseButton(e))
                {
					
					System.out.println("Right Button");
					  for(int i = 0; i < cars.size(); i++) {
							
							cars.get(i).setCarX(cars.get(i).getCarX()+10);
							components.repaint();
						}
					
				  }else  if(SwingUtilities.isLeftMouseButton(e))
	                {
						
						System.out.println("Left Button");
						  for(int i = 0; i < cars.size(); i++) {
								
								cars.get(i).setCarX(cars.get(i).getCarX()-10);
								components.repaint();
							}
						
					  }
			   
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

				
			}
			
			
		}
		
		JFrame frame = new JFrame();
		
		MouseHandler handler = new MouseHandler();
		KeyHandler keyHandler = new KeyHandler();
		
		components.addKeyListener(keyHandler);
		components.addMouseListener(handler);
		
		
		frame.add(components);
		frame.setTitle("Components");
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		
	}
	
	
	

}




