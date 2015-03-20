package Game;

import java.util.ArrayList;

public class Observable {
	private ArrayList<Observer> observers;
	
	private void register(Observer observer) {
		System.out.println("[:Observable].register(observer)");
		observers.add(observer);
	}
	
	private void unregister(Observer observer) {
		System.out.println("[:Observable].unregister(observer)");
		observers.remove(observer);
	}
	
	private void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
