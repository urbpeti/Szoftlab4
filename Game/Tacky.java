package Game;

import Setup.Log;

public class Tacky extends Item {
  public Tacky () {
    Log.enter();
    
    Log.write("[Create] Tacky");
    
    Log.exit();
  }

	@Override
	public void interact(Robot robot) {
		System.out.println("interact()");
		robot.halfSpeed();
	}
}
