package Game;

import Setup.Log;
import Setup.UseCases;

public class Game implements Observer {
	private Field field;
	private Timer timer;
	
	public Game () {
	  Log.enter();
    
    Log.write("[Create] Game");
    
    Log.exit();
	}

	public void endGame() {
	  Log.enter();
	  
	  Log.write("[:Game].endGame()");
	  
	  timer.end();
	  
	  Robot winner = field.winner();
	  
	  Log.exit();
	}

	public void startGame() {
	  Log.enter();
		
	  Log.write("[:Game].startGame()");
	  
	  field = new Field();
	  
	  timer = new Timer();
	  timer.start();
		
	  Log.exit();
	}

	public void step() {
	  if (UseCases.current.equals("holeInteract") ||
	      UseCases.current.equals("oilInteract")  ||
	      UseCases.current.equals("tackyInteract")) {
	    field.step();
	    
	    return;
	  }
	  
	  Log.enter();
	  
	  Log.write("[:Game].step()");
	  
	  if (UseCases.current.equals("placeOil") || UseCases.current.equals("placeTacky")) {
      field.placeItems();
    }
	  
	  if (UseCases.current.equals("stepGame")) {
	    field.placeItems();
	    
	    field.step();
	    
	    field.clearUsedItems();
	  }
	  
	  if (UseCases.current.equals("endGame")) {
	    boolean alldead = field.isAllDead();
	    boolean ended = timer.ended();
	    
	    if (alldead || ended)
	      endGame();
	  }
	  
	  Log.exit();
	}
	
	@Override
  public void update () {
	  Log.enter();
	  
	  Log.write("[:Game].update()");
	  
	  step();
	  
	  Log.exit();
  }
}
