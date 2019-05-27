import javax.swing.JFrame;

public class Window {
	
	private JFrame window;
	public static final int WIDTH=317, HEIGHT=640;
	public Board board;
	public Window() {
		
		window = new JFrame("Tetris");
		board = new Board();

		window.setLocation(500, 50);
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		
		window.add(board);
		window.addKeyListener(board);
		
		
	}
	
	
	public static void main(String args[]) {
		
		new Window();
		
	}

}
