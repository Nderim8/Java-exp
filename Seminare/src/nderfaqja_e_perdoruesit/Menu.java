package nderfaqja_e_perdoruesit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
//	A dime is worth 10 cents and is equal to 2 nickels or 10 pennies.
//	A nickel is worth 5 cents and is equal to 5 pennies. Two nickels have the same value as 1 dime
//	A penny is worth 1 cent. Five pennies have the same value as 1 nickel. Ten pennies 
//	 have the same value as 1 dime.

	private static final double QUARTER = 0.25;
	private static final double DIME = 0.1;
	private static final double NICKEL = 0.05;
	private static final double PENNY = 0.01;
	
	private Color color;
	
	private JLabel label;
	private JPanel panel;
	
	private String emri = "file1";
	
	private double totali = 0;
	
	public Menu()
	{
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		setLayout(new BorderLayout());
		
		 panel = new JPanel();
		panel.setBackground(color);
		add(panel,BorderLayout.CENTER); 
		
        label = new JLabel("Totali : " + totali + "$");
		add(label, BorderLayout.SOUTH);
		
		menuBar.add(createFileMenu());
		menuBar.add(createAddMenu());
		menuBar.add(createColorMenu());
		
	
	}
	
	public JMenu createColorMenu()
	{
		JMenu menu3 = new JMenu("Color");
		menu3.add(createRedItem());
     	menu3.add(createGreenItem());
        menu3.add(createBlueItem());
		
		return menu3;
	}

	public JMenuItem createRedItem()
	{
		JMenuItem red = new JMenuItem("Red"); 
		red.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				panel.setBackground(Color.red);
			
			}
		
			
		} );
		
		return red;
	}
	public JMenuItem createGreenItem()
	{
		JMenuItem green = new JMenuItem("Green"); 
		green.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				panel.setBackground(Color.green);
			
			}
		
			
		} );
		
		return green;
		
	}
	public JMenuItem createBlueItem()
	{
		JMenuItem blue = new JMenuItem("Blue"); 
		blue.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				panel.setBackground(Color.blue);
			
			}
		
			
		} );
		
		return blue;
	} 
	
	public JMenu createAddMenu()
	{
		JMenu menu2 = new JMenu("Add");
		menu2.add(createPenniesItem());
		menu2.add(createDimesItem());
		menu2.add(createNickelsItem());
	    menu2.add(createQuartersItem());
       
		return menu2;
		
	}
	
	public JMenuItem createNickelsItem()
	{
		JMenuItem item1 = new JMenuItem("Nickels");
		
		item1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				String sasia = JOptionPane.showInputDialog( "How many nickels : " );
				String string;
				
					double sas = Double.parseDouble( sasia );
				    totali = totali + (sas * NICKEL);
				  
				   label.setText("Totali : " + totali + "$");   
				  
			}
	
			 
		});
		
		return item1;
		
	}
	
	public JMenuItem createDimesItem()
	{
		JMenuItem item2 = new JMenuItem("Dimes");
		
		item2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				String sasia = JOptionPane.showInputDialog( "How many dimmes : " );
				
				
					double sas = Double.parseDouble( sasia );
				    totali += sas * DIME ;
				    
				    label.setText("Totali : " + totali + "$");
			}
	
			
		});
		
		return item2;
		
	}
	
	public JMenuItem createPenniesItem()
	{
		JMenuItem item3 = new JMenuItem("Pennies");
		
		item3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				String sasia = JOptionPane.showInputDialog( "How many pennies : " );
				
				
					double sas = Double.parseDouble( sasia );
				    totali += sas * PENNY;
				    
				    label.setText("Totali : " + totali + "$");
			}
	
			
		});
		
		return item3;
		
	}
	
	public JMenuItem createQuartersItem()
	{
		JMenuItem item4 = new JMenuItem("Quarters");
		
		item4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				String sasia = JOptionPane.showInputDialog( "How many quarters : " );
				
				
					double sas = Double.parseDouble( sasia );
				    totali += sas * QUARTER ;
			
				    label.setText("Totali : " + totali + "$");
			}
	
			
		});
		
		return item4;
		
	}
	
	
	
	
	public JMenu createFileMenu()
	{
		JMenu menu1 = new JMenu("File");
		menu1.add(createFileNewItem());
		menu1.add(createFileOpenItem());
		menu1.add(createFileSaveItem());
		menu1.add(createFileExitItem());
		
		return menu1;
		
	} 
	
	
	public JMenuItem createFileNewItem()
	{
		JMenuItem item1 = new JMenuItem("New");
		
		item1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
			   newFile();
				
			}
			
		});
		
		return item1;
		
	}
	
	public JMenuItem createFileOpenItem()
	{
		JMenuItem item2 = new JMenuItem("Open");
		
		item2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = JOptionPane.showInputDialog( "Open file : " );
				openFile(name);
			}
			
		});
		
		return item2;
		
	}
	
	public JMenuItem createFileSaveItem()
	{
		JMenuItem item3 = new JMenuItem("Save");
		
		item3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				String name = JOptionPane.showInputDialog( "Write the name of the new file : " );
				
				saveFile(name);
			}
			
		});
		
		return item3;
		
	}
	
	public JMenuItem createFileExitItem()
	{
		JMenuItem item4 = new JMenuItem("Exit");
		
		item4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
			     	System.exit(0);
			}
			
		});
		
		return item4;
		
	}

	private void newFile()
	{
		
		try
		{
		  File file = new File("");
	//	  FileWriter fileWriter = new FileWriter(file);
	//	  FileReader fileReader = new FileReader (file);
		
		  
		}
		catch(Exception ex) 
		{
			
			ex.printStackTrace();
		}
	}
	
	private void openFile(String s)
	{
		try
		{
		   FileReader file = new FileReader (new File(s));
		
		}
		catch(Exception ex) 
		{
			System.out.println("File " + s + " does not exist!");
			ex.printStackTrace();
		}
	}
	
	private void saveFile(String s)
	{
		try
		{
		   FileWriter file = new FileWriter(s);
		
		}
		catch(Exception ex) 
		{
			
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new Menu();
		frame.setTitle("Menu");
		frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      
	}

}




