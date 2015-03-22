package Game;

import Setup.Log;

//A Robot's actual place is determined with Angles
public class Angle {
  private double value;

  public double getAngle() {
    Log.enter();
    Log.write("[:Angle].getAngle()");
    Log.exit();

    return value;
  }

  public void setAngle(double value) {
    Log.enter();
    Log.write("[:Angle].setAngle(value)");

    value %= 360;		//Doing more circles does not have any plus effect here
    this.value = value;

    Log.exit();
  }
}
