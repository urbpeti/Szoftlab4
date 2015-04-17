package Game;

public class Hole extends Item {
  public Hole() {

  }

  @Override
  public void interact(Robot robot) {
    robot.setIsDead(true);
  }
}
