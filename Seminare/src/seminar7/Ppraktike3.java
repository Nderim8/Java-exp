package seminar7;

import java.util.Scanner;

public class Ppraktike3 {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		boolean prim = true;
		String p;
		do
	{
		System.out.println("Fut nje numer te plote pozitiv : ");
		int nr = in.nextInt();
		
		for(int j=2; j<10; j++ )
		{
		      if(nr % j == 0 && j!=nr)
		    	 prim = false;		
		}
		if(prim)
		{
			System.out.println("Po, numri eshte prim.");
		}
		else 
		{
			for( int i=1; i<nr; i++)
			{
				System.out.println(i);
				
			}
			System.out.println("Jo, numri nuk eshte prim.");
		}	
			
		prim = true;
		
		System.out.println("Deshironi te jepni nje numer tjeter ? (Shtyp ndalo per te perfunduar) ");
		  p = in.next();
	
	} while(!p.equalsIgnoreCase("ndalo"));
		
		in.close();
	
	}

}
