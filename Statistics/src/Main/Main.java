package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;




public class Main implements ActionListener, KeyListener, MouseListener {

	public int ticks, yMotion, score;

	public boolean gameOver, started;
	private final int FPS = 60;
	private final int delay = 10000/FPS;
	public Random rand;
	public final static int WIDTH = 700, HEIGHT = 700;
	public static Main main;
	public static Rectangle rect1, rect2, rect3, rect4, rect5;
	public int rect1Width = 50, rect1Height = 100 , rect1X = 100 , rect1Y = HEIGHT-rect1Height-80;
	public int rect2Width = 50, rect2Height = 100 , rect2X = rect1X+rect1Width , rect2Y = HEIGHT-rect2Height-80;
	public int rect3Width = 50, rect3Height = 100 , rect3X = rect2X+rect2Width , rect3Y = HEIGHT-rect3Height-80;
	public int rect4Width = 50, rect4Height = 100 , rect4X = rect3X+rect4Width , rect4Y = HEIGHT-rect4Height-80;
	public int rect5Width = 50, rect5Height = 100 , rect5X = rect4X+rect4Width , rect5Y = HEIGHT-rect5Height-80;
	public int rect6Width = 50, rect6Height = 100 , rect6X = rect5X+rect5Width , rect6Y = HEIGHT-rect6Height-80;
	public int rect7Width = 50, rect7Height = 100 , rect7X = rect6X+rect6Width , rect7Y = HEIGHT-rect7Height-80;
	public int rect8Width = 50, rect8Height = 100 , rect8X = rect7X+rect7Width , rect8Y = HEIGHT-rect8Height-80;
	public int rect9Width = 50, rect9Height = 100 , rect9X = rect8X+rect8Width , rect9Y = HEIGHT-rect9Height-80;
	public int rect10Width = 50, rect10Height = 100 , rect10X = rect9X+rect9Width , rect10Y = HEIGHT-rect10Height-80;
	public Timer timer = new Timer(delay,this);
	public Renderer renderer;
	
	public Main() {
		 
//		rect1 = new Rectangle(rect1X, rect1Y, rect1Width, rect1Height);
//		rect1 = new Rectangle(rect2X, rect2Y, rect2Width, rect2Height);
//		rect1 = new Rectangle(rect3X, rect3Y, rect3Width, rect3Height);
//		rect1 = new Rectangle(rect4X, rect4Y, rect4Width, rect4Height);
//		rect1 = new Rectangle(rect5X, rect5Y, rect5Width, rect5Height);
		
		    JFrame jframe = new JFrame();
		  	JButton start = new JButton("Start");
		  	JButton stop = new JButton("Stop");
		  	
		  	renderer = new Renderer();
		  	rand = new Random();
		  	
		
			
	
			 start.setBounds(650, 400, 50, 50);
			 stop.setBounds(650, 500, 50, 50);
			 start.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						timer.start();
					} 

					@Override
					public void mouseEntered(MouseEvent arg0) {
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {

					}

					@Override
					public void mousePressed(MouseEvent arg0) {
			
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {

					}
					 
				 });
			 
			 stop.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						timer.stop();
					} 

					@Override
					public void mouseEntered(MouseEvent arg0) {
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {

					}

					@Override
					public void mousePressed(MouseEvent arg0) {
			
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {

					}
					 
				 });
					
			 JPanel panel1 = new JPanel();
			 JPanel panel2 = new JPanel();
			 panel1.add(start);
			 panel2.add(stop);
			 panel1.setBounds(605, 500, 100, 200);
			 panel2.setBounds(605, 580, 100, 200);
	//		 jframe.add(panel1);
	//		 jframe.add(panel2);
		  	jframe.add(renderer);
		  	jframe.addKeyListener(this);
		  	jframe.addMouseListener(this);
		  	
		  	jframe.setTitle("Statistics!");
		  	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  	jframe.setSize(WIDTH,HEIGHT);
//		  	jframe.addMouseListener(this);
//		  	jframe.addKeyListener(this);
		  	jframe.setResizable(false);
		  	jframe.setVisible(true);
		  	
		
		  //	timer.start();
	}
	
	public static void main(String args[]) {
		main =  new Main();
	}

	public void repaint(Graphics g) 
	{
		
		
		g.setColor(Color.cyan);
		g.fillRect(rect1X, rect1Y, rect1Width, rect1Height);
		g.setColor(Color.yellow);
		g.fillRect(rect2X, rect2Y, rect2Width, rect2Height);
		g.setColor(Color.red);
		g.fillRect(rect3X, rect3Y, rect3Width, rect3Height);
		g.setColor(Color.blue);
		g.fillRect(rect4X, rect4Y, rect4Width, rect4Height);
		g.setColor(Color.green);
		g.fillRect(rect5X, rect5Y, rect5Width, rect5Height);
		g.setColor(Color.gray);
		g.fillRect(rect6X, rect6Y, rect6Width, rect6Height);
		g.setColor(Color.black);
		g.fillRect(rect7X, rect7Y, rect7Width, rect7Height);
		g.setColor(Color.magenta);
		g.fillRect(rect8X, rect8Y, rect8Width, rect8Height);
		g.setColor(Color.orange);
		g.fillRect(rect9X, rect9Y, rect9Width, rect9Height);
		g.setColor(Color.pink);
		g.fillRect(rect10X, rect10Y, rect10Width, rect10Height);
		
		g.setColor(Color.black);
		g.drawLine(100, 0, 100, HEIGHT-80);
		g.setColor(Color.black);
		g.drawLine(100, HEIGHT-80, WIDTH, HEIGHT-80);
		
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.setColor(Color.white);
		g.drawString("A" , rect1X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("B" , rect2X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("C" , rect3X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("D" , rect4X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("E" , rect5X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("F" , rect6X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("G" , rect7X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("H" , rect8X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("I" , rect9X+20, HEIGHT-100);
		g.setColor(Color.white);
		g.drawString("J" , rect10X+20, HEIGHT-100);
		
		g.setFont(new Font("Arial", Font.PLAIN, 50));
		g.setColor(Color.black);
		for(int i = 0; i < 10; i++) {
			g.drawString(""+(i*100), 10, HEIGHT- 80 - (i*80));
		}

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Random rand = new Random();
		
		rect1Height= rand.nextInt(700);
		rect1Y = HEIGHT-rect1Height - 80;
		rect2Height= rand.nextInt(700); 
		rect2Y = HEIGHT-rect2Height - 80; 
		rect3Height= rand.nextInt(700);
		rect3Y = HEIGHT-rect3Height - 80; 
		rect4Height= rand.nextInt(700);
		rect4Y = HEIGHT-rect4Height - 80; 
		rect5Height= rand.nextInt(700);
		rect5Y = HEIGHT-rect5Height - 80; 
		rect6Height= rand.nextInt(700);
		rect6Y = HEIGHT-rect6Height - 80;
		rect7Height= rand.nextInt(700);
		rect7Y = HEIGHT-rect7Height - 80;;
		rect8Height= rand.nextInt(700);
		rect8Y = HEIGHT-rect8Height - 80;
		rect9Height= rand.nextInt(700);
		rect9Y = HEIGHT-rect9Height - 80;
		rect10Height= rand.nextInt(700);
		rect10Y = HEIGHT-rect10Height - 80;
		
		renderer.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		timer.start();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		timer.stop();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
