package Game;

public class Game implements Observer {
  private Field field;
  private GameTimer timer;

  // Constructor
  public Game() {
    // Creating Field and Timer
    field = new Field();
    
    timer = new GameTimer();
    timer.register(this);
  }
  
  //Starting the game
 public void startGame() {
   timer.start();
 }
  
  public void step() {
    // Stepping the game
    field.placeItems();
    field.step();
    
    // Ending the game
    boolean alldead = field.isAllDead();
    boolean ended = timer.ended();

    if (alldead || ended) endGame();
  }

  // Ending the game
  public void endGame() {
    // Stopping the timer
    timer.end();

    // Getting the winner
    Robot winner = field.winner();
  }

  // Observer handling
  @Override
  public void update() {
    // For every tick a step will occur
    step();
  }
}
