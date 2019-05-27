package seminar2;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JApplet;

 public class Rrathet9 extends JApplet
 {
 public void paint(Graphics g){

 Graphics2D g2 = (Graphics2D) g;

 Ellipse2D.Double ellipse = new Ellipse2D.Double(5, 10, 30, 20);
 g2.setColor(Color.black);
 g2.draw(ellipse);
 g2.setColor(Color.pink);
 g2.fill(ellipse);
 Ellipse2D.Double ellipse2 = new Ellipse2D.Double(5, 30, 30, 20);
 
 g2.draw(ellipse2);
 g2.setColor(Color.blue);
 g2.fill(ellipse2);
 }
}
