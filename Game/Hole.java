package Game;

public class Hole extends Item {

	@Override
	public void interact(Robot robot) {
		System.out.println("interact()");
		robot.setIsDead(true);
	}

}
