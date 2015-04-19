package Game;

public class Oil extends Item {
  protected int expiration;

  public Oil(Angle a) {
    super(a);
    expiration = 10;
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
    return false;
  }
  
  public String toString() {
    return "Oil " + position + " " + expiration;
  }

  @Override
  public void interact(Worker worker) {
    
  }
}
