package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameState.GameStateManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener
{
	
	//dimensions
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 3;  // (final size : 640 by 480)standard size --  2 normal 
	
	//game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	//image
	private BufferedImage image;
	private Graphics2D g;
	
	//game state manager
	private GameStateManager gsm;
	
	// Constructor
	public GamePanel()
	{
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
		
	}

	
	public void addNotify()
	{
		super.addNotify();   // means that the JPanel is done loading
		                     // so we can create a new thread             
		if(thread == null)
		{
			thread = new Thread(this);
			// add the KeyListener before the new thread starts
			addKeyListener(this);
			thread.start();
		}
	}	
	
	private void init()    // initialize everything 
	{
		image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		
		gsm = new GameStateManager();
		
	}
	
	public void run()    // thread start will run(Runnable)
	{
		init();
		
		// before game loops we need 3 timers
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running)
		{
			// timestamp
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000; // since target time is in ms
		                                           // but elapsed is in ns
			if(wait < 0) wait = 5;             
			
			try 
			{
				Thread.sleep(wait);  // wait that amount of time
			}
			catch(Exception e)
			{
				e.printStackTrace();  // fix black screen problems
			}
			
		}
			
	}
	
        private void update()
        {
        	gsm.update();
        }
        private void draw()
        {
        	gsm.draw(g);
        }
		private void drawToScreen()
		{
			Graphics g2 = getGraphics();  // game panel s graphics object
			// WIDTH * SCALE  AND HEIGHT * SCALE, to fill the screen 
			g2.drawImage(image, 0, 0, WIDTH * SCALE , HEIGHT * SCALE, null);
			g2.dispose();
		}
        
        
		public void keyTyped (KeyEvent key){}
		public void keyPressed (KeyEvent key)
		{
			gsm.keyPressed(key.getKeyCode());  //instead of passing the keyEvent
		}                                    //we pass the keyCode,which is an int
		public void keyReleased (KeyEvent key)
		{
			gsm.keyReleased(key.getKeyCode());
		}
		
		
		

	
}
