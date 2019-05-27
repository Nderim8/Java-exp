package Entity.Enemies;

import Entity.*;
import TileMap.TileMap;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class Slugger extends Enemy
{
	// the array of BufferedImages to hold the sprites
	private BufferedImage[] sprites; 
	
	
    // constructer
	public Slugger(TileMap tm)        // just pass along the constructers
	{
		super (tm);
		
		moveSpeed = 0.3;
		maxSpeed = 0.3;
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
		
		// for the tilesheet (30 by 30 for a square frame at the slugger image)
		width = 30;
		height = 30; 
		
		// the real width  and height of the slugger in the game
		cwidth = 20;
		cheight = 20; 
		
		health = maxHealth = 2;
		damage = 1; 
		
		// load sprites
		try
		{
			// read in the entire spritesheet
			BufferedImage spritesheet = ImageIO.read( 
					getClass().getResourceAsStream("/Sprites/Enemies/slugger.gif") );
					
			sprites = new BufferedImage[3];
			for(int i = 0; i < sprites.length; i++)
			{
				sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// set the animation
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(300);           // since its slow
		
		right = true;        // variable right is at MapObject class but since enemy 
		                     // extends MapObject and Slugger extends Enemy we can use		
	                         // MapObject s variables. 
	
	    // since we are starting right
		facingRight = true;
		
	}
	
	private void getNextPosition()
	{
		// movement
    	if(left)
    	{
    		dx -= moveSpeed;      // the vector has to go left minus speed acceleration
    		if(dx < -maxSpeed)    // we cant go pas the maxSpeed, 
    		{
    			dx = -maxSpeed;
    		}
    	}	
    	
    	else if(right)
    		{
    			dx += moveSpeed;
    			if(dx > maxSpeed)
    			{
    				dx = maxSpeed;
    				
    			}
    		
    		}
    	
    	// falling
    	if(falling)
    	{
    		dy += fallSpeed;
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
			if(elapsed > 400)
			{
				flinching = false;
			}
			
		}
		
		// if it hits a wall, go other direction
		if(right && dx == 0) //anytime smthing hits a wall, dx goes to 0 automatically
		{
			right = false;             // change direction of slugger
			left = true;               // from right to left
            facingRight = false;       // -> flips the sprite from right to left
			
		}
		else if(left && dx == 0)
		{
			right = true;              // change direction of slugger
			left = false;              // from left to right
		    facingRight = true;        // -> flips the sprite from left to right
		    
		}  
		
		// update animation
		animation.update();
		
	}
	
	public void draw(Graphics2D g) 
	{
		// not very necessary(not working properly)
	//	if(notOnScreen()) return;
		
		setMapPosition();
		
		super.draw(g);    // facing of objects from MapObject s draw function
		
	}
	
	
}


