package seminari4;

import javax.swing.JFrame;

public class HouseViewer 
{
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		
		frame.setTitle("House");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		HouseComponent home1 = new HouseComponent();
		frame.add(home1);
		frame.setVisible(true);
		
	}

}
