package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class MovingRectangle extends JPanel  implements ActionListener, KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5740880120271863284L;
	private final static int titlePanelSize = 20;
	private final static int WIDTH = 500 , HEIGHT = 520;	
	private int time = 0;	
	Timer timer = new Timer(5, this);
	
	// backgroundi
	private int x = 0;
	private int y = 0;


	
	// katroti1 i kuq
	private int x1 = 0;
	private int y1 = 0;
	private int width1 = 50;
	private int height1 = 50;
	private int velX1 = 6, velY1 = 6;

	// katroti2 jeshil
	private int width2 = 50;
	private int height2 = 50;
	private int x2 = WIDTH-width2;
	private int y2 = 0;
	private int velX2 = 6, velY2 = 6;
	
	// katroti3 blu
	private int width3 = 50;
	private int height3 = 50;
	private int x3 = 0;
	private int y3 = HEIGHT-height3-titlePanelSize;
	private int velX3 = 6, velY3 = 6;

	// katroti4 i verdhe
	private int width4 = 50;
	private int height4 = 50;
	private int x4 = WIDTH-width4;
	private int y4 = HEIGHT-height4-titlePanelSize;
	private int velX4 = 6, velY4 = 6;
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		// ngjyros backgroundin
		g.setColor(Color.black);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
		g.setColor(Color.red);
		g.fillRect(x1, y1, width1, height1);
		g.setColor(Color.green);
		g.fillRect(x2, y2, width2, height2);
		g.setColor(Color.blue);
		g.fillRect(x3, y3, width3, height3);
		g.setColor(Color.yellow);
		g.fillRect(x4, y4, width4, height4);
		
		  timer.start();
	//	   timer.stop();
		  
		  this.addKeyListener(this);
		  
		   g.setColor(Color.white);
		g.drawString("Timer : " + time , WIDTH/2 - 40, 10);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		String [] filters = {"Filter1", "Filter2", "Filter3"};
		  JComboBox cBox = new JComboBox(filters);
		  cBox.setSelectedIndex(0);
		
		
	//	ArrayList<String> filterNames = new ArrayList<>(Arrays.as
		
	 if(timer.isRunning())
	 {
		repaint();
		time++;
		
		// levizjet e katrorit1 te kuq
		if(x1 < 0 || x1 > WIDTH - width1 )  
		  velX1 = -velX1;
		
		    x1 = x1 + velX1;
		
		if(y1 < 0 || y1 > HEIGHT - height1 - titlePanelSize )  // 20 is the height of the north title panel
			  velY1 = -velY1;
		
			y1 = y1 + velY1;
			
			// levizjet e katrorit2 jeshil
			if(x2 < 0 || x2 > WIDTH - width2 )  
				  velX2 = -velX2;
				
				    x2 = x2 + velX2;
				
				if(y2 < 0 || y2 > HEIGHT - height2 - titlePanelSize )  // 20 is the height of the north title panel
					  velY2 = -velY2;
				
					y2 = y2 + velY2;
					
					// levizjet e katrorit3 blu
					if(x3 < 0 || x3 > WIDTH - width3 )  
					  velX3 = -velX3;
					
					    x3 = x3 + velX3;
					
					if(y3 < 0 || y3 > HEIGHT - height3 - titlePanelSize )  // 20 is the height of the north title panel
						  velY3 = -velY3;
					
						y3 = y3 + velY3;
						
						// levizjet e katrorit4 te verdhe
						if(x4 < 0 || x4 > WIDTH - width4 )  
							  velX4 = -velX4;
							
							    x4 = x4 + velX4;
							
							if(y4 < 0 || y4 > HEIGHT - height4 - titlePanelSize )  // 20 is the height of the north title panel
								  velY4 = -velY4;
							
								y4 = y4 + velY4;
		
		}// end if timer.isRunning
		
	}
	
	public static void main(String[]args)
	{
		MovingRectangle rect1 = new MovingRectangle();
	
		JFrame frame = new JFrame();
		frame.setTitle("Moving Rectangle");
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(rect1);

		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("running11111");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		  System.out.println("running11111");
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(timer.isRunning())
			{
		     timer.stop();
		     System.out.println("running");
			}else {
				timer.start();
				System.out.println("running");
			}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("running11111");
	}



}



