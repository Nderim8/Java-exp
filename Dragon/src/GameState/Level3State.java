package GameState;

import Main.GamePanel;
import TileMap.*;
import Entity.*;
import Entity.Enemies.*;
import Audio.AudioPlayer;   


import java.awt.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Level3State extends GameState
{
	
	private TileMap tileMap;
	private Background bg;
	
    private Player player;
    public int score = 0;
	
	// put all sort of enemies together
	private ArrayList<Enemy> enemies;
	
	
	private ArrayList<Explosion> explosions;
	
	// HUD
	private HUD hud;
	
	// audio
	private AudioPlayer bgMusic;
	
	
	
	public Level3State(GameStateManager gsm)
	{
		this.gsm = gsm;
		
		init();
	}

	
	public void init() 
	{
		tileMap = new TileMap(30, gsm);   //////////////
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-3.map");
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
			new Point(220, 150),  new Point(340, 150),
			new Point(440, 150),  new Point(1450,180), 
			new Point(1560, 180), new Point(1650, 180),
		    new Point(2578, 60),  new Point(2635, 60),
			new Point(2621, 170), new Point(2670, 170)
			
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
			
		    new Point(250, 100),  new Point(380, 130),
		    new Point(644, 50),  new Point(737, 70),
			new Point(1124, 80), new Point(1905, 80),
			new Point(2116, 60), new Point(2236, 120),
			new Point(2415, 60), new Point(2832, 120)
				
			
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
		  
	
		// set the tileMap depending on the player position    
		  tileMap.setPosition( GamePanel.WIDTH / 2 - player.getx(), // keep the camera 
				GamePanel.HEIGHT / 2 - player.gety() );             // centered on player
		
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
		/* clear screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);  */
		
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

		g.drawString(String.valueOf(player.getx()),GamePanel.WIDTH-40,20);
		g.drawString(String.valueOf(player.gety()),GamePanel.WIDTH-40,35);
		g.drawString(String.valueOf(score), GamePanel.WIDTH/2, 20);
		
		
	}

	public void keyPressed(int k) 
	{
	  if(!player.isDead() && !player.notOnScreen())
	  {	  
		if(k == KeyEvent.VK_A) player.setLeft(true);
		if(k == KeyEvent.VK_D)  player.setRight(true);
		if(k == KeyEvent.VK_W)  player.setUp(true);
		if(k == KeyEvent.VK_S)  player.setDown(true);
		if(k == KeyEvent.VK_U)  player.setJumping(true);
		if(k == KeyEvent.VK_I)  player.setGliding(true);
		if(k == KeyEvent.VK_O)  player.setScratching();
		if(k == KeyEvent.VK_L)  player.setFiring();
		
	  }	
	  
	  if(player.isDead() || player.notOnScreen())
	  {
		  // set gameState to MENUSTATE
		  if(k == KeyEvent.VK_ENTER)
		  {	  
		    gsm.setState(GameStateManager.MENUSTATE);
	      
		    // stop background music
		    bgMusic.close();  
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
			
	  }
		
	}
	

}