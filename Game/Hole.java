package Game;

import Setup.Log;

public class Hole extends Item {
  public Hole() {
    Log.enter();
    Log.write("[Create] Hole");		//Logging hole creation
    Log.exit();
  }

  @Override
  public void interact(Robot robot) {
    Log.enter();
    Log.write("[:Hole].interact(robot)");	//Hole interaction

    robot.setIsDead(true);

    Log.exit();
  }
}
