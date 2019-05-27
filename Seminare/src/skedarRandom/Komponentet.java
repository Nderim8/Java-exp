package skedarRandom;

/* Lexon te dhenat e nje skedari nqs ekziston , nqs jo athere jep mundesine e krijimit te nje skedari te ri me 10 emra 
 * random automjetesh si dhe gjenerohen ne pozicione random . Ne fund te leximit apo krijimit te skedarit vizatohen te gjithe automjetet
 * sipas emrave dhe pozicioneve korrespondues.
 * 
 * Punoi: Nderim Kurti.
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class Komponentet extends JComponent
	{
	 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private ArrayList<Automjet> automjet;
		
		public Komponentet(ArrayList<Automjet> Automjet)
		{
			automjet = Automjet;
			
		}
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			for(int i = 0; i < automjet.size(); i++)
			{
				automjet.get(i).vizato(g2);   // (.draw)
				
			}
			
		}
		
		public static void main(String[] args)
		{
			Komponentet komponentet;
			Random rand = new Random();
			
			String fileName = "";
			
			while(fileName.isEmpty())
			{
			   fileName = JOptionPane.showInputDialog("Fut emrin e skedarit : ");
			}
			
			String mjeti = " ";
			
			ArrayList<String> aList = new ArrayList<String>();
			
			ArrayList <Automjet> a = new ArrayList<Automjet>();
		
		if(!fileName.isEmpty())
		 {	
			
			// lexo skedarin
						try
						{
						 
						  File file =new File(fileName);
						  if(file.exists())
						  {
							  
							BufferedReader input = new BufferedReader(new FileReader(fileName));
							if(!input.ready())
							{
							   extracted();  // throws IOException, 
							}
							while( (mjeti = input.readLine()) != null )
					     	{
						       aList.add(mjeti);
						       if(mjeti.equals("makine"))  /////////NK/////////////
						         a.add(new Automjet("makine"));
						       else if(mjeti.equals("kamion"))
						    	   a.add(new Automjet("kamion"));
						       
					     	}

							   input.close();
						  }	// end if(file.exist())
						   else    // nqs nuk ekziston 
						   {
					 int pergjigje = 
				  	JOptionPane.showConfirmDialog(null,"Ky skedar nuk ekziston, deshironi ta krijoni me element random ?");
							 if(pergjigje == 0) // yes
						     {	 
							    // shkruaj skedar
							   aList = new ArrayList<String>();
								for(int i = 0; i < 10; i++)
								{
								    int numri;
								    
								    numri = rand.nextInt(2);
							  
								    if(numri == 0)
								    {
								    	mjeti = "makine";
								        a.add(new Automjet(mjeti) );
								    	aList.add(mjeti);
								    	
								    }
								    else
								    {
								    	mjeti = "kamion";					    
								    	a.add(new Automjet(mjeti) );
								    	aList.add(mjeti);
								    }
						       }
						
								FileWriter fw = new FileWriter(fileName);
								Writer output = new BufferedWriter(fw);
								
								for(int i = 0; i < aList.size(); i++ )
								{
									output.write(aList.get(i) + "\n");
								}
								
								output.close();
							
						    } // end if( pergjigje == 0 )
							 else  // pergjigja eshte no ose cancel
								 return;
							
						   } // end else
						} // end try
						catch(IOException e )
						{
							System.out.println(e);
						
						}
				
						for(int i = 0; i < aList.size(); i++)
						{
							System.out.println(aList.get(i).toString());  
						
							
						}
		
						
		} // end if(!fileName.isEmpty();
		
		komponentet = new Komponentet(a);
	
			JFrame frame = new JFrame();
		
			frame.add(komponentet);
			frame.setTitle("Komponentet");
			frame.setSize(500, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setResizable(true);
			frame.setVisible(true);
			
			
		}

		private static void extracted() throws IOException {
			throw new IOException();
		}
	
	}

