package nderfaqja_perdorusit2;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ushtrimi2 extends JComponent
{
	private int number;
	private int xPoz;
	private int yPoz;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private int rectWidth;
	private int rectHeight;

	
	public Ushtrimi2()
	{

		Random rand = new Random();
		
		number = 1 + rand.nextInt(10);

		setLayout(new BorderLayout());
		JButton button1 = new JButton("Double");
		JButton button2 = new JButton("Half");
		
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				number = 2 * number;
				
			  	repaint();
			}
			
		});
		
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(number != 1)
				number = number/2;
				
			  	repaint();
			}
			
		});
		
		JPanel panel = new JPanel();
		
		panel.add(button1);
		panel.add(button2);
		add(panel, BorderLayout.SOUTH);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < number; i++)
		{
			Random rand = new Random();
			rectWidth = 1 + rand.nextInt(100);
			rectHeight = 1 + rand.nextInt(100);
		xPoz = rand.nextInt(WIDTH - rectWidth - 16);
		yPoz = rand.nextInt(HEIGHT - rectHeight - 20 - 20 - 35);// 20 for the upper panel, 20 for down p
		
		Rectangle rect = new Rectangle(xPoz, yPoz, rectWidth, rectHeight );
		
		   g2.draw(rect);

		}
	}	
	
	public static void main(String[]args)
	{
       
		Ushtrimi2 test = new Ushtrimi2();
		
		JFrame frame = new JFrame();
		frame.setTitle("Rectangles");
		frame.setSize(WIDTH, HEIGHT);
		frame.add(test);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
	}

}



