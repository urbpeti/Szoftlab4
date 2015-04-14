package Game;

import java.util.ArrayList;

public class Observable {
  private ArrayList<Observer> observers;

  public void register(Observer observer) {
    observers.add(observer);
  }

  public void unregister(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (Observer observer : observers)
      observer.update();
  }
}
