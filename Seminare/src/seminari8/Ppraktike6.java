package seminari8;

import java.util.ArrayList;
import java.util.Scanner;

public class Ppraktike6 
{
   public static  void main(String[]args)
   {
	   Scanner in = new Scanner(System.in);
	   
	   ArrayList <String> list1 = new ArrayList <String>();
	   
	   ArrayList <String> list2 = new ArrayList <String>();
	   
	   ArrayList <String> list3 = new ArrayList <String>();

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
	   
 System.out.println("Fut elementet e listes2 (Fut -1 per te ndaluar) :");
	   
	   String name2;
		int index2 = 0;
		do
		{
		   name2 = in.next();
		   if(!name2.equalsIgnoreCase("-1") )
		   {
		    list2.add(name2);
		    index2++;
		   }
		  
		}while(!name2.equalsIgnoreCase("-1"));
		
	   System.out.println("list2 : ");
	   System.out.println(list2);
	   
	   
	 // Mund te shtojme elemente te list2 ne list1 sa te duam   
	//   for(int i=0; i < index2; i++)
	   
		  
	    list3.addAll(list1);
	    list3.addAll(list2);
	    System.out.println("Bashkimi i list1 me list2 : ");
	    System.out.println(list3);
	   
	   
   }
   
}
