package Tests;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Game.*;

public class Tester {
  public static void main(String[] args) throws IOException {
    Field f = new Field();
    Game g = new Game(f);

    BufferedReader br = new BufferedReader(new FileReader("tests/rc.txt"));
    try {
      String line = br.readLine();

      while (line != null) {
        String[] as = line.split(" ");
        String cmd = as[0];
        
        if (cmd.equals("Robot")) {
          f.newRobot(createRobot(as)); 
        }
        else if (cmd.equals("Step")) {
          g.step();
        }
        else if (cmd.equals("List_Robots")) {
          for (Robot r: f.getRobots()) {
            System.out.println(r.toString());
          }
        }
        line = br.readLine();
      }
    } finally {
      br.close();
    }
  }

  private static Robot createRobot(String[] args) {
    String n = args[1];
    Angle p  = new Angle(Double.parseDouble(args[2]));
    double v = Double.parseDouble(args[3]);
    
    return new Robot(n, Color.BLACK, p, v);
  }
}