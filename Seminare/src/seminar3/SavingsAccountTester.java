package seminar3;

import java.util.Scanner;

public class SavingsAccountTester 
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Fut llogarin fillestare : ");
		double x = in.nextDouble();
		System.out.println("Fut interesin : ");
		double i =in.nextDouble();
		SavingsAccount account = new SavingsAccount(x,i);
		
		account.addInterest(i);
		
		System.out.println("Para gjithsej: " + account.returnBalance());
		
		
	}

}
