package seminari8;

import java.util.ArrayList;
import java.util.Scanner;

public class Ppraktike5 
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
				
	    String temp; 	
		String temp1;
	    String temp2;
		
	   for(int b=0; b< index -1; b++ )
	   {	   
		   temp1 = "" + names.get(b); 
		   
	    for(int j=1; j < index; j++ )
	    {
	    
	     temp2 =  "" + names.get(j);
          if( temp1.compareTo(temp2) > 0)
          {
        	  names.set(b, temp2);
        	  names.set(j, temp1);
        	  
        	  temp = temp1;
        	  temp1 = temp2;
          }
	     
      
        }
          
          // Veprmet brenda 2 cikleve for 
           System.out.println(names);
        }
	   
     
	    System.out.println("ArrayList perfundimtare : "); 
	    System.out.println(names);
 }
}