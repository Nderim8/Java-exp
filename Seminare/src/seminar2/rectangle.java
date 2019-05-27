package seminar2;

import java.util.Scanner;

public class rectangle{
	private int width;
	private int height;
	
	public rectangle(int a,int b)
	{
		width=a;
		height=b;
		
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public int afishoSip()
	{
		int siperfaqja = getWidth() * getHeight();
		return siperfaqja;
	}
	
	public int afishoPer ()
	{
		int perimeter = 2*getWidth() + 2*getHeight();
		return perimeter;
	}
	
	public static void main(String[]args)
	{
		Scanner in =new Scanner(System.in);
		System.out.println("Fut x-in:");
		int x = in.nextInt();
		System.out.println("Fut y-in:");
		int y = in.nextInt();
		rectangle rect = new rectangle(x,y);
	//	System.out.println(rect.getWidth());
	//	System.out.println(rect.getHeight());
		
		System.out.println("Siperfaqja eshte :" + rect.afishoSip());
		System.out.println("Perimetri eshte :" + rect.afishoPer());
	}

}
