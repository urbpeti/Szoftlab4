package Game;

//A Robot's actual place is determined with Angles
public class Angle {
  private double value;
  
  public Angle(double d) {
    setAngle(d);
  }

  public double getAngle() {
    return value;
  }

  public void setAngle(double value) {
    value %= 360; // Doing more circles does not have any plus effect here
    this.value = value;
  }

  public void addAngle(double angle) {
    value += angle;
    while (value < 0)
      value = 360 + value;
    value %= 360;
  }
  
  public double distance(Angle a) {
    double ad   = a.getAngle();
    double dist = Math.min(Math.abs((value - ad)), 360 - Math.abs((value - ad)));
    
    return Math.abs(dist);
  }
  
  public String toString() {
    return "" + value;
  }
}
