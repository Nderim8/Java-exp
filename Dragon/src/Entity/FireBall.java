package Entity;

import TileMap.TileMap;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

// extends MapObject since MapOject is the base class for all game objects, and FireBall
public class FireBall extends MapObject                        // is a game object.
{
	private boolean hit;          // fireball has hit smthing
	private boolean remove;      // remove the fireball or not 
	private BufferedImage[] sprites;     // regular sprites
	private BufferedImage[] hitSprites;  // the animation that playes when it hits smth.
	
	
	// constructer
	public FireBall(TileMap tm,boolean right, boolean UP, boolean DOWN) //we need the TileMap all map object need
	{                                         // it , and we need the boolean called 
		  super(tm);                          // right to tell us witch direction
		                                      // the fireball is going(left or right)
	     
		  facingRight = right;     //  so that fireball can face both directions
		  up = UP;
		  down = DOWN;
		  
		  
		  moveSpeed = 3.8;
		  
	      if(right) 
	      {  
	    	  if(up)
	    	  {
	    		  dx = moveSpeed ;
	    		  dy = -moveSpeed + 1.8;  ////// speed of y coordinate of fireball is 1.8 less than x coordinate
	    	  }
	    	  else if(down)
	    	  {
	    		  dx = moveSpeed;
	    		  dy = moveSpeed - 1.8;  ///// y coordinate is different (positive) since its going down
	    		   
	    	  }
	    	  else 
	    	  dx = moveSpeed;
	     
	      }
	      
	      else     //   left
	      { 
	    	  if(up)
	    	  {	  
	    	    dx = -moveSpeed;                      // fireball going the other direction
	    	    dy = -moveSpeed + 1.8; 
	    	  }
	    	  else if(down)
	    	  {
	    		  dx = -moveSpeed ;
	    		  dy = moveSpeed - 1.8;  ///// y coordinate is different (positive) since its going down
	    		   
	    	  }
	    	  else
	    	  dx = -moveSpeed; 
	    	    
	      }
	      
	      width = 30;        // -| these are for the drawing
	      height = 30;       // -| and for importing the TileMap
	      
	      cwidth = 14;       // -| the real width and hight    
	      cheight = 14;      // -| 
	
	      // load sprites
	      try
	      {
	    	 BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream
	    			 ("/Sprites/Player/fireball.gif"));
	    	 
	    	 // getting the individual frames and put them in the 2 arrays
	    	 
	    	 // regular fireball sprites
	    	 sprites = new BufferedImage[4];    // because there are 4 frames 
	    	 for(int i = 0; i < sprites.length; i++)
	    	 {
	    		 sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
	    	 }
	    	 
	    	 // hit sprites
	    	 hitSprites = new BufferedImage[3];   // 3 frames 
	    	 for(int i = 0; i < hitSprites.length; i++)
	    	 {
	    		 hitSprites[i] = spritesheet.getSubimage(i * width, height, width, height);
	    	 }
	    	 
	    	 // animation stuff
	    	 animation = new Animation();
	    	 animation.setFrames(sprites);  
	    	 animation.setDelay(70);
	
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	       
	}
	
	// the funfction that gets called to figure out whether or not the fireball has hit smthing
    public void setHit() 
    {
    	if(hit) return;        // we dont want to keep reseting the frames and the delay
    	hit = true;
    	animation.setFrames(hitSprites);  //since enemy is hit  
    	animation.setDelay(70);           // one enemy can be hit again within 70 ms
    	dx = 0;
    	
    	dy = 0;   /// if not dy = 0; then the fireball s ashes go further because of y movement 
    
    } 
    
    public boolean shouldRemove() { return remove; } 
    
    public void update()   // we dont need super cuz its part of the MapObject base class
    {
    	checkTileMapCollision();      // do the same thing as player check the TileMap
    	setPosition(xtemp, ytemp);
    	
    	 
    	if((topLeft || topRight || bottomLeft || bottomRight) && !hit){  setHit(); }
    	
    	
    	if(( dx == 0 ) && !hit)    // to remove the fireball once it hits smthing
    	{                              // new mechanic if not include the dy == 0 condition ...
   		    		
    		setHit();       // if i want the firball to reflect at walls remove // check the ground 1 pixel up, at MapObject
    	}
    	

    	animation.update();
    	
    	// we need to check if we need to take the fireball out of game
    	if(hit && animation.hasPlayedOnce())
    	{
    		remove = true;
    		
    	}
    	
    }
    
    public void draw(Graphics2D g)
    {
    	// like the player , we set the MapPosition
    	setMapPosition();
    	
    	super.draw(g);     // facing of objects from MapObject s draw function
         
    	
    }
	
	
	
}



