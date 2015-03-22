package Game;

import Setup.Log;

public class Hole extends Item {
	public Hole() {
		Log.enter();
		Log.write("[Create] Hole");
		Log.exit();
	}

	@Override
	public void interact(Robot robot) {
		Log.enter();
		Log.write("[:Hole].interact(robot)");

		robot.setIsDead(true);

		Log.exit();
	}
}
