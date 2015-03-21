package Game;

import Setup.Log;

public class Oil extends Item {
  public Oil () {
    Log.enter();
    
    Log.write("[Create] Oil");
    
    Log.exit();
  }

	@Override
	public void interact(Robot robot) {
		System.out.println("interact()");
		robot.setOnOil(true);
	}
}
