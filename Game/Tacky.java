package Game;

public class Tacky extends Item {
  protected int count;

  public Tacky() {
  }

  // Tacky interaction with Robot
  @Override
  public void interact(Robot robot) {
    robot.halfSpeed();

    count--;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int c) {
    count = c;
  }

  public boolean exists() {
    return false;
  }
}
