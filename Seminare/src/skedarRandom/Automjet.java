package skedarRandom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Automjet
{
	private String lloji;	
	private int x;
	private int y;
	private int size = 1;
	
	public Automjet(String lloj)
	{
		lloji = lloj;
	}
		
			public void vizato(Graphics g) 
		    {
			   Graphics2D g2 = (Graphics2D) g;
			   Random rand= new Random();
			   if (lloji.equals("makine"))
			   {
				   x = 1 + rand.nextInt(400);
				   y = 1 + rand.nextInt(400);
			   // size = 1 + rand.nextInt(2);
			      Car car1 = new Car(x, y, size);
		          
			      car1.draw(g2); 
			
			   }
			   else if(lloji.equals("kamion"))
			   {
				  
					   x = 1 + rand.nextInt(400);
					   y = 1 + rand.nextInt(400);
				   //  size = 1 + rand.nextInt(2);
				      Truck truck1 = new Truck(x, y, size);
			          
				      truck1.draw(g2); 
				   
			   }
			
		  }
			
}
		

