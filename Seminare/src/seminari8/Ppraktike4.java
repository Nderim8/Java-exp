package seminari8;

import java.util.Random;

public class Ppraktike4 
{

	public static void main(String[]args)
	{
		Random zari = new Random();
		int [] x  = new int[21];
		
		// Futja e numrave random (nga 1 ne  6 ) ne tabelen x
		for(int i=0; i<20; i++)
		{
		  x[i] = 1 + zari.nextInt(6);
			
		}
		//  e nevojshme per rregullimin e ciklit for te perpunimit 
	   //	(e veme nje numer ndryshem nga numrat qe duam te bien ) 
		x[20] = 0;
		
	// Afishimi i numrave ne tabelen x (pa perfshire elementin e fundit te arrayt(x[20]=0)
		for(int j=0; j<20; j++)
		{
		 System.out.print(x[j] + " ");
		}
		 
		System.out.println();
		
		// Afishimi i numrave ne  tabelen x pas perpunimit 
		 
		 int sasia = 1;
		 int indexf = 0;
		 int indexm = 0;
		 int sasiaMax = 0;
		 
	       
	        for (int i = 0; i < x.length - 1 ; i++) 
	        {
	             
	            if(x[i] != x[i+1])
	            {
	            	sasia = 1;
	            }
	            
	            else {
	                if (x[i] == x[i + 1] )   //&& i != x.length-1) 
	                {
	                	sasia ++;
	                	if(sasia > sasiaMax)
	                	{
	                		sasiaMax = sasia;
	                		indexf = i-sasia+2  ;
	                		indexm = i+1;
	               	
	                	}	
	                   
	                } 
	            }
	          
	        }
	      for(int i=0; i<x.length-1; i++)
	      {
	    	  if(i == indexf && sasiaMax != 0)
	    	  { 
	    		  if( sasiaMax != 0)
	    		  System.out.print("(" + x[i] + " ");
	    	  }
	    	  else if(i == indexm && indexm != 0 )
	    	  {
	    		  System.out.print( x[i] + ") ");
	    	  }
	    	  else 
	    		  System.out.print( x[i] + " ");
	    	  
	      }
	        
	}
}
