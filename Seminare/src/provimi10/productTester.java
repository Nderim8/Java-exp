package provimi10;

import java.util.Scanner;

public class productTester 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Fut emrin e produktit : ");
		String e = in.next();
		
		System.out.println("Fut cmimin e produktit : ");
		double c = in.nextDouble(); 
		
		product test = new product(e, c);
		
		System.out.println(test.getName() + " kushton : " + test.getPrice() + "$");
		
		
		
		
	}

}
