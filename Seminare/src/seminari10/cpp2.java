package seminari10;

import java.util.Scanner;

public class cpp2 
{

	public static void main(String[]args)
	{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Sa numra deshironi te jepni ? ");
		int numrat = in.nextInt();
		
		int [] x = new int [numrat];
		
		System.out.println("Ju lutem jepni numrat : ");
		for(int i=0; i<numrat; i++)
		{
			x[i] = in.nextInt();
		}
		
		int temp; 
		int c = 0;
		for(int b=0; b<numrat/2; b++ )
	{
			
			temp = x[b];
			x[b] = x[numrat-c-1];
			x[numrat-c-1] = temp;
			c = c+1;
	}
		
		System.out.println("Numrat pas renditjes mbrapsh jane : ");
		
		for(int i=0; i < numrat; i++)
		{
			System.out.println(x[i]);
		}
		
		
	}
	

}
