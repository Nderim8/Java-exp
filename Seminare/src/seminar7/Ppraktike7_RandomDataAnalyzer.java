package seminar7;

import java.util.Random;

public class Ppraktike7_RandomDataAnalyzer 
{
	public static void main(String[]args)
	{
		int max = 0;
		int sum = 0;
		int mes;
		Random rand = new Random();
		
		for(int i=0; i<100; i++)
		{
		  int x = rand.nextInt(1001);
		  sum += x;
		  
		  if(x>max)
			  max=x;
			
		}
		
		 mes = sum/100;
				
		System.out.println("Mesatarja e 100 numrave random nga 0 ne 1000 eshte : "+mes);
		System.out.println("Numri me  i madh ndermjet tyre eshte : "+max);
	}
	
}
