package seminari10;

public class uahrrimà 
{
	public static void main(String[] args)
	  {
		int counter = 0;
		int [] t = {5,5,5,5,5,5,5,6};
		
		// sa 5 kemi
		for(int i = 0; i < t.length; i++ )
		{
			if(t[i] == 5)
			{
			counter++;	
			}
		}
		System.out.println(counter);
		
		
		// zhvendosja para
		int c=0;
		while(c<t.length-2 ){
			
			if (t[c]==5){
				for (int i=c;i<t.length-1;i++){
					if(t[i+1]!=5)
						{
						t[c]=t[i+1];
						c++;
						}
					 
					
						}
				
			}
						
			else c++;
	  }
					
			// for i vendosjes se 5-ave ne fund			
		for(int i = t.length - counter; i < t.length; i++)
		{
			t[i] = 5;
		}
		
		
		//for i printmit
		for(int i = 0; i < t.length; i++)
		{
		  System.out.print(t[i]);
		}
	  
	  
	  
	  }


}
