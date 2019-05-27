package main;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Main implements ActionListener, MouseListener, KeyListener {
	
	public static Cmd cmd;
	public ArrayList<Cmd> Cmds;
	public Random rand;
	
	
	public static Main m;
	public Renderer renderer;
	public Main() {
		
		rand = new Random();
		
		Cmds = new ArrayList<>();
		String name = null;
		int cmdType = 0;
        int speed = 0;
        int nr = 0;
		for( int i=1; i<=7; i++)
		{
		    cmdType =  rand.nextInt(3);
            nr = 1 + rand.nextInt(9);
		    if(cmdType == 0)
		    	name = "Ctrl";
		    else if(cmdType == 1)
		    	name = "Alt";
		    else
		    	name = "Shift";
		    
		    speed = 1+rand.nextInt(3);
		    name = name+""+nr;
	
		    cmd = new Cmd( 100 * i, 10, name, speed);
			Cmds.add(cmd);
			
		}
		
		
		
		JFrame main = new JFrame("Keyboard Master");
		Timer timer = new Timer(20,this);
		main.setLocation(500, 50);
		main.setSize(800, 500);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setResizable(false);
		main.setVisible(true);
		
		renderer =new Renderer();
	  	
	  	main.add(renderer);
	  	
		
		boolean control = false, alt = false, shift = false, tab = false, space = false;
		

		
		main.addMouseListener(this);
		main.addKeyListener( this);
		timer.start();

		/*Scanner in = new Scanner(System.in);
		
		ArrayList<String> strs = new ArrayList<String>();
		
		System.out.println("Input your commands you want to train with: (Press -1 when done!)");
		while(!in.hasNext("-1")) {
			strs.add(in.nextLine());
		}
        in.nextLine();
		
	//	System.out.println(strs.size());
		System.out.println("Test your commands: ");
		
		ArrayList<String> cmds = new ArrayList<String>();
		String cmd = null;
		for(int i=0; i<strs.size(); i++) {
			cmd = in.nextLine();
			  cmds.add(cmd);
		}
	//	System.out.println(cmds.size());
	//	System.out.println(cmds.get(0));
	
		boolean correct = false;
		for(int i=0; i<strs.size(); i++) {
			if( !(cmds.get(i).equals(strs.get(i))) ) {
				System.out.println("Wrong!");
				correct = false;
				break;
			
			}
			else {
				  correct = true;
		         }
	 
		} // end for	
        if(correct)
		System.out.println("Well done!");
	
	*/
	}
	
	public static void main(String[] args) {
		
         m = new Main();
	
	} // end main

	public void repaint(Graphics g) 
	{
		for( Cmd c : Cmds)
		{
	       g.drawString(c.getName(), (int) c.getX(), (int) c.getY()  );
		}
	}

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for(Cmd c : Cmds) {
			
			double y = c.getY();
		    y = y + c.getSpeed();
		    c.setY(y);
			
		}
		
		renderer.repaint();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int cmdType = 0, nr = 0, speed;
		String name = null;
		
		
		
		if( e.getKeyCode() == KeyEvent.VK_CONTROL ) {
			
			
			System.out.println("Ctrl");
			for(Cmd c : Cmds) {
				if( c.getName().equals("Ctrl1") || c.getName().equals("Ctrl2") || c.getName().equals("Ctrl3")  )
				{
					c.setY(-50);
				
				 cmdType =  rand.nextInt(3);
		         nr = 1 + rand.nextInt(9);
				 if(cmdType == 0)
				    	name = "Ctrl";
				    else if(cmdType == 1)
				    	name = "Alt";
				    else
				    	name = "Shift";
				    
				    speed = 1+rand.nextInt(3);
				    name = name+""+nr;
				
				    c.setName(name);
				}
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}
