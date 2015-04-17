package Game;

//A Robot's actual place is determined with Angles
public class Angle {
  private double value;

  public double getAngle() {
    return value;
  }

  public void setAngle(double value) {
    value %= 360; // Doing more circles does not have any plus effect here
    this.value = value;
  }

  public void addAngle(double angle) {
    value += angle;
    value %= 360;
  }
}
