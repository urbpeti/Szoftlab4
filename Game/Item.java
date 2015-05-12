package Game;

//Abstract ParentClass
public abstract class Item {
  protected Angle position;
  protected double radius;

  public Item(Angle a) {
    position = a;
    radius = 2;
  }

  public abstract void interact(Robot robot);

  public abstract void interact(Worker worker);

  public abstract boolean exists();
}
