



public class redKnight3 {
	
	public static void main(String[]args)
	{
	  
		int xi = 8, yi = 8, xf = 14, yf = 8;
		  
	    int m = 0;
	    boolean possible = true;
	 
	  
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
	    		
	 			 if(!possible)
	 				 System.out.print("Impossible");
	 			 
	    		System.out.println(m + " ");
	    		
	    		 
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
	

