package Game;

public class Oil extends Item {

	@Override
	public void interact(Robot robot) {
		System.out.println("interact()");
		robot.setOnOil(true);
	}
}
