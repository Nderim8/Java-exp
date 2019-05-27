package seminari6;

public class Ppraktike9
{
	private double X;
	private double Y;
	private double R;
	
	private double xPikes;
	private double yPikes;
	
	public Ppraktike9(double x , double y , double r)
	{
		X = x;
		Y = y;
		R = r;
		
	}
	public void  shtoPike(double a , double b)
	{
		xPikes = a;
		yPikes = b;
		boolean brenda = false;
		
		//Math.sqrt( (x-xPikes) * (x-xPikes) + (y-yPikes) * (y-yPikes) ) <= r 
	  if( (Math.pow((X - xPikes) * (X - xPikes) + (Y - yPikes) * (Y - yPikes), 0.5)) <= R ) 
	  brenda = true;
	  else
		  brenda = false;
	   if(brenda)
		   System.out.println("Urime ju jeni brenda rrethit");
	   else
		   System.out.println("Ju nuk jeni brenda rrethit");
		   
			   
	}
	public static void main(String[]args)
	{
		Ppraktike9 test = new Ppraktike9(100,200,100);
		test.shtoPike(120 , 230);
		
	}
}