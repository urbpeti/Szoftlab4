package Game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;

public class Field {
	private ArrayList<Item> items;
	private ArrayList<Robot> robots;
	private HashSet<Item> usedItems;

	public Field() {
		System.out.println("[Create] Field");
		items = new ArrayList<Item>();
		robots = new ArrayList<Robot>();
		usedItems = new HashSet<Item>();
	}

	public void newRobot(String name, Color color) {
		System.out.println("[:Field].newRobot(name,color)");
		robots.add(new Robot(name, color));
	}

	public void step() {
		System.out.println("[:Field].step()");
	}

	public void applyInteraction(Robot robot) {
		System.out.println("[:Field].applyInteraction(robot)");
	}

	public void addItem(Item item) {
		System.out.println("[:Field].addItem(item)");
		items.add(item);
	}

	public void removeItem(Item item) {
		System.out.println("[:Field].removeItem(item)");
		items.remove(item);
	}

	public void placeItems() {
		System.out.println("[:Field].placeItems()");
	}

	public boolean isAllDead() {
		System.out.println("[:Field].isAllDead()");
		return false;
	}

	public void placeHoles() {
		System.out.println("[:Field].placeHoles()");
	}

	public void clearUsedItems() {
		System.out.println("[:Field].clearUsedItems()");
		usedItems.removeAll(usedItems);
	}

	public Robot winner() {
		System.out.println("[:Field].winner()");
		return new Robot("asdf", Color.black);
	}
}
