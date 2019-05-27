package seminari5;

import java.util.Scanner;

public class Ushtrimi9 
{
	
	public static  void main (String[]args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Fut numrin : ");
		String a = in.next();
	
		// nr me hapsire
		for (int i=0; i<a.length();i++)
		{
			char b = a.charAt(i);
			System.out.print(b);
			System.out.print(" ");
			
		}
		
		
	}

}
