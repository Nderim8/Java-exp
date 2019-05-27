import java.util.Scanner;


public class redKnight
{
	
	
	public static void main(String[]args)
	{
	  
		int n, xi, yi, xf, yf;
		   
		Scanner in = new Scanner(System.in);
		
		do{
		
     	System.out.println("Input the correct values, n must be <=200 , xi,yi,xf,yf must all be >=0 and <=199 ");
			
	  System.out.println("Input the n");
	   n = in.nextInt();
	   
		System.out.println("Input the xi");
		xi = in.nextInt();
		System.out.println("Input the yi");
		yi = in.nextInt();
		System.out.println("Input the xf");
		xf = in.nextInt();
		System.out.println("Input the yf");
		yf = in.nextInt();
		
		}
		while( (xi<0 || xi>199) || (yi<0 || yi>199) || (xf<0 || xf>199) || (yf<0 || yf>199) || (n < 5) || (n>200)  );
		
		  redKnight rK = new redKnight();
		  rK.moves(n, xi, yi, xf, yf);
		
		  in.close();	
		
	}	
	
	
	
	public void moves(int n, int xi, int yi, int xf, int yf)
    {
		
	    int m = 0;
	    boolean possible = true;
	 
	    if( xf > n || yf > n)
	    {
	    	possible = false;
	    }
	    if( xi > n || yi > n)
	    {
	    	possible = false;
	    }
	  
	    if( Math.abs((xf-xi)) % 2 == 1){
	    	possible = false;
	    }
	    else
	    if( Math.abs((xf-xi)) % 4 == 0 &&  Math.abs((yf-yi)) % 2 == 1){
	    	possible = false;
			}
	    else
	    if(Math.abs((xf-xi)) % 2 == 0 && Math.abs((xf-xi)) % 4 != 0 &&  Math.abs((yf-yi)) % 2 == 0){
	    	possible = false;
			}
	    else{
	    	
	    	if(yf !=yi && (yf >= yi - (Math.abs(xf -xi) /2) ) && (yf <= yi + Math.abs(xf -xi) /2 ) ){
	    		
	    		
	    		m = Math.abs(xf-xi) / 2;
	    		
	    	}
	    	else
	    		if(yf !=yi && yf <= yi - (Math.abs(xf -xi) /2)  ){
	    		 m = Math.abs(yf- ((Math.abs(xf-xi)  / 2 ) + yi ))/2;
	    		 
		    	 }
	    		else
		    		if(yf !=yi && yf >= yi + (Math.abs(xf -xi) /2 ) ){
		    		 m = Math.abs(yf - ((Math.abs(xf-xi)  / 2 ) + yi ))/2 +Math.abs(xf-xi)  / 2 ;
		    		
			    	 }
		    else
	    		if(yf==yi ){
	    		 m = Math.abs(xf-xi)  / 2  ;
	    		 
		    	 }
	    		    	
	 		}
		

	    if(!possible)
		{
			System.out.println("Impossible");
		}
		else
		{
		  System.out.println( m );
		}
		
		 int Left=0, Right=0, UpperLeft=0, UpperRight=0, LowerLeft=0, LowerRight=0;
		
		 if(xi>xf && yf < yi - (Math.abs(xf -xi) /2) ) 
	 		{
	 			UpperLeft =   Math.abs(xf-xi) / 2; 
	 			 
	 			 Left = Math.abs(yf - (yi - (Math.abs(xf-xi) / 2)))/2 ;
	 		}
	 		
	 		 if( xi>xf &&  yf > yi + Math.abs(xf -xi) /2)
	 		{
	 			UpperRight =  Math.abs(xf-xi)/2 ;
	 			 
	 			Right = Math.abs(yf - (yi + (Math.abs(xf-xi)/2)))/2;	
	 		}
	 		 
	 		 if(xi>xf &&  (yf >= yi - (Math.abs(xf -xi) /2) ) && (yf <= yi + Math.abs(xf -xi) /2 )  )
	 			{
	 				UpperLeft =  ((yi + Math.abs(xf-xi)/2) - yf)/2;
	 				 
	 				UpperRight = (Math.abs(xf-xi)/2) - (((yi + Math.abs(xf-xi)/2) - yf)/2);	
	 			}

	 		 if(xf>xi &&  (yf >= yi - (Math.abs(xf -xi) /2) ) && (yf <= yi + Math.abs(xf -xi) /2 )  )
	 			{
	 				LowerLeft =  ((yi + Math.abs(xf-xi)/2) - yf)/2;
	 				 
	 				LowerRight = (Math.abs(xf-xi)/2) - (((yi + Math.abs(xf-xi)/2) - yf)/2);	
	 			}
	 			if(xf>xi && yf < yi - (Math.abs(xf -xi) /2) ) 
	 			{
	 				LowerLeft =   Math.abs(xf-xi) / 2; 
	 				 
	 				 Left = Math.abs(yf - (yi - (Math.abs(xf-xi) / 2)))/2 ;
	 			}
	 			 if( xf>xi &&  yf > yi + Math.abs(xf -xi) /2)
	 				{
	 					LowerRight =  Math.abs(xf-xi)/2 ;
	 					 
	 					Right = Math.abs(yf - (yi + (Math.abs(xf-xi)/2)))/2;	
	 				}
	  
	    if(possible)
	    {
	    
		 for(int i = 0; i < UpperLeft; i++)
		 {
			 System.out.print("UL ");
		 }
		
		 for(int i = 0; i < UpperRight; i++)
		 {
			 System.out.print("UR ");
		 }
		 for(int i = 0; i < Right; i++)
		 {
			 System.out.print("R ");
		 }
		
		 for(int i = 0; i < LowerRight; i++)
		 {
			 System.out.print("LR ");
		 }
		 for(int i = 0; i < LowerLeft; i++)
		 {
			 System.out.print("LL ");
		 }
		 for(int i = 0; i < Left; i++)
		 {
			 System.out.print("L ");
		 }
	  
	    }
	     
	  }

	
	
}