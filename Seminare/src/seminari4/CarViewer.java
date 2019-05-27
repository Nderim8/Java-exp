package seminari4;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;


 public class CarViewer extends JComponent 
 {

	 public void paintComponent(Graphics g)
	 { 
	 Graphics2D g2 = (Graphics2D) g;
	 Car car1 = new Car(0, 0, 2);
	 int x = getWidth() - 60;
	 int y = getHeight() - 30 ; 
	 Car car2 = new Car(x, y, 1);
	 Car car3 = new Car(50, 50, 3);

	 car1.draw(g2); 

	 car2.draw(g2); 

	 car3.draw(g2); 

	 }
	 
	 
    public static void main(String[] args)

   {

	  JFrame frame = new JFrame();
      frame.setSize(500, 500);

      frame.setTitle("Cars");

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CarViewer component = new CarViewer();
 
      // CarComponent component = new CarComponent();

      frame.add(component);

      frame.setVisible(true);

    }

 
 }
 
 
 