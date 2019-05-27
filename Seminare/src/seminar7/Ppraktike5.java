package seminar7;

import java.util.Scanner;

public class Ppraktike5 
{
	public static void main(String[]args)
	{
	  Scanner in = new Scanner(System.in);
	
	  String  p;
	  float s = 0;
	  float x;
	  float mes;
	  float dev;
	  int n = 0;
	  System.out.println("Fut numrat me presje (float) te cileve do tu gjejm mesataren"
	  		+ " dhe devijimin standart : ");
	  
	  do
      {
	 	x = in.nextFloat();
		n++;
	    s += x;
	    mes = s/n;
	    dev =(float) Math.sqrt( ( s*s - (s*s)/n )/n-1 ) ;
	    
	    System.out.println("Deshironi te jepni nje numer tjeter ? (Shtyp ndalo per te perfunduar)");
	    p = in.next();
      }
	    
	    while(!p.equalsIgnoreCase("ndalo"));
	  
	  if(p.equalsIgnoreCase("ndalo"))
	  {
		  System.out.println("Mesatarja e ketyre numrave eshte : " + mes);
		  System.out.println("Devijimi standart i ketyre numrave eshte : " + dev);
	  }
		
   }	
	
}
