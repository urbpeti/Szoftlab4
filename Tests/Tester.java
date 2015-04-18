package Tests;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Game.*;

public class Tester {
  private static Field f;
  private static Game g;
  
  public static void listRobots() {
    System.out.println("Robots:");
    for (Robot r: f.getRobots()) {
      System.out.println(r);
    }
  }
  
  public static void listWorkers() {
    System.out.println("Workers:");
    for (Worker w: f.getWorkers()) {
      System.out.println(w);
    }
  }
  
  public static void listItems() {
    System.out.println("Items:");
    for (Item i: f.getItems()) {
      System.out.println(i);
    }
  }
  
  public static void main(String[] args) throws IOException {
    f = new Field();
    g = new Game(f);

    BufferedReader br = new BufferedReader(new FileReader("tests/rwc.txt"));
    try {
      String line = br.readLine();

      while (line != null) {
        String[] as = line.split(" ");
        String cmd = as[0];
        
        if      (cmd.equals("Robot"))        addRobot(as);
        else if (cmd.equals("Worker"))       addWorker(as);
        else if (cmd.equals("Item"))         addItem(as);
        else if (cmd.equals("Step"))         g.step();
        else if (cmd.equals("List_Robots"))  listRobots();
        else if (cmd.equals("List_Workers")) listWorkers();
        else if (cmd.equals("List_Items"))   listItems();
        
        line = br.readLine();
      }
    } finally {
      br.close();
    }
  }

  private static void addItem(String[] args) {
    String type = args[1];
    Angle pos   = new Angle(Double.parseDouble(args[2]));
    
    if      (type.equals("Tacky")) f.addItem(new Tacky(pos));
    else if (type.equals("Oil"))   f.addItem(new Oil(pos));
    else if (type.equals("Hole"))  f.addItem(new Hole(pos));
  }

  private static void addWorker(String[] args) {
    Angle p  = new Angle(Double.parseDouble(args[1]));
    double v = Double.parseDouble(args[2]);
    
    f.newWorker(new Worker(p, v));
  }

  private static void addRobot(String[] args) {
    String n = args[1];
    Angle p  = new Angle(Double.parseDouble(args[2]));
    double v = Double.parseDouble(args[3]);
    
    f.newRobot(new Robot(n, Color.BLACK, p, v));
  }
}