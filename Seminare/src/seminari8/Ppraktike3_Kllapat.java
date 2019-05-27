package seminari8;

import java.util.Random;

public class Ppraktike3_Kllapat 
{
	
	public static void main(String[]args)
	{
		Random zari = new Random();
		int [] x  = new int[20];
		
		// Futja e numrave random (nga 1 ne  6 ) ne tabelen x
		for(int i=0; i<20; i++)
		{
		  x[i] = 1 + zari.nextInt(6);
			
		}
		// Afishimi i numrave ne tabelen x
		for(int j=0; j<20; j++)
		{
		 System.out.print(x[j] + " ");
		}
		
		System.out.println();
		
		// Afishimi i numrave ne  tabelen x pas perpunimit 
		 boolean nrTBarabarte = false;
	        int vleraPara = x[0];
	        for (int i = 0; i < x.length - 1 ; i++) 
	        {
	            if (nrTBarabarte) 
	            {
	                if (x[i] != vleraPara) 
	                {
	                    System.out.print(") ");
	                    nrTBarabarte = false;
	                }
	            } 
	            else 
	            {
	                if (x[i] == x[i + 1]) 
	                {
	                    System.out.print(" (");
	                    nrTBarabarte = true;
	                } 
	                else if(i!=0) 
	                {
	                    System.out.print(" ");
	                }
	            }
	            vleraPara = x[i];
	            System.out.print (x[i]);
	        }
	        
	    if (nrTBarabarte && x[x.length - 1] == vleraPara) 
	    {
	         System.out.print( x[x.length - 1] + ") ");
	    } 
	    else if (nrTBarabarte && x[x.length - 1] != vleraPara) 
	    {
	         System.out.print(") " + x[x.length - 1] );
	    } 
	    else 
	    {
	         System.out.print(" " + x[x.length - 1] );
	    }  
	     
	 }
	
}
