package seminari8;

import java.util.Random;


public class Ushtrimi3
{
     private int[] values;
     private int a;
     public Ushtrimi3(int capacity)
     {
       values = new int[capacity];
       a=0;
     }

     public String giveResult()
    {
	   String answer = "";
	   
       for (int i = 1; i < values.length-1; i++)
     {
   	   if ( i!=20  && values[i] != values[i-1] && values[i] == values[i+1])
   		  answer += " (" + values[i] + "";
   	  
   	   else if ( i!=1 && values[i] == values[i-1] && values[i] != values[i+1])
   		  answer += " "  + values[i] + ")";
   	
   	   else if (i==1 && values[1] == values[i+1] )
   		  answer += " (" + values[i] + "";
   	   
   	 else if (i==values.length-2 && values[values.length-2] == values[i-1] )
   		  answer += " "  + values[i] + ")";
   	   
   	   else
   		  answer +=  " " + values[i] + "";
     }
          return answer;
    }

      public void add(int i) 
      {
	    if(a<=values.length)
	    {
	     values[a] = + i;
	     a++;
	    }
      }

 public static void main(String[] args)
 {
	      final int TOSSES = 22;
	      Random die = new Random();
	      Ushtrimi3 test = new Ushtrimi3(TOSSES);
	     
	      
	      for (int i = 1; i <= TOSSES; i++)
	      {
	         test.add(die.nextInt(6) + 1);
	        
	      }
	     
	      System.out.println(test.giveResult());
	    
	 }      

}