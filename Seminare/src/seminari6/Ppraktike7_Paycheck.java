package seminari6;

import java.util.Scanner;

public class Ppraktike7_Paycheck 
{
	private double PagaTot;
	private double PagaPerOr;
	private double Oret;
	private double Oretj;
	public Ppraktike7_Paycheck(double pagaPerOr, double oret)
	{
		PagaPerOr = pagaPerOr;
		Oret = oret;
		if (Oret > 40)
		{
			PagaTot = 40 * PagaPerOr + (Oret - 40) * PagaPerOr * 1.5 ; 
		System.out.println("Pagesa totale e puntorit eshte :" + PagaTot);
		}
		else
		{
			PagaTot = Oret * PagaPerOr;
		System.out.println("Pagesa totale e puntorit eshte :" + PagaTot);
		}
	}
	
	
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Fusni pagen per ore te punonjesit : ");
		double pagaPerOr = in.nextDouble();
		
		System.out.println("Fusni oret e punes se  javes se kaluar : ");
		double oretPune = in.nextDouble();
		
		Ppraktike7_Paycheck pagesa = new Ppraktike7_Paycheck(pagaPerOr , oretPune);
		
		in.close();
	}
	
	
}
