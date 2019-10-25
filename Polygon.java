import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 

public class Polygon extends Shape implements drawable{
 
 int sides;
 int radius;
 double degrees;
 double radians;
 int[] xP = {(x+(int)Math.sin(radians)*50), (x+(int)Math.cos(radians)*50), (x-(int)Math.sin(radians)*50), (x-(int)Math.cos(radians)*50)};
 int[] yP = {(y+(int)Math.cos(radians)*50), (y-(int)Math.sin(radians)*50), (y-(int)Math.cos(radians)*50), (y+(int)Math.sin(radians)*50)};
 int[] lastM = new int[2];
 double pD = 0;
 int rotate = 0;
 double dir = 0;
 double s = 1.0;
 
 public Polygon(int x, int y, int[] xP, int[] yP, double s){
  this.x = x;
  this.y = y;
  this.xP = xP;
  this.yP = yP;
 }
 
 public Polygon(int x, int y, double d){
   this.x = x;
   this.y = y;
   degrees = d;
   
   radians = Math.toRadians(degrees);
   
 }
  
 public double getPerimeter(){return 0;};
 
 public double getArea(){return 0;};
 
 public void rotate(int d){
   pD = degrees;
   degrees += s*d*3.3;
   radians = Math.toRadians(degrees);
   xP[0] = (x+(int)(Math.sin(radians)*60));
   xP[1] = (x+(int)(Math.cos(radians)*60));
   xP[2] = (x-(int)(Math.sin(radians)*60));
   xP[3] = (x-(int)(Math.cos(radians)*60));
   yP[0] = (y+(int)(Math.cos(radians)*60));
   yP[1] = (y-(int)(Math.sin(radians)*60));
   yP[2] = (y-(int)(Math.cos(radians)*60));
   yP[3] = (y+(int)(Math.sin(radians)*60));
 }
 double rr = Math.toRadians(45);
 public void move(double x){
  lastM[0] = getX();
  lastM[1] = getY();
  setX(getX()+(int)(s*x*Math.cos(radians+rr)*6));
  setY(getY()+(int)(s*-x*Math.sin(radians+rr)*6));
 }
             
 public void draw(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.GREEN); 
    g.fillPolygon(xP, yP,4); 
    repaint();
 }
 
 
}