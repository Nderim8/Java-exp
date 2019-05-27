package seminar7;

import java.util.Scanner;

public class Ppraktike6_Palindrome 
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		
		int index =1;
		boolean palindrome = true;
		System.out.println("Fut fjalen : ");
		String s = in.next();
		
		for (int i=0; i<s.length()/2; i++)
		{	
		  if( s.charAt(i) != ( s.charAt(s.length()-index) ) )
		  {
			  palindrome = false;
		  }
		  
		  index++;
		  
		}
		if(palindrome)
			System.out.println("Fjala " + s + " eshte palindrome.");
		else
			System.out.println("Fjala " + s + " nuk eshte palindrome.");
		
	}

}
