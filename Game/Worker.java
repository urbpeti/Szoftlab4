package Game;

public class Worker extends Creature {
  private int cleaningTime;
  private boolean cleaning;

  public Worker(Angle p, double v) {
    position = p;
    velocity = v;
    cleaning = false;
  }
  
  //Moving the Robot
  public void jump() {
    if (cleaning) return;
    
    velocity += delta;
    delta = 0;
    position.addAngle(velocity);
  }

  public int getCleaningTime() {
    return cleaningTime;
  }

  public void setCleaningTime(int time) {
    cleaningTime = time;
  }
  
  public String toString() {
    String s = getIsDead() ? "Dead" : "Alive";
    return "Worker " + s + " " + position + " " + cleaningTime + " " + velocity;
  }
  
  public boolean isCleaning() {
    return cleaning;
  }
}
