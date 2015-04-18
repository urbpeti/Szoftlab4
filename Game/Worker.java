package Game;

public class Worker extends Creature {
  private int cleaningTime; 
  private boolean cleaning;
  private Field field;

  public Worker(Angle p, double v, Field f) {
    position = p;
    velocity = v;
    cleaning = false;
    cleaningTime = 0;
    field = f;
    
    // elinditja a legkozelebbi item fele
    // ezt majd ujra meg kell hivni ha vegzett egy itemmel
    go();
  }
  
  private void go() {
    Item i = getClosestItem();
    
    // itt valahogy meg kell hatarozni az iranyat a kisrobotnak
    // hogy merre menjen a legkozelebbi cucchoz
    double a = getPosition().getAngle();
    double b = i.position.getAngle();
    double s = Math.signum(Math.min(Math.abs((a - b)), 360 - Math.abs((a - b))));
    
    velocity *= s;
  }
  
  private Item getClosestItem() {
    Item min = null;
    double mind = 1000;
    for (Item i: field.getItems()) {
      if (i instanceof Hole) continue;
      double d = position.distance(i.position);
      if (d < mind) {
        min = i;
        mind = d;
      }
    }
    
    return min;
  }

  // Moving the Robot
  public void jump() {
    if (cleaning) {
      // le kell kezelni amikor vegzett a takaritassal
      cleaningTime++;
      return;
    }
    
    if (onItem()) { // ha egy itemen all elkezd takaritani
      cleaning = true;
      cleaningTime = 0;
    }
    
    velocity += delta;
    delta = 0;
    position.addAngle(velocity);
  }

  private boolean onItem() { // epp egy itemen all-e
    
    return false;
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
