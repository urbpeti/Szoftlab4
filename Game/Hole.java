package Game;

public class Hole extends Item {

  public Hole(Angle a) {
    super(a);
  }

  @Override
  public void interact(Robot robot) {
    robot.setIsDead(true);
  }
  
  public String toString() {
    return "Tacky " + position;
  }
}
