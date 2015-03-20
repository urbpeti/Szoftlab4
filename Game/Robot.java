package Game;

import java.awt.Color;
import Setup.Log;

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
	
	public Robot (String name, Color color) {
	  Log.enter();
	  
		Log.write("[Create] Robot");
		
		this.name = name;
		this.color = color;
		
		Log.exit();
	}

	public void jump () {
		Log.write("[:Robot].jump()");
	}

	public void accelerate () {
		Log.write("[:Robot].accelerate()");
	}

	public void decelerate () {
		Log.write("[:Robot].decelerate()");
	}

	public Angle getPosition () {
		Log.write("[:Robot].getPosition()");
		return position;
	}

	public boolean getIsDead () {
	  Log.enter();
		
	  Log.write("[:Robot].getIsDead()");
	  
	  Log.exit();
		return isDead;
	}

	public void setIsDead (boolean isDead) {
		Log.write("[:Robot].setIsDead()");
		this.isDead = isDead;
	}

	public void halfSpeed () {
		Log.write("[:Robot].halfSpeed()");
	}

	public Item getItemCache () {
		Log.write("[:Robot].getItemCache()");
		return itemCache;
	}

	public void setItemCache (Item itemCache) {
		Log.write("[:Robot].setItemCache");
		this.itemCache = itemCache;
	}

	public boolean getOnOil () {
		Log.write("[:Robot].getOnOil()");
		return onOil;
	}

	public void setOnOil (boolean onOil) {
		Log.write("[:Robot].setOnOil()");
		this.onOil = onOil;
	}
	
	public int getDistance () {
	  Log.enter();
    
	  Log.write("[:Robot].getDistance()");
    
    Log.exit();
    return 0;
  }
}
