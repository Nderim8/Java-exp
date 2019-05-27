package Main;

import javax.swing.JFrame;

public class Game 
{
	public static void main (String[] args) // main function (entry point)
	{
		JFrame window = new JFrame("Dragon Tale");   
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocation(180,80);    /// 320,120 per scale 2 ///
		window.pack();
		window.setVisible(true);
		
		
	}

}
