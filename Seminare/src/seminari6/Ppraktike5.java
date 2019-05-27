package seminari6;

import java.util.Scanner;

public class Ppraktike5 
{
	public  static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
	for (int i=0; i<8; i++)	
	{	
		
		System.out.println("Deshironi te vazhdoni ? ");
		
	    
		String answer = in.next();
		
		if ( answer.equalsIgnoreCase("po")|| answer.equalsIgnoreCase("yes")
			|| answer.equalsIgnoreCase("ok") || answer.equalsIgnoreCase("y")
			|| answer.equalsIgnoreCase("sigurisht") )
		
			System.out.println("OK");
		
		else if (answer.equalsIgnoreCase("jo")|| answer.equalsIgnoreCase("no")
				|| answer.equalsIgnoreCase("n") )
			
			System.out.println("Perfundim");
			
		else
			System.out.println("Input i gabuar!");		
		
	}	
	   in.close();
	
	}

}
