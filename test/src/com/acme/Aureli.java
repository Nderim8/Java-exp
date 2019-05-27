package com.acme;

import java.util.Scanner;

public class Aureli {

       static int[] numbers = new int[5];
	
public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
	    System.out.println("Input your numbers! ");
	    for(int i=0; i<5; i++) {
	    	 int k = in.nextInt();
	    	 numbers[i] = k;
	    }
	   
	    System.out.println("The log of those numbers are :");
	    for(int i=0; i<5; i++) {
	    	double[] nr = log(numbers);
	      System.out.println(nr[i]);
	     
	    }
	    System.out.println("The squareRoot of those numbers are :");
	    for(int i=0; i<5; i++) {
	    	double[] nr = squareRoot(numbers);
	      System.out.println(nr[i]);
	     
	    }
}

public static double[] log( int[] numbers ) {
	
	double[] test = new double[5];
	double nr = 0;
	for(int i=0; i<5; i++) {
		
	  nr = Math.log(numbers[i]);
	  test[i] = nr;
		
	}
	return test;
}
	
public static double[] squareRoot( int[] numbers ) {

	double[] test = new double[5];
	double nr = 0;
	for(int i=0; i<5; i++) {
		
	  nr = Math.sqrt(numbers[i]);
	  test[i] = nr;
		
	}
	return test;
	
}


}
