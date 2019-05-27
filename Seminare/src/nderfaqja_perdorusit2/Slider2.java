package nderfaqja_perdorusit2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class Slider2 extends JComponent
{
	private int sasia;
	private int xPoz;
	private int yPoz;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private int rectWidth ;
	private int rectHeight ;
	
	
	private JSlider sasiaSlider;
	
	public Slider2()
	{  	
		
		setLayout(new BorderLayout());
		
		createControlPanel();
	}
	
	public void createControlPanel()
	{
		class ColorListener implements ChangeListener 
		{
			public void stateChanged(ChangeEvent event)
			{
				setSampleColor();
				repaint();
			}
			
			
		}
		
		ChangeListener listener = new ColorListener();
		
		sasiaSlider = new JSlider(0,100);
		sasiaSlider.addChangeListener(listener);
		
		JPanel controlPanel = new JPanel();
		
		
		controlPanel.add(new JLabel ("Sasia"));
		controlPanel.add(sasiaSlider);
				
		
		add(controlPanel, BorderLayout.SOUTH);
	}
		
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < this.sasia; i++)
		{
			Random rand = new Random();
			rectWidth = 10 + rand.nextInt(100);
			rectHeight = 10 + rand.nextInt(100);
		xPoz = rand.nextInt(WIDTH - rectWidth - 16);
		yPoz = rand.nextInt(HEIGHT - rectHeight - 20 - 20 - 35);// 20 for the upper panel, 20 for down p
		
		Rectangle rect = new Rectangle(xPoz, yPoz, rectWidth, rectHeight );
		
		Random random = new Random();
		int randomColor = random.nextInt(10);
		if(randomColor == 0) {
			g2.setColor(Color.blue);
		}else if(randomColor == 1) {
			g2.setColor(Color.red);
		}else if(randomColor == 2) {
			g2.setColor(Color.green);
		}else if(randomColor == 3) {
			g2.setColor(Color.yellow);
		}else if(randomColor == 4) {
			g2.setColor(Color.orange);
		}else if(randomColor == 5) {
			g2.setColor(Color.cyan);
		}else if(randomColor == 6) {
			g2.setColor(Color.black);
		}else if(randomColor == 7) {
			g2.setColor(Color.magenta);
		}else if(randomColor == 8) {
			g2.setColor(Color.PINK);
		}else if(randomColor == 9) {
			g2.setColor(Color.gray);
		}
		
		   g2.draw(rect);
	
		
		}
	}	
	
	public void setSampleColor()
	{
		this.sasia = sasiaSlider.getValue();
		
		
	}
	 
	public static void main(String[]args)
	{
       
		Slider2 test = new Slider2();
		
		JFrame frame = new JFrame();
		frame.setTitle("Rectangles");
		frame.setSize(WIDTH, HEIGHT);
		frame.add(test);
		frame.setResizable(false);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
	}

}

