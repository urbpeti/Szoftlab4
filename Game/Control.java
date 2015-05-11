package Game;

public interface Control {

  public void itemAdded(Item i);

  public void itemRemoved(Item i);

  public void creatureAdded(Creature c);

  public void creatureRemoved(Creature c);
}
