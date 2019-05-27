package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

// import Audio.AudioPlayer;
import Main.Game.Position;

public class Renderer extends JPanel
{
	public static boolean pressed = false;
	public JButton button , pauseMusic;
	public boolean pause = false;
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
		
		 button = new JButton("Calculate");
		 button.setSelected(false);
		 pauseMusic = new JButton("Music");
		 button.setBounds(343, 675, 100, 30);
		 pauseMusic.setBounds(660, 10, 80, 30);
		 button.addActionListener(new Action());
		 pauseMusic.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!pause)
					  pause = true;
					else
						pause = false;
		//		if(pause)
                //    AudioPlayer.stop();
		//		else
				//	AudioPlayer.playbg();
				
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
	          add(pauseMusic);
	          
 
		Game.game.repaint(g);
	}
	
	
	 class Action implements ActionListener
     {

		public void actionPerformed(ActionEvent arg0)
		{
			
			if(Game.clickN == 3)
			{
				//  if(button.isSelected())
				//	button.setSelected(false);

			   pressed = true;
			  // Game.clickN = 0;
             
               for (Position position1: Game.cardPositions)
               {
                  position1.isMoved = false;
                  position1.x = position1.oldX;
                  position1.y = position1.oldY;
               }
             
               Game.firstIsTaken = false;
               Game.secondIsTaken = false;
               Game.thirdIsTaken = false;
			}
		}
   	  
     }
	
	 
	
}