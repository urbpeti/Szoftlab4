package Game;

import java.awt.Color;
import javax.jws.soap.SOAPBinding.Use;

import Setup.Log;
import Setup.UseCases;

public class Robot {
  private String name;
  private Color color;
  private Angle position;
  private Item itemCache;

  private double distance;
  private double velocity;
  private double delta;

  private boolean isDead;
  private boolean onOil;

  //Constructor
  public Robot(String name, Color color) {
    Log.enter();
    Log.write("[Create] Robot");

    this.name = name;
    this.color = color;

    Log.exit();
  }

  //Moving the Robot
  public void jump() {
    Log.enter();
    Log.write("[:Robot].jump()");
    Log.exit();
  }

  //Accelerating
  public void accelerate() {
    Log.enter();
    Log.write("[:Robot].accelerate()");
    Log.exit();
  }

  //Decelerating
  public void decelerate() {
    Log.enter();
    Log.write("[:Robot].decelerate()");
    Log.exit();
  }

  //Returns the robot's position in Angle
  public Angle getPosition() {
    Log.enter();
    Log.write("[:Robot].getPosition()");
    Log.exit();

    return position;
  }

  //Returns true if the robot is dead, false otherwise
  public boolean getIsDead() {
    Log.enter();
    Log.write("[:Robot].getIsDead()");
    Log.exit();

    return isDead;
  }

  //Sets the robot's isDead variable
  public void setIsDead(boolean isDead) {
    Log.enter();
    Log.write("[:Robot].setIsDead(isDead)");

    this.isDead = isDead;

    Log.exit();
  }

  //Halves the robot's speed
  public void halfSpeed() {
    if (UseCases.current.equals("stepGame")) return;

    Log.enter();
    Log.write("[:Robot].halfSpeed()");
    Log.exit();
  }

  //Returns what item the robot will place next
  public Item getItemCache() {
    Log.enter();
    Log.write("[:Robot].getItemCache()");
    
    Log.off();
    boolean isOilOrTacky = UseCases.current.equals("placeOil")
                        || UseCases.current.equals("placeTacky");
    Item itemCache = isOilOrTacky ? new Oil() : new Tacky();
    Log.on();
    
    Log.exit();

    return itemCache;
  }

  //Sets what item will the robot place next
  public void setItemCache(Item item) {
    Log.enter();
    Log.write("[:Robot].setItemCache(item)");

    this.itemCache = item;

    Log.exit();
  }

  //Returns if the robot is on oil or not
  public boolean getOnOil() {
    Log.enter();
    Log.write("[:Robot].getOnOil()");
    Log.exit();

    return onOil;
  }

  //Sets the robots onOil, meaning is the robot is currently standing on oil or not
  public void setOnOil(boolean onOil) {
    if (UseCases.current.equals("stepGame")) return;

    Log.enter();
    Log.write("[:Robot].setOnOil()");

    this.onOil = onOil;

    Log.exit();
  }

  //Returns the amount of distance the robot has travelled, from the starting of the game
  public int getDistance() {
    Log.enter();
    Log.write("[:Robot].getDistance()");
    Log.exit();

    return 0;
  }
}
