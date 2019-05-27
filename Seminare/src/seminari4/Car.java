package seminari4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JFrame;


	 public class Car

	 {

	 private int xLeft; 

	 private int yTop;
	 
	 private int Size;

	
	 public Car(int x, int y,int size)

	 {

	 xLeft = x;

	 yTop = y;
	 
	 Size = size;

	 }

	public int getCarX() {
		return this.xLeft;
	}
	public int getCarY() {
		return this.yTop;
	}
	public void setCarX(int newX) {
		this.xLeft = newX;
	}
	public void setCarY(int newY) {
		this.yTop = newY;
	}

	 public void draw(Graphics2D g2)

	 {
		 

	 Rectangle body 

	 = new Rectangle(xLeft *  Size, (yTop + 10) * Size, 60 * Size, 10 * Size); 
g2.setColor(Color.red);
g2.fill(body);
 

	 Ellipse2D.Double frontTire 

	 = new Ellipse2D.Double((xLeft + 10)* Size, (yTop + 20)* Size, 10 * Size, 10 * Size);

	 Ellipse2D.Double rearTire

	 = new Ellipse2D.Double((xLeft + 40) * Size, (yTop + 20) * Size, 10 * Size, 10 * Size);
 
 g2.setColor(Color.black);
 g2.fill(frontTire);
 g2.fill(rearTire);

	 // The bottom of the front windshield

	 Point2D.Double r1 

	 = new Point2D.Double((xLeft + 10) * Size, (yTop + 10) * Size);

	 // The front of the roof

	 Point2D.Double r2 

	 = new Point2D.Double((xLeft + 20) * Size , yTop * Size);

	 // The rear of the roof

	 Point2D.Double r3 

	= new Point2D.Double((xLeft + 40) * Size, yTop * Size);
	 
	// The bottom of the rear windshield

	  Point2D.Double r4 

	  = new Point2D.Double((xLeft + 50) * Size, (yTop + 10) * Size);

	  Line2D.Double frontWindshield 

	  = new Line2D.Double(r1, r2);

	  Line2D.Double roofTop 

	  = new Line2D.Double(r2, r3);

	  Line2D.Double rearWindshield

	  = new Line2D.Double(r3, r4);

	  g2.draw(body);

	  g2.draw(frontTire);

	  g2.draw(rearTire);

	  g2.draw(frontWindshield); 

	  g2.draw(roofTop); 

	  g2.draw(rearWindshield);
	
	 }
	 
	 
	
	 }
