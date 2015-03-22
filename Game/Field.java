package Game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;

import Setup.Log;
import Setup.UseCases;

public class Field {
	private ArrayList<Item> items;
	private ArrayList<Robot> robots;
	private HashSet<Item> usedItems;

	public Field() {
	  Log.enter();
	  
		Log.write("[Create] Field");
		
		items     = new ArrayList<Item>();
		robots    = new ArrayList<Robot>();
		usedItems = new HashSet<Item>();
		
		newRobot("Foo", Color.black);
		newRobot("Foo", Color.black);
		newRobot("Foo", Color.black);
		
		placeHoles();
		
		Log.exit();
	}

	public void newRobot(String name, Color color) {
	  Log.enter();
	  
	  Log.write("[:Field].newRobot(name,color)");
	  robots.add(new Robot(name, color));
	  
	  Log.exit();
	}

	public void step() {
	  if (UseCases.current.equals("holeInteract") ||
        UseCases.current.equals("oilInteract")  ||
        UseCases.current.equals("tackyInteract")) {
	    applyInteraction(robots.get(0));
    
      return;
    }
	  
	  Log.enter();
	  
	  Log.write("[:Field].step()");
	  
	  for (Robot r: robots) {
	    r.jump();
	    
	    applyInteraction(r);
	  }
	  
	  Log.exit();
	}

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

	public void addItem(Item item) {
	  Log.enter();
	  
	  if (UseCases.current.equals("placeOil"))
	    Log.write("[:Field].addItem(oil)");
	  else if (UseCases.current.equals("placeTacky"))
      Log.write("[:Field].addItem(tacky)");
	  items.add(item);
	  
	  Log.exit();
	}

	public void removeItem(Item item) {
	  Log.enter();
	  
	  Log.write("[:Field].removeItem(item)");
		items.remove(item);
		
		Log.exit();
	}

	public void placeItems() {
	  Log.enter();
	  
	  Log.write("[:Field].placeItems()");
	  
	  if (UseCases.current.equals("placeOil") || UseCases.current.equals("placeTacky"))
  	  addItem(robots.get(0).getItemCache());
	  
	  Log.exit();
	}

	public boolean isAllDead() {
	  Log.enter();
	  
	  Log.write("[:Field].isAllDead()");
	  
	  for (Robot r: robots) {
	    r.getIsDead();
	  }
	  
	  Log.exit();
		return UseCases.isAllDead;
	}

	public void placeHoles() {
	  Log.enter();
	  
		Log.write("[:Field].placeHoles()");
		
		Log.exit();
	}

	public void clearUsedItems() {
	  Log.enter();
	  
	  Log.write("[:Field].clearUsedItems()");
		usedItems.removeAll(usedItems);
		
		Log.exit();
	}
	
	public Robot winner(){
	  Log.enter();
	  
	  Log.write("[:Field].winner()");
	  
	  for (Robot r: robots) r.getDistance();
	  
	  Log.off();
	  Robot winner = new Robot("Foo",Color.black);
	  Log.on();
	  
	  Log.exit();
		return winner;
	}
}
