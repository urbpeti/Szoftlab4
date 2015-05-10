package Game;

public class Tacky extends Item {
  protected int count;

  public Tacky(Angle a) {
    super(a);
    count = 4;
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
	  if (count <=0) System.out.println("Ragacs m�r nem �lek");
    return count > 0;
  }

  public String toString() {
    return "Tacky " + position + " " + count;
  }

  @Override
  public void interact(Worker worker) {
  }
}