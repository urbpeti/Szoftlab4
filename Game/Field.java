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
		
		placeHoles();
		
		Log.exit();
	}

	public void newRobot(String name, Color color) {
	  Log.enter();
	  
	  Log.write("[:Field].newRobot(name,color)");
	  robots.add(new Robot(name, color));
	  Log.write("[:Field].newRobot(name,color)");
    robots.add(new Robot(name, color));
    Log.write("[:Field].newRobot(name,color)");
    robots.add(new Robot(name, color));
	  
	  Log.exit();
	}

	public void step() {
	  Log.write("[:Field].step()");
	}

	public void applyInteraction(Robot robot) {
	  Log.write("[:Field].applyInteraction(robot)");
	}

	public void addItem(Item item) {
	  Log.write("[:Field].addItem(item)");
		items.add(item);
	}

	public void removeItem(Item item) {
	  Log.write("[:Field].removeItem(item)");
		items.remove(item);
	}

	public void placeItems() {
	  Log.write("[:Field].placeItems()");
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
	  Log.write("[:Field].clearUsedItems()");
		usedItems.removeAll(usedItems);
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
