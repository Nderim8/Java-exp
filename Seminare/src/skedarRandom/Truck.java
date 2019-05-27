package skedarRandom;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Truck

{

private int xLeft; 

private int yTop;

private int Size;


public Truck(int x, int y,int size)

{

xLeft = x;

yTop = y;

Size = size;

}

public void draw(Graphics2D g2)
{
	 
Rectangle body 

= new Rectangle(xLeft *  Size, (yTop) * Size, 60 * Size, 30 * Size); 
g2.setColor(Color.red);
g2.fill(body);

Rectangle head 

= new Rectangle((xLeft + 60) *  Size, (yTop + 10) * Size, 15 * Size, 20 * Size); 
g2.setColor(Color.red);
g2.fill(head);

Ellipse2D.Double frontTire 

= new Ellipse2D.Double((xLeft + 65)* Size, (yTop + 30)* Size, 10 * Size, 10 * Size);


Ellipse2D.Double frontTire1 

= new Ellipse2D.Double((xLeft + 10)* Size, (yTop + 30)* Size, 10 * Size, 10 * Size);

Ellipse2D.Double frontTire2

= new Ellipse2D.Double((xLeft)* Size, (yTop + 30)* Size, 10 * Size, 10 * Size);

Ellipse2D.Double rearTire1

= new Ellipse2D.Double((xLeft + 40) * Size, (yTop + 30) * Size, 10 * Size, 10 * Size);

Ellipse2D.Double rearTire2

= new Ellipse2D.Double((xLeft + 40 + 10) * Size, (yTop + 30) * Size, 10 * Size, 10 * Size);

g2.setColor(Color.black);
g2.fill(frontTire);
g2.fill(frontTire1);
g2.fill(frontTire2);
g2.fill(rearTire1);
g2.fill(rearTire2);

 g2.draw(body);
 g2.draw(head);
 
 g2.draw(frontTire);
 g2.draw(frontTire1);
 g2.draw(frontTire2);   /// trickkk

 g2.draw(rearTire1);
 g2.draw(rearTire2);


}

}
