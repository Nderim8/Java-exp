package seminari8;

import java.util.ArrayList;
import java.util.Scanner;

public class Ppraktike7 
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
		   
		   int index = 0;
		   int fjalPerseritura = 0;
		   for(int i=0; i<index1-1; i++)
		   {
		     if(i != index1- fjalPerseritura-2)
			 {	   
				   index = 0;
			   for(int j=1; j<index1; j++)
			   {
				 if(j != index1-1)
				
				   if(list1.get(i).equalsIgnoreCase(list1.get(j-index)) )
				   {
			        list1.remove(j);
			         index =1;
			         fjalPerseritura++;
			        j++;
				   }
				  
			   }
			 }  
		   }   
		   
			   // Shtojme elementet e list1 pasi reduktuam elemetet e perseritura
				 list2.addAll(list1);
				 System.out.println(list2);
			
	}

}
