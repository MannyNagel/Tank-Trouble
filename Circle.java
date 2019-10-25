import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Circle extends Shape implements Overlapable<Circle>, drawable {
  
  private int radius;
  int color;
  int r2;
  public Circle(){
   super(50,50, "Circle");
   radius = 50;
  }
  
  public Circle(int x, int y, int radius){
   super(x,y,"Circle");
   this.radius = radius;
   r2 = radius/2;
  }
  
  public Circle(int x, int y, int radius, int c){
   super(x,y,"Circle");
   this.radius = radius;    
   this.color = c;
   r2 = radius/2;
  }
  
  public int getRadius(){
   return radius;    
  }
  
  public void setRadius(int x){
   radius = x; 
  }
  
  public boolean anyOverlap(Circle other){
    if(Math.abs((this.getX()+r2)-(other.getX()+other.r2))<((this.r2)+(other.r2)) && 
       Math.abs((this.getY()+r2)-(other.getY()+other.r2))<((this.r2)+(other.r2)))
    return true;
    else return false;
  
  }
  
  public boolean rectOverlap(Rectangle other){
  int degrees;
  double radians = 0;
  Point t = new Point(0,0); 
  for(int i = 0; i < 36; i++){
   degrees = i*10;
   radians = Math.toRadians(degrees);
   t.setX(x+r2+(int)(Math.cos(radians)*r2));
   t.setY(y+r2-(int)(Math.sin(radians)*r2));
   if(other.pointOverlap((int)t.getX(), (int)t.getY())) return true;
    /*if(((other.getX() < (x+r2+(int)(Math.cos(radians)*r2))) && 
      ((x+r2 +(int)(Math.cos(radians)*r2)) < other.getX()+other.getWidth())) &&
      ((other.getY() < (y+r2-(int)(Math.sin(radians)*r2))) && 
      ((y+r2-(int)(Math.sin(radians)*r2)) < other.getY()+other.getHeight())))*/
    //return true;
  }
  return false;
  
  }
  public boolean centralOverlap(Circle other){
   if(Math.abs(this.getX()-other.getX())<(20) && 
       Math.abs(this.getY()-other.getY())<(20))
    return true;
    else return false;
    }
  
  public double getArea(){
    
    return 0;}
  
  public void draw(Graphics g){
   super.paintComponent(g);
    
    g.setColor(Color.RED);
    if(color == 1) g.setColor(Color.GRAY);
    if(color == 2) g.setColor(Color.ORANGE);
    if(color == 3) g.setColor(Color.GREEN);
    if(color == 4) g.setColor(Color.RED);
    if(color == 5) g.setColor(Color.WHITE);
    g.fillOval(x, y, radius, radius);  
  }
  
  public double getPerimeter(){return 0;}
  
  
}