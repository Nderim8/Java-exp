package bank;

public class BankAccount {
private double balance;
private int accountNumber;

public BankAccount(int accountNumber, double abalance)
{
	this.accountNumber = accountNumber;
	this.balance = abalance;
}
public void deposit(double interes)
{
	balance = balance + interes;
}

public void delete(int accountNumber)
{
	balance = 0;
}
public double getBalance()
{
	return balance;
}

public int getAccountNumber()
{
	return accountNumber;
}
}
