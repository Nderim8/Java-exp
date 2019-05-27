package skedaret_tekst_binar;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ASCII
{
	public void askii_Stream(InputStream in , FileWriter out)
	throws IOException
	{
		boolean done = false;
		while(!done)
		{
			int next = in.read();
			if(next == -1)
				done = true;
			else
			{
				
				String c = (int) next + "";
				out.write(c+" ");
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		try
		{
			System.out.print("Input file: ");
			String inFile = in.next();
			System.out.print("Output file: ");
			String outFile = in.next();
			in.close();
			
			InputStream inStream = new FileInputStream(inFile);
			FileWriter outStream = new FileWriter(outFile);
			
			ASCII asc = new ASCII();
			asc.askii_Stream(inStream, outStream);
			
			inStream.close();
			outStream.close();
			
		}
		catch(IOException exception)
		{
		System.out.println("Error processing file: " + exception);	
		}
	}
	
	
}
