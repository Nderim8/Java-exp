package seminari5;

import java.util.Scanner;

public class Ushtrimi12 
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Fut numrin : ");
		String numri = in.next();
		System.out.println("indeksi : " + numri.length());
		for(int i = numri.length()-1; i>=0 ; i-- )
		{
			char ch = numri.charAt(i);
			
			if (i == 1 && numri.charAt(0)== '-')
			{
				System.out.println("-" + ch);
			i--;
			}
			else
				System.out.println(ch);
			
			
		}
		
		
	} 

}
