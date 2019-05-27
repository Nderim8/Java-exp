package seminar3;

public class SavingsAccount 
{
	private double Balance;
	private double Interest;
	
	public SavingsAccount(double balance,double interest)
	{
		Balance = balance;
		Interest = interest;
		
	}

	public void addInterest(double rate)
	{
        Balance += Balance * rate/100;
		
	}
	public double returnBalance()
	{
		return Balance;
	}
	
}
