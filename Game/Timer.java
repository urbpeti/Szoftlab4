package Game;

public class Timer extends Observable {
	private int length;

	private void tick() {
		System.out.println("[:Timer].tick()");
	}

	private boolean ended() {
		System.out.println("[:Timer].ended()");
		return false;
	}

	private void start() {
		System.out.println("[:Timer].start()");
	}

	private void end() {
		System.out.println("[:Timer].end()");
	}
}
