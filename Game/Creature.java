package Game;

public abstract class Creature {
  protected Angle position;
  protected double velocity;
  protected double distance;
  protected double delta;

  private boolean isDead;

  // Constructor

  // Returns the robot's position in Angle
  public Angle getPosition() {
    return position;
  }

  public double getVelocity() {
    return velocity;
  }

  public void setVelocity(double v) {
    velocity = v;
  }

  public double getDelta() {
    return delta;
  }

  public void setDelta(double d) {
    delta = d;
  }

  // Returns the amount of distance the robot has travelled, from the starting
  // of the game
  public double getDistance() {
    return distance;
  }

  public void setDistance(double d) {
    distance = d;
  }

  // Returns true if the robot is dead, false otherwise
  public boolean getIsDead() {
    return isDead;
  }

  // Sets the robot's isDead variable
  public void setIsDead(boolean isDead) {
    this.isDead = isDead;
    System.out.println("Meghaltam");
  }

  public boolean inRangeOf(Creature c) {
    double dist = getPosition().distance(c.getPosition());

    return dist < 0.5;
  }
}
