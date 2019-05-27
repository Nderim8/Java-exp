package TileMap;

import Main.GamePanel;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Background 
{
	private BufferedImage image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	// the scale which the background moves, if we are moving right like 10 
	// and the scale is 0.1 then its going with 10% the regular speed to create
	// the parallax effect
	private double moveScale; 
	
	public Background(String s, double ms)  // double moveScale(ms)
	{
		try
		{
			// importing resource files into the game
			image = ImageIO.read(getClass().getResourceAsStream(s));
			moveScale = ms;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void setPosition(double x, double y)
	{
		// Smooth scrolling, we dont want it to keep going all the way of the screen
		// if it goes past the screen then we wont it to reset so it looks smooth
		this.x = (x * moveScale) % GamePanel.WIDTH; 
		this.y = (y * moveScale) % GamePanel.HEIGHT;
		
	}
	
	public void setVector(double dx, double dy) //makes the bg automatically scroll
	{
		this.dx = dx;
		this.dy = dy;
	}
	
	public void update() // if we set the vector coordinates we have to call update
	{
		x += dx;
		y += dy;
	}
	
	
	public void draw(Graphics2D g)
	{
		g.drawImage(image, (int)x, (int)y, null);
		
		// since this is a scrolling background we have to make sure its always 
		// filling the screen, if the background is scrolling to the left we have 
		// make sure to draw another instance of the bg to the right in oreder to
		// fill up the space
		if(x<0)
		{
			g.drawImage(image, (int)x + GamePanel.WIDTH, (int)y, null);
		}
		
		if(x > 0)
		{
			g.drawImage(image, (int)x - GamePanel.WIDTH, (int)y, null);
		}
		
	}  
	
	
	

}







