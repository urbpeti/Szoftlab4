package Game;

import Setup.Log;
import Setup.UseCases;

public class Timer extends Observable {
  private int length;

  //Constructor, logging
  public Timer() {
    Log.enter();
    Log.write("[Create] Timer");
    Log.exit();
  }

  //One step, or tick for the Timer
  private void tick() {
    Log.enter();
    Log.write("[:Timer].tick()");
    Log.exit();
  }

  //returns if the timer is started or not.
  public boolean ended() {
    Log.enter();
    Log.write("[:Timer].ended()");
    Log.exit();
    return !UseCases.isAllDead;
  }
  
  //Starting the Timer
  public void start() {
    Log.enter();
    Log.write("[:Timer].start()");
    Log.exit();
  }

  //Ending the Timer
  public void end() {
    Log.enter();
    Log.write("[:Timer].end()");
    Log.exit();
  }
}
