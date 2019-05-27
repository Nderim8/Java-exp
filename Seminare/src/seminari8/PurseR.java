package seminari8;

import java.util.ArrayList;
public class PurseR {
private ArrayList<String> monedha ;

public PurseR()
{
	
monedha = new ArrayList<String>();

}
	
	public void addCoin (String coinName){
		
		monedha.add(coinName);
			
		
	}
	
	public   String toString()
	{
				 		
		return "Purse"+monedha;
		
	}
	
	public String reverse(){
		String b;
		int j=0;
		for (int i=monedha.size()-1;i>(monedha.size()-1)/2;i--){
			b=monedha.get(i);
		    monedha.set(i,monedha.get(j));
		    monedha.set(j, b);
		    j++;
		    }
		return "Purse"+ monedha ;
	}
	
	public static void main(String[] args){
		
		PurseR objekt = new PurseR();
	
		objekt.addCoin("Quarter");
		objekt.addCoin("Dime");
		objekt.addCoin("Wickel");
		objekt.addCoin("Dime");
		
	System.out.println(objekt);
	System.out.println(objekt.reverse());
	
	}
}
