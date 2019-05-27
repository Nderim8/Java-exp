package seminar3;

public class Population 
{
	private int Popullsia;
	
	public Population(int popullsia)
	{
		Popullsia = popullsia;
		
	}
	public void multiplyPopulation(int shumfishi)
	{
		Popullsia *= shumfishi;
	}
	public void reducePopulation(int percentage)
	{
		Popullsia -= Popullsia * percentage/100 ;
	}
	
	public int returnPopulation()
	{
		return Popullsia;
	}
	
	public static void main(String[]args)
	{
		Population dibran = new Population(1000);
		
		System.out.println("Numri aktual i popullsise dibrane: " + dibran.returnPopulation());
		dibran.multiplyPopulation(2);
		System.out.println("Numri i popullsise pas shumfishimit: " + dibran.returnPopulation());
	    dibran.reducePopulation(10);
	    System.out.println("Numri i popullsise pas zvoglimit: " + dibran.returnPopulation());
	    
	    System.out.println();
	    
	    Population shkodran = new Population(1500);
	    System.out.println("Numri aktual i popullsise shkodrane: " + shkodran.returnPopulation());
		shkodran.multiplyPopulation(3);
		System.out.println("Numri i popullsise pas shumfishimit: " + shkodran.returnPopulation());
	    shkodran.reducePopulation(20);
	    System.out.println("Numri i popullsise pas zvoglimit: " + shkodran.returnPopulation());
	    
	}

	
	
}
