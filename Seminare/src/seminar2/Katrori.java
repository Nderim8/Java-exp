package seminar2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Katrori extends JComponent
{
	
public void paintComponent(Graphics g) 
    {
	Graphics2D g2 = (Graphics2D) g;
	Rectangle katrori = new Rectangle(100,100,50,50);
	
	g2.draw(katrori);
	g2.setColor(Color.red);
	g2.fill(katrori);
	g2.translate(50, 0);
	g2.draw(katrori);
	g2.setColor(Color.green);
	g2.fill(katrori);
	g2.translate(-50, 50);
	g2.draw(katrori);
	g2.setColor(Color.blue);
	g2.fill(katrori);
	g2.translate(50, 0);
	g2.draw(katrori);
	g2.setColor(Color.yellow);
	g2.fill(katrori);
		
	
	}
	
	public static void main (String[]args)
	{
		JFrame frame = new JFrame();
		frame.setTitle("katrori");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		JOptionPane.showMessageDialog(frame, "Click OK to continue");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		Katrori component = new Katrori();
        frame.add(component);
        frame.setVisible(true);
	
	}
	

}
