package Game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Field implements Observer {
  private HashMap<Double, Item> items;
  private ArrayList<Robot> robots;
  private ArrayList<Worker> workers;
  private Control control;
  private int countdown;

  public Field() {
    // Initializing the containers
    items = new HashMap<Double, Item>();
    robots = new ArrayList<Robot>();
    workers = new ArrayList<Worker>();
    countdown = 4;

    // Placing holes randomly on the field
    //placeHoles();
  }
  
  public void setControl (Control c){
	//Initializing control
	    control = c;
  }

  // Creating new Robot
  public void newRobot(String name, Color cl) {
	Robot r = new Robot(name,cl,new Angle(robots.size()*90),9);
    robots.add(r);
    //Add to control
    control.creatureAdded(r);
  }

  // Stepping the game
  public void step() {
	  clearOil();
	  placeItems();
    stepWorkers();

    // Jumping, and interactions

    for (Robot r : robots) {
      if(!r.getIsDead()){
    	r.jump();

      checkCollision(r);
      }
    }

    for (Robot r : robots) {
      if (!r.getIsDead())
    	applyInteraction(r);
    }
    
    if (--countdown == 0){
        double rand = Math.random() * 360;
    	newWorker(new Worker(new Angle(rand),5,this));
    	countdown = (int)(Math.random()*11)+5;
    }
  }

  public void checkCollision(Robot current) {
    for (Worker w : workers) {
      if (w.getIsDead())
        continue;
      if (!current.inRangeOf(w))
        continue;

      w.setIsDead(true);
      addItem(new Oil(new Angle(w.getPosition().getAngle())));
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
    	worker.go();
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
	 Item temp = null;
	for (Item i : items.values()) {
		if (robot.inRangeOf(i) && i.exists()){
			temp = i;
		}
	}
    //Item i = items.get(robot.position.getAngle());

    if (temp == null)
      return;
    
    temp.interact(robot);

    if (!temp.exists()){
      items.values().remove(temp);
      control.itemRemoved(temp);
    }
  }

  // Adding item to the field
  public void addItem(Item item) {
    items.put(item.position.getAngle(), item);
    //Add to control
    control.itemAdded(item);
  }

  // Removing item from the field
  public void removeItem(Item item) {
    items.values().remove(item);
    //Remove from control
    control.itemRemoved(item);
  }

  // Getting which items to place from Robots
  public void placeItems() {
    for (Robot robot : robots) {
      if (robot.getItemCache() != null) {
        addItem(robot.getItemCache());
        robot.setItemCache(null);
      }
    }
  }

  // Checking if all the Robots are dead
  public boolean isAllDead() {
    boolean ad = true;
    for (Robot r : robots)
      ad &= r.getIsDead();

    return ad;
  }

  // Placing holes on the field
  public void placeHoles() {
          int db = (int) (Math.random() * 6)+1;
	  for (int i=0; i<db; i++) {
	    double position = Math.random()*360;
	    addItem(new Hole(new Angle(position)));
          }
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
	  ArrayList<Item> temp= new ArrayList<Item>();
    for (Item item : items.values()) {
      if (item instanceof Oil) {
        Oil oil = (Oil) item;
        if (!oil.exists()) {
        	System.out.println("Én ilyen olaj voltam");
          temp.add(item);
        } else {
          oil.expire();
        }
      }
    }
    for (Item item : temp) {
    	items.values().remove(item);
	    control.itemRemoved(item);
	}
    temp.clear();
  }

  public void newWorker(Worker w) {
    workers.add(w);
    control.creatureAdded(w);
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
  
  public void update() {
		step();
  }
}
