package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		Snake snake = Snake.snake;
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 800, 700);
		
		g.setColor(Color.GREEN);
		for(Point point: snake.snakePart)
		{
			g.fillRect(point.x * Snake.SKALE, point.y * Snake.SKALE, Snake.SKALE, Snake.SKALE);
		}
		g.fillRect(snake.head.x * Snake.SKALE, snake.head.y * Snake.SKALE, Snake.SKALE, Snake.SKALE);
		
		g.setColor(Color.RED);
		
		g.fillRect(snake.cherry.x * Snake.SKALE, snake.cherry.y * Snake.SKALE, Snake.SKALE, Snake.SKALE);
		
		g.setColor(Color.BLACK);
		
		String string = "Score: " + snake.score + ", TailLength: " + snake.tailLength + ", Time: " + snake.time / 20 ;
		
		g.drawString(string, (int)(getWidth() / 2 - string.length() * 2.5f), 10);
		
		g.setFont(new Font("Arial", 1, 15));
		string = "Game Over!";
		
		if(snake.over)
		{
			g.drawString(string, (int)(getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4  );
		}
		
		string = "Paused!";
		
		if(snake.paused)
		{
			g.drawString(string, (int)(getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4 );
		}
		
		
		
	} 

}



