package seminar7;

import java.util.Scanner;

public class Ppraktike2 
{

	public static void main(String[] args) 
	{  // nr prim deri ne fund
		Scanner in = new Scanner(System.in);
		boolean prim = true;
		System.out.println("Fut numrin :");
		int x = in.nextInt();
		in.close();
		for (int i=2; i<=x; i++)
		{
			for(int j=2; j<10; j++ )
			{
			      if(i % j == 0 && j!=i)
			    	 prim = false;		
			}
			if(prim)
			{
				System.out.println(i);
			}
			
			prim = true;
			
		}
	}

}
