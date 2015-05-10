package Game;

public class Oil extends Item {
  private int expiration;

  public Oil(Angle a) {
    super(a);
    expiration = 0;
  }

  // Oil interaction with Robot
  @Override
  public void interact(Robot robot) {
    robot.setOnOil(true);
  }

  public void setExpiration(int e) {
    expiration = e;
  }

  public int getExpiration() {
    return expiration;
  }

  public boolean exists() {
    return expiration < 3;
  }

  public String toString() {
    return "Oil " + position + " " + expiration;
  }

  public void expire() {
    expiration++;
  }

  @Override
  public void interact(Worker worker) {
  }
}
