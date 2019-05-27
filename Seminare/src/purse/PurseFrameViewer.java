package purse;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class PurseFrameViewer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenu add;
	
	private JMenuItem open;
	private JMenuItem exit;
	private JMenuItem save;
	private JMenuItem dhjeteshe;
	private JMenuItem qindeshe;
	private JMenuItem mijeshe;
	private JMenuItem newPurse;
	
	private Purse myPurse;
	private JLabel purse_ID;
	private JLabel purse_Balance;
	
	private JPanel infoKeeper;
	public PurseFrameViewer()
	{
		myPurse=new Purse();
		super.setTitle("Purse");
		super.setSize(400, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenuItem();
		createMenu();
		createMenuBar();
		createLabel();
		createPanel();
		super.setVisible(true);
	}
	private void createMenuItem()
	{
		open=new JMenuItem("Open");
		open.addActionListener(new menuListener());
		
		exit=new JMenuItem("Exit");
		exit.addActionListener(new menuListener());
		
		save=new JMenuItem("Save");
		save.addActionListener(new menuListener());
		
		dhjeteshe=new JMenuItem("Dhjeteshe");
		dhjeteshe.addActionListener(new menuListener());
		
		qindeshe=new JMenuItem("Qindeshe");
		qindeshe.addActionListener(new menuListener());
		
		mijeshe=new JMenuItem("Mijeshe");
		mijeshe.addActionListener(new menuListener());
		
		newPurse=new JMenuItem("New");
		newPurse.addActionListener(new menuListener());
	}
	
	private void createMenu()
	{
		file=new JMenu("File");
		file.add(newPurse);
		file.add(open);
		file.add(save);
		file.add(exit);
		add=new JMenu("Add");
		add.add(dhjeteshe);
		add.add(qindeshe);
		add.add(mijeshe);
	}
	private void createMenuBar()
	{
		menuBar=new JMenuBar();
		menuBar.add(file);
		menuBar.add(add);
		super.add(menuBar,BorderLayout.NORTH);
	}
	
	private void createLabel()
	{
		purse_ID=new JLabel();
		purse_ID.setText("<html><font size=\"9\">"+"ID :"+myPurse.ktheID()+"</font></html>");
		purse_Balance=new JLabel();
		purse_Balance.setText("<html><font size=\"9\">"+"Balanca :"+myPurse.ktheBalancenKorente()+"</font></html>");
	}
	public void reset()
	{
		purse_ID.setText("<html><font size=\"9\">"+"ID :"+myPurse.ktheID()+"</font></html>");
		purse_Balance.setText("<html><font size=\"9\">"+"Balanca :"+myPurse.ktheBalancenKorente()+"</font></html>");
	}
	public void createPanel()
	{
		infoKeeper=new JPanel();
		infoKeeper.setLayout(new GridLayout(2,1));
		infoKeeper.add(purse_ID);
		infoKeeper.add(purse_Balance);
		super.add(infoKeeper,BorderLayout.CENTER);
	}
	class menuListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource().equals(exit))
			{
				System.exit(0);
			}
			else if(arg0.getSource().equals(save))
			{
				JFileChooser f=new JFileChooser();
				if(f.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
				{
					String nameFile=f.getCurrentDirectory().getPath();
					nameFile+="/"+f.getSelectedFile().getName();
					FileManager FM=new FileManager();
					try
					{
						FM.open(nameFile);
						FM.write(myPurse);
						FM.close();
					}
					catch(IOException exc)
					{
						JOptionPane.showMessageDialog(null, "Error Accessing File !","File Error",JOptionPane.ERROR_MESSAGE,null);
					}
				}
			}
			else if(arg0.getSource().equals(open))
			{
				JFileChooser f=new JFileChooser();
				if(f.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
				{
					String nameFile=f.getCurrentDirectory().getPath();
					nameFile+="/"+f.getSelectedFile().getName();
					FileManager FM=new FileManager();
					try
					{
						FM.open(nameFile);
						myPurse=FM.read();
						reset();
						FM.close();
					}
					catch(IOException exc)
					{
						JOptionPane.showMessageDialog(null, "Error Accessing File !","File Error",JOptionPane.ERROR_MESSAGE,null);
					}
				}
				
			}
			else if(arg0.getSource().equals(dhjeteshe))
			{
				String num=JOptionPane.showInputDialog("Sa dhjeteshe do te shtoni !");
				myPurse.shtoDhjeteshe(Integer.parseInt(num));
				reset();
			}
			else if(arg0.getSource().equals(qindeshe))
			{
				String num=JOptionPane.showInputDialog("Sa qindeshe do te shtoni !");
				myPurse.shtoQindeshe(Integer.parseInt(num));
				reset();
			}
			else if(arg0.getSource().equals(mijeshe))
			{
				String num=JOptionPane.showInputDialog("Sa mijeshe do te shtoni !");
				myPurse.shtoMijeshe(Integer.parseInt(num));
				reset();
			}
			else if(arg0.getSource().equals(newPurse))
			{
				myPurse=new Purse();
				reset();
			}
			
		}
		
		
	}
}
