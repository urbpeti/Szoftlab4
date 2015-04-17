package Game;

public class Worker extends Creature {
  private int cleaningTime;

  public Worker(Angle pos) {
    position = pos;
  }

  public void jump() {

  }

  public int getCleaningTime() {
    return cleaningTime;
  }

  public void setCleaningTime(int time) {
    cleaningTime = time;
  }
}
