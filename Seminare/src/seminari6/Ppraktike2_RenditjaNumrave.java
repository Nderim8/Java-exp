package seminari6;

import java.util.Scanner;

public class Ppraktike2_RenditjaNumrave 
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Sa numra deshironi te jepni ? ");
		int numrat = in.nextInt();
		
		double [] x = new double [numrat];
		
		System.out.println("Ju lutem jepni numrat : ");
		for(int i=0; i<numrat; i++)
		{
			x[i] = in.nextDouble();
		}
		
		double temp; 
		for(int b=0; b<numrat - 1; b++ )
	{
	    for(int j=1; j < numrat; j++ )
	    {
		if ( x[b] > x[j] )
		  {
			temp = x[b];
			x[b] = x[j];
			x[j] = temp;
			
		  }
	    }	
	}
		
		System.out.println("Numrat sipas rendit rendites jane : ");
		
		for(int i=0; i < numrat; i++)
		{
			System.out.println(x[i]);
		}
		
		
	}
	

}
