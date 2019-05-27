package seminari5;

public class Ushtrimi7 
{
	public static void main (String[]args)
	{
		int n = 4;  int i;    String a , b , c , d ;

		String s = "Hello";

		String t = "World";

		a = s + t;

		b = s + n;

		c = n + t;

		d = s.substring(1, n);

		i = s.length() + t.length();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(i);
		
		System.out.println("Ushtrimi 8: ");
		
		String stringu = "laptop";
		System.out.println(stringu);
		
		System.out.println("Merr karakterin e pare te fjales : ");
		System.out.println(stringu.charAt(0));
		
		System.out.println("Merr karakterin e fundit te fjales : ");
		System.out.println(stringu.charAt(stringu.length()-1));
		
		System.out.println("Heq karakterin e pare te fjales : ");
		System.out.println(stringu.substring(1,stringu.length()));
		
		System.out.println("Heq karakterin e fundit te fjales : ");
		System.out.println(stringu.substring(0,stringu.length()-1));
		
	}

}
