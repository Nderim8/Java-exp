package seminari6;

import java.util.Scanner;

public class Ppraktike3_RenditjaStringjeve 
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Sa strigje deshironi te jepni ? ");
		int nr = in.nextInt();
		
		String [] x = new String [nr];
		
		System.out.println("Ju lutem jepni stringjet : ");
		for(int i=0; i<nr; i++)
		{
			x[i] = in.next();
		}
		
		String temp; 
		for(int b=0; b<nr - 1; b++ )
	{
	    for(int j=1; j < nr; j++ )
	    {
		if (  x[b].compareTo( x[j] ) > 0 )
		  {
			temp = x[b];
			x[b] = x[j];
			x[j] = temp;
			
		  }
	    }	
	}
		
		System.out.println("Stringjet pas renditjes jane : ");
		
		for(int i=0; i < nr; i++)
		{
			System.out.println(x[i]);
		}
		
		
	}
	

}
