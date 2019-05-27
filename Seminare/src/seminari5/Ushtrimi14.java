package seminari5;

import java.util.Scanner;

public class Ushtrimi14 
 {
	private int a;
	   public int max=Integer.MIN_VALUE;
	   public  int min=Integer.MAX_VALUE;
		public  void shtovlerë(int x ){
			 a=x;
			 if (a>=max)
					max=a;
			 
			  if (a<=min)
					min=a;
			 
		}
		public int merrVleraMadhe(){
			
			return max;	
		}

		public int merrVleraVogël(){
			return min;
		}
		public static void main(String[] args){
			Ushtrimi14 objekt = new Ushtrimi14();
		
			System.out.println("Numrat me te vegjel dhe me te medhenj:"
			+Integer.MAX_VALUE+"  "+Integer.MIN_VALUE);
			System.out.println("Jep numrin e numrave qe doni te jepni");
			Scanner test = new Scanner(System.in);
			int numrat=test.nextInt();
			System.out.println("Jep numrat e plote:");
			int i=0;
			while(i<numrat){
			objekt.shtovlerë(test.nextInt());
			
			i++;
			}
			
			
			System.out.println("Vlera me e madhe: "+objekt.merrVleraMadhe());
			System.out.println("Vlera me e vogel: "+objekt.merrVleraVogël());
		}
	}

	

