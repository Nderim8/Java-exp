package checkGame;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;

public final class Checker
{
   private final static int DIMENSION = 50;
 
   private BufferedImage wking;
   private BufferedImage wqueen;
   private BufferedImage wofficer;
   private BufferedImage whorse;
   private BufferedImage wtower;
   private BufferedImage wsoldier;
   private BufferedImage bking;
   private BufferedImage bqueen;
   private BufferedImage bofficer;
   private BufferedImage bhorse;
   private BufferedImage btower;
   private BufferedImage bsoldier;
   private int width1;
   private int height1;

   private CheckerType checkerType;
   private int color;

   public Checker(CheckerType CheckerType, int Color)
   {
      checkerType = CheckerType;
      color = Color;
      
      width1 = 333;
	  height1 = 333;
	   
	   // Marrim spritet
		  try
		  {   
			  BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream(
					  "/ChessSprites.gif"));    //// 
	  
			  for(int i = 0; i < 6; i++)  
			  {
				if(i == 0)
				{
					wking = spritesheet.getSubimage(i * width1, 0, width1, height1);
					bking = spritesheet.getSubimage(i * width1, height1, width1, height1);
				}
				if(i == 1) 
				{
			    	wqueen = spritesheet.getSubimage(i * width1, 0, width1, height1);
			    	bqueen = spritesheet.getSubimage(i * width1, height1, width1, height1);
				}				
			    if(i == 2)
			    {
			    	wofficer = spritesheet.getSubimage(i * width1, 0, width1, height1);
			    	bofficer = spritesheet.getSubimage(i * width1, height1, width1, height1);
			    }
			    if(i == 3) 
			    {
			    	whorse = spritesheet.getSubimage(i * width1, 0, width1, height1);
			    	bhorse = spritesheet.getSubimage(i * width1, height1, width1, height1);
			    }	
				if(i == 4)
				{
					wtower = spritesheet.getSubimage(i * width1, 0, width1, height1);
					btower = spritesheet.getSubimage(i * width1, height1, width1, height1);
				}
			    	
				if(i == 5)
				{
			    	wsoldier = spritesheet.getSubimage(i * width1, 0, width1, height1);
				    bsoldier = spritesheet.getSubimage(i * width1, height1, width1, height1);
				}
			
			  }
		  } 
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	  
      
   }

  
   public void draw(Graphics g, int cx, int cy)
   {
	   // Per vizatimin e drejtkendeshit(katorit ne kete rast) na duhet
	   // koordinata e cepit majtas lart te drejtkendeshit
	   // dhe kete koordinat e gjejme duke i zbritur x-it te qendres gjysmen e SQUAREDIM(gjeresia e katrorit(62))  
	   // , dhe per y i njeti veprim.

      int x1 = cx - Board.getSQUAREDIM()/2;   // SQUAREDIM = 62
      int y1 = cy - Board.getSQUAREDIM()/2;
      
      // Vizato gurin.
      
      if(checkerType == CheckerType.KING && color == 2)
      {
          g.drawImage(wking.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
       if(checkerType == CheckerType.KING && color == 1)
      {
    	  g.drawImage(bking.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      if(checkerType == CheckerType.QUEEN && color == 2)
      {
         g.drawImage(wqueen.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      if(checkerType == CheckerType.QUEEN && color == 1)
      {
         g.drawImage(bqueen.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      
      if(checkerType == CheckerType.OFFICER && color == 2)
      {
         g.drawImage(wofficer.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      if(checkerType == CheckerType.OFFICER && color == 1)
      {
         g.drawImage(bofficer.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
     
      if(checkerType == CheckerType.HORSE && color == 2)
      {
         g.drawImage(whorse.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      if(checkerType == CheckerType.HORSE && color == 1)
      {
         g.drawImage(bhorse.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      
      if(checkerType == CheckerType.TOWER && color == 2)
      {
         g.drawImage(wtower.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      if(checkerType == CheckerType.TOWER && color == 1)
      {
         g.drawImage(btower.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      
      if(checkerType == CheckerType.SOLDIER && color == 2)
      {
         g.drawImage(wsoldier.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
      if(checkerType == CheckerType.SOLDIER && color == 1)
      {
         g.drawImage(bsoldier.getScaledInstance(Board.getSQUAREDIM(), Board.getSQUAREDIM(), Image.SCALE_DEFAULT) , x1, y1, null);
      }
    
   }

   // Metode e nevojshme per te kontrolluar nqs nje pike e caktuar 
   // gjendet brenda nje katrori me gjeresi dhe gjatesi = SQUAREDIM  , (pika i ka koordinatat x,y
   // ndersa cx (centerx) dhe cy (centery) jane koordinatat e qendres se katorit 
   public static boolean contains(int x, int y, int cx, int cy)
   {
	   int x1 = cx - Board.getSQUAREDIM()/2;
	   int y1 = cy - Board.getSQUAREDIM()/2;
      return x > x1 &&  x < x1 + Board.getSQUAREDIM() && y > y1 && y < y1 + Board.getSQUAREDIM() ;
   }

   public static int getDimension()
   {
      return DIMENSION;
   }
   
   // Kthen llojin e gurit
   public CheckerType getCheckerType()  ///////////
   {
	   return checkerType;
   }
   // Kthen  ngjyren e gurit
   public int getColor()  ///////////
   {
	   return color;
   }
   
}