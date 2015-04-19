package Game;

public class Worker extends Creature {
  private int cleaningTime; 
  private boolean cleaning;
  private Item cleaningItem;
  private Field field;

  public Worker(Angle p, double v, Field f) {
    position = p;
    velocity = v;
    cleaning = false;
    cleaningTime = 0;
    field = f;
    
    go();
  }
  
  private void go() {
    Item i = getClosestItem();
    
    if (i == null) return;
 
    
    double distance = i.position.getAngle() - position.getAngle();
    while(distance < 0)
      distance += 360;
    if(distance > 180)
      velocity = -1;
    else
      velocity = 1;    
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
    if (getIsDead()) return;
    
    if (cleaning) {
      cleaningTime++;
      
      if (cleaningTime == 2) { // ha  vegzett
        field.removeItem(cleaningItem);
        
        cleaningTime = 0;
        cleaning = false;
        cleaningItem = null;
        go();
      }
      else return;
    }
    
    Item found = onItem();
    if (found != null) {
      if (getIsDead()) return;
      
      cleaning = true;
      cleaningItem = found; 
      cleaningTime = 1;
      return;
    }
    
    position.addAngle(velocity);
  }

  private Item onItem() {
    double current = getPosition().getAngle();
    
    Item item = null;
    for (Item i: field.getItems())
      if (i.position.getAngle() == current) { // ide rangeof
        item = i;
        break;
      }
    
    if (item == null) return null;
    
    item.interact(this);
    
    return item;
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
