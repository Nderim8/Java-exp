package seminar2;

import java.util.Random;

public class LotteryPrinter
{
	public static void main(String[]args)
	{
		Random lottery = new Random();
		System.out.println("Luaj kete kombinim:");
		for (int i=0;i<6;i++)
		{
		  int x =	1 + lottery.nextInt(49);
			System.out.print(x +" ");
		}
		
	}

}
