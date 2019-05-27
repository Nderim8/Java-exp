package purse;


public class Purse {
	private static  int CurID=0;
	private double balanceKorente;
	private int PurseId;
	public Purse()
	{
		this.balanceKorente=0;
		this.PurseId=CurID;
		CurID++;
	}
	public Purse(int aId,double aBalance)
	{
		this.balanceKorente=aBalance;
		this.PurseId=aId;
	}
	public void shtoQindeshe(int num)
	{
		this.balanceKorente+=num*100;
	}
	public void shtoMijeshe(int num)
	{
		this.balanceKorente+=num*1000;
	}
	public void shtoDhjeteshe(int num)
	{
		this.balanceKorente+=num*10;
	}
	public double ktheBalancenKorente()
	{
		return this.balanceKorente;
	}
	public int ktheID()
	{
		return PurseId;
	}
	
}
