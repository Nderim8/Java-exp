package seminari6;

import java.util.Scanner;

public class Ppraktike4_VitiBrisht 
{
	
	public static void  main(String[]args)
	{ 
		Scanner in = new Scanner(System.in);
		
		System.out.println("Fut vitin : ");
		int viti = in.nextInt();
	/*	
		if (viti % 4 == 0) 
		{
			if (viti % 100 != 0 )
				System.out.println("Eshte vit i brisht.");
			
			 if (viti % 100 == 0 && viti % 400 == 0)
				System.out.println("Eshte vit i brisht.");
			
			// if(viti % 100 ==0 && viti %  400 !=0 )
			//	System.out.println("Nuk eshte vit i brisht.");
			 else 
				 System.out.println("Nuk eshte vit i brisht.");
				 
		}
		else 
			System.out.println("Nuk eshte vit i brisht.");    */
    
	//	Zgjidhje me e shkurter
		
		 if (viti % 4 == 0 && viti % 100 != 0 || viti % 400 == 0 )
		System.out.println("Eshte vit i brisht.");
		
	     else 
		System.out.println("Nuk Eshte vit i brisht.");
   
	}	
		
}
