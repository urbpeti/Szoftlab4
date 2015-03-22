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

	public Robot(String name, Color color) {
		Log.enter();
		Log.write("[Create] Robot");

		this.name = name;
		this.color = color;

		Log.exit();
	}

	public void jump() {
		Log.enter();
		Log.write("[:Robot].jump()");
		Log.exit();
	}

	public void accelerate() {
		Log.enter();
		Log.write("[:Robot].accelerate()");
		Log.exit();
	}

	public void decelerate() {
		Log.enter();
		Log.write("[:Robot].decelerate()");
		Log.exit();
	}

	public Angle getPosition() {
		Log.enter();
		Log.write("[:Robot].getPosition()");
		Log.exit();
		return position;
	}

	public boolean getIsDead() {
		Log.enter();
		Log.write("[:Robot].getIsDead()");
		Log.exit();
		return isDead;
	}

	public void setIsDead(boolean isDead) {
		Log.enter();
		Log.write("[:Robot].setIsDead(isDead)");

		this.isDead = isDead;

		Log.exit();
	}

	public void halfSpeed() {
		if (UseCases.current.equals("stepGame"))
			return;

		Log.enter();
		Log.write("[:Robot].halfSpeed()");
		Log.exit();
	}

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

	public void setItemCache(Item item) {
		Log.enter();
		Log.write("[:Robot].setItemCache(item)");

		this.itemCache = item;

		Log.exit();
	}

	public boolean getOnOil() {
		Log.enter();
		Log.write("[:Robot].getOnOil()");
		Log.exit();
		return onOil;
	}

	public void setOnOil(boolean onOil) {
		if (UseCases.current.equals("stepGame"))
			return;

		Log.enter();
		Log.write("[:Robot].setOnOil()");

		this.onOil = onOil;

		Log.exit();
	}

	public int getDistance() {
		Log.enter();
		Log.write("[:Robot].getDistance()");
		Log.exit();
		return 0;
	}
}
