package flappyBird;

import java.awt.image.BufferedImage;

//this class will handle the spray animation 
public class Animation 
{
 // we are gonna use an array of buffered images to hold all of frames
	private BufferedImage[] frames;
	private int currentFrame;             //-> we also have to keep track 
	                                      // of the current frame.
	
	private long startTime;           // -> timer between frames.
	private long delay;               // -> how long between each frame.
	
	private boolean playedOnce;       // tells us whether or not  
                                 // the animation has played already. 

 // this is useful for atacking animations, were the animation of atack 
	// only needs to happen one time.
	public Animation()     // constructor
	{
		playedOnce = false;
	}
	
	// need to set the frames
	public void setFrames(BufferedImage[] frames)
	{
		this.frames = frames;
		currentFrame = 0;           // reset the current frame to 0.
	    startTime = System.nanoTime();
		playedOnce = false;
		
	}
	// we also need to give it a delay
	public void setDelay(long d) { delay = d; }
	
	// we might need in case we wont to manually set the frame number
	public void setFrame(int i) { currentFrame = i; }
	
	// update function, this will handle the logic for determining 
	// whether or not to move to the next frame.
	public void update()
	{
		if(delay == -1) return;  // if true then there is no animation
//otherwise we need to find out how long its been since the last frame came up
		long elapsed = (System.nanoTime() - startTime) / 1000000;  //to get in millisec.
	    if(elapsed > delay)     // -> if true we have to move on to the next frame,
	    {
	    	currentFrame++;
	    	startTime = System.nanoTime();  // and reset the timer.
	    	
	    }   
	    // we also have to make sure that we dont go past the amount of frames there are
	    if(currentFrame == frames.length)   //if true then it went out of bounce
	    {
	    	currentFrame = 0;     // we have to loop back to 0,
	    	playedOnce = true;    // also that means the animation has played once.
	    	
	    }
	    
	}
	 // current frame number
	public int getFrame() { return currentFrame; }
	
	 //gets the image that we need to draw
	 public BufferedImage getImage() { return frames[currentFrame]; }  
	
	 public boolean hasPlayedOnce() { return playedOnce; }
	
	
} 