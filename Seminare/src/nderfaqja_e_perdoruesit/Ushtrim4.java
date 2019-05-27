package nderfaqja_e_perdoruesit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ushtrim4 extends JFrame
{
	private JPanel panel, panel1, panel2;	
	private JFrame frame;
	
	public Ushtrim4()
	{
	
		createPanel();
		
	}
	private void createPanel()
	{
		panel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		frame = new JFrame("Ushtrim4");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		panel.setLayout(new BorderLayout());
		
	//	panel2.setBackground(Color.black);
	//	panel1.setBackground(Color.yellow);
		
	String [] ngjyrat = {"Red", "Green", "Blue" };
		
		JComboBox<String> color = new JComboBox<String>();
	
		color.addItem(ngjyrat [0]);
		color.addItem(ngjyrat[1]);
		color.addItem(ngjyrat[2]);
		
		color.setSelectedItem(ngjyrat[0]);
		
		color.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selectedString = (String) color.getSelectedItem();
				
					if(selectedString == ngjyrat[0])
					    panel2.setBackground(Color.red);
					else if(selectedString == ngjyrat[1])
						panel2.setBackground(Color.green);
					else if(selectedString == ngjyrat[2])
						panel2.setBackground(Color.blue);
			
				
			}
			
		});
		
		panel1.add(color);
	
		panel.add(panel1, BorderLayout.SOUTH );
		panel.add(panel2, BorderLayout.CENTER);
		
		frame.add(panel);
		
	}
	
	
    public static void main(String[]args)
    {
    	Ushtrim4 test = new Ushtrim4();
    }
	
}



