package Game;

import Setup.Log;

public class Oil extends Item {
	public Oil() {
		Log.enter();
		Log.write("[Create] Oil");
		Log.exit();
	}

	@Override
	public void interact(Robot robot) {
		Log.enter();
		Log.write("[:Oil].interact(robot)");

		robot.setOnOil(true);

		Log.exit();
	}
}
