package provimi10;

public class product 
{
	
	private String emrip;
	private double cmimip;
	
	public product(String emri, double cmimi)
	{
		emrip = emri;
		cmimip = cmimi;
		
		if (cmimip <= 1000)
		{
			cmimip -= 3;
		}
		else
			cmimip += 2;
		
	}
	public String getName()
	{
		return emrip;
	}
	public double getPrice()
	{
		return cmimip;
	}
	

}
