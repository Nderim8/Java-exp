package seminari5;

public class Ushtrimi1 
{

	public static void main(String[] args) 
	{
		double π = 3.14159 , a = 2 , p = 3 , m1 = 2 , m2 = 4 ;  
		
		double  b = 5 , ɣ = 60 ;
		
		double G = 4 * π * π * ( (Math.pow(a, 3)) / (p * p) * (m1 + m2) ) ;
		
		System.out.println(G);
		
		
		double c = Math.sqrt(a * a + b * b - (2 * a * b) * Math.cos(ɣ) );
		
		System.out.println(c);
		
		
		double x = 3.6563;
		int n = (int) x ;
		int m = (int) Math.round(x); 
		System.out.println(n + "  " + m);
		
		
		double v = 2.64;
		int z = (int) (v + 0.5) ;
		int f = (int) Math.round(v);
		System.out.println(z + "  " + f);
		
		
		int x1 = 21; 
		String s = "1234";
		
	   String sh = "" + Integer.parseInt(s) + x1;
	    System.out.println(sh);
	    
	    System.out.println(s.substring(0,s.length()- 1));
		
		

	}

}
