package Game;

public class Tacky extends Item {

	@Override
	public void interact(Robot robot) {
		System.out.println("interact()");
		robot.halfSpeed();
	}
}
