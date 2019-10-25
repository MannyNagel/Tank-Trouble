public class Point {
 
  private double x, y;
  
  public Point(){
   x = 0;
   y = 0;
  }
  
  public Point(double x1, double y1){
   x = x1;
   y = y1;
  }
    
  public Point(Point p){
   double x1 = p.getX();
   double y1 = p.getY();
   x = x1;
   y = y1;
  }
  
  public void add(Point other){
    double x1 = other.getX() + this.getX();
  }
  
  public void multiply(double a){
    x *= a;
    y *= a;
  }
  
  public double[] asArray(){
   double[] n = new double[2];
   x = n[0];
   y = n[1];
   return n; 
  }
  
 
  public double getX(){
   return x;
  }
  
  public double getY(){
   return y;
  }
  
  public void setX(double setx){
    x = setx;
  }
  
  public void setY(double sety){
    y = sety;
  }
  
  public String toString(){
   String str;
   str = "(" + getX() + "," + getY() + ")";
   return str;
  }
  
  //returns point in the center of two inputted points
  public static Point getMidPoint(Point a, Point b){
   Point c = new Point(); 
   double xMid = (a.getX() + b.getX())/2.0;
   c.setX(xMid);
   double yMid = (a.getY() + b.getY())/2.0;
   c.setY(yMid);
   return c;
  }
  
  public static double getSlope(Point a, Point b){
   double numerator = (Math.abs(a.getY()- b.getY()));
   double denominator = (Math.abs(a.getX()- b.getX())); 
   double slope = numerator/denominator;
    return slope;
  }
  
  public static Point getNextPoint(Point a, Point b){
   Point c = new Point(); 
    double xDif = (Math.abs(a.getX()- b.getX()));
   double yDif = (Math.abs(a.getY()- b.getY())); 
   if(a.getY() > b.getY()){
    c.setY(a.getY() + yDif);
    c.setX(a.getX() + xDif);
   }
   else{
    c.setY(b.getY() + yDif);
    c.setX(b.getX() + xDif); 
   }
   return c; 
  }
  
  public static double getYIntercept(Point a, Point b){
    
    double slope = getSlope(a,b);
    double c = a.getY()- slope*a.getX();
    return c;
  }
    
    
    
  
  
  public static Point add(Point p1, Point p2) {
    return new Point(p1.x+p2.x, p1.y+p2.y);
  }
  
  
  
}