package infografia;

import java.util.Scanner;

public class Konvertimi
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Me sa rreshta eshte tabela ? ");
		int rreshta = in.nextInt();
		System.out.println("Me sa kolona eshte tabela ? ");
		int kolona = in.nextInt();
		
		
		
		int [][] tabela = new int[rreshta][kolona];
		
		// Mbushja tabeles me vlera
		
		System.out.println("Fut vlerat e tabeles : " );
		for(int i = 0; i < rreshta; i++)
		{
			// System.out.println("Fut vlerat e rreshtit " + i);
			for(int j = 0; j < kolona; j++)
			{
				int vlera = in.nextInt();
				
				tabela[i][j] = vlera; 
			}
			
		}
		in.close();
		
		int [][] p = new int [2] [rreshta * kolona];
		int nr = 0; 
	    int index = 0;
		int i = 0;
		int temp = tabela[0][0];
		
		while( i < rreshta)
		{
			for(int j = 0; j < kolona; j++)
			{
			   
			   if (temp == tabela[i][j] )
		       {
			       nr ++;
			   }
			   else
			   {
				   p [0][index] = temp;
				   p [1][index] = nr;
				     
				   index ++;
				   temp = tabela[i][j];
				   nr = 1;
				  
			   }
			   
			   if(i == rreshta - 1 &&  j == kolona - 1 )  // rregullimi manual per numrin e fundit
		       {
				 p [0][index] = temp;
				 p [1][index] = nr;
			     //	 index++;   
			   }
			  
		   }
			
			 i ++;
			
		} 
		
		System.out.println("Tabela pas konvertimit : ");      ////////////////////
		
		for(int r = 0; r < 2; r++)
		{
			for(int k = 0; k <= index; k++)
			{
				System.out.print(p[r][k] + " ");
			}
			System.out.println( );
			
		}
		
		
	}

}
