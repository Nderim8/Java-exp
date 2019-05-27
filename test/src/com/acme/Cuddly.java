package com.acme;

import java.util.ArrayList;
import java.util.Random;

public class Cuddly {
	
	public static void main(String[] args) {

		ArrayList<String> reds = new ArrayList<String>();
		ArrayList<String> purples = new ArrayList<String>();
		ArrayList<String> blues = new ArrayList<String>();
		String result = null;

		for (int i = 0; i < 43; i++) {
			reds.add("red");
		}
		for (int i = 0; i < 33; i++) {
			purples.add("purple");
		}
		for (int i = 0; i < 23; i++) {
			blues.add("blue");
		}

		blues.add("blue");
		
		while ( (reds.size() > 0 && blues.size() > 0 ) || (reds.size() > 0 && purples.size() > 0 ) || 
				(blues.size() > 0 && purples.size() > 0 ) ) {
			
			 if(reds.size() == blues.size()) {
				Random random = new Random();
				int r = 1 + random.nextInt(2);
				if(r == 1)
				{
				result = "red";
				blues.remove(blues.get(blues.size()-1));
				}
				else {
					result = "blue";
					reds.remove(reds.get(reds.size()-1));
				}
			}
			else if(reds.size() == purples.size()) {
				Random random = new Random();
				int r = 1 + random.nextInt(2);
				if(r == 1)
				{
				result = "red";
				purples.remove(purples.get(purples.size()-1));
				}
				else {
					result = "purple";
					reds.remove(reds.get(reds.size()-1));
				}
			}
			else if(purples.size() == blues.size()) {
				Random random = new Random();
				int r = 1 + random.nextInt(2);
				if(r == 1)
				{
				result = "purple";
				blues.remove(blues.get(blues.size()-1));
				}
				else {
					result = "blue";
					purples.remove(purples.get(purples.size()-1));
				}
			}
			else if (reds.size() > purples.size() && reds.size() > blues.size()) {

				if (purples.size() > blues.size()) {
					result = "blue";
					reds.remove(reds.get(reds.size() - 1));
					purples.remove(purples.get(purples.size() - 1));
					blues.add("blue");
				} else {
					result = "purple";
					reds.remove(reds.get(reds.size() - 1));
					blues.remove(blues.get(blues.size() - 1));
					purples.add("purple");
				}

			}
			else if (purples.size() > reds.size() && purples.size() > blues.size()) {

				if (reds.size() > blues.size()) {
					result = "blue";
					reds.remove(reds.get(reds.size() - 1));
					purples.remove(purples.get(purples.size() - 1));
					blues.add("blue");
				} else {
					result = "red";
					blues.remove(blues.get(blues.size() - 1));
					purples.remove(purples.get(purples.size() - 1));
					reds.add("red");
				}
			}
			else if (blues.size() > reds.size() && blues.size() > purples.size()) {

				if (reds.size() > purples.size()) {
					result = "purple";
					reds.remove(reds.get(reds.size() - 1));
					blues.remove(blues.get(blues.size() - 1));
					purples.add("purple");
				} else {
					result = "red";
					blues.remove(blues.get(blues.size() - 1));
					purples.remove(purples.get(purples.size() - 1));
					reds.add("red");
				}

			}
			

		} // end while
		
		
		System.out.print(result);
		
	}
}