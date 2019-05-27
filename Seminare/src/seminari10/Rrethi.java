package seminari10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Rrethi extends JComponent
{

	private Ellipse2D.Double rrethi;
	private JPanel panel;
	private JButton button;
	private JLabel label;	
	private static int r1 = 0;
	private static JTextField textField;	
	
	public Rrethi()
	{
		rrethi = new Ellipse2D.Double();	
		
		createPanel();
	}
	
	 private void createPanel() 
	 {
		 setLayout(new BorderLayout());
	   panel = new JPanel();
	   button = new JButton("Update");
	   button.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		  r1 = Integer.parseInt(textField.getText());
			
		}
		   
		   
	   });
	   
	   label = new JLabel("Rrezja : ");		
	   textField = new JTextField(10);
	   panel.add(label, BorderLayout.NORTH);
	   panel.add(textField, BorderLayout.NORTH);
	   panel.add(button, BorderLayout.NORTH);
	// panel.add(resultLabel);
	   add(panel, BorderLayout.NORTH);
	 }
 
	
	public Rrethi( Ellipse2D.Double rrethi1)
	{
		rrethi = rrethi1;
		createPanel();
	}

	
	 public void paintComponent(Graphics g)
	 {
		 Graphics2D g2 = (Graphics2D) g;
	
		 g2.setColor(Color.RED);
		 
		 g2.draw(rrethi);
		 g2.fill(rrethi);   
		 
	 } 
	 
		public void vizato(int x, int y, int r)
		{
		 
			 rrethi = new Ellipse2D.Double(x - r , y - r  , 2 * r , 2 * r);
			
			    repaint();
			    
		}    
			
	 
	 public static void main(String[] args)
	 {
		 
		Ellipse2D.Double rr = new Ellipse2D.Double();   
			
			Rrethi object = new Rrethi(rr);
   

	    class MouseHandler implements MouseListener
	    {
		
	    	@Override
			public void mouseClicked(MouseEvent e) {
			 
			//	String rr1 = JOptionPane.showInputDialog( "Jep rrezen" );
			//	int r1 = Integer.parseInt( rr1 );
			
	    	
				int x = e.getX();
				
				int y = e.getY();
				
			
		      object.vizato(x, y, r1);
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}	  
	 

	
        }

	 
		  JFrame frame = new JFrame();
		  
		  MouseHandler handler = new MouseHandler();
		  
		  object.addMouseListener(handler);
			
			frame.add(object);
			frame.setSize(640, 480);
			frame.setTitle("Rrethi");
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		
		
	    
	    
	    
	    
   }


}

