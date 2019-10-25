


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public abstract class Shape extends JPanel{
 String type;
 int x;
 int y;
 
 public Shape(){
  x = 0;
  y = 0;
  type = "";
 }
  
 public Shape(int x, int y, String type){
  this.x = x;
  this.y = y;
  this.type = type;
 }
  
 public abstract double getPerimeter();
 
 public abstract double getArea();
 
 public int getX(){
  return x; 
 }
 
 public int getY(){
  return y; 
 }
 
 public void setX(int x){
  this.x = x; 
 }
 
 public void setY(int y){
  this.y = y; 
 }
 
 public void move(int x, int y){
  this.setX(this.getX()+x);
  this.setY(this.getY()+y);
 }
 
 public String getType(){
  return type; 
 }
 

}