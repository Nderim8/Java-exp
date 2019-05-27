package seminari8;

import java.util.*;
import java.util.ArrayList;
public class Ppraktike5R 
{
	
public static void main(String [] args){
	ArrayList <String> listaemra = new ArrayList<String>();
		
	
	Scanner test = new Scanner(System.in);
	System.out.println("Fusni emrat: (-1 per ndalim)");
	
	String temp ;
	
	
	String a = test.nextLine();
		while(!a.equals("-1") ){
			
		listaemra.add(a);
		
		a=test.nextLine();
		}	
		
		
		for (int i = 0;i<listaemra.size()-1;i++){
			for(int j=i+1;j<listaemra.size();j++){
				if (listaemra.get(i).compareTo(listaemra.get(j))>0){
					temp=listaemra.get(i);
					listaemra.set(i, listaemra.get(j));
					listaemra.set(j, temp);
				}
					
			}
		}
		System.out.println(listaemra);
		
	}
}
