package Game;


public class GameTimer extends Observable {
  private int length;

  public GameTimer() {
	  length = 300;
  }

  // One step, or tick for the Timer
  public void tick() {
    length--;
    notifyObservers();
  }

  // Returns if the timer is started or not.
  public boolean ended() {
    return (length <= 0);
  }

}
