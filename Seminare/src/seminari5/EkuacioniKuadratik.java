package seminari5;

public class EkuacioniKuadratik 
{
	private double A;
	private double B;
	private double C;
	private double D;

	
	public EkuacioniKuadratik(double a , double b , double c)
{
		A = a;
		B = b;
		C = c;
		D = B * B - 4 * A * C ;
		
		if (D < 0)
			System.out.println("Ekuacioni nuk ka zgjidhje (dallori esht negativ)!!");
		else 
			return;
}
			public double merrZgjidhje1()
			{
				double x1 = (-B + ( Math.sqrt(D) ) ) / 2 * A;
				return x1;
			}
			
			public double merrZgjidhje2()
			{
				double x2 = (-B - ( Math.sqrt(D) ) ) / 2 * A;
				return x2;
			
		    }
			 
			
	public static void main(String[]args)
	{
		EkuacioniKuadratik ek1 = new EkuacioniKuadratik(1,-3,1);
		
		  double z1 = ek1.merrZgjidhje1();
		  System.out.println("Zgjidhja e pare eshte : " +  z1);
		
		  double z2 = ek1.merrZgjidhje2();
		  System.out.println("Zgjidhja e dyte eshte : " + z2);
		  
		  
	}
	

}
