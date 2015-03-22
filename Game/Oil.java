package Game;

import Setup.Log;

public class Oil extends Item {
  public Oil() {
    Log.enter();
    Log.write("[Create] Oil");	//Logging oil creation
    Log.exit();
  }

  //Oil interaction with Robot
  @Override
  public void interact(Robot robot) {
    Log.enter();
    Log.write("[:Oil].interact(robot)");

    robot.setOnOil(true);

    Log.exit();
  }
}
