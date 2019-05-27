package Main;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

// import Audio.AudioPlayer;
import Card.Card;

	public class Game  implements ActionListener, MouseListener
	{
	    public int bluePoints , redPoints, greenPoints, yellowPoints, brownPoints, purplePoints;  // blackPoints
		public int firstCardX = 320 - 69; /// 
        public int firstCardY = 322;
        public int round;
        public int playerHealth = 400, bossHealth = 4000;
        public int playerDamage = 2000, bossDamage = 50;
        public int bossDamageReceived = 0, playerDamageReceived = 0, playerTotalHealth = 400;
    //   public boolean thirdUp;
		public static boolean firstIsTaken = false, secondIsTaken = false, thirdIsTaken = false;
        
		private BufferedImage image;
		private BufferedImage cardIm;
		
		
		private BufferedImage red1;
		private BufferedImage red1top;
		private BufferedImage blue1;
		private BufferedImage blue1top;
		private BufferedImage green1;
		private BufferedImage green1top;
		private BufferedImage yellow1;
		private BufferedImage yellow1top;
		private BufferedImage brown1;
		private BufferedImage brown1top;
		private BufferedImage purple1;
		private BufferedImage purple1top;
		private BufferedImage black;
		private BufferedImage blacktop;
		
		private BufferedImage red2;
		private BufferedImage red2top;
		private BufferedImage blue2;
		private BufferedImage blue2top;
		private BufferedImage green2;
		private BufferedImage green2top;
		private BufferedImage yellow2;
		private BufferedImage yellow2top;
		private BufferedImage brown2;
		private BufferedImage brown2top;
		private BufferedImage purple2;
		private BufferedImage purple2top;
		
		
		
		private BufferedImage red3;
		private BufferedImage red3top;
		private BufferedImage blue3;
		private BufferedImage blue3top;
		private BufferedImage green3;
		private BufferedImage green3top;
		private BufferedImage yellow3;
		private BufferedImage yellow3top;
		private BufferedImage brown3;
		private BufferedImage brown3top;
		private BufferedImage purple3;
		private BufferedImage purple3top;
	
		
		private BufferedImage red4;
		private BufferedImage red4top;
		private BufferedImage blue4;
		private BufferedImage blue4top;
		private BufferedImage green4;
		private BufferedImage green4top;
		private BufferedImage yellow4;
		private BufferedImage yellow4top;
		private BufferedImage brown4;
		private BufferedImage brown4top;
		private BufferedImage purple4;
		private BufferedImage purple4top;
		
		private BufferedImage red5;
		private BufferedImage red5top;
		private BufferedImage blue5;
		private BufferedImage blue5top;
		private BufferedImage green5;
		private BufferedImage green5top;
		private BufferedImage yellow5;
		private BufferedImage yellow5top;
		private BufferedImage brown5;
		private BufferedImage brown5top;
		private BufferedImage purple5;
		private BufferedImage purple5top;
		
		private BufferedImage red6;
		private BufferedImage red6top;
		private BufferedImage blue6;
		private BufferedImage blue6top;
		private BufferedImage green6;
		private BufferedImage green6top;
		private BufferedImage yellow6;
		private BufferedImage yellow6top;
		private BufferedImage brown6;
		private BufferedImage brown6top;
		private BufferedImage purple6;
		private BufferedImage purple6top;
		
		private BufferedImage red7;
		private BufferedImage red7top;
		private BufferedImage blue7;
		private BufferedImage blue7top;
		private BufferedImage green7;
		private BufferedImage green7top;
		private BufferedImage yellow7;
		private BufferedImage yellow7top;
		private BufferedImage brown7;
		private BufferedImage brown7top;
		private BufferedImage purple7;
		private BufferedImage purple7top;
		
		private BufferedImage red8;
		private BufferedImage red8top;
		private BufferedImage blue8;
		private BufferedImage blue8top;
		private BufferedImage green8;
		private BufferedImage green8top;
		private BufferedImage yellow8;
		private BufferedImage yellow8top;
		private BufferedImage brown8;
		private BufferedImage brown8top;
		private BufferedImage purple8;
		private BufferedImage purple8top;
		
		private BufferedImage red9;
		private BufferedImage red9top;
		private BufferedImage blue9;
		private BufferedImage blue9top;
		private BufferedImage green9;
		private BufferedImage green9top;
		private BufferedImage yellow9;
		private BufferedImage yellow9top;
		private BufferedImage brown9;
		private BufferedImage brown9top;
		private BufferedImage purple9;
		private BufferedImage purple9top;
		
		
		public Graphics g;
		public ArrayList <Card> tableCards;
		public ArrayList <Card> randomCards;
		public ArrayList <Position> comingCards;
		public static ArrayList <Position> cardPositions;
		public static Position position;
		public Card card;
		public Color brown;
		// audio
	//	private AudioPlayer bgMusic;
		
		public JButton start;

	    private boolean inClick = false;
	    
	   public static int clickN = 0;
	   public Position firstC = position , secondC = position , thirdC = position;
       
		
		public static Game game;

		public final int WIDTH = 750, HEIGHT = 740;

		public Renderer renderer;

		public int ticks, yMotion, score;

		public boolean gameOver, started;

		public Random randColor;
		public Random randNumber;
		
	//	 public int k = 0;

		public Game()
		{
			gameOver = false;
		    start = new JButton();
			 randColor = new Random();
			 randNumber = new Random();
			
			 randomCards = new ArrayList<Card>();

			comingCards = new ArrayList<Position>();
	
			cardPositions = new ArrayList<Position>();
			
			 bluePoints = 0; redPoints = 0; greenPoints = 0; yellowPoints = 0;  brownPoints = 0; purplePoints = 0;
			 round = 0;
		//	 brown = new Color(64,0,0);
			 
	 
			 try
				{
					// importing resource files into the game
				 image = ImageIO.read(getClass().getResourceAsStream("/Backgrounds/digimonbg.jpg"));
				 
				 red1 = ImageIO.read(getClass().getResourceAsStream("/Cards/1red.png"));
				 blue1 = ImageIO.read(getClass().getResourceAsStream("/Cards/1blue.png"));
				 green1 = ImageIO.read(getClass().getResourceAsStream("/Cards/1green.png"));
				 yellow1 = ImageIO.read(getClass().getResourceAsStream("/Cards/1yellow.png"));
				 purple1 = ImageIO.read(getClass().getResourceAsStream("/Cards/1purple.png"));
				 brown1 = ImageIO.read(getClass().getResourceAsStream("/Cards/1brown.png"));
				 
				 black = ImageIO.read(getClass().getResourceAsStream("/Cards/black.png"));
				 
				 red2 = ImageIO.read(getClass().getResourceAsStream("/Cards/2red.png"));
				 blue2 = ImageIO.read(getClass().getResourceAsStream("/Cards/2blue.png"));
				 green2 = ImageIO.read(getClass().getResourceAsStream("/Cards/2green.png"));
				 yellow2 = ImageIO.read(getClass().getResourceAsStream("/Cards/2yellow.png"));
				 purple2 = ImageIO.read(getClass().getResourceAsStream("/Cards/2purple.png"));
				 brown2 = ImageIO.read(getClass().getResourceAsStream("/Cards/2brown.png"));
				 
				 red3 = ImageIO.read(getClass().getResourceAsStream("/Cards/3red.png"));
				 blue3 = ImageIO.read(getClass().getResourceAsStream("/Cards/3blue.png"));
				 green3 = ImageIO.read(getClass().getResourceAsStream("/Cards/3green.png"));
				 yellow3 = ImageIO.read(getClass().getResourceAsStream("/Cards/3yellow.png"));
				 purple3 = ImageIO.read(getClass().getResourceAsStream("/Cards/3purple.png"));
				 brown3 = ImageIO.read(getClass().getResourceAsStream("/Cards/3brown.png"));
				 
				 red4 = ImageIO.read(getClass().getResourceAsStream("/Cards/4red.png"));
				 blue4 = ImageIO.read(getClass().getResourceAsStream("/Cards/4blue.png"));
				 green4 = ImageIO.read(getClass().getResourceAsStream("/Cards/4green.png"));
				 yellow4 = ImageIO.read(getClass().getResourceAsStream("/Cards/4yellow.png"));
				 purple4 = ImageIO.read(getClass().getResourceAsStream("/Cards/4purple.png"));
				 brown4 = ImageIO.read(getClass().getResourceAsStream("/Cards/4brown.png"));
				 
				 red5 = ImageIO.read(getClass().getResourceAsStream("/Cards/5red.png"));
				 blue5 = ImageIO.read(getClass().getResourceAsStream("/Cards/5blue.png"));
				 green5 = ImageIO.read(getClass().getResourceAsStream("/Cards/5green.png"));
				 yellow5 = ImageIO.read(getClass().getResourceAsStream("/Cards/5yellow.png"));
				 purple5 = ImageIO.read(getClass().getResourceAsStream("/Cards/5purple.png"));
				 brown5 = ImageIO.read(getClass().getResourceAsStream("/Cards/5brown.png"));
				 
				 red6 = ImageIO.read(getClass().getResourceAsStream("/Cards/6red.png"));
				 blue6 = ImageIO.read(getClass().getResourceAsStream("/Cards/6blue.png"));
				 green6 = ImageIO.read(getClass().getResourceAsStream("/Cards/6green.png"));
				 yellow6 = ImageIO.read(getClass().getResourceAsStream("/Cards/6yellow.png"));
				 purple6 = ImageIO.read(getClass().getResourceAsStream("/Cards/6purple.png"));
				 brown6 = ImageIO.read(getClass().getResourceAsStream("/Cards/6brown.png"));
				 
				 red7 = ImageIO.read(getClass().getResourceAsStream("/Cards/7red.png"));
				 blue7 = ImageIO.read(getClass().getResourceAsStream("/Cards/7blue.png"));
				 green7 = ImageIO.read(getClass().getResourceAsStream("/Cards/7green.png"));
				 yellow7 = ImageIO.read(getClass().getResourceAsStream("/Cards/7yellow.png"));
				 purple7 = ImageIO.read(getClass().getResourceAsStream("/Cards/7purple.png"));
				 brown7 = ImageIO.read(getClass().getResourceAsStream("/Cards/7brown.png"));
				 
				 red8 = ImageIO.read(getClass().getResourceAsStream("/Cards/8red.png"));
				 blue8 = ImageIO.read(getClass().getResourceAsStream("/Cards/8blue.png"));
				 green8 = ImageIO.read(getClass().getResourceAsStream("/Cards/8green.png"));
				 yellow8 = ImageIO.read(getClass().getResourceAsStream("/Cards/8yellow.png"));
				 purple8 = ImageIO.read(getClass().getResourceAsStream("/Cards/8purple.png"));
				 brown8 = ImageIO.read(getClass().getResourceAsStream("/Cards/8brown.png"));
				 
				 red9 = ImageIO.read(getClass().getResourceAsStream("/Cards/9red.png"));
				 blue9 = ImageIO.read(getClass().getResourceAsStream("/Cards/9blue.png"));
				 green9 = ImageIO.read(getClass().getResourceAsStream("/Cards/9green.png"));
				 yellow9 = ImageIO.read(getClass().getResourceAsStream("/Cards/9yellow.png"));
				 purple9 = ImageIO.read(getClass().getResourceAsStream("/Cards/9purple.png"));
				 brown9 = ImageIO.read(getClass().getResourceAsStream("/Cards/9brown.png"));
				
				
				 // get subimages for top coming cards
				 
				 red1top = red1.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 red2top = red2.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 red3top = red3.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 red4top = red4.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 red5top = red5.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 red6top = red6.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 red7top = red7.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 red8top = red8.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 red9top = red9.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 
				 
				 blue1top = blue1.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 blue2top = blue2.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 blue3top = blue3.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 blue4top = blue4.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 blue5top = blue5.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 blue6top = blue6.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 blue7top = blue7.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 blue8top = blue8.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 blue9top = blue9.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 
				 
				 green1top = green1.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 green2top = green2.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 green3top = green3.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 green4top = green4.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 green5top = green5.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 green6top = green6.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 green7top = green7.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 green8top = green8.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 green9top = green9.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 
				 
				 yellow1top = yellow1.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 yellow2top = yellow2.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 yellow3top = yellow3.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 yellow4top = yellow4.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 yellow5top = yellow5.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 yellow6top = yellow6.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 yellow7top = yellow7.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 yellow8top = yellow8.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 yellow9top = yellow9.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 
				 
				 purple1top = purple1.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 purple2top = purple2.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 purple3top = purple3.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 purple4top = purple4.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 purple5top = purple5.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 purple6top = purple6.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 purple7top = purple7.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 purple8top = purple8.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 purple9top = purple9.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 
				 
				 brown1top = brown1.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 brown2top = brown2.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 brown3top = brown3.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 brown4top = brown4.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 brown5top = brown5.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 brown6top = brown6.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 brown7top = brown7.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 brown8top = brown8.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 brown9top = brown9.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 
				 blacktop = black.getSubimage(0, (Card.getCardHeight())-(Card.getCardHeight())/3 , Card.getCardWidth(), Card.getCardHeight()/3);
				 
				 
				 
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			 
			randomCards();
			comingCards();
			cardPositions();
            
		
	   
		   
		    JFrame jframe = new JFrame();
		  	Timer timer = new Timer(20, this);
		  	
		  	renderer=new Renderer();
		  
		  	jframe.add(renderer);
		  	jframe.setTitle("Digimon Heros");
		  	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  	jframe.setSize(WIDTH,HEIGHT);
		  	jframe.addMouseListener(this); //
		  	jframe.setResizable(false);
		  	jframe.setVisible(true);
		  		
	     	timer.start();
			
		}
		
		public void randomCards()
		{
		 // mbushe listen me 14 letra random
	      while(randomCards.size() < 14)
		  {	
			int randomColor = 1 + randColor.nextInt(13);
			int randomNumber = 1 + randColor.nextInt(9);
			String color = "white";

			if(randomColor == 1 || randomColor == 2 )
			{
				color = "red";
			}
			if(randomColor == 3 || randomColor == 4)
			{
				color = "green";
			}
			if(randomColor == 5 || randomColor == 6 )
			{
				color = "blue";
			}
			if(randomColor == 7 || randomColor == 8)
			{
				color = "yellow";
			}
			if(randomColor == 9 || randomColor == 10 )
			{
				color = "purple";
			}
			if(randomColor == 11 || randomColor == 12 )
			{
				color = "brown";  
			}
			if(randomColor == 13)
			{
				color = "black";
			}
			

				// fut letra random 
			if(color == "black")
				randomCards.add(new Card(color, 10));
			else
				randomCards.add(new Card(color, randomNumber));
			
		//		k++;
		  }	// While
		
		}	 
		
	
		
		public void comingCards()
		{
				
			int pos = 0;
			
			 if(comingCards.isEmpty()  )
			 {
				
			     for(int i = 12;i > 0; i--)
			     {
			    	 position = new Position();
			   //  int= i+1;
			    	 position.card = new Card(randomCards.get(randomCards.size()-i).getCardColor() , randomCards.get(randomCards.size()-i).getCardNumber()  );
			  ///  	 randomCards.remove(randomCards.size()-j); //////////////////////
			    	 position.isTop = true;
					 position.x = firstCardX + pos*Card.getCardWidth()/3;
					 pos++;
				     position.y = firstCardY;
				     
				     comingCards.add(position);
				   				     			     
			     }
						
			   			     
		     }
		}	 
	/*	
		public void moveComingCardsForward()
		{
			  if(comingCards.size() < 12)
				     for(Position pos1 : comingCards)
					    {
					    	pos1.x = pos1.x + Card.getCardWidth()/3;
					    }
		              
		}
		
		
		public void  moveComingCardsBackwards()
		{
			  if(comingCards.size() < 12)
				     for(Position pos1 : comingCards)
					    {
					    	pos1.x = pos1.x - Card.getCardWidth()/3;
					    }
		              
		}
	*/	
		
		
		public void cardPositions()
		{	
	      
		 	
			int space = 10;
			int fRowPositionX = 200;
			int fRowPositionY = 450 + 5;
			int sRowPositionX = 200;
			int sRowPositionY =  450 + 5 + Card.getCardHeight() + space; // firstPositionX + space + card.getCardHeight();
			
		//	int t = comingCards.size()-1;
			for(int i = 0; i < 5; i++)
			{	
		       
			    position = new Position();
			  
	        //    position.card = new Card(comingCards.get(t).card.getCardColor(), comingCards.get(t).card.getCardNumber());
			    position.card = null;  ////////////
	            position.x = sRowPositionX + i*space + i*Card.getCardWidth();
			    position.y = sRowPositionY;
			    position.oldX = position.x;
			    position.oldY = position.y;
			    
			    position.isTaken = true;
			    cardPositions.add(position);
			//    comingCards.remove(comingCards.get(t));  //////
		//	    t--;
			      
              }
			
              for(int i = 5; i < 10; i++)   /// merri letrat nga fundi
  			  {	
 	 
               position = new Position();
                int j = i - 5;
             //     position.card = new Card(comingCards.get(t).card.getCardColor(), comingCards.get(t).card.getCardNumber());
                
                position.card = null;
                  position.x = fRowPositionX + j*space + j*Card.getCardWidth();
  			      position.y = fRowPositionY;
  			      position.oldX = position.x;
			      position.oldY = position.y;
  			      
  			    position.isTaken = true;
  			    cardPositions.add(position);
  			    
  		//	  comingCards.remove(comingCards.get(t));  //////
  			randomCards.remove(randomCards.size()-1);  
  		//	  k--;
  		//	    t--;
	  
              }     
			
		}     
		
		
	      public void checkCardPositions() 
	      {
	    	 
	    	  for(Position pos : cardPositions)
	    	  {
	    		  if(pos.card == null && !comingCards.isEmpty() && comingCards.get(comingCards.size()-1).card != null) // == null
	    		  {
			
	    		//	  moveComingCardsForward();
	    		//	  cHeight = Card.getCardHeight();  /////////
	    			//  pos.card = comingCards.get(comingCards.size()-1).card;
	    			//  pos.card = comingCards.get(comingCards.size()-1).card;
	    			   		
	    			  int lastX = comingCards.get(comingCards.size()-1).x;
	    			  int lastY = comingCards.get(comingCards.size()-1).y;
	    			  
	    	          comingCards.get(comingCards.size()-1).x = pos.x;
	    	          comingCards.get(comingCards.size()-1).y = pos.y;
	    			  comingCards.get(comingCards.size()-1).isTop = false;
	    	         
	    			   pos.card = comingCards.get(comingCards.size()-1).card;
		    		   pos.card = comingCards.get(comingCards.size()-1).card;
		    		   
		    		   
		    		   comingCards.get(comingCards.size()-1).card = null;
		    		   comingCards.get(comingCards.size()-1).isTop = true;
		    		   comingCards.get(comingCards.size()-1).x = lastX;           ///   comingCards.get(comingCards.size()-1).oldX;
		    		   comingCards.get(comingCards.size()-1).y = lastY;           ///   comingCards.get(comingCards.size()-1).oldY;
		    		   
		    		   
		    		//   comingCards.remove(comingCards.size()-1);
		    		   
	    	  //        
	    	          
	    		  }
	    	  }
	    		  
	      }
	      
	      public void checkComingCards()  ///////////////////// using
	      {
	    	 
	    		  for(int i = comingCards.size()-1 ; i > 0; i--)
	    		  {
	    			  int j = i-1;
	    			  comingCards.get(i).card = comingCards.get(j).card;
	    			  comingCards.get(j).card = null;
	    		
	    		  }
	    	
	      }
	   
	      public void addComingCards()
	      {
	    	  if(comingCards.get(0).card == null)
	    	  {
	    		  
	    		  comingCards.get(0).card = randomCards.get(randomCards.size()-1);
	    			randomCards.remove(randomCards.get(randomCards.size()-1));
	    		//	k--;
	    			randomCards();
	    	  }
	    	  
	      }
	      
	/*      
	      public void checkClicked()  /////////// not using
	      {
	    	 
	    		  for(Position pos : cardPositions)
		    	  {
		    		  if(pos.isMoved && !comingCards.isEmpty())
		    		  {
				
		    			//moveComingCardsForward();
		    		//	  cHeight = Card.getCardHeight();  /////////
		    			//  pos.card = comingCards.get(comingCards.size()-1).card;
		    			//  pos.card = comingCards.get(comingCards.size()-1).card;
		    			   			  
		    	          comingCards.get(comingCards.size()-1).x = pos.oldX;
		    	          comingCards.get(comingCards.size()-1).y = pos.oldY;
		    			  comingCards.get(comingCards.size()-1).isTop = false;
		    	         
		    			   pos.card = comingCards.get(comingCards.size()-1).card;
			    		   pos.card = comingCards.get(comingCards.size()-1).card;
			    		// comingCards.remove(comingCards.size()-1);
			    		   
		    	  //        
		    	          
		    		  }
	    		  
	    	  }
	    	  
	      
	    }
	      */

		public void paintTableCards(Graphics g , Position pos )
		{
			if(pos.card != null)
			{
			  // g.setColor(pos.card.getCardColor());
			//   g.fillRect(pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight() );
				
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 1)
			        g.drawImage(red1, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 2)
			        g.drawImage(red2, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 3)
			        g.drawImage(red3, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 4)
			        g.drawImage(red4, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 5)
			        g.drawImage(red5, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 6)
			        g.drawImage(red6, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 7)
			        g.drawImage(red7, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 8)
			        g.drawImage(red8, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 9)
			        g.drawImage(red9, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 1)
			        g.drawImage(blue1, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 2)
			        g.drawImage(blue2, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 3)
			        g.drawImage(blue3, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 4)
			        g.drawImage(blue4, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 5)
			        g.drawImage(blue5, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 6)
			        g.drawImage(blue6, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 7)
			        g.drawImage(blue7, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 8)
			        g.drawImage(blue8, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 9)
			        g.drawImage(blue9, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 1)
			        g.drawImage(green1, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 2)
			        g.drawImage(green2, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 3)
			        g.drawImage(green3, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 4)
			        g.drawImage(green4, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 5)
			        g.drawImage(green5, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 6)
			        g.drawImage(green6, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 7)
			        g.drawImage(green7, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 8)
			        g.drawImage(green8, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 9)
			        g.drawImage(green9, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 1)
			        g.drawImage(yellow1, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 2)
			        g.drawImage(yellow2, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 3)
			        g.drawImage(yellow3, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 4)
			        g.drawImage(yellow4, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 5)
			        g.drawImage(yellow5, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 6)
			        g.drawImage(yellow6, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 7)
			        g.drawImage(yellow7, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 8)
			        g.drawImage(yellow8, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 9)
			        g.drawImage(yellow9, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 1)
			        g.drawImage(brown1, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 2)
			        g.drawImage(brown2, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 3)
			        g.drawImage(brown3, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 4)
			        g.drawImage(brown4, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 5)
			        g.drawImage(brown5, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 6)
			        g.drawImage(brown6, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 7)
			        g.drawImage(brown7, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 8)
			        g.drawImage(brown8, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 9)
			        g.drawImage(brown9, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 1)
			        g.drawImage(purple1, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 2)
			        g.drawImage(purple2, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 3)
			        g.drawImage(purple3, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 4)
			        g.drawImage(purple4, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 5)
			        g.drawImage(purple5, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 6)
			        g.drawImage(purple6, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 7)
			        g.drawImage(purple7, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 8)
			        g.drawImage(purple8, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 9)
			        g.drawImage(purple9, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				
				if(pos.card.getCardColor() == "black" ) // pos.card.getCardNumber() == 9
			        g.drawImage(black, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight(), null);
				
				
			/*   
			   g.setColor(Color.orange);
			   g.setFont(new Font("default", Font.BOLD, 16));
			   g.drawString("" + pos.card.getCardNumber(),pos.x + 5 , pos.y + 17);
			   g.drawString("" + pos.card.getCardNumber(), pos.x + Card.getCardWidth() - 13,
					pos.y + Card.getCardHeight() - 5);
			  
			   // korniza letrave
			   g.setColor(Color.orange);
			   g.drawRect(pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight());
			  
		     	*/
			}
		}
		
		public void paintComingCards(Graphics g , Position pos )
		{
			if(pos.card != null)                  //   int cHeight = card.getCardHeight()/3;
			{
		     if(pos.isTop)
		     {
		      //   g.setColor(pos.card.getCardColor());
		      
			//  g.fillRect(pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3 );
		    	 
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 1)
			         g.drawImage(red1top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 2)
			         g.drawImage(red2top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 3)
			         g.drawImage(red3top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 4)
			         g.drawImage(red4top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 5)
			         g.drawImage(red5top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 6)
			         g.drawImage(red6top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 7)
			         g.drawImage(red7top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 8)
			         g.drawImage(red8top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "red" && pos.card.getCardNumber() == 9)
			         g.drawImage(red9top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 1)
			         g.drawImage(blue1top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 2)
			         g.drawImage(blue2top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 3)
			         g.drawImage(blue3top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 4)
			         g.drawImage(blue4top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 5)
			         g.drawImage(blue5top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 6)
			         g.drawImage(blue6top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 7)
			         g.drawImage(blue7top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 8)
			         g.drawImage(blue8top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "blue" && pos.card.getCardNumber() == 9)
			         g.drawImage(blue9top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 1)
			         g.drawImage(green1top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 2)
			         g.drawImage(green2top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 3)
			         g.drawImage(green3top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 4)
			         g.drawImage(green4top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 5)
			         g.drawImage(green5top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 6)
			         g.drawImage(green6top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 7)
			         g.drawImage(green7top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 8)
			         g.drawImage(green8top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "green" && pos.card.getCardNumber() == 9)
			         g.drawImage(green9top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 
		    	 
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 1)
			         g.drawImage(brown1top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 2)
			         g.drawImage(brown2top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 3)
			         g.drawImage(brown3top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 4)
			         g.drawImage(brown4top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 5)
			         g.drawImage(brown5top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 6)
			         g.drawImage(brown6top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 7)
			         g.drawImage(brown7top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 8)
			         g.drawImage(brown8top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "brown" && pos.card.getCardNumber() == 9)
			         g.drawImage(brown9top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 1)
			         g.drawImage(purple1top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 2)
			         g.drawImage(purple2top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 3)
			         g.drawImage(purple3top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 4)
			         g.drawImage(purple4top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 5)
			         g.drawImage(purple5top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 6)
			         g.drawImage(purple6top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 7)
			         g.drawImage(purple7top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 8)
			         g.drawImage(purple8top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "purple" && pos.card.getCardNumber() == 9)
			         g.drawImage(purple9top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 1)
			         g.drawImage(yellow1top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 2)
			         g.drawImage(yellow2top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 3)
			         g.drawImage(yellow3top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 4)
			         g.drawImage(yellow4top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 5)
			         g.drawImage(yellow5top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 6)
			         g.drawImage(yellow6top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 7)
			         g.drawImage(yellow7top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 8)
			         g.drawImage(yellow8top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 if(pos.card.getCardColor() == "yellow" && pos.card.getCardNumber() == 9)
			         g.drawImage(yellow9top, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 
		    	 
		    	 
		    	 if(pos.card.getCardColor() == "black" )     //  && pos.card.getCardNumber() == 9
			         g.drawImage(blacktop, pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight()/3, null);
		    	 
		    	 
			/*
			  g.setColor(Color.orange);
			  g.setFont(new Font("default", Font.BOLD, 16));
		  //  g.drawString("" + pos.card.getCardNumber(), pos.x + 5, pos.y + 17);
			  g.drawString("" + pos.card.getCardNumber(), pos.x + Card.getCardWidth() - 13,    //pos.x + 5 
					pos.y + Card.getCardHeight()/3 - 5);
			
		    // korniza letrave
		       g.setColor(Color.orange); 
		    	      g.drawRect(pos.x, pos.y, Card.getCardWidth(),Card.getCardHeight()/3);

		         g.setColor(Color.black);   ////////// new Color(100,100,100)
			     g.drawLine(pos.x, pos.y, pos.x + Card.getCardWidth(), pos.y);
               */
			}
		     
		    /*
		     else
		       {
				g.setColor(pos.card.getCardColor());
			      
				  g.fillRect(pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight() );
				
				  g.setColor(Color.white);
				  g.setFont(new Font("default", Font.BOLD, 16));
			  //  g.drawString("" + pos.card.getCardNumber(), pos.x + 5, pos.y + 17);
				  g.drawString("" + pos.card.getCardNumber(),pos.x + 5 , pos.y + 17);
				   g.drawString("" + pos.card.getCardNumber(), pos.x + card.getCardWidth() - 13,
						pos.y + card.getCardHeight() - 5);
				   
			    // korniza letrave
			       g.setColor(Color.white); 
			    	      g.drawRect(pos.x, pos.y, Card.getCardWidth(), Card.getCardHeight());

			      
				
		       }
		       
		       */
		 
			}
		     
		}
	

			
		public void repaint(Graphics g) 
		{
			// draw background image
			g.drawImage(image, 0, 0, null);        ////////
			
			g.setColor(new Color(100, 100 ,100));  // background
			g.fillRect(0, 0,WIDTH, HEIGHT);
			
			g.setColor(Color.black);
			// korniza
			g.drawRect(100, 0 ,550, HEIGHT - 30);
			g.drawLine(100, 290,  650, 290);

			if(playerHealth > playerTotalHealth)
				playerTotalHealth = playerHealth;
			
			double percentage = 0;
			int f = 0;
			if(playerHealth != 0 && playerDamageReceived != 0)
			{
			 percentage = (playerDamageReceived/playerTotalHealth);
			 f = (int) (percentage * 400);
			}
			

			// player health bar
			g.setColor(Color.green);
			g.fillRect(181, 301 , 400-f, 21);
			g.setColor(Color.black);
			g.drawRect(180, 301 , 400, 21 );
			
			
			//boss health bar
			int bdr = (int)((bossDamageReceived/10));
			g.setColor(Color.red);
			g.fillRect(181, 245 , 400-bdr, 21);
			g.setColor(Color.black);
			g.drawRect(180, 245 , 400, 21 );
			
			
			g.setColor(Color.blue);    /// Color.orange
			
			g.setFont(new Font("Arial",1, 18));
			// round
		    g.drawString("Round: " + round, 350, 285);
			
		    // player health
			g.drawString(""+playerHealth, 590, 318);
			g.drawString("HEALTH", 105, 317);
			g.drawString("<NEXT", 580, 345);
			
			g.setColor(Color.red);
			// boss health
			g.drawString(""+bossHealth, 590, 261);
			g.drawString("HEALTH", 105, 261);
			
			g.setColor(Color.black);
			g.setFont(new Font("Arial",1, 15));
			g.drawString("0", 150, 20);
			g.drawString("0", 250, 20);
			g.drawString("0", 350, 20);
			g.drawString("0", 450, 20);
			
			g.setColor(Color.black);
			g.drawString("XP", 158, 20);
			g.drawString("M", 258, 20);
			g.drawString("EGGS", 358, 20);
			g.drawString("SP", 458, 20);
			
			
			// nr klikimeve(clickN)
			g.drawString("clickN:"+ clickN, 10, 10);
			g.drawString("inClick:"+ inClick, 10, 20);
			g.drawString("started:"+ started, 10, 30);
	//		g.drawString("k:"+ k, 10, 40);
			g.drawString("randomC:"+ randomCards.size(), 10, 50);
			g.drawString("comingC:"+ comingCards.size(), 10, 60);
			g.drawString("cardP:"+ cardPositions.size(), 10, 70);
			
		   // Piket
		     g.setFont(new Font("Arial",1,15));
			
		     g.setColor(Color.blue);
			 g.drawString("BLUE POINTS : " + bluePoints, 110, 50);
			 g.setColor(Color.red);
			 g.drawString("RED POINTS : " + redPoints, 110, 65);
			 g.setColor(Color.green);
			 g.drawString("GREEN POINTS : " + greenPoints, 110, 80);
			 g.setColor(Color.yellow);
			 g.drawString("YELLOW POINTS : " + yellowPoints, 110, 95);
			 g.setColor(new Color(64,0,128));
			 g.drawString("PURPLE POINTS : " + purplePoints, 110, 110);
			 g.setColor(new Color(64,0,0));
			 g.drawString("BROWN POINTS : " + brownPoints, 110, 125);
			
			int p = 0;
		for(Position pos : comingCards)
			{
			  p++;
			if( p > 0)   // > 8  per 4 letrat e fundit
				   paintComingCards(g , pos);
	
			}
		
	
			for(Position pos : cardPositions)
			{
				// if(pos.card != null) 
				   paintTableCards(g , pos);
			
			}

	
		//	g.setColor(Color.white);
		//	g.setFont(new Font("Arial",1,90));
			
		
		}
		
		  // metode per te kontrolluar nqs mausi do klikoj mbi nje leter te caktuar
		   public static boolean contains(int x1, int y1, int cardx, int cardy)
		   {
			  // int x1 = cx - Card.getCardWidth()/2;
			  // int y1 = cy - Card.getCardHeight()/2;
		     // return x > x1 &&  x < x1 + Card.getCardWidth() && y > y1 && y < y1 + Card.getCardHeight();
		        return x1 > cardx && y1 > cardy+25 && x1 < cardx + Card.getCardWidth() && y1 < cardy + Card.getCardHeight()+25;
		   }
		
		public static void main (String[] args) 
		{ 
			 game = new Game(); 
			
		}
		
		
			public void mouseClicked(MouseEvent e) 
			{
				

         	//	System.out.println("firstPos: " + firstIsTaken);
         	//	System.out.println("secondPos: " + secondIsTaken);
         	//	System.out.println("thirdPos: " + thirdIsTaken);
         	//	System.out.println("1Pos: " + cardPositions.get(5).x);
				
			//	randomCards();      /////////////////
			//	 checkCardPositions();  ///////
			//	comingCards();
			//	cardPositions();
			
				  // Merr koordinatat e mausit ne momentin qe shtypet
                int x = e.getX();
                int y = e.getY();
  
            Position currentP = position;
            
                // Lokalizo letren e zgjedhur
                for (Position position: cardPositions)
                {
                	// currentP = position;
                	 if (Game.contains(x, y, position.x,  position.y) && !position.isMoved 
                			 && e.getButton() == 1  && position.card != null )
                   {
                		 clickN++;
                		 
                	//	 if(e.getButton() == 1 && clickN > 0 && clickN < 4)
             		//		moveComingCardsForward();
                		 
                		
                	      // ngri letrat e zgjedhura menyra1
                         if(  clickN < 4)
                        {
                        	
                        	 for(Position pos : cardPositions)
                        	 {
                        		 if(pos.x == 200 + 1*(Card.getCardWidth()+10) && pos.y == 350 )
                        		 {
                        			// if(pos.card != null)
                        			 firstIsTaken = true;
                        		 }
                        		 else if(pos.x == 200 + 2*(Card.getCardWidth()+10) && pos.y == 350)
                        		 {
                        			// if(pos.card != null)
                        			 secondIsTaken = true;
                        		 }
                        		 else if(pos.x == 200 + 3*(Card.getCardWidth()+10) && pos.y == 350)
                        		 {
                        			// if(pos.card != null)
                        			 thirdIsTaken = true;
                        		 }
                        	 }		 
                        	 
                        	 
                        	 if(firstIsTaken && secondIsTaken && !thirdIsTaken)
                        	 {
                        		 position.x = 200 + 3*(Card.getCardWidth()+10);
                        	     position.y = 350;
                        	 }
                        	 else if(firstIsTaken && thirdIsTaken && !secondIsTaken)
                        	 {
                        		 position.x = 200 + 2*(Card.getCardWidth()+10);
                        		 position.y = 350;
                        	 }
                        	 else if(secondIsTaken && thirdIsTaken && !firstIsTaken)
                        	 {
                        		 position.x = 200 + 1*(Card.getCardWidth()+10);
                        		 position.y = 350;
                        	 }
                        	 else if(firstIsTaken && !secondIsTaken && !thirdIsTaken)
                        	 {
                        		   position.x = 200 + 2*(Card.getCardWidth()+10);
                   		           position.y = 350;
                        	 }
                        	 else if(!firstIsTaken && !secondIsTaken && thirdIsTaken)
                        	 {
                        		   position.x = 200 + 1*(Card.getCardWidth()+10);
                   		           position.y = 350;
                        	 }
                        	 else if(!firstIsTaken && secondIsTaken && !thirdIsTaken)
                        	 {
                        		   position.x = 200 + 1*(Card.getCardWidth()+10);
                   		           position.y = 350;
                        	 }
                        	 else if(!firstIsTaken && !secondIsTaken && !thirdIsTaken)
                        	    {
                        		  position.x = 200 + 1*(Card.getCardWidth()+10);
                        		  position.y = 350;
                        	    }
                        	 
                         //      position.x = 200 + clickN*(Card.getCardWidth()+10);
                         //      position.y = 300;
                           
                           position.isMoved = true;
                       
                           currentP = position;
     
                        
                        }    
                         
                              
                		 
                	/*	 // ngri letrat e zgjedhura menyra2
                		 if( e.getButton() == 1 && clickN < 4)
                         {
               	 
                          //    position.x = 200 + clickN*(Card.getCardWidth()+10);
                            position.y = position.y - 20;
                            
                            position.isMoved = true;
                        
                            currentP = position;
                         
                         }    
                	 */ 
                   

                   }else if (Game.contains(x, y, position.x,  position.y) && position.isMoved 
              			 && e.getButton() == 1  && position.card != null )
                   {
                	   
                	   if(position.x == 200 + 1*(Card.getCardWidth() +10) && position.y == 350)
                	   {
                		   firstIsTaken = false;
                	   }
                	   else if(position.x == 200 + 2*(Card.getCardWidth()+10)  && position.y == 350)
                		   secondIsTaken = false;
                	   else if(position.x == 200 + 3*(Card.getCardWidth()+10) && position.y == 350 )
                	       thirdIsTaken = false;
                	   
                	   position.isMoved = false;
                	   position.x = position.oldX;
                	   position.y = position.oldY;
                	   clickN--;
                   }
                	 
         /*       	 
                     if(clickN > 0  && e.getButton() == 3 && clickN < 3)
                   	 {
         		        	for(int i = 0 ; i < clickN ; i++) 
         		        	{
         		        		moveComingCardsBackwards();       
         		        	}
                   	 }
                	 
             */   	
                	 if(e.getButton() == 3)
                   {
                		
                  	    position.x = position.oldX;
                        position.y = position.oldY;
                       clickN = 0;
                        
                        for (Position position1: cardPositions)
                        {
                           position1.isMoved = false;
                        }
            
                        firstIsTaken = false;
                        secondIsTaken = false;
                        thirdIsTaken = false;
                        
                     // inClick = false;
                    }	
	 
                }
                
       
                
                 if(clickN > 3)
                	clickN = 3;  //////////////
                	
                if(clickN > 0)
        	    {
                    inClick = true;  /////            
        	    }
            else
            {
            	inClick = false;
            	
            }
                
               if(currentP.card != null) 
               {
                if(clickN == 1)
          	    {
        		    firstC = currentP;
          	    	firstC.card.setCardNumber(currentP.card.getCardNumber());
          	    	firstC.card.setColor(currentP.card.getCardColor());
          	    }
          	    if(clickN == 2)
          	    {
          	    	secondC = currentP;
          	    	secondC.card.setCardNumber(currentP.card.getCardNumber());
          	    	secondC.card.setColor(currentP.card.getCardColor());
          	    }
          	    if(clickN == 3)
                  {
          	    	thirdC = currentP;
          	    	thirdC.card.setCardNumber(currentP.card.getCardNumber());
          	        thirdC.card.setColor(currentP.card.getCardColor());
          	        

          	      //   inClick = false;
                  }
                	
               } // if current != null
               
          	     
		    	}
                
               
		
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
				
			}
			public void mousePressed(MouseEvent e) {
		
			}
			public void mouseReleased(MouseEvent e) {
				
				
			}
			public void keyPressed(KeyEvent e) {
				
				
			}
		
	
			public class Position
			   {
				  public Card card;
			      public boolean isTaken;
			      public boolean isMoved;
			      public boolean isTop;
			      public int x;
			      public int y;
			      public int oldX;
			      public int oldY;
			   }


			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
			//	if(comingCards.get(comingCards.size()-1) == null)
			
				
				if(comingCards.get(comingCards.size()-1).card == null)
					checkComingCards();

				checkCardPositions();
				addComingCards();     /////////
	              
	            
	         //      checkComingCards();
               //checkClicked();
					
           	    if(clickN == 3 && Renderer.pressed )
           	    {
           	    	
           	    	if( ( (firstC.card.getCardColor() == (secondC.card.getCardColor() ) )
                   			&& firstC.card.getCardColor() == (thirdC.card.getCardColor() ) ) 
           	    			
           	    			|| (firstC.card.getCardColor() == "black") && ( (secondC.card.getCardColor() == thirdC.card.getCardColor())
           	    			||(secondC.card.getCardColor() == "black" || thirdC.card.getCardColor() == "black") )
           	    			
           	    			|| (secondC.card.getCardColor() == "black" && (firstC.card.getCardColor() == thirdC.card.getCardColor())
           	    			||(firstC.card.getCardColor() == "black" || thirdC.card.getCardColor() == "black"))
           	    		
           	    			|| (thirdC.card.getCardColor() == "black" && firstC.card.getCardColor() == secondC.card.getCardColor()) 
           	    			||(firstC.card.getCardColor() == "black" || secondC.card.getCardColor() == "black")) 
                   	{
           	    		
           	    		
                   		System.out.println("3 letra me te njeten ngjyre");
                     	System.out.println("First: " + firstC.card.getCardNumber() + firstC.card.getCardColor());
                   		System.out.println("Second: " + secondC.card.getCardNumber() + secondC.card.getCardColor());
                   		System.out.println("Third: " + thirdC.card.getCardNumber() + thirdC.card.getCardColor());
                   		
                   	    if(firstC.card.getCardColor() == "black" && secondC.card.getCardColor() == "black" && thirdC.card.getCardColor() == "black")
                   		{
                   			brownPoints = brownPoints + 20*(10 + 10 + 10) ;
                   		    purplePoints = purplePoints + 20*(10 + 10 + 10 ) ;
                   		    yellowPoints = yellowPoints + 20*(10 + 10 + 10 ) ;
                   		    greenPoints = greenPoints + 20*(10 + 10 + 10 ) ;
                   		    redPoints = redPoints + 20*(10 + 10 + 10 ) ;
                   		    bluePoints = bluePoints + 20*(10 + 10 + 10 ) ;
                   		   
                   		    // damage the boss
                   		    playerDamage = 20*(10 + 10 + 10 );                   		
                   		    bossHealth = bossHealth - playerDamage;
                   	        bossDamageReceived += playerDamage;
                   	        // heal the player                 	                          		
                		    playerHealth = playerHealth + 400;
                   		}
                   		else if(firstC.card.getCardColor() == "black" && secondC.card.getCardColor() == "black")
                   		{
                   			brownPoints = brownPoints + 15*(10 + 10 + thirdC.card.getCardNumber() ) ;
                   		    purplePoints = purplePoints + 15*(10 + 10 + thirdC.card.getCardNumber() ) ;
                   		    yellowPoints = yellowPoints + 15*(10 + 10 + thirdC.card.getCardNumber() ) ;
                   		    greenPoints = greenPoints + 15*(10 + 10 + thirdC.card.getCardNumber() ) ;
                   		    redPoints = redPoints + 15*(10 + 10 + thirdC.card.getCardNumber() ) ;
                   		    bluePoints = bluePoints + 15*(10 + 10 + thirdC.card.getCardNumber() ) ;
                   		   
                   		    if(thirdC.card.getCardColor() == "green") {
                   		    	// heal the player
                   		    	playerHealth += 200;
                   		    }
                   		    playerDamage = 15*(10 + 10 + thirdC.card.getCardNumber() );                   		
                   		    bossHealth = bossHealth - playerDamage;
                   	        bossDamageReceived += playerDamage;
                   		}
                   		else if(firstC.card.getCardColor() == "black" && thirdC.card.getCardColor() == "black")
                   		{
                   			brownPoints = brownPoints + 15*(10 + secondC.card.getCardNumber() + 10 ) ;
                   		    purplePoints = purplePoints + 15*(10 + secondC.card.getCardNumber() + 10 ) ;
                   		    yellowPoints = yellowPoints + 15*(10 + secondC.card.getCardNumber() + 10 ) ;
                   		    greenPoints = greenPoints + 15*(10 + secondC.card.getCardNumber() + 10 ) ;
                   		    redPoints = redPoints + 15*(10 + secondC.card.getCardNumber() + 10 ) ;
                   		    bluePoints = bluePoints + 15*(10 + secondC.card.getCardNumber() + 10 ) ;
                   		   
                   		    if(secondC.card.getCardColor() == "green") {
                		    	// heal the player
                		    	playerHealth += 200;
                		    }
                   		    playerDamage = 15*(10 + secondC.card.getCardNumber() + 10);                   		
                   		    bossHealth = bossHealth - playerDamage;
                   	        bossDamageReceived += playerDamage;
                   		}
                   		else if(secondC.card.getCardColor() == "black" && thirdC.card.getCardColor() == "black")
                   		{
                   			brownPoints = brownPoints + 15*(firstC.card.getCardNumber() +10 + 10 ) ;
                   		    purplePoints = purplePoints + 15*(firstC.card.getCardNumber() + 10 + 10 ) ;
                   		    yellowPoints = yellowPoints + 15*(firstC.card.getCardNumber() + 10 + 10 ) ;
                   		    greenPoints = greenPoints + 15*(firstC.card.getCardNumber() + 10 + 10 ) ;
                   		    redPoints = redPoints + 15*(firstC.card.getCardNumber() +10 + 10 ) ;
                   		    bluePoints = bluePoints + 15*(firstC.card.getCardNumber() + 10 + 10 ) ;
                   		   
                   		    if(firstC.card.getCardColor() == "green") {
                		    	// heal the player
                		    	playerHealth += 200;
                		    }
                   		    playerDamage = 15*(firstC.card.getCardNumber() + 10 + 10);                   		
                   		    bossHealth = bossHealth - playerDamage;
                   	        bossDamageReceived += playerDamage;
                   		}
                   		else if(firstC.card.getCardColor() == "black")
                   		{
                   			brownPoints = brownPoints + 10*(10 + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    purplePoints = purplePoints + 10*(10 + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    yellowPoints = yellowPoints + 10*(10 + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    greenPoints = greenPoints + 10*(10 + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    redPoints = redPoints + 10*(10 + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    bluePoints = bluePoints + 10*(10 + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		   
                   		    if(secondC.card.getCardColor() == "green" && thirdC.card.getCardColor() == "green") {
                		    	// heal the player
                		    	playerHealth += 150;
                		    }
                   		    playerDamage = 10*(10 + secondC.card.getCardNumber() + thirdC.card.getCardNumber() );                   		
                   		    bossHealth = bossHealth - playerDamage;
                   	        bossDamageReceived += playerDamage;
                   		}
                   		else if(secondC.card.getCardColor() == "black")
                   		{
                   			brownPoints = brownPoints + 10*(firstC.card.getCardNumber() + 10 + thirdC.card.getCardNumber() ) ;
                   		    purplePoints = purplePoints + 10*(firstC.card.getCardNumber() +10 + thirdC.card.getCardNumber() ) ;
                   		    yellowPoints = yellowPoints + 10*(firstC.card.getCardNumber() + 10 + thirdC.card.getCardNumber() ) ;
                   		    greenPoints = greenPoints + 10*(firstC.card.getCardNumber() + 10 + thirdC.card.getCardNumber() ) ;
                   		    redPoints = redPoints + 10*(firstC.card.getCardNumber() + 10 + thirdC.card.getCardNumber() ) ;
                   		    bluePoints = bluePoints + 10*(firstC.card.getCardNumber() + 10 + thirdC.card.getCardNumber() ) ;
                   		   
                   		    if(firstC.card.getCardColor() == "green" && thirdC.card.getCardColor() == "green") {
              		    	    // heal the player
              		    	    playerHealth += 150;
              		        }
                   		    playerDamage = 10*(firstC.card.getCardNumber() + 10 + thirdC.card.getCardNumber() );                   		
                   		    bossHealth = bossHealth - playerDamage;
                   	        bossDamageReceived += playerDamage;                   	        
                   		}
                   		else if(thirdC.card.getCardColor() == "black")
                   		{
                   			brownPoints = brownPoints + 10*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + 10 ) ;
                   		    purplePoints = purplePoints + 10*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + 10 ) ;
                   		    yellowPoints = yellowPoints + 10*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + 10 ) ;
                   		    greenPoints = greenPoints + 10*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + 10 ) ;
                   		    redPoints = redPoints + 10*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + 10 ) ;
                   		    bluePoints = bluePoints + 10*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + 10 ) ;
                   		    
                   		    if(firstC.card.getCardColor() == "green" && secondC.card.getCardColor() == "green") {
              		    	    // heal the player
              		    	    playerHealth += 150;
              		        }
                   		    playerDamage = 10*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + 10);                   		
                   		    bossHealth = bossHealth - playerDamage;
                   	        bossDamageReceived += playerDamage;
                   		}
                   		else if(firstC.card.getCardColor() == "blue")
                   		{
                   			bluePoints = bluePoints + 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    playerDamage = 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() );
                   		    bossHealth = bossHealth - playerDamage;
                   		    bossDamageReceived += playerDamage;
                   		}
                   		else if(firstC.card.getCardColor() == "red")
                   		{
                   			// add points
                   			redPoints = redPoints + 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    // damage the boss
                   			playerDamage = 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() );                   		
                   		    bossHealth = bossHealth - playerDamage; 
                   		    bossDamageReceived += playerDamage;
                   		}
                   		else if(firstC.card.getCardColor() == "green")
                   		{
              		    	// heal the player
              		    	playerHealth += 100;
              		    	// add points
                   			greenPoints = greenPoints + 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   	     	// damage the boss
                   			playerDamage = 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() );                   		
                   		    bossHealth = bossHealth - playerDamage;
                   		    bossDamageReceived += playerDamage;
                   		}
                   		else if(firstC.card.getCardColor() == "yellow")
                   		{
                   			yellowPoints = yellowPoints + 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    playerDamage = 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() );                   		
                   		    bossHealth = bossHealth - playerDamage;
                   		    bossDamageReceived += playerDamage;
                   		}
                   		else if(firstC.card.getCardColor() == "purple")
                   		{
                   			purplePoints = purplePoints + 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    playerDamage = 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() );                   		
                   		    bossHealth = bossHealth - playerDamage;
                   		    bossDamageReceived += playerDamage;
                   		}
                   		else if(firstC.card.getCardColor() == "brown")  // brown
                   		{
                   			brownPoints = brownPoints + 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() ) ;
                   		    playerDamage = 5*(firstC.card.getCardNumber() + secondC.card.getCardNumber() + thirdC.card.getCardNumber() );                   		
                   		    bossHealth = bossHealth - playerDamage;
                   	     	bossDamageReceived += playerDamage;
                   		}
                   		
                   		    playerDamage = 0;
                   		firstC.x = firstC.oldX;
                   		firstC.y = firstC.oldY;
                   		secondC.x = secondC.oldX;
                   		secondC.y = secondC.oldY;
                   		thirdC.x = thirdC.oldX;
                   		thirdC.y = thirdC.oldY;
                   		
                   		firstC.isMoved = false;           		
                   		secondC.isMoved = false;
                   		thirdC.isMoved = false;
                   		
                   		firstC.card = null;
                   		secondC.card = null;
                   		thirdC.card = null;
                   		
                   		round ++;
                   	  //  bossDamage = 50;                   		
            		    playerHealth = playerHealth - bossDamage;
            	        playerDamageReceived += bossDamage;
                   		
                   		clickN = 0;
                   	  inClick = false;
                   	Renderer.pressed = false;
                   	
             
                /* 
                   	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
						}
						*/
					
                   	}else 
                   		 { 
                   		   System.out.println("3 letra me ngjyre te ndryshme");
                   		   System.out.println("First: " + firstC.card.getCardNumber() + firstC.card.getCardColor());
                   		   System.out.println("Second: " + secondC.card.getCardNumber() + secondC.card.getCardColor());
                   		   System.out.println("Third: " + thirdC.card.getCardNumber() + thirdC.card.getCardColor());
                   		
                   		   if(firstC.card.getCardColor() == "blue")
                   			   bluePoints += firstC.card.getCardNumber();
                   		   else if(firstC.card.getCardColor() == "red")
                   			   redPoints += firstC.card.getCardNumber();
                   		   else if(firstC.card.getCardColor() == "green")
                			   greenPoints += firstC.card.getCardNumber();
                   		   else if(firstC.card.getCardColor() == "yellow")
                			   yellowPoints += firstC.card.getCardNumber();
                   		   else if(firstC.card.getCardColor() == "purple")
                			   purplePoints += firstC.card.getCardNumber();
                   		   else if(firstC.card.getCardColor() == "brown")
                			   brownPoints += firstC.card.getCardNumber();
                   		
                   		   
                   		  if(secondC.card.getCardColor() == "blue")
                  			   bluePoints += secondC.card.getCardNumber();
                  		   else if(secondC.card.getCardColor() == "red")
                  			   redPoints += secondC.card.getCardNumber();
                  		   else if(secondC.card.getCardColor() == "green")
               			       greenPoints += secondC.card.getCardNumber();
                  		   else if(secondC.card.getCardColor() == "yellow")
               			       yellowPoints += secondC.card.getCardNumber();
                  		   else if(secondC.card.getCardColor() == "purple")
               			       purplePoints += secondC.card.getCardNumber();
                  		   else if(secondC.card.getCardColor() == "brown")
               			       brownPoints += secondC.card.getCardNumber();
                   		  
                   		if(thirdC.card.getCardColor() == "blue")
               			   bluePoints += thirdC.card.getCardNumber();
               		   else if(thirdC.card.getCardColor() == "red")
               			    redPoints += thirdC.card.getCardNumber();
               		   else if(thirdC.card.getCardColor() == "green")
            			    greenPoints += thirdC.card.getCardNumber();
               		   else if(thirdC.card.getCardColor() == "yellow")
            			    yellowPoints += thirdC.card.getCardNumber();
               		   else if(thirdC.card.getCardColor() == "purple")
            			    purplePoints += thirdC.card.getCardNumber();
               		   else if(thirdC.card.getCardColor() == "brown")
            			    brownPoints += thirdC.card.getCardNumber();
                   		     
                   		
                   		firstC.x = firstC.oldX;
                   		firstC.y = firstC.oldY;
                   		secondC.x = secondC.oldX;
                   		secondC.y = secondC.oldY;
                   		thirdC.x = thirdC.oldX;
                   		thirdC.y = thirdC.oldY;
                   		
                   		firstC.isMoved = false;           		
                   		secondC.isMoved = false;
                   		thirdC.isMoved = false;
                   		   
                   		firstC.card = null;
                   		secondC.card = null;
                   		thirdC.card = null;
                   		
                   		round ++;
                    	 inClick = false;
                   		   clickN = 0;
                   		   Renderer.pressed = false;
                   	
                   		 }
                   	
           	    }
	
           	 renderer.repaint();
           	    
			}
	
}
