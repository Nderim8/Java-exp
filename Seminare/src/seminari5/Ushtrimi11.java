package seminari5;

import java.util.Scanner;

public class Ushtrimi11 
{
	private  int a;
	
	public Ushtrimi11(int brinja)
	{
		a = brinja;
	}
	
	public int getSip()
	{
		int sip = a * a ;
		return sip;
	}
	public int getPer()
	{
		int per = 4 * a; 
		return per;
	}
	public int getDiag()
	{
		int diag = (int) Math.round( Math.sqrt(2 * a * a) );
		return diag;
	}
	
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Fut brinjen e katrorit :");
		int b = in.nextInt();
		
		Ushtrimi11 prova =  new Ushtrimi11(b);
		
		System.out.println("Syprina e katrorit me brinj " + b +" eshte : " + prova.getSip());
		System.out.println("Perimetri i katrorit me brinj " + b +" eshte : " + prova.getPer());
		System.out.println("Diagonalja e katrorit me brinj " + b +" eshte : " + prova.getDiag());
		
	}
	

}
