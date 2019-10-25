import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Map{
  private ArrayList<Rectangle> walls1 = new ArrayList<Rectangle>();
  private ArrayList<Rectangle> walls2 = new ArrayList<Rectangle>();
  private ArrayList<Rectangle> walls3 = new ArrayList<Rectangle>();
  int minX = 10;
  int minY = 400;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  
  public Map(){
   addWalls1(); 
  }
  
  public void addWalls1(){
  walls1.add(new Rectangle(0,300,(int)screenSize.getWidth(), 100));
  walls1.add(new Rectangle(0,300,40,(int)screenSize.getHeight()-300));
  walls1.add(new Rectangle(0,(int)screenSize.getHeight()-200,(int)screenSize.getWidth(),200));
  walls1.add(new Rectangle((int)screenSize.getWidth()-20, 300, 20,(int)screenSize.getHeight()-400));
  walls1.add(new VWall(minX + 200, minY, 200));
  walls1.add(new VWall(minX + 1400, minY, 400));
  walls1.add(new VWall(minX + 400, minY, 600));
  walls1.add(new VWall(minX + 600, minY, 200));
  //walls.add(new VWall(minX + 800, minY+200, 200));
  //walls.add(new VWall(minX + 1200, minY+400, 400));
  //walls.add(new VWall(minX + 1200, minY+1000, 400));
  walls1.add(new VWall(minX + 800, minY+200, 200));
  walls1.add(new HWall(minX+800, minY+800, 400));
  walls1.add(new HWall(minX+1800, minY+200, 800));
  walls1.add(new HWall(minX, minY+400, 200));
  walls1.add(new HWall(minX, minY+800, 200));
  walls1.add(new HWall(minX, minY+800, 200));
  walls1.add(new HWall(minX+600, minY+400, 600));
  walls1.add(new HWall(minX+400, minY+600, 400));
  walls1.add(new HWall(minX+200, minY+600, 220));
  walls1.add(new HWall(minX, minY+1000, 800));
  walls1.add(new HWall(minX, minY+800, 200));
  walls1.add(new HWall(minX+1200, minY+600, 400));
  walls1.add(new HWall(minX, minY+800, 200));
  walls1.add(new HWall(minX+2400, minY+400, 200));
  walls1.add(new VWall(minX+2400, minY+200, 200));
  walls1.add(new VWall(minX+600, minY+600, 200));
  walls1.add(new VWall(minX+400, minY+1000, 200));
  walls1.add(new HWall(minX, minY+800, 200));
  walls1.add(new HWall(minX+1600, minY+400, 600));
  walls1.add(new VWall(minX+1200, minY+400, 600));
  walls1.add(new HWall(minX+1000, minY+200, 400));
  walls1.add(new HWall(minX+1200, minY+200, 400));
  walls1.add(new VWall(minX+2200, minY+1200, 200));
  walls1.add(new VWall(minX+2600, minY+1200, 200));
  walls1.add(new VWall(minX+2600, minY+1200, 200));
  walls1.add(new VWall(minX+2400, minY+800, 400));
  walls1.add(new VWall(minX+1800, minY+400, 600));
  walls1.add(new VWall(minX+800, minY+1000, 200));
  walls1.add(new HWall(minX+1400, minY+1000, 800));
  walls1.add(new HWall(minX+1200, minY+1200, 400));
  walls1.add(new VWall(minX+1800, minY+1000, 200));
  walls1.add(new HWall(minX+2200, minY+800, 600));
  walls1.add(new HWall(minX+2200, minY+600, 600));
  }
  
  public void addWalls2(){
    walls2.add(new HWall(minX, minY+800, 1000));
    walls2.add(new HWall(minX+400, minY+1200, 600));
    walls2.add(new HWall(minX+400, minY+200, 2000));
    walls2.add(new HWall(minX+1800, minY+800, 600));
    walls2.add(new VWall(minX+2400, minY+200, 600));
    walls2.add(new VWall(minX+400, minY+800, 400));
    walls2.add(new VWall(minX+1000, minY+400, 600));
    walls2.add(new VWall(minX+1000, minY+1000, 400));
    
  }
  public ArrayList<Rectangle> Walls(){
    return walls1;
  }
  
  
}