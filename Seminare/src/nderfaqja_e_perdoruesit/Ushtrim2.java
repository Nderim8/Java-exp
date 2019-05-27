package nderfaqja_e_perdoruesit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ushtrim2 extends JFrame
{
	private JPanel panel, panel1, panel2;
	private JFrame frame;
	private int size = 300;
	
	public Ushtrim2()
	{
		createPanel();
		
	}
	private void createPanel()
	{
		panel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		frame = new JFrame("Ushtrim2");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.setLayout(new BorderLayout());
	//	frame.add(panel);
		
		panel2.setSize(size, size);
	//	panel2.setBackground(Color.black);
		panel1.setBackground(Color.yellow);
		
		JRadioButton button1 = new JRadioButton("E kuqe");
		JRadioButton button2 = new JRadioButton("Jeshile");
		JRadioButton button3 = new JRadioButton("Blu");
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(button1);
		group.add(button2);
		group.add(button3);
		
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					
					panel2.setBackground(Color.red);
				//   JOptionPane.showMessageDialog(null, "ActionListener is working");
					
				
			}
			
		});
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					  
					panel2.setBackground(Color.green);
				
			}
			
		});
		button3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					panel2.setBackground(Color.blue);
			
			}
			
		});
		
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
        
		panel.add(panel1, BorderLayout.SOUTH);
		panel.add(panel2, BorderLayout.CENTER);
		
		frame.add(panel);
		
	}
	
	
    public static void main(String[]args)
    {
    	Ushtrim2 test = new Ushtrim2();
    }
	
}
