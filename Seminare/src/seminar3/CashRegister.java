package seminar3;

import java.util.Scanner;

public class CashRegister 
{
     public double Tax;
     private double totalTax;
     private double salesTotal;
     private int salesCount;
     private int taxablePurchase;
     private int notTaxablePurchase;
     
     public CashRegister(double tax)
     {
    	 Tax = tax;
    	 taxablePurchase = 0;
    	 notTaxablePurchase = 0;
     }
	 public void recordTaxablePurchase(double price)
	 {
		 totalTax = totalTax + price * Tax/100;
	     salesTotal += price;
		 salesCount++;
	     
	 }
	
	public void recordPurchase(double price)
	{
		salesTotal += price;
		notTaxablePurchase++;
		salesCount++;
	}
	
	public double getSalesTotal()
	{
		return salesTotal;
	}
	
	public int getSalesCount()
	{
		return salesCount;
	}
	
	public double getTotalTax()
	{
		return totalTax;
	}
	
	public double giveChange(double price1)
	{
		double taxCost = price1 * Tax/100;
		return taxCost;
	}
	
	public void reset()
	{
		salesTotal = 0;
		salesCount = 0;
		totalTax = 0;
	}
	
	public static void main(String[]args)
	{
		boolean fundi = true ;
		Scanner in = new Scanner(System.in);
		
		for (int a=0;a<100;a--){
			fundi = true;
			System.out.println("Fut taksimin e dites ne nr te plote:");
			int x = in.nextInt();
			CashRegister objekt = new CashRegister(x);
			
			while(fundi){
		
				
		System.out.println("Fut cmimin e produktit:");
		double price = in.nextDouble();
		System.out.printf("Taksa per nje  produkt qe kushton %f leke eshte: %f",price,objekt.giveChange(price));
		System.out.println();
		System.out.println("A eshte produkt i taksueshem? po/jo");
		String c = in.next();
		if (c.equalsIgnoreCase("po"))
		
			objekt.recordTaxablePurchase(price);
		else 
		    objekt.recordPurchase(price);
			
		System.out.println("Taksimi total: " + objekt.getTotalTax());
		System.out.println("Vlera e shitjeve total: " + objekt.getSalesTotal());
		System.out.println("Mallara te shitur: " + objekt.getSalesCount());
		
		System.out.println("Mbaroi dita e punes? po/jo");
		String b = in.next();
		
		if(b.equalsIgnoreCase("po"))
		{	
			objekt.reset(); fundi = false;
			}
	  else
	      
			a--;	
			
		}
	      
		}
		
	}
	
}

