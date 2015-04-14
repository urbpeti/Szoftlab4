package Game;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer extends Observable {
  private int length;
  private Timer timer;

  // Constructor, logging
  public GameTimer() {
    timer = new Timer(1000, new ActionListener() {
      public void actionPerformed(ActionEvent e) { tick(); }
    });
  }

  // One step, or tick for the Timer
  private void tick() {
    notifyObservers();
  }

  // Returns if the timer is started or not.
  public boolean ended() {
    return length <= 0;
  }
  
  // Starting the Timer
  public void start() {
    timer.start();
  }

  // Ending the Timer
  public void end() {
    timer.stop();
  }
}
