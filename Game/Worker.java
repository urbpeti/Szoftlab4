package Game;

import Setup.Log;

public class Worker extends Creature {
  private int cleaningTime;
  
  public Worker(Angle pos) {
    
  }
  
  public void jump() {
    Log.enter();
    Log.write("[:Worker].jump()");
    Log.exit();
  }
  
  public int getCleaningTime() {
    return cleaningTime;
  }
  
  public void setCleaningTime(int time) {
    cleaningTime = time;
  }
}
