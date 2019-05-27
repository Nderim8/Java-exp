package GameState;

// import java.util.ArrayList;

public class GameStateManager 
{
	// private ArrayList<GameState> gameStates;  () no longer using arraylist 
	// because  of the music in game , in stead using a regular array.
	
	private GameState[] gameStates;
	private int currentState;            // use it like an index
	
	public static final int NUMGAMESTATES = 4;
	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;
	public static final int LEVEL2STATE = 2;
	public static final int LEVEL3STATE = 3;
	
	
	
	// Constructor
	public GameStateManager()
	{
		gameStates = new GameState[NUMGAMESTATES];
		
		currentState = MENUSTATE;
	    
		loadState(currentState);
	
	
		
	}
	// load  game states
	private void loadState(int state)
	{
		if(state == MENUSTATE)		
			gameStates[state] = new MenuState(this);
		
		if(state == LEVEL1STATE)
			gameStates[state] = new Level1State(this);
		
		if(state == LEVEL2STATE)
			gameStates[state] = new Level2State(this);
		
		if(state == LEVEL3STATE)
		gameStates[state] = new Level3State(this);
			
	}
	// unload game states
	private void unloadState(int states)
	{
		gameStates[states] = null;   // free some memory (good coding practice)
	}
	
	public int getState()  /////////////
	{
		return currentState;
	}
	
	public void setState(int state)
	{
		unloadState(currentState);     // unload current state 
		
		currentState = state;          // set new state
		
		loadState(currentState);       // load the new state 
		
		// no longer using init()
	   // gameStates[currentState].init();
		
	}
	
    public void update()
    {
    	if(gameStates[currentState] != null)
    	gameStates[currentState].update();
    	
    }
    
    public void draw(java.awt.Graphics2D g)
    {
    	if(gameStates[currentState] != null)
    	gameStates[currentState].draw(g);
    
    }
    
    public void keyPressed(int k)
    {
    	gameStates[currentState].keyPressed(k);
    }
	
    public void keyReleased(int k)
    {
    	gameStates[currentState].keyReleased(k);
    }
	
	
	
	
}
