package Setup;

import java.awt.Color;

import Game.*;

public class UseCases {
  public static String current = "None"; // Mark the current usecase (so it's
                                         // possible to split methods to more
                                         // usecase)

  public static void startGame() {
    current = "startGame";

    Game g = new Game();
    g.startGame();
  }

  
  public static boolean isAllDead = false;
  public static void endGame (boolean alldead) {
    current = "endGame";
    isAllDead = alldead;

    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }


  public static boolean isAccelerate = false;
  public static void accelerateOrDecelerate (boolean acc) {
    current = "accelerateOrDecelerate";
    isAccelerate = acc;

    Log.off();
    Robot r = new Robot("Foo", Color.black);
    Log.on();

    if (isAccelerate) r.accelerate();
    else              r.decelerate();
  }


  public static boolean isOil = false;
  public static void placeItems (boolean oil) {
    current = "placeItems";
    isOil = oil;

    Log.off();
    Robot r = new Robot("Foo", Color.black);
    Log.on();

    if (isOil) r.setItemCache(new Oil());
    else       r.setItemCache(new Tacky());
  }
  
  
  public static void placeOil() {
    current = "placeOil";

    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }

  
  public static void placeTacky() {
    current = "placeTacky";

    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }
  
  
  public static void stepGame() {
    current = "stepGame";

    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.update();
  }

  
  public static void holeInteract() {
    current = "holeInteract";

    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }

  
  public static void oilInteract() {
    current = "oilInteract";

    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }

  
  public static void tackyInteract() {
    current = "tackyInteract";

    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }
}