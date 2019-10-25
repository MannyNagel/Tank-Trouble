import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;
import java.util.ArrayList;

public class ShootWar extends JPanel implements ActionListener, KeyListener{
//  static int x, y;
  Timer t = new Timer(1,this);
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  Shooter p1 = new Shooter(0, 0, 0,45.0); //The different Players
  Shooter p2 = new Shooter(1, 0, 0,45.0);
  Circle tester = new Circle(0,0,84);
  JLabel p1L = new JLabel("Player 1");
  JLabel p2L = new JLabel("Player 2");
  JLabel p1AL = new JLabel("Ammo");
  JLabel p2AL = new JLabel("Ammo");
  JLabel p1A = new JLabel("" + p1.getAmmo());//Labels That display how much ammo each player has
  JLabel p2A = new JLabel("" + p2.getAmmo());
  JLabel p1S = new JLabel("" + p1.getScore());//Lables that display the score
  JLabel p2S = new JLabel("" + p2.getScore());
  JLabel title1 = new JLabel("WAR");//Lables that show the title
  JLabel title2 = new JLabel("MAYHEM");
  ArrayList<Bullet> bullets = new ArrayList<Bullet>();//Array list of live bullets
  ArrayList<Point> points = new ArrayList<Point>();//List of available points for ammo to spawn
  ArrayList<Shooter> players = new ArrayList<Shooter>();
  ArrayList<Bullet> ammo = new ArrayList<Bullet>();//List of ammo currently displayed
  ArrayList<Bullet> exploders = new ArrayList<Bullet>();//list of exploding bullets
  Map map = new Map();//The different maps
  boolean restart;
  boolean remove;
  boolean help = true;
  int restartC = 0;
  int ammoTimer = 0;//timer for when to display a new ammo
  int random;
  int bulletType;
  
//Constructor
  public ShootWar(){
   setLayout(null);
   p1.setX(150);
   p1.setY(1100);
   p2.setX(2100);
   p2.setY(1100);
   players.add(p1);
   players.add(p2);
   setFocusable(true);
   addKeyListener(this);
   setComponents();
   //For loop that generates the possible points for ammo to spawn
   for(int i = 0; i < 105; i++){
    Point a = new Point(); 
     a.setX((i%15)*(200) + 120);
     a.setY((i/15)*200 + 500);
     points.add(a); 
   }
  }
   
  public void setComponents(){
    p1L.setVisible(true);
    add(p1L);
    p1L.setBounds(10,50,1000,200);
    p1L.setFont(new Font("Comic Sans", Font.BOLD, 150));
    
    title1.setVisible(true);
    add(title1);
    title1.setBounds(1300,0,500,200);
    title1.setFont(new Font("Russo One", Font.BOLD,140));
    
    title2.setVisible(true);
    add(title2);
    title2.setBounds(1150,170,700,100);
    title2.setFont(new Font("Russo One", Font.BOLD, 140));

    p2L.setVisible(true);
    add(p2L);
    p2L.setBounds(2400,50,800,200);
    p2L.setFont(new Font("Comic Sans", Font.BOLD, 150));

    p1A.setVisible(true);
    add(p1A);
    p1A.setBounds(700,100,800,200);
    p1A.setFont(new Font("Comic Sans", Font.BOLD, 70));
    
    p2A.setVisible(true);
    add(p2A);
    p2A.setBounds(2250,100,400,200);
    p2A.setFont(new Font("Comic Sans", Font.BOLD, 70));
    
    p1AL.setVisible(true);
    add(p1AL);
    p1AL.setBounds(610,10,800,200);
    p1AL.setFont(new Font("Comic Sans", Font.BOLD, 70));
    
    p2AL.setVisible(true);
    add(p2AL);
    p2AL.setBounds(2160,10,400,200);
    p2AL.setFont(new Font("Comic Sans", Font.BOLD, 70));
    
    p1S.setVisible(true);
    add(p1S);
    p1S.setBounds(850,50,400,200);
    p1S.setFont(new Font("Comic Sans", Font.BOLD, 200));
    
    p2S.setVisible(true);
    add(p2S);
    p2S.setBounds(2020,50,400,200);
    p2S.setFont(new Font("Comic Sans", Font.BOLD, 200));

  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
   
    for(int i = 0; i < players.size(); i++) players.get(i).draw(g);//draws the players
    //Draws the different walls from the arraylist in the map object
    for(int i = 0; i < map.Walls().size(); i++){
     map.Walls().get(i).draw(g); 
    }
    
    g.setColor(Color.BLACK);
    g.fillRect(0,300,40,(int)screenSize.getHeight()-300);
    
    //Draws each live bullet
    for(int i  = 0; i < bullets.size(); i++){
     bullets.get(i).draw(g); 
    }
    
    //Draws the live Ammo
    for(int i = 0; i < ammo.size(); i++){
     ammo.get(i).draw(g); 
    }
    
    //The background to the stats at the top
    g.setColor(Color.MAGENTA);
    g.fillRect(1980,10,1010,270);
    g.setColor(Color.BLUE);
    g.fillRect(10,10,1010,270);
    
    //The Help screen
    if(help){
     g.setColor(Color.DARK_GRAY);
     g.fillRect(200,400,2600,1400);
     
     g.setColor(Color.BLUE);
     g.fillRect(300,640,100,100);
     g.fillRect(420,520,100,100);
     g.fillRect(420,640,100,100);
     g.fillRect(540,640,100,100);
     g.fillRect(740,580,100,100);
     
     g.setColor(Color.MAGENTA);
     g.fillRect(1100,640,100,100);
     g.fillRect(420+800,520,100,100);
     g.fillRect(420+800,640,100,100);
     g.fillRect(540+800,640,100,100);
     g.fillRect(740+800,580,100,100);
     
     g.setColor(Color.ORANGE);
     g.fillOval(220,1430,70,70);
     g.setColor(Color.RED);
     g.fillOval(1420,1230,70,70);
     g.setColor(Color.WHITE);
     g.fillOval(1420,1430,70,70);
     g.setColor(Color.GRAY);
     g.fillOval(220,1230,70,70);
     g.setColor(Color.GREEN);
     g.fillOval(220,1630,70,70);
     g.setColor(Color.WHITE);
     g.setFont(new Font("Comic Sans", Font.BOLD, 100));
     g.drawString("Player 1", 300,500);
     g.drawString("Player 2", 1100,500);
     g.drawString("Increase Speed 10s", 300,1500);
     g.drawString("Explodes", 1500,1300);
     g.drawString("Ghost", 1500,1500);
     g.drawString("+1 Bullet", 300,1300);
     g.drawString("+5 Bullet", 300,1700);
     g.drawString("P = Reset Match", 300,900);
     g.drawString("H = Show/Delete This Screen", 300,1100);
     g.drawString("S", 315,725);
     g.drawString("E", 435,605);
     g.drawString("D", 435,725);
     g.drawString("F", 555,725);
     g.drawString("Q", 755,665);
     
     g.drawString("<", 315+800,725);
     g.drawString("^", 440+800,625);
     g.drawString("", 435+800,725);
     g.drawString(">", 555+800,725);
     g.drawString("M", 755+800,665);
    }
    
    
  }

  //Updates the JLabel when the score changes
  public void updateScore(){
   p1S.setText("" + p1.getScore()); 
   p2S.setText("" + p2.getScore()); 
  }
  
  //Updates the JLabel when the ammo changes
  public void updateAmmo(){
   p1A.setText("" + p1.getAmmo());
   p2A.setText("" + p2.getAmmo());
   
  }
  
  //resets the game
  //*Precondition: Game has just ended
  //*Post-condition: variables ready for a new game
  public void resetGame(){
   //resets all the qualities of the players
    while(players.size() > 0) players.remove(0);
   while(bullets.size() > 0) bullets.remove(0);
   while(points.size() > 0) points.remove(0);
   while(ammo.size() > 0) ammo.remove(0); 
    players.add(p1);
     players.add(p2); 
   for(int i = 0; i < 2; i++){
    players.get(i).setAmmo(1);
    players.get(i).s = 1;
    players.get(i).ghost = false;
    players.get(i).unstuck = false;
    players.get(i).degrees = (int)(Math.random()*360);
    players.get(i).exploder = false;
   }
  
   updateAmmo();
   
  
   restartC = 0;
   restart = false;
   //resets the points
   for(int i = 0; i < 105; i++){
    Point a = new Point(); 
     a.setX((i%15)*(200) + 120);
     a.setY((i/15)*200 + 500);
     points.add(a); 
   }
   //randomizes the location of the player
   random = (int)(Math.random()*points.size());
   p1.setX((int)points.get(random).getX());
   p1.setY((int)points.get(random).getY());
   points.remove(random);
   random = (int)(Math.random()*points.size());
   p2.setX((int)points.get(random).getX());
   p2.setY((int)points.get(random).getY());
   points.remove(random);
  }
  
  public void actionPerformed(ActionEvent e) {
    
    //The timer which is the main component of this class
    if(e.getSource().equals(t)){
      
      if(players.size() == 0) resetGame();
      
      //Updates the location and rotation of the player
      p1.move(p1.dir);
      p1.rotate(p1.rotate);
      p2.move(p2.dir);
      p2.rotate(p2.rotate);
      
      //Generates ammo after the timer reaches 150
      ammoTimer++;
      if(ammoTimer > 150 && points.size()>0){
       ammoTimer = 0;
       //Generates different types of Bullets
       //Each bullet has an integer 'type' which will determine what it does when someone picks it up
       random = (int)(Math.random()*points.size());
       bulletType = (int)(Math.random()*8);
       if(bulletType == 5){
         ammo.add(new Bullet((int)points.get(random).getX(),(int)points.get(random).getY(), 35, 2, 1));
       }
       if(bulletType == 4){
         ammo.add(new Bullet((int)points.get(random).getX(),(int)points.get(random).getY(), 35, 5, 4));
       }
       if(bulletType ==7){
         ammo.add(new Bullet((int)points.get(random).getX(),(int)points.get(random).getY(), 35, 4, 3));
       }
       if(bulletType == 6){
         ammo.add(new Bullet((int)points.get(random).getX(),(int)points.get(random).getY(), 35, 3, 2));
       }
       if(bulletType < 4){
       ammo.add(new Bullet((int)points.get(random).getX(),(int)points.get(random).getY(), 35, 1, 0));
       }
       points.remove(random);//remove the point from the list when you add a bullet there
      }
      
      //For loop for the different powerUps a player can pick up
      for(int k = 0; k < players.size(); k++){
        //The timer for the speed powerUp
       if(players.get(k).s == 1.6) players.get(k).speedCount++;
       if(players.get(k).speedCount > 300) {
         players.get(k).s = 1;
         players.get(k).speedCount = 0;
       }
        //The timer for the Ghost powerUp
       if(players.get(k).ghost) players.get(k).ghostCount++;
       if(players.get(k).ghostCount > 200){
         players.get(k).ghost = false;
         players.get(k).ghostCount = 0;
         players.get(k).setX((int)players.get(k).lastPos.getX());
         players.get(k).setY((int)players.get(k).lastPos.getY());
       }
      }
      
      
      //When someone is killed there is a 2 second period before 
      //the game restartes
      if(restart) restartC++;
      if(restartC > 200) {
        if(players.size()!= 0) players.get(0).getPoint();
        updateScore();
        resetGame();
      }
      
      //the bullet explodes and creates 20 new bullets
      if(exploders.size() > 0){
        //System.out.println("Explode");
        for(int i = 0; i < 18; i++){
          bullets.add(new Bullet(exploders.get(0).getX(), exploders.get(0).getY(), i*20.0));
      }
        exploders.remove(0);
      }
      
      //For loop for all things relating to bullets
      for(int i = 0; i < bullets.size(); i++){
        //Turns a bullet into an exploder if it has the proper type and its timer is greater than 120
        if(bullets.get(i).explodeTimer > 120){
         exploders.add(bullets.get(i));
         bullets.get(i).life = 500;
        }
        if(bullets.get(i).explodeTimer > 0){
         //System.out.println("HEREE");
          bullets.get(i).explodeTimer++;
        }
       //Moves the live bullets every time this loop runs
        bullets.get(i).move(1.0);
       remove = bullets.get(i).checkLife();
       if(remove) {bullets.remove(i);i--;}
      }
      
      //If a bullet has been alive for a certain amount of time, it is removed
      for(int i = 0; i < ammo.size(); i++){
       remove = ammo.get(i).checkLifeA();
       if(remove) {ammo.remove(i);i--;}
      }
      
      
      //Checks overlap from the walls to the players
      for(int j = 0; j < map.Walls().size(); j++){
         for(int k = 0; k < players.size(); k++){
           //Its too hard to check the overlap for the polygon so I made
           //A circle that is centered in the polygon and I check the overlap for that
           tester.setX(players.get(k).getX()-42);
           tester.setY(players.get(k).getY()-42);
           for(int m = 0; m < 4; m++){
             if((map.Walls().get(j).pointOverlap(players.get(k).xP[m], players.get(k).yP[m]) 
             || players.get(k).top.rectOverlap(map.Walls().get(j))|| tester.rectOverlap(map.Walls().get(j)))
             && players.get(k).ghost == false){
               //unmove the player if it overlaps
               players.get(k).move(-1*players.get(k).dir);
               players.get(k).rotate(-1*players.get(k).rotate);
             }
             //If the player is a ghost then dont unmove just record its
             if(players.get(k).ghost && !(map.Walls().get(j).pointOverlap(players.get(k).xP[m], players.get(k).yP[m]) 
                && tester.rectOverlap(map.Walls().get(j)) || players.get(k).top.rectOverlap(map.Walls().get(j)))){
               players.get(k).lastPos.setX(players.get(k).getX());
               players.get(k).lastPos.setY(players.get(k).getY());
             }
           }
         }
        }
      //Bullets deflect when they hit walls
      for(int i = 0; i < bullets.size(); i++){
        for(int j = 0; j < map.Walls().size(); j++){
         if(map.Walls().get(j).pointOverlap(bullets.get(i).getX(), bullets.get(i).getY()))
           bullets.get(i).deflect(map.Walls().get(j));
        }
      }
      
      //Checks bullets overlap with players
      for(int i = 0; i < bullets.size(); i++){
        for(int k = 0; k < players.size(); k++){
          tester.setX(players.get(k).getX()-42);
          tester.setY(players.get(k).getY()-42);
          if(bullets.get(i).anyOverlap(tester) || bullets.get(i).anyOverlap(players.get(k).top)){
            //players.get(players.size()-1-k).getPoint();
            //updateScore();
            players.remove(k);
            bullets.get(i).life = 500;
            restart = true;
          }
      }
      }
      //Check Ammo overlap with bullets
      for(int i = 0; i < ammo.size(); i++){
        for(int k = 0; k < players.size(); k++){
         tester.setX(players.get(k).getX()-42);
         tester.setY(players.get(k).getY()-42);
         if(ammo.get(i).anyOverlap(tester)|| ammo.get(i).anyOverlap(players.get(k).top)){
           ammo.get(i).life = 500;
           points.add(new Point((double)ammo.get(i).getX(), (double)ammo.get(i).getY()));
           //What happens depending on the different type of ammo
           //Only adds 1 bullet
           if(ammo.get(i).type == 0){
             players.get(k).addAmmo();
             updateAmmo();
           }
           //Doubles the speed
           if(ammo.get(i).type == 1){
             players.get(k).s = 1.6;
           }
           //Turn it into ghost mode
           if(ammo.get(i).type == 4){
             players.get(k).ghost = true;
           }
           //makes the next bullet an exploding one
           if(ammo.get(i).type == 3){
             //System.out.println("EXPLODER IS TRUE");
             players.get(k).exploder = true;
           }
           //adds 5 ammo
           if(ammo.get(i).type == 2){
             players.get(k).addAmmo(5);
             updateAmmo();
           }
           
         }
        }
      }
      repaint();
 
    }
  }


    @Override
    public void keyTyped(KeyEvent e) { }

    //What happens when you press the different keys
    @Override
    public void keyPressed(KeyEvent e) {
        /*Rotate = direction of rotation
         *   + = clockwise
         *   - = counter-clockwise
         * Dir = direction of movement
         *   + = forward
         *   - = bakward
         *   # = speed;
         * Shoot = add new bullet
         * H = show/hide help screen
         */
      
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           p2.rotate = 1;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
           p2.rotate = -1;  
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
           p2.dir = 1.3;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
           p2.dir = -1.3;
        }
        if (e.getKeyCode() == KeyEvent.VK_N && !p2.unstuck) {
           p2.unstuck = true;
           p2.ghost = true;
           p2.ghostCount = 100;
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
          if(p2.exploder){
            bullets.add(new Bullet(p2, 1));
            p2.exploder = false;
          }
          else if(p2.shoot()) 
             bullets.add(new Bullet(p2));
             updateAmmo();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
           p1.rotate = 1;
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
           p1.dir = -1.3;

        }
        if (e.getKeyCode() == KeyEvent.VK_E) {
           p1.dir = 1.3;

        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
           p1.rotate = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_A && !p1.unstuck) {
           p1.unstuck = true;
           p1.ghost = true;
           p1.ghostCount = 100;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q) {
          if(p1.exploder){
            bullets.add(new Bullet(p1, 1));
            p1.exploder = false;
          }
          else if(p1.shoot()) 
          bullets.add(new Bullet(p1));
          updateAmmo();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_P) {
           resetGame();
        }
        //Pause game and shows help screen
        if (e.getKeyCode() == KeyEvent.VK_H) {
           if(help) t.start();
           if(!help) t.stop();
          help = !help;
        }

    }

    @Override
    //Resets all variables when you let go of the  keys
    public void keyReleased(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           p2.rotate = 0;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
           p2.rotate = 0;

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
           p2.dir = 0;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
           p2.dir = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
           p1.rotate = 0;
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
           p1.dir = 0;

        }
        if (e.getKeyCode() == KeyEvent.VK_E) {
           p1.dir = 0;

        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
           p1.rotate = 0;
        }
        
    }


  public static void main(String[] args) {
 JFrame w = new JFrame("Shoot Wars");
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
//    x = screensize.width;
//    y = screensize.height;
    w.setSize(screensize);
    w.setExtendedState(w.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    w.getContentPane().add(new ShootWar());
    w.setVisible(true);
  }
}