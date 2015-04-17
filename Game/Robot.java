package Game;

import java.awt.Color;

public class Robot extends Creature {
  private String name;
  private Color color;
  private Item itemCache;
  private boolean onOil;

  // Constructor
  public Robot(String name, Color color) {
    this.name = name;
    this.color = color;
  }

  public void jump() {

  }

  // Accelerating
  public void accelerate() {

  }

  // Decelerating
  public void decelerate() {

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
}
