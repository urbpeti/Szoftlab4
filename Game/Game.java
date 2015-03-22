package Game;

import Setup.Log;
import Setup.UseCases;

public class Game implements Observer {
  private Field field;
  private Timer timer;

  //Constructor
  public Game() {
    Log.enter();
    Log.write("[Create] Game");	//logging the creation of the Game
    Log.exit();
  }

  //Ending the game
  public void endGame() {
    Log.enter();
    Log.write("[:Game].endGame()");

    timer.end();	//Stopping the timer
    Robot winner = field.winner();	//Getting the winner

    Log.exit();
  }

  //Starting the game
  public void startGame() {
    Log.enter();
    Log.write("[:Game].startGame()");
    
    //Creating new Field and Timer
    field = new Field();
    timer = new Timer();
    timer.start();

    Log.exit();
  }

  public void step() {
	//Stepping the game
    if (UseCases.current.equals("holeInteract")
        || UseCases.current.equals("oilInteract")
        || UseCases.current.equals("tackyInteract")) {
      field.step();
      return;
    }

    Log.enter();
    Log.write("[:Game].step()");

    //Placing items
    if (UseCases.current.equals("placeOil")
        || UseCases.current.equals("placeTacky")) {
      field.placeItems();
    }

    if (UseCases.current.equals("stepGame")) {
      field.placeItems();
      field.step();
      field.clearUsedItems();
    }

    //Ending the game
    if (UseCases.current.equals("endGame")) {
      boolean alldead = field.isAllDead();
      boolean ended = timer.ended();

      if (alldead || ended) endGame();
    }

    Log.exit();
  }

  //Observer handling
  @Override
  public void update() {
    Log.enter();
    Log.write("[:Game].update()");

    step();

    Log.exit();
  }
}
