package seminar3;

public class BankAccount 
{
	public static void main(String[] args)
	{
		BankAccountTester account = new BankAccountTester(0);
		account.deposit(1000);
		//	account.withdraw(500);
		//	account.withdraw(400);
			account.addInterest(10);
		    
		System.out.println("Monyes left:" + account.returnBalance());
		
	}

}
