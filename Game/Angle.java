package Game;

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

    value %= 360;
    this.value = value;

    Log.exit();
  }
}
