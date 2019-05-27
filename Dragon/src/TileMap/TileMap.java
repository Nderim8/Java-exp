package TileMap;

import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.ImageIO;

import Entity.*;
import GameState.GameStateManager;
import Main.GamePanel;



public class TileMap 
{
   
   private GameStateManager gsm;
   
   
	// postion 
	private double x;
	private double y;
	
	// bounds 
	private double xmin;
	private double ymin;
	private double xmax;
	private double ymax;
	
	// for the camera smoothly following the player (twitching)
	private double tween;
	
	// map
	private int [][] map;   // 2D integer array
	private int tileSize;
	private int numRows;
	private int numCols;
	private int width;     // dimensions of the map (in pixels)
	private int height;
	
	// tileset
	private BufferedImage tileset;
	private int numTilesAcross;
	
	// after we import the tileset BufferedImages we will put all the tile images
	// into this Tile 2D array
	private Tile[][] tiles;
	
	// drawing
	// we dont want to draw  the entire TileMap all the time we only want to draw  
	// the tiles that are on the screen 
	private int rowOffset;     // tells us which row to start drawing
	private int colOffset;
	private int numRowsToDraw;  // we need to know how many rows and cols to draw
	private int numColsToDraw;
	
	public int getNumRows() { return numRows; }
	public int getNumCols() { return numCols; }

	
	// Constructor
	public TileMap(int tileSize, GameStateManager gsm)
	{
		this.gsm = gsm;
		
		
		this.tileSize = tileSize;
		// since the game is 240 height and the tile size is 30 so its 8 tiles 
		// down , add an extra 2 just to pad it, so we dont get any skips
		numRowsToDraw = GamePanel.HEIGHT / tileSize + 2;
		numColsToDraw = GamePanel.WIDTH / tileSize + 2; // 320 / 30 around 11 tiles across
		tween = 1;
		
	}

	
	
	public void loadTiles(String s) // loads the tileset into memory
	{
		try
		{
			tileset = ImageIO.read(getClass().getResourceAsStream(s));
			numTilesAcross = tileset.getWidth() / tileSize;
			// the tile array, which is the representation of the tileset
			// (2 rows and numTilesAcross columns)
			tiles = new Tile[2][numTilesAcross];
			
			// import the entire tileset
			BufferedImage subimage;
			for(int col = 0; col < numTilesAcross; col++)
			{
				subimage = tileset.getSubimage(col * tileSize, 0, tileSize, tileSize);
			    
				tiles[0][col] = new Tile(subimage, Tile.NORMAL);
				subimage = tileset.getSubimage(col * tileSize, tileSize, tileSize, tileSize);
				tiles[1][col] = new Tile(subimage, Tile.BLOCKED);
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void loadMap(String s)  // loads the map file into memory 
	{
		
		try
		{
			  
			InputStream in = getClass().getResourceAsStream(s);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			// the way of the map file is set up so that the first line is the number of cols
			// the second line is the numrows and the rest of the lines are the map itself
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int[numRows][numCols];
			width = numCols * tileSize;          // width in pixels
			height = numRows * tileSize;         // height in pixels
			
		// setting the coordinates of map (so it can move)	
			xmin = GamePanel.WIDTH - width;
			xmax = 0;
			ymin = GamePanel.HEIGHT - height;
			ymax = 0;
			
			// start reading the map file (map itself, the array)
			String delims = "\\s+";       // Delimiters (just white space)
			for(int row = 0; row < numRows; row++) //  read all of the lines
			{
			  String line = br.readLine();                // read line 
			  String[] tokens = line.split(delims); //split it using the delims (whitespace)
			  for(int col = 0; col < numCols; col++)//go through that array and put it in map
			  {
				  map[row][col] = Integer.parseInt(tokens[col]);
				  
				  
			  }
				
			}
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

	public int getTileSize() { return tileSize; }
	public double getx() { return x; }
	public double gety() { return y;}
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public int getType(int row, int col)
	{
		int rc =  map[row][col];      // how it works: exm: to read the 
		int r = rc / numTilesAcross;  // 9-nth tile when the last tile in one row
		int c = rc % numTilesAcross;  // is 7 (means one row has 6 tiles since it
		return tiles[r][c].getType(); // begins from 0) r=9/7=1 means the tile 
		                              // is in row number 1, c=9%7=1 		

	}
	
	public void setPosition(double x, double y)
	{
		this.x += (x - this.x) * tween;
		this.y += (y - this.y) * tween;
		
		fixBounds();
		
		// we have to find out where to start drawing , dont want to draw 
		// the entire TileMap
		colOffset = (int)-this.x / tileSize;  // which column to start drawing
		rowOffset = (int)-this.y / tileSize; // which row
		
	}
	
	private void fixBounds()
	{
		if(x < xmin) x = xmin;
		if(y < ymin) y = ymin;
		if(x > xmax) x = xmax;
		if(y > ymax) y = ymax;
	}
	
	public void draw(Graphics2D g)
	{
		for(int row = rowOffset; row < rowOffset + numRowsToDraw; row++)
		{
			if(row >= numRows) break;
			
			for(int col = colOffset; col < colOffset + numColsToDraw; col++)
			{
				if(col >= numCols) break;
				
			if(map[row][col] == 0) continue; //first tile in tile set is nthing
				
				int rc = map[row][col];
				int r = rc / numTilesAcross;
				int c = rc % numTilesAcross;
				
				g.drawImage(tiles[r][c].getImage(), (int)x + col * tileSize,
						(int)y + row * tileSize, null);
				
		      if(gsm.getState() == 1)
		      { 
		    	  g.drawString("Fake tile", (int)x + 2 * tileSize, (int)y + 5 * tileSize  - 10  ); ////////// just the image
		    	  g.drawImage(tiles[1][2].getImage(),(int)x + 2 * tileSize, (int)y + 5 * tileSize, null); 
		    	  g.drawImage(tiles[1][4].getImage(),(int)x + 3 * tileSize, (int)y + 5 * tileSize, null); 
		      }
			
		      
		      
		      
			}
			
		}
		
		          //// if(gsm.getState() == 1) g.drawString("Behet", 150,150);
	       //   if(player.getx() >= 150) g.drawString("Behet", 150,150);  error
		
	}
	
      public void update() 
      {
		
		
		   if(gsm.getState() == 1 )  // for the first level (if the event is true) // not necessary
		   {
			map[5][4] = 22;          //////// to lock the map for the boss event         ////////////////
			map[5][5] = 22;
			map[6][4] = 22;        
			map[6][5] = 22;
		
		
		   }
		
	   }	
	  	
      public void update1()
      {
    	    map[5][95] = 22;          //////// to lock the map for the boss event         ////////////////
			map[5][96] = 22;
			map[6][95] = 22;        
			map[6][96] = 22;
		
			map[5][97] = 4;          // 4  is the forth image at tileset
			map[5][94] = 3;
			map[6][94] = 3;        
			map[6][97] = 4;
			
    	  
      }
      
      
	
}



