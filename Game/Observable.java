package Game;

import java.util.ArrayList;

import Setup.Log;

public class Observable {
  private ArrayList<Observer> observers;

  public void register(Observer observer) {
    Log.enter();
    Log.write("[:Observable].register(observer)");

    observers.add(observer);

    Log.exit();
  }

  public void unregister(Observer observer) {
    Log.enter();
    Log.write("[:Observable].unregister(observer)");

    observers.remove(observer);

    Log.exit();
  }

  public void notifyObservers() {
    Log.enter();
    Log.write("[:Observable].notifyObservers()");
    
    for (Observer observer : observers)
      observer.update();

    Log.exit();
  }
}
