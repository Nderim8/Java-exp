package seminari8;

public class Ppraktike2 
{
	public static void main(String[]args)
	{
		int[] tabela = {8, 2, 5, 10};
		int sum = 0;
		
		for(int i=0; i<tabela.length; i++)
		{
			if(i % 2 == 0 )
			{
				sum = sum + tabela[i];
				System.out.print("+ " + tabela[i] + " ");
			}
			else
			{
				sum = sum - tabela[i];
			    System.out.print("- " + tabela[i] + " ");
			}	
		}
		System.out.println(" = " + sum);
		
		System.out.println("Shuma e elementeve te tabeles sipas sekuences se deshiruar eshte : "+sum);
	}
	
}
