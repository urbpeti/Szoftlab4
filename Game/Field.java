package Game;

import java.util.ArrayList;

public class Field {
  private ArrayList<Item> items;
  private ArrayList<Robot> robots;
  private ArrayList<Worker> workers;

  public Field() {
    // Initializing the containers
    items = new ArrayList<Item>();
    robots = new ArrayList<Robot>();
    workers = new ArrayList<Worker>();

    // Placing holes randomly on the field
    placeHoles();
  }

  // Creating new Robot
  public void newRobot(Robot r) {
    robots.add(r);
  }

  // Stepping the game
  public void step() {
    stepWorkers();
    // Jumping, and interactions
    for (Robot r : robots) {
      r.jump();
      checkCollision(r);
      applyInteraction(r);
    }
  }

  // Interaction handling
  public void applyInteraction(Robot robot) {

  }

  // Adding item to the field
  public void addItem(Item item) {
    items.add(item);
  }

  // Removing item from the field
  public void removeItem(Item item) {
    items.remove(item);
  }

  // Getting which items to place from Robots
  public void placeItems() {
    for (Robot robot : robots) {
      if (robot.getItemCache() != null) {
        items.add(robot.getItemCache());
      }
    }
  }

  // Checking if all the Robots are dead
  public boolean isAllDead() {
    boolean ad = false;
    for (Robot r : robots)
      ad &= r.getIsDead();

    return ad;
  }

  // Placing holes on the field
  public void placeHoles() {

  }

  // Deciding the winning Robot
  public Robot winner() {
    for (Robot r : robots)
      r.getDistance();

    //Robot winner = new Robot("Foo", Color.black);

    return null;
  }

  // Check witch Oil is expired
  public void clearOil() {
    for (Item item : items) {
      if (item instanceof Oil) {
        Oil oil = (Oil) item;
        if (oil.getExpiration() >= 4) {
          items.remove(item);
        }
      }
    }
  }

  public void newWorker() {
    //workers.add(new Worker(new Angle()));
  }

  public void checkCollision(Robot current) {
    for (Robot r: robots) {
      if (r == current || r.getIsDead()) continue;
      if (current.inRangeOf(r)) {
        double cv  = current.getVelocity();
        double rv  = r.getVelocity();
        double acv = Math.abs(cv);
        double arv = Math.abs(rv);
        
        Robot winner = acv > arv ? current : r;
        Robot loser  = acv > arv ? r : current;
        
        winner.setVelocity((cv + rv) / 2);
        loser.setIsDead(true);
      }
    }
  }

  public void stepWorkers() {
    for (Worker worker : workers) {
      worker.jump();
      workerCollide(worker);
    }
  }

  public void workerCollide(Worker w) {

  }
  
  public ArrayList<Robot> getRobots() {
    return robots;
  }
}
