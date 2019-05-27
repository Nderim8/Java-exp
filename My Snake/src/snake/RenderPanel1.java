package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class RenderPanel1 extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		Snake1 snake = Snake1.snake;
		
		g.setColor(Color.BLUE);
		
		g.fillRect(0, 0, 800, 700);
		
		g.setColor(Color.BLACK);
		
		for(Point point: snake.snakeParts)
		{
			g.fillRect(point.x * snake.SCALE, point.y * snake.SCALE, snake.SCALE, snake.SCALE);
		}
		
		g.setColor(Color.RED);
		
		g.fillRect(snake.cherry.x * snake.SCALE, snake.cherry.y * snake.SCALE, snake.SCALE, snake.SCALE);
		
		g.setFont(new Font("Arial", 1, 15));
		
		g.setColor(Color.WHITE);
		
		String string = "Score : " + snake.score + ", TailLength : " + snake.tailLength + ", Time : " + snake.time/20;
		
		g.drawString(string, 400, 10);
		
		string = "Game Over!";
		
		if(snake.over)
		{
			g.drawString(string, 400, 350);
		}
		
		string = "Paused!";
		
		if(snake.paused)
		{
			g.drawString(string, 400, 350);
		}
		
		
		
	}

}





