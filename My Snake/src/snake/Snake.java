package snake;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Snake implements ActionListener, KeyListener
{
	public static Snake snake;
	
	public RenderPanel renderPanel;
	
	public Timer timer = new Timer(20, this);
	
	public ArrayList<Point> snakePart = new ArrayList<Point>();
	
	public Point head, cherry;
	
	public boolean over = false, paused;
	
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SKALE = 10;
	
	public int ticks = 0, score = 0, time , direction = DOWN, tailLength = 10;
	
	public Random random;
	
	public JFrame jframe;
	
	public Dimension dim;
	
	
	public Snake()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(805, 700);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(renderPanel = new RenderPanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		startGame();
		
	}
	
	public void startGame()
	{
		over = false;
		paused = false;
		score = 0;
		time = 0;
		ticks = 0;
		timer.start();
		head = new Point(0 , -1);
		random = new Random();
		cherry = new Point(random.nextInt(79), random.nextInt(66));
		tailLength = 14;
		direction = DOWN;
		snakePart.clear();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		renderPanel.repaint();
		ticks++;
		
		if(ticks % 2 == 0 && head !=  null && !over && !paused )
		{
			time ++;
			
			snakePart.add(new Point(head.x, head.y) );
			
			if(direction == DOWN)
			{
				if(head.y + 1 < 67 && noTailAt(head.x, head.y + 1) )
				{
					head = new Point(head.x, head.y + 1);
				}
				else
				{
					over = true;
				}
			}
			if(direction == UP)
			{
				if(head.y - 1 >= 0 && noTailAt(head.x, head.y - 1) )
				{
					head = new Point(head.x, head.y - 1);
				}
				else
				{
					over = true;
				}
			}
			if(direction == RIGHT)
			{
				if(head.x + 1 < 80 && noTailAt(head.x + 1, head.y) )
				{
					head = new Point(head.x + 1, head.y);
				}
				else
				{
					over = true;
				}
			}
			if(direction == LEFT)
			{
				if(head.x - 1 >= 0 && noTailAt(head.x - 1, head.y) )
				{
					head = new Point(head.x - 1, head.y);
				}
				else
				{
					over = true;
				}
			}
			
			if(snakePart.size() > tailLength)
			{
				snakePart.remove(0);
			}
			
			if(cherry != null)
			{
			  if(head.equals(cherry))
			  {
				score += 10;
				tailLength++;
				cherry.setLocation(random.nextInt(79), random.nextInt(66));
			  }	
			}
			
		}
				
	}
 
	public boolean noTailAt(int x, int y)
	{
		for(Point point: snakePart)
		{
			if(point.equals(new Point(x,y)) )
			{
				return false;
			}
		}
		return true;
		
	}

	public static void main(String[] args)
	{
		snake = new Snake();
	}
	
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		
		if( (c == KeyEvent.VK_W || c == KeyEvent.VK_UP) && direction != DOWN )
		{
			direction = UP;
		}
		if( (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S) && direction != UP )
		{
			direction = DOWN;
		}
		if( (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) && direction != RIGHT )
		{
			direction = LEFT;
		}
		if ( (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D) && direction != LEFT )
		{
			direction = RIGHT;
		}
		
		if(c == KeyEvent.VK_SPACE)
		{
			if (c == KeyEvent.VK_SPACE)
			{
				if (over)
				{
					startGame();
				}
				else
				{
					paused = !paused;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}






