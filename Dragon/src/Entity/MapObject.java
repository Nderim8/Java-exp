package Entity;

import TileMap.Tile;
import TileMap.TileMap;
import java.awt.Rectangle;

import Main.GamePanel;

// superclass (so that i dont have to keep reusing these variables 
//             over and over when i a make a player, enemy etc. class)

public abstract class MapObject 
{
	// tile stuff.
	// (since this is an abstract superclass everything has to be 
	// protected so that the subclasses can see this)
	
	protected TileMap tileMap;
	protected int tileSize;
	protected double xmap;
	protected double ymap;
	
	
	// Position and vector
	// (x and y position , dx and dy the direction the object is going)
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	
	// dimensions
	// (the width and height are mainly for reading in the spritesheets that will use)
	protected int width;
	protected int height;
	
	// collision box
	// (these are used to determine collision with tiles and other enemies
	//  ,the real dimensions*) 
	protected int cwidth;
	protected int cheight;
	
	// collision
	// (variables so we dont have to make new ones)
	protected int currRow;    // (current row that we are in) 
	protected int currCol;    // (current column)
	protected double xdest;    // (destinations where are we going
	protected double ydest;    //  the next positon)
	protected double xtemp;    // (temporary position)
	protected double ytemp;    //
	protected boolean topLeft;     // (using the 4 point method for collision 
	protected boolean topRight;    //  using the 4 corners to determent 
	protected boolean bottomLeft;  //  whether  i am hitting
	protected boolean bottomRight; //  a block tiler or not)
	
	// animation
	protected Animation animation;
	protected int currentAction;
	protected int previousAction;
	protected boolean facingRight;   // (used to determent wether or not the 
	                                // sprite should be facing right or left)
	
	// movement
	//(booleans that determine what the object is actually doing)
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	protected boolean falling;
	
	// movement atributes (physics)
	protected double moveSpeed;   // (how fast does the object acelerate)
	protected double maxSpeed;    // (how fast the object can go)
	protected double stopSpeed;   // (deceleration speed, if not pressing left
	                              //  or right this is the speed value)
	protected double fallSpeed;   // (gravity)
	protected double maxFallSpeed;   // (terminal velocity :P)
	protected double jumpStart;      // (how high the object can jump)
	protected double stopJumpSpeed;  // (mechanic -> if you hold the jump
	                                 //  button longer you keep going higher)    
	
	
	// constuctor
	// (sets the tile map and get the tile size)
	public MapObject(TileMap tm)
	{
		tileMap = tm;
		tileSize = tm.getTileSize();
	}
	
	public boolean intersects(MapObject o)
	{
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.intersects(r2);
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle((int)x - cwidth, (int)y - cheight, cwidth, cheight);  //////////////////////
	}
	
	public void calculateCorners(double x, double y) {
		int leftTile = (int)(x - cwidth / 2) / tileSize;
		int rightTile = (int)(x + cwidth / 2 - 1) / tileSize;
		int topTile = (int)(y - cheight / 2) / tileSize;
		int bottomTile = (int)(y + cheight / 2 - 1) / tileSize;
		if(topTile < 0 || bottomTile >= tileMap.getNumRows() ||
			leftTile < 0 || rightTile >= tileMap.getNumCols()) {
			topLeft = topRight = bottomLeft = bottomRight = false;
			return;
		}
		int tl = tileMap.getType(topTile, leftTile);
		int tr = tileMap.getType(topTile, rightTile);
		int bl = tileMap.getType(bottomTile, leftTile);
		int br = tileMap.getType(bottomTile, rightTile);
		topLeft = tl == Tile.BLOCKED;
		topRight = tr == Tile.BLOCKED;
		bottomLeft = bl == Tile.BLOCKED;
		bottomRight = br == Tile.BLOCKED;
	}
	
	public void checkTileMapCollision()
	{
		currCol = (int)x / tileSize;
		currRow = (int)y / tileSize;
		
		xdest = x + dx; 
		ydest = y + dy;
		
		xtemp = x;
		ytemp = y;
		
		calculateCorners(x,ydest);
		
		if(dy < 0)   // means(if we are going up)
		{
			if(topLeft || topRight)  // means if we have hit smthing, and need to stop
			{
				dy = 0;
				ytemp = currRow * tileSize + cheight / 2;
			}
			else  // we can keep going 
			{
				ytemp += dy;
			}
		}
		
		if(dy > 0)  // if we are going down, falling
		{
			if(bottomLeft || bottomRight)  //if we have hit a tile, then we have to stop
			{
				dy = 0;
				falling = false;
				
			 //	up = true;
				
				ytemp = (currRow + 1) * tileSize - cheight / 2;
			}
			else  // we can keep falling
			{
				ytemp += dy;
			}
		}
		
		calculateCorners(xdest, y);  // doing the x direction
		if(dx < 0)  // means we are going left
		{
			if(topLeft || bottomLeft)   // check the left corners,if eather one is true
			{                           // that means we have hit a blocked tile
				                        // and we have to stop moving 
				dx = 0;                 
			    xtemp = currCol * tileSize + cwidth / 2;  // set the x position
			                                              // to just right of the tile hit 
			}  
			else   // else we are free to keep going
			{
				xtemp += dx;
			}
		}	
		
		if(dx > 0)  // means that we are moving to the right
		{
			if(topRight || bottomRight)  // check the right corners
			{                            // if eather is true that means we have hit a wall
				dx = 0;                  //  to the right and need to stop moving
			    xtemp = (currCol + 1) * tileSize - cwidth / 2; //-> sets x postion
			                                          // just to the left of that wall
			}
			else
			{
				xtemp += dx;    /////////////
			}

		}
		                 // check whether or not we ran of a cliff.
		if(!falling)     // if we are not falling
		{
			calculateCorners(x, ydest + 1); // check the ground 1 pixel below our feet
			if(!bottomLeft && !bottomRight) // if true means we are no longer 
			{                               // in solid ground and have to start falling.
				falling = true;
			}
		}
		
		
		if(dx > 0 || dx < 0)              // remove this for new fireball mechanichs
		{
		calculateCorners(x, ydest - 1); // check the ground 1 pixel up (essentially for the fireball)
	    if(topRight || topLeft)
	    {
	    	dx = 0;
	    }
	    
		}
		                             
	
	
	
	}
	
	public int getx() { return (int)x; }
	public int gety() { return (int)y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getCWidth() { return cwidth; }
	public int getCHeight() { return cheight; }
	
	public int getXmap() { return (int)xmap; }
	public int getYmap() { return (int)ymap; }
	
	            // regular position
	public void setPosition(double x, double y)   
	{                   
		this.x = x;     // setters , that set the values
		this.y = y;
	}
	public void setVector(double dx, double dy)
	{
		this.dx = dx;
		this.dy = dy;
	}
	            // map position, tells us where to actually draw the caracter
	// exp: if the player is at position 2000,1000 then he would be offscreen
	// we have to found out how far the tile map has moved in order to offset
// the player back on to the screen and thats the final position(x+xmap),(y+ymap)
	
	public void setMapPosition()  // every map object has 2 different positions, 
	{                             // one is global position(regular x and y)  
		xmap = tileMap.getx();    // the other is the local position witch is the 
		ymap = tileMap.gety();    // x and y + the tile position
	}
	
	// setting the action for the object
	public void setLeft(boolean b) { left = b; }
	public void setRight(boolean b) { right = b; }
	public void setUp(boolean b) { up = b; }
	public void setDown(boolean b) { down = b; }
	public void setJumping(boolean b) { jumping = b; }
	
	// like the tile map we dont want to draw the entire tile map every time,
	// we only draw the tiles that are necessary ,and same with map objects 
	// we dont want to draw map object that are not even on the screen
	
	// (not very necessary cuz all rendering outside of the BufferedImage is 
	// automatically ignored.)
	public boolean notOnScreen()  // use this to determine whether we have to 
	{                             //  draw the object or not 
		    
		 // if the oject is beyond the left side of the screen,
		 // or beyond the right side, 
		 // or the object is on top of the screen or below screen.
		return x + xmap + width < 0 || x + xmap - width > GamePanel.WIDTH 
			|| y + ymap + height < 0 || y + ymap - height > GamePanel.HEIGHT;
	
	}
	                   // its own draw function
	public void draw(java.awt.Graphics2D g)       // facing of objects
	{
		 if(facingRight)
	      {                                           // map position
	    	  g.drawImage(animation.getImage(), (int)(x + xmap - width / 2),
	    			  (int)(y + ymap - height / 2), null );
	    	  // width/2 and height/2 because of the sprite image 
	          // x ku e duam objektin te vizatohet + x hartes(qe trgon se ku ndodhet ekrani
	    	  // per momentin) - gjysmen e imazhit
	    	  // ben qe qendra e imazhit te vizatohet ne posicionin qe ne deshirojm
	      }
	      else    // facing left
	      {                                                  // shifted up by width
	    	  g.drawImage(animation.getImage(), (int)(x + xmap - width / 2 + width),
	    			  (int)(y + ymap - height / 2), -width, height, null);
	    	  
	      }
		
	}
	
	

}


