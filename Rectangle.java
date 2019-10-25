
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Rectangle extends Shape implements Overlapable<Rectangle>, drawable{
 int width;
 int height;
  
 
 public Rectangle(){
  super(0,0,"Rectangle");
  this.width = 50;
  this.height = 50;
 }
  
 public Rectangle(int x, int y, int width, int height){
  super(x,y,"Rectangle");
  this.width = width;
  this.height = height;
 }
 
 public void draw(Graphics g){
  super.paintComponent(g);
    
    g.setColor(Color.BLACK);
    g.fillRect(x, y, width, height); 
    repaint();
 }
 

   
 
                    
 
 public double getArea(){
  double area = width*height;
  return area;  
 }
 
 public double getPerimeter(){
  double perimeter = 2*width + 2*height;
  return perimeter;   
 }
 
 public boolean anyOverlap(Rectangle other){
  if(((other.getX()<this.getX() && this.getX()<other.getX()+other.getWidth())
    || (this.getX()<other.getX() && other.getX()<this.getX()+this.getWidth())) &&
     ((other.getY()<this.getY() && this.getY()<other.getY()+other.getHeight())
    || (this.getY()<other.getY() && other.getY()<this.getY()+this.getHeight()))) return true;
  
  else return false;
 }
 
 public boolean pointOverlap(int x, int y){
  if((x>= this.getX() && x < this.getX()+this.getWidth()) && (y>= this.getY() && y < this.getY()+this.getHeight()))
    return true;
  return false;
   
 }
 
 public boolean centralOverlap(Rectangle other){
   double txCenter = (this.getX() + this.getX()+this.getWidth())/2;
   double tyCenter = (this.getY() + this.getY()+this.getHeight())/2;
   double oxCenter = (other.getX() + other.getX()+other.getWidth())/2;
   double oyCenter = (other.getY() + other.getY()+other.getHeight())/2;
   
   if(Math.abs(txCenter-oxCenter) < 20 && Math.abs(tyCenter-oyCenter) < 100) return true;
   return false;
 }
 
 
 public int getWidth(){
  return width;
 }
 
 public int getHeight(){
  return height;
 }
 
 public void setWidth(int width){
  this.width = width; 
 }
 
 public void setHeight(int height){
  this.height = height;   
 }
 
 
 
}