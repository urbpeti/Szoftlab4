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
    return "Hole " + position;
  }

  @Override
  public void interact(Worker worker) {
    worker.setIsDead(true);
  }

  @Override
  public boolean exists() {
    return true;
  }

}
