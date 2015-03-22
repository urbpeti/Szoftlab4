package Game;

import Setup.Log;

public class Tacky extends Item {
	public Tacky() {
		Log.enter();
		Log.write("[Create] Tacky");
		Log.exit();
	}

	@Override
	public void interact(Robot robot) {
		Log.enter();
		Log.write("[:Tacky].interact(robot)");

		robot.halfSpeed();

		Log.exit();
	}
}
