package seminari8;

import java.util.ArrayList;
import java.util.Scanner;

public class Purse 
{
	private ArrayList<String> Monedhat;
	
	public Purse(ArrayList<String> arrayList)
	{
      Monedhat = arrayList;
	}
	public void addCoin(String coinName)
	{
		Monedhat.add(coinName);
	}
	public ArrayList<String> tostring()
	{
		   return Monedhat;
	}
	
	public ArrayList<String> reverse()
	{
		// Riorganizojme elementet e ArrayList Monedhat (mbrapsh)
		String temp;
		int index = 1;
		for (int i=0; i<Monedhat.size()/2; i++)
		{
			
			temp = Monedhat.get(i);
			Monedhat.set(i, Monedhat.get(Monedhat.size()-index) );
			Monedhat.set(Monedhat.size()-index, temp );
			index++;
		}
		// ArrayList Monedhat pas riorganizimit te elementeve
		return Monedhat;
	}
	
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		
	//	System.out.println("Fusni emrin e ArrayList (psh : Canta) :");
	//	String s = in.next();
		
		ArrayList<String> purse = new ArrayList<String>();
		
		Purse test = new Purse(purse);
		
		System.out.println("Sa monedha deshironi te fusni ?");
		int x = in.nextInt();
		
		for (int i=1; i<x+1; i++)
		{
			
		System.out.println("Fut emrin e monedhes" + i + " : ");
		String monedha = in.next();
		test.addCoin(monedha);
		
		}

		System.out.println( "Purse" + test.tostring() );
		
		System.out.println( "Purse" + test.reverse() );
		
		in.close();
	
	}

}
