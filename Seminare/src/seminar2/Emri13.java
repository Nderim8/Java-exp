package seminar2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Emri13 extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Rectangle box = new Rectangle(10,20,200,100);
		g2.setColor(Color.red);
		g2.draw(box);
		g2.fill(box);
		g2.setColor(Color.blue);
		g2.drawString("Nderimi", 80, 70);
		
		
	}
	
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		
		frame.setTitle("emri");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Emri13 component = new Emri13();
		frame.add(component);
		frame.setVisible(true);
		
	}
	

}
