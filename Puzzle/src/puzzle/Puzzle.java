package puzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Puzzle extends JPanel implements ActionListener, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1387002269817355224L;
	
	public static int WIDTH = 800, HEIGHT = 500;
	
	public static int boardX = 0, boardY = 0;
	
	public static int posx = 0, posy = 0;
	
//	private boolean inDrag = false;
	
	public boolean firstSpace = false, space = false, up = false, down = false, left = false, right = false;
	
	static int x=0, y=0, width=0, height=0;
	private  int pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0, pos5 = 0, pos6 = 0, pos7 = 0, pos8 = 0, pos9 = 0;
    private boolean complete = false;
	
    static Puzzle p;
	private Square square1, square2, square3, square4, square5, square6, square7, square8, square9;
	private ArrayList<Square> squares = new ArrayList<Square>();
	private BufferedImage sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8, sq9;

	
	public Puzzle () {
		
/////////////////////////
try
{   
	
	// spritesheet image
BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream(
	  "/lion.jpg"));    //// 

for(int i = 0; i < 3; i++)  
{
    if(i == 0) {
    	sq1 = spritesheet.getSubimage(x, y,spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    	sq2 = spritesheet.getSubimage(x, y+spritesheet.getHeight()/3, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    	sq3 = spritesheet.getSubimage(x, y+(spritesheet.getHeight()/3)*2, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    }
    if(i == 1) {
    	sq4 = spritesheet.getSubimage(x+spritesheet.getWidth()/3, y, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    	sq5 = spritesheet.getSubimage(x+spritesheet.getWidth()/3,spritesheet.getHeight()/3, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    	sq6 = spritesheet.getSubimage(x+spritesheet.getWidth()/3, y+(spritesheet.getHeight()/3)*2, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    }
    if(i == 2) {
    	sq7 = spritesheet.getSubimage(x+(spritesheet.getWidth()/3)*2, y, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    	sq8 = spritesheet.getSubimage(x+(spritesheet.getWidth()/3)*2, y+spritesheet.getHeight()/3, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    	sq9 = spritesheet.getSubimage(x+(spritesheet.getWidth()/3)*2, y+(spritesheet.getHeight()/3)*2, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);
    //	SQ9 = spritesheet.getSubimage(x+(spritesheet.getWidth()/3)*2, y+(spritesheet.getHeight()/3)*2, spritesheet.getWidth()/3 , spritesheet.getHeight()/3);

    }
	  
}

           width = sq1.getWidth();
           height = sq1.getHeight();
} 
catch(Exception e)
{
e.printStackTrace();
}

        // fill the arrayList with squares		
		square1 = new Square(x, y, width, height, sq1, 0 , true);
		squares.add(square1);
		square2 = new Square(x, y+height, width, height, sq2, 1 , true);
		squares.add(square2);
		square3 = new Square(x, y+(height*2), width, height, sq3, 2 , true );
		squares.add(square3);
		square4 = new Square(x+width, y, width, height, sq4, 3, true );
		squares.add(square4);
		square5 = new Square(x+width, y+height, width, height, sq5, 4 , true);
		squares.add(square5);
		square6 = new Square(x+width, y+(height*2), width, height, sq6, 5 , true);
		squares.add(square6);
    	square7 = new Square(x+(width*2), y, width, height, sq7, 6 , true);
		squares.add(square7);
		square8 = new Square(x+(width*2), y+height, width, height, sq8, 7 , true);
		squares.add(square8);
		square9 = new Square(x+(width*2), y+(height*2), width, height, sq9, 8 , true);
		squares.add(square9);
		

		JFrame jf = new JFrame("Puzzle");
		jf.setVisible(true);
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		
		jf.addKeyListener(this);
        //add actionListener
		jf.add(this);
		
		jf.addMouseMotionListener(new MouseMotionAdapter()
	      {
	    	  public void mouseMoved(MouseEvent me)
	          {
	             repaint();
	    		  
	          } 
	      });
	 
		jf.addMouseListener(new MouseAdapter()
        {      

           @Override
           public void mousePressed(MouseEvent me)
           {
        	   if( me.getX() >= boardX && me.getX() <= boardX + (width*3) && me.getY() >= boardY && me.getY() <= boardY + (height*3) )
        	   {
        		   System.out.println("WORKS");
        		  
        	   }
           }
           @Override
           public void mouseReleased(MouseEvent me)
           {
        	  
           }
		
        });
		
		jf.addMouseListener(new MouseAdapter()
        {      

           @Override
           public void mouseDragged(MouseEvent me)
           {
        	  
        		   
        		   boardX = boardX + ( me.getX() - posx);
        		   boardY = boardY + (  me.getY() - posy);
        		   repaint();
        	
        	   
           }
		
        });
		
	}

	public void actionPerformed(ActionEvent arg0) {

		// repaint();
	}
	


	public void keyPressed(KeyEvent e) {

		System.out.println(e.getKeyCode());
	
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if(boardX < WIDTH-(width*3))
			boardX = boardX + 10;
			else
				boardX = WIDTH-(width*3);
		
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			
            if(boardX > 0)
			boardX = boardX - 10;
            else
            	boardX = 0;
       
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
            
			if(boardY < HEIGHT-(height*3)-32)
			boardY = boardY + 10;
			else
				boardY = HEIGHT-(height*3)-32;
		
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
            if(boardY > 0)
			boardY = boardY - 10;
            else
            	boardY = 0;
			
		}
      
		 if(e.getKeyCode() == KeyEvent.VK_LEFT) {
		     
			 int nr = 0;
			 if(!complete)
			 for(int i = 3; i < 9; i++) { 
		    	if(nr == 0)
				 if(squares.get(i-3).getTaken() == false) {

					 squares.get(i-3).setImage(squares.get(i).getImage());
					 squares.get(i-3).setTaken(true);
					 squares.get(i).setImage(null);
					 squares.get(i).setTaken(false);
	                 nr++;
					 
				  }
				 
			 } // end for
		
       } // end if left
		 
		 if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
			 if(!complete)
			 for(int i = 0; i < 6; i++) {

				 if(squares.get(i+3).getTaken() == false) {

					 squares.get(i+3).setImage(squares.get(i).getImage());
					 squares.get(i+3).setTaken(true);
					 squares.get(i).setImage(null);
					 squares.get(i).setTaken(false);
	
				  }
				 
			 } // end for

		
       } // end if right
		 
		 if(e.getKeyCode() == KeyEvent.VK_DOWN) {

			 if(!complete)
			 for(int i = 0; i < 9; i++) {
		
				 if( i!=0 && i!=3 && i!=6 )
				 if(squares.get(i).getTaken() == false && squares.get(i).getX()==squares.get(i-1).getX() ) {

					 squares.get(i).setImage(squares.get(i-1).getImage());
					 squares.get(i).setTaken(true);
					 squares.get(i-1).setImage(null);
					 squares.get(i-1).setTaken(false);
					 
	
				  }
				 
			 } // end for

       } // end if down
		 
		 if(e.getKeyCode() == KeyEvent.VK_UP) {
			 int nr1 = 0;
			 if(!complete)
			 for(int i = 0; i < 9; i++) {
		         
				 if( nr1 == 0 && ( i!=2 && i!=5 && i!=8 ))
				 if(squares.get(i).getTaken() == false && squares.get(i).getX()==squares.get(i+1).getX() ) {

					 squares.get(i).setImage(squares.get(i+1).getImage());
					 squares.get(i).setTaken(true);
					 squares.get(i+1).setImage(null);
					 squares.get(i+1).setTaken(false);
					 nr1++;
	
				  }
				 
			 } // end for
		  
       } // end if up

			
		 if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			 
			 squares.get(0).setImage(sq1);
			 squares.get(0).setTaken(true);
			 squares.get(1).setImage(sq2);
			 squares.get(1).setTaken(true);
			 squares.get(2).setImage(sq3);
			 squares.get(2).setTaken(true);
			 squares.get(3).setImage(sq4);
			 squares.get(3).setTaken(true);
			 squares.get(4).setImage(sq5);
			 squares.get(4).setTaken(true);
			 squares.get(5).setImage(sq6);
			 squares.get(5).setTaken(true);
			 squares.get(6).setImage(sq7);
			 squares.get(6).setTaken(true);
			 squares.get(7).setImage(sq8);
			 squares.get(7).setTaken(true);
			 squares.get(8).setImage(sq9);
			 squares.get(8).setTaken(true);
			 
			 complete = true;
			 
		 }
		 
		 
		Random rand = new Random();

		 if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			 
			complete = false;

					pos1 = rand.nextInt(8);
					     pos2 = rand.nextInt(8);
				         while(pos2 == pos1)
				    	     pos2 = rand.nextInt(8);
					     pos3 = rand.nextInt(8);
					     while(pos3 == pos1 || pos3 == pos2)
					    	 pos3 = rand.nextInt(8);
				         pos4 = rand.nextInt(8);
					     while(pos4 == pos1 || pos4 == pos2 || pos4 == pos3)
					    	 pos4 = rand.nextInt(8);
					 	 pos5 = rand.nextInt(8);
					     while(pos5 == pos1 || pos5 == pos2 || pos5 == pos3 || pos5 == pos4)
					    	 pos5 = rand.nextInt(8);
						pos6 = rand.nextInt(8);
					    while(pos6 == pos1 || pos6 == pos2 || pos6 == pos3 || pos6 == pos4 || pos6 == pos5)
						     pos6 = rand.nextInt(8);
						pos7 = rand.nextInt(8);
						while(pos7 == pos1 || pos7 == pos2 || pos7 == pos3 || pos7 == pos4 || pos7 == pos5 || pos7 == pos6)
					    	 pos7 = rand.nextInt(8);
						pos8 = rand.nextInt(8);
						while(pos8 == pos1 || pos8 == pos2 || pos8 == pos3 || pos8 == pos4 || pos8 == pos5 
								|| pos8 == pos6 || pos8 == pos7)
					    	 pos8 = rand.nextInt(8);
						
						pos9 = 8;			
						
						/////////////////
						squares.get(pos1).setImage(sq1);
						squares.get(pos1).setTaken(true);
						squares.get(pos2).setImage(sq2);
						squares.get(pos2).setTaken(true);
						squares.get(pos3).setImage(sq3);
						squares.get(pos3).setTaken(true);
						squares.get(pos4).setImage(sq4);
						squares.get(pos4).setTaken(true);
						squares.get(pos5).setImage(sq5);
						squares.get(pos5).setTaken(true);
						squares.get(pos6).setImage(sq6);
						squares.get(pos6).setTaken(true);
						squares.get(pos7).setImage(sq7);
						squares.get(pos7).setTaken(true);
						squares.get(pos8).setImage(sq8);
						squares.get(pos8).setTaken(true);
						
						squares.get(pos9).setImage(null);   
						squares.get(pos9).setTaken(false);		
        
		} 
		 
		 // win condition
         if(squares.get(0).getImage() == sq1 && squares.get(1).getImage() == sq2
         	&& squares.get(2).getImage() == sq3 && squares.get(3).getImage() == sq4
         	&& squares.get(4).getImage() == sq5 && squares.get(5).getImage() == sq6
         	&& squares.get(6).getImage() == sq7 && squares.get(7).getImage() == sq8
         	&& squares.get(8).getImage() == null ) {
         	
         	complete = true;
         	
         	squares.get(8).setImage(sq9);
         	
         }
		 
		 repaint();
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

	//////////////////
		for(Square square: squares) {
			
			if(square.getImage() == null)
				g.drawRect(square.getX()+boardX, square.getY()+boardY, square.getWidth(), square.getHeight());
			else
			g.drawImage(square.getImage().getScaledInstance(square.getWidth(), square.getHeight(), Image.SCALE_DEFAULT),
					square.getX()+boardX, square.getY()+boardY, null );
			
		}
		
		
		if(complete) {
			g.setFont(new Font( "serial", Font.BOLD, 15 ));
			g.setColor(Color.RED);
			g.drawString("WELL DONE!! JE NONA FARE!!", 300, 300);
		}
			
		
	}
	
	
	public void keyReleased(KeyEvent key) {
       
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
	
	public static void main(String[] args) {
		
		p = new Puzzle();
	  
		
		
	}

	

}
