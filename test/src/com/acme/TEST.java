package com.acme;

import com.sun.javafx.geom.Rectangle;

public class TEST {

	
	public static void main(String[]args) {
		
		Rectangle rectangle1 = new Rectangle(10,10,10,100);
		Rectangle rectangle2 = rectangle1;
		rectangle1.x = 20;
		rectangle2.x = 30;
		
		System.out.print(rectangle2.x + " " + rectangle1.x);
		
	}
	

}
