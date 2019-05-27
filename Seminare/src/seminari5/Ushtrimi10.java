package seminari5;

import java.util.Scanner;

public class Ushtrimi10 {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Fut dy numra :");
	//	for ( int i=0;i<2;i++)
	//	{
		 double a = in.nextDouble();
		 double b = in.nextDouble();
	//	}
		double shuma = a + b;
		double diferenca = a - b;
		double prodhimi = a * b;
		double mes = (a + b) / 2.0 ;
		
		double distanca = a - b;
		if (distanca < 0)
		
			distanca = distanca * -1 ;
		else  ;
		
		double max = a , min = a;
		if(b > a)
			max = b;
		else 
			max = a;
		
		if(b < a)
			min = b;
		else 
			min = a;
		
		System.out.printf("Shuma e %f + %f = % f \n", a , b , shuma);
		
		System.out.println(a + "-" + b + "=" + diferenca);
		System.out.println(a + "*" + b + "=" + prodhimi);
		System.out.println("Mesatarja : " + mes);
		System.out.println("Distanca : " + distanca);
		System.out.println("Maksimumi : " + max);
		System.out.println("Minimumi : " + min);
		
	}

}
