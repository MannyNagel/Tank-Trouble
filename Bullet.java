
public class Bullet extends Circle{
 double degrees;
 int slope;
 double radians;
 int xPrev;
 int yPrev;
 int life = 0;
 int type;
 int explodeTimer;
 
 public Bullet(Shooter a){
  super(a.getX() + (int)(Math.cos(Math.toRadians(a.degrees+45))*120)-10, a.getY() -(int)(Math.sin(Math.toRadians(a.degrees+45))*120)-10, 20);
   this.degrees =  a.degrees + 45;
 }
 
 public Bullet(Shooter a, int x){
  super(a.getX() + (int)(Math.cos(Math.toRadians(a.degrees+45))*120)-10, 
        a.getY() -(int)(Math.sin(Math.toRadians(a.degrees+45))*120)-10, 20);
   this.degrees =  a.degrees + 45;
   explodeTimer = 2;
 }
 
 public Bullet(int x, int y, double d){
   super(x,y,25);
   this.degrees = d;
 }
 public Bullet(int x, int y, int r, int c, int t){
  super(x,y,r,c); 
  type = t;
 }
 public void deflect(Rectangle w){
   degrees = degrees%360;
   if(w.getHeight() == 20)
     degrees = 360-degrees;
   else if(w.getWidth() == 20)
     degrees = 180-degrees;
   else if(w.getWidth() <100)
     degrees = 180-degrees;
   else  degrees = 360-degrees;
 }
 
 public int getLife(){
  return life; 
 }

 public boolean checkLife(){
   if(life < 500) {
     life++;
     return false;
   }
   return true;
 }
 
 public boolean checkLifeA(){
   if(life < 500) {
     return false;
   }
   return true;
 }
 
 //double rr = Math.toRadians(45);
 
 public void move(double x){
   xPrev = getX();
   yPrev = getY();
  radians = Math.toRadians(degrees);
  setX(getX()+(int)(Math.cos(radians)*10*x));
  setY(getY()-(int)(Math.sin(radians)*10*x));
 }
 
}