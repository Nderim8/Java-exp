package seminari8;

import java.util.ArrayList;
import java.util.Scanner;

public class Ppraktike7m2
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		
		 ArrayList <String> list1 = new ArrayList <String>();
		   
		 ArrayList <String> list2 = new ArrayList <String>();
		
		 System.out.println("Fut elementet e listes1 (Fut -1 per te ndaluar) :");
		   
		   String name1;
			int index1 = 0;
			do
			{
			   name1 = in.next();
			   if(!name1.equalsIgnoreCase("-1") )
			   {
			    list1.add(name1);
			    index1++;
			   }
			  
			}while(!name1.equalsIgnoreCase("-1"));
			
		   System.out.println("list1 : ");
		   System.out.println(list1);
		   
		   for(int i=0; i<index1-1; i++)
		   {
		     if(!list2.contains(list1.get(i)))
		     {
		    	 list2.add(list1.get(i));
		     }
			    
		   }   
		   
				 System.out.println("Lista2 : ");
				 System.out.println(list2);
			
	}


}
