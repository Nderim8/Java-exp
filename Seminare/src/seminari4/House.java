package seminari4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class House 
{
	private int X;
	private int Y;
	private int Width;
	private int Height;
	
	public House(int x, int y, int width, int height)
	{
		X = x;
		Y = y;
		Width = width;
		Height = height;
	}
	public void draw(Graphics2D g2)
	{
		Rectangle baza = new Rectangle(X  , Y  , Width , Height);
		
		Rectangle dera = new Rectangle(X + Width/4  , Y + Height/2, Width/4 , Height/2 );
		
		Rectangle dritarja = new Rectangle(X + 5*Width/8  , Y + Height/2, Width/4 , (Height/2) * 1/2 );
		
		Line2D.Double vMajtas = new Line2D.Double(X, Y, X + Width/2, Y - (Height/4));
		
		Line2D.Double vDjathtas = new Line2D.Double(X + Width, Y , X + Width/2, Y - (Height/4));
		
		g2.draw(baza);
		g2.setColor(Color.yellow);
		g2.draw(baza);
		g2.fill(baza);
		
		
		g2.setColor(Color.black);
		g2.draw(dera);
		g2.fill(dera);
		
		
		g2.setColor(Color.cyan);
		g2.draw(dritarja);
		g2.fill(dritarja);
		
		g2.setColor(Color.black);
		g2.draw(vMajtas);
		g2.draw(vDjathtas);
		
		
	}
	
	

}
