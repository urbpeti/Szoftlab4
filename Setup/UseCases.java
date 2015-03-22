package Setup;

import java.awt.Color;

import Game.*;

public class UseCases {
  public static String current = "None"; // Mark the current usecase (so it's
                                         // possible to split methods to more
                                         // usecase)

  public static void startGame() {
    // Setting the usecase's parameters
    current = "startGame";

    Game g = new Game();
    g.startGame();
  }

  
  public static boolean isAllDead = false;
  public static void endGame (boolean alldead) {
    // Setting the usecase's parameters
    current = "endGame";
    isAllDead = alldead;

    // Creating a mock game object to simulate a step
    // Logging is disabled for the game creation
    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    // Simulating a step
    g.step();
  }

  
  public static boolean isAccelerate = false;
  public static void accelerateOrDecelerate (boolean acc) {
    // Setting the usecase's parameters
    current = "accelerateOrDecelerate";
    isAccelerate = acc;

    // Creating a mock robot
    Log.off();
    Robot r = new Robot("Foo", Color.black);
    Log.on();

    if (isAccelerate) r.accelerate();
    else              r.decelerate();
  }


  public static boolean isOil = false;
  public static void placeItems (boolean oil) {
    // Setting the usecase's parameters
    current = "placeItems";
    isOil = oil;

    // Creating a mock robot
    Log.off();
    Robot r = new Robot("Foo", Color.black);
    Log.on();

    if (isOil) r.setItemCache(new Oil());
    else       r.setItemCache(new Tacky());
  }
  
  
  public static void placeOil() {
    // Setting the usecase's parameters
    current = "placeOil";

    // Creating a mock game and starting it
    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }

  
  public static void placeTacky() {
    // Setting the usecase's parameters
    current = "placeTacky";

    // Creating a mock game and starting it
    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }
  
  
  public static void stepGame() {
    // Setting the usecase's parameters
    current = "stepGame";

    // Creating a mock game and starting it
    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    // Calling the 'notify' method of the game
    // This will be called by the timer
    g.update();
  }

  
  public static void holeInteract() {
    // Setting the usecase's parameters
    current = "holeInteract";

    // Creating a mock game and starting it
    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }

  
  public static void oilInteract() {
    // Setting the usecase's parameters
    current = "oilInteract";

    // Creating a mock game and starting it
    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }

  
  public static void tackyInteract() {
    // Setting the usecase's parameters
    current = "tackyInteract";

    // Creating a mock game and starting it
    Log.off();
    Game g = new Game();
    g.startGame();
    Log.on();

    g.step();
  }
}