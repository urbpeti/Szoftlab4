package Game;

public class Game {
	private Field field;
	private Timer timer;

	public void endGame() {
		System.out.println("[:Game].endGame()");
	}

	public void startGame() {
		System.out.println("[:Game].startGame()");
	}
	
	public void step() {
		System.out.println("[:Game].step()");
	}

}
