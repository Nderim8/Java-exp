package checkGame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Renderer extends JPanel
{
	public static boolean pressed = false;
	public JButton button , reset;
	public boolean pause = false;
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
		
	//	 button = new JButton("Calculate");
		 button.setSelected(false);
		 reset = new JButton("Music");
		 button.setBounds(343, 675, 100, 30);
		 reset.setBounds(660, 10, 80, 30);
	//	 button.addActionListener(new Action());
		 reset.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!pause)
					  pause = true;
					else
						pause = false;
				if(pause)
                 //   AudioPlayer.stop();
					// reset method
					return;
				else
					// AudioPlayer.playbg();
				    return;
			} 

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
	
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
			 
		 });
	          setLayout(null); 	
	          add(button);
	          add(reset);
	          
 
	//	Game.game.repaint(g);
	}
	
	
	
	
	 
	
}