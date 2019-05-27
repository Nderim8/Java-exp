package GameState;


import Main.GamePanel;
import TileMap.*;
import Entity.*;
import Entity.Enemies.*;
import Audio.AudioPlayer;     // audio


import java.awt.*;

import java.awt.event.KeyEvent;

import java.util.ArrayList;


public class Level1State extends GameState
{
	
	private TileMap tileMap;
	private Background bg;
	
    private Player player;
    public int score;
    
   
	// put all sort of enemies together
	private ArrayList<Enemy> enemies;
	
	
	private ArrayList<Explosion> explosions;
	
	// HUD
	private HUD hud;
	
	// audio
	private AudioPlayer bgMusic;
		
	
	
	public Level1State(GameStateManager gsm )
	{
		this.gsm = gsm;
		
		
		init();
		score = 0;
			
	}
    public int getScore()
    {
    	return score;
    }
	
	
	public void init() 
	{
		tileMap = new TileMap(30, gsm);         ///////////////////////////
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");   
		tileMap.setPosition(0, 0);
		
		bg = new Background("/Backgrounds/grassbg1.gif",0.1);
		
		
		player = new Player(tileMap);
		player.setPosition(100,100);
		

		// fill map with enemies
		populateEnemies();
		
	
		explosions = new ArrayList<Explosion>();
		
		hud = new HUD(player);
		
		// create audio
		bgMusic = new AudioPlayer("/Music/level1-1.mp3");
		
		bgMusic.playbg();
		
	}
	
	private void populateEnemies() 
	{
		enemies = new ArrayList<Enemy>();
		
		// put sluggers in the map
		Slugger s;
		Point[] points = new Point[] {
			
				// new Point(100, 100),
			new Point(200, 100), new Point(400, 140),
			new Point(860, 200), new Point(960,200), 
			new Point(1525, 200), 
			new Point(1680, 200), new Point(1800, 200), new Point(1840, 170)
			
		};
		// now we  need a loop to go through this array of Points
		for(int i = 0; i < points.length; i++)
		{
			s = new Slugger(tileMap);
			
			s.setPosition(points[i].x, points[i].y);
			
			// fill enemies ArrayList with sluggers at the positions we made
			enemies.add(s);
		}
		
		// put arachniks in the map
		Arachnik a;
		Point[] points2 = new Point[] {
			
		    new Point(200,40), new Point(400, 100),
		    new Point(1800, 200),
			new Point(1840, 170), new Point(2000, 30),
			new Point(2050, 30), new Point(2100, 40),
		
		};
		// now we  need a loop to go through this array of Points
		for(int i = 0; i < points2.length; i++)
		{
			a = new Arachnik(tileMap);
			
			a.setPosition(points2[i].x, points2[i].y);
			
			// fill enemies ArrayList with arachniks at the positions we made(points2)
			enemies.add(a);
		}
		
		
	}

	
	public void update()
	{
		// update player		
		  player.update();
		  if(player.getx() >= 200 ) ////////////// if true then lock the map with the update function at TileMap
		  {	  
		      tileMap.update();      /// (redraws some tiles)
		  }
		
		  if(player.getx() >= 2920)
		  {
			  tileMap.update1();
		  }
		 
		  if(!(player.getx() >= 2920))   
		  {  
		  // set the tileMap depending on the player position    
		  tileMap.setPosition( GamePanel.WIDTH / 2 - player.getx(), // keep the camera 
				GamePanel.HEIGHT / 2 - player.gety() );             // centered on player
		  }
		  else     // lock the screen for the boss event
		  {
			  tileMap.setPosition( GamePanel.WIDTH /2 - 3200, GamePanel.HEIGHT / 2 - player.gety() );  // 2920
		  }   
		  
		  
		// attack enemies
		 player.checkAttack(enemies);
			
		// set background (background moving) (causes glitch i think)
	    bg.setPosition(tileMap.getx(), tileMap.gety());
	    
	    // update all enemies
	    for(int i = 0; i < enemies.size(); i++)
	    {
	    	// new instance of enemy for the explosion
	    	Enemy e = enemies.get(i);
	    	
	    	e.update();
	    	
	    	// check if enemy is dead
	    	if(e.isDead())
	    	{
	    		enemies.remove(i);
	    		i--;   // so it wont skip checking the enemy that
	    	           //  gets the place of the removed enemy in the ArrayList
	    		
	    		score = score + 100;  // add score (100 per enemy killed)
	    		
	    		// when enemy dies we add an explosion at his coordinates
	    		explosions.add(new Explosion(e.getx(), e.gety()));
	    		
	    	}
	    	
	    }
	    
	    // update all explosions
	    for(int i = 0; i < explosions.size(); i++)
	    {
	    	explosions.get(i).update();
	    	
	    	if(explosions.get(i).shouldRemove())
	    	{
	    		explosions.remove(i);
	    		i--;
	    		
	    	}
	    	
	    }
		
	}

	
	public void draw(Graphics2D g) 
	{
	
		// draw bg
		bg.draw(g);
		
	
		// draw tilemap
		tileMap.draw(g);
		
	

	 if(!player.isDead() &&  !player.notOnScreen())
	 {		
			// draw player
			player.draw(g);
		
		// draw enemies
		for( int i = 0; i < enemies.size(); i++)
		{
			enemies.get(i).draw(g);
		  
		}
		
		// draw explosions
		// we need  a loop to draw  all the explosions
		for (int i = 0; i < explosions.size(); i++)
		{
			// set the map position of explosions
			explosions.get(i).setMapPosition(
					(int)tileMap.getx() , (int)tileMap.gety());
			
			explosions.get(i).draw(g);
		}
		
	
	 }	
		if(player.isDead() || player.notOnScreen())
		{
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 20));
			g.drawString("Game Over!", GamePanel.WIDTH / 2 - 50, GamePanel.HEIGHT / 2);
			
			g.setColor(Color.red);
			g.setFont(new Font("Arial", 1, 15));
			g.drawString("Press Enter", GamePanel.WIDTH / 2 - 40, GamePanel.HEIGHT / 2 + 15);
		}
	 
		// draw HUD
		hud.draw(g);
		
		
		g.drawString(String.valueOf(score), GamePanel.WIDTH/2, 20);
		g.drawString(String.valueOf(player.getx()),GamePanel.WIDTH-40,20);
		if(!player.notOnScreen())
		g.drawString(String.valueOf(player.gety()),GamePanel.WIDTH-40,35);
		
		// draw a door
	/*	Rectangle door = new Rectangle(200, 160, 40, 40);
		
		g.setColor(Color.white);
		g.draw(door);
	    g.fill(door);   */
		
		
	}

	boolean T;
	
	public void keyPressed(int k) 
	{
		
		
	  if(!player.isDead() && !player.notOnScreen())
	  {	  
		if(k == KeyEvent.VK_A)  player.setLeft(true);
		if(k == KeyEvent.VK_D)  player.setRight(true);
		if(k == KeyEvent.VK_W)  player.setUp(true);
		if(k == KeyEvent.VK_S)  player.setDown(true);
		if(k == KeyEvent.VK_U)  player.setJumping(true);
		if(k == KeyEvent.VK_I)  player.setGliding(true);
		if(k == KeyEvent.VK_O)  player.setScratching();
		if(k == KeyEvent.VK_L)  player.setFiring();
		
		if(k == KeyEvent.VK_T)  T = true;
		
	  }	
	  
	  if(player.isDead() || player.notOnScreen())
	  {
		  // set gameState to MENUSTATE
		  if(k == KeyEvent.VK_ENTER)
		  {	  
		    gsm.setState(GameStateManager.MENUSTATE);
	      
		    // stop background music
		    bgMusic.close();  //  can use stop method too but close , to free some memory 
		  }
		    
	  }
	  
	  // 2 teleports to stage 2
	  if( (player.getx() >= 200 &&  player.getx() <=260 && player.gety() >= 160) 
			  || (player.getx() >= 3130 && player.getx() <= 3190 && player.gety() >= 160 ) )    // 3130 , 160
	  {
		  if(k == KeyEvent.VK_P )
		  {
			  if(T)
			  {	  
			     gsm.setState(GameStateManager.LEVEL2STATE);
			     bgMusic.close();
           
			  }
			  
		  }
	  }
	  
	 
	}

	public void keyReleased(int k) 
	{
	  if(!player.isDead() && !player.notOnScreen())
	  {
		  if(k == KeyEvent.VK_A) player.setLeft(false);
			if(k == KeyEvent.VK_D)  player.setRight(false);
			if(k == KeyEvent.VK_W)  player.setUp(false);
			if(k == KeyEvent.VK_S)  player.setDown(false);
			if(k == KeyEvent.VK_U)  player.setJumping(false);
			if(k == KeyEvent.VK_I)  player.setGliding(false);
			if(k == KeyEvent.VK_O)  player.setScratching();
			if(k == KeyEvent.VK_L)  player.setFiring();
			
			if(k == KeyEvent.VK_T)  T = false;
			
	  }
	  
	
		
	}
	
	

}
