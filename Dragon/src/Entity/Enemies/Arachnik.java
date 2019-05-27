package Entity.Enemies;


import java.awt.image.BufferedImage;
import java.awt.*;

import javax.imageio.ImageIO;

import Entity.Animation;
import Entity.Enemy;
import TileMap.TileMap;

public class Arachnik extends Enemy
{

	private Arachnik arachnik;
	private BufferedImage[] sprites;
	
	private double ytemp2; 
	private double yStart;
	private double yEnd; 
	
	
	public Arachnik(TileMap tm) 
	{
		super(tm);
		
		yStart = (double)this.gety() + (double)this.getYmap();
		ytemp2 = (double)this.gety() + (double)this.getYmap();
		yEnd = (double)this.gety() + (double)this.getYmap() + 100;
		
		
		moveSpeed = 0.5;
		maxSpeed = 0.5;
		fallSpeed = 0.3;
		maxFallSpeed = 8.0;
		
		// for the tilesheet (30 by 30 for a square frame at the arachnik image)
		width = 30;
		height = 30; 
	
		// the real width  and height of the slugger in the game
		cwidth = 20;
		cheight = 20; 
		
		health = maxHealth = 10;
		damage = 2; 
		
		
		
		
		// load sprites
				try
				{
					// read in the entire spritesheet
					BufferedImage spritesheet = ImageIO.read( 
							getClass().getResourceAsStream("/Sprites/Enemies/arachnik.gif") );
							
					 sprites = new BufferedImage[1];
					
					sprites[0] = spritesheet.getSubimage(0, 0, width, height);
						
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		
				
				// set the animation
				animation = new Animation();
				animation.setFrames(sprites);
				animation.setDelay(400);          
				
				down = true;
				
			     
	}
	
	private void getNextPosition()
	{
		
		// movement
		if(up)
    	{
    		dy -= moveSpeed;      // the vector has to go left minus speed acceleration
    		if(dy < -maxSpeed)          
    		{
    			dy = -maxSpeed;
    			
    		}
    		
    		ytemp2 = ytemp2 + dy;
    		
    	}	
    	
    	else if(down)
    		{
    			dy += moveSpeed;
    			if(dy > maxSpeed)
    			{
    				dy = maxSpeed;
    				
    			}
    		
    			ytemp2 = ytemp2 + dy;
    			
    		}
  
		
	}
	
	
	
	public void update()        // just like the player
	{
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		// check flinching
		if(flinching)
		{
		   long elapsed = (System.nanoTime() - flinchTimer) / 1000000; // in millisecs
			if(elapsed > 400)    //  delay = 400;  (immune for  sec) 
			{
				flinching = false;
			}
			
		}
	
	
	
	// if goes down at a point start going up
	if(down ) //when down and collided or reached at the lowest point 
	{
		if(dy == 0 || ytemp2 == yEnd)
		{	
			
			 dy = 0;
			
		  down = false;
		  up = true;            // change direction of arachanik from down to up
		}
	}
	else if(up)  // when up and reached the highest point
	{
		if(dy == 0)     // || ytemp2 == yStart(if i want to stop going up before collision)
		{		
		      up = false;    // change direction from up to down            
	          down = true; 
		}
	}  
	
	// update animation
	animation.update();
	
  }
	
	
	public void draw(Graphics2D g) 
	{
	
		setMapPosition();
		
		
		 if(flinching)
	      {
	    	  long elapsed = (System.nanoTime() - flinchTimer) / 1000000; // in milliseconds
	    	  if(elapsed / 100 % 2 == 0)   // if true dont draw the enemy just return
	    	  { return; }                  // this will give it the aparence of blinking 
	    	                               // every 100 milliseconds.
	     
	      }

			
			g.setColor(Color.white);
			
			int a = this.getx() + this.getXmap() ;  // x coordinate of arachnik
			 
			// draw line at arachnik coordinates
			g.drawLine( a , (int)yStart, a , (int)ytemp ); // (int)yStart + 30(if i want net to be on wall)
	
			
		super.draw(g);    // facing of objects from MapObject s draw function
	
	
		
		
	}
	
	
}





