package Game;

import java.awt.Color;
import java.util.ArrayList;


public class Field {
  private ArrayList<Item>  items;
  private ArrayList<Robot> robots;

  public Field() {
    // Initializing the containers
    items  = new ArrayList<Item>();
    robots = new ArrayList<Robot>();

    // Creating robots
    newRobot("Foo", Color.black);
    newRobot("Bar", Color.black);
    newRobot("Baz", Color.black);
    
    // Placing holes randomly on the field
    placeHoles();
  }
  
  //  Creating new Robot
  public void newRobot(String name, Color color) {
    robots.add(new Robot(name, color));
  }
  
  //  Stepping the game
  public void step() {
    //  Jumping, and interactions
    for (Robot r : robots) {
      r.jump();
      applyInteraction(r);
    }
  }

  //  Interaction handling
  public void applyInteraction(Robot robot) {
    
  }
  
  //  Adding item to the field
  public void addItem(Item item) {
    items.add(item);
  }

  //  Removing item from the field
  public void removeItem(Item item) {
    items.remove(item);
  }

  //  Getting which items to place from Robots
  public void placeItems() {
    
  }

  //  Checking if all the Robots are dead
  public boolean isAllDead() {
    boolean ad = false;
    for (Robot r : robots)
      ad &= r.getIsDead();
    
    return ad;
  }
  
  // Placing holes on the field
  public void placeHoles() {
    
  }
  
  // Deciding the winnig Robot
  public Robot winner() {
    for (Robot r : robots)
      r.getDistance();

    Robot winner = new Robot("Foo", Color.black);
    
    return winner;
  }

  public void clearOil() {
    
  }
  
  public void newWorker() {
    
  }
  
  public void checkCollision(Robot r) {
    
  }
  
  public void stepWorkers() {
    
  }
  
  public void workerCollide(Worker w) {
    
  }
}
