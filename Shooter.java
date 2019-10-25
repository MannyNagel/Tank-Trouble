                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Shooter extends Polygon implements drawable{
  private int ammo = 1; // how many bullets the shooter has
  private int color = 0;
  private int score = 0;
  private double dofC = 0;
  private double rofC = 0;
  int speedCount = 0;
  boolean remove;
  Circle top = new Circle();
  int ammoPrev =0;
  int ammoCount = 0;
  boolean exploder;
  boolean ghost;
  int ghostCount;
  Point lastPos = new Point(0,0);
  boolean unstuck;
  
  public Shooter(int color, int x, int y, double d){
   super(x,y,d);
    this.color = color;
    dofC = d+45;
    rofC = Math.toRadians(dofC);
    top.setRadius(84);
  }
  
  public boolean remove(){
   return remove; 
  }
  
  public void draw(Graphics g){
  super.paintComponent(g);
    if(color == 0) g.setColor(Color.BLUE);
    else{ g.setColor(Color.MAGENTA);}
    dofC = degrees+45;
    rofC = Math.toRadians(dofC);
    top.setX(x+(int)(Math.cos(rofC)*42.4)-39);
    top.setY(y-(int)(Math.sin(rofC)*42.4)-39);
    if(ghost) {
      g.drawPolygon(xP, yP,4);
      g.drawOval(top.getX(), top.getY(), 78,78);
    }
      else{
        g.fillPolygon(xP, yP,4);
        g.fillOval(top.getX(), top.getY(), 78,78);
      }
    
    
    
 }
  
   public int getAmmo(){
   return ammo; 
  }
  
   public int getScore(){
    return score; 
   }
   
   public void getPoint(){
    score++; 
   }
   
   public void addAmmo(){
    ammo++;     
   }
   
   public void addAmmo(int x){
    ammo += x;     
   }
   public void setAmmo(int x){
    ammo = x;    
   }
   public boolean shoot(){
     //ammo++;
     if(ammo > 0){
       ammo--;
       return true; 
     }
     
     else return false;
   }
  
  
  
}