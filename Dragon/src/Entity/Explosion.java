package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

// no need to extand MapObject since it only going to play an animation when an
// enemy dies
public class Explosion 
{
	
	// position of the explosion
	private int x;
	private int y;
	
	// we need this for the for the exact position of explosion 
	// in order to translate to local coordinates.
	private int xmap;
	private int ymap;
	
	private int width;
	private int height;
	
	private Animation animation;
	private BufferedImage[] sprites;
	
	private boolean remove;   // to know when to remove the explosion
	
	public Explosion(int x, int y)
	{
		this.x = x;
		this.y = y;
		
		width = 30;
		height = 30;
		
		// read the sprite
	
		try
		{
			BufferedImage spritesheet = ImageIO.read(
					getClass().getResourceAsStream("/Sprites/Enemies/explosion.gif"));
			
			// splitting up the spritesheet into different frames
			sprites = new BufferedImage[6];
			for(int i = 0; i < sprites.length; i++)
			{
				sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
			
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// set the animation
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(70);
	
	}
	
	// update the animation
	public void update()
	{
		animation.update();
		if(animation.hasPlayedOnce())
		{
			remove = true;
			
		}
	
	}
	
	public boolean shouldRemove() { return remove; }
	
	//  set position where on the map do we want the explosion to be 
	public void setMapPosition(int x, int y)
	{
		xmap = x;
		ymap = y;
		
	} 
	
	// draw the explosion
	public void draw(Graphics2D g)
	{
	 g.drawImage(animation.getImage(),
			 x + xmap - width / 2, y + ymap - height / 2, null);
		
	}
	
	

}






