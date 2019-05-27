package provimi10;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class ushtrimi2 extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Line2D.Double viza1 = new Line2D.Double(100,100,200,100);
		Line2D.Double viza2 = new Line2D.Double(150,100,150,200);
		
		g2.draw(viza1);
		g2.draw(viza2);
		
		
	}
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		
		frame.setSize(300, 300);
		frame.setTitle("Shkronja T");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		ushtrimi2 test = new ushtrimi2();
		frame.add(test);
		frame.setVisible(true);
		
	}

}
