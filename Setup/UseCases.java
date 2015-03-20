package Setup;
import Game.*;

public class UseCases {
  public static String current = "None";    // Mark the current usecase (so it's possible to split methods to more usecase) 
  
  public static void startGame () {
    current = "startGame";
    
    Game g = new Game();

    g.startGame();
  }
  
  public static boolean isAllDead = false;
  public static void endGame (boolean alldead) {
    current   = "endGame";
    isAllDead = alldead;
    
    Log.off();
    
    Game g = new Game();
    g.startGame();
    
    Log.on();
    
    g.step();
  }
}
