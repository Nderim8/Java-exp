package seminari6;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Ppraktike8 extends JComponent
{
	
	private static final long serialVersionUID = 1L;
	private double X1;
	private double Y1;
	private double R1;
	private double X2;
	private double Y2;
	private double R2;
	
	public Ppraktike8(double x1 ,double y1, double r1 , double x2 , double y2 , double r2 )
	{
		X1 = x1;
		Y1 = y1;
		R1 = r1;
		X2 = x2;
		Y2 = y2;
		R2 = r2;
		
	}

	  public static void main(String[] args){
	    
		  Scanner input = new Scanner(System.in);
		    System.out.println("Fut koordinatat e qendres se Rrethit1 x , y dhe rrezen : ");
		    
		    double x1 = input.nextDouble();
		    double y1 = input.nextDouble();
		    double rrezja1 = input.nextDouble();
		    System.out.println("Fut koordinatat e qendres se Rrethit2 x , y dhe rrezen : ");
		    
		    double x2 = input.nextDouble();
		    double y2 = input.nextDouble();
		    double rrezja2 = input.nextDouble(); 
		    input.close();
	    
	    double distanca = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	    
	    /* 5 mundesi : 1)rrethi1 eshte brenda rrethit2 2)rrethi2 eshte brenda rrethit1
	     *             3)rrathet nuk priten 4)rrathet priten 5)rrathet jane tangent */
	    
	    if (rrezja2 >= rrezja1 && distanca <= (rrezja2 - rrezja1)){
	        System.out.println("Rrethi1 eshte brenda Rrethit2.");
	    }
	    else if (rrezja1 >= rrezja2 && distanca <= (rrezja1 - rrezja2) ) {
	        System.out.println("Rrethi2 eshte brenda Rrethit1");
	    }
	    else if (distanca > (rrezja1 + rrezja2)){
	        System.out.println("Rrethi1 dhe rrethi2 nuk priten.");
	    }    
	    else if (distanca < (rrezja1 + rrezja2)){
		        System.out.println("Rrethi1 dhe rrethi2 priten.");
	    }
	    else {
		        System.out.println("Rrethi1 dhe rrethi2 jane tangent.");
	        }
	   
	    JFrame frame = new JFrame();
	    frame.setSize(500,500);
	    frame.setTitle("Rrathet");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    Ppraktike8 component =  new Ppraktike8(x1,y1,rrezja1,x2,y2,rrezja2);
	    frame.add(component);
	    frame.setVisible(true);
	    
	    }
	  
		public void paintComponent (Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			/*  Kordinatat ne elips merren si : x dhe y  jane gjersia dhe lartesia
			 * e pikes se nisjes se nje drejtkendeshi qe do ti brendashkruhet nje elips
			 * (rreth) i cili esht i pershtatur ne max me kte drejtkendesh 
			 * nese duam te vizatojm nje rreth me koordinata te qendres (x , y)
			 * dhe rreze r atehere ne vizatimin e tij ne duhet te veprojm keshtu
			 * Ellipse2D.Double rrethi1 = new Ellipse2D.Double( x-r , y-r , r*2 , r*2);
			*/
		
			Ellipse2D.Double rrethi1 = new Ellipse2D.Double( X1-R1 , Y1-R1 , R1*2 , R1*2);
			
			Ellipse2D.Double rrethi2 = new Ellipse2D.Double(  X2-R2 , Y2-R2 , R2*2 , R2*2);
			
			
			g2.draw(rrethi1);
			g2.draw(rrethi2);
			
		}

	}


