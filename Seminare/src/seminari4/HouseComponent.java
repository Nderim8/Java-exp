package seminari4;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class HouseComponent extends JComponent
{
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		House house1 = new House(50,50,200,200);
		
		House house2 = new House(250,250,100,100);
		
		int x = getWidth() - 51;

		int y = getHeight() - 51 ; 
		
		House house3 = new House(x,y,50,50);
		
		house1.draw(g2);
		
		house2.draw(g2);
		
		house3.draw(g2);
		
		
		
	}

}
