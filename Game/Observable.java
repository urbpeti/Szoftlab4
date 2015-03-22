package Game;

import java.util.ArrayList;

public class Observable {
  private ArrayList<Observer> observers;

  private void register(Observer observer) {
    Log.enter();
    Log.write("[:Observable].register(observer)");

    observers.add(observer);

    Log.exit();
  }

  private void unregister(Observer observer) {
    Log.enter();
    Log.write("[:Observable].unregister(observer)");

    observers.remove(observer);

    Log.exit();
  }

  private void notifyObservers() {
    Log.enter();
    Log.write("[:Observable].notifyObservers()");
    
    for (Observer observer : observers)
      observer.update();

    Log.exit();
  }
}
