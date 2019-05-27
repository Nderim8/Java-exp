package com.acme;
class Solution {
	
	public int solution(int[] A) {
		// write your code in Java SE 8

		// sort the list
		for (int s = 0; s <= A.length - 1; s++) {
			for (int k = 0; k <= A.length - 2; k++) {
				if (A[k] > A[k+1] ) { // comparing list values

					int temp = 0;
					temp = A[k]; // storing value of list in temp variable

				A[k] = A[k+1]; // swaping values
				A[k+1] = temp; // now storing temp value in list

				} // end if block
			} // end inner loop
		}
		// end outer loop

		/////////////////////
		boolean foundOne = false;
		int value = 1;
	
		for (int s = 0; s <= A.length - 2; s++) {
           if(A[s] == 1)
        	   foundOne = true;
			
			if (A[0] > 1 ) {
				value = 1;
				return value;
			}
			
		  if(A[s] > 0) 
		  {
			if ( A[s] + 1 < A[s+1] ) {
				value = A[s] + 1; 
				break;

			} else {
				value = A[s+1] + 1; 
			}
		  }
		}
		
		if(A[A.length-1] == 1)
			return 2;

		if(foundOne)
		  return value;
		else
			return 1;
	}
   
	public static void main(String[] args) {
		int A[] = {1, 3, 6, 4, 1, 2};
		Solution test = new Solution();
	
	    System.out.println( test.solution(A) );

      String x = "test";
      if(x == "test")
    	  System.out.println( "yes" );
      if(x.equals("test") )
    	  System.out.println( "yes" );
      if("test".equals(x))
    	  System.out.println( "yes" );
      

      System.out.println( String.format("id = %08.2f", 423.147) );


	}
}