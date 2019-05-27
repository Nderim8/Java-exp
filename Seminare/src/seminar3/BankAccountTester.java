package seminar3;

public class BankAccountTester 
{
	private double balance;
	
public BankAccountTester(int a)
{
	balance = a;
	
}

	public void deposit(int b)
	{
		balance += b;
		
	
	}
	public void withdraw(int x)
	{
		balance -= x;
		
	}
	
		
	
	public void addInterest(double rate)
	{
		balance += balance *  rate/100;
	}
	public double returnBalance()
	{
		return balance;
	}
	
/*	public static void main (String[]args)
	{
		BankAccountTester account = new BankAccountTester(0);
		account.deposit(1000);
	//	account.withdraw(500);
	//	account.withdraw(400);
		account.addInterest(10);
		System.out.println("Moneys left:" + account.returnBalance());
	//	System.out.println("Expected: 100");
	}
	*/
}
