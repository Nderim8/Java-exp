package flappyBird;

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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;



public class FlappyBird implements ActionListener, MouseListener, KeyListener
{
	 //  protected Animation animation;
	// protected int currentAction;
	public Rectangle bird;
	
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {2, 8, 1, 2, 4, 2, 5}; // IDLE = 2frames, WALKING=8,etc. 
	// animation actions                                // (gliding has 4 frames in image but i only need the first)
		private static final int IDLE = 0;
		private static final int WALKING = 1;
		private static final int JUMPING = 2;
		private static final int FALLING = 3;
		private static final int GLIDING = 4;
		private static final int FIREBALL = 5;
		private static final int SCRATCHING = 6;
		
		private BufferedImage[] bird1;
	    
		private int width1;
		private int height1;

	public static FlappyBird flappyBird;

	public final int WIDTH = 1000, HEIGHT = 700;
	
	// private int x;
	// private int y;

	public Renderer renderer;

	public ArrayList<Rectangle> columns;

	public int ticks, yMotion, score;

	public boolean gameOver, started;

	public Random rand;
	

	public FlappyBird()
	{
		
	   width1 = 30;
	   height1 = 30;
	   
	   //load sprites
		  try
		  {   // get the spritesheet (to read resources need to use getClass.getRAsStream)
			  BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream(
					  "/playersprites.gif"));    //// 
			  
			// the sprites
			  sprites = new ArrayList<BufferedImage[]>();
			  
			  // extracting each animation action (from the arrayList)
			  for(int i = 0; i < 7; i++)  // since we have 7 animation actions.
			  {
				 BufferedImage[] bi = new BufferedImage[numFrames[i]];
			     for(int j = 0; j < numFrames[i]; j++)
				 {
			    	 
				   if(i != SCRATCHING) // 6 first sprites have a width of 30 , last one has width=60
				   {
					 bi[j] = spritesheet.getSubimage(j * width1, i * height1, width1, height1);
			       }
				   else   // double the width.
				  {
				   bi[j] = spritesheet.getSubimage(j * width1 * 2, i * height1, width1*2, height1);
				  }
					  
				 }
			  
			     sprites.add(bi);
			     
			  }
		  } 
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		
		/*  
		  animation = new Animation();
		  currentAction = GLIDING;
		  animation.setFrames(sprites.get(GLIDING));
		  animation.setDelay(-1); // 400                        */
		  
	      bird1 = sprites.get(FALLING);  //////////////
	  
	   
	      JFrame jframe = new JFrame();
	  	Timer timer = new Timer(20,this);
	  	
	  	renderer=new Renderer();
	  	rand = new Random();
	  	
	  	jframe.add(renderer);
	  	jframe.setTitle("My Flappy Bird");
	  	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	jframe.setSize(WIDTH,HEIGHT);
	  	jframe.addMouseListener(this);
	  	jframe.addKeyListener(this);
	  	jframe.setResizable(false);
	  	jframe.setVisible(true);
	  	
	    bird = new Rectangle(WIDTH/2 - 10,HEIGHT/2-10, 20, 20);
	  	columns =new ArrayList<Rectangle>();
	  	
	  	addColumn(true);
	  	addColumn(true);
	  	addColumn(true);
	  	addColumn(true);
	  	
	  	timer.start();
		
	}
	
	
	public void addColumn(boolean start)
	{
		int space=300;
		int width=100;
		int height= 50 + rand.nextInt(300);
		
		if(start){
		columns.add(new Rectangle(WIDTH + width + columns.size()*300,HEIGHT-height-120,width,height));
		columns.add(new Rectangle(WIDTH + width +(columns.size()-1)*300,0,width,HEIGHT-height-space));
		}
		else
		{
			columns.add(new Rectangle(columns.get(columns.size()-1).x + 600,HEIGHT-height-120,width,height));
			columns.add(new Rectangle(columns.get(columns.size()-1).x,0,width,HEIGHT-height-space));
		}
		}

	public void paintColumn(Graphics g , Rectangle column)
	{
		g.setColor(Color.black);
		g.fillRect(column.x, column.y, column.width, column.height);
	}
	public void jump()
	{
	if(gameOver)
	{
		bird =new Rectangle(WIDTH/2 -10,HEIGHT/2-10, 20, 20);
		columns.clear();
		yMotion = 0;
		score = 0;
		
		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);
		
		gameOver = false;
	}
	if(!started)
	{
	started = true;	
	}
	else if (!gameOver)
	{
	  if(yMotion > 0)
	  {
	   yMotion = 0;	
	  }	
	  yMotion -= 12;
	}
	}

	public void actionPerformed(ActionEvent e) 
	{
		int speed = 10;
		ticks++;
		
		if(started)
		{

		for(int i=0;i<columns.size();i++)
		{
			Rectangle column = columns.get(i);
			column.x -= speed;
		}
		
		if(ticks %2 ==0 && yMotion < 15)
		{
			yMotion += 2;
		}
		
		for(int i=0;i < columns.size();i++)
		{
			Rectangle column = columns.get(i);
		if(column.x + column.width<0)
		{
		columns.remove(column);
		if(column.y == 0)
		{
			addColumn(false);
		}
		}
		}
	     bird.y +=yMotion;
		
		for(Rectangle column : columns)
		{
			if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 10 && bird.x + bird.width / 2 < column.x + column.width / 2 + 10)
			{
				score++;
			}
			
			if(column.intersects(bird))
			{
				gameOver = true;
				bird.x = column.x - bird.width;
			}
		}
		if(bird.y > HEIGHT-120 || bird.y < 0)
		{
			gameOver = true;
			
		}
		if(bird.y + yMotion >= HEIGHT-120)
		{
			bird.y = HEIGHT-120 -bird.height;
			gameOver = true;
		}
		
		}
		renderer.repaint();
		
	}

		
	public void repaint(Graphics g) 
	{
		g.setColor(Color.cyan);
		g.fillRect(0, 0,WIDTH, HEIGHT);
		
		g.setColor(Color.gray);
		g.fillRect(0, HEIGHT-120, WIDTH, 120);
		
		g.setColor(Color.green);
		g.fillRect(0, HEIGHT-120, WIDTH, 20);
		
		g.setColor(Color.black);
	//	g.fillRect(bird.x, bird.y, bird.width, bird.height);
		g.drawImage(bird1[0], bird.x, bird.y, null);  ////////////////
		
		for(Rectangle column:columns)
		{
			paintColumn(g,column);
		}
		g.setColor(Color.white);
		g.setFont(new Font("Arial",1,100));
		
		if(!started)
		{
			g.drawString("Start!", WIDTH/2-100, HEIGHT/2-50);
		}
		
		g.setColor(Color.red);
		g.setFont(new Font("Arial",1,100));
		if(gameOver)
		{
			g.drawString("Game Over!", WIDTH/2-200, HEIGHT/2-50);
		}
		
		if(!gameOver && started)
		{
			g.drawString(String.valueOf(score),WIDTH/2-20,100);
			
			g.setColor(Color.yellow);
			if(score == 5) g.drawString("Bravo", WIDTH/2 - 50, HEIGHT/2 - 50);
			if(score == 10) g.drawString("Vazhdo", WIDTH/2 - 50, HEIGHT/2 - 50);
		}
		
	}
		public static void main(String[]args)
		{
			
			flappyBird =new FlappyBird();
			
		}
		public void mouseClicked(MouseEvent e) {
			jump();
		}
		public void mouseEntered(MouseEvent e) {
			
		}
		public void mouseExited(MouseEvent e) {
			
			
		}
		public void mousePressed(MouseEvent e) {
			
			
		}
		public void mouseReleased(MouseEvent e) {
			
			
		}
		public void keyPressed(KeyEvent e) {
			
			
		}
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
			{
			jump();
			}
		}
		public void keyTyped(KeyEvent e) {
			
			
		}
}