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

  // Moving the Robot
  public void jump() {
    if (getIsDead())
      return;

    if (getOnOil())
      setOnOil(false);
    else
      velocity += delta;

    delta = 0;
    distance += Math.abs(velocity);
    position.addAngle(velocity);
  }

  // Accelerating
  public void accelerate() {
    if (delta < 10)
      delta += 1;
  }

  // Decelerating
  public void decelerate() {
    if (delta > -10)
      delta -= 1;
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

  public String getName() {
    return name;
  }

  public String toString() {
    String s = getIsDead() ? "Dead" : "Alive";
    String o = getOnOil() ? "Oily" : "Not Oily";
    return name + ", Position: " + position + ", Velocity: " + velocity +
    /* ", Delta: " + delta + */", " + o + ", " + s;
  }
  
  public boolean inRangeOf(Item i) {
	    double dist = getPosition().distance(i.position);

	    return dist < 3.5;
  }
  
  public Color getColor(){
	  return color;
  }
}
