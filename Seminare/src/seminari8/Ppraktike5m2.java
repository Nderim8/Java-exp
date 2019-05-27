package seminari8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ppraktike5m2 
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
	//	System.out.println("Sa strigje deshironi te jepni ? ");
   // int nr = in.nextInt();
		
		ArrayList names = new ArrayList();
		
		System.out.println("Ju lutem jepni stringjet (Fut -1 per te ndaluar): ");
		
			String name;
			int index = 0;
			do
			{
			   name = in.next();
			   if(!name.equalsIgnoreCase("-1") )
			   {
			    names.add(index, name);
			    index++;
			   }
			  
			}while(!name.equalsIgnoreCase("-1"));
			
			
		Collections.sort(names);
	  
	    System.out.println(names);
		
     }
          
        
}
