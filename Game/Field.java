package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Field {
  private HashMap<Double, Item> items;
  private ArrayList<Robot> robots;
  private ArrayList<Worker> workers;

  public Field() {
    // Initializing the containers
    items = new HashMap<Double, Item>();
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
    }

    for (Robot r : robots) {
      applyInteraction(r);
    }
  }

  public void checkCollision(Robot current) {
    for (Worker w : workers) {
      if (w.getIsDead())
        continue;
      if (!current.inRangeOf(w))
        continue;

      w.setIsDead(true);
      addItem(new Oil(w.getPosition()));
    }

    for (Robot r : robots) {
      if (r == current || r.getIsDead())
        continue;
      if (current.inRangeOf(r)) {
        double cv = current.getVelocity();
        double rv = r.getVelocity();
        double acv = Math.abs(cv);
        double arv = Math.abs(rv);

        Robot winner = acv > arv ? current : r;
        Robot loser = acv > arv ? r : current;

        winner.setVelocity((cv + rv) / 2);
        loser.setIsDead(true);
      }
    }
  }

  public void stepWorkers() {
    for (Worker worker : workers) {
      worker.jump();
    }

    for (Worker worker : workers) {
      if (worker.isCleaning())
        continue;
      workerCollide(worker);
    }
  }

  public void workerCollide(Worker current) {
    for (Worker w : workers) {
      if (w == current || w.getIsDead())
        continue;
      if (current.inRangeOf(w)) {
        double v = current.getVelocity();
        current.setVelocity(-v);
        return;
      }
    }

    for (Robot r : robots) {
      if (r.getIsDead())
        continue;
      if (current.inRangeOf(r)) {
        double v = current.getVelocity();
        current.setVelocity(-v);
        return;
      }
    }
  }

  // Interaction handling
  public void applyInteraction(Robot robot) {
    Item i = items.get(robot.position.getAngle());

    if (i == null)
      return;

    i.interact(robot);

    if (!i.exists())
      items.values().remove(i);
  }

  // Adding item to the field
  public void addItem(Item item) {
    items.put(item.position.getAngle(), item);
  }

  // Removing item from the field
  public void removeItem(Item item) {
    items.remove(item.position.getAngle());
  }

  // Getting which items to place from Robots
  public void placeItems() {
    for (Robot robot : robots) {
      if (robot.getItemCache() != null) {
        addItem(robot.getItemCache());
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

    // Robot winner = new Robot("Foo", Color.black);

    return null;
  }

  // Check witch Oil is expired
  public void clearOil() {
    for (Item item : items.values()) {
      if (item instanceof Oil) {
        Oil oil = (Oil) item;
        if (!oil.exists()) {
          items.values().remove(item);
        } else {
          oil.expire();
        }
      }
    }
  }

  public void newWorker(Worker w) {
    workers.add(w);
  }

  public ArrayList<Robot> getRobots() {
    return robots;
  }

  public ArrayList<Worker> getWorkers() {
    return workers;
  }

  public Collection<Item> getItems() {
    return items.values();
  }
}
