package Entity;

import TileMap.*;
import Audio.AudioPlayer;

import java.util.ArrayList;
import javax.imageio.ImageIO;     // -> for reading in the spritesheets
import java.awt.*;
import java.awt.image.BufferedImage;  // for drawing buffered images
import java.util.HashMap;

// extends MapOject so it can inherit all of MapObject s stuff.
public class Player extends MapObject
{
	
	
	// player stuff
	private int health;
	private int maxHealth;
	private int fire;
	private int maxFire;
	private boolean dead;
	private boolean flinching;
	private long flinchTimer;
	
	// fireball
	private boolean firing;    // -> using it for keybord input.
	private int fireCost;
	private int fireBallDamage;
	private ArrayList<FireBall>fireBalls; // for the fireball animations
	
	// scratch
	private boolean scratching;  // for keybord input
	private int scratchDamage;
	private int scratchRange;
	
	// gliding
	private boolean gliding;
	
	// animations  (similar to the game state manager)
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {2, 8, 1, 2, 4, 2, 5}; // IDLE = 2frames, WALKING=8,etc.
	
	// animation actions
	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;
	private static final int FALLING = 3;
	private static final int GLIDING = 4;
	private static final int FIREBALL = 5;
	private static final int SCRATCHING = 6;
	
	// data storage with key/value pairs, in this case string is the key
	// audio is the value.
	private HashMap<String, AudioPlayer> sfx;
	
	// constructer
	public Player(TileMap tm) 
	{
		super(tm);     // calling the MapObject constructer with super
	                // all the MapObject constructer does is set the tileMap and tileSize
	
	  width = 30;
	  height = 30;
	  cwidth = 20;
	  cheight = 20;
	  
	  moveSpeed = 0.3;      //// 1    // 0.3
	  maxSpeed = 1.6;     /// 10      // 1.6
	  stopSpeed = 0.4;
	  fallSpeed = 0.15;
	  maxFallSpeed = 4.0;
	  jumpStart = -4.8;
	  stopJumpSpeed = 0.3;
	
	  facingRight = true;
	  
	  health = maxHealth = 10;
	  fire = maxFire = 2500;
	  
	  fireCost = 200;
	  fireBallDamage = 5;
	  fireBalls = new ArrayList<FireBall>();  // to store the fireballs
	  
	  scratchDamage = 8;
	  scratchRange = 40;
	  
	  //load sprites
	  try
	  {   // get the spritesheet (to read resources need to use getClass.getRAsStream)
		  BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream(
				  "/Sprites/Player/playersprites.gif"));
		  
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
				 bi[j] = spritesheet.getSubimage(j * width, i * height, width, height);
		       }
			   else   // double the width.
			  {
			  bi[j] = spritesheet.getSubimage(j * width * 2, i * height, width*2, height);
			  }
				  
			}
		     // add the buffered image array (bi) to the animation s list
		     sprites.add(bi);
			  
			  
		 }
		  
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  animation = new Animation();
	  currentAction = IDLE;
	  animation.setFrames(sprites.get(IDLE));
	  animation.setDelay(400);
	  
	  // set hashmap
	  sfx = new HashMap<String, AudioPlayer>();
	  // load stuff
	  sfx.put("jump", new AudioPlayer("/SFX/jump.mp3"));  // set new pairs.
	  sfx.put("scratch", new AudioPlayer("/SFX/scratch.mp3"));
	
	}  
	
	public int getHealth() { return health; }
	public int getMaxHealth() { return maxHealth; }
	public int getFire() { return fire; }
	public int getMaxFire() { return maxFire; }
	public boolean isDead() { return dead; }
	
	// keybord input
	public void setFiring() 
	{
		firing = true;
	}
    public void setScratching(){
    	scratching = true;
    }
    
    public void setGliding(boolean b){   // use boolean here because we can stop gliding
    	gliding = b;                     // at any moment, but once we do an atack we 
    	                                 // have to carry that atcak all the way through. 
    
    }          
    
    public void checkAttack(ArrayList<Enemy> enemies)
    {
    	// loop through enemies
    	for(int i = 0; i < enemies.size(); i++)
    	{

			Enemy e = enemies.get(i);       // get the enemy
    		
    		// check scratch attack
        	if(scratching)
        	{
        		if(facingRight)             // if scratching right
        		{
        			
        				// now he have to find out whether the enemy is in atack range
    /*bounding box */  if(e.getx() > x       // if the enemy is to the right of us
    /*for the scratch*/ && e.getx() < x + scratchRange  //and the right of us + range
    /*damage*/    		&& e.gety() > y - height / 2   // ndermjet intervalit
        				&& e.gety() < y + height / 2   // ]y-height/2; y+height/2[
        				)
        				{
        					e.hit(scratchDamage);
        				}
        						
        		}
        		else    // facing left
        		{
        		
        			// check if in atack range
    				if(e.getx() < x                      // is to the left
    				&& 	e.getx() > x - scratchRange      // - since is to the left
    				&& e.gety() > y - height / 2
    				&& e.gety() < y + height / 2
    				)
    				{
    					e.hit(scratchDamage);
    				}
        			
        		}
        			
        	}
        	
        	// check fireball attack
           for(int j = 0; j < fireBalls.size(); j++)//loop throught all active fireballs
        	{
        		if( fireBalls.get(j).intersects(e) )
        		{
        			e.hit(fireBallDamage);
        			fireBalls.get(j).setHit();   // since fireball hit an enemy
        		                      // calling setHit function so we can do the 
        		             // animation of fireball exploding and set the delay 
        		             // so the enemy cannot be hit again within the delay
        		
        		   break;
        		}
        	}
    		 // check for enemy collision (inside the enemy for loop)
             if(intersects(e))
             {
            	 hit(e.getDamage());
             }
           
    	}
    	
    }
    // hit function for player
    public void hit(int damage)
    {
    	if(flinching) return;
    		
    	  health -= damage;                // otherwise subtract health by damage amount.
		  if(health < 0) health = 0;       // for potential bugg
		  if(health == 0) dead = true;
		
		  flinching = true;                    // if not dead 
		  flinchTimer = System.nanoTime();     // sets the timer
    	
		 
    }
    
    
    
    private void getNextPosition()
    {
     
    	// movement
    	if(left && !notOnScreen())  // (!notOnScreen)fix player off screen bugg
    	{
    		
    		dx -= moveSpeed;      // the vector has to go left minus speed acceleration
    		if(dx < -maxSpeed)    // we cant go pas the maxSpeed, 
    		{
    			dx = -maxSpeed;
    		}
    	}
    	else if(right && !notOnScreen())
 		{
 		    
 			dx += moveSpeed;
 			if(dx > maxSpeed)
 			{
 				dx = maxSpeed;
 			}
 		
 		}
    	
    	else     // if we are not going left or right then we have to stop
    	{
    			if(dx > 0)
    			{
    			   dx -= stopSpeed;  // suptract by the stopSpeed
    			  if(dx < 0)        // we have come to a full stop
    			  {
    				  dx = 0;
    			  }
    			
    			}
    			else if(dx < 0)
    			{
    			   dx += stopSpeed;   // oposite direction
    			   if(dx > 0)      // we have come to a full stop
    			   {
    				   dx = 0;
    			   }
    				
    			}
    		
    	}
    	
    	// cannot move while atacking (except while flying)
    	if((currentAction == SCRATCHING || currentAction == FIREBALL) 
    			&& !(jumping || falling))
    	{
    		dx = 0;
    	}
    	
    	// jumping
    	if(jumping && !falling)
    	{
    		// play the audio for the jump action
    		sfx.get("jump").play();   // get the key and play the audio
    		
    		dy = jumpStart;
    		falling = true;
    	}
    	
    	// falling
    	if(falling)
    	{
    		if(dy > 0 && gliding)  dy += fallSpeed * 0.1;  // 10 % of the falling speed
    		else dy += fallSpeed;
    		
    		if(dy > 0) jumping = false;
    		if(dy < 0 && !jumping)  dy += stopJumpSpeed;  // the longer you hold the 
    		                                           //button the higher the jump is.  
    	    if(dy > maxFallSpeed) dy = maxFallSpeed;
    	
    	
    	}
    		
    		
  }
    
    
    
    // main function (this does all the positioning stuff).(***)
    public void update()
    {
    	// update position
    	getNextPosition();
    	checkTileMapCollision();    // from the mapObject class.
    	setPosition(xtemp, ytemp);  // set the position to the temporary variables.
    	
    	// check attack has stopped
    	if(currentAction == SCRATCHING)
    	{
    		if(animation.hasPlayedOnce())  scratching = false;
    	}
    	if(currentAction == FIREBALL)
    	{
    		if(animation.hasPlayedOnce())  firing = false;
    	}
    	
    	// fireball attack
    	fire += 2;           // we want to continue to regenerate the fireball energy
    	if(fire > maxFire) fire = maxFire;   // cap it at max fire
    	
    	// check if we are firing and the animation is not set yet
    	if(firing && currentAction != FIREBALL)   // check if we have enough energy to 
    	{                                         // perform a fireball attack
    		if(fire > fireCost)
    		{
    			fire -= fireCost;
    			// create a new fireball
    			FireBall fb = new FireBall(tileMap, facingRight, up, down);     ////////// up and down (new mechanics)
    			fb.setPosition(x, y);   //  set it at the same position as the player
    			fireBalls.add(fb);      // add it to ArrayList
    			
    		}
    		
    	}
    	
    	// update fireballs (loop through)
    	for(int i = 0; i < fireBalls.size(); i++)
    	{
    		fireBalls.get(i).update();
    		if(fireBalls.get(i).shouldRemove() )
    		{
    			fireBalls.remove(i);
    			i--;
    		}
    		
    	}
    	// check done flinching
    	if(flinching)
    	{
    		long elapsed = (System.nanoTime() - flinchTimer) / 1000000;
    		
    		if(elapsed > 1000)        // 1 sec of invisibility(1000)
    		{
    			flinching = false;    // stop flinching after 1 sec
    		} 
    	
    	}
    	
    	
    	// set animation
    	if(scratching)
    	{
    		if(currentAction != SCRATCHING)
    		{
    			// play the audio for scratch attack
    			sfx.get("scratch").play();  // get the key , play the audio it has
    			
    			currentAction = SCRATCHING;
    			animation.setFrames(sprites.get(SCRATCHING));
    			animation.setDelay(50);
    			width = 60;
    		}
    		
    	}
    	else if(firing)
    	{
    		if(currentAction != FIREBALL)
    		{
    			currentAction = FIREBALL;
    			animation.setFrames(sprites.get(FIREBALL));
    			animation.setDelay(100);
    			width = 30;
    			
    		}
    		
    	}
    	 
    	else if(dy > 0) //falling (we have 2 ways to fall, regular fall or gliding fall)
    	{
    		if(gliding)   // gliding falling
    		{
    			if(currentAction != GLIDING)  
    			{
    				currentAction = GLIDING;
    				animation.setFrames(sprites.get(GLIDING));
    				animation.setDelay(100);
    				width = 30;
    				
    			}
    		
    		}
    		else if(currentAction != FALLING)   // regular falling
    		{
    			currentAction = FALLING;
    			animation.setFrames(sprites.get(FALLING));
    			animation.setDelay(100);
    			width = 30;
    			
    		}
    	
    	}
    	else if(dy < 0)  // jumping
    	{
    		if(currentAction != JUMPING)
    		{
    			currentAction = JUMPING;
    			animation.setFrames(sprites.get(JUMPING));
    			animation.setDelay(-1);  // -1 because is only one jumping spray 
    			width = 30;              // and we dont need any animation.
    		}
    		
    	}
    	else if(left || right)
    	{
    		if(currentAction != WALKING)
    		{
    			currentAction = WALKING;
    			animation.setFrames(sprites.get(WALKING));
    			animation.setDelay(40);
    			width = 30;
    		}
    	}
    	else
    	{
    		if(currentAction != IDLE)
    		{
    			currentAction = IDLE;
    			animation.setFrames(sprites.get(IDLE));
    			animation.setDelay(400);
    			width = 30;
    		}
    		
    		
    	}
    	
    	animation.update();
    	
    	// set direction
    	if(currentAction != SCRATCHING && currentAction != FIREBALL)
    	{
    		if(right)
    		{
    			facingRight = true;
    		}
    	    if(left)
    		{
                facingRight = false;    		
    		}
    	
    	}
    	
    	
    }
    
    // drawing the player
    public void draw(Graphics2D g)
    {
      setMapPosition(); // this should be the first thing that gets called in any mapOject
    	
      // draw fireballs
      for(int i = 0; i< fireBalls.size(); i++)
      {
    	  fireBalls.get(i).draw(g);
      }
      
      // draw player
      if(flinching)
      {
    	  long elapsed = (System.nanoTime() - flinchTimer) / 1000000; // in milliseconds
    	  if(elapsed / 100 % 2 == 0)   // if true dont draw the player just return
    	  { return; }                  // this will give it the aparence of blinking 
    	                               // every 100 milliseconds.
     
      }
      
     
      super.draw(g);     // facing of objects from MapObject s draw function
      
      
    }
    
    
    
    
	

}








