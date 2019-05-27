package GameState;

// abstract class because we dont want anyone to actually use the GameState class
// its self , we want to extend of of its subclasses (like a blueprint)
public abstract class GameState 
{
	// every GameState will have a reference to the GameStateManager so that
	// it can change states, it can call a set of states
	protected GameStateManager gsm;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(java.awt.Graphics2D g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	

}
