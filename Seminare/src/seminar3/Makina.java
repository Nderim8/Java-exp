package seminar3;

public class Makina 
{
   private double Eficenca;
   private double SasiNafte;
   
	public Makina(double eficenca)
	{
		Eficenca = eficenca;
		SasiNafte = 0;
	}
	public void addGas(double nafte)
	{
		SasiNafte += nafte;
		
	}
	public double getGasInTank()
	{
		return SasiNafte;
	}
	
	public void drive(double milje)
	{
		SasiNafte -= milje / Eficenca;
	}
	
	public static void main (String[]args)
	{
		Makina makina = new Makina(100);
		
		makina.addGas(40);
		double a = makina.getGasInTank();
		System.out.println("Nafta e mbetur: " + a);
        makina.drive(500);  
        System.out.println("Nafta e mbetur pas udhetimit: " + makina.getGasInTank());
        
	}
	
}
