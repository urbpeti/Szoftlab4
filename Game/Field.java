package Game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;

import Setup.Log;
import Setup.UseCases;

public class Field {
  private ArrayList<Item>  items;
  private ArrayList<Robot> robots;
  private HashSet<Item>    usedItems;

  public Field() {
    Log.enter();
    Log.write("[Create] Field");
    
    
    items     = new ArrayList<Item>();
    robots    = new ArrayList<Robot>();
    usedItems = new HashSet<Item>();

    //Creating robots
    newRobot("Foo", Color.black);
    newRobot("Bar", Color.black);
    newRobot("Baz", Color.black);
    
    //Placing holes
    placeHoles();

    Log.exit();
  }
  
  //Creating new Robot
  public void newRobot(String name, Color color) {
    Log.enter();
    Log.write("[:Field].newRobot(name, color)");

    robots.add(new Robot(name, color));

    Log.exit();
  }
  
  //Stepping the game
  public void step() {
    if    (UseCases.current.equals("holeInteract")
        || UseCases.current.equals("oilInteract")
        || UseCases.current.equals("tackyInteract")) {
      applyInteraction(robots.get(0));
      return;
    }

    Log.enter();
    Log.write("[:Field].step()");
    
    //Jumping, and interactions
    for (Robot r : robots) {
      r.jump();
      applyInteraction(r);
    }

    Log.exit();
  }

  //Interaction handling
  public void applyInteraction(Robot robot) {
    Log.enter();
    Log.write("[:Field].applyInteraction(robot)");

    Log.off();
    Item o = new Oil();
    Item t = new Tacky();
    Item h = new Hole();
    Log.on();

    if (UseCases.current.equals("holeInteract"))
      h.interact(robot);
    else if (UseCases.current.equals("tackyInteract"))
      t.interact(robot);
    else
      o.interact(robot);

    Log.exit();
  }
  
  //Adding item to the field
  public void addItem(Item item) {
    Log.enter();

    if (UseCases.current.equals("placeOil"))
      Log.write("[:Field].addItem(oil)");
    else if (UseCases.current.equals("placeTacky"))
      Log.write("[:Field].addItem(tacky)");
    items.add(item);

    Log.exit();
  }

  //Removing item from the field
  public void removeItem(Item item) {
    Log.enter();
    Log.write("[:Field].removeItem(item)");

    items.remove(item);

    Log.exit();
  }

  //Getting which items to place from Robots
  public void placeItems() {
    Log.enter();
    Log.write("[:Field].placeItems()");

    if (UseCases.current.equals("placeOil")
        || UseCases.current.equals("placeTacky"))
      addItem(robots.get(0).getItemCache());

    Log.exit();
  }

  //Checking if all the Robots are dead
  public boolean isAllDead() {
    Log.enter();
    Log.write("[:Field].isAllDead()");

    for (Robot r : robots)
      r.getIsDead();

    Log.exit();

    return UseCases.isAllDead;
  }
  
  //Placing holes on the field
  public void placeHoles() {
    Log.enter();
    Log.write("[:Field].placeHoles()");
    Log.exit();
  }
  
  //Clearing the used items from field
  public void clearUsedItems() {
    Log.enter();
    Log.write("[:Field].clearUsedItems()");

    usedItems.removeAll(usedItems);

    Log.exit();
  }

  //Deciding the winnig Robot
  public Robot winner() {
    Log.enter();
    Log.write("[:Field].winner()");

    for (Robot r : robots)
      r.getDistance();

    Log.off();
    //Creating the winnig robot
    Robot winner = new Robot("Foo", Color.black);
    Log.on();

    Log.exit();

    return winner;
  }
}
