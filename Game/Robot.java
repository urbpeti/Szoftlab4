package Game;

import java.awt.Color;

public class Robot extends Creature {
  private String name;
  private Color color;
  private Item itemCache;
  private boolean onOil;

  // Constructor
  public Robot(String name, Color color, Angle pos, double v) {
    this.name = name;
    this.color = color;
    this.position = pos;
    this.velocity = v;
    this.delta = 0;
  }

  public void jump() {
    velocity += delta;
    delta = 0;
    distance += Math.abs(velocity);
    position.addAngle(velocity);
  }

  // Accelerating
  public void accelerate() {
    if (delta < 10)
      delta += 10;
  }

  // Decelerating
  public void decelerate() {
    if (delta > 10)
      delta -= 10;
  }

  // Halves the robot's speed
  public void halfSpeed() {
    double v = getVelocity();
    v /= 2;

    setVelocity(v);
  }

  // Returns what item the robot will place next
  public Item getItemCache() {
    return itemCache;
  }

  // Sets what item will the robot place next
  public void setItemCache(Item item) {
    this.itemCache = item;
  }

  // Returns if the robot is on oil or not
  public boolean getOnOil() {
    return onOil;
  }

  // Sets the robots onOil, meaning is the robot is currently standing on oil or
  // not
  public void setOnOil(boolean onOil) {
    this.onOil = onOil;
  }
  
  public boolean inRangeOf(Robot r) {
    double dist = getPosition().distance(r.getPosition());
    
    return dist < 0.5;
  }
  
  public String toString() {
    String s = getIsDead() ? "Dead" : "Alive";
    return name + " " + position + " " + s + " " + velocity;
  }
}
