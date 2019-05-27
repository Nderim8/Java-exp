package seminari6;

import java.util.Scanner;

public class Ppraktike6_Muajt 
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Fut muajin : (1=janar , 2=shkurt etj) ");
		for (int i=0; i<12; i++)
		{
			if(i != 0)
			System.out.println("Fut muajin : ");
			int muaji = in.nextInt();
			
	    if ( muaji %2 !=0 || muaji == 8 )
	    	System.out.println("Ky muaj ka 31 dite.");
	    else if(muaji == 2) 
	    	System.out.println("Ky muaj ka 28 dite.");
	    else
	    	System.out.println("Ky muaj ka 30 dite.");
	    
			
			
		}
		
	}

}
