package Entity;

import TileMap.TileMap;

// can be abstract (if it has abstract functions (?))
public class Enemy extends MapObject
{
	protected int health;
	protected int maxHealth;
	protected boolean dead;
	protected int damage;
	
	protected boolean flinching;
	protected long flinchTimer;
	
    //  constructor
	public Enemy(TileMap tm)
	{
		super(tm);
	}
	
	public boolean isDead() { return dead; }
	
	public int getDamage() { return damage; }
	
	public void hit(int damage)
	{
		if(dead || flinching) return;    // if enemy is dead or flinching just return
		health -= damage;                // otherwise subtract health by damage amount.
		if(health < 0) health = 0;
		if(health == 0) dead = true;
		
		flinching = true;                    // if not dead 
		flinchTimer = System.nanoTime();     // sets the timer
		
	}
	
	public void update() {}
	
	
	
	
	
}
